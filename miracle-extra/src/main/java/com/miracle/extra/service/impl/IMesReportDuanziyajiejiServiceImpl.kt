package com.miracle.extra.service.impl

import com.miracle.extra.domain.MesReportDuanziyajieji
import com.miracle.extra.mapper.MesReportDuanziyajiejiMapper
import com.miracle.extra.service.IMesReportDuanziyajiejiService
import org.springframework.stereotype.Service

/**
 * 端子压接机数据Service业务层处理
 *
 * @author miracle
 * @date 2025-12-22
 */

@Service
class IMesReportDuanziyajiejiServiceImpl(
    private val mesReportDuanziyajiejiMapper : MesReportDuanziyajiejiMapper)
    : IMesReportDuanziyajiejiService
{

    /**
     * 查询端子压接机数据
     *
     * @param id 端子压接机数据主键
     * @return 端子压接机数据
     */
    override fun selectMesReportDuanziyajiejiById(id: Long): MesReportDuanziyajieji? = mesReportDuanziyajiejiMapper.selectMesReportDuanziyajiejiById(id)


    override fun selectMesReportDuanziyajiejiList(mesReportDuanziyajieji: MesReportDuanziyajieji): List<MesReportDuanziyajieji> = mesReportDuanziyajiejiMapper.selectMesReportDuanziyajiejiList(mesReportDuanziyajieji)


    /**
     * 新增端子压接机数据
     *
     * @param mesReportDuanziyajieji 端子压接机数据
     * @return 结果
     */
    override fun insertMesReportDuanziyajieji(mesReportDuanziyajieji: MesReportDuanziyajieji): Int = mesReportDuanziyajiejiMapper.insertMesReportDuanziyajieji(mesReportDuanziyajieji)

    /**
     * 修改端子压接机数据
     *
     * @param mesReportDuanziyajieji 端子压接机数据
     * @return 结果
     */
    override fun updateMesReportDuanziyajieji(mesReportDuanziyajieji: MesReportDuanziyajieji): Int = mesReportDuanziyajiejiMapper.updateMesReportDuanziyajieji(mesReportDuanziyajieji)

    /**
     * 批量删除端子压接机数据
     *
     * @param ids 需要删除的端子压接机数据主键集合
     * @return 结果
     */
    override fun deleteMesReportDuanziyajiejiByIds(ids: Array<Long>): Int = mesReportDuanziyajiejiMapper.deleteMesReportDuanziyajiejiByIds(ids)

    /**
     * 删除端子压接机数据信息
     *
     * @param id 端子压接机数据主键
     * @return 结果
     */
    override fun deleteMesReportDuanziyajiejiById(id: Long): Int = mesReportDuanziyajiejiMapper.deleteMesReportDuanziyajiejiById(id)
}