package com.transsion.store.context;

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
     * 地址
     * */
    private String cityName;

    /**
     * 店铺信息
     */
    private Shop shop;

    /**
     * 店铺名称
     * */
	private String dealerName;

    /**
     * 用户信息
     */
    private User user;
    
    /**
     * 公司ID
     * */
    private Long companyId;
    
    /**
     * 店铺名称
     * */
    public String getDealerName() {
		return dealerName;
	}
    /**
     * 店铺名称
     * */
	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	public String getToken() {
        return token;
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
	
	@Override
	public String toString() {
		return "UserContext [token=" + token + ", userCode=" + userCode + ", password=" + password + ", cityName="
						+ cityName + ", shop=" + shop + ", dealerName=" + dealerName + ", user=" + user + ", companyId="
						+ companyId + "]";
	}
    
}
