package com.miracle.extra.service;

import com.miracle.extra.domain.BizWeldingRecord;

/**
 * 焊接结果记录Service接口
 *
 * @author miracle
 * @date 2025-10-30
 */
interface IBizWeldingRecordService
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

    /**
     * 批量新增焊接结果记录
     *
     * @param bizWeldingRecord 焊接结果记录
     * @return 结果
     */

    fun insertBizWeldingRecordBatch(bizWeldingRecord : List<BizWeldingRecord>) : Int;

    /**
     * 修改焊接结果记录
     *
     * @param bizWeldingRecord 焊接结果记录
     * @return 结果
     */
    fun updateBizWeldingRecord(bizWeldingRecord :BizWeldingRecord) : Int;

    /**
     * 批量删除焊接结果记录
     *
     * @param ids 需要删除的焊接结果记录主键集合
     * @return 结果
     */
    fun deleteBizWeldingRecordByIds(ids : Array<Long>) : Int;

    /**
     * 删除焊接结果记录信息
     *
     * @param id 焊接结果记录主键
     * @return 结果
     */
    fun deleteBizWeldingRecordById(id :  Long) : Int;
}
