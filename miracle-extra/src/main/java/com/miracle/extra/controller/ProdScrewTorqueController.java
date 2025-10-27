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
import com.miracle.extra.domain.ProdScrewTorque;
import com.miracle.extra.service.IProdScrewTorqueService;
import com.miracle.common.utils.poi.ExcelUtil;
import com.miracle.common.core.page.TableDataInfo;

/**
 * 碳化硅自动锁螺丝数据Controller
 * 
 * @author miracle
 * @date 2025-10-24
 */
@Anonymous
@RestController
@RequestMapping("/extra/mes/report/torque")
public class ProdScrewTorqueController extends BaseController
{
    @Autowired
    private IProdScrewTorqueService prodScrewTorqueService;

    /**
     * 查询碳化硅自动锁螺丝数据列表
     */
    //@PreAuthorize("@ss.hasPermi('extra:torque:list')")
    @GetMapping("/list")
    public TableDataInfo list(ProdScrewTorque prodScrewTorque)
    {
        startPage();
        List<ProdScrewTorque> list = prodScrewTorqueService.selectProdScrewTorqueList(prodScrewTorque);
        return getDataTable(list);
    }

    /**
     * 导出碳化硅自动锁螺丝数据列表
     */
    //@PreAuthorize("@ss.hasPermi('extra:torque:export')")
    @Log(title = "碳化硅自动锁螺丝数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ProdScrewTorque prodScrewTorque)
    {
        List<ProdScrewTorque> list = prodScrewTorqueService.selectProdScrewTorqueList(prodScrewTorque);
        ExcelUtil<ProdScrewTorque> util = new ExcelUtil<ProdScrewTorque>(ProdScrewTorque.class);
        util.exportExcel(response, list, "碳化硅自动锁螺丝数据数据");
    }

    /**
     * 获取碳化硅自动锁螺丝数据详细信息
     */
    //@PreAuthorize("@ss.hasPermi('extra:torque:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(prodScrewTorqueService.selectProdScrewTorqueById(id));
    }

    /**
     * 新增碳化硅自动锁螺丝数据
     */
    @PreAuthorize("@ss.hasPermi('extra:torque:add')")
    @Log(title = "新增碳化硅自动锁螺丝数据", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody ProdScrewTorque prodScrewTorque)
    {
        return toAjax(prodScrewTorqueService.insertProdScrewTorque(prodScrewTorque));
    }

    /**
     * 新增碳化硅自动锁螺丝数据
     */
    @PreAuthorize("@ss.hasPermi('extra:torque:add')")
    @Log(title = "批量新增碳化硅自动锁螺丝数据", businessType = BusinessType.INSERT)
    @PostMapping("/addBatch")
    public AjaxResult addBatch(@RequestBody List<ProdScrewTorque> prodScrewTorqueList)
    {
        return toAjax(prodScrewTorqueService.insertProdScrewTorqueBatch(prodScrewTorqueList));
    }

    /**
     * 修改碳化硅自动锁螺丝数据
     */
    @PreAuthorize("@ss.hasPermi('extra:torque:edit')")
    @Log(title = "碳化硅自动锁螺丝数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ProdScrewTorque prodScrewTorque)
    {
        return toAjax(prodScrewTorqueService.updateProdScrewTorque(prodScrewTorque));
    }

    /**
     * 删除碳化硅自动锁螺丝数据
     */
    @PreAuthorize("@ss.hasPermi('extra:torque:remove')")
    @Log(title = "碳化硅自动锁螺丝数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(prodScrewTorqueService.deleteProdScrewTorqueByIds(ids));
    }
}
