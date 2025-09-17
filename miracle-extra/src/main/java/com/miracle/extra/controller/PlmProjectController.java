package com.miracle.extra.controller;

import java.util.List;

import com.miracle.extra.domain.ProductReportMes;
import io.swagger.v3.oas.annotations.Operation;
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
import com.miracle.extra.domain.PlmProject;
import com.miracle.extra.service.IPlmProjectService;
import com.miracle.common.utils.poi.ExcelUtil;
import com.miracle.common.core.page.TableDataInfo;

/**
 * PLM项目Controller
 * 
 * @author miracle
 * @date 2025-09-10
 */
@RestController
@RequestMapping("/extra/plm/report/plm_project")
public class PlmProjectController extends BaseController
{
    @Autowired
    private IPlmProjectService plmProjectService;

    /**
     * 查询PLM项目列表
     */
    @PreAuthorize("@ss.hasPermi('extra:plm_project:list')")
    @GetMapping("/list")
    public TableDataInfo list(PlmProject plmProject)
    {
        startPage();
        List<PlmProject> list = plmProjectService.selectPlmProjectList(plmProject);
        return getDataTable(list);
    }

    /**
     * 导出PLM项目列表
     */
    @PreAuthorize("@ss.hasPermi('extra:plm_project:export')")
    @Log(title = "PLM项目", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PlmProject plmProject)
    {
        List<PlmProject> list = plmProjectService.selectPlmProjectList(plmProject);
        ExcelUtil<PlmProject> util = new ExcelUtil<PlmProject>(PlmProject.class);
        util.exportExcel(response, list, "PLM项目数据");
    }

    /**
     * 获取PLM项目详细信息
     */
    @PreAuthorize("@ss.hasPermi('extra:plm_project:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(plmProjectService.selectPlmProjectById(id));
    }

    /**
     * 新增PLM项目
     */
    @PreAuthorize("@ss.hasPermi('extra:plm_project:add')")
    @Log(title = "新增PLM项目", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody PlmProject plmProject)
    {
        return toAjax(plmProjectService.insertPlmProject(plmProject));
    }

    /**
     * 批量新增PLM项目
     */

    @PreAuthorize("@ss.hasPermi('extra:plm_project:add')")
    @Log(title = "批量新增PLM项目数据", businessType = BusinessType.INSERT)
    @PostMapping("/addBatch")
    public AjaxResult addBatch(@RequestBody List<PlmProject> plmProjectList)
    {
        return toAjax(plmProjectService.insertPlmProjectBatch(plmProjectList));
    }

    /**
     * 修改PLM项目
     */
    @PreAuthorize("@ss.hasPermi('extra:plm_project:edit')")
    @Log(title = "PLM项目", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PlmProject plmProject)
    {
        return toAjax(plmProjectService.updatePlmProject(plmProject));
    }

    /**
     * 删除PLM项目
     */
    @PreAuthorize("@ss.hasPermi('extra:plm_project:remove')")
    @Log(title = "PLM项目", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(plmProjectService.deletePlmProjectByIds(ids));
    }
}
