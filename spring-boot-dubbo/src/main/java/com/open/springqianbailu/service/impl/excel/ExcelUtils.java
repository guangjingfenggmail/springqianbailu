package com.open.springqianbailu.service.impl.excel;

import jxl.CellView;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {
	public static WritableFont arial14font = null;

	public static WritableCellFormat arial14format = null;
	public static WritableFont arial10font = null;
	public static WritableCellFormat arial10format = null;
	public static WritableFont arial12font = null;
	public static WritableCellFormat arial12format = null;

	public final static String UTF8_ENCODING = "UTF-8";
	public final static String GBK_ENCODING = "UTF-8";

	public static void format() {
		try {
			arial14font = new WritableFont(WritableFont.ARIAL, 14, WritableFont.BOLD);
			arial14font.setColour(jxl.format.Colour.LIGHT_BLUE);
			
			arial14format = new WritableCellFormat(arial14font);
			arial14format.setAlignment(jxl.format.Alignment.CENTRE);
			arial14format.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
			arial14format.setBackground(jxl.format.Colour.VERY_LIGHT_YELLOW);
			
			arial10font = new WritableFont(WritableFont.ARIAL, 12, WritableFont.BOLD);
			
			arial10format = new WritableCellFormat(arial10font);
			arial10format.setAlignment(jxl.format.Alignment.CENTRE);
			arial10format.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
			arial10format.setBackground(jxl.format.Colour.GOLD);
			
			arial12font = new WritableFont(WritableFont.ARIAL, 14);
			
			arial12format = new WritableCellFormat(arial12font);
			arial12format.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
			arial12format.setWrap(true);
		}
		catch (WriteException e) {

			e.printStackTrace();
		}
	}

	public static void initExcel(String sheetName,String fileName, String[] colName) {
		format();
		WritableWorkbook workbook = null;
		try {
			File file = new File(fileName);
			workbook = Workbook.createWorkbook(file);
			WritableSheet sheet = workbook.createSheet(sheetName, 0);
			sheet.addCell((WritableCell) new Label(0, 0, fileName, arial14format));
			for (int col = 0; col < colName.length; col++) {
				sheet.addCell(new Label(col, 0, colName[col], arial10format));
			}
			workbook.write();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (workbook != null) {
				try {
					workbook.close();
				}
				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public static <T> void writeObjListToExcel(List<T> objList, String fileName) {
		if (objList != null && objList.size() > 0) {
			WritableWorkbook writebook = null;
			InputStream in = null;
			try {
				WorkbookSettings setEncode = new WorkbookSettings();
				setEncode.setEncoding(UTF8_ENCODING);
				in = new FileInputStream(new File(fileName));
				Workbook workbook = Workbook.getWorkbook(in);
				writebook = Workbook.createWorkbook(new File(fileName), workbook);
				WritableSheet sheet = writebook.getSheet(0);
				
				CellView cellView = new CellView();  
			    cellView.setAutosize(true); //设置自动大小
				for (int j = 0; j < objList.size(); j++) {
					float isreturn = 0;

					ArrayList<String> list=(ArrayList<String>) objList.get(j);
					int len = list.get(0).length();
					for (int i = 0; i < list.size(); i++) {
						if (i==0) {
							cellView.setAutosize(true);  
						}else  {
							cellView.setAutosize(false);
							cellView.setDimension(50);
						}
						sheet.setColumnView(i, cellView);
						sheet.addCell(new Label(i, j+1, list.get(i), arial12format));
						if (len<list.get(i).length()){
							len = list.get(i).length();
						}
					}
					if (len>0) {
						isreturn = len / 50f;
					}
					sheet.setRowView(j+1, ((int)isreturn+1)*500, false); //设置行高
				}
				sheet.setRowView(objList.size(), 500, false); //设置行高
				writebook.write();
				System.out.println("保存成功");
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				if (writebook != null) {
					try {
						writebook.close();
					}
					catch (Exception e) {
						e.printStackTrace();
					}

				}
				if (in != null) {
					try {
						in.close();
					}
					catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

		}
	}

	public static Object getValueByRef(Class cls, String fieldName) {
		Object value = null;
		fieldName = fieldName.replaceFirst(fieldName.substring(0, 1), fieldName.substring(0, 1).toUpperCase());
		String getMethodName = "get" + fieldName;
		try {
			Method method = cls.getMethod(getMethodName);
			value = method.invoke(cls);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
}

