package com.miracle.extra.service;

import java.util.List;
import com.miracle.extra.domain.MesWorkshopTranspose;

/**
 * 车间转序Service接口
 *
 * @author miracle
 * @date 2025-12-17
 */
public interface IMesWorkshopTransposeService
{
    /**
     * 查询车间转序
     *
     * @param id 车间转序主键
     * @return 车间转序
     */
    public MesWorkshopTranspose selectMesWorkshopTransposeById(Long id);

    /**
     * 查询车间转序列表
     *
     * @param mesWorkshopTranspose 车间转序
     * @return 车间转序集合
     */
    public List<MesWorkshopTranspose> selectMesWorkshopTransposeList(MesWorkshopTranspose mesWorkshopTranspose);

    /**
     * 新增车间转序
     *
     * @param mesWorkshopTranspose 车间转序
     * @return 结果
     */
    public int insertMesWorkshopTranspose(MesWorkshopTranspose mesWorkshopTranspose);

    /**
     * 修改车间转序
     *
     * @param mesWorkshopTranspose 车间转序
     * @return 结果
     */
    public int updateMesWorkshopTranspose(MesWorkshopTranspose mesWorkshopTranspose);

    /**
     * 修改数量
     *
     * @param mesWorkshopTranspose 车间转序
     * @return 结果
     */
    public int changeQuantity(MesWorkshopTranspose mesWorkshopTranspose);

    /**
     * 批量删除车间转序
     *
     * @param ids 需要删除的车间转序主键集合
     * @return 结果
     */
    public int deleteMesWorkshopTransposeByIds(Long[] ids);

    /**
     * 删除车间转序信息
     *
     * @param id 车间转序主键
     * @return 结果
     */
    public int deleteMesWorkshopTransposeById(Long id);
}
