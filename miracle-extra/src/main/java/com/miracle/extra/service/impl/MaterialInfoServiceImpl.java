package com.miracle.extra.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.miracle.extra.mapper.MaterialInfoMapper;
import com.miracle.extra.domain.MaterialInfo;
import com.miracle.extra.service.IMaterialInfoService;

/**
 * 物料信息Service业务层处理
 * 
 * @author miracle
 * @date 2025-07-27
 */
@Service
public class MaterialInfoServiceImpl implements IMaterialInfoService 
{
    @Autowired
    private MaterialInfoMapper materialInfoMapper;

    /**
     * 查询物料信息
     * 
     * @param materialId 物料信息主键
     * @return 物料信息
     */
    @Override
    public MaterialInfo selectMaterialInfoByMaterialId(String materialId)
    {
        return materialInfoMapper.selectMaterialInfoByMaterialId(materialId);
    }

    /**
     * 查询物料信息列表
     * 
     * @param materialInfo 物料信息
     * @return 物料信息
     */
    @Override
    public List<MaterialInfo> selectMaterialInfoList(MaterialInfo materialInfo)
    {
        return materialInfoMapper.selectMaterialInfoList(materialInfo);
    }

    /**
     * 按物料ID查询物料集合
     *
     * @param ids 物料ID集合
     * @return 物料集合
     */
    @Override
    public List<MaterialInfo> selectMaterialInfoListByIds(String[] ids) {
        return materialInfoMapper.selectMaterialInfoListByIds(ids);
    }
}
