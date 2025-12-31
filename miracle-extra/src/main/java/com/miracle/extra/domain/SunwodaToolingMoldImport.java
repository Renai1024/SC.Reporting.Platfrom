package com.miracle.extra.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Data
public class SunwodaToolingMoldImport {
    //项目名称
    private String projectName;
    //零件编码
    private String itemCode;
    //零件名称
    private String itemName;
    //工序名称
    private String processName;
    //设备名称&编号
    private String equipmentName;
    //工装/模具名称
    private String toolingMoldName;
    //工装/模具编码
    private String toolingMoldCode;
    //设计寿命
    private Integer designLife;
    //开始使用时间
    private String startTime;
    //使用次数
    private Integer usedCount;
    //使用率
    private String utilizationRate;
    //首次预警时间
    private String firstWarningTime;
    //寿命结束时间
    private String endOfLifeTime;
    //新工装/模具编码
    private String newToolingMoldCode;
    //更换人
    private String changer;
    //数据上传时间
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private OffsetDateTime dataUploadTime;
    //供应商编码
    private String vendorCode;
}
