package com.miracle.extra.controller;

import java.util.List;

import com.miracle.common.annotation.Anonymous;
import com.miracle.common.exception.ServiceException;
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
import com.miracle.extra.domain.InspectionRecordMES;
import com.miracle.extra.service.IInspectionRecordMESService;
import com.miracle.common.utils.poi.ExcelUtil;
import com.miracle.common.core.page.TableDataInfo;

/**
 * 检验数据Controller
 * 
 * @author miracle
 * @date 2025-09-24
 */
@Anonymous
@RestController
@RequestMapping("/extra/mes/report/mes_inspection_record")
public class InspectionRecordMESController extends BaseController
{
    @Autowired
    private IInspectionRecordMESService inspectionRecordMESService;

    /**
     * 查询检验数据列表
     */
    //@PreAuthorize("@ss.hasPermi('extra:mes_inspection_record:list')")
    @GetMapping("/list")
    public TableDataInfo list(InspectionRecordMES inspectionRecordMES)
    {
        startPage();
        List<InspectionRecordMES> list = inspectionRecordMESService.selectInspectionRecordMESList(inspectionRecordMES);
        return getDataTable(list);
    }

    /**
     * 导出检验数据列表
     */
    @PreAuthorize("@ss.hasPermi('extra:mes_inspection_record:export')")
    @Log(title = "检验数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, InspectionRecordMES inspectionRecordMES)
    {
        List<InspectionRecordMES> list = inspectionRecordMESService.selectInspectionRecordMESList(inspectionRecordMES);
        ExcelUtil<InspectionRecordMES> util = new ExcelUtil<InspectionRecordMES>(InspectionRecordMES.class);
        util.exportExcel(response, list, "检验数据数据");
    }

    /**
     * 获取检验数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('extra:mes_inspection_record:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(inspectionRecordMESService.selectInspectionRecordMESById(id));
    }

    /**
     * 新增工序一检验数据
     */
    @PreAuthorize("@ss.hasPermi('extra:mes_inspection_record:add1')")
    @Log(title = "工序一检验数据", businessType = BusinessType.INSERT)
    @PostMapping("/add1")
    public AjaxResult add1(@RequestBody InspectionRecordMES inspectionRecordMES)
    {
        try{
            return toAjax(inspectionRecordMESService.insertInspectionRecordMES1(inspectionRecordMES));
        }catch (ServiceException  e){
            return AjaxResult.error(e.getMessage());
        }
    }

    /**
     * 新增工序二检验数据
     */
    @PreAuthorize("@ss.hasPermi('extra:mes_inspection_record:add2')")
    @Log(title = "工序二检验数据", businessType = BusinessType.INSERT)
    @PostMapping("/add2")
    public AjaxResult add2(@RequestBody InspectionRecordMES inspectionRecordMES)
    {
        return toAjax(inspectionRecordMESService.insertInspectionRecordMES2(inspectionRecordMES));
    }

    /**
     * 新增工序三检验数据
     */
    @PreAuthorize("@ss.hasPermi('extra:mes_inspection_record:add3')")
    @Log(title = "工序三检验数据", businessType = BusinessType.INSERT)
    @PostMapping("/add3")
    public AjaxResult add3(@RequestBody InspectionRecordMES inspectionRecordMES)
    {
        return toAjax(inspectionRecordMESService.insertInspectionRecordMES3(inspectionRecordMES));
    }

    /**
     * 新增箱码绑定
     */
    @PreAuthorize("@ss.hasPermi('extra:mes_inspection_record:add4')")
    @Log(title = "箱码绑定", businessType = BusinessType.UPDATE)
    @PostMapping("/add4")
    public AjaxResult add4( @RequestBody InspectionRecordMES.BoxBindRequest request)
    {
        return toAjax(inspectionRecordMESService.updateInspectionRecordMES(request.getSerialNumbers(),request.getBoxCode()));
    }

    /**
     * 客户箱码绑定
     */
    @PreAuthorize("@ss.hasPermi('extra:mes_inspection_record:add5')")
    @Log(title = "客户箱码绑定", businessType = BusinessType.UPDATE)
    @PostMapping("/add5")
    public AjaxResult add5( @RequestBody InspectionRecordMES.CustomerBoxBindRequest request)
    {
        return toAjax(inspectionRecordMESService.updateInspectionRecordMES(request.getBoxCode(),request.getCustomerBoxCode()));
    }

    /**
     * 修改检验数据
     */
    @PreAuthorize("@ss.hasPermi('extra:mes_inspection_record:edit')")
    @Log(title = "检验数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody InspectionRecordMES inspectionRecordMES)
    {
        return toAjax(inspectionRecordMESService.updateInspectionRecordMES(inspectionRecordMES));
    }

    /**
     * 删除检验数据
     */
    @PreAuthorize("@ss.hasPermi('extra:mes_inspection_record:remove')")
    @Log(title = "检验数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long ids)
    {
        //return toAjax(inspectionRecordMESService.deleteInspectionRecordMESByIds(ids));
        return toAjax(inspectionRecordMESService.deleteInspectionRecordMESById(ids));
    }
}
