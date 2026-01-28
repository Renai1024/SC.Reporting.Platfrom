package com.miracle.extra.controller

import com.miracle.common.annotation.Anonymous
import com.miracle.common.annotation.Log
import com.miracle.common.core.controller.BaseController
import com.miracle.common.core.domain.AjaxResult
import com.miracle.common.core.page.TableDataInfo
import com.miracle.common.enums.BusinessType
import com.miracle.common.utils.poi.ExcelUtil
import com.miracle.extra.domain.MesReportDuanziyajieji
import com.miracle.extra.service.IMesReportDuanziyajiejiService
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*

/**
 * 端子压接机数据Controller
 *
 * @author miracle
 * @date 2025-12-22
 */
@Anonymous
@RestController
@RequestMapping("/extra/mes/report/mes_report_duanziyajieji")
open class MesReportDuanziyajiejiController(
    private val mesReportDuanziyajiejiService: IMesReportDuanziyajiejiService
) : BaseController() {


    /**
     * 查询端子压接机数据列表
     */
    @GetMapping("/list")
    open fun list(mesReportDuanziyajieji: MesReportDuanziyajieji): TableDataInfo {
        startPage()
        val list = mesReportDuanziyajiejiService.selectMesReportDuanziyajiejiList(mesReportDuanziyajieji)
        return getDataTable(list)
    }

    /**
     * 导出端子压接机数据列表
     */
    @Log(title = "端子压接机数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    open fun export(response: HttpServletResponse, mesReportDuanziyajieji: MesReportDuanziyajieji) {
        val list = mesReportDuanziyajiejiService.selectMesReportDuanziyajiejiList(mesReportDuanziyajieji)
        ExcelUtil(MesReportDuanziyajieji::class.java)
            .exportExcel(response, list, "端子压接机数据数据")
    }

    /**
     * 获取端子压接机数据详细信息
     */
    // @PreAuthorize("@ss.hasPermi('extra:mes_report_duanziyajieji:query')")
    @GetMapping("/{id}")
    open fun getInfo(@PathVariable("id") id: Long): AjaxResult =
        success(mesReportDuanziyajiejiService.selectMesReportDuanziyajiejiById(id))

    /**
     * 新增端子压接机数据
     */
    @PreAuthorize("@ss.hasPermi('extra:mes_report_duanziyajieji:add')")
    @Log(title = "端子压接机数据", businessType = BusinessType.INSERT)
    @PostMapping
    open fun add(@RequestBody mesReportDuanziyajieji: MesReportDuanziyajieji): AjaxResult =
        toAjax(mesReportDuanziyajiejiService.insertMesReportDuanziyajieji(mesReportDuanziyajieji))


    /**
     * 修改端子压接机数据
     */
    @PreAuthorize("@ss.hasPermi('extra:mes_report_duanziyajieji:edit')")
    @Log(title = "端子压接机数据", businessType = BusinessType.UPDATE)
    @PutMapping
    open fun edit(@RequestBody mesReportDuanziyajieji: MesReportDuanziyajieji): AjaxResult =
         toAjax(mesReportDuanziyajiejiService.updateMesReportDuanziyajieji(mesReportDuanziyajieji))


    /**
     * 删除端子压接机数据
     */
    @PreAuthorize("@ss.hasPermi('extra:mes_report_duanziyajieji:remove')")
    @Log(title = "端子压接机数据", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    open fun remove(@PathVariable ids: Array<Long>): AjaxResult =
        toAjax(mesReportDuanziyajiejiService.deleteMesReportDuanziyajiejiByIds(ids))
}