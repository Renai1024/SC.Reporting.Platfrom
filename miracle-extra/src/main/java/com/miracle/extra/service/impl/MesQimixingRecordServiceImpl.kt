package com.miracle.extra.service.impl;

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
class MesQimixingRecordServiceImpl(
    private val mesQimixingRecordMapper: MesQimixingRecordMapper
) : IMesQimixingRecordService
{

    /**
     * 查询气密性测试记录列表
     *
     * @param mesQimixingRecord 气密性测试记录
     * @return 气密性测试记录
     */
    override fun selectMesQimixingRecordList(mesQimixingRecord: MesQimixingRecord): List<MesQimixingRecord> = mesQimixingRecordMapper.selectMesQimixingRecordList(mesQimixingRecord)


}
