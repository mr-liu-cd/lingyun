package com.lingyun.domain.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 * 
 * @author liujie
 * @email 956225064@qq.com
 * @date 2018-09-02 13:30:01
 */
@ApiModel
@TableName("ly_car")
public class LyCarEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(value = "",name = "id")
	private Integer id;
	/**
	 * 
	 */
	@ApiModelProperty(value = "",name = "carType")
	private Integer carType;
	/**
	 * 
	 */
	@ApiModelProperty(value = "",name = "license")
	private String license;
	/**
	 * 
	 */
	@ApiModelProperty(value = "",name = "customerId")
	private Integer customerId;
	/**
	 * 
	 */
	@ApiModelProperty(value = "",name = "repairTime")
	private Date recentRepairTime;
	/**
	 * 
	 */
	@ApiModelProperty(value = "",name = "insuranceTime")
	private Date insuranceTime;
	/**
	 * 
	 */
	@ApiModelProperty(value = "",name = "annualInspectionTime")
	private Date annualInspectionTime;
	/**
	 * 
	 */
	@ApiModelProperty(value = "",name = "createTime")
	private Date createTime;

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
	public void setCarType(Integer carType) {
		this.carType = carType;
	}
	/**
	 * 获取：
	 */
	public Integer getCarType() {
		return carType;
	}
	/**
	 * 设置：
	 */
	public void setLicense(String license) {
		this.license = license;
	}
	/**
	 * 获取：
	 */
	public String getLicense() {
		return license;
	}

	public Date getRecentRepairTime() {
		return recentRepairTime;
	}

	public void setRecentRepairTime(Date recentRepairTime) {
		this.recentRepairTime = recentRepairTime;
	}

	/**
	 * 设置：
	 */
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	/**
	 * 获取：
	 */
	public Integer getCustomerId() {
		return customerId;
	}

	/**
	 * 设置：
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	public void setInsuranceTime(Date insuranceTime) {
		this.insuranceTime = insuranceTime;
	}
	/**
	 * 获取：
	 */
	public Date getInsuranceTime() {
		return insuranceTime;
	}
	/**
	 * 设置：
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	public void setAnnualInspectionTime(Date annualInspectionTime) {
		this.annualInspectionTime = annualInspectionTime;
	}
	/**
	 * 获取：
	 */
	public Date getAnnualInspectionTime() {
		return annualInspectionTime;
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
}
