package com.transsion.store.test.manager;

import java.text.SimpleDateFormat;
import java.util.Date;

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
		shopDamageManager = this.getBean("shopDamageManager");
    }
	
	@Test
	public void  testSaveOrUpdateShopDamage() throws ServiceException {
		String token = "eyJhbGciOiJIUzI1NiIsImNhbGciOiJHWklQIn0.H4sIAAAAAAAAAKtWKi5NUrJS8nM3MDK2UNJRSq0oULIyNLGwNLEwtzA2qAUACpjF6yEAAAA.eKoALd56L1_PPkw3H-7f6Q_NadRszPSN9rO2xIzX908";
		ShopDamageInfoDto shopDamageInfoDto = new ShopDamageInfoDto();
		shopDamageInfoDto.setShopId((long)1);
		shopDamageInfoDto.setMaterielId((long)1);
		shopDamageInfoDto.setDamageTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		shopDamageInfoDto.setDescription("This materiel is bad.");
		shopDamageInfoDto.setImgFirstUrl("/first.jpg");
		shopDamageInfoDto.setImgSecondUrl("/second.jpg");
		shopDamageInfoDto.setImgThirdUrl("/third.jpg");
		shopDamageInfoDto.setRemark("ok");
		shopDamageManager.saveOrUpdateShopDamage(token, shopDamageInfoDto);
	}
}
