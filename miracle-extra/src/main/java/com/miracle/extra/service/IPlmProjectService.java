package com.miracle.extra.service;

import java.util.List;
import com.miracle.extra.domain.PlmProject;
import com.miracle.extra.domain.ProductReportMes;

/**
 * PLM项目Service接口
 * 
 * @author miracle
 * @date 2025-09-10
 */
public interface IPlmProjectService 
{
    /**
     * 查询PLM项目
     * 
     * @param id PLM项目主键
     * @return PLM项目
     */
    public PlmProject selectPlmProjectById(Long id);

    /**
     * 查询PLM项目列表
     * 
     * @param plmProject PLM项目
     * @return PLM项目集合
     */
    public List<PlmProject> selectPlmProjectList(PlmProject plmProject);

    /**
     * 新增PLM项目
     * 
     * @param plmProject PLM项目
     * @return 结果
     */
    public int insertPlmProject(PlmProject plmProject);

    /**
     * 批量新增PLM项目数据
     * @param plmProjectList PLM项目数据集合
     * @return 批量插入结果
     */
    int insertPlmProjectBatch(List<PlmProject> plmProjectList);

    /**
     * 修改PLM项目
     * 
     * @param plmProject PLM项目
     * @return 结果
     */
    public int updatePlmProject(PlmProject plmProject);

    /**
     * 批量删除PLM项目
     * 
     * @param ids 需要删除的PLM项目主键集合
     * @return 结果
     */
    public int deletePlmProjectByIds(Long[] ids);

    /**
     * 删除PLM项目信息
     * 
     * @param id PLM项目主键
     * @return 结果
     */
    public int deletePlmProjectById(Long id);


    int clearAllProjects();

}
