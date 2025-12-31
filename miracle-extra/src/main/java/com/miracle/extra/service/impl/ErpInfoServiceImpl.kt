package com.miracle.extra.service.impl;
import com.miracle.extra.domain.ErpInfo
import com.miracle.extra.mapper.ErpInfoMapper;
import com.miracle.extra.service.ErpInfoService
import org.springframework.stereotype.Service;

@Service
class ErpInfoServiceImpl(private val erpInfoMapper: ErpInfoMapper) : ErpInfoService {


    override fun selectWorkerList(erpInfo: ErpInfo) : List<ErpInfo> = erpInfoMapper.selectWorkerList(erpInfo)

    override fun selectWorkshopList(erpInfo : ErpInfo) : List<ErpInfo> = erpInfoMapper.selectWorkshopList(erpInfo)

    override fun selectWorkshopByCode(workshopCode: String?) : List<ErpInfo> = erpInfoMapper.selectWorkshopByCode(workshopCode)

    override fun selectWorkshopByName(workshopName : String?): List<ErpInfo> = erpInfoMapper.selectWorkshopByName(workshopName)

    override fun selectWorkerByCode(workerCode: String?) : List<ErpInfo> = erpInfoMapper.selectWorkerByCode(workerCode)

    override fun selectWorkerByName(workerName: String?) : List<ErpInfo> = erpInfoMapper.selectWorkerByName(workerName)

    override fun searchWorkshop(searchText: String?) : List<ErpInfo> = erpInfoMapper.searchWorkshop(searchText)

    override fun searchWorker(searchText: String?) : List<ErpInfo> = erpInfoMapper.searchWorker(searchText)

    override fun searchMaterial(searchText: String?) : List<ErpInfo> = erpInfoMapper.searchMaterial(searchText)
}
