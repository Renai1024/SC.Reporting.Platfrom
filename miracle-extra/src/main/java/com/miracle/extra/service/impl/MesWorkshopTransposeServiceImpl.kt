package com.miracle.extra.service.impl;

import java.math.BigDecimal;
import java.util.Date;

import com.miracle.common.exception.ServiceException;
import com.miracle.common.utils.DateUtils;
import com.miracle.common.utils.SecurityUtils;
import com.miracle.extra.mapper.ErpInfoMapper;
import com.miracle.extra.mapper.MaterialInfoMapper;
import com.miracle.extra.utils.SnowflakeIdGenerator;
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
class MesWorkshopTransposeServiceImpl(
    private val mesWorkshopTransposeMapper : MesWorkshopTransposeMapper,
    private val erpInfoMapper : ErpInfoMapper
    ) : IMesWorkshopTransposeService
{


    /**
     * 查询车间转序
     *
     * @param id 车间转序主键
     * @return 车间转序
     */
    override fun selectMesWorkshopTransposeById(id : Long): MesWorkshopTranspose = mesWorkshopTransposeMapper.selectMesWorkshopTransposeById(id)

    /**
     * 查询车间转序列表
     *
     * @param mesWorkshopTranspose 车间转序
     * @return 车间转序
     */
    override fun selectMesWorkshopTransposeList(mesWorkshopTranspose : MesWorkshopTranspose) : List<MesWorkshopTranspose> = mesWorkshopTransposeMapper.selectMesWorkshopTransposeList(mesWorkshopTranspose)

    /**
     * 车间转序
     *
     * @param mesWorkshopTranspose 车间转序
     * @return 结果
     */
    override fun insertMesWorkshopTranspose(mesWorkshopTranspose: MesWorkshopTranspose) : Int
    {
        val materialCode : String = mesWorkshopTranspose.materialCode.toString()
        val fromWorkshop : String = mesWorkshopTranspose.fromWorkshop.toString()
        val toWorkshop : String = mesWorkshopTranspose.toWorkshop.toString()
        val transferPerson : String = mesWorkshopTranspose.transferPerson.toString()

        if(materialCode.isBlank() || erpInfoMapper.selectMaterialByCode(materialCode).isEmpty()) throw ServiceException("该物料编码不存在！");

        mesWorkshopTranspose.fromWorkshop = resolveWorkshopName(fromWorkshop)
        mesWorkshopTranspose.toWorkshop = resolveWorkshopName(toWorkshop)
        mesWorkshopTranspose.transferPerson = resolveWorkerName(transferPerson)

        if((mesWorkshopTranspose.transferQuantity?.compareTo(BigDecimal.ZERO) ?: -1) <= 0) throw  ServiceException("转序数量必须大于0！")
        val snowflakeId = basicGenerateId(SnowflakeIdGenerator(1, 1)).toString()
        val now : Date = DateUtils.getNowDate()
        val name : String = SecurityUtils.getLoginUser().user.nickName

        mesWorkshopTranspose.apply {
            this.snowflakeId = snowflakeId
            this.createBy = name
            this.createTime = now
            this.transferTime = transferTime ?: now
            this.ifTransferred = "Y"
        }

        return mesWorkshopTransposeMapper.insertMesWorkshopTranspose(mesWorkshopTranspose)


//        if(erpInfoMapper.selectWorkshopByName(fromWorkshop).isEmpty()) {
//            if(erpInfoMapper.selectWorkshopByCode(fromWorkshop).isEmpty()) {
//                throw ServiceException("该转出车间：" + fromWorkshop + "不存在或无效！");
//            }else{
//                mesWorkshopTranspose.fromWorkshop = erpInfoMapper.selectWorkshopByCode(fromWorkshop)[0].workshopName
//            }
//        }
//        // 判断转入车间是否存在
//        if(erpInfoMapper.selectWorkshopByName(toWorkshop).isEmpty()) {
//            if(erpInfoMapper.selectWorkshopByCode(toWorkshop).isEmpty()) {
//                throw ServiceException("该转入车间：" + toWorkshop + "不存在或无效！");
//            }else{
//                mesWorkshopTranspose.toWorkshop = erpInfoMapper.selectWorkshopByCode(toWorkshop)[0].workshopName
//            }
//        }
//        // 判断转序人员是否存在
//        if(erpInfoMapper.selectWorkerByName(transferPerson).isEmpty()) {
//            if(erpInfoMapper.selectWorkerByCode(transferPerson).isEmpty()) {
//                throw ServiceException("该转序人员：" + transferPerson + "不存在或无效！");
//            }else{
//                mesWorkshopTranspose.transferPerson = (erpInfoMapper.selectWorkerByCode(transferPerson)[0].workerName);
//            }
//        }
//        // 转序数量必须大于0
//        if((mesWorkshopTranspose.transferQuantity?.compareTo(BigDecimal.ZERO) ?: -1) <= 0) throw  ServiceException("转序数量必须大于0！");
//        val snowflakeId = BasicGenerateId(SnowflakeIdGenerator(1, 1)).toString()
//        val now : Date = DateUtils.getNowDate()
//        val name : String = SecurityUtils.getLoginUser().user.nickName
//        // 转序时间，若不存在，则使用当前时间
//        if(mesWorkshopTranspose.transferTime == null || mesWorkshopTranspose.transferTime!!.equals("")){
//            mesWorkshopTranspose.transferTime = now
//        }
//        mesWorkshopTranspose.snowflakeId = snowflakeId;
//        mesWorkshopTranspose.createBy = name;
//        mesWorkshopTranspose.createTime = DateUtils.getNowDate();
//        mesWorkshopTranspose.ifTransferred = "Y";
//        return mesWorkshopTransposeMapper.insertMesWorkshopTranspose(mesWorkshopTranspose);
    }

    /**
     * 收料确认
     *
     * @param mesWorkshopTranspose 车间转序
     * @return 结果
     */
    override fun updateMesWorkshopTranspose(mesWorkshopTranspose: MesWorkshopTranspose) : Int
    {
        val now : Date = DateUtils.getNowDate()
        mesWorkshopTranspose.updateTime = now
        val transferPerson : String = mesWorkshopTranspose.transferPerson.toString()
        val materialCode : String = mesWorkshopTranspose.materialCode.toString()
        val receiverPerson : String = mesWorkshopTranspose.receiverPerson.toString()

        if (mesWorkshopTransposeMapper.selectMesWorkshopTransposeListByMaterialCode(materialCode).isEmpty()) {
            throw ServiceException("该物料编码未进行转序操作，不允许确认！")
        }

        val existing = mesWorkshopTransposeMapper
            .selectMesWorkshopTransposeBySnowflakeId(mesWorkshopTranspose.snowflakeId.toString())

        if (existing.ifTransferred == "N") {
            throw ServiceException("该物料未进行转序操作，不允许收料确认！")
        }
        if (existing.ifConfirmed == "Y") {
            throw ServiceException("该物料已进行收料确认操作，不允许重复操作！")
        }

        mesWorkshopTranspose.receiverPerson = resolveWorkerName(receiverPerson)

        if (receiverPerson == transferPerson) {
            throw ServiceException("收料人员不允许与转序人员相同！")
        }

        mesWorkshopTranspose.apply {
            confirmTime = now
            ifConfirmed = "Y"
        }

        return mesWorkshopTransposeMapper.updateMesWorkshopTranspose(mesWorkshopTranspose)

//        // 判断该物料编码是否进行转序
//        if(mesWorkshopTransposeMapper.selectMesWorkshopTransposeListByMaterialCode(materialCode).isEmpty()) throw ServiceException("该物料编码未进行转序操作，不允许确认！");
//        // 判断该物料是否已进行转序操作
//        if(mesWorkshopTransposeMapper
//            .selectMesWorkshopTransposeBySnowflakeId(mesWorkshopTranspose.snowflakeId.toString())
//            .ifTransferred.equals("N"))
//            throw ServiceException("该物料未进行转序操作，不允许收料确认！");
//        // 判断该物料是否已进行收料确认操作
//        if(mesWorkshopTransposeMapper.selectMesWorkshopTransposeBySnowflakeId(mesWorkshopTranspose.snowflakeId.toString()).ifConfirmed.equals("Y")) throw ServiceException("该物料已进行收料确认操作，不允许重复操作！");
//        // 收料人员不允许与转序人员相同
//        if(erpInfoMapper.selectWorkerByName(receiverPerson).isEmpty()) {
//            if(erpInfoMapper.selectWorkerByCode(receiverPerson).isEmpty()){
//                throw ServiceException("该收料人员：" + receiverPerson + "不存在或无效！");
//            }else{
//                mesWorkshopTranspose.receiverPerson = erpInfoMapper.selectWorkerByCode(receiverPerson)[0].workerName
//            }
//        }
//        if(receiverPerson.equals(transferPerson)) throw ServiceException("收料人员不允许与转序人员相同！");
//        mesWorkshopTranspose.confirmTime = now
//        mesWorkshopTranspose.ifConfirmed = "Y"
//        return mesWorkshopTransposeMapper.updateMesWorkshopTranspose(mesWorkshopTranspose);
    }

    override fun changeQuantity(mesWorkshopTranspose : MesWorkshopTranspose) : Int {
        val result : Int= mesWorkshopTransposeMapper.changeQuantity(mesWorkshopTranspose);
        if(result <= 0) throw ServiceException("修改数量失败,请联系管理员!");
        return result;
    }

    /**
     * 批量删除车间转序
     *
     * @param ids 需要删除的车间转序主键
     * @return 结果
     */
    override fun deleteMesWorkshopTransposeByIds(ids: Array<Long>) : Int = mesWorkshopTransposeMapper.deleteMesWorkshopTransposeByIds(ids)

    /**
     * 删除车间转序信息
     *
     * @param id 车间转序主键
     * @return 结果
     */
    override fun deleteMesWorkshopTransposeById(id: Long) : Int
    {
        val mesWorkshopTranspose : MesWorkshopTranspose = mesWorkshopTransposeMapper.selectMesWorkshopTransposeById(id);
        if(mesWorkshopTranspose.ifConfirmed.equals("Y")) throw ServiceException("该物料已进行收料操作，不允许删除！");
        return mesWorkshopTransposeMapper.deleteMesWorkshopTransposeById(id);
    }

    private fun resolveWorkshopName(input: String) : String {
        if(input.isBlank()) throw ServiceException("车间信息不能为空或无效！")
        return erpInfoMapper.selectWorkshopByName(input).firstOrNull()?.workshopName
            ?: erpInfoMapper.selectWorkshopByCode(input).firstOrNull()?.workshopName
            ?: throw ServiceException("该车间：$input 不存在或无效！")
    }

    private fun resolveWorkerName(input: String) : String {
        if(input.isBlank()) throw ServiceException("人员信息不能为空或无效！")
        return erpInfoMapper.selectWorkerByName(input).firstOrNull()?.workerName
            ?: erpInfoMapper.selectWorkerByCode(input).firstOrNull()?.workerName
            ?: throw ServiceException("该人员：$input 不存在或无效！")
    }

    private fun basicGenerateId(snowflakeIdGenerator: SnowflakeIdGenerator) : Long =
        snowflakeIdGenerator.nextId();
}
