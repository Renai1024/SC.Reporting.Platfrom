package com.miracle.extra.mapper;

import java.util.List;

import com.miracle.common.annotation.DataSource;
import com.miracle.common.enums.DataSourceType;
import com.miracle.extra.domain.PlmProject;
import org.apache.ibatis.annotations.Mapper;

/**
 * PLM项目Mapper接口
 * 
 * @author miracle
 * @date 2025-09-10
 */
@Mapper
@DataSource(DataSourceType.SLAVE2)
public interface PlmProjectMapper 
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
     * 批量新增PLM项目
     * @param plmProjectList PLM项目集合
     * @return 数量
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
     * 删除PLM项目
     * 
     * @param id PLM项目主键
     * @return 结果
     */
    public int deletePlmProjectById(Long id);

    /**
     * 批量删除PLM项目
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePlmProjectByIds(Long[] ids);

    int clearAllProjects();
}
