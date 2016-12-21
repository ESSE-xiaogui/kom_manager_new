package com.transsion.store.bo;

public class OrgBiz extends Model{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String bizAttribute;
	
	private String createBy;
	
	private String createTime;
	
	private String remark;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBizAttribute() {
		return bizAttribute;
	}

	public void setBizAttribute(String bizAttribute) {
		this.bizAttribute = bizAttribute;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "OrgBiz [id=" + id + ", bizAttribute=" + bizAttribute + ", createBy=" + createBy + ", createTime="
						+ createTime + ", remark=" + remark + "]";
	}

}
