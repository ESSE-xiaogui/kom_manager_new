package com.transsion.store.exception;

public enum ExceptionDef {

	ERROR_COMMON(1, "ERROR_COMMON"),//公共错误
	ERROR_COMMON_PARAM_NULL(2,"ERROR_COMMON_PARAM_NULL"),//参数为空
	ERROR_COMMON_PARAM_INVALID(3,"ERROR_COMMON_PARAM_INVALID"),//参数失效
	ERROR_COMMON_CHILDREN_EXIST(4,"ERROR_COMMON_CHILDREN_EXIST"),//子集存在
	
	ERROR_SYSTEM(100,"ERROR_SYSTEM"),//系统错误
	ERROR_SYSTEM_RESOURCE_ALREADY_EXIST(101, "ERROR_SYSTEM_RESOURCE_ALREADY_EXIST"), //系统资源已存在
	ERROR_SYSTEM_MENU_ALREADY_EXIST(102, "ERROR_SYSTEM_MENU_ALREADY_EXIST"), //系统目录已存在
	ERROR_SYSTEM_ROLE_ALREADY_EXIST(103, "ERROR_SYSTEM_ROLE_ALREADY_EXIST"), //系统角色已存在

	ERROR_TASK(200,"ERROR_TASK"),//任务管理错误
	ERROR_TASK_TEMPLATE_EXIST(201,"ERROR_TASK_FILE_FORMATERROR"),//文件模板不存在
	ERROR_TASK_FILE_FORMATERROR(202,"ERROR_TASK_FILE_FORMATERROR"),//文件格式错误
	ERROR_TASK_NONEXIST(203,"ERROR_TASK_NONEXIST"),
	
	ERROR_USER(300, "ERROR_USER"),//用户管理错误
	ERROR_USER_LOGIN_FAILED(301, "ERROR_USER_LOGIN_FAILED"),//用户名或密码错误，登录失败
	ERROR_USER_TOKEN_INVALID(302,"ERROR_USER_TOKEN_INVALID"),//token失效
	ERROR_USER_INACTIVE(303,"ERROR_USER_INACTIVE"),//用户已停用
	ERROR_USER_ALREADY_EXIST(304, "ERROR_USER_ALREADY_EXIST"), //用户已存在
	ERROR_USER_NONEXIST(305, "ERROR_USER_NONEXIST"), //用户不存在
	
	ERROR_REGION(400, "ERROR_REGION"),	//区域管理错误
	ERROR_REGION_CURRENCY(401, "ERROR_REGION_CURRENCY"),//区域管理汇率错误
	ERROR_REGION_ALREADY_EXIST(402, "ERROR_REGION_ALREADY_EXIST"), //区域已存在
	ERROR_REGION_NONEXIST(403, "ERROR_REGION_NONEXIST"), //区域不存在
	ERROR_REGION_SHOP_BIND(404, "ERROR_REGION_SHOP_BIND"), //区域已绑定店铺
	ERROR_REGION_CHILDREN_EXIST(405, "ERROR_REGION_CHILDREN_EXIST"), //区域存在下级区域
	
	ERROR_COMPANY(500, "ERROR_COMPANY"),//公司管理错误
	ERROR_COMPANY_ISEXIST(501, "ERROR_COMPANY_ISEXIST"),//公司已存在
	
	ERROR_ORGANIZATION(600, "ERROR_ORGANIZATION"),//组织机构管理错误
	ERROR_ORGANIZATION_DUTY(601, "ERROR_ORGANIZATION_DUTY"),//职位管理错误
	ERROR_ORGANIZATION_CHILDREN_EXIST(602, "ERROR_ORGANIZATION_CHILDREN_EXIST"), //组织机构下有子组织,不能删除此组织机构
	ERROR_ORGANIZATION_EMP_BIND(603, "ERROR_ORGANIZATION_CHILDREN_EXIST"), //此组织机构绑定员工不能删除
	ERROR_ORGANIZATION_ALREADY_EXIST(604, "ERROR_ORGANIZATION_ALREADY_EXIST"), //组织机构已存在
	ERROR_ORGANIZATION_INACTIVE(605, "ERROR_ORGANIZATION_INACTIVE"), //组织机构已停用
	ERROR_ORGANIZATION_DELETE_FAILED(606, "ERROR_ORGANIZATION_DELETE_FAILED"), //组织机构删除失败
	
	ERROR_EMPLOYEE(700,"ERROR_EMPLOYEE"),//员工管理错误
	ERROR_EMPLOYEE_ALREADY_EXIST(701,"ERROR_EMPLOYEE_ALREADY_EXIST"),//员工已存在
	ERROR_EMPLOYEE_NONEXIST(702,"ERROR_EMPLOYEE_NONEXIST"),//员工不存在
	ERROR_EMPLOYEE_OUTOFSERVICE(703,"ERROR_EMPLOYEE_OUTOFSERVICE"),////员工已离职
	ERROR_EMPLOYEE_USER_BIND(704,"ERROR_EMPLOYEE_USER_BIND"), ////员工已绑定用户

	ERROR_BRAND(800, "ERROR_BRAND"),//品牌管理错误
	ERROR_BRAND_MODEL(801, "ERROR_MODEL"),//机型管理错误
	ERROR_BRAND_ALREADY_EXIST(802,"ERROR_BRAND_ALREADY_EXIST"),//品牌已存在
	ERROR_BRAND_NONEXIST(803,"ERROR_BRAND_NONEXIST"),//品牌不存在
	ERROR_MODEL_ALREADY_EXIST(804,"ERROR_MODEL_ALREADY_EXIST"),//机型已存在
	ERROR_MODEL_NONEXIST(805,"ERROR_MODEL_NONEXIST"),//机型不存在
	ERROR_MODEL_BIND_BRAND(806,"ERROR_MODEL_BIND_BRAND"),//机型不存在

	ERROR_SHOP(900, "ERROR_SHOP"),//店铺管理错误
	ERROR_SHOP_ALREADY_EXIST(901,"ERROR_SHOP_ALREADY_EXIST"),//店铺已存在
	ERROR_SHOP_NONEXIST(902,"ERROR_SHOP_NONEXIST"),//店铺不存在
	ERROR_SHOP_GRADE_EXIST(903,"ERROR_SHOP_GRADE_EXIST"),//店铺等级已存在
	ERROR_SHOP_GRADE_INUSE(904,"ERROR_SHOP_GRADE_INUSE"),//店铺等级被使用
	ERROR_SHOP_MATERIEL_ALREADY_EXISTS(905,"ERROR_SHOP_MATERIEL_ALREADY_EXISTS"),//店铺物料已存在
	ERROR_SHOP_BIZ_INUSE(906,"ERROR_SHOP_BIZ_INUSE"),//店铺类型被使用
	ERROR_SHOPCODE_ALREADY_EXIST(907,"ERROR_SHOPCODE_ALREADY_EXIST"),//店铺编码已存在
	ERROR_SHOP_BIZ_EXIST(908,"ERROR_SHOP_BIZ_EXIST"),//店铺类型已存在
	
	ERROR_SALE(1000, "ERROR_SALE"),//销量管理错误
	ERROR_SALE_IMEI_INVALID(1001, "ERROR_SALE_IMEI_INVALID"),//IMEI非法
	ERROR_SALE_IMEI_(1002, "ERROR_SALE_IMEI_INVALID"),
	ERROR_SALE_TOO_MANY_RESULTS(1003,"ERROR_SALE_TOO_MANY_RESULTS"),//销量查询错误
	

	ERROR_STOCK(1100, "ERROR_STOCK"),
	
	ERROR_MATERIEL(1200,"ERROR_MATERIEL"),//物料管理错误
	ERROR_MATERIEL_ALREADY_EXIST(1201,"ERROR_MATERIEL_ALREADY_EXIST"),//物料已存在
	
	ERROR_PROTOTYPE_PARAM_NULL(1301,"ERROR_PROTOTYPE_PARAM_NULL"),//样机参数为空
	ERROR_PROTOTYPE_IMEI_INVALID(1302,"ERROR_PROTOTYPE_IMEI_INVALID"),//IMEI非法
	ERROR_PROTOTYPE_TOO_MANY_RESULTS(1303,"ERROR_PROTOTYPE_TOO_MANY_RESULTS"),// IMEI重复
	
	ERROR_PROTOTYPECOUNTING_PARAM_NULL(1401,"ERROR_PROTOTYPECOUNTING_PARAM_NULL"),//参数为空
	ERROR_PROTOTYPESETTING_PARAM_NULL(1501,"ERROR_PROTOTYPESETTING_PARAM_NULL"),//参数为空
	ERROR_PROTOTYPESETTING_DATE_INVALID(1502,"ERROR_PROTOTYPESETTING_DATE_INVALID"),// 当月已生效的盘点计划，不允许修改，只能改下月或以后月的。
	ERROR_PROTOTYPESETTING_TOO_MANY_RESULTS(1503,"ERROR_PROTOTYPESETTING_TOO_MANY_RESULTS"),// 每月只能生成一次盘点计划
	
	//职位
	ERROR_DUTY_IS_EXIST(1601,"ERROR_DUTY_IS_EXIST"),//此职位已存在
	
	//汇率
	ERROR_CURRENCY_IS_EXIST(1701,"ERROR_CURRENCY_IS_EXIST"),//此汇率已存在
	
	//销售大区
	ERROR_AREA_ALREADY_EXIST(1801,"ERROR_AREA_ALREADY_EXIST"),//销售大区已存在
	ERROR_PARENT_AREA_IS_NULL(1802,"ERROR_PARENT_AREA_IS_NULL"),//父级销售大区为空
	
	ERROR_UNDEFINE(9999, "ERROR_UNDEFINE");//未定义错误
	
	private int code;
	private String name;
	
	private ExceptionDef(int code, String name)
	{
		this.code=code;
		this.name=name;
	}
	
	public int getCode() {
		return code;
	}
	public String getName() {
		return name.toLowerCase();
	}

}
