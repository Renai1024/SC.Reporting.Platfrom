package com.miracle.extra.domain;

import com.miracle.common.core.domain.BaseEntity

data class ErpInfo (
    var workerName: String? = null,
    var workerCode: String? = null,
    var workshopName: String? = null,
    var workshopCode: String? = null,
    var materialName: String? = null,
    var materialCode: String? = null,
) : BaseEntity()
