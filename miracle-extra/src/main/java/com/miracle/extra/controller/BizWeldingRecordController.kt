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
import com.miracle.extra.domain.BizWeldingRecord;
import com.miracle.extra.service.IBizWeldingRecordService;
import com.miracle.common.utils.poi.ExcelUtil;
import com.miracle.common.core.page.TableDataInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse

/**
 * 焊接结果记录Controller
 *
 * @author miracle
 * @date 2025-10-30
 */
@Tag(name = "焊接结果记录管理")
@Anonymous
@RestController
@RequestMapping("/extra/mes/report/weld_record")
open class BizWeldingRecordController(private val bizWeldingRecordService: IBizWeldingRecordService) : BaseController() {

    /**
     * 查询焊接结果记录列表
     */
    @Operation(summary = "查询焊接结果记录列表")
    //@PreAuthorize("@ss.hasPermi('extra:weld:list')")
    @GetMapping("/list")
    open fun  list(bizWeldingRecord : BizWeldingRecord):TableDataInfo {
        startPage();
        val list = bizWeldingRecordService.selectBizWeldingRecordList(bizWeldingRecord);
        return getDataTable(list);
    }

    /**
     * 导出焊接结果记录列表
     */
    @Operation(summary = "导出焊接结果记录列表")
    //@PreAuthorize("@ss.hasPermi('extra:weld:export')")
    @Log(title = "焊接结果记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    open fun export(response : HttpServletResponse,  bizWeldingRecord : BizWeldingRecord)
    {
        val list = bizWeldingRecordService.selectBizWeldingRecordList(bizWeldingRecord)
            ExcelUtil(BizWeldingRecord::class.java)
                .exportExcel(response, list, "焊接结果记录数据");
    }

    /**
     * 获取焊接结果记录详细信息
     */
    @Operation(summary = "获取焊接结果记录详细信息")
//    @PreAuthorize("@ss.hasPermi('extra:weld:query')")
    @GetMapping("/{id}")
    open fun getInfo(@PathVariable("id") id: Long) : AjaxResult =
        success(bizWeldingRecordService.selectBizWeldingRecordById(id))

    /**
     * 新增焊接结果记录
     */
    @Operation(summary = "新增焊接结果记录")
    @PreAuthorize("@ss.hasPermi('extra:weld:add')")
    @Log(title = "焊接结果记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    open fun add(@RequestBody bizWeldingRecord : BizWeldingRecord) : AjaxResult =
        toAjax(bizWeldingRecordService.insertBizWeldingRecord(bizWeldingRecord))


    /**
     * 批量新增焊接结果记录
     */
    @Operation(summary = "批量新增焊接结果记录")
    @PreAuthorize("@ss.hasPermi('extra:weld:add')")
    @Log(title = "焊接结果记录", businessType = BusinessType.INSERT)
    @PostMapping("/addBatch")
    open fun addBatch(@RequestBody bizWeldingRecord : List<BizWeldingRecord>) : AjaxResult =
         toAjax(bizWeldingRecordService.insertBizWeldingRecordBatch(bizWeldingRecord))

    /**
     * 修改焊接结果记录
     */
    @Operation(summary = "修改焊接结果记录")
    @PreAuthorize("@ss.hasPermi('extra:weld:edit')")
    @Log(title = "焊接结果记录", businessType = BusinessType.UPDATE)
    @PutMapping
    open fun edit(@RequestBody bizWeldingRecord : BizWeldingRecord) : AjaxResult =
        toAjax(bizWeldingRecordService.updateBizWeldingRecord(bizWeldingRecord))


    /**
     * 删除焊接结果记录
     */
    @Operation(summary = "删除焊接结果记录")
    @PreAuthorize("@ss.hasPermi('extra:weld:remove')")
    @Log(title = "焊接结果记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    open fun remove(@PathVariable ids : Array<Long>) : AjaxResult =
        toAjax(bizWeldingRecordService.deleteBizWeldingRecordByIds(ids));
}
