package com.transsion.store.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.exception.ServiceException;
import com.transsion.store.dto.ShopDamageDto;
import com.transsion.store.mapper.ShopDamageMapper;
import com.transsion.store.utils.ExcelUtils;

@Service("shopDamageManager")
public class ShopDamageManager {
	@Autowired
	private ShopDamageMapper shopDamageMapper;
	
	public byte[] getShopDamageListByExcel(ShopDamageDto shopDamageDto) throws ServiceException {
		String[] headers = {"事业部","报修单号","损坏日期","国家","城市","门店编码","门店名称","用户名", "员工姓名", "职位","物料名称(CN)", "物料名称(EN)","上传时间"};
		List<ShopDamageDto> list = shopDamageMapper.queryListByProperty(shopDamageDto);
		List<Object[]> dataset = new ArrayList<Object[]>();
		for(ShopDamageDto shopDamage :list){
			dataset.add(
					new Object[]{
							shopDamage.getCompanyName(),
							shopDamage.getDamageId(),
							shopDamage.getDamageTime(),
							shopDamage.getCountryName(),
							shopDamage.getCityName(),
							shopDamage.getShopCode(),
							shopDamage.getShopName(),
							shopDamage.getCreateBy(),
							shopDamage.getEmpName(),
							shopDamage.getDutyName(),
							shopDamage.getNameCn(),
							shopDamage.getNameEn(),
							shopDamage.getCreateTime()
				});
		}
		String title = "报修报损报表";
		return ExcelUtils.exportExcel(title, headers, dataset);
	
	}
}
