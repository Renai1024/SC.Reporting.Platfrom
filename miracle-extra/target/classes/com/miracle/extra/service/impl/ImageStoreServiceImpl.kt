package com.miracle.extra.service.impl;

import com.miracle.common.utils.SecurityUtils;
import com.miracle.common.utils.uuid.IdUtils;
import com.miracle.extra.config.MinioConfig;
import com.miracle.extra.domain.ImageStore;
import com.miracle.extra.mapper.ImageStoreMapper;
import com.miracle.extra.service.IImageStoreService;
import io.minio.*;
import io.minio.http.Method;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 图片存储 Service 实现类
 *
 * @author miracle
 */
@Service
class ImageStoreServiceImpl(
    private val imageStoreMapper: ImageStoreMapper,
    private val minioClient: MinioClient,
    private val minioConfig: MinioConfig,
) : IImageStoreService {


    val IMAGE_DIR:  String = "images/";


    override fun uploadImage(file: MultipartFile): ImageStore {
        val createBy : String = SecurityUtils.getLoginUser().user.nickName

        // 检查存储桶是否存在，不存在则创建
        val found: Boolean = minioClient.bucketExists(BucketExistsArgs.builder()
                .bucket(minioConfig.bucketName)
                .build());
        if (!found) {
            minioClient.makeBucket(MakeBucketArgs.builder()
                    .bucket(minioConfig.bucketName)
                    .build());
        }


        // 生成唯一的图片名称
        val originalFilename: String = file.originalFilename!!
        val fileExtension: String = originalFilename.substring(originalFilename.lastIndexOf("."))
        val imageName : String = IdUtils.fastUUID() + fileExtension;
        val objectName:  String = IMAGE_DIR + imageName;

        val contentType = file.contentType ?: "application/octet-stream"

        // 上传图片到 MinIO
        minioClient.putObject(PutObjectArgs.builder()
                .bucket(minioConfig.bucketName)
                .`object`(objectName)
                .stream(file.inputStream, file.size, -1)
                .contentType(contentType)
                .build());

        // 构建图片 URL
        val imageUrl: String = minioConfig.endpoint + "/" + minioConfig.bucketName + "/" + objectName;

        // 保存图片信息到数据库
        val imageStore: ImageStore = ImageStore().apply {
            this.imageName = imageName
            this.originalName = originalFilename
            this.imagePath = objectName
            this.imageUrl = imageUrl
            this.imageSize = file.size
            this.imageType = contentType
            this.bucketName = minioConfig.bucketName
            this.status = 0
            this.createBy = createBy
            this.createTime = Date()
        }

        imageStoreMapper.insertImageStore(imageStore);
        return imageStore;
    }

    @Throws(Exception::class)
    override fun downloadImage(imageId:  Long): InputStream {
        val imageStore : ImageStore? = imageStoreMapper.selectImageStoreById(imageId);
        if (imageStore == null) {
            throw  Exception("图片不存在")
        }

        return minioClient.getObject(GetObjectArgs.builder()
                .bucket(imageStore.bucketName!!)
                .`object`(imageStore.imagePath)
                .build())
    }

    @Throws(Exception::class)
    override fun getImagePreviewUrl(imageId: Long) : String {
        val imageStore: ImageStore? = imageStoreMapper.selectImageStoreById(imageId);
        if (imageStore == null) {
            throw Exception("图片不存在");
        }

        // 生成带签名的临时 URL，有效期为 7 天
        return minioClient.getPresignedObjectUrl(GetPresignedObjectUrlArgs.builder()
                .method(Method.GET)
                .bucket(imageStore.bucketName)
                .`object`(imageStore.imagePath)
                .expiry(7, TimeUnit.DAYS)
                .build())
    }

    @Throws(Exception::class)
    override fun deleteImage(imageId: Long) : Boolean {
        val imageStore: ImageStore? = imageStoreMapper.selectImageStoreById(imageId)
        if (imageStore == null) {
            throw Exception("图片不存在");
        }

        // 从 MinIO 删除图片
        minioClient.removeObject(RemoveObjectArgs.builder()
                .bucket(imageStore.bucketName!!)
                .`object`(imageStore.imagePath!!)
                .build());

        // 从数据库删除图片信息
        val result : Int= imageStoreMapper.deleteImageStoreById(imageId);
        return result > 0;
    }

    override fun selectImageStoreList(imageStore: ImageStore): List<ImageStore> =
        imageStoreMapper.selectImageStoreList(imageStore)

    override fun insertImageStore(imageStore: ImageStore): Int =
        imageStoreMapper.insertImageStore(imageStore);


    override fun updateImageStore(imageStore: ImageStore): Int {
        imageStore.updateTime = Date()
        imageStore.updateBy = SecurityUtils.getLoginUser().user.nickName;
        return imageStoreMapper.updateImageStore(imageStore);
    }

    @Throws(Exception::class)
    override fun deleteImageStoreByIds( imageIds : Array<Long>) : Int {
        var result = 0;
        for (imageId in imageIds) {
            if (deleteImage(imageId)) {
                result++;
            }
        }
        return result;
    }

    override fun selectImageStoreById(imageId:  Long): ImageStore {
        return imageStoreMapper.selectImageStoreById(imageId);
    }

    override fun selectImageStoreByPath(imagePath:  String) : ImageStore {
        return imageStoreMapper.selectImageStoreByPath(imagePath);
    }

//    override fun confirmImage(imageId: Long): Int {
//        val imageStore: ImageStore? = imageStoreMapper.selectImageStoreById(imageId);
//        if (imageStore == null) {
//            throw Exception("图片不存在");
//        }
//        imageStore.status = 0
//        imageStore.updateTime = Date();
//        imageStore.updateBy = SecurityUtils.getLoginUser().user.nickName;
//        return imageStoreMapper.updateImageStore(imageStore)
//    }
}