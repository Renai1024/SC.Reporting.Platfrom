package com.miracle.extra.service.impl;

import java.util.Date;
import java.util.List;
import com.miracle.common.utils.DateUtils;
import com.miracle.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.miracle.extra.mapper.ProdScrewTorqueMapper;
import com.miracle.extra.domain.ProdScrewTorque;
import com.miracle.extra.service.IProdScrewTorqueService;

/**
 * 碳化硅自动锁螺丝数据Service业务层处理
 * 
 * @author miracle
 * @date 2025-10-24
 */
@Service
public class ProdScrewTorqueServiceImpl implements IProdScrewTorqueService 
{
    @Autowired
    private ProdScrewTorqueMapper prodScrewTorqueMapper;

    /**
     * 查询碳化硅自动锁螺丝数据
     * 
     * @param id 碳化硅自动锁螺丝数据主键
     * @return 碳化硅自动锁螺丝数据
     */
    @Override
    public ProdScrewTorque selectProdScrewTorqueById(Long id)
    {
        return prodScrewTorqueMapper.selectProdScrewTorqueById(id);
    }

    /**
     * 查询碳化硅自动锁螺丝数据列表
     * 
     * @param prodScrewTorque 碳化硅自动锁螺丝数据
     * @return 碳化硅自动锁螺丝数据
     */
    @Override
    public List<ProdScrewTorque> selectProdScrewTorqueList(ProdScrewTorque prodScrewTorque)
    {
        return prodScrewTorqueMapper.selectProdScrewTorqueList(prodScrewTorque);
    }

    /**
     * 新增碳化硅自动锁螺丝数据
     * 
     * @param prodScrewTorque 碳化硅自动锁螺丝数据
     * @return 结果
     */
    @Override
    public int insertProdScrewTorque(ProdScrewTorque prodScrewTorque)
    {
        prodScrewTorque.setCreateTime(DateUtils.getNowDate());
        return prodScrewTorqueMapper.insertProdScrewTorque(prodScrewTorque);
    }

    /**
     * 新增碳化硅自动锁螺丝数据
     *
     * @param prodScrewTorqueList 碳化硅自动锁螺丝数据
     * @return 结果
     */
    @Override
    public int insertProdScrewTorqueBatch(List<ProdScrewTorque> prodScrewTorqueList)
    {
        String createBy = SecurityUtils.getLoginUser().getUser().getNickName();
        Date now = DateUtils.getNowDate();
        for (ProdScrewTorque item : prodScrewTorqueList){
            item.setCreateTime(now);
            item.setCreateBy(createBy);
        }
        return prodScrewTorqueMapper.insertProdScrewTorqueBatch(prodScrewTorqueList);
    }

    /**
     * 修改碳化硅自动锁螺丝数据
     * 
     * @param prodScrewTorque 碳化硅自动锁螺丝数据
     * @return 结果
     */
    @Override
    public int updateProdScrewTorque(ProdScrewTorque prodScrewTorque)
    {
        return prodScrewTorqueMapper.updateProdScrewTorque(prodScrewTorque);
    }

    /**
     * 批量删除碳化硅自动锁螺丝数据
     * 
     * @param ids 需要删除的碳化硅自动锁螺丝数据主键
     * @return 结果
     */
    @Override
    public int deleteProdScrewTorqueByIds(Long[] ids)
    {
        return prodScrewTorqueMapper.deleteProdScrewTorqueByIds(ids);
    }

    /**
     * 删除碳化硅自动锁螺丝数据信息
     * 
     * @param id 碳化硅自动锁螺丝数据主键
     * @return 结果
     */
    @Override
    public int deleteProdScrewTorqueById(Long id)
    {
        return prodScrewTorqueMapper.deleteProdScrewTorqueById(id);
    }
}
