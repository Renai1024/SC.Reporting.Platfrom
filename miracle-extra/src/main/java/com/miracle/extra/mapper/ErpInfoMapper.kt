package com.miracle.extra.mapper;

import com.miracle.common.annotation.DataSource;
import com.miracle.common.enums.DataSourceType;
import com.miracle.extra.domain.ErpInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
@DataSource(DataSourceType.SLAVE)
public interface ErpInfoMapper {


    /**
     * 查询所有员工列表
     * @return
     */
    public List<ErpInfo> selectWorkerList(ErpInfo erpInfo);

    /**
     * 查询所有车间列表
     * @return
     */
    public List<ErpInfo> selectWorkshopList(ErpInfo erpInfo);

    /**
     * 搜索车间列表
     * @param searchText 搜索关键字
     * @return
     */
    public List<ErpInfo> searchWorkshop(@Param("searchText") String searchText);

    /**
     * 搜索员工列表
     * @param searchText 搜索关键字
     * @return
     */
    public List<ErpInfo> searchWorker(@Param("searchText") String searchText);

    /**
     * 搜索物料列表
     * @param searchText 搜索关键字
     * @return
     */
    public List<ErpInfo> searchMaterial(@Param("searchText") String searchText);


    /**
     * 根据车间编码查询转序明细列表
     *
     * @param workshopCode 车间编码
     * @return 转序明细集合
     */
    public List<ErpInfo> selectWorkshopByCode(String workshopCode);

    /**
     * 根据车间名称查询转序明细列表
     *
     * @param workshopName 车间名称
     * @return 转序明细集合
     */
    public List<ErpInfo> selectWorkshopByName(String workshopName);

    /**
     * 根据员工编码查询转序明细列表
     *
     * @param workerCode 员工编码
     * @return 转序明细集合
     */
    public List<ErpInfo> selectWorkerByCode(String workerCode);

    /**
     * 根据员工名称查询转序明细列表
     *
     * @param workerName 员工名称
     * @return 转序明细集合
     */
    public List<ErpInfo> selectWorkerByName(String workerName);

    /**
     * 根据物料编码查询转序明细列表
     *
     * @param materialCode 物料编码
     * @return 转序明细集合
     */
    public List<ErpInfo> selectMaterialByCode(String materialCode);

    /**
     * 根据物料名称查询转序明细列表
     *
     * @param materialName 物料名称
     * @return 转序明细集合
     */
    public List<ErpInfo> selectMaterialByName(String materialName);
}
