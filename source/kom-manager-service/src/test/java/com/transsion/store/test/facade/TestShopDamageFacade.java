package com.transsion.store.test.facade;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.shangkang.core.exception.ServiceException;
import com.transsion.store.dto.ShopDamageInfoDto;
import com.transsion.store.facade.ShopDamageFacade;
import com.transsion.store.test.base.GenericTestCase;

public class TestShopDamageFacade extends GenericTestCase {
	private ShopDamageFacade shopDamageFacade;
	
	@Before
	protected void setUp() throws Exception {
		shopDamageFacade = this.getBean("shopDamageFacade");
	}
	
	@Test
	public void testQueryShopDamageList() throws ServiceException {
		long shopId = 1;
		List<ShopDamageInfoDto> list = shopDamageFacade.queryShopDamageList(shopId);
		for (ShopDamageInfoDto shopDamageInfoDto : list) {
			System.out.println(shopDamageInfoDto.toString());
		}
	}
}
