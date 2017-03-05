package com.transsion.store.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.Brand;
import com.transsion.store.bo.Model;
import com.transsion.store.bo.Prototype;
import com.transsion.store.bo.Tac;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.PrototypeDto;
import com.transsion.store.dto.ScanValidateDto;
import com.transsion.store.exception.ExceptionDef;
import com.transsion.store.mapper.BrandMapper;
import com.transsion.store.mapper.ModelMapper;
import com.transsion.store.mapper.PrototypeMapper;
import com.transsion.store.service.SystemDateService;
import com.transsion.store.utils.CacheUtils;

@Service("/prototypeManager")
public class PrototypeManager {
	
	@Autowired
	private SystemDateService systemDateService;
	@Autowired
	private PrototypeMapper	prototypeMapper;
	@Autowired
	private ScanValidateManager scanValidateManager;
	@Autowired
	private TacManager tacManager;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private BrandMapper brandMapper;
	
	/**
	 * 新增样机
	 * @param prototypeDto
	 * @param token
	 * @throws ServiceException
	 */
	public void savePrototype(PrototypeDto prototypeDto,String token) throws ServiceException {
		// 是否登录
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		// 登录信息是否为空
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext) || UtilHelper.isEmpty(userContext.getUser())){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		// 数据是否为空
		if(UtilHelper.isEmpty(prototypeDto)){
			throw new ServiceException(ExceptionDef.ERROR_PROTOTYPE_PARAM_NULL.getName());
		}
		
		// 新增时校验IMEI是否唯一
		Prototype conditionOne = new Prototype();
		conditionOne.setImeiNo(prototypeDto.getImeiNo());
		
		int imeiCount = prototypeMapper.checkImeiOnly(conditionOne);		
		
		if (imeiCount > 0) {
			throw new ServiceException(ExceptionDef.ERROR_PROTOTYPE_TOO_MANY_RESULTS.getName());
		}
		
		Prototype prototype = new Prototype();
		
		prototype.setCompanyId(userContext.getCompanyId());
		prototype.setImeiNo(prototypeDto.getImeiNo());
		
		if (!"".equals(prototype.getImeiNo())) {
			ScanValidateDto scanValidateDto = scanValidateManager.scanValidate(prototypeDto.getImeiNo(), "");
			
			String[] imeis = scanValidateDto.getImeis();
			
			String imeiList = "";
			
			if (imeis != null) {
				for (String str : imeis) {
					imeiList += str + ",";
				}
				prototype.setImeiList(imeiList);
			}
			
			Tac tac = tacManager.queryTacInfoByImei(prototype.getImeiNo());
			
			if (tac != null) {
				prototype.setBrandCode(tac.getBrandCode());
				
				Brand brand = new Brand();
				brand.setBrandCode(prototype.getBrandCode());
				
				List<Brand> brandList = brandMapper.listByProperty(brand);
				
				if (!UtilHelper.isEmpty(brandList)) {
					prototype.setBrandId(brandList.get(0).getId());
				}
				
				prototype.setModelCode(tac.getModelCode());
				
				Model model = new Model();
				model.setModelCode(prototype.getModelCode());

				List<Model> modelList = modelMapper.listByProperty(model);
				
				if (!UtilHelper.isEmpty(modelList)) {
					prototype.setModelId(modelList.get(0).getId());
				}
			}
		}
		
		prototype.setImgImeiUrl(prototypeDto.getImgImeiUrl());
		prototype.setImgPrototypeUrl(prototypeDto.getImgPrototypeUrl());
		prototype.setImgShopUrl(prototypeDto.getImgShopUrl());
		prototype.setRemark(prototypeDto.getRemark());
		prototype.setShopId(prototypeDto.getShopId());
		prototype.setStatus(prototypeDto.getStatus());
		prototype.setPublishTime(userContext.getUserCode());
		prototype.setPublishTime(systemDateService.getCurrentDate());
		prototype.setCreateBy(userContext.getUserCode());
		prototype.setCreateTime(systemDateService.getCurrentDate());
		
		prototypeMapper.save(prototype);
	}
	
	/**
	 * 样机下架
	 * @param prototypeDto
	 * @param token
	 * @return
	 * @throws ServiceException
	 */
	public int updatePrototype(PrototypeDto prototypeDto,String token) throws ServiceException {
		// 是否登录
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		// 登录信息是否为空
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext) || UtilHelper.isEmpty(userContext.getUser())){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		// 数据是否为空
		if(UtilHelper.isEmpty(prototypeDto)){
			throw new ServiceException(ExceptionDef.ERROR_PROTOTYPE_PARAM_NULL.getName());
		}
		
		Prototype prototype = prototypeMapper.getByPK(prototypeDto.getId());
		
		if (prototype != null) {
			if (!"".equals(prototypeDto.getImeiNo())) {
				ScanValidateDto scanValidateDto = scanValidateManager.scanValidate(prototypeDto.getImeiNo(), "");
				
				String[] imeis = scanValidateDto.getImeis();
				
				String imeiList = "";
				
				if (imeis != null) {
					for (String str : imeis) {
						imeiList += str + ",";
					}
					prototype.setImeiList(imeiList);
				}
				
				Tac tac = tacManager.queryTacInfoByImei(prototype.getImeiNo());
				
				if (tac != null) {
					prototype.setBrandCode(tac.getBrandCode());
					
					Brand brand = new Brand();
					brand.setBrandCode(prototype.getBrandCode());
					
					List<Brand> brandList = brandMapper.listByProperty(brand);
					
					if (!UtilHelper.isEmpty(brandList)) {
						prototype.setBrandId(brandList.get(0).getId());
					}
					
					prototype.setModelCode(tac.getModelCode());
					
					Model model = new Model();
					model.setModelCode(prototype.getModelCode());

					List<Model> modelList = modelMapper.listByProperty(model);
					
					if (!UtilHelper.isEmpty(modelList)) {
						prototype.setModelId(modelList.get(0).getId());
					}
				}
			}
			
			prototype.setImgImeiUrl(prototypeDto.getImgImeiUrl());
			prototype.setImgPrototypeUrl(prototypeDto.getImgPrototypeUrl());
			prototype.setImgShopUrl(prototypeDto.getImgShopUrl());
			prototype.setRemark(prototypeDto.getRemark());
			prototype.setShopId(prototypeDto.getShopId());
			prototype.setStatus(prototypeDto.getStatus());
			
			// 下架
			if ("2".equals(prototypeDto.getStatus())) {
				prototype.setUnpublishBy(userContext.getUserCode());
				prototype.setUnpublishTime(systemDateService.getCurrentDate());
				prototype.setUnpublishCause(prototypeDto.getUnpublishCause());
			}
			
			prototype.setUpdateBy(userContext.getUserCode());
			prototype.setUpdateTime(systemDateService.getCurrentDate());
		}
		
		return prototypeMapper.update(prototype);
	}
}