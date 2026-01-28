package com.miracle.extra.service

import com.miracle.extra.domain.MesReportDuanziyajieji
    /**
     * 端子压接机数据Service接口
     *
     * @author miracle
     * @date 2025-12-22
     */
    interface IMesReportDuanziyajiejiService {

        /**
         * 查询端子压接机数据
         *
         * @param id 端子压接机数据主键
         * @return 端子压接机数据
         */
        fun selectMesReportDuanziyajiejiById(id: Long): MesReportDuanziyajieji?

        /**
         * 查询端子压接机数据列表
         *
         * @param mesReportDuanziyajieji 端子压接机数据
         * @return 端子压接机数据集合
         */
        fun selectMesReportDuanziyajiejiList(mesReportDuanziyajieji: MesReportDuanziyajieji): List<MesReportDuanziyajieji>

        /**
         * 新增端子压接机数据
         *
         * @param mesReportDuanziyajieji 端子压接机数据
         * @return 结果
         */
        fun insertMesReportDuanziyajieji(mesReportDuanziyajieji: MesReportDuanziyajieji): Int

        /**
         * 修改端子压接机数据
         *
         * @param mesReportDuanziyajieji 端子压接机数据
         * @return 结果
         */
        fun updateMesReportDuanziyajieji(mesReportDuanziyajieji: MesReportDuanziyajieji): Int

        /**
         * 批量删除端子压接机数据
         *
         * @param ids 需要删除的端子压接机数据主键集合
         * @return 结果
         */
        fun deleteMesReportDuanziyajiejiByIds(ids: Array<Long>): Int

        /**
         * 删除端子压接机数据信息
         *
         * @param id 端子压接机数据主键
         * @return 结果
         */
        fun deleteMesReportDuanziyajiejiById(id: Long): Int
}