package com.miracle.extra.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.miracle.common.core.domain.BaseEntity;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.miracle.common.annotation.Excel;

/**
 * bydlabelprint对象 mes_bydlabelprint
 *
 * @author miracle
 * @date 2025-11-20
 */

@Data
public class MesBydlabelprint extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 物料号 */
    @Excel(name = "物料号")
    private String materialCode;

    /** 版本号 */
    @Excel(name = "版本号")
    private String materialVersion;

    /** 客户编号 */
    @Excel(name = "客户编号")
    private String customerCode;

    /** 电镀标识 */
    @Excel(name = "电镀标识")
    private String dDFactoryFlag;

    /** 条码 */
    @Excel(name = "条码")
    private String barCodeStr;

    /** 标签流水号 */
    @Excel(name = "标签流水号")
    private Long labelNumber;

    /** 标签日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "标签日期", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date manufactureDate;

    /** 打印时间点 */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Excel(name = "打印时间点", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date labelPrintDateTime;

    /** 打印开始时间**/
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date printStartTime;

    /** 打印结束时间**/
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date printEndTime;

    /** 标签开始时间**/
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date labelStartTime;

    /** 标签结束时间**/
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date labelEndTime;

}
