package com.transsion.store.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.Brand;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.BrandDto;
import com.transsion.store.dto.BrandResponseDto;
import com.transsion.store.mapper.BrandMapper;
import com.transsion.store.resource.MessageStoreResource;
import com.transsion.store.service.SystemDateService;
import com.transsion.store.utils.CacheUtils;

@Service("brandManager")
public class BrandManager {
	
	@Autowired
	private BrandMapper brandMapper;
	@Autowired
	private SystemDateService systemDateService;
	
	/**
	 * 新增品牌
	 * @return
	 * @throws ServiceException
	 * */
	public BrandResponseDto saveBrand(String token,BrandDto brandDto) throws ServiceException{
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_TOKEN_INVALID);
		}
		if(UtilHelper.isEmpty(brandDto)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		if(UtilHelper.isEmpty(userContext.getUser())){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_USER_IS_NULL);
		}
		if(UtilHelper.isEmpty(userContext.getUser().getCompanyId())){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		if(UtilHelper.isEmpty(userContext.getUser().getUserId())){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_USERID_IS_NULL);
		}
		Brand brand = new Brand();
		BeanUtils.copyProperties(brandDto, brand);
		brand.setBrandCode(brandDto.getBrandName());
		brand.setCompanyId(userContext.getUser().getCompanyId());
		brand.setCreatedBy(userContext.getUser().getUserId().toString());
		brand.setCreatedTime(systemDateService.getCurrentDate());
		brand.setUpdatedBy(userContext.getUser().getUserId().toString());
		brand.setUpdatedTime(systemDateService.getCurrentDate());
		brand.setVersion(0);
		brandMapper.save(brand);
		BrandResponseDto brd = new BrandResponseDto();
		brd.setStatus(1);
		return brd;
	}
	
	/**
	 * 查询品牌
	 * @return
	 * @throws ServiceException
	 * */
	public List<BrandDto> findBrand(String token) throws ServiceException{
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_TOKEN_INVALID);
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		if(UtilHelper.isEmpty(userContext.getUser())){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_USER_IS_NULL);
		}
		if(UtilHelper.isEmpty(userContext.getUser().getCompanyId())){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		Brand brand = new Brand();
		brand.setCompanyId(userContext.getUser().getCompanyId());
		List<Brand> brandList = brandMapper.listByProperty(brand);
		if(UtilHelper.isEmpty(brandList)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		List<BrandDto> brandDtoList = new ArrayList<BrandDto>();
		BeanUtils.copyProperties(brandDtoList, brandList);
		return brandDtoList;
	}
}
