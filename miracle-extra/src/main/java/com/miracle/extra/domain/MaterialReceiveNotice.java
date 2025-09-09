package com.miracle.extra.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.miracle.common.core.domain.BaseEntity;
import lombok.Data;

import com.miracle.common.annotation.Excel;

/**
 * 收料通知单对象 material_receive_notice
 * 
 * @author miracle
 * @date 2025-09-03
 */
@Data
public class MaterialReceiveNotice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 明细ID */
    private Long fentryId;

    /** 收料通知单号 */
    @Excel(name = "收料通知单号")
    private String billNo;

    /** 收料日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "收料日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date receiveDate;

    /** 收料组织 */
    @Excel(name = "收料组织")
    private String receiveOrg;

    /** 采购组织 */
    @Excel(name = "采购组织")
    private String purchaseOrg;

    /** 供应商名称 */
    @Excel(name = "供应商名称")
    private String supplierName;

    /** 物料编码 */
    @Excel(name = "物料编码")
    private String materialNo;

    /** 物料名称 */
    @Excel(name = "物料名称")
    private String materialName;

    /** 交货数量 */
    @Excel(name = "交货数量")
    private BigDecimal receiveQty;

    /** 规格型号 */
    @Excel(name = "规格型号")
    private String materialSpe;

    /** 批号 */
    @Excel(name = "批号")
    private String flot;

    /** 物料说明 */
    @Excel(name = "物料说明")
    private String materialDesc;

    /** 委外物料编码 */
    @Excel(name = "委外物料编码")
    private String materialNoWw;


}
