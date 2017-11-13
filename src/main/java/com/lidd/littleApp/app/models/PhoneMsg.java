package com.lidd.littleApp.app.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
/**
 * 商品
 * @author ldd
 *
 */
@Entity
public class PhoneMsg implements Serializable { 
	private static final long serialVersionUID = 1L;   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String phoneMsg;
	@Column
	private Integer createTime;
	@Column
	@CreatedDate
	private String phoneNum;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPhoneMsg() {
		return phoneMsg;
	}
	public void setPhoneMsg(String phoneMsg) {
		this.phoneMsg = phoneMsg;
	}
	public Integer getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public PhoneMsg() {
		
	}
}
