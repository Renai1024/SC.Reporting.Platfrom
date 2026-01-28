package com.miracle.quartz.task;

import com.miracle.extra.service.SunwodaToolingMoldImportService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

@Component("SunwodaPushTask")
public class SunwodaPushTask {

    @Resource
    private SunwodaToolingMoldImportService sunwodaToolingMoldImportService;

    public void pushData() {
        sunwodaToolingMoldImportService.pushData();
    }

    public SunwodaPushTask(){}
}
