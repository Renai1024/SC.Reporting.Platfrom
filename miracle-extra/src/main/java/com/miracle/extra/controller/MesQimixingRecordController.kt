package com.miracle.extra.controller;

import com.miracle.common.annotation.Anonymous;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.miracle.common.annotation.Log;
import com.miracle.common.core.controller.BaseController;
import com.miracle.common.core.domain.AjaxResult
import com.miracle.common.enums.BusinessType;
import com.miracle.extra.domain.MesQimixingRecord;
import com.miracle.extra.service.IMesQimixingRecordService;
import com.miracle.common.utils.poi.ExcelUtil;
import com.miracle.common.core.page.TableDataInfo;
import jakarta.servlet.http.HttpServletResponse

/**
 * 气密性测试记录Controller
 *
 * @author miracle
 * @date 2025-12-04
 */
@Anonymous
@RestController
@RequestMapping("/extra/mes/report/mes_qimixing_record")
open class MesQimixingRecordController(
    private val mesQimixingRecordService: IMesQimixingRecordService
) : BaseController()
{

    /**
     * 查询气密性测试记录列表
     */
    //@PreAuthorize("@ss.hasPermi('extra:MesQimixingRecord:list')")
    @GetMapping("/list")
    open fun list(mesQimixingRecord: MesQimixingRecord): TableDataInfo {
        startPage();
        val list = mesQimixingRecordService.selectMesQimixingRecordList(mesQimixingRecord);
        return getDataTable(list);
    }

    /**
     * 导出气密性测试记录列表
     */
    //@PreAuthorize("@ss.hasPermi('extra:MesQimixingRecord:export')")
    @Log(title = "气密性测试记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    open fun export(response: HttpServletResponse, mesQimixingRecord: MesQimixingRecord)
    {
        val list: List<MesQimixingRecord> = mesQimixingRecordService.selectMesQimixingRecordList(mesQimixingRecord);
        ExcelUtil<MesQimixingRecord>(MesQimixingRecord::class.java)
            .exportExcel(response, list, "气密性测试记录数据");
    }

}
