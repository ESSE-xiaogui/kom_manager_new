package com.transsion.store.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.Brand;
import com.transsion.store.bo.Model;
import com.transsion.store.bo.Prototype;
import com.transsion.store.bo.PrototypeSettingModel;
import com.transsion.store.bo.PrototypeSettingRegion;
import com.transsion.store.bo.Tac;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.PrototypeDto;
import com.transsion.store.dto.PrototypeSettingDto;
import com.transsion.store.dto.ScanValidateDto;
import com.transsion.store.exception.ExceptionDef;
import com.transsion.store.mapper.BrandMapper;
import com.transsion.store.mapper.ModelMapper;
import com.transsion.store.mapper.PrototypeMapper;
import com.transsion.store.service.SystemDateService;
import com.transsion.store.utils.CacheUtils;
import com.transsion.store.utils.ExcelUtils;

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
		prototype.setPublishBy(userContext.getUserCode());
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
			if (!"".equals(prototypeDto.getImeiNo()) && prototypeDto.getImeiNo() != null) {
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
			if (prototypeDto.getStatus() == 2) {
				prototype.setUnpublishBy(userContext.getUserCode());
				prototype.setUnpublishTime(systemDateService.getCurrentDate());
				prototype.setUnpublishCause(prototypeDto.getUnpublishCause());
			}
			
			prototype.setUpdateBy(userContext.getUserCode());
			prototype.setUpdateTime(systemDateService.getCurrentDate());
		}
		
		return prototypeMapper.update(prototype);
	}
	
	/**
	 * 根据盘点参数获取要盘点的样机
	 * @param prototypeSettingDto
	 * @return
	 * @throws ServiceException
	 */
	public List<Prototype> getPrototypesByPrototypeSettings(List<PrototypeSettingDto> prototypeSettingDtos) throws ServiceException {
		
		List<Prototype> prototypes = new ArrayList<Prototype>();
		
		// 每个月只能新增一条prototypeSettingDto. 所以取get(0)
		if (prototypeSettingDtos != null && !prototypeSettingDtos.isEmpty()) {
			PrototypeSettingDto prototypeSettingDto = prototypeSettingDtos.get(0);
			
			if (prototypeSettingDto != null && prototypeSettingDto.getPrototypeSettingModels() != null) {
				Long modelId = 0L;
				List<Long> modelIds = new ArrayList<Long>();
				for (PrototypeSettingModel prototypeSettingModel : prototypeSettingDto.getPrototypeSettingModels()) {
					modelId = prototypeSettingModel.getModelId();
					modelIds.add(modelId);
				}
				prototypeSettingDto.setModelIds(modelIds);
			}
			
			if (prototypeSettingDto != null && prototypeSettingDto.getPrototypeSettingRegions() != null) {
				Long regionId = 0L;
				List<Long> regionIds = new ArrayList<Long>();
				for (PrototypeSettingRegion prototypeSettingRegion : prototypeSettingDto.getPrototypeSettingRegions()) {
					regionId = prototypeSettingRegion.getRegionId();
					regionIds.add(regionId);
				}
				prototypeSettingDto.setRegionIds(regionIds);
			}
			
			prototypes = prototypeMapper.listByPrototypeSettingDto(prototypeSettingDto);
		}
		
		return prototypes;
	}
	
	/**
	 * 样机导出
	 * @param prototypeDto
	 * @return
	 * @throws ServiceException
	 */
	public byte[] getPrototypeByExcel(PrototypeDto prototypeDto)throws ServiceException {
		String[] headers = {"序号","事业部","品牌名称","国家","城市","门店编码","门店名称","IMEI号","样机机型", 
		"上样用户","上样员工姓名","上样时间","下样用户","下样员工姓名","下样时间","下样原因","样机状态","样机状态","创建时间"};
		
		List<PrototypeDto> prototypeDtos = prototypeMapper.listByProperty(prototypeDto);
		List<Object[]> dataset = new ArrayList<Object[]>();
		int i=1;
		for(PrototypeDto prototypeDtoTemp :prototypeDtos){
			dataset.add(new Object[]{i++,prototypeDtoTemp.getCompanyCode(), prototypeDtoTemp.getBrandCode(),
					prototypeDtoTemp.getCountryName(), prototypeDtoTemp.getCityName(),
					prototypeDtoTemp.getShopCode(), prototypeDtoTemp.getShopName(), prototypeDtoTemp.getImeiNo(),
					prototypeDtoTemp.getModelCode(), prototypeDtoTemp.getPublishBy(), 
					prototypeDtoTemp.getPublishName(), prototypeDtoTemp.getPublishTime(),
					prototypeDtoTemp.getUnpublishBy(), prototypeDtoTemp.getUnpublishName(),prototypeDtoTemp.getUnpublishTime(), 
					prototypeDtoTemp.getUnpublishCause(), prototypeDtoTemp.getStatus() == 1 ? "上样" : "下样", prototypeDtoTemp.getCreateTime()});
		}
		String title = "样机汇总报表";
		return ExcelUtils.exportExcel(title, headers, dataset);
	}
}