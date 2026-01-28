package com.miracle.extra.mapper;

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
interface MesQimixingRecordMapper
{

    /**
     * 查询气密性测试记录列表
     *
     * @param mesQimixingRecord 气密性测试记录
     * @return 气密性测试记录集合
     */
    fun selectMesQimixingRecordList(mesQimixingRecord: MesQimixingRecord): List<MesQimixingRecord>


}
