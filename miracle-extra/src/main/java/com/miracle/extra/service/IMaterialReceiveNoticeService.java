package com.miracle.extra.service;

import java.util.List;
import com.miracle.extra.domain.MaterialReceiveNotice;

/**
 * 收料通知单Service接口
 * 
 * @author miracle
 * @date 2025-09-03
 */
public interface IMaterialReceiveNoticeService 
{
    /**
     * 查询收料通知单
     * 
     * @param fentryId 收料通知单主键
     * @return 收料通知单
     */
    public MaterialReceiveNotice selectMaterialReceiveNoticeByFENTRYID(Long fentryId);


    /**
     * 查询收料通知单ByIds
     * @param fentryIds
     * @return 收料通知单行数据
     */
    public List<MaterialReceiveNotice> selectMaterialReceiveNoticeByFENTRYIDs(String[] fentryIds);

    /**
     * 查询收料通知单列表
     * 
     * @param materialReceiveNotice 收料通知单
     * @return 收料通知单集合
     */
    public List<MaterialReceiveNotice> selectMaterialReceiveNoticeList(MaterialReceiveNotice materialReceiveNotice);

    /**
     * 新增收料通知单
     * 
     * @param materialReceiveNotice 收料通知单
     * @return 结果
     */
    public int insertMaterialReceiveNotice(MaterialReceiveNotice materialReceiveNotice);

    /**
     * 修改收料通知单
     * 
     * @param materialReceiveNotice 收料通知单
     * @return 结果
     */
    public int updateMaterialReceiveNotice(MaterialReceiveNotice materialReceiveNotice);

    /**
     * 批量删除收料通知单
     * 
     * @param fentryIds 需要删除的收料通知单主键集合
     * @return 结果
     */
    public int deleteMaterialReceiveNoticeByFENTRYIDs(Long[] fentryIds);

    /**
     * 删除收料通知单信息
     * 
     * @param fentryId 收料通知单主键
     * @return 结果
     */
    public int deleteMaterialReceiveNoticeByFENTRYID(Long fentryId);
}
