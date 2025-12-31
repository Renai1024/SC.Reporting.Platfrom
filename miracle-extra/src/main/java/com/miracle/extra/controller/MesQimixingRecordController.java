package com.miracle.extra.controller;

import java.util.List;

import com.miracle.common.annotation.Anonymous;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.miracle.common.core.domain.AjaxResult;
import com.miracle.common.enums.BusinessType;
import com.miracle.extra.domain.MesQimixingRecord;
import com.miracle.extra.service.IMesQimixingRecordService;
import com.miracle.common.utils.poi.ExcelUtil;
import com.miracle.common.core.page.TableDataInfo;

/**
 * 气密性测试记录Controller
 *
 * @author miracle
 * @date 2025-12-04
 */
@Anonymous
@RestController
@RequestMapping("/extra/mes/report/mes_qimixing_record")
public class MesQimixingRecordController extends BaseController
{
    @Autowired
    private IMesQimixingRecordService mesQimixingRecordService;

    /**
     * 查询气密性测试记录列表
     */
    //@PreAuthorize("@ss.hasPermi('extra:MesQimixingRecord:list')")
    @GetMapping("/list")
    public TableDataInfo list(MesQimixingRecord mesQimixingRecord)
    {
        startPage();
        List<MesQimixingRecord> list = mesQimixingRecordService.selectMesQimixingRecordList(mesQimixingRecord);
        return getDataTable(list);
    }

    /**
     * 导出气密性测试记录列表
     */
    //@PreAuthorize("@ss.hasPermi('extra:MesQimixingRecord:export')")
    @Log(title = "气密性测试记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MesQimixingRecord mesQimixingRecord)
    {
        List<MesQimixingRecord> list = mesQimixingRecordService.selectMesQimixingRecordList(mesQimixingRecord);
        ExcelUtil<MesQimixingRecord> util = new ExcelUtil<MesQimixingRecord>(MesQimixingRecord.class);
        util.exportExcel(response, list, "气密性测试记录数据");
    }

    /**
     * 获取气密性测试记录详细信息
     */
    //@PreAuthorize("@ss.hasPermi('extra:MesQimixingRecord:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(mesQimixingRecordService.selectMesQimixingRecordById(id));
    }

    /**
     * 新增气密性测试记录
     */
    @PreAuthorize("@ss.hasPermi('extra:MesQimixingRecord:add')")
    @Log(title = "气密性测试记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MesQimixingRecord mesQimixingRecord)
    {
        return toAjax(mesQimixingRecordService.insertMesQimixingRecord(mesQimixingRecord));
    }

    /**
     * 修改气密性测试记录
     */
    @PreAuthorize("@ss.hasPermi('extra:MesQimixingRecord:edit')")
    @Log(title = "气密性测试记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MesQimixingRecord mesQimixingRecord)
    {
        return toAjax(mesQimixingRecordService.updateMesQimixingRecord(mesQimixingRecord));
    }

    /**
     * 删除气密性测试记录
     */
    @PreAuthorize("@ss.hasPermi('extra:MesQimixingRecord:remove')")
    @Log(title = "气密性测试记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(mesQimixingRecordService.deleteMesQimixingRecordByIds(ids));
    }
}
