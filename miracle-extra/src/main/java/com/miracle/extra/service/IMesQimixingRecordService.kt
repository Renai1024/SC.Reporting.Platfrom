package com.miracle.extra.service;

import com.miracle.extra.domain.MesQimixingRecord;

/**
 * 气密性测试记录Service接口
 *
 * @author miracle
 * @date 2025-12-04
 */
interface IMesQimixingRecordService
{
    /**
     * 查询气密性测试记录列表
     *
     * @param mesQimixingRecord 气密性测试记录
     * @return 气密性测试记录集合
     */
    fun selectMesQimixingRecordList(mesQimixingRecord: MesQimixingRecord): List<MesQimixingRecord>
}
