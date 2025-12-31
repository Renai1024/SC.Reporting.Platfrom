package com.miracle.extra.service;

import java.util.List;
import com.miracle.extra.domain.InspectionRecordMES;

/**
 * 检验数据Service接口
 *
 * @author miracle
 * @date 2025-09-24
 */
public interface IInspectionRecordMESService
{
    /**
     * 查询检验数据
     *
     * @param id 检验数据主键
     * @return 检验数据
     */
    public InspectionRecordMES selectInspectionRecordMESById(Long id);

    /**
     * 查询检验数据
     *
     * @param serialNumber 序列号
     * @return 检验数据
     */
    public InspectionRecordMES selectInspectionRecordMESBySerialNumber(String serialNumber);
//
//    /**
//     * 查询检验数据
//     *
//     * @param serialNumber 检验数据主键
//     * @return 检验数据
//     */
//    public InspectionRecordMES selectInspectionRecordMESBySerialNumber1(String serialNumber);
//
//    /**
//     * 查询检验数据
//     *
//     * @param serialNumber 检验数据主键
//     * @return 检验数据
//     */
//    public InspectionRecordMES selectInspectionRecordMESBySerialNumber2(String serialNumber);
//
//    /**
//     * 查询检验数据
//     *
//     * @param serialNumber 检验数据主键
//     * @return 检验数据
//     */
//    public InspectionRecordMES selectInspectionRecordMESBySerialNumber3(String serialNumber);

    /**
     * 查询检验数据列表
     *
     * @param inspectionRecordMES 检验数据
     * @return 检验数据集合
     */
    public List<InspectionRecordMES> selectInspectionRecordMESList(InspectionRecordMES inspectionRecordMES);

    /**
     * 查询已绑箱码检验数据列表
     *
     * @param inspectionRecordMES 检验数据
     * @return 检验数据集合
     */
    public List<InspectionRecordMES> selectInspectionRecordMESListWithBoxCode(InspectionRecordMES inspectionRecordMES);

    /**
     * 新增工序一检验数据
     *
     * @param inspectionRecordMES 检验数据
     * @return 结果
     */
    public int insertInspectionRecordMES1(InspectionRecordMES inspectionRecordMES);

    /**
     * 新增工序二检验数据
     *
     * @param inspectionRecordMES 检验数据
     * @return 结果
     */
    public int insertInspectionRecordMES2(InspectionRecordMES inspectionRecordMES);

    /**
     * 新增工序三检验数据
     *
     * @param inspectionRecordMES 检验数据
     * @return 结果
     */
    public int insertInspectionRecordMES3(InspectionRecordMES inspectionRecordMES);

    /**
     * 修改检验数据
     *
     * @param inspectionRecordMES 检验数据
     * @return 结果
     */
    public int updateInspectionRecordMES(InspectionRecordMES inspectionRecordMES);

    /**
     * 箱码绑定
     * @author miracle
     * @param boxCode 箱码
     * @param serialNumbers 序列号集合
     * @return 结果
     */
    public int updateInspectionRecordMES(String[] serialNumbers, String boxCode);

    /**
     * 客户箱码绑定
     * @author miracle
     * @param boxCode 箱码
     * @param customerBoxCode 客户箱码
     * @return 结果
     */
    public int updateInspectionRecordMES(String boxCode, String customerBoxCode);

    /**
     * 批量删除检验数据
     *
     * @param ids 需要删除的检验数据主键集合
     * @return 结果
     */
    public int deleteInspectionRecordMESByIds(Long[] ids);

    /**
     * 删除检验数据信息
     *
     * @param id 检验数据主键
     * @return 结果
     */
    public int deleteInspectionRecordMESById(Long id);
}
