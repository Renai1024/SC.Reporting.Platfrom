package com.miracle.extra.domain;

import com.miracle.common.core.domain.BaseEntity;
import lombok.Data;

@Data
public class ErpInfo extends BaseEntity {
    private String workerName;
    private String workerCode;
    private String workshopName;
    private String workshopCode;
    private String materialName;
    private String materialCode;
}
