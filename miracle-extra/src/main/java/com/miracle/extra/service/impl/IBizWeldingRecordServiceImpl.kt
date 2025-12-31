package com.miracle.extra.service.impl;

import java.util.Date;

import com.miracle.common.utils.DateUtils;
import com.miracle.common.utils.SecurityUtils;
import org.springframework.stereotype.Service;
import com.miracle.extra.mapper.BizWeldingRecordMapper;
import com.miracle.extra.domain.BizWeldingRecord;
import com.miracle.extra.service.IBizWeldingRecordService;

/**
 * 焊接结果记录Service业务层处理
 *
 * @author miracle
 * @date 2025-10-30
 */
@Service
class IBizWeldingRecordServiceImpl(
    private val bizWeldingRecordMapper : BizWeldingRecordMapper)
    : IBizWeldingRecordService
{

    /**
     * 查询焊接结果记录
     *
     * @param id 焊接结果记录主键
     * @return 焊接结果记录
     */
    override fun selectBizWeldingRecordById(id : Long) : BizWeldingRecord = bizWeldingRecordMapper.selectBizWeldingRecordById(id);


    /**
     * 查询焊接结果记录列表
     *
     * @param bizWeldingRecord 焊接结果记录
     * @return 焊接结果记录
     */
    override fun selectBizWeldingRecordList(bizWeldingRecord : BizWeldingRecord) : List<BizWeldingRecord> = bizWeldingRecordMapper.selectBizWeldingRecordList(bizWeldingRecord);


    /**
     * 新增焊接结果记录
     *
     * @param bizWeldingRecord 焊接结果记录
     * @return 结果
     */
    override fun insertBizWeldingRecord(bizWeldingRecord : BizWeldingRecord) : Int
    {
        bizWeldingRecord.createTime = DateUtils.getNowDate();
        return bizWeldingRecordMapper.insertBizWeldingRecord(bizWeldingRecord);
    }

    /**
     * 批量新增焊接结果记录
     * @param bizWeldingRecord 焊接结果记录
     * @return 结果
     */

    @Override
    override fun insertBizWeldingRecordBatch(bizWeldingRecord : List<BizWeldingRecord>) : Int {
        val createBy : String = SecurityUtils.getLoginUser().user.nickName
        val now : Date= DateUtils.getNowDate();

        val uniqueRecords = bizWeldingRecord.filter { record ->
            !isExist(record.productCode.toString(), record.weldingTime)
        }
            .map { record ->
                record.apply {
                    this.createTime = now;
                    this.createBy = createBy;
                }
            }
        if( uniqueRecords.isEmpty()) {
            return 0;
        }
        return bizWeldingRecordMapper.insertBizWeldingRecordBatch(uniqueRecords);
    }

    /**
     * 修改焊接结果记录
     *
     * @param bizWeldingRecord 焊接结果记录
     * @return 结果
     */
    @Override
    override fun updateBizWeldingRecord(bizWeldingRecord : BizWeldingRecord) : Int = bizWeldingRecordMapper.updateBizWeldingRecord(bizWeldingRecord);

    /**
     * 批量删除焊接结果记录
     *
     * @param ids 需要删除的焊接结果记录主键
     * @return 结果
     */
    @Override
    override fun deleteBizWeldingRecordByIds(ids : Array<Long>) : Int = bizWeldingRecordMapper.deleteBizWeldingRecordByIds(ids)


    /**
     * 删除焊接结果记录信息
     *
     * @param id 焊接结果记录主键
     * @return 结果
     */
    @Override
    override fun deleteBizWeldingRecordById(id : Long) : Int = bizWeldingRecordMapper.deleteBizWeldingRecordById(id);

    /**
     * 判断组合字段是否存在
     * @param productCode 产品码
     * @param weldingTime 焊接时间
     * @return 存在返回true，不存在返回false
     */
    private fun isExist(productCode: String, weldingTime: Date?) : Boolean {
        if (productCode == null || weldingTime == null) {
            return false;
        }
        val query : BizWeldingRecord = BizWeldingRecord().apply {
            this.productCode = productCode
            this.weldingTime = weldingTime
        }
        val existingRecords = bizWeldingRecordMapper.selectBizWeldingRecordList(query)
        return existingRecords.isNotEmpty()
    }
}
