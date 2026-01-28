package com.miracle.extra.service

import com.miracle.extra.domain.MesTransposeMaterial

interface IMesTransposeMaterialService {

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