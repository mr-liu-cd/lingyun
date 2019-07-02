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
@TableName("yr_table_val")
public class YrTableValEntity implements Serializable {
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
	@ApiModelProperty(value = "",name = "rowId")
	private Integer rowId;
	/**
	 * 
	 */
	@ApiModelProperty(value = "",name = "line")
	private Integer line;
	/**
	 * 
	 */
	@ApiModelProperty(value = "",name = "val")
	private String val;
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
	public void setRowId(Integer rowId) {
		this.rowId = rowId;
	}
	/**
	 * 获取：
	 */
	public Integer getRowId() {
		return rowId;
	}
	/**
	 * 设置：
	 */
	public void setLine(Integer line) {
		this.line = line;
	}
	/**
	 * 获取：
	 */
	public Integer getLine() {
		return line;
	}
	/**
	 * 设置：
	 */
	public void setVal(String val) {
		this.val = val;
	}
	/**
	 * 获取：
	 */
	public String getVal() {
		return val;
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
