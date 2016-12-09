package com.transsion.store.utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	File file = null;
	private Workbook workbook = null;
	
	private static final SimpleDateFormat UTC_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
	private static final SimpleDateFormat PRC_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
	static {
		UTC_FORMAT.setTimeZone(TimeZone.getTimeZone("UTC"));
		PRC_FORMAT.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
	}
	
	public static Excel create(File file){
		Excel excel = new Excel(file);
		if(excel.workbook == null){
			return null;
		}
		
		return excel;
	}
	
	public static Excel create(String path){
		File file = new File(path);
		return create(file);
	}
	
	public Excel(File file){
		this.file = file;
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(file);
		} catch (Exception e) {
			fis = null;
			return;
		}
		
		try {
			workbook = new XSSFWorkbook(fis);
		} catch (IOException e) {
			workbook = null;
		}
		
		if(fis != null){
			try {
				fis.close();
			} catch (IOException e) {
			}finally{
				fis = null;
			}
		}
		
		if(workbook == null){
			try {
				fis = new FileInputStream(file);
			} catch (Exception e) {
				fis = null;
				return;
			}
			
			try {
				workbook = new HSSFWorkbook(fis);
			} catch (IOException e) {
				workbook = null;
			}
			
			if(fis != null){
				try {
					fis.close();
				} catch (IOException e) {
				}finally{
					fis = null;
				}
			}
		}
	}
	
	public Map<String, Object> toMap(){
		Map<String, Object> excelJson = new HashMap<String, Object>();
		excelJson.put("name", file.getName());
		List<Map<String, Object>> sheetsJson = new ArrayList<Map<String, Object>>();
		for(int i=0, sSize=workbook.getNumberOfSheets(); i<sSize ;++i){
			Map<String, Object> sheetJson = new HashMap<String, Object>();
			sheetJson.put("index", i);
			Sheet sheet = workbook.getSheetAt(i);
			sheetJson.put("name", sheet.getSheetName());
			List<Map<String, Object>> rowsJson = new ArrayList<Map<String, Object>>();
			for(int j=0, rSize=sheet.getLastRowNum(); j<=rSize ;++j){
				Map<String, Object> rowJson = new HashMap<String, Object>();
				rowJson.put("index", j);
				Row row = sheet.getRow(j);
				List<Map<String, Object>> cellsJson = new ArrayList<Map<String, Object>>();
				if(row != null){
					for(int k=0,cSize=row.getLastCellNum(); k<cSize; ++k){
						Map<String, Object> cellJson = new HashMap<String, Object>();
						cellJson.put("index", k);
						Cell cell=row.getCell(k);
						if(cell != null){
							int cellType = cell.getCellType();
							if(cellType == Cell.CELL_TYPE_FORMULA){
								cellType = cell.getCachedFormulaResultType();
							}
							cellJson.put("type", cellType);
							switch(cellType){
							case Cell.CELL_TYPE_NUMERIC:
								cellJson.put("value", cell.getNumericCellValue());
								if(DateUtil.isCellDateFormatted(cell)){
									cellJson.put("type", 101);
									cellJson.put("stamp", cell.getDateCellValue().getTime());
									cellJson.put("utc", UTC_FORMAT.format(cell.getDateCellValue()));
									cellJson.put("prc", PRC_FORMAT.format(cell.getDateCellValue()));
								}
								break;
							case Cell.CELL_TYPE_STRING:
								cellJson.put("value", cell.getStringCellValue());
								break;
							case Cell.CELL_TYPE_BLANK:
								cellJson.put("value", null);
								break;
							case Cell.CELL_TYPE_BOOLEAN:
								cellJson.put("value", cell.getBooleanCellValue());
								break;
							case Cell.CELL_TYPE_ERROR:
								cellJson.put("value", null);
								break;
							default:
								cellJson.put("value", null);
							}
						}else{
							cellJson.put("type", Cell.CELL_TYPE_BLANK);
						}
						cellsJson.add(cellJson);
					}
				}
				rowJson.put("cells", cellsJson);
				rowsJson.add(rowJson);
			}
			sheetJson.put("rows", rowsJson);
			sheetsJson.add(sheetJson);
		}
		excelJson.put("sheets", sheetsJson);
		return excelJson;
	}

	public static void main(String[] args) {
		Excel excel = Excel.create("C:/Users/guihua.zhang/Desktop/tecno1.xlsx");
		System.out.println(excel.toMap());
	}
}

