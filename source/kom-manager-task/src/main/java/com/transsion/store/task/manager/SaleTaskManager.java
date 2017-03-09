package com.transsion.store.task.manager;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.Currency;
import com.transsion.store.bo.GoalModel;
import com.transsion.store.bo.GoalPromoter;
import com.transsion.store.bo.GoalSupervisor;
import com.transsion.store.bo.Model;
import com.transsion.store.bo.Region;
import com.transsion.store.bo.Sale;
import com.transsion.store.bo.SaleItem;
import com.transsion.store.bo.Shop;
import com.transsion.store.bo.Task;
import com.transsion.store.bo.TaskDetail;
import com.transsion.store.dto.SaleTaskDto;
import com.transsion.store.dto.ScanValidateDto;
import com.transsion.store.dto.TaskGoalModelDto;
import com.transsion.store.dto.TaskGoalPromoterDto;
import com.transsion.store.dto.TaskGoalSupervisorDto;
import com.transsion.store.dto.TaskSaleDto;
import com.transsion.store.dto.UserDto;
import com.transsion.store.exception.ExceptionDef;
import com.transsion.store.manager.ScanValidateManager;
import com.transsion.store.mapper.CurrencyMapper;
import com.transsion.store.mapper.GoalModelMapper;
import com.transsion.store.mapper.GoalPromoterMapper;
import com.transsion.store.mapper.GoalSupervisorMapper;
import com.transsion.store.mapper.ModelMapper;
import com.transsion.store.mapper.RegionMapper;
import com.transsion.store.mapper.SaleItemMapper;
import com.transsion.store.mapper.SaleMapper;
import com.transsion.store.mapper.ShopMapper;
import com.transsion.store.mapper.TaskDetailMapper;
import com.transsion.store.mapper.TaskMapper;
import com.transsion.store.mapper.UserMapper;
import com.transsion.store.message.Message.Type;
import com.transsion.store.service.SystemDateService;
import com.transsion.store.utils.ExcelUtil;

import net.mikesu.fastdfs.FastdfsClient;
import net.mikesu.fastdfs.FastdfsClientFactory;

@Service("saleTaskManager")
public class SaleTaskManager {
	@Autowired
	private ScanValidateManager scanValidateManager;

	@Autowired
	private SaleItemMapper saleItemMapper;

	@Autowired
	private ShopMapper shopMapper;

	@Autowired
	private SaleMapper saleMapper;

	@Autowired
	private SystemDateService systemDateService;

	@Autowired
	private TaskDetailMapper taskDetailMapper;

	@Autowired
	private TaskMapper taskMapper;

	@Autowired
	private CurrencyMapper currencyMapper;

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private RegionMapper regionMapper;
	
	@Autowired
	private GoalSupervisorMapper goalSupervisorMapper;
	
	@Autowired
	private GoalModelMapper goalModelMapper;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private GoalPromoterMapper goalPromoterMapper;

	/**
	 * excel解析 转成实体
	 */
	public void getSaleTaskDto(Long taskId) throws ServiceException {
		if (UtilHelper.isEmpty(taskId)) {
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		Task task = taskMapper.findTaskById(taskId);
		if (UtilHelper.isEmpty(task)) {
			throw new ServiceException(ExceptionDef.ERROR_TASK_NONEXIST.getName());
		}
		FastdfsClient fastdfsClient = FastdfsClientFactory.getFastdfsClient();
		InputStream input;
		try {
			input = fastdfsClient.download(task.getUploadPath());
			ExcelUtil e = new ExcelUtil(input);
			String[][] dataArr = e.getData(1);
			if (task.getTaskType().equals(Type.TASK_SALE_IMPORT.getDesc())) {
				arrayConvertSaleDto(task, dataArr);
			} else if (task.getTaskType().equals(Type.TASK_CURRENCY_IMPORT.getDesc())) {
				arrayConverCurrencyDto(task, dataArr);
			}else if(task.getTaskType().equals(Type.TASK_GOAL_SUPERVISOR_IMPORT.getDesc())){
				arrayConverGoalSupervisorDto(task,dataArr);
			}else if(task.getTaskType().equals(Type.TASK_GOAL_MODEL_IMPORT.getDesc())){
				arrayConverGoalModelDto(task,dataArr);
			}else if(task.getTaskType().equals(Type.TASK_GOAL_PROMOTER_IMPORT.getDesc())){
				arrayConverGoalPromoterDto(task,dataArr);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	/**
	 * 批量上传销量
	 */
	public TaskDetail taskSales(SaleTaskDto saleTaskDto) throws ServiceException {
		TaskDetail taskDetail = new TaskDetail();
		/**
		 * imei illeagal
		 */
		ScanValidateDto scan = scanValidateManager.scanValidate(saleTaskDto.getImeiNo(), null);
		if (UtilHelper.isEmpty(scan)) {
			taskDetail.setStatus(2);
			taskDetail.setMessage("IMEI illegal");
		}
		if (UtilHelper.isEmpty(scan.getImeis())) {
			taskDetail.setStatus(2);
			taskDetail.setMessage("IMEI illegal");
		} else {
			String imeiNo = saleItemMapper.queryScanDuplicatedIMEI(saleTaskDto.getImeiNo());
			List<String> imeiLists = Arrays.asList(scan.getImeis());
			if (imeiLists.contains(imeiNo)) {
				taskDetail.setStatus(2);
				taskDetail.setMessage("IMEI code repeated");
			} else {
				Sale sale = new Sale();
				sale.setBillno("");
				sale.setUserCode(saleTaskDto.getUserCode());
				sale.setUserId(saleTaskDto.getUserId());
				sale.setCompanyId(saleTaskDto.getCompanyId());
				sale.setShopId(saleTaskDto.getShopId());
				sale.setTrantype(24020005);
				sale.setSaleDate(saleTaskDto.getSaleDate());
				sale.setStatus(24030005);
				sale.setWerks("");
				sale.setCurrencyRatio(new BigDecimal("1"));
				saleMapper.save(sale);
				SaleItem saleItem = new SaleItem();
				saleItem.setSaleId(sale.getId());
				saleItem.setCompanyId(saleTaskDto.getCompanyId());
				saleItem.setBillno("");
				saleItem.setImeiNo(saleTaskDto.getImeiNo());
				saleItem.setBrandCode(scan.getBrand());
				saleItem.setModelCode(scan.getModel());
				saleItem.setLineId(0);
				StringBuilder imeisList = new StringBuilder();
				String[] imeis = scan.getImeis();
				if (!UtilHelper.isEmpty(imeis)) {
					for (int i = 0; i < imeis.length; i++) {
						imeisList.append(imeis[i] + ";");
					}
				}
				String imeiList = imeisList.toString();
				saleItem.setImeiList(imeiList);
				saleItemMapper.save(saleItem);
				taskDetail.setMessage("ok");
				taskDetail.setStatus(1);
			}
		}
		// }
		return taskDetail;
	}

	public void arrayConvertSaleDto(Task task, String[][] dataArr) throws ServiceException {
		TaskDetail taskDetail = new TaskDetail();
		List<Map<String, Object>> list = TaskUtil.formatArr(dataArr,TaskSaleDto.IMPORT_HEADERS);
		if (UtilHelper.isEmpty(list)) {
			throw new ServiceException(ExceptionDef.ERROR_TASK_FILE_FORMATERROR.getName());
		} else {
			for (Map<String, Object> map : list) {
				SaleTaskDto saleTaskDto = new SaleTaskDto();
				TaskSaleDto taskSaleDto = new TaskSaleDto();
				taskSaleDto.copyFormMap(map);
				Boolean flag = validate(map, taskDetail);
				if(flag){
					UserDto user = userMapper.findByName(taskSaleDto.getUserCode());
					if (UtilHelper.isEmpty(user)) {
						taskDetail.setMessage("User ID is null");
						taskDetail.setStatus(2);
					}
					Shop shop = shopMapper.findShopId(taskSaleDto.getShopCode());
					if (UtilHelper.isEmpty(shop) || UtilHelper.isEmpty(shop.getId())
									|| UtilHelper.isEmpty(shop.getCompanyId())) {
						taskDetail.setMessage("Shop code is null");
						taskDetail.setStatus(2);
					}
					if (!UtilHelper.isEmpty(shop) && !UtilHelper.isEmpty(shop.getCompanyId())
						&& !UtilHelper.isEmpty(user) && !UtilHelper.isEmpty(user.getId())) {
						saleTaskDto.setShopId(shop.getId().intValue());
						saleTaskDto.setCompanyId(shop.getCompanyId());
						saleTaskDto.setSaleDate(taskSaleDto.getSaleDate());
						saleTaskDto.setShopCode(taskSaleDto.getShopCode());
						saleTaskDto.setUserId(user.getId().intValue());
						saleTaskDto.setUserCode(taskSaleDto.getUserCode());
						saleTaskDto.setImeiNo(taskSaleDto.getImeiNo());
						BigDecimal bd = new BigDecimal(taskSaleDto.getPrice());
						saleTaskDto.setPrice(bd);
						taskDetail = this.taskSales(saleTaskDto);
					}
				}
				String context = taskSaleDto.getContext();
				Long taskId = task.getId();
				this.saveTaskDetail(taskId,context,taskDetail);
			}
		}
	}

	private void arrayConverGoalModelDto(Task task, String[][] dataArr) throws ServiceException {
		TaskDetail taskDetail = new TaskDetail();
		List<Map<String, Object>> list = TaskUtil.formatArr(dataArr,TaskGoalModelDto.IMPORT_HEADERS);
		if (UtilHelper.isEmpty(list)) {
			throw new ServiceException(ExceptionDef.ERROR_TASK_FILE_FORMATERROR.getName());
		} else {
			for (Map<String, Object> map : list) {
				TaskGoalModelDto taskGoalModelDto = new TaskGoalModelDto();
				taskGoalModelDto.copyFormMap(map);
				boolean flag = validate(map, taskDetail);
				if(flag){
					UserDto user = userMapper.findByName(taskGoalModelDto.getUserCode());
					if (UtilHelper.isEmpty(user)) {
						taskDetail.setMessage("User is null");
						taskDetail.setStatus(2);
					}
					Shop shop = shopMapper.findShopId(taskGoalModelDto.getShopCode());
					if (UtilHelper.isEmpty(shop)){
						taskDetail.setMessage("Shop is null");
						taskDetail.setStatus(2);
					}
					Model model = new Model();
					model.setModelCode(taskGoalModelDto.getModelCode());
					List<Model> modelList = modelMapper.listByProperty(model);
					if(UtilHelper.isEmpty(modelList)){
						taskDetail.setMessage("Model is null");
						taskDetail.setStatus(2);
					}
					if (!UtilHelper.isEmpty(shop) && !UtilHelper.isEmpty(user) 
						&& !UtilHelper.isEmpty(user.getCompanyId())
						&& !UtilHelper.isEmpty(modelList)){
						taskGoalModelDto.setCompanyId(user.getCompanyId());
						taskGoalModelDto.setShopId(shop.getId());
						taskGoalModelDto.setModelId(modelList.get(0).getId());
						//TODO:创建人  更新人
						GoalModel goalModel = new GoalModel();
						goalModel.setGoalMonth(taskGoalModelDto.getGoalMonth());
						goalModel.setShopId(taskGoalModelDto.getShopId());
						goalModel.setModelCode(taskGoalModelDto.getModelCode());
						List<GoalModel> goalModelList = goalModelMapper.listByProperty(goalModel);
						BeanUtils.copyProperties(taskGoalModelDto, goalModel);
						goalModel.setSaleTarget(Long.parseLong(taskGoalModelDto.getSaleTarget()));
						if(!UtilHelper.isEmpty(goalModelList)){
							goalModel.setId(goalModelList.get(0).getId());
							goalModelMapper.update(goalModel);
						}else{
							goalModelMapper.save(goalModel);
						}
						taskDetail.setMessage("ok");
						taskDetail.setStatus(1);
					}	
				}
				String context = taskGoalModelDto.getContext();
				Long taskId = task.getId();
				this.saveTaskDetail(taskId,context,taskDetail);
			}
		}
	}
	
	private void arrayConverGoalSupervisorDto(Task task, String[][] dataArr) throws ServiceException {
		TaskDetail taskDetail = new TaskDetail();
		List<Map<String, Object>> list = TaskUtil.formatArr(dataArr,TaskGoalSupervisorDto.IMPORT_HEADERS);
		if (UtilHelper.isEmpty(list)) {
			throw new ServiceException(ExceptionDef.ERROR_TASK_FILE_FORMATERROR.getName());
		} else {
			for (Map<String, Object> map : list) {
				TaskGoalSupervisorDto taskGoalSupervisorDto = new TaskGoalSupervisorDto();
				taskGoalSupervisorDto.copyFormMap(map);
				boolean flag = validate(map, taskDetail);
				if(flag){
					UserDto user = userMapper.findByName(taskGoalSupervisorDto.getUserCode());
					if (UtilHelper.isEmpty(user)) {
						taskDetail.setMessage("User is null");
						taskDetail.setStatus(2);
					}
					Shop shop = shopMapper.findShopId(taskGoalSupervisorDto.getShopCode());
					if (UtilHelper.isEmpty(shop)){
						taskDetail.setMessage("Shop is null");
						taskDetail.setStatus(2);
					}
					if (!UtilHelper.isEmpty(shop) && !UtilHelper.isEmpty(user) 
									&& !UtilHelper.isEmpty(user.getCompanyId())){
						taskGoalSupervisorDto.setCompanyId(user.getCompanyId());
						taskGoalSupervisorDto.setUserId(user.getId());
						taskGoalSupervisorDto.setShopId(shop.getId());
						//TODO:创建人  更新人
						GoalSupervisor goalSupervisor = new GoalSupervisor();
						goalSupervisor.setGoalMonth(taskGoalSupervisorDto.getGoalMonth());
						goalSupervisor.setShopId(taskGoalSupervisorDto.getShopId());
						List<GoalSupervisor> goalSupervisorList = goalSupervisorMapper.listByProperty(goalSupervisor);		
						BeanUtils.copyProperties(taskGoalSupervisorDto, goalSupervisor);
						goalSupervisor.setSaleTarget(Long.parseLong(taskGoalSupervisorDto.getSaleTarget()));
						if(!UtilHelper.isEmpty(goalSupervisorList)){
							goalSupervisor.setId(goalSupervisorList.get(0).getId());
							goalSupervisorMapper.update(goalSupervisor);
						}else{
							goalSupervisorMapper.save(goalSupervisor);
						}
						taskDetail.setMessage("ok");
						taskDetail.setStatus(1);
					}	
				}
				String context = taskGoalSupervisorDto.getContext();
				Long taskId = task.getId();
				this.saveTaskDetail(taskId,context,taskDetail);
			}
		}
	}
	
	private void arrayConverGoalPromoterDto(Task task, String[][] dataArr) throws ServiceException {
		TaskDetail taskDetail = new TaskDetail();
		List<Map<String, Object>> list = TaskUtil.formatArr(dataArr,TaskGoalPromoterDto.IMPORT_HEADERS);
		if (UtilHelper.isEmpty(list)) {
			throw new ServiceException(ExceptionDef.ERROR_TASK_FILE_FORMATERROR.getName());
		} else {
			for (Map<String, Object> map : list) {
				TaskGoalPromoterDto taskGoalPromoterDto = new TaskGoalPromoterDto();
				taskGoalPromoterDto.copyFormMap(map);
				boolean flag = validate(map, taskDetail);
				if(flag){
					UserDto user = userMapper.findByName(taskGoalPromoterDto.getUserCode());
					if (UtilHelper.isEmpty(user)) {
						taskDetail.setMessage("User is null");
						taskDetail.setStatus(2);
					}
					Shop shop = shopMapper.findShopId(taskGoalPromoterDto.getShopCode());
					if (UtilHelper.isEmpty(shop)){
						taskDetail.setMessage("Shop is null");
						taskDetail.setStatus(2);
					}
					if (!UtilHelper.isEmpty(shop) && !UtilHelper.isEmpty(user) 
									&& !UtilHelper.isEmpty(user.getCompanyId())){
						taskGoalPromoterDto.setCompanyId(user.getCompanyId());
						taskGoalPromoterDto.setUserId(user.getId());
						taskGoalPromoterDto.setShopId(shop.getId());
						//TODO:创建人  更新人
						GoalPromoter goalPromoter = new GoalPromoter();
						goalPromoter.setGoalMonth(taskGoalPromoterDto.getGoalMonth());
						goalPromoter.setShopId(taskGoalPromoterDto.getShopId());
						List<GoalPromoter> goalPromoterList = goalPromoterMapper.listByProperty(goalPromoter);		
						BeanUtils.copyProperties(taskGoalPromoterDto, goalPromoter);
						goalPromoter.setSaleTarget(Long.parseLong(taskGoalPromoterDto.getSaleTarget()));
						if(!UtilHelper.isEmpty(goalPromoterList)){
							goalPromoter.setId(goalPromoterList.get(0).getId());
							goalPromoterMapper.update(goalPromoter);
						}else{
							goalPromoterMapper.save(goalPromoter);
						}
						taskDetail.setMessage("ok");
						taskDetail.setStatus(1);
					}	
				}
				String context = taskGoalPromoterDto.getContext();
				Long taskId = task.getId();
				this.saveTaskDetail(taskId,context,taskDetail);
			}
		}
	}
	
	
	
	public void arrayConverCurrencyDto(Task task, String[][] dataArr) throws ServiceException {
		TaskDetail taskDetail = new TaskDetail();
		List<Map<String, Object>> list = TaskUtil.formatArr(dataArr,
						new String[] { "国家", "币别编码", "币别名称", "美元兑外币汇率", "人民币兑外币汇率", "生效日期", "失效日期", "是否停用" });
		if (UtilHelper.isEmpty(list)) {
			throw new ServiceException(ExceptionDef.ERROR_TASK_FILE_FORMATERROR.getName());
		} else {
			for (Map<String, Object> map : list) {
				Currency currency = new Currency();
				String country = (String) map.get("国家");
				String werks = (String) map.get("币别编码");
				String currencyName = (String) map.get("币别名称");
				String exchangerate = (String) map.get("美元兑外币汇率");
				String exchangerate2 = (String) map.get("人民币兑外币汇率");
				String beginTime = (String) map.get("生效日期");
				String endTime = (String) map.get("失效日期");
				String isInactive = (String) map.get("是否停用");
				if (UtilHelper.isEmpty(country)) {
					taskDetail.setMessage("country is null");
					taskDetail.setStatus(2);
				}
				if (UtilHelper.isEmpty(werks)) {
					taskDetail.setMessage("werks is null");
					taskDetail.setStatus(2);
				}
				if (UtilHelper.isEmpty(currencyName)) {
					taskDetail.setMessage("currencyName is null");
					taskDetail.setStatus(2);
				}
				if (UtilHelper.isEmpty(exchangerate)) {
					taskDetail.setMessage("exchangerate is null");
					taskDetail.setStatus(2);
				}
				if (UtilHelper.isEmpty(exchangerate2)) {
					taskDetail.setMessage("exchangerate2 is null");
					taskDetail.setStatus(2);
				}
				if (UtilHelper.isEmpty(beginTime)) {
					taskDetail.setMessage("beginTime is null");
					taskDetail.setStatus(2);
				}
				if (UtilHelper.isEmpty(endTime)) {
					taskDetail.setMessage("endTime is null");
					taskDetail.setStatus(2);
				}
				if (UtilHelper.isEmpty(isInactive)) {
					taskDetail.setMessage("isInactive is null");
					taskDetail.setStatus(2);
				}
				if (!UtilHelper.isEmpty(country) && !UtilHelper.isEmpty(werks) && !UtilHelper.isEmpty(currencyName)
								&& !UtilHelper.isEmpty(exchangerate) && !UtilHelper.isEmpty(exchangerate2)
								&& !UtilHelper.isEmpty(beginTime) && !UtilHelper.isEmpty(endTime)
								&& !UtilHelper.isEmpty(isInactive)) {
					currency.setFindex(1);
					Region region = regionMapper.findRegionByName(country);
					if(UtilHelper.isEmpty(region)){
						taskDetail.setMessage("country is null");
						taskDetail.setStatus(2);
					}
					Currency c = new Currency();
					c.setCurrencyName(currencyName);
					c.setBeginTime(beginTime);
					c.setEndTime(endTime);
					List<Currency> currencyList = currencyMapper.listByProperty(c);
					if(!UtilHelper.isEmpty(currencyList)){
						taskDetail.setMessage("currency is repeat");
						taskDetail.setStatus(2);
					}else{
					if(!UtilHelper.isEmpty(region) && !UtilHelper.isEmpty(region.getId())){
						currency.setRegionId(region.getId());
						currency.setWerks(werks);
						currency.setCurrencyName(currencyName);
						BigDecimal cc = new BigDecimal(exchangerate);
						currency.setExchangerate(cc);
						BigDecimal cc2 = new BigDecimal(exchangerate2);
						currency.setExchangerate2(cc2);
						currency.setBeginTime(beginTime);
						currency.setEndTime(endTime);
						if(isInactive.equals("否")){
							currency.setIsInactive(1);
						}else{
							currency.setIsInactive(2);
						}
						currency.setCreatedBy(task.getUserName());
						currency.setCreatedTime(systemDateService.getCurrentDate());
						currencyMapper.save(currency);
						taskDetail.setMessage("ok");
						taskDetail.setStatus(1);
					}
					}
				}
				taskDetail.setTaskId(task.getId());
				String context = "country:" + country + "\r" + "werks:" + werks + "\r" + "currencyName:" + currencyName
								+ "\r" + "exchangerate:" + exchangerate + "exchangerate2:" + exchangerate2 + "\r"
								+ "beginTime:" + beginTime + "\r" + "endTime:" + endTime + "\r" + "isInactive:"
								+ isInactive;
				taskDetail.setContext(context);
				taskDetail.setCreateTime(systemDateService.getCurrentDate());
				taskDetailMapper.saveTaskDetail(taskDetail);
			}
		}

	}
	
	/**
	 * 更新task表
	 * @param taskId
	 * @param context
	 * @param taskDetail
	 * @throws ServiceException
	 */
	private void saveTaskDetail(Long taskId, String context,TaskDetail taskDetail) throws ServiceException {
		taskDetail.setTaskId(taskId);
		taskDetail.setContext(context);
		taskDetail.setCreateTime(systemDateService.getCurrentDate());
		taskDetailMapper.saveTaskDetail(taskDetail);
	}
	
	/**
	 * 验证数据是否为空
	 * @param importMap
	 * @param taskDetail
	 * @return
	 */
	public boolean validate(Map<String, Object> importMap,TaskDetail taskDetail)
	{
		boolean flag = true;
		Set<Entry<String, Object>> entry = importMap.entrySet();  
        Iterator<Entry<String, Object>> it = entry.iterator();  
        while (it.hasNext())  
        {  
            Entry<String, Object>  me = it.next();  
            String key = me.getKey();  
            String value = (String)me.getValue();
            if(UtilHelper.isEmpty(value)){
            	taskDetail.setMessage(key+" is null");
				taskDetail.setStatus(2);
				flag = false;
            }    
        }
        return flag;
	}
}
