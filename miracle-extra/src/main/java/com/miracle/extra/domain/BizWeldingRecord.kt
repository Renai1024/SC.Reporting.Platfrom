package com.miracle.extra.domain;
import com.fasterxml.jackson.annotation.JsonFormat
import com.miracle.common.core.domain.BaseEntity;


import com.miracle.common.annotation.Excel;
import java.util.Date

/**
 * 焊接结果记录对象 biz_welding_record
 *
 * @author miracle
 * @date 2025-10-30
 */

data class BizWeldingRecord (

    private val serialVersionUID :Long = 1L,

    /** 主键ID */
    var id: Long? = null,

    /** 产品码 */
    @Excel(name = "产品码")
    var productCode: String? = null,

    /** 焊接时间 */
    @field:JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Excel(name = "焊接时间", width = 30.0, dateFormat = "yyyy-MM-dd HH:mm:ss ")
    var weldingTime: Date? = null,

    /** 焊接结果 */
    @Excel(name = "焊接结果")
    var weldingResult: String? = null,

): BaseEntity()
