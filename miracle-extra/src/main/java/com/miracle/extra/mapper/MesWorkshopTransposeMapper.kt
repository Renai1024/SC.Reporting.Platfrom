package com.miracle.extra.mapper;
import com.miracle.common.annotation.DataSource;
import com.miracle.common.enums.DataSourceType;
import com.miracle.extra.domain.MesWorkshopTranspose;
import org.apache.ibatis.annotations.Mapper;

/**
 * 车间转序Mapper接口
 *
 * @author miracle
 * @date 2025-12-17
 */
@Mapper
@DataSource(DataSourceType.SLAVE2)
interface MesWorkshopTransposeMapper
{
    /**
     * 查询车间转序
     *
     * @param id 车间转序主键
     * @return 车间转序
     */
    fun selectMesWorkshopTransposeById(id: Long): MesWorkshopTranspose

    /**
     * 根据雪花ID查询车间转序
     *
     * @param snowflakeId 雪花ID
     * @return 车间转序
     */
    fun selectMesWorkshopTransposeBySnowflakeId(snowflakeId: String): MesWorkshopTranspose;

    /**
     * 查询车间转序列表
     *
     * @param mesWorkshopTranspose 车间转序
     * @return 车间转序集合
     */
    fun selectMesWorkshopTransposeList(mesWorkshopTranspose: MesWorkshopTranspose): List<MesWorkshopTranspose>

    /**
     * 根据物料编码查询车间转序列表
     *
     * @param materialCode 物料编码
     * @return 车间转序集合
     */
    fun selectMesWorkshopTransposeListByMaterialCode(materialCode: String): List<MesWorkshopTranspose>


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
    fun updateMesWorkshopTranspose(mesWorkshopTranspose: MesWorkshopTranspose): Int

    /**修改数量
     *
     * @param mesWorkshopTranspose 车间转序
     * @return 结果
     */
    fun changeQuantity(mesWorkshopTranspose: MesWorkshopTranspose): Int

    /**
     * 删除车间转序
     *
     * @param id 车间转序主键
     * @return 结果
     */
    fun deleteMesWorkshopTransposeById(id: Long): Int

    /**
     * 批量删除车间转序
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    fun deleteMesWorkshopTransposeByIds(ids: Array<Long>): Int;
}
