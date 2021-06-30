package com.gilberto.cursomc.resources.exceptionhandler;

import java.io.Serializable;

public class StandardError implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer status;
	private String msg;
	private Long timeStanp;
	public StandardError(Integer status, String msg, Long timeStanp) {
		super();
		this.status = status;
		this.msg = msg;
		this.timeStanp = timeStanp;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Long getTimeStanp() {
		return timeStanp;
	}
	public void setTimeStanp(Long timeStanp) {
		this.timeStanp = timeStanp;
	}
	
	
	

}
