package com.miracle.extra.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.miracle.common.annotation.Excel;
import com.miracle.common.core.domain.BaseEntity
import java.util.Date

/**
 * 气密性测试记录对象 mes_qimixing_record
 *
 * @author miracle
 * @date 2025-12-04
 */
data class MesQimixingRecord (

    /** 测试时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "测试时间", width = 30.0, dateFormat = "yyyy-MM-dd HH:mm:ss")
    var  datatime: Date? = null,

    /** 测试开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    var startTime: Date? = null,

    /** 测试结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    var endTime: Date? = null,

    /** 测试结果 */
    @Excel(name = "测试结果")
    var workresult: String? = null,

    /** 通道 */
    @Excel(name = "通道")
    var tongdao: String? = null,

    /** 条码 */
    @Excel(name = "条码")
    var tiaoma: String? = null,

    /** 平衡上限 */
    @Excel(name = "平衡上限")
    var pinghengshangxian: String? = null,

    /** 平衡下限 */
    @Excel(name = "平衡下限")
    var pinghengxiaxian: String? = null,

    /** 测量上限 */
    @Excel(name = "测量上限")
    var celiangshangxian: String? = null,

    /** 测量下限 */
    @Excel(name = "测量下限")
    var celiangxiaxian: String? = null,

    /** 泄漏值 */
    @Excel(name = "泄漏值")
    var xieluozhi: String? = null,

    /** 压力值 */
    @Excel(name = "压力值")
    var yalizhi: String? = null,

    /** 单位 */
    @Excel(name = "单位")
    var danwei: String? = null,

    /** 延迟时间 */
    @Excel(name = "延迟时间")
    var yanchitime: String? = null,

    /** 充气时间 */
    @Excel(name = "充气时间")
    var chongqitime: String? = null,

    /** 平衡时间 */
    @Excel(name = "平衡时间")
    var pinghengtime: String? = null,

    /** 测量时间 */
    @Excel(name = "测量时间")
    var celiangtime: String? = null,

    /** 排气时间 */
    @Excel(name = "排气时间")
    var paiqitime: String? = null,

): BaseEntity()
