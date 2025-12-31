package com.miracle.extra.mapper;

import java.util.List;

import com.miracle.common.annotation.DataSource;
import com.miracle.common.enums.DataSourceType;
import com.miracle.extra.domain.MesQimixingRecord;
import org.apache.ibatis.annotations.Mapper;

/**
 * 气密性测试记录Mapper接口
 *
 * @author miracle
 * @date 2025-12-04
 */
@Mapper
@DataSource(DataSourceType.SLAVE5)
public interface MesQimixingRecordMapper
{
    /**
     * 查询气密性测试记录
     *
     * @param id 气密性测试记录主键
     * @return 气密性测试记录
     */
    public MesQimixingRecord selectMesQimixingRecordById(Long id);

    /**
     * 查询气密性测试记录列表
     *
     * @param mesQimixingRecord 气密性测试记录
     * @return 气密性测试记录集合
     */
    public List<MesQimixingRecord> selectMesQimixingRecordList(MesQimixingRecord mesQimixingRecord);

    /**
     * 新增气密性测试记录
     *
     * @param mesQimixingRecord 气密性测试记录
     * @return 结果
     */
    public int insertMesQimixingRecord(MesQimixingRecord mesQimixingRecord);

    /**
     * 修改气密性测试记录
     *
     * @param mesQimixingRecord 气密性测试记录
     * @return 结果
     */
    public int updateMesQimixingRecord(MesQimixingRecord mesQimixingRecord);

    /**
     * 删除气密性测试记录
     *
     * @param id 气密性测试记录主键
     * @return 结果
     */
    public int deleteMesQimixingRecordById(Long id);

    /**
     * 批量删除气密性测试记录
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMesQimixingRecordByIds(Long[] ids);
}
