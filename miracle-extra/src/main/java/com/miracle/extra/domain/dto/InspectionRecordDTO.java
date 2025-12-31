package com.miracle.extra.domain.dto;

import lombok.Data;

import java.util.List;

@Data
public class InspectionRecordDTO {
    private String boxCode;
    private String customerBoxCode;
    private String boxCodeBindTime;
    private String customerBoxCodeBindTime;
    private List<String> serialNumbers;
}
