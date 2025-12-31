package com.miracle.extra.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.miracle.common.core.domain.BaseEntity;
import lombok.Data;
import com.miracle.common.annotation.Excel;

/**
 * bydlabelscan对象 mes_bydlabelscan
 *
 * @author miracle
 * @date 2025-11-20
 */
@Data
public class MesBydlabelscan extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 物料号 */
    @Excel(name = "物料号")
    private String materialCode;

    /** 条码 */
    @Excel(name = "条码")
    private String barCodeStr;

    /** 扫码时间 */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Excel(name = "扫码时间", width = 30, dateFormat = "yyyy-MM-dd hh:mm:ss")
    private Date scanDate;

    /** 扫码所在电脑名称 */
    @Excel(name = "扫码所在电脑名称")
    private String scanMachine;

    /** 扫码所在电脑 */
    @Excel(name = "扫码所在电脑")
    private String scanIPAddress;

    /** 是否重码 */
    @Excel(name = "是否重码")
    private String duplicateFlag;

    /**开始时间**/
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startTime;

    /** 结束时间**/
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endTime;


}
