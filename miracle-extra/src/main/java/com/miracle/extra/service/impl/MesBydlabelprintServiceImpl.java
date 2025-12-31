package com.miracle.extra.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.miracle.extra.mapper.MesBydlabelprintMapper;
import com.miracle.extra.domain.MesBydlabelprint;
import com.miracle.extra.service.IMesBydlabelprintService;

/**
 * bydlabelprintService业务层处理
 * 
 * @author miracle
 * @date 2025-11-20
 */
@Service
public class MesBydlabelprintServiceImpl implements IMesBydlabelprintService 
{
    @Autowired
    private MesBydlabelprintMapper mesBydlabelprintMapper;

    /**
     * 查询bydlabelprint
     * 
     * @param MaterialCode bydlabelprint主键
     * @return bydlabelprint
     */
    @Override
    public MesBydlabelprint selectMesBydlabelprintByMaterialCode(String MaterialCode)
    {
        return mesBydlabelprintMapper.selectMesBydlabelprintByMaterialCode(MaterialCode);
    }

    /**
     * 查询bydlabelprint列表
     * 
     * @param mesBydlabelprint bydlabelprint
     * @return bydlabelprint
     */
    @Override
    public List<MesBydlabelprint> selectMesBydlabelprintList(MesBydlabelprint mesBydlabelprint)
    {
        return mesBydlabelprintMapper.selectMesBydlabelprintList(mesBydlabelprint);
    }

    /**
     * 新增bydlabelprint
     * 
     * @param mesBydlabelprint bydlabelprint
     * @return 结果
     */
    @Override
    public int insertMesBydlabelprint(MesBydlabelprint mesBydlabelprint)
    {
        return mesBydlabelprintMapper.insertMesBydlabelprint(mesBydlabelprint);
    }

    /**
     * 修改bydlabelprint
     * 
     * @param mesBydlabelprint bydlabelprint
     * @return 结果
     */
    @Override
    public int updateMesBydlabelprint(MesBydlabelprint mesBydlabelprint)
    {
        return mesBydlabelprintMapper.updateMesBydlabelprint(mesBydlabelprint);
    }

    /**
     * 批量删除bydlabelprint
     * 
     * @param MaterialCodes 需要删除的bydlabelprint主键
     * @return 结果
     */
    @Override
    public int deleteMesBydlabelprintByMaterialCodes(String[] MaterialCodes)
    {
        return mesBydlabelprintMapper.deleteMesBydlabelprintByMaterialCodes(MaterialCodes);
    }

    /**
     * 删除bydlabelprint信息
     * 
     * @param MaterialCode bydlabelprint主键
     * @return 结果
     */
    @Override
    public int deleteMesBydlabelprintByMaterialCode(String MaterialCode)
    {
        return mesBydlabelprintMapper.deleteMesBydlabelprintByMaterialCode(MaterialCode);
    }
}
