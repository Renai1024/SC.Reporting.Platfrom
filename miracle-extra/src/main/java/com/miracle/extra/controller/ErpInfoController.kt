package com.miracle.extra.controller;

import com.miracle.common.core.controller.BaseController;
import com.miracle.common.core.page.TableDataInfo;
import com.miracle.extra.domain.ErpInfo;
import com.miracle.extra.service.ErpInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/extra/erp/info")
open class ErpInfoController(private val erpInfoService: ErpInfoService) : BaseController() {


    @GetMapping("/workshop/list")
    open fun workshopList(info : ErpInfo) : TableDataInfo{
        startPage();
        val list : List<ErpInfo> = erpInfoService.selectWorkshopList(info);
        return getDataTable(list);
    }

    @GetMapping("/worker/list")
    open fun workerList(info: ErpInfo) : TableDataInfo{
        startPage();
        val list : List<ErpInfo> = erpInfoService.selectWorkerList(info);
        return getDataTable(list);
    }

    /**
     * 通用查询车间（编码或名称）
     */
    @GetMapping("/workshop/search")
    open fun searchWorkshop(@RequestParam(value = "searchText", required = false) searchText : String?) : TableDataInfo {
        startPage();
        val list :List<ErpInfo> = erpInfoService.searchWorkshop(searchText?:"");
        return getDataTable(list);
    }

    /**
     * 通用查询员工（编码或名称）
     */
    @GetMapping("/worker/search")
    open fun searchWorker(@RequestParam(value = "searchText", required = false) searchText : String?) : TableDataInfo {
        startPage();
        val list : List<ErpInfo> = erpInfoService.searchWorker(searchText?:"");
        return getDataTable(list);
    }

    /**
     * 通用查询物料（编码或名称）
     */
    @GetMapping("/material/search")
    open fun searchMaterial(@RequestParam(value = "searchText", required = false) searchText : String?) : TableDataInfo{
        startPage();
        val list : List<ErpInfo> = erpInfoService.searchMaterial(searchText?:"");
        return getDataTable(list);
    }

}
