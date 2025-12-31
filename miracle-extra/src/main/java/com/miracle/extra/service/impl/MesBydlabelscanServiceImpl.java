package com.miracle.extra.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.miracle.extra.mapper.MesBydlabelscanMapper;
import com.miracle.extra.domain.MesBydlabelscan;
import com.miracle.extra.service.IMesBydlabelscanService;

/**
 * bydlabelscanService业务层处理
 * 
 * @author miracle
 * @date 2025-11-20
 */
@Service
public class MesBydlabelscanServiceImpl implements IMesBydlabelscanService 
{
    @Autowired
    private MesBydlabelscanMapper mesBydlabelscanMapper;

    /**
     * 查询bydlabelscan
     * 
     * @param materialCode bydlabelscan主键
     * @return bydlabelscan
     */
    @Override
    public MesBydlabelscan selectMesBydlabelscanByMaterialCode(String materialCode)
    {
        return mesBydlabelscanMapper.selectMesBydlabelscanByMaterialCode(materialCode);
    }

    /**
     * 查询bydlabelscan列表
     * 
     * @param mesBydlabelscan bydlabelscan
     * @return bydlabelscan
     */
    @Override
    public List<MesBydlabelscan> selectMesBydlabelscanList(MesBydlabelscan mesBydlabelscan)
    {
        return mesBydlabelscanMapper.selectMesBydlabelscanList(mesBydlabelscan);
    }

    /**
     * 新增bydlabelscan
     * 
     * @param mesBydlabelscan bydlabelscan
     * @return 结果
     */
    @Override
    public int insertMesBydlabelscan(MesBydlabelscan mesBydlabelscan)
    {
        return mesBydlabelscanMapper.insertMesBydlabelscan(mesBydlabelscan);
    }

    /**
     * 修改bydlabelscan
     * 
     * @param mesBydlabelscan bydlabelscan
     * @return 结果
     */
    @Override
    public int updateMesBydlabelscan(MesBydlabelscan mesBydlabelscan)
    {
        return mesBydlabelscanMapper.updateMesBydlabelscan(mesBydlabelscan);
    }

    /**
     * 批量删除bydlabelscan
     * 
     * @param materialCodes 需要删除的bydlabelscan主键
     * @return 结果
     */
    @Override
    public int deleteMesBydlabelscanByMaterialCodes(String[] materialCodes)
    {
        return mesBydlabelscanMapper.deleteMesBydlabelscanByMaterialCodes(materialCodes);
    }

    /**
     * 删除bydlabelscan信息
     * 
     * @param materialCode bydlabelscan主键
     * @return 结果
     */
    @Override
    public int deleteMesBydlabelscanByMaterialCode(String materialCode)
    {
        return mesBydlabelscanMapper.deleteMesBydlabelscanByMaterialCode(materialCode);
    }
}
