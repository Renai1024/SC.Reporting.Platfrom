package com.miracle.extra.mapper;

import java.util.List;

import com.miracle.common.annotation.DataSource;
import com.miracle.common.enums.DataSourceType;
import com.miracle.extra.domain.MaterialInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 物料信息Mapper接口
 * 
 * @author miracle
 * @date 2025-07-27
 */
@DataSource(DataSourceType.SLAVE)
@Mapper
public interface MaterialInfoMapper 
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
     * 查询物料信息列表
     * @param ids 物料ID集合
     * @return 物料信息集合
     */
    List<MaterialInfo> selectMaterialInfoListByIds(@Param("ids") String[] ids);
}
