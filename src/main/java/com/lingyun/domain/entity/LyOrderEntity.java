package com.lingyun.domain.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
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
@TableName("ly_order")
public class LyOrderEntity implements Serializable {
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
	@ApiModelProperty(value = "",name = "orderNum")
	private String orderNum;
	/**
	 * 
	 */
	@ApiModelProperty(value = "",name = "carId")
	private Integer carId;
	/**
	 *
	 */
	@ApiModelProperty(value = "",name = "customerId")
	private Integer customerId;
	/**
	 * 
	 */
	@ApiModelProperty(value = "",name = "payTotal")
	private BigDecimal payTotal;
	/**
	 * 
	 */
	@ApiModelProperty(value = "",name = "state")
	private Integer state;
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

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
}
