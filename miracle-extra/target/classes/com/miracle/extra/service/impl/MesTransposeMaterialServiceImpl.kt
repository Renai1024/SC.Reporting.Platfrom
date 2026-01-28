package com.miracle.extra.service.impl

import com.miracle.common.exception.ServiceException
import com.miracle.common.utils.SecurityUtils
import org.springframework.stereotype.Service
import com.miracle.extra.service.IMesTransposeMaterialService
import com.miracle.extra.domain.MesTransposeMaterial
import com.miracle.extra.mapper.MesTransposeMaterialMapper
import com.miracle.extra.utils.SnowflakeIdGenerator
import java.util.Date

@Service
class MesTransposeMaterialServiceImpl(
    private val mesTransposeMaterialMapper: MesTransposeMaterialMapper)
    :IMesTransposeMaterialService {

    override fun selectMesTransposeMaterialById(id: Long): MesTransposeMaterial {
        return mesTransposeMaterialMapper.selectMesTransposeMaterialById(id)
    }

    override fun selectMesTransposeMaterialList(mesTransposeMaterial: MesTransposeMaterial): List<MesTransposeMaterial> =
        mesTransposeMaterialMapper.selectMesTransposeMaterialList(mesTransposeMaterial)

    override fun selectMesTransposeMaterialListByMaterialCode(materialCode: String): List<MesTransposeMaterial> =
        mesTransposeMaterialMapper.selectMesTransposeMaterialListByMaterialCode(materialCode)

    override fun selectMesTransposeMaterialListByMaterialName(materialName: String): List<MesTransposeMaterial> =
        mesTransposeMaterialMapper.selectMesTransposeMaterialListByMaterialName(materialName)

    override fun insertMesTransposeMaterial(mesTransposeMaterial: MesTransposeMaterial): Int {
        val code = mesTransposeMaterial.materialCode
        val createBy : String = SecurityUtils.getLoginUser().user.nickName
        val createTime : Date = Date()
        if(code.isNullOrEmpty()) throw ServiceException("物料编码不能为空！")
        if(mesTransposeMaterialMapper.selectMesTransposeMaterialListByMaterialCode(code).isNotEmpty()) throw ServiceException("该物料编码已存在！")
        mesTransposeMaterial.apply {
            this.createBy = createBy
            this.createTime = createTime
        }
        return mesTransposeMaterialMapper.insertMesTransposeMaterial(mesTransposeMaterial)
    }

    override fun insertMesTransposeMaterialBatch(mesTransposeMaterialList: List<MesTransposeMaterial>): Int =
        mesTransposeMaterialMapper.insertMesTransposeMaterialBatch(mesTransposeMaterialList)

    override fun updateMesTransposeMaterial(mesTransposeMaterial: MesTransposeMaterial): Int {
        val updateBy : String = SecurityUtils.getLoginUser().user.nickName
        val updateTime : Date = Date()
        mesTransposeMaterial.apply {
            this.updateBy = updateBy
            this.updateTime = updateTime
        }
        return mesTransposeMaterialMapper.updateMesTransposeMaterial(mesTransposeMaterial)
    }

    override fun deleteMesTransposeMaterialById(id: Long): Int =
        mesTransposeMaterialMapper.deleteMesTransposeMaterialById(id)

    override fun deleteMesTransposeMaterialByIds(ids: Array<Long>): Int =
        mesTransposeMaterialMapper.deleteMesTransposeMaterialByIds(ids)

    private fun basicGenerateId(snowflakeIdGenerator: SnowflakeIdGenerator) : Long =
        snowflakeIdGenerator.nextId();
}