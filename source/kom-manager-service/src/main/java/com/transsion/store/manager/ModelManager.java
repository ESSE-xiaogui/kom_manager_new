package com.transsion.store.manager;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.Model;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.ModelDto;
import com.transsion.store.dto.ModelResponseDto;
import com.transsion.store.exception.ExceptionDef;
import com.transsion.store.mapper.ModelMapper;
import com.transsion.store.service.SystemDateService;
import com.transsion.store.utils.CacheUtils;

@Service("modelManager")
public class ModelManager {

	@Autowired
	private SystemDateService systemDateService;
	
	@Autowired
	private ModelMapper modelMapper;
	/**
	 * 新增机型
	 * @return
	 * @throws ServiceException
	 * */
	public ModelResponseDto saveModel(String token,Model model) throws ServiceException{
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		if(UtilHelper.isEmpty(model)){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext)){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		//同一品牌下的机型不能重复，不同品牌下的机型可以重复
		Model tempMo = new Model();
		tempMo.setModelName(model.getModelName());
		tempMo.setBrandCode(model.getBrandCode());
		int count = modelMapper.findByCount(tempMo);
		if(count>0){
			throw new ServiceException(ExceptionDef.ERROR_MODEL_ALREADY_EXIST.getName());
		}
		model.setSaleTime(model.getSaleTime().equals("") ? null : model.getSaleTime());
		model.setCompanyId(userContext.getCompanyId().intValue());
		model.setCreatedBy(userContext.getUserCode());
		model.setCreatedTime(systemDateService.getCurrentDate());
		model.setVersion(0);
		modelMapper.save(model);
		ModelResponseDto mrd = new ModelResponseDto();
		mrd.setStatus(1);
		return mrd;
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
	public ModelResponseDto update(String token, Model model) throws ServiceException {
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		if(UtilHelper.isEmpty(model)){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext)){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		//同一品牌下的机型不能重复，不同品牌下的机型可以重复
		Model tempMo = new Model();
		tempMo.setModelName(model.getModelName());
		tempMo.setBrandCode(model.getBrandCode());
		int count1 = modelMapper.findByCount(tempMo);
		tempMo.setId(model.getId());
		int count2 = modelMapper.findByCount(tempMo);
		if(count1>0 && count2<1){
			throw new ServiceException(ExceptionDef.ERROR_MODEL_ALREADY_EXIST.getName());
		}
		Model formerMo = modelMapper.getByPK(model.getId());
		formerMo.setBrandCode(model.getBrandCode());
		formerMo.setSeriesCode(model.getSeriesCode());
		formerMo.setSaleTime(model.getSaleTime().equals("")?null:model.getSaleTime());
		formerMo.setModelCode(model.getModelCode());
		formerMo.setModelName(model.getModelName());
		formerMo.setPriceScale(model.getPriceScale());
		formerMo.setIsInactive(model.getIsInactive());
		formerMo.setUpdatedBy(userContext.getUserCode());
		formerMo.setUpdatedTime(systemDateService.getCurrentDate());
		modelMapper.update(formerMo);
		ModelResponseDto mrd = new ModelResponseDto();
		mrd.setStatus(1);
		return mrd;
	}
	
	/**
	 * 查询所有机型名称
	 * */
	public List<String> findModelName(String token) throws ServiceException{
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext)){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		return modelMapper.findModelName(userContext.getCompanyId());
	}
}
