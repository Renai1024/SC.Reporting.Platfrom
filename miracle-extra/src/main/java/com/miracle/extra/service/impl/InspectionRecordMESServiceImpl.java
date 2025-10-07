package com.miracle.extra.service.impl;

import java.util.*;

import com.miracle.common.exception.ServiceException;
import com.miracle.common.utils.DateUtils;
import com.miracle.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.miracle.extra.mapper.InspectionRecordMESMapper;
import com.miracle.extra.domain.InspectionRecordMES;
import com.miracle.extra.service.IInspectionRecordMESService;
import org.springframework.transaction.annotation.Transactional;


/**
 * 检验数据Service业务层处理
 * 
 * @author miracle
 * @date 2025-09-24
 */
@Service
public class InspectionRecordMESServiceImpl implements IInspectionRecordMESService 
{
    @Autowired
    private InspectionRecordMESMapper inspectionRecordMESMapper;

    /**
     * 查询检验数据
     * 
     * @param id 检验数据主键
     * @return 检验数据
     */
    @Override
    public InspectionRecordMES selectInspectionRecordMESById(Long id)
    {
        return inspectionRecordMESMapper.selectInspectionRecordMESById(id);
    }

    @Override
    public InspectionRecordMES selectInspectionRecordMESBySerialNumber(String serialNumber) {
        return inspectionRecordMESMapper.selectInspectionRecordMESBySerialNumber(serialNumber);
    }

    /**
     * 查询检验数据列表
     * 
     * @param inspectionRecordMES 检验数据
     * @return 检验数据
     */
    @Override
    public List<InspectionRecordMES> selectInspectionRecordMESList(InspectionRecordMES inspectionRecordMES)
    {
        return inspectionRecordMESMapper.selectInspectionRecordMESList(inspectionRecordMES);
    }

    /**
     * 新增工序一检验数据*
     * @param inspectionRecordMES 检验数据
     * @return 结果
     */
    @Transactional
    @Override
    public int insertInspectionRecordMES1(InspectionRecordMES inspectionRecordMES)
    {
        Date now = DateUtils.getNowDate();
        inspectionRecordMES.setCreateTime1(now);
        String createBy = SecurityUtils.getLoginUser().getUser().getNickName();
        inspectionRecordMES.setCreateBy1(createBy);
        if(inspectionRecordMESMapper.selectInspectionRecordMESBySerialNumberCount1(inspectionRecordMES.getSerialNumber()) >= 1){
            throw new ServiceException("该序列号：" + inspectionRecordMES.getSerialNumber() + "已绑定17.5尺寸&47.5尺寸，不允许重复操作！");
        }
        int mainCount = inspectionRecordMESMapper.selectInspectionRecordMESBySerialNumberCount(inspectionRecordMES.getSerialNumber());

        if(mainCount > 1){
            throw new ServiceException("该序列号：" + inspectionRecordMES.getSerialNumber() + "在主表中存在多条记录，请联系管理员！");
        }
        int resultCount = inspectionRecordMESMapper.insertInspectionRecordMES1(inspectionRecordMES);
        if(resultCount > 0){
            if(mainCount == 1){
                inspectionRecordMESMapper.updateInspectionRecordMES(inspectionRecordMES);
            }else{
                inspectionRecordMESMapper.insertInspectionRecordMES(inspectionRecordMES);
            }
        }
        return resultCount;
    }

    /**
     * 新增工序二检验数据*
     * @param inspectionRecordMES 检验数据
     * @return 结果
     */
    @Transactional
    @Override
    public int insertInspectionRecordMES2(InspectionRecordMES inspectionRecordMES)
    {
        Date now = DateUtils.getNowDate();
        inspectionRecordMES.setCreateTime2(now);
        String createBy = SecurityUtils.getLoginUser().getUser().getNickName();
        inspectionRecordMES.setCreateBy2(createBy);
        if(inspectionRecordMESMapper.selectInspectionRecordMESBySerialNumberCount2(inspectionRecordMES.getSerialNumber()) >= 1){
            throw new ServiceException("该序列号：" + inspectionRecordMES.getSerialNumber() + "已绑定610尺寸，不允许重复操作！");
        }
        int mainCount = inspectionRecordMESMapper.selectInspectionRecordMESBySerialNumberCount(inspectionRecordMES.getSerialNumber());

        if(mainCount > 1){
            throw new ServiceException("该序列号：" + inspectionRecordMES.getSerialNumber() + "在主表中存在多条记录，请联系管理员！");
        }
        int resultCount = inspectionRecordMESMapper.insertInspectionRecordMES2(inspectionRecordMES);
        if(resultCount > 0){
            if(mainCount == 1){
                inspectionRecordMESMapper.updateInspectionRecordMES(inspectionRecordMES);
            }else{
                inspectionRecordMESMapper.insertInspectionRecordMES(inspectionRecordMES);
            }
        }
        return resultCount;
    }

    /**
     * 新增工序三检验数据*
     * @param inspectionRecordMES 检验数据
     * @return 结果
     */
    @Transactional
    @Override
    public int insertInspectionRecordMES3(InspectionRecordMES inspectionRecordMES)
    {
        Date now = DateUtils.getNowDate();
        System.out.println("操作时间：" + now);
        inspectionRecordMES.setCreateTime3(now);
        String createBy = SecurityUtils.getLoginUser().getUser().getNickName();
        inspectionRecordMES.setCreateBy3(createBy);
        if(inspectionRecordMESMapper.selectInspectionRecordMESBySerialNumberCount3(inspectionRecordMES.getSerialNumber()) >= 1){
            throw new ServiceException("该序列号：" + inspectionRecordMES.getSerialNumber() + "已绑定外观检验，不允许重复操作！");
        }
        int mainCount = inspectionRecordMESMapper.selectInspectionRecordMESBySerialNumberCount(inspectionRecordMES.getSerialNumber());

        if(mainCount > 1){
            throw new ServiceException("该序列号：" + inspectionRecordMES.getSerialNumber() + "在主表中存在多条记录，请联系管理员！");
        }
        int resultCount = inspectionRecordMESMapper.insertInspectionRecordMES3(inspectionRecordMES);
        if(resultCount > 0){
            if(mainCount == 1){
                inspectionRecordMESMapper.updateInspectionRecordMES(inspectionRecordMES);
            }else{
                inspectionRecordMESMapper.insertInspectionRecordMES(inspectionRecordMES);
            }
        }
        return resultCount;
    }

    /**
     * 修改检验数据
     * 
     * @param inspectionRecordMES 检验数据
     * @return 结果
     */
    @Transactional
    @Override
    public int updateInspectionRecordMES(InspectionRecordMES inspectionRecordMES)
    {
        return inspectionRecordMESMapper.updateInspectionRecordMES(inspectionRecordMES);
    }

    /**
     * 箱码绑定
     * @param serialNumbers 序列号集合
     * @param boxCode 箱码
     * @return 影响行数
     */
    @Transactional
    @Override
    public int updateInspectionRecordMES(String[] serialNumbers, String boxCode) {
        int hasBoxCode = inspectionRecordMESMapper.selectInspectionRecordMESByBoxCodeCount(boxCode);
        int successCount = 0;
        Map<String,String> updateErrors = new HashMap<>();
        Map<String,String> checkedErrors = new HashMap<>();
        if(hasBoxCode > 0){
            throw new ServiceException("该箱码：" + boxCode + "已被绑定，不允许重复操作！");
        }
        for (String serialNumber : serialNumbers){
            InspectionRecordMES result = inspectionRecordMESMapper.selectInspectionRecordMESBySerialNumber(serialNumber);
            if(result == null ){
                throw new ServiceException("该序列号：" + serialNumber + "不存在，请仔细检查！");
            }
            String result1 = result.getResult1();
            String result2 = result.getResult3();
            String result3 = result.getAppearanceInspection();
            String boxCodeAlready = result.getBoxCode();
            if(result1 ==  null || result1.isEmpty()){
                checkedErrors.put(serialNumber, "序列号：" + serialNumber + "未完成17.5尺寸&47.5尺寸检验，不允许绑定箱码！");
            }
            if(result2 ==  null || result2.isEmpty()){
                checkedErrors.put(serialNumber, "序列号：" + serialNumber + "未完成610尺寸检验，不允许绑定箱码！");
            }
            if(result3 ==  null || result3.isEmpty()){
                checkedErrors.put(serialNumber, "序列号：" + serialNumber + "未完成外观检验，不允许绑定箱码！");
            }
            if(boxCodeAlready != null && !boxCodeAlready.isEmpty()){
                checkedErrors.put(serialNumber, "序列号：" + serialNumber + "已绑定箱码：" + boxCodeAlready + "不允许重复绑定！");
            }
        }if(!checkedErrors.isEmpty()){
            StringBuilder errorMessage = new StringBuilder();
            for (int i = 0;i < checkedErrors.size(); i++){
                errorMessage.append(checkedErrors.values()).append("\n");
            }
            throw new ServiceException(errorMessage.toString());
        }else{
            for (String serialNumber : serialNumbers){
                InspectionRecordMES params = new InspectionRecordMES();
                params.setSerialNumber(serialNumber);
                params.setBoxCode(boxCode);
                int resultCount = inspectionRecordMESMapper.updateInspectionRecordMES(params);
                if(resultCount <= 0){
                    updateErrors.put(serialNumber, "序列号：" + serialNumber + "绑定箱码失败！");
                }else if(resultCount > 1){
                    updateErrors.put(serialNumber, "序列号：" + serialNumber + "绑定箱码条数异常，绑定箱码条数为：" + resultCount + "条!");
                }else{
                    successCount++;
                }
            }
            if(!updateErrors.isEmpty()){
                StringBuilder errorMessage = new StringBuilder();
                for (int i = 0;i < updateErrors.size(); i++){
                    errorMessage.append(updateErrors.values()).append("\n");
                }
                throw new ServiceException(errorMessage.toString());
            }
            if(successCount != serialNumbers.length){
                throw new ServiceException("箱码绑定条数异常！需绑定箱码数：" + serialNumbers.length + "，成功绑定数：" + successCount + "请联系管理员处理！");
            }else return successCount;
        }
    }

    /**
     * 箱码绑定
     * @param boxCode 箱码
     * @param customerBoxCode 客户箱码
     * @return 影响行数
     */
    @Override
    public int updateInspectionRecordMES(String boxCode, String customerBoxCode) {
        List<InspectionRecordMES> boxCodeResultList = inspectionRecordMESMapper.selectInspectionRecordMESByBoxCode(boxCode);
        List<InspectionRecordMES> customerBoxCodeResultList = inspectionRecordMESMapper.selectInspectionRecordMESByCustomerBoxCode(customerBoxCode);
        List<String> boxCodes = new ArrayList<>();
        List<String> customerBoxCodes = new ArrayList<>();
        if(boxCodeResultList.isEmpty()){
            throw new ServiceException("箱码：" + boxCode + "不存在，请仔细检查！");
        }else if(!customerBoxCodeResultList.isEmpty()){
            for (InspectionRecordMES inspectionRecordMES : customerBoxCodeResultList){
                if(!boxCodes.contains(inspectionRecordMES.getBoxCode())) {
                    boxCodes.add(inspectionRecordMES.getBoxCode());
                }
            }
            throw new ServiceException("客户箱码：" + customerBoxCode + "已绑定箱码：" + boxCodes + "，不允许重复绑定！");
        }else {
            for (InspectionRecordMES inspectionRecordMES : boxCodeResultList) {
                String CBoxCode = inspectionRecordMES.getCustomerBoxCode();
                if (CBoxCode != null && !CBoxCode.isEmpty() && !customerBoxCodes.contains(CBoxCode)) {
                    customerBoxCodes.add(CBoxCode);
                }
            }
            if(!customerBoxCodes.isEmpty()){
                throw new ServiceException("箱码：" + boxCode + "已绑定客户箱码：" + customerBoxCodes + "，不允许重复绑定！");
            }
        }
        return inspectionRecordMESMapper.updateInspectionRecordMESCustomerBoxCode(boxCode, customerBoxCode);
    }

    /**
     * 批量删除检验数据
     * 
     * @param ids 需要删除的检验数据主键
     * @return 结果
     */
    @Override
    public int deleteInspectionRecordMESByIds(Long[] ids)
    {
        return inspectionRecordMESMapper.deleteInspectionRecordMESByIds(ids);
    }

    /**
     * 删除检验数据信息
     * 
     * @param id 检验数据主键
     * @return 结果
     */
    @Override
    public int deleteInspectionRecordMESById(Long id)
    {
        String serialNumber = inspectionRecordMESMapper.selectInspectionRecordMESById(id).getSerialNumber();
        int resultCount1 = inspectionRecordMESMapper.deleteInspectionRecordMESBySerialNumber1(serialNumber);
        int resultCount2 = inspectionRecordMESMapper.deleteInspectionRecordMESBySerialNumber2(serialNumber);
        int resultCount3 = inspectionRecordMESMapper.deleteInspectionRecordMESBySerialNumber3(serialNumber);
        int resultCount;
        if(resultCount1 <= 0 && resultCount2 <= 0 && resultCount3 <= 0){
            throw new ServiceException("该序列号：" + serialNumber + "在子表中不存在，请检查联系管理员！");
        }else{
            resultCount = inspectionRecordMESMapper.deleteInspectionRecordMESById(id);
        }
        return resultCount;
    }
}
