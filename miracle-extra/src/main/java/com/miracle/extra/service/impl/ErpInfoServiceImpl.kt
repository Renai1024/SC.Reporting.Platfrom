package com.miracle.extra.service.impl;

import com.miracle.extra.domain.ErpInfo;
import com.miracle.extra.mapper.ErpInfoMapper;
import com.miracle.extra.service.ErpInfoService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ErpInfoServiceImpl implements ErpInfoService {
    @Resource
    ErpInfoMapper erpInfoMapper;

    @Override
    public List<ErpInfo> selectWorkerList(ErpInfo erpInfo) {
        return erpInfoMapper.selectWorkerList(erpInfo);
    }

    @Override
    public List<ErpInfo> selectWorkshopList(ErpInfo erpInfo) {
        return erpInfoMapper.selectWorkshopList(erpInfo);
    }

    @Override
    public List<ErpInfo> selectWorkshopByCode(String workshopCode) {
        return erpInfoMapper.selectWorkshopByCode(workshopCode);
    }

    @Override
    public List<ErpInfo> selectWorkshopByName(String workshopName) {
        return erpInfoMapper.selectWorkshopByName(workshopName);
    }

    @Override
    public List<ErpInfo> selectWorkerByCode(String workerCode) {
        return erpInfoMapper.selectWorkerByCode(workerCode);
    }

    @Override
    public List<ErpInfo> selectWorkerByName(String workerName) {
        return erpInfoMapper.selectWorkerByName(workerName);
    }

    @Override
    public List<ErpInfo> searchWorkshop(String searchText) {
        return erpInfoMapper.searchWorkshop(searchText);
    }

    @Override
    public List<ErpInfo> searchWorker(String searchText) {
        return erpInfoMapper.searchWorker(searchText);
    }

    @Override
    public List<ErpInfo> searchMaterial(String searchText) {
        return erpInfoMapper.searchMaterial(searchText);
    }
}
