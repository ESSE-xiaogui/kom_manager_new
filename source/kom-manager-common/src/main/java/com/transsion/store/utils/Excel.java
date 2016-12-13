package com.transsion.store.utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class Excel {
	File file = null;
	private Workbook workbook = null;
	private static final SimpleDateFormat Date_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	
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
	
	public  String[][]  getData(int ignoreRows){
		int rowSize = 0;
		int cellSize = 0;
		List<String[]>  rowList = new ArrayList<String[]>();
		for(int i=0, sSize=workbook.getNumberOfSheets(); i<sSize ;++i){
			Sheet sheet = workbook.getSheetAt(i);
			for(int j=ignoreRows, rSize=sheet.getLastRowNum(); j<=rSize ;++j){
				Row row = sheet.getRow(j);
			    if (row == null) {
                  continue;
                }
			    int tempCellSize = row.getLastCellNum() + 1; //当前单元格的一列 总条数
                if (tempCellSize > cellSize) {
                  cellSize = tempCellSize;
                }
                String[] values = new String[cellSize]; // 创建一个数组 且 必须是比单元格一列的总数 要多  
                Arrays.fill(values, ""); //填充数组
				for(int k=0,cSize=row.getLastCellNum(); k<cSize; ++k){
					Object value ="";
					Cell cell=row.getCell(k);
					if(cell != null){
						int cellType = cell.getCellType(); //获取当前单元格内容
						if(cellType == Cell.CELL_TYPE_FORMULA){
							cellType = cell.getCachedFormulaResultType();
						}
						switch(cellType){
							case Cell.CELL_TYPE_NUMERIC: //数字类型
		                         if (HSSFDateUtil.isCellDateFormatted(cell)) { //判断是否是日期
		                            Date date = cell.getDateCellValue();
		                            if (date != null) {
		                                value = Date_FORMAT.format(date);
		                            } else {
		                                value = "";
		                            }
		                         } else { 
		                            value = new DecimalFormat("0").format(cell.getNumericCellValue());
		                         }
		                         break;
							case Cell.CELL_TYPE_STRING:
								value = cell.getStringCellValue();
								break;
							case Cell.CELL_TYPE_BLANK:
								value = null;
								break;
							case Cell.CELL_TYPE_BOOLEAN:
								value = cell.getBooleanCellValue();
								break;
							case Cell.CELL_TYPE_ERROR:
								value = null;
								break;
							default:
								value = null;
						}
					}
					values[k] = value == null?"":value.toString();
				}
				rowList.add(values);
			}
		}

       String[][] returnArray = new String[rowList.size()][rowSize];

       for (int i = 0; i < returnArray.length; i++) {

           returnArray[i] = (String[]) rowList.get(i);

       }
		return returnArray;
	}
/*	public static void main(String[] args) {
		File file = new File("C:/Users/guihua.zhang/Desktop/tecno1.xlsx");
		Excel e = new Excel(file);
		String [] [] dataArr = e.getData(1);
		List<SaleTaskDto> saleTaskDtoList = new ArrayList<SaleTaskDto>();
		for(int i=0;i<dataArr.length;i++){		
			SaleTaskDto saleTaskDto = new SaleTaskDto();
			for(int j=0;j<dataArr[i].length;j++){
				saleTaskDto.setSaleDate(dataArr[i][0]);
				saleTaskDto.setShopCode(dataArr[i][1]);
				saleTaskDto.setUserCode(dataArr[i][2]);
				saleTaskDto.setImeiNo(dataArr[i][3]);
				saleTaskDto.setPrice(new BigDecimal(dataArr[i][4]));
			}
			saleTaskDtoList.add(saleTaskDto);
		}
		
		System.out.println(saleTaskDtoList);
	}*/
}

