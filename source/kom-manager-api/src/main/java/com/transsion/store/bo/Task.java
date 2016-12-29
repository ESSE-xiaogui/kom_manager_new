package com.transsion.store.bo;

import com.shangkang.core.bo.Model;

public class Task extends Model{
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	
	private Long id;
	
	private String taskType;
	
	private String fileName;
	
	private String uploadPath;
	
	private Integer stage;
	
	private String uploadTime;
	
	private String userName;
	
	private Integer status;
	
	private String remark;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getUploadPath() {
		return uploadPath;
	}

	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}

	public Integer getStage() {
		return stage;
	}

	public void setStage(Integer stage) {
		this.stage = stage;
	}

	public String getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", taskType=" + taskType + ", fileName=" + fileName + ", uploadPath=" + uploadPath
						+ ", stage=" + stage + ", uploadTime=" + uploadTime + ", userName=" + userName + ", status="
						+ status + ", remark=" + remark + "]";
	}
}
