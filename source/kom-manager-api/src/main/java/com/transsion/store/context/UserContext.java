package com.transsion.store.context;

import java.util.List;
import com.transsion.store.IUserContext;
import com.transsion.store.bo.Shop;
import com.transsion.store.bo.User;

/**
 * Created by liuzh on 16-5-31.
 */
public class UserContext implements IUserContext {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 用户登录token
     */
    private String token;

    /**
     * 用户code
     */
    private String userCode;

    /**
     * password
     */
    private String password;
    
    /**
     * 品牌
     * */
    private String brandCode;
    
    /**
     * 角色
     * */
    private List<String> role;

    
    /**
     * 地址
     * */
    private String cityName;

    /**
     * 店铺信息
     */
    private Shop shop;
    
    /**
     * 职务名称
     * */
    private String dutyName;
    
    /**
     * 店铺信息
     */
    private List<Shop> shopList;

    /**
     * 店铺名称
     * */
	private String shopName;

    /**
     * 用户信息
     */
    private User user;
    
    /**
     * 公司ID
     * */
    private Long companyId;
    

	public String getToken() {
        return token;
    }

    public String getDutyName() {
		return dutyName;
	}

	public void setDutyName(String dutyName) {
		this.dutyName = dutyName;
	}

	public List<Shop> getShopList() {
		return shopList;
	}

	public void setShopList(List<Shop> shopList) {
		this.shopList = shopList;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public void setToken(String token) {
        this.token = token;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }
    
	public String getBrandCode() {
		return brandCode;
	}

	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
	
	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public List<String> getRole() {
		return role;
	}

	public void setRole(List<String> role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserContext [token=" + token + ", userCode=" + userCode + ", password=" + password + ", brandCode="
						+ brandCode + ", role=" + role + ", cityName=" + cityName + ", shop=" + shop + ", dutyName="
						+ dutyName + ", shopList=" + shopList + ", shopName=" + shopName + ", user=" + user
						+ ", companyId=" + companyId + "]";
	}

}
