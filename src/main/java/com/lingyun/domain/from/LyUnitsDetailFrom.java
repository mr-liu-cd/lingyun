package com.lingyun.domain.from;

public class LyUnitsDetailFrom {
    private Integer id;
    private Integer unitId;
    private String desc;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "LyUnitsDetailFrom{" +
                "id=" + id +
                ", unitId=" + unitId +
                ", desc='" + desc + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
