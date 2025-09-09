package com.miracle.extra.controller;

import java.util.List;

import com.miracle.extra.domain.ProductReportMes;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.miracle.common.annotation.Log;
import com.miracle.common.core.controller.BaseController;
import com.miracle.common.core.domain.AjaxResult;
import com.miracle.common.enums.BusinessType;
import com.miracle.extra.domain.MaterialReceiveNotice;
import com.miracle.extra.service.IMaterialReceiveNoticeService;
import com.miracle.common.utils.poi.ExcelUtil;
import com.miracle.common.core.page.TableDataInfo;

/**
 * 收料通知单Controller
 * 
 * @author miracle
 * @date 2025-09-03
 */
@RestController
@RequestMapping("/extra/erp/report/receive_material_notice")
public class MaterialReceiveNoticeController extends BaseController
{
    @Autowired
    private IMaterialReceiveNoticeService materialReceiveNoticeService;

    /**
     * 查询收料通知单列表
     */
    @PreAuthorize("@ss.hasPermi('extra:receive_material_notice:list')")
    @GetMapping("/list")
    public TableDataInfo list(MaterialReceiveNotice materialReceiveNotice)
    {
        startPage();
        List<MaterialReceiveNotice> list = materialReceiveNoticeService.selectMaterialReceiveNoticeList(materialReceiveNotice);
        return getDataTable(list);
    }

    /**
     * 导出收料通知单列表
     */
    @PreAuthorize("@ss.hasPermi('extra:receive_material_notice:export')")
    @Log(title = "收料通知单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MaterialReceiveNotice materialReceiveNotice)
    {
        List<MaterialReceiveNotice> list = materialReceiveNoticeService.selectMaterialReceiveNoticeList(materialReceiveNotice);
        ExcelUtil<MaterialReceiveNotice> util = new ExcelUtil<MaterialReceiveNotice>(MaterialReceiveNotice.class);
        util.exportExcel(response, list, "收料通知单数据");
    }

    /**
     * 导出收料通知单ByIds
     * @param ids 明细id
     */
    @PreAuthorize("@ss.hasPermi('extra:receive_material_notice:export')")
    @Log(title = "收料通知单", businessType = BusinessType.EXPORT)
    @PostMapping("/exportByIds")
    public void export(HttpServletResponse response, @RequestParam("ids") String ids){
        List<MaterialReceiveNotice> list = materialReceiveNoticeService.selectMaterialReceiveNoticeByFENTRYIDs(ids.split( ","));
        ExcelUtil<MaterialReceiveNotice> util = new ExcelUtil<MaterialReceiveNotice>(MaterialReceiveNotice.class);
        util.exportExcel(response, list, "收料通知单");
    }

    /**
     * 获取收料通知单详细信息
     */
    @PreAuthorize("@ss.hasPermi('extra:receive_material_notice:query')")
    @GetMapping(value = "/{fentryId}")
    public AjaxResult getInfo(@PathVariable("fentryId") Long fentryId)
    {
        return success(materialReceiveNoticeService.selectMaterialReceiveNoticeByFENTRYID(fentryId));
    }

    /**
     * 新增收料通知单
     */
    @PreAuthorize("@ss.hasPermi('extra:receive_material_notice:add')")
    @Log(title = "收料通知单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MaterialReceiveNotice materialReceiveNotice)
    {
        return toAjax(materialReceiveNoticeService.insertMaterialReceiveNotice(materialReceiveNotice));
    }

    /**
     * 修改收料通知单
     */
    @PreAuthorize("@ss.hasPermi('extra:receive_material_notice:edit')")
    @Log(title = "收料通知单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MaterialReceiveNotice materialReceiveNotice)
    {
        return toAjax(materialReceiveNoticeService.updateMaterialReceiveNotice(materialReceiveNotice));
    }

    /**
     * 删除收料通知单
     */
    @PreAuthorize("@ss.hasPermi('extra:receive_material_notice:remove')")
    @Log(title = "收料通知单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{FENTRYIDs}")
    public AjaxResult remove(@PathVariable Long[] FENTRYIDs)
    {
        return toAjax(materialReceiveNoticeService.deleteMaterialReceiveNoticeByFENTRYIDs(FENTRYIDs));
    }
}
