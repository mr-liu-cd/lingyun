package com.lingyun.domain.from;

import java.io.Serializable;
import java.util.List;

public class LyUserFrom implements Serializable {
    private Integer id;
    private String username;
    private List<LyMenuFrom> menus;
    private Integer roleId;
    private Integer status;
    private String roleName;
    private String token;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<LyMenuFrom> getMenus() {
        return menus;
    }

    public void setMenus(List<LyMenuFrom> menus) {
        this.menus = menus;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "LyUserFrom{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", menus=" + menus +
                ", roleId=" + roleId +
                ", status=" + status +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
