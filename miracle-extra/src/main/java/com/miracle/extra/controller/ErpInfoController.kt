package com.miracle.extra.controller;

import com.miracle.common.core.controller.BaseController;
import com.miracle.common.core.page.TableDataInfo;
import com.miracle.extra.domain.ErpInfo;
import com.miracle.extra.service.ErpInfoService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/extra/erp/info")
public class ErpInfoController extends BaseController {

    @Resource
    private ErpInfoService erpInfoService;

    @GetMapping("/workshop/list")
    public TableDataInfo workshopList(ErpInfo info){
        startPage();
        List<ErpInfo> list = erpInfoService.selectWorkshopList(info);
        return getDataTable(list);
    }

    @GetMapping("/worker/list")
    public TableDataInfo workerList(ErpInfo info){
        startPage();
        List<ErpInfo> list = erpInfoService.selectWorkerList(info);
        return getDataTable(list);
    }

    /**
     * 通用查询车间（编码或名称）
     */
    @GetMapping("/workshop/search")
    public TableDataInfo searchWorkshop(@RequestParam(value = "searchText", required = false) String searchText) {
        startPage();
        List<ErpInfo> list = erpInfoService.searchWorkshop(searchText);
        return getDataTable(list);
    }

    /**
     * 通用查询员工（编码或名称）
     */
    @GetMapping("/worker/search")
    public TableDataInfo searchWorker(@RequestParam(value = "searchText", required = false) String searchText) {
        startPage();
        List<ErpInfo> list = erpInfoService.searchWorker(searchText);
        return getDataTable(list);
    }

    /**
     * 通用查询物料（编码或名称）
     */
    @GetMapping("/material/search")
    public TableDataInfo searchMaterial(@RequestParam(value = "searchText", required = false) String searchText) {
        startPage();
        List<ErpInfo> list = erpInfoService.searchMaterial(searchText);
        return getDataTable(list);
    }

}
