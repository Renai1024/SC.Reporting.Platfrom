package com.miracle.extra.mapper;

import java.util.Date;
import java.util.List;
import com.miracle.extra.domain.InspectionRecordMES;
import org.apache.ibatis.annotations.Mapper;

/**
 * 检验数据Mapper接口
 *
 * @author miracle
 * @date 2025-09-24
 */
@Mapper
public interface InspectionRecordMESMapper
{
    /**
     * 查询检验数据ById
     *
     * @param id 检验数据主键
     * @return 检验数据
     */
    public InspectionRecordMES selectInspectionRecordMESById(Long id);

    /**
     * 查询检验数据BySerialNumber
     * @param serialNumber 序列号
     * @return 检验数据
     */
    public InspectionRecordMES selectInspectionRecordMESBySerialNumber(String serialNumber);

    /**
     * 查询检验数据BySerialNumber
     *
     * @param serialNumber 检验数据主键
     * @return 检验数据
     */
    public Integer selectInspectionRecordMESBySerialNumberCount(String serialNumber);

    /**
     * 查询检验数据BySerialNumber
     *
     * @param serialNumber 检验数据主键
     * @return 检验数据
     */
    public Integer selectInspectionRecordMESBySerialNumberCount1(String serialNumber);

    /**
     * 查询检验数据BySerialNumber
     *
     * @param serialNumber 检验数据主键
     * @return 检验数据
     */
    public Integer selectInspectionRecordMESBySerialNumberCount2(String serialNumber);

    /**
     * 查询检验数据BySerialNumber
     *
     * @param serialNumber 检验数据主键
     * @return 检验数据
     */
    public Integer selectInspectionRecordMESBySerialNumberCount3(String serialNumber);

    /**
     * 查询检验数据ByBoxCode
     * @param boxCode 箱码
     * @return 结果条数
     */
    public Integer selectInspectionRecordMESByBoxCodeCount(String boxCode);

    /**
     * 查询检验数据ByCustomerBoxCode
     * @param customerBoxCode 箱码
     * @return 结果集合
     */
    public List<InspectionRecordMES> selectInspectionRecordMESByCustomerBoxCode(String customerBoxCode);

    /**
     * 查询检验数据ByBoxCode
     * @param boxCode 箱码
     * @return 结果集合
     */
    public List<InspectionRecordMES> selectInspectionRecordMESByBoxCode(String boxCode);

    /**
     * 查询检验数据列表
     *
     * @param inspectionRecordMES 检验数据
     * @return 检验数据集合
     */
    public List<InspectionRecordMES> selectInspectionRecordMESList(InspectionRecordMES inspectionRecordMES);

    /**
     * 查询已绑定箱码序列号列表
     *
     * @param inspectionRecordMES 检验数据
     * @return 检验数据集合
     */
    public List<InspectionRecordMES> selectInspectionRecordMESListWithBoxCode(InspectionRecordMES inspectionRecordMES);

    /**
     * 新增主表检验数据
     *
     * @param inspectionRecordMES 检验数据
     * @return 结果
     */
    public int insertInspectionRecordMES(InspectionRecordMES inspectionRecordMES);

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
     * 绑定客户箱码
     * @param boxCode 箱码
     * @param customerBoxCode 客户箱码
     * @return 影响行数
     */
    public int updateInspectionRecordMESCustomerBoxCode(String boxCode, String customerBoxCode, Date customerBoxCodeBindTime);


    /**
     * 删除检验数据
     *
     * @param id 检验数据主键
     * @return 结果
     */
    public int deleteInspectionRecordMESById(Long id);

    /**
     * 删除检验数据
     *
     * @param serialNumber 检验数据主键
     * @return 结果
     */
    public int deleteInspectionRecordMESBySerialNumber1(String serialNumber);

    /**
     * 删除检验数据
     *
     * @param serialNumber 检验数据主键
     * @return 结果
     */
    public int deleteInspectionRecordMESBySerialNumber2(String serialNumber);

    /**
     * 删除检验数据
     *
     * @param serialNumber 检验数据主键
     * @return 结果
     */
    public int deleteInspectionRecordMESBySerialNumber3(String serialNumber);

    /**
     * 批量删除检验数据
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteInspectionRecordMESByIds(Long[] ids);
}
