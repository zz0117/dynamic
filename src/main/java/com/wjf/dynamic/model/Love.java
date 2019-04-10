package com.wjf.dynamic.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Love {
    Integer id;
    String openId;
    String dynamicsId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date createDate;
    Integer type;
    Date updateDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getDynamicsId() {
        return dynamicsId;
    }

    public void setDynamicsId(String dynamicsId) {
        this.dynamicsId = dynamicsId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
