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
import com.transsion.store.mapper.ModelMapper;
import com.transsion.store.resource.MessageStoreResource;
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
	public ModelResponseDto saveModel(String token,ModelDto modelDto) throws ServiceException{
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_TOKEN_INVALID);
		}
		if(UtilHelper.isEmpty(modelDto)){
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
		Model model = new Model();
		BeanUtils.copyProperties(modelDto, model);
		model.setCompanyId(userContext.getUser().getCompanyId());
		model.setCreatedBy(userContext.getUser().getUserId().toString());
		model.setCreatedTime(systemDateService.getCurrentDate());
		model.setUpdatedBy(userContext.getUser().getUserId().toString());
		model.setUpdatedTime(systemDateService.getCurrentDate());
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
	public List<ModelDto> findModel(String token,ModelDto modelDto) throws ServiceException{
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_TOKEN_INVALID);
		}
		if(UtilHelper.isEmpty(modelDto)){
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
		Model model = new Model();
		BeanUtils.copyProperties(modelDto, model);
		return modelMapper.findModel(model);
	}
}
