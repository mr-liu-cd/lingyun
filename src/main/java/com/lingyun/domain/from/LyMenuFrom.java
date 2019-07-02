package com.lingyun.domain.from;

import java.util.List;

public class LyMenuFrom {
    private Integer id;
    private String name;
    private String url;
    private String icon;
    private Integer pid;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public List<LyMenuFrom> getMenus() {
        return menus;
    }

    public void setMenus(List<LyMenuFrom> menus) {
        this.menus = menus;
    }

    @Override
    public String toString() {
        return "LyMenuFrom{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", icon='" + icon + '\'' +
                ", pid=" + pid +
                ", menus=" + menus +
                '}';
    }
}
