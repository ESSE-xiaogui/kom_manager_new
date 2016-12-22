package com.transsion.store.dto;

import java.io.Serializable;

public class VersionInfoDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String version;
	
	private String appName;
	
	private String url;
	
	private String downLoad_flag;
	
	private String donwLoad_hint;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDownLoad_flag() {
		return downLoad_flag;
	}

	public void setDownLoad_flag(String downLoad_flag) {
		this.downLoad_flag = downLoad_flag;
	}

	public String getDonwLoad_hint() {
		return donwLoad_hint;
	}

	public void setDonwLoad_hint(String donwLoad_hint) {
		this.donwLoad_hint = donwLoad_hint;
	}

	@Override
	public String toString() {
		return "VersionInfoDto [id=" + id + ", version=" + version + ", appName=" + appName + ", url=" + url
						+ ", downLoad_flag=" + downLoad_flag + ", donwLoad_hint=" + donwLoad_hint + "]";
	}

}
