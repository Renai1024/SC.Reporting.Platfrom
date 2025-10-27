package com.miracle.extra.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.miracle.common.core.domain.BaseEntity;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.miracle.common.annotation.Excel;

/**
 * 碳化硅自动锁螺丝数据对象 prod_screw_torque
 * 
 * @author miracle
 * @date 2025-10-24
 */
@Data
public class ProdScrewTorque extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 产品二维码数据 */
    @Excel(name = "产品二维码数据")
    private String qrCode;

    /** 产品螺丝序号 */
    @Excel(name = "产品螺丝序号")
    private String screwIndex;

    /** 锁附时间 */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Excel(name = "锁附时间", width = 30, dateFormat = "yyyy-MM-dd hh:mm:ss")
    private Date lockTime;

    /** 目标扭矩 */
    @Excel(name = "目标扭矩")
    private String targetTorque;

    /** 实际锁附扭矩 */
    @Excel(name = "实际锁附扭矩")
    private String actualTorque;

    /** 锁附圈数(r) */
    @Excel(name = "锁附圈数(r)")
    private String lockCircle;

    /** 锁附时长(s) */
    @Excel(name = "锁附时长(s)")
    private String lockDuration;

    /** 锁附结果 */
    @Excel(name = "锁附结果")
    private String lockResult;

}
