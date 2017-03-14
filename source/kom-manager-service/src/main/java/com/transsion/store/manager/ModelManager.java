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
import com.transsion.store.dto.ModelDto;
import com.transsion.store.dto.ModelInfoDto;
import com.transsion.store.dto.VisitModelSettingListDto;
import com.transsion.store.exception.ExceptionDef;
import com.transsion.store.mapper.BrandMapper;
import com.transsion.store.mapper.ModelMapper;
import com.transsion.store.mapper.VisitMapper;
import com.transsion.store.service.SystemDateService;
import com.transsion.store.utils.CacheUtils;

@Service("modelManager")
public class ModelManager {

	@Autowired
	private SystemDateService systemDateService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private BrandMapper brandMapper;
	
	@Autowired
	private VisitMapper visitMapper;
	/**
	 * 新增机型
	 * @return
	 * @throws ServiceException
	 * */
	public void saveModel(String token,Model model) throws ServiceException{
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		if(UtilHelper.isEmpty(model)){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext) || UtilHelper.isEmpty(userContext.getCompanyId())
						|| UtilHelper.isEmpty(userContext.getUserCode())){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		//同一品牌下的机型不能重复，不同品牌下的机型可以重复
		Model modelParam = new Model();
		modelParam.setModelName(model.getModelName());
		modelParam.setBrandCode(model.getBrandCode());
		int count = modelMapper.findByCount(modelParam);
		if(count>0){
			throw new ServiceException(ExceptionDef.ERROR_MODEL_ALREADY_EXIST.getName());
		}
		Brand brand = new Brand();
		brand.setCompanyId(userContext.getCompanyId().intValue());
		brand.setBrandName(model.getBrandCode());
		List<Brand> list = brandMapper.listByProperty(brand);
		if(!UtilHelper.isEmpty(list)){
			model.setBrandId(list.get(0).getId());
		}
		model.setSaleTime(model.getSaleTime().equals("") ? null : model.getSaleTime());
		model.setCompanyId(userContext.getCompanyId().intValue());
		model.setCreatedBy(userContext.getUserCode());
		model.setCreatedTime(systemDateService.getCurrentDate());
		model.setVersion(0);
		modelMapper.save(model);
	}
	
	/**
	 * 查询品牌产品系列机型
	 * @return
	 * @throws ServiceException
	 * */
	public List<ModelDto> findModel(ModelDto modelDto) throws ServiceException{
		if(UtilHelper.isEmpty(modelDto)){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		Model model = new Model();
		BeanUtils.copyProperties(modelDto, model);
		return modelMapper.findModel(model);
	}

	/**
	 * 修改机型
	 * @return
	 * @throws ServiceException
	 * */
	public void update(String token, Model model) throws ServiceException {
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		if(UtilHelper.isEmpty(model)){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if((UtilHelper.isEmpty(userContext)) || UtilHelper.isEmpty(userContext.getCompanyId())
						|| UtilHelper.isEmpty(userContext.getUserCode())){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		//同一品牌下的机型不能重复，不同品牌下的机型可以重复
		Model modelParam = new Model();
		modelParam.setModelName(model.getModelName());
		modelParam.setBrandCode(model.getBrandCode());
		int count1 = modelMapper.findByCount(modelParam);
		modelParam.setId(model.getId());
		int count2 = modelMapper.findByCount(modelParam);
		if(count1>0 && count2<1){
			throw new ServiceException(ExceptionDef.ERROR_MODEL_ALREADY_EXIST.getName());
		}
		Model modelResult = modelMapper.getByPK(model.getId());
		Brand brand = new Brand();
		brand.setCompanyId(userContext.getCompanyId().intValue());
		brand.setBrandName(model.getBrandCode());
		List<Brand> list = brandMapper.listByProperty(brand);
		if(!UtilHelper.isEmpty(list)){
			modelResult.setBrandId(list.get(0).getId());
		}
		modelResult.setCompanyId(userContext.getCompanyId().intValue());
		modelResult.setBrandCode(model.getBrandCode());
		modelResult.setSeriesCode(model.getSeriesCode());
		modelResult.setSaleTime(model.getSaleTime().equals("")?null:model.getSaleTime());
		modelResult.setModelCode(model.getModelCode());
		modelResult.setModelName(model.getModelName());
		modelResult.setPriceScale(model.getPriceScale());
		modelResult.setIsInactive(model.getIsInactive());
		modelResult.setUpdatedBy(userContext.getUserCode());
		modelResult.setUpdatedTime(systemDateService.getCurrentDate());
		modelMapper.update(modelResult);
	}
	
	/**
	 * 查询所有机型名称
	 * */
	public List<String> findModelName(String token) throws ServiceException{
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext) || UtilHelper.isEmpty(userContext.getCompanyId())){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		return modelMapper.findModelName(userContext.getCompanyId());
	}
	
	/**
	 * @author guihua.zhang on 2017-03-14
	 * 查询机型和已绑定的机型
	 * */
	public List<ModelInfoDto> findModelList(String token) throws ServiceException {
		if (UtilHelper.isEmpty(token)) {
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		UserContext userContext = (UserContext) CacheUtils.getSupporter().get(token);
		if (UtilHelper.isEmpty(userContext) || UtilHelper.isEmpty(userContext.getCompanyId())
						|| UtilHelper.isEmpty(userContext.getUserCode())) {
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		// 查询所有机型
		List<ModelInfoDto> modelInfoList = modelMapper.findModelList(userContext.getCompanyId());
		// 查询当前登录人最新的巡店机型
		List<ModelInfoDto> visitList = visitMapper.findLastDateModel(userContext.getUserCode(),
						userContext.getCompanyId());
		List<ModelInfoDto> result = new ArrayList<ModelInfoDto>();
		/**
		 * 1.所有机型为空,直接返回result
		 * 2.所有机型不为空,巡店机型为空,返回所有机型,isSelect为false
		 * 3.所有机型不为空,巡店机型不为空,如果巡店机型和所有机型比较有相同的,isSelect为true
		 * */
		if (!UtilHelper.isEmpty(modelInfoList)) {
			result.addAll(modelInfoList);
			if (!UtilHelper.isEmpty(visitList)) {
				// 将巡店机型设置为true
				for (ModelInfoDto mDto : visitList) {
					if (result.contains(mDto)) {
						int index = modelInfoList.indexOf(mDto);
						if (index != -1) {
							ModelInfoDto modelInfoDto = modelInfoList.get(index);
							modelInfoDto.setSelected(true);
						}
					}
				}
			}
		}
		return result;
	}
}
