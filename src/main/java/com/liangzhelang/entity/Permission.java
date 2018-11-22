package com.liangzhelang.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

public class Permission {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String permissionName;

    private String url;

    private String resouceType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName == null ? null : permissionName.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getResouceType() {
        return resouceType;
    }

    public void setResouceType(String resouceType) {
        this.resouceType = resouceType == null ? null : resouceType.trim();
    }
}