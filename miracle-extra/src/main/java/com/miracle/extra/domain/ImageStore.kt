package com.miracle.extra.domain;

import com.miracle.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 图片存储实体
 *
 * @author miracle
 */
@Data
@EqualsAndHashCode(callSuper = true)
data class ImageStore(

    var serialVersionUID: Long = 1L,

    /** 图片ID **/
    var imageId: Long? = null,

    /** 图片名称 **/
    var imageName: String? = null,

    /** 图片原始名称 **/
    var originalName: String? = null,

    /** 图片存储路径 **/
    var imagePath: String? = null,

    /** 图片url **/
    var imageUrl: String? = null,

    /** 图片大小(字节) **/
    var imageSize: Long? = null,

    /** 图片类型 **/
    var imageType: String? = null,

    /** 存储桶名称 **/
    var bucketName: String? = null,

    /** 图片状态（0：正常，1：删除）**/
    var status: Int? = null,

) : BaseEntity(), Serializable