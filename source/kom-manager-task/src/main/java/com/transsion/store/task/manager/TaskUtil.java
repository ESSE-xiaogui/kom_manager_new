package com.transsion.store.task.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shangkang.tools.UtilHelper;

public class TaskUtil {
	/**
	 * 
	 *  
	 *
	 * @param arr  二维数组   excel导出的数据   数组里面的每一个数组 都是excel每一行  从左到右的 数据
	 * @param arrkey    excel 里面从左往右 每一列的对应的key   对应数组中  里面的数组 的顺序  
	 * @return
	 * 
	 */
	public static List<Map<String, Object>> formatArr(String[][] arr, String[] arrkey) {
		List<Map<String, Object>> result = new ArrayList<>();
		if (UtilHelper.isEmpty(arr)) {
			return null;
		}
		for (int i = 0; i < arr.length; i++) {
			String[] childArr = arr[i]; // 当前数组 和arrkey的长度 相同
			if (!vaildArr(childArr)) {
				break;
			}
			int childLength = childArr.length;
			if (childArr.length > arrkey.length) { // 且 必须是小于等于 arrkey的长度 如果大于
													// 则只取 arrkey的长度内的数据
				childLength = arrkey.length;
			}
			Map<String, Object> m = new HashMap<String, Object>();
			for (int a = 0; a < childLength; a++) {
				String value = childArr[a];
				String key = arrkey[a];
				m.put(key, value);
			}
			result.add(m);
		}

		return result;
	}
	/**
	 * 检索数据是否为空
	 * */
	public static boolean vaildArr(String[] arr) {
		if (UtilHelper.isEmpty(arr)) {
			return false;
		}
		int i = 0;
		for (String a : arr) {
			if (UtilHelper.isEmpty(a)) {
				i++;
			}
		}
		if (i >= arr.length) {
			return false;
		}
		return true;
	}
}
