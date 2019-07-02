package com.lingyun.domain.from;

import com.lingyun.domain.entity.LyMenuEntity;

import java.io.Serializable;
import java.util.List;

public class LyRoleFrom implements Serializable {

    private Integer id;
    private String name;
    private String description;
    private List<LyMenuFrom> menus;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<LyMenuFrom> getMenus() {
        return menus;
    }

    public void setMenus(List<LyMenuFrom> menus) {
        this.menus = menus;
    }

    @Override
    public String toString() {
        return "LyRoleFrom{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
