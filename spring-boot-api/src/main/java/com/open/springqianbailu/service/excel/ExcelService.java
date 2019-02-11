package com.open.springqianbailu.service.excel;

import com.open.springqianbailu.model.bean.excel.ExcelBean;

public interface ExcelService {

    /**
     * 生成excel
     *
     * @param bean
     */
    void writeObjListToExcel(ExcelBean bean);


    /**
     *
     * 读取excel
     *
     * @param fileName
     * @return
     */
    ExcelBean readExcel(String fileName);
}
