package com.miracle.extra.controller;

import java.util.List;

import com.miracle.common.annotation.Anonymous;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import org.springdoc.core.service.OperationService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.miracle.common.annotation.Log;
import com.miracle.common.core.controller.BaseController;
import com.miracle.common.core.domain.AjaxResult;
import com.miracle.common.enums.BusinessType;
import com.miracle.extra.domain.MaterialInfo;
import com.miracle.extra.service.IMaterialInfoService;
import com.miracle.common.utils.poi.ExcelUtil;
import com.miracle.common.core.page.TableDataInfo;

/**
 * 物料信息Controller
 * 
 * @author miracle
 * @date 2025-07-27
 */

@Tag(name = "物料信息报表")
@RestController
@RequestMapping("/extra/erp/report/material")
public class MaterialInfoController extends BaseController
{
    @Autowired
    private IMaterialInfoService materialInfoService;


    /**
     * 查询物料信息列表
     */
    @Operation(summary = "查询物料信息列表")
    @PreAuthorize("@ss.hasPermi('extra:erp_report_material:list')")
    @GetMapping("/list")
    public TableDataInfo list(MaterialInfo materialInfo)
    {
        startPage();
        List<MaterialInfo> list = materialInfoService.selectMaterialInfoList(materialInfo);
        return getDataTable(list);
    }

    /**
     * 全量导出物料信息列表
     */
    @Operation(summary = "全量导出物料信息列表")
    @PreAuthorize("@ss.hasPermi('extra:erp_report_material:export')")
    @Log(title = "物料信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MaterialInfo materialInfo)
    {
        List<MaterialInfo> list = materialInfoService.selectMaterialInfoList(materialInfo);
        ExcelUtil<MaterialInfo> util = new ExcelUtil<MaterialInfo>(MaterialInfo.class);
        util.exportExcel(response, list, "物料信息数据");
    }

    /**
     * 按ids导出物料信息
     */
    @Operation(summary = "按ids导出物料信息")
    @PreAuthorize("@ss.hasPermi('extra:erp_report_material:export')")
    @Log(title = "物料信息ById", businessType = BusinessType.EXPORT)
    @PostMapping("/exportByIds")
    public void exportByIds(HttpServletResponse response, @RequestParam("ids") String ids)
    {
        List<MaterialInfo> list = materialInfoService.selectMaterialInfoListByIds(ids.split( ","));
        ExcelUtil<MaterialInfo> util = new ExcelUtil<MaterialInfo>(MaterialInfo.class);
        util.exportExcel(response, list, "物料信息数据");
    }

    /**
     * 获取物料信息详细信息
     */
    @Operation(summary = "获取物料信息详细信息")
    @PreAuthorize("@ss.hasPermi('extra:erp_report_material:query')")
    @GetMapping(value = "/{materialId}")
    public AjaxResult getInfo(@PathVariable("materialId") String materialId)
    {
        return success(materialInfoService.selectMaterialInfoByMaterialId(materialId));
    }



}
