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
 * @email " "
 * @date 2018-12-27 16:26:54
 */
@ApiModel
@TableName("yr_table_row")
public class YrTableRowEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YrTableRowEntity() {
	}

	public YrTableRowEntity(String name, Integer tableId) {
		this.name = name;
		this.tableId = tableId;
	}

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
	@ApiModelProperty(value = "",name = "tableId")
	private Integer tableId;
	/**
	 * 
	 */
	@ApiModelProperty(value = "",name = "createTime")
	private Date createTime;
	/**
	 * 
	 */
	@ApiModelProperty(value = "",name = "updateTime")
	private Date updateTime;
	/**
	 * 
	 */
	@ApiModelProperty(value = "",name = "isDeleted")
	private Integer isDeleted;

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
	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}
	/**
	 * 获取：
	 */
	public Integer getTableId() {
		return tableId;
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
	/**
	 * 设置：
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：
	 */
	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}
	/**
	 * 获取：
	 */
	public Integer getIsDeleted() {
		return isDeleted;
	}
}
