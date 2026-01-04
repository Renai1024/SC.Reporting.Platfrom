package com.miracle.extra.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.miracle.common.exception.ServiceException;
import com.miracle.common.utils.DateUtils;
import com.miracle.common.utils.SecurityUtils;
import com.miracle.extra.domain.ErpInfo;
import com.miracle.extra.mapper.ErpInfoMapper;
import com.miracle.extra.mapper.MaterialInfoMapper;
import com.miracle.extra.utils.SnowflakeIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.miracle.extra.mapper.MesWorkshopTransposeMapper;
import com.miracle.extra.domain.MesWorkshopTranspose;
import com.miracle.extra.service.IMesWorkshopTransposeService;

/**
 * 车间转序Service业务层处理
 *
 * @author miracle
 * @date 2025-12-17
 */
@Service
public class MesWorkshopTransposeServiceImpl implements IMesWorkshopTransposeService
{
    @Autowired
    private MesWorkshopTransposeMapper mesWorkshopTransposeMapper;

    @Autowired
    private MaterialInfoMapper materialInfoMapper;

    @Autowired
    private ErpInfoMapper erpInfoMapper;

    /**
     * 查询车间转序
     *
     * @param id 车间转序主键
     * @return 车间转序
     */
    @Override
    public MesWorkshopTranspose selectMesWorkshopTransposeById(Long id)
    {
        return mesWorkshopTransposeMapper.selectMesWorkshopTransposeById(id);
    }

    /**
     * 查询车间转序列表
     *
     * @param mesWorkshopTranspose 车间转序
     * @return 车间转序
     */
    @Override
    public List<MesWorkshopTranspose> selectMesWorkshopTransposeList(MesWorkshopTranspose mesWorkshopTranspose)
    {
        return mesWorkshopTransposeMapper.selectMesWorkshopTransposeList(mesWorkshopTranspose);
    }

    /**
     * 车间转序
     *
     * @param mesWorkshopTranspose 车间转序
     * @return 结果
     */
    @Override
    public int insertMesWorkshopTranspose(MesWorkshopTranspose mesWorkshopTranspose)
    {
        String materialCode = mesWorkshopTranspose.getMaterialCode();
        String fromWorkshop = mesWorkshopTranspose.getFromWorkshop();
        String toWorkshop = mesWorkshopTranspose.getToWorkshop();
        String transferPerson = mesWorkshopTranspose.getTransferPerson();
        // 判断物料编码是否存在
        if(erpInfoMapper.selectMaterialByCode(materialCode).isEmpty()) throw new ServiceException("该物料编码不存在！");
        // 判断转出车间是否存在
        if(erpInfoMapper.selectWorkshopByName(fromWorkshop).isEmpty()) {
            if(erpInfoMapper.selectWorkshopByCode(fromWorkshop).isEmpty()) {
                throw new ServiceException("该转出车间：" + fromWorkshop + "不存在或无效！");
            }else{
                mesWorkshopTranspose.setFromWorkshop(erpInfoMapper.selectWorkshopByCode(fromWorkshop).get(0).getWorkshopName());
            }
        }
        // 判断转入车间是否存在
        if(erpInfoMapper.selectWorkshopByName(toWorkshop).isEmpty()) {
            if(erpInfoMapper.selectWorkshopByCode(toWorkshop).isEmpty()) {
                throw new ServiceException("该转入车间：" + toWorkshop + "不存在或无效！");
            }else{
                mesWorkshopTranspose.setToWorkshop(erpInfoMapper.selectWorkshopByCode(toWorkshop).get(0).getWorkshopName());
            }
        }
        // 判断转序人员是否存在
        if(erpInfoMapper.selectWorkerByName(transferPerson).isEmpty()) {
            if(erpInfoMapper.selectWorkerByCode(transferPerson).isEmpty()) {
                throw new ServiceException("该转序人员：" + transferPerson + "不存在或无效！");
            }else{
                mesWorkshopTranspose.setTransferPerson(erpInfoMapper.selectWorkerByCode(transferPerson).get(0).getWorkerName());
            }
        }
        // 转序数量必须大于0
        if(mesWorkshopTranspose.getTransferQuantity().compareTo(BigDecimal.ZERO) <= 0) throw new ServiceException("转序数量必须大于0！");
        String snowflakeId = String.valueOf(BasicGenerateId(new SnowflakeIdGenerator(1,1)));
        System.out.println("snowflakeId: " + snowflakeId);
        Date now = DateUtils.getNowDate();
        String name = SecurityUtils.getLoginUser().getUser().getNickName();
        // 转序时间，若不存在，则使用当前时间
        if(mesWorkshopTranspose.getTransferTime() == null || mesWorkshopTranspose.getTransferTime().equals("")){
            mesWorkshopTranspose.setTransferTime(now);
        }
        mesWorkshopTranspose.setSnowflakeId(snowflakeId);
        mesWorkshopTranspose.setCreateBy(name);
        mesWorkshopTranspose.setCreateTime(DateUtils.getNowDate());
        mesWorkshopTranspose.setIsTransferred("Y");
        return mesWorkshopTransposeMapper.insertMesWorkshopTranspose(mesWorkshopTranspose);
    }

    /**
     * 收料确认
     *
     * @param mesWorkshopTranspose 车间转序
     * @return 结果
     */
    @Override
    public int updateMesWorkshopTranspose(MesWorkshopTranspose mesWorkshopTranspose)
    {
        Date now = DateUtils.getNowDate();
        mesWorkshopTranspose.setUpdateTime(now);
        String transferPerson = mesWorkshopTranspose.getTransferPerson();
        String materialCode = mesWorkshopTranspose.getMaterialCode();
        String receiverPerson = mesWorkshopTranspose.getReceiverPerson();

        // 判断该物料编码是否进行转序
        if(mesWorkshopTransposeMapper.selectMesWorkshopTransposeListByMaterialCode(materialCode).isEmpty()) throw new ServiceException("该物料编码未进行转序操作，不允许确认！");
        // 判断该物料是否已进行转序操作
        if(mesWorkshopTransposeMapper.selectMesWorkshopTransposeBySnowflakeId(mesWorkshopTranspose.getSnowflakeId()).getIsTransferred().equals("N")) throw new ServiceException("该物料未进行转序操作，不允许收料确认！");
        // 判断该物料是否已进行收料确认操作
        if(mesWorkshopTransposeMapper.selectMesWorkshopTransposeBySnowflakeId(mesWorkshopTranspose.getSnowflakeId()).getIsConfirmed().equals("Y")) throw new ServiceException("该物料已进行收料确认操作，不允许重复操作！");
        // 收料人员不允许与转序人员相同
        if(erpInfoMapper.selectWorkerByName(receiverPerson).isEmpty()) {
            if(erpInfoMapper.selectWorkerByCode(receiverPerson).isEmpty()){
                throw new ServiceException("该收料人员：" + receiverPerson + "不存在或无效！");
            }else{
                mesWorkshopTranspose.setReceiverPerson(erpInfoMapper.selectWorkerByCode(receiverPerson).get(0).getWorkerName());
            }
        }
        if(receiverPerson.equals(transferPerson)) throw new ServiceException("收料人员不允许与转序人员相同！");
        mesWorkshopTranspose.setConfirmTime(now);
        mesWorkshopTranspose.setIsConfirmed("Y");
        return mesWorkshopTransposeMapper.updateMesWorkshopTranspose(mesWorkshopTranspose);
    }

    @Override
    public int changeQuantity(MesWorkshopTranspose mesWorkshopTranspose) {
        int result = mesWorkshopTransposeMapper.changeQuantity(mesWorkshopTranspose);
        if(result <= 0) throw new ServiceException("修改数量失败,请联系管理员!");
        return result;
    }

    /**
     * 批量删除车间转序
     *
     * @param ids 需要删除的车间转序主键
     * @return 结果
     */
    @Override
    public int deleteMesWorkshopTransposeByIds(Long[] ids)
    {
        return mesWorkshopTransposeMapper.deleteMesWorkshopTransposeByIds(ids);
    }

    /**
     * 删除车间转序信息
     *
     * @param id 车间转序主键
     * @return 结果
     */
    @Override
    public int deleteMesWorkshopTransposeById(Long id)
    {
        MesWorkshopTranspose mesWorkshopTranspose = mesWorkshopTransposeMapper.selectMesWorkshopTransposeById(id);
        if(mesWorkshopTranspose.getIsTransferred().equals("Y")) throw new ServiceException("该物料已进行转序操作，不允许删除！");
        return mesWorkshopTransposeMapper.deleteMesWorkshopTransposeById(id);
    }

    public static long BasicGenerateId(SnowflakeIdGenerator snowflakeIdGenerator) {
        return snowflakeIdGenerator.nextId();
    }
}
