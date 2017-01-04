package com.transsion.store.task.service;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.Sale;
import com.transsion.store.bo.SaleItem;
import com.transsion.store.bo.Shop;
import com.transsion.store.bo.Task;
import com.transsion.store.bo.TaskDetail;
import com.transsion.store.dto.SaleTaskDto;
import com.transsion.store.dto.ScanValidateDto;
import com.transsion.store.manager.ScanValidateManager;
import com.transsion.store.mapper.SaleItemMapper;
import com.transsion.store.mapper.SaleMapper;
import com.transsion.store.mapper.ShopMapper;
import com.transsion.store.mapper.TaskDetailMapper;
import com.transsion.store.mapper.TaskMapper;
import com.transsion.store.service.SystemDateService;
import com.transsion.store.task.interfaces.SaleService;
import com.transsion.store.utils.Excel;
import net.mikesu.fastdfs.FastdfsClient;
import net.mikesu.fastdfs.FastdfsClientFactory;

@Service("taskSaleService")
public class SaleServiceImpl implements SaleService {
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
	
	/**
	 * 批量上传销量
	 * */
	public TaskDetail taskSales(SaleTaskDto saleTaskDto) throws ServiceException {
			TaskDetail taskDetail = new TaskDetail();
			/**
			 * param is null 
			 */
			if (UtilHelper.isEmpty(saleTaskDto.getImeiNo()) || UtilHelper.isEmpty(saleTaskDto.getUserCode())
							|| UtilHelper.isEmpty(saleTaskDto.getShopCode())) {
				taskDetail.setMessage("IMEI code is null;User ID is null;Shop ID is null");
			}
			/**
			 * imei illeagal
			 */
			ScanValidateDto scan = scanValidateManager.scanValidate(saleTaskDto.getImeiNo(), null);
			if (UtilHelper.isEmpty(scan.getImeis())) {
				taskDetail.setMessage("IMEI illegal");
			} else {
				String imeiNo = saleItemMapper.queryScanDuplicatedIMEI(saleTaskDto.getImeiNo());
				List<String> imeiLists = Arrays.asList(scan.getImeis());
				if (imeiLists.contains(imeiNo)) {
					taskDetail.setMessage("IMEI code repeated");
				} else {
					Sale sale = new Sale();
					sale.setBillno("");
					sale.setUserCode(saleTaskDto.getUserCode());
					Shop shop = shopMapper.findShopId(saleTaskDto.getShopCode());
					sale.setCompanyId(shop.getCompanyId());
					sale.setShopId(shop.getShopId().intValue());
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
					saleItem.setBrandCode(scan.getBrand());
					saleItem.setModelCode(scan.getModel());
					saleItem.setLineId(0);
					StringBuilder imeisList = new StringBuilder();
					String[] imeis = scan.getImeis();
					if (!UtilHelper.isEmpty(imeis)) {
						for (int i = 0; i < imeis.length; i++) {
							imeisList.append(imeis[i] + ";");
							if (!imeiLists.contains(imeis[i])) {
								imeiLists.add(imeis[i]);
							}
						}
					}
					String imeiList = imeisList.toString();
					saleItem.setImeiList(imeiList);
					saleItemMapper.save(saleItem);
					taskDetail.setMessage("IMEI code repeated");
				}
			}
			return taskDetail;
	}

	public void getSaleTaskDto(Long taskId) throws ServiceException {
		Task task = taskMapper.findTaskById(taskId);
		FastdfsClient fastdfsClient = FastdfsClientFactory.getFastdfsClient();
    	InputStream input;
		try {
		//	input = fastdfsClient.download("group1/M00/00/00/Cvp1BlhrUqeARHnQAACQAHwDqpY24.xlsx");
			input = fastdfsClient.download(task.getUploadPath());
			Excel e = new Excel(input);
			String [] [] dataArr = e.getData(1);
			for(int i=0;i<dataArr.length;i++){		
				for(int j=0;j<dataArr[i].length;j++){
					TaskDetail taskDetail = new TaskDetail();
					if(UtilHelper.isEmpty(dataArr[i][j])){
						taskDetail.setMessage("file is null");
					}else
					if(UtilHelper.isEmpty(dataArr[i][0])){
						taskDetail.setMessage("sale date is null");
					}else
					if(UtilHelper.isEmpty(dataArr[i][1])){
						taskDetail.setMessage("shop code is null");
					}else
					if(UtilHelper.isEmpty(dataArr[i][2])){
						taskDetail.setMessage("user code is null");
					}else
					if(UtilHelper.isEmpty(dataArr[i][3])){
						taskDetail.setMessage("imei is null");
					}else
					if(UtilHelper.isEmpty(dataArr[i][4])){
						taskDetail.setMessage("price is null");
					}else{
					SaleTaskDto saleTaskDto = new SaleTaskDto();
					saleTaskDto.setSaleDate(dataArr[i][0]);
					saleTaskDto.setShopCode(dataArr[i][1]);
					saleTaskDto.setUserCode(dataArr[i][2]);
					saleTaskDto.setImeiNo(dataArr[i][3]);
					saleTaskDto.setPrice(new BigDecimal(dataArr[i][4]));
					taskDetail = this.taskSales(saleTaskDto);
					taskDetail.setTaskId(taskId);
					String context = "Sales date:" + saleTaskDto.getSaleDate() + "\r" + "Shop ID:"+saleTaskDto.getShopCode() + "\r"
									+ "User ID:" +saleTaskDto.getUserCode() + "\r" + "IMEI code:" +saleTaskDto.getImeiNo() + "\r"
									+ "Price:" +saleTaskDto.getPrice();
					taskDetail.setContext(context);
					taskDetail.setCreateTime(systemDateService.getCurrentDate());
					taskDetailMapper.save(taskDetail);
					}
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}
	
	/**
	 * 转换excel
	 * */
	/*public static void main(String[] args){
		Task task =new Task();
		task.setId(1L);
		FastdfsClient fastdfsClient = FastdfsClientFactory.getFastdfsClient();
    	InputStream input;
		try {
			input = fastdfsClient.download("group1/M00/00/00/Cvp1BlhrUqeARHnQAACQAHwDqpY24.xlsx");
			Excel e = new Excel(input);
			String [] [] dataArr = e.getData(1);
			for(int i=0;i<dataArr.length;i++){		
				for(int j=0;j<dataArr[i].length;j++){
					for(String a:dataArr[j]){
						System.out.println(a);
					}
					TaskDetail taskDetail = new TaskDetail();
					if(UtilHelper.isEmpty(dataArr[i][j])){
						taskDetail.setMessage("file is null");
					}else
					if(UtilHelper.isEmpty(dataArr[i][0])){
						taskDetail.setMessage("sale date is null");
					}else
					if(UtilHelper.isEmpty(dataArr[i][1])){
						taskDetail.setMessage("shop code is null");
					}else
					if(UtilHelper.isEmpty(dataArr[i][2])){
						taskDetail.setMessage("user code is null");
					}else
					if(UtilHelper.isEmpty(dataArr[i][3])){
						taskDetail.setMessage("imei is null");
					}else
					if(UtilHelper.isEmpty(dataArr[i][4])){
						taskDetail.setMessage("price is null");
					}else{
					SaleTaskDto saleTaskDto = new SaleTaskDto();
					saleTaskDto.setSaleDate(dataArr[i][0]);
					saleTaskDto.setShopCode(dataArr[i][1]);
					saleTaskDto.setUserCode(dataArr[i][2]);
					saleTaskDto.setImeiNo(dataArr[i][3]);
					saleTaskDto.setPrice(new BigDecimal(dataArr[i][4]));
					SaleServiceImpl s = new SaleServiceImpl();
					s.taskSales(saleTaskDto, task);
					}
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}*/

}
