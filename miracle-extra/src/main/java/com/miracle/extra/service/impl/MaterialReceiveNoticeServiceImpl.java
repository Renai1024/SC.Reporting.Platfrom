package com.miracle.extra.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.miracle.extra.mapper.MaterialReceiveNoticeMapper;
import com.miracle.extra.domain.MaterialReceiveNotice;
import com.miracle.extra.service.IMaterialReceiveNoticeService;

/**
 * 收料通知单Service业务层处理
 * 
 * @author miracle
 * @date 2025-09-03
 */
@Service
public class MaterialReceiveNoticeServiceImpl implements IMaterialReceiveNoticeService 
{
    @Autowired
    private MaterialReceiveNoticeMapper materialReceiveNoticeMapper;

    /**
     * 查询收料通知单
     * 
     * @param fentryId 收料通知单主键
     * @return 收料通知单
     */
    @Override
    public MaterialReceiveNotice selectMaterialReceiveNoticeByFENTRYID(Long fentryId)
    {
        return materialReceiveNoticeMapper.selectMaterialReceiveNoticeByFENTRYID(fentryId);
    }

    @Override
    public List<MaterialReceiveNotice> selectMaterialReceiveNoticeByFENTRYIDs(String[] fentryIds) {
        return materialReceiveNoticeMapper.selectMaterialReceiveNoticeByFENTRYIDs(fentryIds);
    }

    /**
     * 查询收料通知单列表
     * 
     * @param materialReceiveNotice 收料通知单
     * @return 收料通知单
     */
    @Override
    public List<MaterialReceiveNotice> selectMaterialReceiveNoticeList(MaterialReceiveNotice materialReceiveNotice)
    {
        return materialReceiveNoticeMapper.selectMaterialReceiveNoticeList(materialReceiveNotice);
    }

    /**
     * 新增收料通知单
     * 
     * @param materialReceiveNotice 收料通知单
     * @return 结果
     */
    @Override
    public int insertMaterialReceiveNotice(MaterialReceiveNotice materialReceiveNotice)
    {
        return materialReceiveNoticeMapper.insertMaterialReceiveNotice(materialReceiveNotice);
    }

    /**
     * 修改收料通知单
     * 
     * @param materialReceiveNotice 收料通知单
     * @return 结果
     */
    @Override
    public int updateMaterialReceiveNotice(MaterialReceiveNotice materialReceiveNotice)
    {
        return materialReceiveNoticeMapper.updateMaterialReceiveNotice(materialReceiveNotice);
    }

    /**
     * 批量删除收料通知单
     * 
     * @param fentryIds 需要删除的收料通知单主键
     * @return 结果
     */
    @Override
    public int deleteMaterialReceiveNoticeByFENTRYIDs(Long[] fentryIds)
    {
        return materialReceiveNoticeMapper.deleteMaterialReceiveNoticeByFENTRYIDs(fentryIds);
    }

    /**
     * 删除收料通知单信息
     *
     fentryId     * @return 结果
     */
    @Override
    public int deleteMaterialReceiveNoticeByFENTRYID(Long fentryId)
    {
        return materialReceiveNoticeMapper.deleteMaterialReceiveNoticeByFENTRYID(fentryId);
    }
}
