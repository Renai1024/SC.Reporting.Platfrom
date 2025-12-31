package com.miracle.extra.service;

import java.util.List;
import com.miracle.extra.domain.MesBydlabelscan;

/**
 * bydlabelscanService接口
 * 
 * @author miracle
 * @date 2025-11-20
 */
public interface IMesBydlabelscanService 
{
    /**
     * 查询bydlabelscan
     * 
     * @param materialCode bydlabelscan主键
     * @return bydlabelscan
     */
    public MesBydlabelscan selectMesBydlabelscanByMaterialCode(String materialCode);

    /**
     * 查询bydlabelscan列表
     * 
     * @param mesBydlabelscan bydlabelscan
     * @return bydlabelscan集合
     */
    public List<MesBydlabelscan> selectMesBydlabelscanList(MesBydlabelscan mesBydlabelscan);

    /**
     * 新增bydlabelscan
     * 
     * @param mesBydlabelscan bydlabelscan
     * @return 结果
     */
    public int insertMesBydlabelscan(MesBydlabelscan mesBydlabelscan);

    /**
     * 修改bydlabelscan
     * 
     * @param mesBydlabelscan bydlabelscan
     * @return 结果
     */
    public int updateMesBydlabelscan(MesBydlabelscan mesBydlabelscan);

    /**
     * 批量删除bydlabelscan
     * 
     * @param materialCodes 需要删除的bydlabelscan主键集合
     * @return 结果
     */
    public int deleteMesBydlabelscanByMaterialCodes(String[] materialCodes);

    /**
     * 删除bydlabelscan信息
     * 
     * @param materialCode bydlabelscan主键
     * @return 结果
     */
    public int deleteMesBydlabelscanByMaterialCode(String materialCode);
}
