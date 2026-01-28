package com.miracle.extra.mapper;

import java.util.List;

import com.miracle.common.annotation.DataSource;
import com.miracle.common.enums.DataSourceType;
import com.miracle.extra.domain.MaterialReceiveNotice;
import org.apache.ibatis.annotations.Mapper;

/**
 * 收料通知单Mapper接口
 * 
 * @author miracle
 * @date 2025-09-03
 */
@Mapper
@DataSource(DataSourceType.SLAVE)
public interface MaterialReceiveNoticeMapper 
{
    /**
     * 查询收料通知单
     * 
     * @param FENTRYID 收料通知单主键
     * @return 收料通知单
     */
    public MaterialReceiveNotice selectMaterialReceiveNoticeByFENTRYID(Long FENTRYID);

    /**
     * 查询收料通知单列表
     * 
     * @param materialReceiveNotice 收料通知单
     * @return 收料通知单集合
     */
    public List<MaterialReceiveNotice> selectMaterialReceiveNoticeList(MaterialReceiveNotice materialReceiveNotice);

    /**
     * 批量查询收料通知单
     * @param fentryIds 明细id
     * @return 收料通知单集合
     */
    public List<MaterialReceiveNotice> selectMaterialReceiveNoticeByFENTRYIDs(String[] fentryIds);

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
     * 删除收料通知单
     * 
     * @param fentryId 收料通知单主键
     * @return 结果
     */
    public int deleteMaterialReceiveNoticeByFENTRYID(Long fentryId);

    /**
     * 批量删除收料通知单
     * 
     * @param fentryIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMaterialReceiveNoticeByFENTRYIDs(Long[] fentryIds);
}
