package com.transsion.store.bo;

import com.shangkang.core.bo.Model;

public class TaskDetail extends Model{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private Long taskId;
	
	private String message;
	
	private Integer status;
	
	private String createTime;
	
	private String constant;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getConstant() {
		return constant;
	}

	public void setConstant(String constant) {
		this.constant = constant;
	}

	@Override
	public String toString() {
		return "TaskDetail [id=" + id + ", taskId=" + taskId + ", message=" + message + ", status=" + status
						+ ", createTime=" + createTime + ", constant=" + constant + "]";
	}
	
}
