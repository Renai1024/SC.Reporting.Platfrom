package com.miracle.extra.domain;

import com.miracle.common.annotation.Excel
import com.miracle.common.core.domain.BaseEntity


/**
 * 转序物料信息 mes_transpose_material
 *
 * @author miracle
 * @date 2026-01-20
 */

data class MesTransposeMaterial(
    var id: Long? = null,

    @Excel(name = "物料编码")
    var materialCode: String? = null,

    @Excel(name = "物料名称")
    var materialName: String? = null,

    @Excel(name = "生产车间")
    var materialWorkshop: String? = null,

    var materialImage: String? = null,

    var materialImageId: Long? = null,
) : BaseEntity()



