package com.miracle.extra.mapper;

import com.miracle.common.annotation.DataSource;
import com.miracle.common.enums.DataSourceType;
import com.miracle.extra.domain.ErpInfo
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
@DataSource(DataSourceType.SLAVE)
interface ErpInfoMapper {


    /**
     * 查询所有员工列表
     * @return
     */
    fun selectWorkerList(erpInfo : ErpInfo) : List<ErpInfo>

    /**
     * 查询所有车间列表
     * @return
     */
    fun selectWorkshopList(erpInfo: ErpInfo) : List<ErpInfo>

    /**
     * 搜索车间列表
     * @param searchText 搜索关键字
     * @return
     */
    fun searchWorkshop(@Param("searchText") searchText : String?): List<ErpInfo>

    /**
     * 搜索员工列表
     * @param searchText 搜索关键字
     * @return
     */
    fun searchWorker(@Param("searchText") searchText : String?): List<ErpInfo>;

    /**
     * 搜索物料列表
     * @param searchText 搜索关键字
     * @return
     */
    fun searchMaterial(@Param("searchText") searchText: String?) : List<ErpInfo>;


    /**
     * 根据车间编码查询转序明细列表
     *
     * @param workshopCode 车间编码
     * @return 转序明细集合
     */
    fun selectWorkshopByCode(workshopCode: String?) : List<ErpInfo>;

    /**
     * 根据车间名称查询转序明细列表
     *
     * @param workshopName 车间名称
     * @return 转序明细集合
     */
    fun selectWorkshopByName(workshopName : String?): List<ErpInfo>;

    /**
     * 根据员工编码查询转序明细列表
     *
     * @param workerCode 员工编码
     * @return 转序明细集合
     */
    fun selectWorkerByCode(workerCode: String?): List<ErpInfo>;

    /**
     * 根据员工名称查询转序明细列表
     *
     * @param workerName 员工名称
     * @return 转序明细集合
     */
    fun selectWorkerByName(workerName: String?): List<ErpInfo>;

    /**
     * 根据物料编码查询转序明细列表
     *
     * @param materialCode 物料编码
     * @return 转序明细集合
     */
    fun selectMaterialByCode(materialCode: String?): List<ErpInfo>;

    /**
     * 根据物料名称查询转序明细列表
     *
     * @param materialName 物料名称
     * @return 转序明细集合
     */
    fun selectMaterialByName(materialName: String?): List<ErpInfo>;
}
