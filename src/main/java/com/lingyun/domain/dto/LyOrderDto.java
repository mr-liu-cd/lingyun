package com.lingyun.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class LyOrderDto implements Serializable {

    private Integer customerId;
    private Integer carId;

    private String name;
    private String tele;
    private String idCard;

    private Integer carType;
    private String license;

    private Date insuranceTime;
    private Date annualInspectionTime;
    private String typeName;
    private String brandName;
    private String desc;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getCarType() {
        return carType;
    }

    public void setCarType(Integer carType) {
        this.carType = carType;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }
    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date getInsuranceTime() {
        return insuranceTime;
    }

    public void setInsuranceTime(Date insuranceTime) {
        this.insuranceTime = insuranceTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date getAnnualInspectionTime() {
        return annualInspectionTime;
    }

    public void setAnnualInspectionTime(Date annualInspectionTime) {
        this.annualInspectionTime = annualInspectionTime;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "LyOrderDto{" +
                "customerId=" + customerId +
                ", carId=" + carId +
                ", name='" + name + '\'' +
                ", tele='" + tele + '\'' +
                ", idCard='" + idCard + '\'' +
                ", carType=" + carType +
                ", license='" + license + '\'' +
                ", insuranceTime=" + insuranceTime +
                ", annualInspectionTime=" + annualInspectionTime +
                '}';
    }
}
