package com.miracle.extra.domain;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude
import com.miracle.common.annotation.Excel;
import com.miracle.common.core.domain.BaseEntity
import java.math.BigDecimal
import java.util.Date

/**
 * 车间转序对象 mes_workshop_transpose
 *
 * @author miracle
 * @date 2025-12-17
 */
data class MesWorkshopTranspose
(
    private val serialVersionUID : Long = 1L,

    /** 主键ID */
    var id: Long? = null,

    /** 雪花ID（业务唯一标识） */
    @Excel(name = "雪花ID", readConverterExp = "业=务唯一标识")
    var snowflakeId: String? = null,

    /** 物料编码 */
    @Excel(name = "物料编码")
    var materialCode: String? = null,

    /** 转出车间 */
    @Excel(name = "转出车间")
    var fromWorkshop: String? = null,

    /** 转入车间 */
    @Excel(name = "转入车间")
    var toWorkshop: String? = null,

    /** 转序数量 */
    @Excel(name = "转序数量")
    var transferQuantity: BigDecimal? = null,

    /** 转序时间 */
    @field:JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Excel(name = "转序时间", width = 30.0, dateFormat = "yyyy-MM-dd HH:mm:ss")
    var  transferTime: Date? = null,

    /** 转序开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    var transferStartTime: Date? = null,

    /** 转序结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    var transferEndTime: Date? = null,

    /** 转序人员 */
    @Excel(name = "转序人员")
    var transferPerson: String? = null,

    /** 确认时间 */
    @field:JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Excel(name = "确认时间", width = 30.0, dateFormat = "yyyy-MM-dd HH:mm:ss")
    var confirmTime: Date? = null,

    /** 确认开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    var confirmStartTime: Date? = null,

    /** 确认结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    var confirmEndTime: Date? = null,

    /** 收料人员 */
    @Excel(name = "收料人员")
    var receiverPerson: String? = null,

    /** 是否转序（N否 Y是） */
    //@field:JsonInclude(JsonInclude.Include.ALWAYS)
    @Excel(name = "是否转序", readConverterExp = "N=否,Y=是")
    var ifTransferred: String? = null,

    /** 是否确认（N否 Y是） */
    //@field:JsonInclude(JsonInclude.Include.ALWAYS)
    @Excel(name = "是否确认", readConverterExp = "N=否,Y=是")
    var ifConfirmed: String? = null,

) : BaseEntity()
