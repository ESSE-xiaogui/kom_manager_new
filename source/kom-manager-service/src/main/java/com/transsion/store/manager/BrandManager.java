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
		if(UtilHelper.isEmpty(userContext.getCompanyId())){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		Brand brand = new Brand();
		BeanUtils.copyProperties(brandDto, brand);
		brand.setCompanyId(userContext.getCompanyId().intValue());
		brand.setCreatedBy(userContext.getUserCode());
		brand.setCreatedTime(systemDateService.getCurrentDate());
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
		if(UtilHelper.isEmpty(userContext.getCompanyId())){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		Brand brand = new Brand();
		brand.setCompanyId(userContext.getCompanyId().intValue());
		List<Brand> brandList = brandMapper.listByProperty(brand);
		if(UtilHelper.isEmpty(brandList)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		List<BrandDto> brandDtoList = new ArrayList<BrandDto>();
		for(Brand b:brandList){
			BrandDto bd = new BrandDto();
			bd.setBrandName(b.getBrandName());
			bd.setIsSelf(b.getIsSelf());
			bd.setIsInactive(b.getIsInactive());
			brandDtoList.add(bd);
		}
		return brandDtoList;
	}

	/**
	 * 修改品牌
	 * @return
	 * @throws ServiceException
	 * */
	public BrandResponseDto update(String token, Brand brand) throws ServiceException {
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_TOKEN_INVALID);
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		Brand formerBr = brandMapper.getByPK(brand.getId());
		formerBr.setBrandName(brand.getBrandName());
		formerBr.setIsSelf(brand.getIsSelf());
		formerBr.setIsInactive(brand.getIsInactive());
		formerBr.setUpdatedBy(userContext.getUser().getUserCode());
		formerBr.setUpdatedTime(systemDateService.getCurrentDate());
		brandMapper.update(formerBr);
		BrandResponseDto brd = new BrandResponseDto();
		brd.setStatus(1);
		return brd;
	}
}
