package com.miracle.extra.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.miracle.common.core.domain.BaseEntity;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.miracle.common.annotation.Excel;

/**
 * 车间转序对象 mes_workshop_transpose
 *
 * @author miracle
 * @date 2025-12-17
 */
@Data
public class MesWorkshopTranspose extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 雪花ID（业务唯一标识） */
    @Excel(name = "雪花ID", readConverterExp = "业=务唯一标识")
    private String snowflakeId;

    /** 物料编码 */
    @Excel(name = "物料编码")
    private String materialCode;

    /** 转出车间 */
    @Excel(name = "转出车间")
    private String fromWorkshop;

    /** 转入车间 */
    @Excel(name = "转入车间")
    private String toWorkshop;

    /** 转序数量 */
    @Excel(name = "转序数量")
    private BigDecimal transferQuantity;

    /** 转序时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "转序时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date transferTime;

    /** 转序开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date transferStartTime;

    /** 转序结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date transferEndTime;

    /** 转序人员 */
    @Excel(name = "转序人员")
    private String transferPerson;

    /** 确认时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "确认时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date confirmTime;

    /** 确认开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date confirmStartTime;

    /** 确认结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date confirmEndTime;

    /** 收料人员 */
    @Excel(name = "收料人员")
    private String receiverPerson;

    /** 是否转序（N否 Y是） */
    @Excel(name = "是否转序", readConverterExp = "N=否,Y=是")
    private String isTransferred;

    /** 是否确认（N否 Y是） */
    @Excel(name = "是否确认", readConverterExp = "N=否,Y=是")
    private String isConfirmed;



}
