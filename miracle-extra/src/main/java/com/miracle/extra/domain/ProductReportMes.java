package com.miracle.extra.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.miracle.common.core.domain.BaseEntity;
import lombok.Data;
import com.miracle.common.annotation.Excel;

/**
 * MES生产数据对象 product_report_mes
 * 
 * @author miracle
 * @date 2025-07-31
 */
@Data
public class ProductReportMes extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 物料编号 */
    @Excel(name = "物料编号")
    private String materialNo;

    /** 旧料号 */
    @Excel(name = "旧料号")
    private String oldMaterialNo;

    /** 订单号 */
    @Excel(name = "订单号")
    private String orderNo;

    /** 信息1 */
    @Excel(name = "信息1")
    private String info1;

    /** 信息2 */
    @Excel(name = "信息2")
    private String info2;

    /** 信息3 */
    @Excel(name = "信息3")
    private String info3;

    /** 信息4 */
    @Excel(name = "信息4")
    private String info4;

    /** 信息5 */
    @Excel(name = "信息5")
    private String info5;

    /** 信息6 */
    @Excel(name = "信息6")
    private String info6;

    /** 条码 */
    @Excel(name = "批号")
    private String barcode;

    /** 测试开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Excel(name = "测试开始时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date testStartTime;

    /** 测试结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Excel(name = "测试结束时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date testEndTime;

    /** 测试结果 */
    @Excel(name = "测试结果")
    private String testResult;

    /** 报文转义 */
    @Excel(name = "报文转义")
    private String messageEscape;

    /** 测试状态 */
    @Excel(name = "测试状态")
    private String testStatus;

    /** 客户端IP */
    @Excel(name = "客户端IP")
    private String clientIp;

    /** 产品类型 */
    @Excel(name = "产品类型")
    private String productType;

    /** 客户标识 */
    @Excel(name = "客户标识")
    private String customerFlag;

}
