package com.miracle.extra.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.miracle.common.core.domain.BaseEntity;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.miracle.common.annotation.Excel;

/**
 * 气密性测试记录对象 mes_qimixing_record
 *
 * @author miracle
 * @date 2025-12-04
 */
@Data
public class MesQimixingRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 测试时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "测试时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date datatime;

    /** 测试开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startTime;

    /** 测试结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endTime;

    /** 测试结果 */
    @Excel(name = "测试结果")
    private String workresult;

    /** 通道 */
    @Excel(name = "通道")
    private String tongdao;

    /** 条码 */
    @Excel(name = "条码")
    private String tiaoma;

    /** 平衡上限 */
    @Excel(name = "平衡上限")
    private String pinghengshangxian;

    /** 平衡下限 */
    @Excel(name = "平衡下限")
    private String pinghengxiaxian;

    /** 测量上限 */
    @Excel(name = "测量上限")
    private String celiangshangxian;

    /** 测量下限 */
    @Excel(name = "测量下限")
    private String celiangxiaxian;

    /** 泄漏值 */
    @Excel(name = "泄漏值")
    private String xieluozhi;

    /** 压力值 */
    @Excel(name = "压力值")
    private String yalizhi;

    /** 单位 */
    @Excel(name = "单位")
    private String danwei;

    /** 延迟时间 */
    @Excel(name = "延迟时间")
    private String yanchitime;

    /** 充气时间 */
    @Excel(name = "充气时间")
    private String chongqitime;

    /** 平衡时间 */
    @Excel(name = "平衡时间")
    private String pinghengtime;

    /** 测量时间 */
    @Excel(name = "测量时间")
    private String celiangtime;

    /** 排气时间 */
    @Excel(name = "排气时间")
    private String paiqitime;


}
