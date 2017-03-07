package com.transsion.store.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.Brand;
import com.transsion.store.bo.Model;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.BrandDto;
import com.transsion.store.exception.ExceptionDef;
import com.transsion.store.mapper.BrandMapper;
import com.transsion.store.mapper.ModelMapper;
import com.transsion.store.service.SystemDateService;
import com.transsion.store.utils.CacheUtils;

@Service("brandManager")
public class BrandManager {
	
	@Autowired
	private BrandMapper brandMapper;
	
	@Autowired
	private SystemDateService systemDateService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	/**
	 * 新增品牌
	 * @return
	 * @throws ServiceException
	 * */
	public void saveBrand(String token,BrandDto brandDto) throws ServiceException{
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		if(UtilHelper.isEmpty(brandDto)){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext) ||UtilHelper.isEmpty(userContext.getCompanyId())
						|| UtilHelper.isEmpty(userContext.getUserCode())){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		Brand brandName = new Brand();
		brandName.setBrandName(brandDto.getBrandName());
		int count = brandMapper.findByCount(brandName);
		if(count>0){
			throw new ServiceException(ExceptionDef.ERROR_BRAND_ALREADY_EXIST.getName());
		}
		Brand brand = new Brand();
		BeanUtils.copyProperties(brandDto, brand);
		brand.setBrandCode(brandDto.getBrandName());
		brand.setCompanyId(userContext.getCompanyId().intValue());
		brand.setCreatedBy(userContext.getUserCode());
		brand.setCreatedTime(systemDateService.getCurrentDate());
		brand.setVersion(0);
		brandMapper.save(brand);
	}
	
	/**
	 * 查询品牌
	 * @return
	 * @throws ServiceException
	 * */
	public List<BrandDto> findBrand(String token) throws ServiceException{
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext) || UtilHelper.isEmpty(userContext.getCompanyId())){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		Brand brand = new Brand();
		brand.setCompanyId(userContext.getCompanyId().intValue());
		List<Brand> brandList = brandMapper.listByProperty(brand);
		if(UtilHelper.isEmpty(brandList)){
			return null;
		}else{
		List<BrandDto> brandDtoList = new ArrayList<BrandDto>();
		for(Brand b:brandList){
			BrandDto bd = new BrandDto();
			bd.setBrandName(b.getBrandName());
			bd.setBrandId(b.getId());
			bd.setIsSelf(b.getIsSelf());
			bd.setIsInactive(b.getIsInactive());
			brandDtoList.add(bd);
		}
		return brandDtoList;
		}
	}

	/**
	 * 修改品牌
	 * @return
	 * @throws ServiceException
	 * */
	public void update(String token, Brand brand) throws ServiceException {
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext) ||UtilHelper.isEmpty(userContext.getCompanyId())
						|| UtilHelper.isEmpty(userContext.getUserCode())){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		Brand brandParam = new Brand();
		brandParam.setBrandName(brand.getBrandName());
		int count1 = brandMapper.findByCount(brandParam);
		brandParam.setId(brand.getId());
		int count2 = brandMapper.findByCount(brandParam);
		if(count1>0 && count2<1){
			throw new ServiceException(ExceptionDef.ERROR_BRAND_ALREADY_EXIST.getName());
		}
		Brand brandResult = brandMapper.getByPK(brand.getId());
		brandResult.setBrandCode(brand.getBrandName());
		brandResult.setCompanyId(userContext.getCompanyId().intValue());
		brandResult.setBrandName(brand.getBrandName());
		brandResult.setIsSelf(brand.getIsSelf());
		brandResult.setIsInactive(brand.getIsInactive());
		brandResult.setUpdatedBy(userContext.getUserCode());
		brandResult.setUpdatedTime(systemDateService.getCurrentDate());
		brandMapper.update(brandResult);
	}
	
	/**
	 * @author guihua.zhang on 2017-02-21
	 * 
	 * 删除品牌
	 * */
	public void deleteByPKeys(List<Long> primaryKeys) throws ServiceException
	{
		if(UtilHelper.isEmpty(primaryKeys)){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		for(long primaryKey:primaryKeys){
			Brand brand = new Brand();
			brand.setId(primaryKey);
			List<Brand> list = brandMapper.listByProperty(brand);
			if(!UtilHelper.isEmpty(list)){
				for(Brand brandResult:list){
					Model model = new Model();
					model.setBrandCode(brandResult.getBrandCode());
					int count = modelMapper.findByCount(model);
					if(count>0){
						throw new ServiceException(ExceptionDef.ERROR_MODEL_BIND_BRAND.getName());
					}else{
						brandMapper.deleteByPK(primaryKey);
					}
				}
			}
		}
	}
}
