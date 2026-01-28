package com.miracle.extra.service;

import java.util.List;
import com.miracle.extra.domain.ProductReportMes;

/**
 * MES生产数据Service接口
 * 
 * @author miracle
 * @date 2025-07-31
 */
public interface IProductReportMesService 
{
    /**
     * 查询MES生产数据
     * 
     * @param id MES生产数据主键
     * @return MES生产数据
     */
    public ProductReportMes selectProductReportMesById(Long id);

    /**
     * 查询MES生产数据列表
     * 
     * @param productReportMes MES生产数据
     * @return MES生产数据集合
     */
    public List<ProductReportMes> selectProductReportMesList(ProductReportMes productReportMes);

    /**
     * 查询MES生产数据列表
     *
     * @param ids id集合
     * @return MES生产数据集合
     */
    List<ProductReportMes> selectProductReportMesListByIds(String[] ids);

    /**
     * 新增MES生产数据
     * 
     * @param productReportMes MES生产数据
     * @return 结果
     */
    public int insertProductReportMes(ProductReportMes productReportMes);

    /**
     * 批量新增MES生产数据
     * @param productReportMesList MES生产数据集合
     * @return 结果
     */
    int insertProductReportMesBatch(List<ProductReportMes> productReportMesList);

    /**
     * 修改MES生产数据
     * 
     * @param productReportMes MES生产数据
     * @return 结果
     */
    public int updateProductReportMes(ProductReportMes productReportMes);

    /**
     * 批量删除MES生产数据
     * 
     * @param ids 需要删除的MES生产数据主键集合
     * @return 结果
     */
    public int deleteProductReportMesByIds(Long[] ids);

    /**
     * 删除MES生产数据信息
     * 
     * @param id MES生产数据主键
     * @return 结果
     */
    public int deleteProductReportMesById(Long id);
}
