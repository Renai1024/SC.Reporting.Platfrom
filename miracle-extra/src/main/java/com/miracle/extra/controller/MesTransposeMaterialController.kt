package com.miracle.extra.controller

import com.miracle.common.annotation.Anonymous
import com.miracle.common.core.controller.BaseController
import com.miracle.common.core.domain.AjaxResult
import com.miracle.common.core.page.TableDataInfo
import com.miracle.common.utils.poi.ExcelUtil
import com.miracle.extra.domain.MesTransposeMaterial
import com.miracle.extra.service.IMesTransposeMaterialService
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Anonymous
@RestController
@RequestMapping("/extra/mes/report/mes_transpose_material")
open class MesTransposeMaterialController(
    private val mesTransposeMaterialService: IMesTransposeMaterialService
) : BaseController(){


    /**
     * 查询转序物料列表
     */
    @GetMapping("/list")
    open fun list(mesTransposeMaterial: MesTransposeMaterial): TableDataInfo {
        startPage()
        val list : List<MesTransposeMaterial> = mesTransposeMaterialService.selectMesTransposeMaterialList(mesTransposeMaterial)
        return getDataTable(list)
    }

    /**
     * 获取转序物料详细信息
     */
    @GetMapping("/{id}")
    open fun getInfo(@PathVariable("id") id: Long): AjaxResult {
        return success(mesTransposeMaterialService.selectMesTransposeMaterialById(id))
    }

    @PostMapping("/export")
    open fun export(response: HttpServletResponse, mesTransposeMaterial: MesTransposeMaterial)
    {
        val list = mesTransposeMaterialService.selectMesTransposeMaterialList(mesTransposeMaterial)
        ExcelUtil(MesTransposeMaterial::class.java)
            .exportExcel(response, list, "转序物料数据")
    }


    /**
     * 新增转序物料
     */
    @PreAuthorize("@ss.hasPermi('extra:mes_transpose_material:add')")
    @PostMapping("/add")
    open fun add(@RequestBody mesTransposeMaterial: MesTransposeMaterial) : AjaxResult =
        toAjax(mesTransposeMaterialService.insertMesTransposeMaterial(mesTransposeMaterial))


    /**
     * 批量新增转序物料
     */
    @PreAuthorize("@ss.hasPermi('extra:mes_transpose_material:add')")
    @PostMapping("/addBatch")
    open fun addBatch(@RequestBody mesTransposeMaterials: List<MesTransposeMaterial>) : AjaxResult =
        toAjax(mesTransposeMaterialService.insertMesTransposeMaterialBatch(mesTransposeMaterials))


    /**
     * 修改转序物料
     */
    @PreAuthorize("@ss.hasPermi('extra:mes_transpose_material:edit')")
    @PutMapping("/edit")
    open fun edit(@RequestBody mesTransposeMaterial: MesTransposeMaterial) : AjaxResult =
        toAjax(mesTransposeMaterialService.updateMesTransposeMaterial(mesTransposeMaterial))


    /**
     * 删除转序物料
     */
    @PreAuthorize("@ss.hasPermi('extra:mes_transpose_material:remove')")
    @DeleteMapping("/{id}")
    open fun delete(@PathVariable("id") id: Long) : AjaxResult =
        toAjax(mesTransposeMaterialService.deleteMesTransposeMaterialById(id))


    /**
     * 批量删除转序物料
     */
    @PreAuthorize("@ss.hasPermi('extra:mes_transpose_material:remove')")
    @DeleteMapping("/{ids}")
    open fun remove(@PathVariable("ids") ids: Array<Long>) : AjaxResult =
        toAjax(mesTransposeMaterialService.deleteMesTransposeMaterialByIds(ids))

}