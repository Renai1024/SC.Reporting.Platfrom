package com.miracle.extra.controller;

import java.util.List;

import com.miracle.common.annotation.Anonymous;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.miracle.common.annotation.Log;
import com.miracle.common.core.controller.BaseController;
import com.miracle.common.core.domain.AjaxResult;
import com.miracle.common.enums.BusinessType;
import com.miracle.extra.domain.ProductReportMes;
import com.miracle.extra.service.IProductReportMesService;
import com.miracle.common.utils.poi.ExcelUtil;
import com.miracle.common.core.page.TableDataInfo;

/**
 * MES生产数据Controller
 * 
 * @author miracle
 * @date 2025-07-31
 */
@Anonymous
@Tag(name = "MES生产数据报表")
@RestController
@RequestMapping("/extra/mes/report/iqc")
public class ProductReportMesController extends BaseController
{
    @Autowired
    private IProductReportMesService productReportMesService;

    /**
     * 查询MES生产数据列表
     */
    @Operation(summary = "查询MES生产数据列表")
    //@PreAuthorize("@ss.hasPermi('extra:mes_report_iqc:list')")
    @GetMapping("/list")
    public TableDataInfo list(ProductReportMes productReportMes)
    {
        startPage();
        List<ProductReportMes> list = productReportMesService.selectProductReportMesList(productReportMes);
        return getDataTable(list);
    }

    /**
     * 导出MES生产数据列表
     */
    @Operation(summary = "全量导出MES生产数据列表")
    //@PreAuthorize("@ss.hasPermi('extra:mes_report_iqc:export')")
    @Log(title = "导出MES生产数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ProductReportMes productReportMes)
    {
        List<ProductReportMes> list = productReportMesService.selectProductReportMesList(productReportMes);
        ExcelUtil<ProductReportMes> util = new ExcelUtil<ProductReportMes>(ProductReportMes.class);
        util.exportExcel(response, list, "MES生产数据数据");
    }

    /**
     * 按ids导出MES生产数据
     */
    @Operation(summary = "按ids导出MES生产数据")
    //@PreAuthorize("@ss.hasPermi('extra:mes_report_iqc:export')")
    @Log(title = "导出MES生产数据ByIds", businessType = BusinessType.EXPORT)
    @PostMapping("/exportByIds")
    public void export(HttpServletResponse response, @RequestParam("ids") String ids)
    {
        List<ProductReportMes> list = productReportMesService.selectProductReportMesListByIds(ids.split( ","));
        ExcelUtil<ProductReportMes> util = new ExcelUtil<ProductReportMes>(ProductReportMes.class);
        util.exportExcel(response, list, "MES生产数据数据");
    }


    /**
     * 获取MES生产数据详细信息
     */
    @Operation(summary = "获取MES生产数据详细信息")
    @PreAuthorize("@ss.hasPermi('extra:mes_report_iqc:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(productReportMesService.selectProductReportMesById(id));
    }

    /**
     * 新增MES生产数据信息
     */
    @Operation(summary = "新增MES生产数据信息")
    @PreAuthorize("@ss.hasPermi('extra:mes_report_iqc:add')")
    @Log(title = "新增MES生产数据", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody ProductReportMes productReportMes)
    {
        return toAjax(productReportMesService.insertProductReportMes(productReportMes));
    }

    /**
     * 批量新增MES生产数据信息
     */
    @Operation(summary = "批量新增MES生产数据信息")
    @PreAuthorize("@ss.hasPermi('extra:mes_report_iqc:add')")
    @Log(title = "批量新增MES生产数据", businessType = BusinessType.INSERT)
    @PostMapping("/addBatch")
    public AjaxResult addBatch(@RequestBody List<ProductReportMes> productReportMesList)
    {
        return toAjax(productReportMesService.insertProductReportMesBatch(productReportMesList));
    }

    /**
     * 修改MES生产数据信息
     */
    @Operation(summary = "修改MES生产数据信息")
    @PreAuthorize("@ss.hasPermi('extra:mes_report_iqc:edit')")
    @Log(title = "修改MES生产数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ProductReportMes productReportMes)
    {
        return toAjax(productReportMesService.updateProductReportMes(productReportMes));
    }

    /**
     * 删除MES生产数据信息
     */
    @Operation(summary = "删除MES生产数据信息")
    @PreAuthorize("@ss.hasPermi('extra:mes_report_iqc:remove')")
    @Log(title = "MES生产数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(productReportMesService.deleteProductReportMesByIds(ids));
    }
}
