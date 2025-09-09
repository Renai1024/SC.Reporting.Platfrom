package com.miracle.extra.domain;

import com.miracle.common.core.domain.BaseEntity;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.miracle.common.annotation.Excel;

/**
 * 物料信息对象 material_info
 * 
 * @author miracle
 * @date 2025-07-27
 */
@Data
public class MaterialInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 物料ID */
    private String materialId;

    /** 物料编码 */
    @Excel(name = "物料编码")
    private String materialNum;

    /** 物料名称 */
    @Excel(name = "物料名称")
    private String materialName;

    /** 使用组织 */
    @Excel(name = "使用组织", dictType = "sys_erp_organization")
    private String useOrg;

    /** 物料描述 */
    @Excel(name = "物料描述")
    private String materialDesc;

    /** 规格型号 */
    @Excel(name = "规格型号")
    private String materialSpecification;

    /** 顺科产品类型 */
    @Excel(name = "顺科产品类型")
    private String materialType;

    /** 事业部 */
    @Excel(name = "事业部")
    private String materialSyb;

    /** 行业 */
    @Excel(name = "行业")
    private String materialHy;

    /** 物料属性 */
    @Excel(name = "物料属性")
    private String materialProperty;

    /** 物料分组 */
    @Excel(name = "物料分组")
    private String materialGroup;

    /** 存货类别 */
    @Excel(name = "存货类别")
    private String materialInventoryType;

    /** 基本单位 */
    @Excel(name = "基本单位")
    private String materialUnit;

    /** 数据状态 */
    @Excel(name = "数据状态", dictType = "sys_document_status")
    private String dataStatus;

    /** 禁用状态 */
    @Excel(name = "禁用状态", dictType = "sys_forbidden_status")
    private String forbiddenStatus;


}
