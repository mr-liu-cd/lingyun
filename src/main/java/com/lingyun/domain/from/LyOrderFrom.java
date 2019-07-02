package com.lingyun.domain.from;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class LyOrderFrom implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String orderNum;
	private Integer carId;
	private BigDecimal payTotal;
	private Integer state;
	private Date createTime;
	private String license;
	private String name;
	private String typeName;
	private String brandName;
	private String tele;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	/**
	 * 获取：
	 */
	public String getOrderNum() {
		return orderNum;
	}
	/**
	 * 设置：
	 */
	public void setCarId(Integer carId) {
		this.carId = carId;
	}
	/**
	 * 获取：
	 */
	public Integer getCarId() {
		return carId;
	}
	/**
	 * 设置：
	 */
	public void setPayTotal(BigDecimal payTotal) {
		this.payTotal = payTotal;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getPayTotal() {
		return payTotal;
	}
	/**
	 * 设置：
	 */
	public void setState(Integer state) {
		this.state = state;
	}
	/**
	 * 获取：
	 */
	public Integer getState() {
		return state;
	}
	/**
	 * 设置：
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：
	 */
	public Date getCreateTime() {
		return createTime;
	}


	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getTele() {
		return tele;
	}

	public void setTele(String tele) {
		this.tele = tele;
	}
}
