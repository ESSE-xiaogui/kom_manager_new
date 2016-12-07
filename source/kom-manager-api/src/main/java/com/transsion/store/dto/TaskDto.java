package com.transsion.store.dto;

import java.io.Serializable;

public class TaskDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String taskType;
	
	private String fileName;
	
	private String uploadPath;
	
	private String userName;

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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "TaskDto [taskType=" + taskType + ", fileName=" + fileName + ", uploadPath=" + uploadPath + ", userName="
				+ userName + "]";
	}

}
