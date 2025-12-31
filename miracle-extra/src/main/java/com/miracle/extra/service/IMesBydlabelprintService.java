package com.miracle.extra.service;

import java.util.List;
import com.miracle.extra.domain.MesBydlabelprint;

/**
 * bydlabelprintService接口
 * 
 * @author miracle
 * @date 2025-11-20
 */
public interface IMesBydlabelprintService 
{
    /**
     * 查询bydlabelprint
     * 
     * @param MaterialCode bydlabelprint主键
     * @return bydlabelprint
     */
    public MesBydlabelprint selectMesBydlabelprintByMaterialCode(String MaterialCode);

    /**
     * 查询bydlabelprint列表
     * 
     * @param mesBydlabelprint bydlabelprint
     * @return bydlabelprint集合
     */
    public List<MesBydlabelprint> selectMesBydlabelprintList(MesBydlabelprint mesBydlabelprint);

    /**
     * 新增bydlabelprint
     * 
     * @param mesBydlabelprint bydlabelprint
     * @return 结果
     */
    public int insertMesBydlabelprint(MesBydlabelprint mesBydlabelprint);

    /**
     * 修改bydlabelprint
     * 
     * @param mesBydlabelprint bydlabelprint
     * @return 结果
     */
    public int updateMesBydlabelprint(MesBydlabelprint mesBydlabelprint);

    /**
     * 批量删除bydlabelprint
     * 
     * @param MaterialCodes 需要删除的bydlabelprint主键集合
     * @return 结果
     */
    public int deleteMesBydlabelprintByMaterialCodes(String[] MaterialCodes);

    /**
     * 删除bydlabelprint信息
     * 
     * @param MaterialCode bydlabelprint主键
     * @return 结果
     */
    public int deleteMesBydlabelprintByMaterialCode(String MaterialCode);
}
