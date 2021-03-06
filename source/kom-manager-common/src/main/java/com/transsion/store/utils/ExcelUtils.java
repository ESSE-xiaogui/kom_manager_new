package com.transsion.store.utils;

import com.shangkang.tools.DateHelper;
import com.shangkang.tools.UtilHelper;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 * @author shiwt java读取excel文件 一个Excel文件的层次：Excel文件->工作表->行->单元格
 *         对应到POI中，为：workbook->sheet->row->cell
 *
 */
public class ExcelUtils {

	static Logger logger = LoggerFactory.getLogger(ExcelUtils.class);

	/**
	 * 读取excel，遍历各个小格获取其中信息
	 */
	public static List<Map<String, String>> readExcel(String tagertPath) {
		try {
			if(UtilHelper.isEmpty(tagertPath))
				return null;

			// 创建对Excel工作簿文件的引用
			Workbook workbook = null;
			if(tagertPath.toLowerCase().endsWith(".xlsx"))
				workbook = new XSSFWorkbook(new FileInputStream(tagertPath));
			else
				workbook = new HSSFWorkbook(new FileInputStream(tagertPath));

			if (null != workbook.getSheetAt(0)) {
				Sheet sheet = workbook.getSheetAt(0);// 获得一个sheet

				List<Map<String, String>> list = new ArrayList<Map<String, String>>();
				int maxRowNum = sheet.getLastRowNum();
				for (int rowNum = 0; rowNum <= maxRowNum; rowNum++) {
					if (null != sheet.getRow(rowNum)) {
						Row row = sheet.getRow(rowNum);

						Map<String, String> map = new HashMap<String, String>();
						for (int cellNumOfRow = 0; cellNumOfRow < row.getLastCellNum(); cellNumOfRow++) {
							if (null != row.getCell(cellNumOfRow)) {
								Cell cell = row.getCell(cellNumOfRow);
								int cellType = cell.getCellType();

								String value = null;
								switch (cellType) {
								case Cell.CELL_TYPE_FORMULA:
									// cell.getCellFormula();
									try {
										value = String.valueOf(cell.getNumericCellValue());
									} catch (IllegalStateException e) {
										value = String.valueOf(cell.getRichStringCellValue());
									}
									break;
								case Cell.CELL_TYPE_NUMERIC:// Numeric
									if (DateUtil.isCellDateFormatted(cell)) {
										value = DateHelper.format(cell.getDateCellValue(), DateHelper.TIME_PATTERN_DEFAULT);
									} else {
										Long l = (long) cell.getNumericCellValue();

										if (l == cell.getNumericCellValue())
											value = String.valueOf(l);
										else
											value = String.valueOf(cell.getNumericCellValue()).trim();
									}
									break;
								case Cell.CELL_TYPE_STRING:// String
									value = cell.getStringCellValue();
									break;
								case Cell.CELL_TYPE_BLANK:
									value = "";
									break;
								default:
									value = "";
									break;
								}
								if(value != null && "end".equals(value))
									return list;

								map.put("" + cellNumOfRow, value);
							}
						}
						list.add(map);
					}
				}
				return list;
			}
		} catch (Exception e) {
			logger.debug("读Excel文件出错：", e);
			e.printStackTrace();
		}

		return null;
	}

	public static void exportExcel(String title, String[] headers,Collection<Object[]> dataset, OutputStream out) {
		// 声明一个工作薄
		SXSSFWorkbook workbook = new SXSSFWorkbook(100);
		// 生成一个表格
		Sheet sheet = workbook.createSheet(title);
		// 设置表格默认列宽度为15个字节
		sheet.setDefaultColumnWidth((short) 15);
		// 生成一个样式
		CellStyle style = workbook.createCellStyle();
		// 设置这些样式
		style.setFillForegroundColor(IndexedColors.SKY_BLUE.getIndex());
		style.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(XSSFCellStyle.BORDER_THIN);
		style.setBorderRight(XSSFCellStyle.BORDER_THIN);
		style.setBorderTop(XSSFCellStyle.BORDER_THIN);
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		// 生成一个字体
		Font font = workbook.createFont();
		font.setColor(IndexedColors.VIOLET.getIndex());
		font.setFontHeightInPoints((short) 12);
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		// 把字体应用到当前的样式
		style.setFont(font);
		// 生成并设置另一个样式
		CellStyle style2 = workbook.createCellStyle();
		style2.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
		style2.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
		style2.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		style2.setBorderLeft(XSSFCellStyle.BORDER_THIN);
		style2.setBorderRight(XSSFCellStyle.BORDER_THIN);
		style2.setBorderTop(XSSFCellStyle.BORDER_THIN);
		style2.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		style2.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
		// 生成另一个字体
		Font font2 = workbook.createFont();
		font2.setBoldweight(XSSFFont.BOLDWEIGHT_NORMAL);
		// 把字体应用到当前的样式
		style2.setFont(font2);
		// 声明一个画图的顶级管理器
		Drawing patriarch = sheet.createDrawingPatriarch();
		// 定义注释的大小和位置,详见文档
		Comment comment = patriarch.createCellComment(new XSSFClientAnchor(0, 0, 0, 0, (short) 4, 2, (short) 6, 5));
		// 设置注释内容
		comment.setString(new XSSFRichTextString("可以在POI中添加注释！"));
		// 设置注释作者，当鼠标移动到单元格上是可以在状态栏中看到该内容.
		comment.setAuthor("Liuzh");
		//产生表格标题行
		Row row = sheet.createRow(0);
		for (short i = 0; i < headers.length; i++) {
			Cell cell = row.createCell(i);
			cell.setCellStyle(style);
			RichTextString text = new XSSFRichTextString(headers[i]);
			cell.setCellValue(text);
		}
		//遍历集合数据，产生数据行
		Iterator<Object[]> it = dataset.iterator();
		int index = 0;
		while (it.hasNext()) {
			index++;
			row = sheet.createRow(index);
			Object[] fields =  it.next();
			for (short i = 0; i < fields.length; i++) {
				Cell cell = row.createCell(i);
				cell.setCellStyle(style2);
				Object value = fields[i];
				if(value == null) value = "";
				String textValue = null;
				if (value instanceof Integer) {
					cell.setCellType(XSSFCell.CELL_TYPE_NUMERIC);
					int intValue = (Integer) value;
					cell.setCellValue(intValue);
				} else if (value instanceof Float) {
					cell.setCellType(XSSFCell.CELL_TYPE_NUMERIC);
					float fValue = (Float) value;
					textValue = String.valueOf(fValue);
					cell.setCellValue(textValue);
				} else if (value instanceof Double) {
					cell.setCellType(XSSFCell.CELL_TYPE_NUMERIC);
					double dValue = (Double) value;
					//textValue = String.valueOf(dValue);
					cell.setCellValue(dValue);
				} else if (value instanceof Long) {
					cell.setCellType(XSSFCell.CELL_TYPE_NUMERIC);
					long longValue = (Long) value;
					cell.setCellValue(longValue);
				}else{
					cell.setCellType(XSSFCell.CELL_TYPE_STRING);
					cell.setCellValue(value.toString());
				}
				if (textValue != null) {
					Pattern p = Pattern.compile("^//d+(//.//d+)?$");
					Matcher matcher = p.matcher(textValue);
					if (matcher.matches()) {
						//是数字当作double处理
						cell.setCellValue(Double.parseDouble(textValue));

					} else {
						RichTextString richString = new XSSFRichTextString(textValue);
						Font font3 = workbook.createFont();
						font3.setColor(IndexedColors.BLUE.getIndex());
						richString.applyFont(font3);
						cell.setCellValue(richString);
					}
				}
			}
		}
		try {
			workbook.write(out);
			workbook.dispose();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static byte[] exportExcel(String title, String[] headers,Collection<Object[]> dataset) {
		// 声明一个工作薄
		SXSSFWorkbook workbook = new SXSSFWorkbook(500);
		// 生成一个表格
		Sheet sheet = workbook.createSheet(title);
		// 设置表格默认列宽度为15个字节
		sheet.setDefaultColumnWidth((short) 15);
		// 生成一个样式
		CellStyle style = workbook.createCellStyle();
		// 设置这些样式
		style.setFillForegroundColor(IndexedColors.SKY_BLUE.getIndex());
		style.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(XSSFCellStyle.BORDER_THIN);
		style.setBorderRight(XSSFCellStyle.BORDER_THIN);
		style.setBorderTop(XSSFCellStyle.BORDER_THIN);
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		// 生成一个字体
		Font font = workbook.createFont();
		font.setColor(IndexedColors.VIOLET.getIndex());
		font.setFontHeightInPoints((short) 12);
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		// 把字体应用到当前的样式
		style.setFont(font);
		// 生成并设置另一个样式
		CellStyle style2 = workbook.createCellStyle();
		style2.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
		style2.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
		style2.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		style2.setBorderLeft(XSSFCellStyle.BORDER_THIN);
		style2.setBorderRight(XSSFCellStyle.BORDER_THIN);
		style2.setBorderTop(XSSFCellStyle.BORDER_THIN);
		style2.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		style2.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
		// 生成另一个字体
		Font font2 = workbook.createFont();
		font2.setBoldweight(XSSFFont.BOLDWEIGHT_NORMAL);
		// 把字体应用到当前的样式
		style2.setFont(font2);
		// 声明一个画图的顶级管理器
		Drawing patriarch = sheet.createDrawingPatriarch();
		// 定义注释的大小和位置,详见文档
		Comment comment = patriarch.createCellComment(new XSSFClientAnchor(0, 0, 0, 0, (short) 4, 2, (short) 6, 5));
		// 设置注释内容
		comment.setString(new XSSFRichTextString("可以在POI中添加注释！"));
		// 设置注释作者，当鼠标移动到单元格上时可以在状态栏中看到该内容.
		comment.setAuthor("Liuzh");
		//产生表格标题行
		Row row = sheet.createRow(0);
		for (short i = 0; i < headers.length; i++) {
			Cell cell = row.createCell(i);
			cell.setCellStyle(style);
			RichTextString text = new XSSFRichTextString(headers[i]);
			cell.setCellValue(text);
		}
		//遍历集合数据，产生数据行
		Iterator<Object[]> it = dataset.iterator();
		int index = 0;
		while (it.hasNext()) {
			index++;
			row = sheet.createRow(index);
			Object[] fields =  it.next();
			for (short i = 0; i < fields.length; i++) {
				Cell cell = row.createCell(i);
				cell.setCellStyle(style2);
				Object value = fields[i];
				if(value == null) value = "";
				String textValue = null;
				if (value instanceof Integer) {
					cell.setCellType(XSSFCell.CELL_TYPE_NUMERIC);
					int intValue = (Integer) value;
					cell.setCellValue(intValue);
				} else if (value instanceof Float) {
					cell.setCellType(XSSFCell.CELL_TYPE_NUMERIC);
					float fValue = (Float) value;
					textValue = String.valueOf(fValue);
					cell.setCellValue(textValue);
				} else if (value instanceof Double) {
					cell.setCellType(XSSFCell.CELL_TYPE_NUMERIC);
					double dValue = (Double) value;
					//textValue = String.valueOf(dValue);
					cell.setCellValue(dValue);
				} else if (value instanceof Long) {
					cell.setCellType(XSSFCell.CELL_TYPE_NUMERIC);
					long longValue = (Long) value;
					cell.setCellValue(longValue);
				}else{
					cell.setCellType(XSSFCell.CELL_TYPE_STRING);
					cell.setCellValue(value.toString());
				}
				if (textValue != null) {
					Pattern p = Pattern.compile("^//d+(//.//d+)?$");
					Matcher matcher = p.matcher(textValue);
					if (matcher.matches()) {
						//是数字当作double处理
						cell.setCellValue(Double.parseDouble(textValue));

					} else {
						RichTextString richString = new XSSFRichTextString(textValue);
						Font font3 = workbook.createFont();
						font3.setColor(IndexedColors.BLUE.getIndex());
						richString.applyFont(font3);
						cell.setCellValue(richString);
					}
				}
			}
		}

		ByteArrayOutputStream os=new ByteArrayOutputStream();
		try {
			workbook.write(os);
			workbook.dispose();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return os.toByteArray();
	}

	/**
	 * 下载Excel
	 * @param title
	 * @param headers
	 * @param dataset
	 * @param path
	 * @return
	 */
	public static String downloadExcel(String title, String[] headers,List<Object[]> dataset,String path)
	{
		String fileName = title+new SimpleDateFormat("yyyyMMddHHmmss").format(System.currentTimeMillis())+".xls";
		try {
			OutputStream out = new FileOutputStream(path + fileName);

			ExcelUtils.exportExcel(title, headers, dataset, out);
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileName;
	}

}

