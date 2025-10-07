package com.miracle.extra.domain;

import com.miracle.common.core.domain.BaseEntity;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.miracle.common.annotation.Excel;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 检验数据对象 mes_inspection_record
 * 
 * @author miracle
 * @date 2025-09-24
 */
@Data
public class InspectionRecordMES extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 序列号 */
    @Excel(name = "序列号")
    private String serialNumber;

    /** 结果1 */
    @Excel(name = "结果1")
    private String result1;

    /** 结果2 */
    @Excel(name = "结果2")
    private String result2;

    /** 结果3 */
    @Excel(name = "结果3")
    private String result3;

    /** 外观检验 */
    @Excel(name = "外观检验")
    private String appearanceInspection;

    /** 工序一创建人 */
    @Excel(name = "工序一创建人")
    private String createBy1;

    /** 工序一创建时间 */
    @Excel(name = "工序一创建时间")
    private Date createTime1;

    /** 工序二创建人 */
    @Excel(name = "工序二创建人")
    private String createBy2;

    /** 工序二创建时间 */
    @Excel(name = "工序二创建时间")
    private Date createTime2;

    /** 工序三创建人 */
    @Excel(name = "工序三创建人")
    private String createBy3;

    /** 工序三创建时间 */
    @Excel(name = "工序三创建时间")
    private Date createTime3;

    /** 箱码 */
    @Excel(name = "箱码")
    private String boxCode;

    /** 客户箱码 */
    @Excel(name = "客户箱码")
    private String customerBoxCode;

    @Data
    /** 箱码绑定请求 */
    public static class BoxBindRequest {
        private String[] serialNumbers;
        private String boxCode;
    }

    @Data
    /** 客户箱码绑定请求 */
    public static class CustomerBoxBindRequest {
        private String boxCode;
        private String customerBoxCode;
    }

}
