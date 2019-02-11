package com.open.springqianbailu.model.bean.excel;

import java.io.Serializable;
import java.util.ArrayList;

public class ExcelBean implements Serializable {
    private String filePath;
    private String fileName;
    private String[] excelTitle;
    private String sheetName;
    private ArrayList<ArrayList<String>> excelList;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String[] getExcelTitle() {
        return excelTitle;
    }

    public void setExcelTitle(String[] excelTitle) {
        this.excelTitle = excelTitle;
    }

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public ArrayList<ArrayList<String>> getExcelList() {
        return excelList;
    }

    public void setExcelList(ArrayList<ArrayList<String>> excelList) {
        this.excelList = excelList;
    }
}
