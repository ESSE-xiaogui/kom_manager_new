package com.transsion.store.test.manager;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.transsion.store.context.UserContext;
import org.junit.Before;
import org.junit.Test;

import com.shangkang.core.exception.ServiceException;
import com.transsion.store.dto.ShopDamageInfoDto;
import com.transsion.store.manager.ShopDamageManager;
import com.transsion.store.test.base.GenericTestCase;

public class TestShopDamageManager extends GenericTestCase {
	private ShopDamageManager shopDamageManager;
	
	@Before
    protected void setUp() throws Exception {
		super.setUp();
		shopDamageManager = this.getBean("shopDamageManager");
    }
	
	@Test
	public void  testSaveOrUpdateShopDamage() throws ServiceException {
		UserContext userContext = this.getUserContext("NG0238", "123456");
		ShopDamageInfoDto shopDamageInfoDto = new ShopDamageInfoDto();
		shopDamageInfoDto.setShopId((long)1);
		shopDamageInfoDto.setMaterielId((long)1);
		shopDamageInfoDto.setDamageTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		shopDamageInfoDto.setDescription("This materiel is bad.");
		shopDamageInfoDto.setImgFirstUrl("/first.jpg");
		shopDamageInfoDto.setImgSecondUrl("/second.jpg");
		shopDamageInfoDto.setImgThirdUrl("/third.jpg");
		shopDamageInfoDto.setRemark("ok");
		shopDamageManager.saveOrUpdateShopDamage(userContext.getToken(), shopDamageInfoDto);
	}
}
