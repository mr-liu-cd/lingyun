package com.lingyun.domain.from;

import java.io.Serializable;

public class LyCarTypeFrom implements Serializable {
	private Integer id;
	private String name;
	private Integer brandId;
	private String brandName;
	private String level;
	private String displacement;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getDisplacement() {
		return displacement;
	}

	public void setDisplacement(String displacement) {
		this.displacement = displacement;
	}

	@Override
	public String toString() {
		return "LyCarTypeFrom{" +
				"id=" + id +
				", name='" + name + '\'' +
				", brandId=" + brandId +
				", brandName='" + brandName + '\'' +
				'}';
	}
}
