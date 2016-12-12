package com.taobao.yugong.translator;

import com.taobao.yugong.common.db.meta.ColumnValue;
import com.taobao.yugong.common.model.record.Record;

public abstract class  BaseDataTranslator extends AbstractDataTranslator implements DataTranslator {
	
	public BaseDataTranslator(){
	}
	
	public boolean translator(Record record) {
		System.out.println(record);
		record.setSchemaName("kom");
		record.setTableName(getTableName());
		
		String[] srcColumns= getSrcColumnNames(); 
		String[] destColumns= getDestColumnNames();
		if (srcColumns != null && destColumns != null && srcColumns.length == destColumns.length && srcColumns.length > 0) {
			for(int i = 0; i < srcColumns.length; i++) {
				ColumnValue nameColumn = record.getColumnByName(srcColumns[i]);
		        nameColumn.getColumn().setName(destColumns[i]);
			}
			
			String[] deleteColumns = getSrcDeleteColumnNames();
			if (deleteColumns != null && deleteColumns.length > 0) {
				for (int i = 0; i < deleteColumns.length; i++) {
					record.removeColumnByName(deleteColumns[i]);
				}
			}
		} else {
			return false;
		}
		return true;
	}
	
	public abstract String getTableName();
		
	public abstract String[] getSrcColumnNames();
	
	public abstract String[] getDestColumnNames();
	
	public abstract String[] getSrcDeleteColumnNames();
}
