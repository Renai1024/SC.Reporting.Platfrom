package com.miracle.extra.mapper;

import java.util.List;

import com.miracle.common.annotation.DataSource;
import com.miracle.common.enums.DataSourceType;
import com.miracle.extra.domain.MesWorkshopTranspose;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 车间转序Mapper接口
 *
 * @author miracle
 * @date 2025-12-17
 */
@Mapper
@DataSource(DataSourceType.SLAVE2)
public interface MesWorkshopTransposeMapper
{
    /**
     * 查询车间转序
     *
     * @param id 车间转序主键
     * @return 车间转序
     */
    public MesWorkshopTranspose selectMesWorkshopTransposeById(Long id);

    /**
     * 根据雪花ID查询车间转序
     *
     * @param snowflakeId 雪花ID
     * @return 车间转序
     */
    public MesWorkshopTranspose selectMesWorkshopTransposeBySnowflakeId(String snowflakeId);

    /**
     * 查询车间转序列表
     *
     * @param mesWorkshopTranspose 车间转序
     * @return 车间转序集合
     */
    public List<MesWorkshopTranspose> selectMesWorkshopTransposeList(MesWorkshopTranspose mesWorkshopTranspose);

    /**
     * 根据物料编码查询车间转序列表
     *
     * @param materialCode 物料编码
     * @return 车间转序集合
     */
    public List<MesWorkshopTranspose> selectMesWorkshopTransposeListByMaterialCode(String materialCode);


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

    /**修改数量
     *
     * @param mesWorkshopTranspose 车间转序
     * @return 结果
     */
    public int changeQuantity(MesWorkshopTranspose mesWorkshopTranspose);

    /**
     * 删除车间转序
     *
     * @param id 车间转序主键
     * @return 结果
     */
    public int deleteMesWorkshopTransposeById(Long id);

    /**
     * 批量删除车间转序
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMesWorkshopTransposeByIds(Long[] ids);
}
