package com.miracle.extra.domain.dto;

import lombok.Data;

@Data
public class MesBydLabelPrintScanCountDTO {
    private int PrintCount;
    private int ScanCount;
    private int UnscannedCount;
}
