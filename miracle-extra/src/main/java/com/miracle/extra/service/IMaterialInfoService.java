package com.miracle.extra.service;

import java.util.List;
import com.miracle.extra.domain.MaterialInfo;

/**
 * 物料信息Service接口
 * 
 * @author miracle
 * @date 2025-07-27
 */
public interface IMaterialInfoService 
{
    /**
     * 查询物料信息
     * 
     * @param materialId 物料信息主键
     * @return 物料信息
     */
    public MaterialInfo selectMaterialInfoByMaterialId(String materialId);

    /**
     * 查询物料信息列表
     * 
     * @param materialInfo 物料信息
     * @return 物料信息集合
     */
    public List<MaterialInfo> selectMaterialInfoList(MaterialInfo materialInfo);

    /**
     * 根据ids查询物料信息列表
     *
     * @param ids 物料ID集合
     * @return 物料信息集合
     */
    List<MaterialInfo> selectMaterialInfoListByIds(String[] ids);
}
