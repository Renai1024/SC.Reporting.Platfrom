package com.miracle.extra.domain

import com.fasterxml.jackson.annotation.JsonFormat
import com.miracle.common.annotation.Excel
import com.miracle.common.core.domain.BaseEntity
import java.util.*

/**
 * 端子压接机数据对象 mes_report_duanziyajieji
 *
 * @author miracle
 * @date 2025-12-22
 */
data class MesReportDuanziyajieji(

    private val serialVersionUID: Long = 1L,
    /** 主键ID  */
    var id: Long? = null,

    /** 测试时间  */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "测试时间", width = 30.0, dateFormat = "yyyy-MM-dd HH:mm:ss")
    var datatime: Date? = null,

    /** 测试开始时间  */
    @JsonFormat(pattern = "yyyy-MM-dd")
    var testStartTime: Date? = null,

    /** 测试结束时间  */
    @JsonFormat(pattern = "yyyy-MM-dd")
    var testEndTime: Date? = null,

    /** 测试结果  */
    @Excel(name = "测试结果")
    var workresult: String? = null,

    /** 产量序号  */
    @Excel(name = "产量序号")
    var chanliangxuhao: String? = null,

    /** 线缆规格  */
    @Excel(name = "线缆规格")
    var xianlanguige: String? = null,

    /** 生产模式  */
    @Excel(name = "生产模式")
    var shengchanmoshi: String? = null,

    /** 二维码  */
    @Excel(name = "二维码")
    var tiaoma: String? = null,

    /** 焊头编号  */
    @Excel(name = "焊头编号")
    var hantoubianhao: String? = null,

    /** 焊接时间  */
    @Excel(name = "焊接时间")
    var hanjieshijian: String? = null,

    /** 触发高度  */
    @Excel(name = "触发高度")
    var chufagaodu: String? = null,

    /** 成形高度  */
    @Excel(name = "成形高度")
    var chengxinggaodu: String? = null,

    /** 压力  */
    @Excel(name = "压力")
    var yali: String? = null,

    /** 振幅  */
    @Excel(name = "振幅")
    var zhenfu: String? = null,

    /** 能量  */
    @Excel(name = "能量")
    var nengliang: String? = null,

    /** 频率  */
    @Excel(name = "频率")
    var pinlv: String? = null,

    /** 平均功率  */
    @Excel(name = "平均功率")
    var pingjungonglv: String? = null
) : BaseEntity()