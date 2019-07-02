package com.lingyun.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

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
public class YrTableValDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
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
	@ApiModelProperty(value = "",name = "rowName")
	private String rowName;
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

	public String getRowName() {
		return rowName;
	}

	public void setRowName(String rowName) {
		this.rowName = rowName;
	}

	@Override
	public String toString() {
		return "YrTableValDTO{" +
				"id=" + id +
				", rowId=" + rowId +
				", rowName='" + rowName + '\'' +
				", line=" + line +
				", val='" + val + '\'' +
				'}';
	}
}
