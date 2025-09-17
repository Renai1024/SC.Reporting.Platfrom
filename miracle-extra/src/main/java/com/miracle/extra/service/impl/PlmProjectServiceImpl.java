package com.miracle.extra.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.miracle.extra.mapper.PlmProjectMapper;
import com.miracle.extra.domain.PlmProject;
import com.miracle.extra.service.IPlmProjectService;

/**
 * PLM项目Service业务层处理
 * 
 * @author miracle
 * @date 2025-09-10
 */
@Service
public class PlmProjectServiceImpl implements IPlmProjectService 
{
    @Autowired
    private PlmProjectMapper plmProjectMapper;

    /**
     * 查询PLM项目
     * 
     * @param id PLM项目主键
     * @return PLM项目
     */
    @Override
    public PlmProject selectPlmProjectById(Long id)
    {
        return plmProjectMapper.selectPlmProjectById(id);
    }

    /**
     * 查询PLM项目列表
     * 
     * @param plmProject PLM项目
     * @return PLM项目
     */
    @Override
    public List<PlmProject> selectPlmProjectList(PlmProject plmProject)
    {
        return plmProjectMapper.selectPlmProjectList(plmProject);
    }

    /**
     * 新增PLM项目
     * 
     * @param plmProject PLM项目
     * @return 结果
     */
    @Override
    public int insertPlmProject(PlmProject plmProject)
    {
        return plmProjectMapper.insertPlmProject(plmProject);
    }

    /**
     * 批量新增PLM项目
     *
     * @param plmProjectList PLM项目集合
     * @return 结果
     */
    @Override
    public int insertPlmProjectBatch(List<PlmProject> plmProjectList) {
        return plmProjectMapper.insertPlmProjectBatch(plmProjectList);
    }

    /**
     * 修改PLM项目
     * 
     * @param plmProject PLM项目
     * @return 结果
     */
    @Override
    public int updatePlmProject(PlmProject plmProject)
    {
        return plmProjectMapper.updatePlmProject(plmProject);
    }

    /**
     * 批量删除PLM项目
     * 
     * @param ids 需要删除的PLM项目主键
     * @return 结果
     */
    @Override
    public int deletePlmProjectByIds(Long[] ids)
    {
        return plmProjectMapper.deletePlmProjectByIds(ids);
    }

    /**
     * 删除PLM项目信息
     * 
     * @param id PLM项目主键
     * @return 结果
     */
    @Override
    public int deletePlmProjectById(Long id)
    {
        return plmProjectMapper.deletePlmProjectById(id);
    }

    /**
     * 全量删除PLM项目信息
     *
     * @return 结果
     */
    @Override
    public int clearAllProjects() {
        return plmProjectMapper.clearAllProjects();
    }
}
