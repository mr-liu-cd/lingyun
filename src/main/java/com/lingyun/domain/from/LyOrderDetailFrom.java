package com.lingyun.domain.from;

import java.io.Serializable;
import java.math.BigDecimal;

public class LyOrderDetailFrom implements Serializable {

	private Integer id;
	private Integer orderId;
	private Integer detailId;
	private Integer unitId;
	private BigDecimal price;
	private Integer num;
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getDetailId() {
		return detailId;
	}

	public void setDetailId(Integer detailId) {
		this.detailId = detailId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Integer getUnitId() {
		return unitId;
	}

	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}

	@Override

	public String toString() {
		return "LyOrderDetailFrom{" +
				"id=" + id +
				", orderId=" + orderId +
				", detailId=" + detailId +
				", price=" + price +
				", num=" + num +
				", name='" + name + '\'' +
				'}';
	}
}
