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
import com.miracle.extra.domain.MesBydlabelscan;
import com.miracle.extra.service.IMesBydlabelscanService;
import com.miracle.common.utils.poi.ExcelUtil;
import com.miracle.common.core.page.TableDataInfo;

/**
 * bydlabelscanController
 *
 * @author miracle
 * @date 2025-11-20
 */
@RestController
@Anonymous
@RequestMapping("/extra/mes/report/bydlabelscan")
public class MesBydlabelscanController extends BaseController
{
    @Autowired
    private IMesBydlabelscanService mesBydlabelscanService;

    /**
     * 查询bydlabelscan列表
     */
    //@PreAuthorize("@ss.hasPermi('extra:bydlabelprint&scan:list')")
    @GetMapping("/list")
    public TableDataInfo list(MesBydlabelscan mesBydlabelscan)
    {
        startPage();
        List<MesBydlabelscan> list = mesBydlabelscanService.selectMesBydlabelscanList(mesBydlabelscan);
        return getDataTable(list);
    }

    /**
     * 导出bydlabelscan列表
     */
   // @PreAuthorize("@ss.hasPermi('extra:bydlabelprint&scan:export')")
    @Log(title = "bydlabelscan", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MesBydlabelscan mesBydlabelscan)
    {
        List<MesBydlabelscan> list = mesBydlabelscanService.selectMesBydlabelscanList(mesBydlabelscan);
        ExcelUtil<MesBydlabelscan> util = new ExcelUtil<MesBydlabelscan>(MesBydlabelscan.class);
        util.exportExcel(response, list, "bydlabelscan数据");
    }

    /**
     * 获取bydlabelscan详细信息
     */
    @PreAuthorize("@ss.hasPermi('extra:bydlabelprint&scan:query')")
    @GetMapping(value = "/{materialCode}")
    public AjaxResult getInfo(@PathVariable("materialCode") String materialCode)
    {
        return success(mesBydlabelscanService.selectMesBydlabelscanByMaterialCode(materialCode));
    }

//    /**
//     * 新增bydlabelscan
//     */
//    @PreAuthorize("@ss.hasPermi('extra:bydlabelprint&scan:add')")
//    @Log(title = "bydlabelscan", businessType = BusinessType.INSERT)
//    @PostMapping
//    public AjaxResult add(@RequestBody MesBydlabelscan mesBydlabelscan)
//    {
//        return toAjax(mesBydlabelscanService.insertMesBydlabelscan(mesBydlabelscan));
//    }
//
//    /**
//     * 修改bydlabelscan
//     */
//    @PreAuthorize("@ss.hasPermi('extra:bydlabelprint&scan:edit')")
//    @Log(title = "bydlabelscan", businessType = BusinessType.UPDATE)
//    @PutMapping
//    public AjaxResult edit(@RequestBody MesBydlabelscan mesBydlabelscan)
//    {
//        return toAjax(mesBydlabelscanService.updateMesBydlabelscan(mesBydlabelscan));
//    }
//
//    /**
//     * 删除bydlabelscan
//     */
//    @PreAuthorize("@ss.hasPermi('extra:bydlabelprint&scan:remove')")
//    @Log(title = "bydlabelscan", businessType = BusinessType.DELETE)
//	@DeleteMapping("/{materialCodes}")
//    public AjaxResult remove(@PathVariable String[] materialCodes)
//    {
//        return toAjax(mesBydlabelscanService.deleteMesBydlabelscanByMaterialCodes(materialCodes));
//    }
}
