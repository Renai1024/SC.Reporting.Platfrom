package com.miracle.extra.mapper;

import java.util.List;
import com.miracle.extra.domain.ProdScrewTorque;
import org.apache.ibatis.annotations.Mapper;

/**
 * 碳化硅自动锁螺丝数据Mapper接口
 * 
 * @author miracle
 * @date 2025-10-24
 */
@Mapper
public interface ProdScrewTorqueMapper 
{
    /**
     * 查询碳化硅自动锁螺丝数据
     * 
     * @param id 碳化硅自动锁螺丝数据主键
     * @return 碳化硅自动锁螺丝数据
     */
    public ProdScrewTorque selectProdScrewTorqueById(Long id);

    /**
     * 查询碳化硅自动锁螺丝数据列表
     * 
     * @param prodScrewTorque 碳化硅自动锁螺丝数据
     * @return 碳化硅自动锁螺丝数据集合
     */
    public List<ProdScrewTorque> selectProdScrewTorqueList(ProdScrewTorque prodScrewTorque);

    /**
     * 新增碳化硅自动锁螺丝数据
     * 
     * @param prodScrewTorque 碳化硅自动锁螺丝数据
     * @return 结果
     */
    public int insertProdScrewTorque(ProdScrewTorque prodScrewTorque);

    /**
     * 批量新增碳化硅自动锁螺丝数据
     *
     * @param prodScrewTorqueList 碳化硅自动锁螺丝数据
     * @return 批量结果
     */
    public int insertProdScrewTorqueBatch(List<ProdScrewTorque> prodScrewTorqueList);

    /**
     * 修改碳化硅自动锁螺丝数据
     * 
     * @param prodScrewTorque 碳化硅自动锁螺丝数据
     * @return 结果
     */
    public int updateProdScrewTorque(ProdScrewTorque prodScrewTorque);

    /**
     * 删除碳化硅自动锁螺丝数据
     * 
     * @param id 碳化硅自动锁螺丝数据主键
     * @return 结果
     */
    public int deleteProdScrewTorqueById(Long id);

    /**
     * 批量删除碳化硅自动锁螺丝数据
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteProdScrewTorqueByIds(Long[] ids);
}
