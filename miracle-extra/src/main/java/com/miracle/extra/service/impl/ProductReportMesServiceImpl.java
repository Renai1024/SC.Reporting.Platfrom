package com.miracle.extra.service.impl;

import java.util.Date;
import java.util.List;
import com.miracle.common.utils.DateUtils;
import com.miracle.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.miracle.extra.mapper.ProductReportMesMapper;
import com.miracle.extra.domain.ProductReportMes;
import com.miracle.extra.service.IProductReportMesService;

/**
 * MES生产数据Service业务层处理
 * 
 * @author miracle
 * @date 2025-07-31
 */
@Service
public class ProductReportMesServiceImpl implements IProductReportMesService 
{
    @Autowired
    private ProductReportMesMapper productReportMesMapper;

    /**
     * 查询MES生产数据
     * 
     * @param id MES生产数据主键
     * @return MES生产数据
     */
    @Override
    public ProductReportMes selectProductReportMesById(Long id)
    {
        return productReportMesMapper.selectProductReportMesById(id);
    }

    /**
     * 查询MES生产数据列表
     * 
     * @param productReportMes MES生产数据
     * @return MES生产数据
     */
    @Override
    public List<ProductReportMes> selectProductReportMesList(ProductReportMes productReportMes)
    {
        return productReportMesMapper.selectProductReportMesList(productReportMes);
    }

    @Override
    public List<ProductReportMes> selectProductReportMesListByIds(String[] ids) {
        return productReportMesMapper.selectProductReportMesListByIds(ids);
    }

    /**
     * 新增MES生产数据
     * 
     * @param productReportMes MES生产数据
     * @return 结果
     */
    @Override
    public int insertProductReportMes(ProductReportMes productReportMes)
    {
        String createBy = SecurityUtils.getLoginUser().getUser().getNickName();
        Date now = DateUtils.getNowDate();
        productReportMes.setCreateBy(createBy);
        productReportMes.setCreateTime(now);
        productReportMes.setUpdateBy(createBy);
        productReportMes.setUpdateTime(now);
        return productReportMesMapper.insertProductReportMes(productReportMes);
    }

    @Override
    public int insertProductReportMesBatch(List<ProductReportMes> productReportMesList) {
        String createBy = SecurityUtils.getLoginUser().getUser().getNickName();
        Date now = DateUtils.getNowDate();
        for (ProductReportMes item : productReportMesList){
            item.setCreateBy(createBy);
            item.setCreateTime(now);
            item.setUpdateTime(now);
            item.setUpdateBy(createBy);
        }
        return productReportMesMapper.insertProductReportMesBatch(productReportMesList);
    }

    /**
     * 修改MES生产数据
     * 
     * @param productReportMes MES生产数据
     * @return 结果
     */
    @Override
    public int updateProductReportMes(ProductReportMes productReportMes)
    {
        String updateBy = SecurityUtils.getLoginUser().getUser().getNickName();
        productReportMes.setUpdateTime(DateUtils.getNowDate());
        productReportMes.setUpdateBy(updateBy);
        return productReportMesMapper.updateProductReportMes(productReportMes);
    }

    /**
     * 批量删除MES生产数据
     * 
     * @param ids 需要删除的MES生产数据主键
     * @return 结果
     */
    @Override
    public int deleteProductReportMesByIds(Long[] ids)
    {
        return productReportMesMapper.deleteProductReportMesByIds(ids);
    }

    /**
     * 删除MES生产数据信息
     * 
     * @param id MES生产数据主键
     * @return 结果
     */
    @Override
    public int deleteProductReportMesById(Long id)
    {
        return productReportMesMapper.deleteProductReportMesById(id);
    }
}
