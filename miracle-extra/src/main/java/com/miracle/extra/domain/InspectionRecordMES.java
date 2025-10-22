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
    @Excel(name = "17.5尺寸检验结果", dictType = "sys_test_result")
    private String result1;

    /** 结果2 */
    @Excel(name = "47.5尺寸检验结果", dictType = "sys_test_result")
    private String result2;

    /** 结果3 */
    @Excel(name = "610尺寸检验结果", dictType = "sys_test_result")
    private String result3;

    /** 外观检验 */
    @Excel(name = "外观检验结果", dictType = "sys_test_result")
    private String appearanceInspection;

    /** 工序一创建人 */
    //@Excel(name = "17.5/47.5尺寸检验人")
    private String createBy1;

    /** 工序一创建时间 */
    @Excel(name = "17.5/47.5尺寸检验时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date createTime1;

    /** 工序二创建人 */
    //@Excel(name = "610尺寸检验人")
    private String createBy2;

    /** 工序二创建时间 */
    @Excel(name = "610尺寸检验时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date createTime2;

    /** 工序三创建人 */
    //@Excel(name = "外观检验人")
    private String createBy3;

    /** 工序三创建时间 */
    @Excel(name = "外观检验时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
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
