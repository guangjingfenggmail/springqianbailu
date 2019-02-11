package com.open.springqianbailu.service.impl.excel;

import com.alibaba.dubbo.config.annotation.Service;
import com.open.springqianbailu.model.bean.excel.ExcelBean;
import com.open.springqianbailu.service.excel.ExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Service(interfaceClass = ExcelService.class) //dubbo的service，注入接口
public class ExcelServiceImpl implements ExcelService {

    public  String TAG = getClass().getSimpleName();
    public Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());

    @Override
    public void writeObjListToExcel(ExcelBean bean) {
        try {
            ExcelUtils.initExcel(bean.getSheetName(),bean.getFilePath()+"/"+bean.getFileName(), bean.getExcelTitle());
            ExcelUtils.writeObjListToExcel(bean.getExcelList(), bean.getFilePath()+"/"+bean.getFileName());
        }catch (Exception e){
            logger.error(TAG+e.toString());
        }
    }

    @Override
    public ExcelBean readExcel(String fileName) {
        return null;
    }
}
