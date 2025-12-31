package com.miracle.extra.service;

import com.miracle.extra.domain.ErpInfo


interface ErpInfoService {

    fun selectWorkerList(erpInfo: ErpInfo): List<ErpInfo>;

    fun selectWorkshopList(erpInfo: ErpInfo): List<ErpInfo>;

    fun selectWorkshopByCode(workshopCode: String?): List<ErpInfo>;

    fun selectWorkshopByName(workshopName: String?): List<ErpInfo>;

    fun selectWorkerByCode(workerCode: String?): List<ErpInfo>;

    fun selectWorkerByName(workerName: String?): List<ErpInfo>;

    fun searchWorkshop(searchText: String?): List<ErpInfo>;

    fun searchWorker(searchText: String?): List<ErpInfo>;

    fun searchMaterial(searchText: String?): List<ErpInfo>;
}
