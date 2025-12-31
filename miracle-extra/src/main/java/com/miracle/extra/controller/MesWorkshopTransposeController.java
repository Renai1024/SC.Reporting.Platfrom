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
import com.miracle.extra.domain.MesWorkshopTranspose;
import com.miracle.extra.service.IMesWorkshopTransposeService;
import com.miracle.common.utils.poi.ExcelUtil;
import com.miracle.common.core.page.TableDataInfo;

/**
 * 车间转序Controller
 *
 * @author miracle
 * @date 2025-12-17
 */
@Anonymous
@RestController
@RequestMapping("/extra/mes/report/mes_workshop_transpose")
public class MesWorkshopTransposeController extends BaseController
{
    @Autowired
    private IMesWorkshopTransposeService mesWorkshopTransposeService;

    /**
     * 查询车间转序列表
     */
//    @PreAuthorize("@ss.hasPermi('extra:mes_workshop_transpose:list')")
    @GetMapping("/list")
    public TableDataInfo list(MesWorkshopTranspose mesWorkshopTranspose)
    {
        startPage();
        List<MesWorkshopTranspose> list = mesWorkshopTransposeService.selectMesWorkshopTransposeList(mesWorkshopTranspose);
        return getDataTable(list);
    }


    /**
     * 导出车间转序列表
     */
//    @PreAuthorize("@ss.hasPermi('extra:mes_workshop_transpose:export')")
    @Log(title = "车间转序", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MesWorkshopTranspose mesWorkshopTranspose)
    {
        List<MesWorkshopTranspose> list = mesWorkshopTransposeService.selectMesWorkshopTransposeList(mesWorkshopTranspose);
        ExcelUtil<MesWorkshopTranspose> util = new ExcelUtil<MesWorkshopTranspose>(MesWorkshopTranspose.class);
        util.exportExcel(response, list, "车间转序数据");
    }

    /**
     * 获取车间转序详细信息
     */
//    @PreAuthorize("@ss.hasPermi('extra:mes_workshop_transpose:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(mesWorkshopTransposeService.selectMesWorkshopTransposeById(id));
    }

    /**
     * 新增车间转序
     */
    @PreAuthorize("@ss.hasPermi('extra:mes_workshop_transpose:add')")
    @Log(title = "车间转序", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody MesWorkshopTranspose mesWorkshopTranspose)
    {
        return toAjax(mesWorkshopTransposeService.insertMesWorkshopTranspose(mesWorkshopTranspose));
    }

    /**
     * 转序确认
     */
    @PreAuthorize("@ss.hasPermi('extra:mes_workshop_transpose:confirm')")
    @Log(title = "转序确认", businessType = BusinessType.UPDATE)
    @PutMapping("/confirm")
    public AjaxResult edit(@RequestBody MesWorkshopTranspose mesWorkshopTranspose)
    {
        return toAjax(mesWorkshopTransposeService.updateMesWorkshopTranspose(mesWorkshopTranspose));
    }

    /**
     * 修改数量
     */
    @PreAuthorize("@ss.hasPermi('extra:mes_workshop_transpose:modify')")
    @Log(title = "修改数量", businessType = BusinessType.UPDATE)
    @PutMapping("/change/quantity")
    public AjaxResult changeQuantity(@RequestBody MesWorkshopTranspose mesWorkshopTranspose)
    {
        return toAjax(mesWorkshopTransposeService.changeQuantity(mesWorkshopTranspose));
    }

    /**
     * 删除车间转序
     */
    @PreAuthorize("@ss.hasPermi('extra:mes_workshop_transpose:remove')")
    @Log(title = "车间转序", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(mesWorkshopTransposeService.deleteMesWorkshopTransposeByIds(ids));
    }
}
