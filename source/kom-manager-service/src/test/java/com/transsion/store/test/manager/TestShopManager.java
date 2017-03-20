package com.transsion.store.test.manager;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.shangkang.core.exception.ServiceException;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.ShopParamDto;
import com.transsion.store.dto.ShopResponseDto;
import com.transsion.store.dto.ShopResponseInfoDto;
import com.transsion.store.dto.ShopUserDto;
import com.transsion.store.manager.ShopManager;
import com.transsion.store.test.base.GenericTestCase;

/**
 * @author guihua.zhang on 2017-03-15
 * */
public class TestShopManager extends GenericTestCase{
	
	 	private ShopManager shopManager;
		
	    private UserContext userContext;

	    @Before
	    protected void setUp() throws Exception {
	    	super.setUp();
	    	shopManager = this.getBean("shopManager");
	    	userContext = this.getUserContext("CM0110", "123456");
	    }

	    //查询用户店铺信息和店铺巡店的最后时间 注:如果用户店铺为巡店的 最后巡店时间为NULL
	    @Test
	    public void testFindShopByUserId() throws ServiceException {
	    	List<ShopUserDto> list = shopManager.findShopByUserId(userContext.getToken());
	    	System.out.println(list);
	    }
	    
	    //新建店铺
	    @Test
	    public void testSaveShop() throws ServiceException {
	    	//
	    	ShopParamDto shopDto = new ShopParamDto();
	    	/*shopDto.setShopName("zgh34521");
	    	shopDto.setCountry(92L);
	    	shopDto.setCity(203L);
	    	shopDto.setAddress("huaxialf");
	    	shopDto.setItelPromoter("CM0110");
	    	shopDto.setMaterielId(11L);
	    	shopDto.setGradeId(14L);
	    	shopDto.setBizId(50L);
	    	shopDto.setTotalnum(50);
	    	shopDto.setCurrentnum(60);
	    	shopDto.setBrandsFirst("zgh");*/
	    	shopDto.setShopName("zgh34503");
	    	shopDto.setCountry(92L);
	    	shopDto.setCity(203L);
	    	shopDto.setAddress("huaxialf1");
	    	shopDto.setItelPromoter("CM0110");
	    	shopDto.setMaterielId(11L);
	    	shopDto.setGradeId(14L);
	    	shopDto.setBizId(50L);
	    	shopDto.setTotalnum(50);
	    	shopDto.setCurrentnum(60);
	    	shopDto.setBrandsFirst("zgh");
	    	ShopResponseDto result = shopManager.saveShop(userContext.getToken(),shopDto);
	    	System.out.println(result);
	    }
	    
	    //查询门店详情
	    @Test
	    public void testFindShopDetails() throws ServiceException {
	    	ShopParamDto s = new ShopParamDto();
	    	s.setId(4499L);
	    	ShopParamDto spDto = shopManager.findShopDetails(userContext.getToken(), s);
	    	System.out.println(spDto);
	    }
	    
	    //查询门店
	    @Test
	    public void testFindShopList() throws ServiceException {
	    	List<ShopResponseInfoDto> list = shopManager.findShopList(userContext.getToken());
	    	System.out.println(list);
	    }
}
