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
 * @date 2019-01-22 14:31:25
 */
@ApiModel
@TableName("yr_add_table_condition")
public class YrAddTableConditionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(value = "",name = "id")
	private Integer id;
	/**
	 * a==b ————》a
	 */
	@ApiModelProperty(value = "a==b ————》a",name = "rowPreId")
	private Integer rowPreId;
	/**
	 * a==b ————》b
	 */
	@ApiModelProperty(value = "a==b ————》b",name = "rowEndId")
	private Integer rowEndId;
	/**
	 * 添加表ID
	 */
	@ApiModelProperty(value = "添加表ID",name = "tableId")
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
	 * 设置：a==b ————》a
	 */
	public void setRowPreId(Integer rowPreId) {
		this.rowPreId = rowPreId;
	}
	/**
	 * 获取：a==b ————》a
	 */
	public Integer getRowPreId() {
		return rowPreId;
	}
	/**
	 * 设置：a==b ————》b
	 */
	public void setRowEndId(Integer rowEndId) {
		this.rowEndId = rowEndId;
	}
	/**
	 * 获取：a==b ————》b
	 */
	public Integer getRowEndId() {
		return rowEndId;
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
}
