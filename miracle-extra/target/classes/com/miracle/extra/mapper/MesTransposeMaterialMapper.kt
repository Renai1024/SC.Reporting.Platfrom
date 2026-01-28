package com.miracle.extra.mapper

import com.miracle.common.annotation.DataSource
import com.miracle.common.enums.DataSourceType
import com.miracle.extra.domain.MesTransposeMaterial
import org.apache.ibatis.annotations.Mapper

@Mapper
@DataSource(DataSourceType.SLAVE2)
interface MesTransposeMaterialMapper {

    fun selectMesTransposeMaterialById(id: Long): MesTransposeMaterial

    fun selectMesTransposeMaterialList(mesTransposeMaterial: MesTransposeMaterial): List<MesTransposeMaterial>

    fun selectMesTransposeMaterialListByMaterialCode(materialCode: String): List<MesTransposeMaterial>

    fun selectMesTransposeMaterialListByMaterialName(materialName: String): List<MesTransposeMaterial>

    fun insertMesTransposeMaterial(mesTransposeMaterial: MesTransposeMaterial): Int

    fun insertMesTransposeMaterialBatch(mesTransposeMaterialList: List<MesTransposeMaterial>): Int

    fun updateMesTransposeMaterial(mesTransposeMaterial: MesTransposeMaterial): Int

    fun deleteMesTransposeMaterialById(id: Long): Int

    fun deleteMesTransposeMaterialByIds(ids: Array<Long>): Int
}