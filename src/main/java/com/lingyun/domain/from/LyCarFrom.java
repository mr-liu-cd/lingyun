package com.lingyun.domain.from;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class LyCarFrom implements Serializable {
    private Integer id;
    private Integer carType;
    private String license;
    private Integer customerId;
    private Date recentRepairTime;
    private Date insuranceTime;
    private Date annualInspectionTime;
    private Date createTime;

    private String typeName;
    private String brandName;
    private String customer;
    private Integer times;
    private String tele;

    public Integer
    getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Date getRecentRepairTime() {
        return recentRepairTime;
    }

    public void setRecentRepairTime(Date recentRepairTime) {
        this.recentRepairTime = recentRepairTime;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    @Override
    public String toString() {
        return "LyCarFrom{" +
                "id=" + id +
                ", carType=" + carType +
                ", license='" + license + '\'' +
                ", customerId=" + customerId +
                ", recentRepairTime=" + recentRepairTime +
                ", insuranceTime=" + insuranceTime +
                ", annualInspectionTime=" + annualInspectionTime +
                ", createTime=" + createTime +
                ", typeName='" + typeName + '\'' +
                ", brandName='" + brandName + '\'' +
                ", customer='" + customer + '\'' +
                ", times=" + times +
                '}';
    }
}
