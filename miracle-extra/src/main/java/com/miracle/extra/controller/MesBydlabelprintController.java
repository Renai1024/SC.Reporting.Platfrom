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
import com.miracle.extra.domain.MesBydlabelprint;
import com.miracle.extra.service.IMesBydlabelprintService;
import com.miracle.common.utils.poi.ExcelUtil;
import com.miracle.common.core.page.TableDataInfo;

/**
 * bydlabelprintController
 *
 * @author miracle
 * @date 2025-11-20
 */
@RestController
@Anonymous
@RequestMapping("/extra/mes/report/bydlabelprint")
public class MesBydlabelprintController extends BaseController
{
    @Autowired
    private IMesBydlabelprintService mesBydlabelprintService;

    /**
     * 查询bydlabelprint列表
     */
    //@PreAuthorize("@ss.hasPermi('extra:bydlabelprint&scan:list')")
    @GetMapping("/list")
    public TableDataInfo list(MesBydlabelprint mesBydlabelprint)
    {
        startPage();
        List<MesBydlabelprint> list = mesBydlabelprintService.selectMesBydlabelprintList(mesBydlabelprint);
        return getDataTable(list);
    }

    /**
     * 导出bydlabelprint列表
     */
    //@PreAuthorize("@ss.hasPermi('extra:bydlabelprint&scan:export')")
    @Log(title = "bydlabelprint", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MesBydlabelprint mesBydlabelprint)
    {
        List<MesBydlabelprint> list = mesBydlabelprintService.selectMesBydlabelprintList(mesBydlabelprint);
        ExcelUtil<MesBydlabelprint> util = new ExcelUtil<MesBydlabelprint>(MesBydlabelprint.class);
        util.exportExcel(response, list, "bydlabelprint数据");
    }

    /**
     * 获取bydlabelprint详细信息
     */
    @PreAuthorize("@ss.hasPermi('extra:bydlabelprint&scan:query')")
    @GetMapping(value = "/{MaterialCode}")
    public AjaxResult getInfo(@PathVariable("MaterialCode") String MaterialCode)
    {
        return success(mesBydlabelprintService.selectMesBydlabelprintByMaterialCode(MaterialCode));
    }

//    /**
//     * 新增bydlabelprint
//     */
//    @PreAuthorize("@ss.hasPermi('extra:bydlabelprint&scan:add')")
//    @Log(title = "bydlabelprint", businessType = BusinessType.INSERT)
//    @PostMapping
//    public AjaxResult add(@RequestBody MesBydlabelprint mesBydlabelprint)
//    {
//        return toAjax(mesBydlabelprintService.insertMesBydlabelprint(mesBydlabelprint));
//    }
//
//    /**
//     * 修改bydlabelprint
//     */
//    @PreAuthorize("@ss.hasPermi('extra:bydlabelprint&scan:edit')")
//    @Log(title = "bydlabelprint", businessType = BusinessType.UPDATE)
//    @PutMapping
//    public AjaxResult edit(@RequestBody MesBydlabelprint mesBydlabelprint)
//    {
//        return toAjax(mesBydlabelprintService.updateMesBydlabelprint(mesBydlabelprint));
//    }
//
//    /**
//     * 删除bydlabelprint
//     */
//    @PreAuthorize("@ss.hasPermi('extra:bydlabelprint&scan:remove')")
//    @Log(title = "bydlabelprint", businessType = BusinessType.DELETE)
//	@DeleteMapping("/{MaterialCodes}")
//    public AjaxResult remove(@PathVariable String[] MaterialCodes)
//    {
//        return toAjax(mesBydlabelprintService.deleteMesBydlabelprintByMaterialCodes(MaterialCodes));
//    }
}
