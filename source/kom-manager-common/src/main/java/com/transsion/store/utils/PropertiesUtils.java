package com.transsion.store.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.ResourceBundle;

public class PropertiesUtils {
	public static ResourceBundle res = null;
	static {
		try {
			res = ResourceBundle.getBundle("config");
		} catch (Exception ex) {

		}
	}
	/**
	 * 非实时读取,properties配置文件属性值 - 按属性名称读取-默认读取conf.properties文件
	 * @param propertiesName : 属性名称
	 * @return String
	 */
	public static String readProperties(String propertiesName){
		String value = null;
		if(res != null){
			value = res.getString(propertiesName);
		}
		return value;
	}
	
	/**
	 * 实时读取,properties配置文件属性值 - 按属性名称读取-默认读取conf.properties文件
	 * 
	 * @param propertiesName
	 *            ：属性名称
	 * @param fileName
	 *            ：文件名称-只加载properties文件
	 * @return String
	 */
	public static String rtReadProperties(String propertiesName, String fileName) {
		String value = null;
		try {
			if (fileName != null) {
				StringBuffer buffer = new StringBuffer(fileName);
				if (fileName.indexOf(".") == -1) {
					buffer.append(".properties");
				}
				String path = PropertiesUtils.class.getClassLoader().getResource(buffer.toString()).getPath();
				FileInputStream in = new FileInputStream(path);
				Properties properties = new Properties();
				properties.load(in);
				if (propertiesName != null) {
					value = properties.getProperty(propertiesName);
				}
			} else {
				if (propertiesName != null) {
					value = res.getString(propertiesName);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	
	/**
	 * 修改properties文件属性的值
	 * @param key
	 * @param value
	 * @param fileName
	 */
	public static void setProperties(String key,String value, String fileName){
		InputStream fis = null;
		OutputStream fos = null;
		try {
			StringBuffer buffer = new StringBuffer(fileName);
			if (fileName.indexOf(".") == -1) {
				buffer.append(".properties");
			}
			String path = PropertiesUtils.class.getClassLoader()
					.getResource(buffer.toString()).getPath();
			File file = new File(path);
			fis = new FileInputStream(file);  

			Properties properties = new Properties();
			properties.load(fis);
			
	        fis.close();//一定要在修改值之前关闭fis
	        fos = new FileOutputStream(file);  
	        properties.setProperty(key, value);  
	        properties.store(fos, "Update '" + key + "' value");  
	        fos.close();  
		} catch (Exception e) {
			e.printStackTrace();
		}finally{  
            try {  
                fos.close();  
                fis.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }
	}
	
	public static void main(String[] args) {
//		System.out.println(PropertiesUtils.readProperties("task.init.status"));
		System.out.println("修改前的值：" + PropertiesUtils.rtReadProperties("task.init.status","job"));
		
		PropertiesUtils.setProperties("task.init.status", "0", "job");
		
		System.out.println("修改后的值：" + PropertiesUtils.rtReadProperties("task.init.status","job"));
	}
}
