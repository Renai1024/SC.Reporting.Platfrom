package com.miracle.extra.controller;

import com.miracle.common.core.controller.BaseController;
import com.miracle.common.core.domain.AjaxResult;
import com.miracle.common.core.page.TableDataInfo;
import com.miracle.extra.domain.ImageStore;
import com.miracle.extra.service.IImageStoreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.net.URLEncoder;

/**
 * 图片存储控制器
 *
 * @author miracle
 */
@Tag(name = "图片存储管理", description = "图片上传、下载、预览等操作")
@RestController
@RequestMapping("/extra/image")
open class ImageStoreController(
    private val imageStoreService: IImageStoreService
) : BaseController() {


    /**
     * 上传图片
     */
    @Operation(summary = "上传图片", description = "上传图片到 MinIO 并保存图片信息到数据库")
    @PostMapping("/upload")
    open fun uploadImage(@RequestParam("file")  file : MultipartFile) : AjaxResult {
        return try {
            if(file.isEmpty) {
                AjaxResult.error("上传文件不能为空")
            } else {
                val imageStore : ImageStore = imageStoreService.uploadImage(file);
                AjaxResult.success("上传成功", imageStore)
            }
        }catch (e: Exception) {
            AjaxResult.error("上传失败：" + e.message)
        }
    }

    /**
     * 下载图片
     */
    @Operation(summary = "下载图片", description = "根据图片ID下载图片")
    @GetMapping("/download/{imageId}")
    open fun downloadImage(@PathVariable("imageId") imageId : Long) : ResponseEntity<InputStreamResource>{
        try {
            val imageStore : ImageStore? = imageStoreService.selectImageStoreById(imageId)
            if (imageStore == null) {
                return ResponseEntity.notFound().build()
            }

            val inputStream : InputStream = imageStoreService.downloadImage(imageId)
            val headers : HttpHeaders = HttpHeaders()
            headers.add("Content-Disposition", "attachment; filename=" + URLEncoder.encode(imageStore.originalName,"UTF-8"));

            return ResponseEntity.ok()
                    .headers(headers)
                    .contentType(MediaType.parseMediaType(imageStore.imageType ?: "application/octet-stream"))
                    .body(InputStreamResource(inputStream));
        } catch (e : Exception) {
            return ResponseEntity.badRequest().build()
        }
    }

    /**
     * 获取图片预览URL
     */
    @Operation(summary = "获取图片预览URL", description = "根据图片ID获取图片预览URL")
    @GetMapping("/preview/{imageId}")
    open fun getImagePreviewUrl(@PathVariable("imageId") imageId : Long) : AjaxResult{
        return try {
            val previewUrl : String = imageStoreService.getImagePreviewUrl(imageId)
            AjaxResult.success("获取预览URL成功", previewUrl)
        } catch (e : Exception) {
            AjaxResult.error("获取预览URL失败：" + e.message)
        }
    }

    /**
     * 删除图片
     */
    @Operation(summary = "删除图片", description = "根据图片ID删除图片")
    @DeleteMapping("/{imageId}")
    open fun deleteImage(@PathVariable("imageId") imageId : Long) : AjaxResult{
        return try {
            val result : Boolean = imageStoreService.deleteImage(imageId);
            if (result) {
                AjaxResult.success("删除成功");
            } else {
                AjaxResult.error("删除失败");
            }
        } catch (e : Exception) {
            return AjaxResult.error("删除失败：" + e.message);
        }
    }

    /**
     * 查询图片存储列表
     */
    @Operation(summary = "查询图片存储列表", description = "查询图片存储列表")
    @GetMapping("/list")
    @Throws(Exception::class)
    open fun list(imageStore : ImageStore) : TableDataInfo {
        val list : List<ImageStore> = imageStoreService.selectImageStoreList(imageStore)
        return getDataTable(list);
    }

    /**
     * 新增图片存储
     */
    @Operation(summary = "新增图片存储", description = "新增图片存储")
    @PostMapping
    open fun add(@RequestBody imageStore : ImageStore) : AjaxResult {
        val rows :  Int = imageStoreService.insertImageStore(imageStore);
        if (rows > 0) {
            return AjaxResult.success("新增成功");
        }
        return AjaxResult.error("新增失败");
    }

    /**
     * 修改图片存储
     */
    @Operation(summary = "修改图片存储", description = "修改图片存储")
    @PutMapping
    open fun edit(@RequestBody imageStore: ImageStore) : AjaxResult{
        val rows : Int = imageStoreService.updateImageStore(imageStore);
        if (rows > 0) {
            return AjaxResult.success("修改成功");
        }
        return AjaxResult.error("修改失败");
    }

    /**
     * 批量删除图片存储
     */
    @Operation(summary = "批量删除图片存储", description = "批量删除图片存储")
    @DeleteMapping("/batch")
    open fun remove(@RequestBody imageIds : Array<Long>) : AjaxResult{
        try {
            val rows : Int = imageStoreService.deleteImageStoreByIds(imageIds);
            if (rows > 0) {
                return AjaxResult.success("删除成功");
            }
            return AjaxResult.error("删除失败");
        } catch (e : Exception) {
            return AjaxResult.error("删除失败：" + e.message);
        }
    }

    /**
     * 根据图片ID查询图片存储
     */
    @Operation(summary = "根据图片ID查询图片存储", description = "根据图片ID查询图片存储")
    @GetMapping("/{imageId}")
    open fun getInfo(@PathVariable("imageId") imageId : Long) : AjaxResult{
        return AjaxResult.success(imageStoreService.selectImageStoreById(imageId));
    }

//    @PutMapping("/confirm/{imageId}")
//    open fun confirm(@PathVariable("imageId") imageId : Long) : AjaxResult{
//        return try {
//            val imageStore : ImageStore? = imageStoreService.selectImageStoreById(imageId)
//            if (imageStore == null) {
//                return AjaxResult.error("图片不存在");
//            }
//            val result : Int = imageStoreService.confirmImage(imageId)
//            if(result == 1) {
//                AjaxResult.success("确认成功");
//            } else {
//                AjaxResult.error("确认失败");
//            }
//        } catch (e : Exception){
//            return AjaxResult.error("确认失败：${e.message}")
//        }
//    }
}