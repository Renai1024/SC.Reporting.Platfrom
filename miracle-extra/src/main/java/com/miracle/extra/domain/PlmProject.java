package com.miracle.extra.domain;

import java.time.LocalDateTime;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.miracle.common.core.domain.BaseEntity;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.miracle.common.annotation.Excel;

/**
 * PLM项目对象 plm_project
 *
 * @author miracle
 * @date 2025-09-10
 */
@Data
public class PlmProject extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 项目编码 */
    @Excel(name = "项目编码")
    private String projectNumber;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String projectName;

    /** 事业部 */
    @Excel(name = "事业部")
    private String businessDivision;

    /** 计划开始时间 */
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm")
    @Excel(name = "计划开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private LocalDateTime projectPlanStartTime;

    /** 实际开始时间 */
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm")
    @Excel(name = "实际开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private LocalDateTime projectActualStartTime;

    /** 实际结束时间 */
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm")
    @Excel(name = "实际结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private LocalDateTime projectActualEndTime;

    /** 项目状态 */
    @Excel(name = "项目状态")
    private String projectState;

    /** 项目经理 */
    @Excel(name = "项目经理")
    private String projectManager;

    /** 项目计划达成率 */
    @Excel(name = "项目计划达成率")
    private String projectCompletedOnScheduleCount;

    /** 项目标记 */
    @Excel(name = "项目标记")
    private String projectMark;


}
