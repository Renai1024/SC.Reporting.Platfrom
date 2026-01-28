package com.miracle.extra.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class SunwodaToolingMoldImport {

    //零件编码
    private String itemCode;
    //零件名称
    private String itemName;
    //工序名称
    private String processName;
    //项目名称
    private String projectName;
    //数据上传时间
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private OffsetDateTime dataUploadTime;
    //生产数量
    private Integer productionQuantity;
    //合格数量
    private Integer qualifiedQuantity;
    //不合格数量
    private Integer unQualifiedQuantity;
    //合格率
    private Integer qualifiedRate;
    //供应商编码
    private String vendorCode;
}
