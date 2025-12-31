package com.miracle.extra.mapper;

import java.util.List;

import com.miracle.common.annotation.DataSource;
import com.miracle.common.enums.DataSourceType;
import com.miracle.extra.domain.MesBydlabelprint;
import org.apache.ibatis.annotations.Mapper;

/**
 * bydlabelprintMapper接口
 *
 * @author miracle
 * @date 2025-11-20
 */
@DataSource(value = DataSourceType.SLAVE4)
@Mapper
public interface MesBydlabelprintMapper
{
    /**
     * 查询bydlabelprint
     *
     * @param MaterialCode bydlabelprint主键
     * @return bydlabelprint
     */
    public MesBydlabelprint selectMesBydlabelprintByMaterialCode(String MaterialCode);

    /**
     * 查询bydlabelprint列表
     *
     * @param mesBydlabelprint bydlabelprint
     * @return bydlabelprint集合
     */
    public List<MesBydlabelprint> selectMesBydlabelprintList(MesBydlabelprint mesBydlabelprint);

    /**
     * 新增bydlabelprint
     *
     * @param mesBydlabelprint bydlabelprint
     * @return 结果
     */
    public int insertMesBydlabelprint(MesBydlabelprint mesBydlabelprint);

    /**
     * 修改bydlabelprint
     *
     * @param mesBydlabelprint bydlabelprint
     * @return 结果
     */
    public int updateMesBydlabelprint(MesBydlabelprint mesBydlabelprint);

    /**
     * 删除bydlabelprint
     *
     * @param MaterialCode bydlabelprint主键
     * @return 结果
     */
    public int deleteMesBydlabelprintByMaterialCode(String MaterialCode);

    /**
     * 批量删除bydlabelprint
     *
     * @param MaterialCodes 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMesBydlabelprintByMaterialCodes(String[] MaterialCodes);
}
