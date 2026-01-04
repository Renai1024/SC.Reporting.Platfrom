package com.miracle.extra.controller;
import com.miracle.common.annotation.Anonymous;
import org.springframework.security.access.prepost.PreAuthorize;
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
import com.miracle.common.core.domain.AjaxResult
import com.miracle.common.enums.BusinessType;
import com.miracle.extra.domain.MesWorkshopTranspose;
import com.miracle.extra.service.IMesWorkshopTransposeService;
import com.miracle.common.utils.poi.ExcelUtil;
import com.miracle.common.core.page.TableDataInfo;
import jakarta.servlet.http.HttpServletResponse

/**
 * 车间转序Controller
 *
 * @author miracle
 * @date 2025-12-17
 */
@Anonymous
@RestController
@RequestMapping("/extra/mes/report/mes_workshop_transpose")
open class MesWorkshopTransposeController(private val mesWorkshopTransposeService: IMesWorkshopTransposeService) : BaseController()
{

    /**
     * 查询车间转序列表
     */
//    @PreAuthorize("@ss.hasPermi('extra:mes_workshop_transpose:list')")
    @GetMapping("/list")
    open fun list(mesWorkshopTranspose: MesWorkshopTranspose):TableDataInfo
    {
        startPage();
        val list: List<MesWorkshopTranspose> = mesWorkshopTransposeService.selectMesWorkshopTransposeList(mesWorkshopTranspose)
        return getDataTable(list);
    }


    /**
     * 导出车间转序列表
     */
//    @PreAuthorize("@ss.hasPermi('extra:mes_workshop_transpose:export')")
    @Log(title = "车间转序", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    open fun export(response: HttpServletResponse, mesWorkshopTranspose:MesWorkshopTranspose)
    {
        val list = mesWorkshopTransposeService.selectMesWorkshopTransposeList(mesWorkshopTranspose)
        ExcelUtil(MesWorkshopTranspose::class.java)
            .exportExcel(response, list, "车间转序数据");
    }

    /**
     * 获取车间转序详细信息
     */
//    @PreAuthorize("@ss.hasPermi('extra:mes_workshop_transpose:query')")
    @GetMapping( "/{id}")
    open fun getInfo(@PathVariable("id") id: Long) : AjaxResult = success(mesWorkshopTransposeService.selectMesWorkshopTransposeById(id))

    /**
     * 新增车间转序
     */
    @PreAuthorize("@ss.hasPermi('extra:mes_workshop_transpose:add')")
    @Log(title = "车间转序", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    open fun add(@RequestBody mesWorkshopTranspose: MesWorkshopTranspose) : AjaxResult = toAjax(mesWorkshopTransposeService.insertMesWorkshopTranspose(mesWorkshopTranspose))

    /**
     * 转序确认
     */
    @PreAuthorize("@ss.hasPermi('extra:mes_workshop_transpose:confirm')")
    @Log(title = "转序确认", businessType = BusinessType.UPDATE)
    @PutMapping("/confirm")
    open fun edit(@RequestBody mesWorkshopTranspose : MesWorkshopTranspose) : AjaxResult = toAjax(mesWorkshopTransposeService.updateMesWorkshopTranspose(mesWorkshopTranspose))

    /**
     * 修改数量
     */
    @PreAuthorize("@ss.hasPermi('extra:mes_workshop_transpose:modify')")
    @Log(title = "修改数量", businessType = BusinessType.UPDATE)
    @PutMapping("/change/quantity")
    open fun changeQuantity(@RequestBody mesWorkshopTranspose: MesWorkshopTranspose) : AjaxResult = toAjax(mesWorkshopTransposeService.changeQuantity(mesWorkshopTranspose))
    /**
     * 删除车间转序
     */
    @PreAuthorize("@ss.hasPermi('extra:mes_workshop_transpose:remove')")
    @Log(title = "车间转序", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    open fun remove(@PathVariable ids : Array<Long>) : AjaxResult = toAjax(mesWorkshopTransposeService.deleteMesWorkshopTransposeByIds(ids))
}
