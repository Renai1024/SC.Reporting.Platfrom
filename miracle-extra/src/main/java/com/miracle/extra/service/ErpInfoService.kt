package com.miracle.extra.service;

import com.miracle.extra.domain.ErpInfo;

import java.util.List;

public interface ErpInfoService {

    public List<ErpInfo> selectWorkerList(ErpInfo erpInfo);

    public List<ErpInfo> selectWorkshopList(ErpInfo erpInfo);

    public List<ErpInfo> selectWorkshopByCode(String workshopCode);

    public List<ErpInfo> selectWorkshopByName(String workshopName);

    public List<ErpInfo> selectWorkerByCode(String workerCode);

    public List<ErpInfo> selectWorkerByName(String workerName);

    public List<ErpInfo> searchWorkshop(String searchText);

    public List<ErpInfo> searchWorker(String searchText);

    public List<ErpInfo> searchMaterial(String searchText);
}
