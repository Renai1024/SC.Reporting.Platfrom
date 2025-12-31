package com.miracle.extra.mapper;

import java.util.List;

import com.miracle.common.annotation.DataSource;
import com.miracle.common.enums.DataSourceType;
import com.miracle.extra.domain.MesBydlabelscan;
import org.apache.ibatis.annotations.Mapper;

/**
 * bydlabelscanMapper接口
 *
 * @author miracle
 * @date 2025-11-20
 */
@Mapper
@DataSource(value = DataSourceType.SLAVE4)
public interface MesBydlabelscanMapper
{
    /**
     * 查询bydlabelscan
     *
     * @param materialCode bydlabelscan主键
     * @return bydlabelscan
     */
    public MesBydlabelscan selectMesBydlabelscanByMaterialCode(String materialCode);

    /**
     * 查询bydlabelscan列表
     *
     * @param mesBydlabelscan bydlabelscan
     * @return bydlabelscan集合
     */
    public List<MesBydlabelscan> selectMesBydlabelscanList(MesBydlabelscan mesBydlabelscan);

    /**
     * 新增bydlabelscan
     *
     * @param mesBydlabelscan bydlabelscan
     * @return 结果
     */
    public int insertMesBydlabelscan(MesBydlabelscan mesBydlabelscan);

    /**
     * 修改bydlabelscan
     *
     * @param mesBydlabelscan bydlabelscan
     * @return 结果
     */
    public int updateMesBydlabelscan(MesBydlabelscan mesBydlabelscan);

    /**
     * 删除bydlabelscan
     *
     * @param materialCode bydlabelscan主键
     * @return 结果
     */
    public int deleteMesBydlabelscanByMaterialCode(String materialCode);

    /**
     * 批量删除bydlabelscan
     *
     * @param materialCodes 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMesBydlabelscanByMaterialCodes(String[] materialCodes);
}
