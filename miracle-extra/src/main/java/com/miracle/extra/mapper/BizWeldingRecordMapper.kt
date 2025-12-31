package com.miracle.extra.mapper;

import com.miracle.extra.domain.BizWeldingRecord;
import org.apache.ibatis.annotations.Mapper;

/**
 * 焊接结果记录Mapper接口
 *
 * @author miracle
 * @date 2025-10-30
 */
@Mapper
interface BizWeldingRecordMapper
{
    /**
     * 查询焊接结果记录
     *
     * @param id 焊接结果记录主键
     * @return 焊接结果记录
     */
    fun selectBizWeldingRecordById(id : Long) : BizWeldingRecord;

    /**
     * 查询焊接结果记录列表
     *
     * @param bizWeldingRecord 焊接结果记录
     * @return 焊接结果记录集合
     */
    fun selectBizWeldingRecordList(bizWeldingRecord : BizWeldingRecord) : List<BizWeldingRecord>;

    /**
     * 新增焊接结果记录
     *
     * @param bizWeldingRecord 焊接结果记录
     * @return 结果
     */
    fun insertBizWeldingRecord(bizWeldingRecord : BizWeldingRecord) : Int;

    /** 批量新增焊接结果记录
     *
     * @param bizWeldingRecordList 焊接结果记录集合
     * @return 结果
     */

    fun insertBizWeldingRecordBatch(bizWeldingRecordList :List<BizWeldingRecord>) : Int;

    /**
     * 修改焊接结果记录
     *
     * @param bizWeldingRecord 焊接结果记录
     * @return 结果
     */
    fun updateBizWeldingRecord(bizWeldingRecord : BizWeldingRecord) : Int;

    /**
     * 删除焊接结果记录
     *
     * @param id 焊接结果记录主键
     * @return 结果
     */
    fun deleteBizWeldingRecordById(id : Long) : Int;

    /**
     * 批量删除焊接结果记录
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    fun deleteBizWeldingRecordByIds(ids : Array<Long>) : Int;
}
