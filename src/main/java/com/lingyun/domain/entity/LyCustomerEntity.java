package com.lingyun.domain.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

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
@TableName("ly_customer")
public class LyCustomerEntity implements Serializable {
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
	@ApiModelProperty(value = "",name = "name")
	private String name;
	/**
	 * 
	 */
	@ApiModelProperty(value = "",name = "imgUrl")
	private String imgUrl;
	/**
	 * 
	 */
	@ApiModelProperty(value = "",name = "tele")
	private String tele;
	/**
	 * 
	 */
	@ApiModelProperty(value = "",name = "idCard")
	private String idCard;
	/**
	 * 
	 */
	@ApiModelProperty(value = "",name = "repairTimes")
	private Integer repairTimes;
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
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：
	 */
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	/**
	 * 获取：
	 */
	public String getImgUrl() {
		return imgUrl;
	}
	/**
	 * 设置：
	 */
	public void setTele(String tele) {
		this.tele = tele;
	}
	/**
	 * 获取：
	 */
	public String getTele() {
		return tele;
	}
	/**
	 * 设置：
	 */
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	/**
	 * 获取：
	 */
	public String getIdCard() {
		return idCard;
	}
	/**
	 * 设置：
	 */
	public void setRepairTimes(Integer repairTimes) {
		this.repairTimes = repairTimes;
	}
	/**
	 * 获取：
	 */
	public Integer getRepairTimes() {
		return repairTimes;
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
