package com.miracle.extra.service;

import com.miracle.extra.domain.MesWorkshopTranspose;

/**
 * 车间转序Service接口
 *
 * @author miracle
 * @date 2025-12-17
 */
interface IMesWorkshopTransposeService
{
    /**
     * 查询车间转序
     *
     * @param id 车间转序主键
     * @return 车间转序
     */
    fun selectMesWorkshopTransposeById(id: Long): MesWorkshopTranspose

    /**
     * 查询车间转序列表
     *
     * @param mesWorkshopTranspose 车间转序
     * @return 车间转序集合
     */
    fun selectMesWorkshopTransposeList(mesWorkshopTranspose: MesWorkshopTranspose):List<MesWorkshopTranspose>

    /**
     * 新增车间转序
     *
     * @param mesWorkshopTranspose 车间转序
     * @return 结果
     */
    fun insertMesWorkshopTranspose(mesWorkshopTranspose: MesWorkshopTranspose): Int

    /**
     * 修改车间转序
     *
     * @param mesWorkshopTranspose 车间转序
     * @return 结果
     */
    fun updateMesWorkshopTranspose(mesWorkshopTranspose : MesWorkshopTranspose): Int

    /**
     * 修改数量
     *
     * @param mesWorkshopTranspose 车间转序
     * @return 结果
     */
    fun changeQuantity(mesWorkshopTranspose : MesWorkshopTranspose): Int

    /**
     * 批量删除车间转序
     *
     * @param ids 需要删除的车间转序主键集合
     * @return 结果
     */
    fun deleteMesWorkshopTransposeByIds(ids:Array<Long>): Int

    /**
     * 删除车间转序信息
     *
     * @param id 车间转序主键
     * @return 结果
     */
    fun deleteMesWorkshopTransposeById(id: Long): Int
}
