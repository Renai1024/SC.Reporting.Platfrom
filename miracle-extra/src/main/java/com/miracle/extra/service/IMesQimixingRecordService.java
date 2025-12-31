package com.miracle.extra.service;

import java.util.List;
import com.miracle.extra.domain.MesQimixingRecord;

/**
 * 气密性测试记录Service接口
 * 
 * @author miracle
 * @date 2025-12-04
 */
public interface IMesQimixingRecordService 
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
     * 批量删除气密性测试记录
     * 
     * @param ids 需要删除的气密性测试记录主键集合
     * @return 结果
     */
    public int deleteMesQimixingRecordByIds(Long[] ids);

    /**
     * 删除气密性测试记录信息
     * 
     * @param id 气密性测试记录主键
     * @return 结果
     */
    public int deleteMesQimixingRecordById(Long id);
}
