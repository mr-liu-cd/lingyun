package com.lingyun.domain.from;

import java.io.Serializable;
import java.util.Date;
public class LyCustomerFrom implements Serializable {
	private Integer id;
	private String name;
	private String imgUrl;
	private String tele;
	private String idCard;
	private Integer repairTimes;
	private Date createTime;

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

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getTele() {
		return tele;
	}

	public void setTele(String tele) {
		this.tele = tele;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public Integer getRepairTimes() {
		return repairTimes;
	}

	public void setRepairTimes(Integer repairTimes) {
		this.repairTimes = repairTimes;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "LyCustomerFrom{" +
				"id=" + id +
				", name='" + name + '\'' +
				", imgUrl='" + imgUrl + '\'' +
				", tele='" + tele + '\'' +
				", idCard='" + idCard + '\'' +
				", repairTimes=" + repairTimes +
				", createTime=" + createTime +
				'}';
	}
}
