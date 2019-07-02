package com.lingyun.domain.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 添加表 列属性
 * </p>
 * 
 * @author liujie
 * @email " "
 * @date 2019-01-22 14:31:25
 */
@ApiModel
@TableName("yr_add_table_row")
public class YrAddTableRowEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(value = "",name = "id")
	private Integer id;
	/**
	 * 列id
	 */
	@ApiModelProperty(value = "列id",name = "rowId")
	private Integer rowId;
	/**
	 * 添加表ID
	 */
	@ApiModelProperty(value = "添加表ID",name = "tableId")
	private Integer tableId;
	/**
	 * 状态 1:全选 2:条件赛选
	 */
	@ApiModelProperty(value = "状态 1:全选 2:条件赛选",name = "status")
	private Integer status;
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
	 * 设置：列id
	 */
	public void setRowId(Integer rowId) {
		this.rowId = rowId;
	}
	/**
	 * 获取：列id
	 */
	public Integer getRowId() {
		return rowId;
	}
	/**
	 * 设置：添加表ID
	 */
	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}
	/**
	 * 获取：添加表ID
	 */
	public Integer getTableId() {
		return tableId;
	}
	/**
	 * 设置：状态 1:全选 2:条件赛选
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态 1:全选 2:条件赛选
	 */
	public Integer getStatus() {
		return status;
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
