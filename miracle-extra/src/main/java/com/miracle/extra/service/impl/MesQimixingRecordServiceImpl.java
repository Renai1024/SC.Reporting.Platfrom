package com.miracle.extra.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.miracle.extra.mapper.MesQimixingRecordMapper;
import com.miracle.extra.domain.MesQimixingRecord;
import com.miracle.extra.service.IMesQimixingRecordService;

/**
 * 气密性测试记录Service业务层处理
 * 
 * @author miracle
 * @date 2025-12-04
 */
@Service
public class MesQimixingRecordServiceImpl implements IMesQimixingRecordService 
{
    @Autowired
    private MesQimixingRecordMapper mesQimixingRecordMapper;

    /**
     * 查询气密性测试记录
     * 
     * @param id 气密性测试记录主键
     * @return 气密性测试记录
     */
    @Override
    public MesQimixingRecord selectMesQimixingRecordById(Long id)
    {
        return mesQimixingRecordMapper.selectMesQimixingRecordById(id);
    }

    /**
     * 查询气密性测试记录列表
     * 
     * @param mesQimixingRecord 气密性测试记录
     * @return 气密性测试记录
     */
    @Override
    public List<MesQimixingRecord> selectMesQimixingRecordList(MesQimixingRecord mesQimixingRecord)
    {
        return mesQimixingRecordMapper.selectMesQimixingRecordList(mesQimixingRecord);
    }

    /**
     * 新增气密性测试记录
     * 
     * @param mesQimixingRecord 气密性测试记录
     * @return 结果
     */
    @Override
    public int insertMesQimixingRecord(MesQimixingRecord mesQimixingRecord)
    {
        return mesQimixingRecordMapper.insertMesQimixingRecord(mesQimixingRecord);
    }

    /**
     * 修改气密性测试记录
     * 
     * @param mesQimixingRecord 气密性测试记录
     * @return 结果
     */
    @Override
    public int updateMesQimixingRecord(MesQimixingRecord mesQimixingRecord)
    {
        return mesQimixingRecordMapper.updateMesQimixingRecord(mesQimixingRecord);
    }

    /**
     * 批量删除气密性测试记录
     * 
     * @param ids 需要删除的气密性测试记录主键
     * @return 结果
     */
    @Override
    public int deleteMesQimixingRecordByIds(Long[] ids)
    {
        return mesQimixingRecordMapper.deleteMesQimixingRecordByIds(ids);
    }

    /**
     * 删除气密性测试记录信息
     * 
     * @param id 气密性测试记录主键
     * @return 结果
     */
    @Override
    public int deleteMesQimixingRecordById(Long id)
    {
        return mesQimixingRecordMapper.deleteMesQimixingRecordById(id);
    }
}
