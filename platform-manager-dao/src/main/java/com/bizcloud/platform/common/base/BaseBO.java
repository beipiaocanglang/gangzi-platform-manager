package com.bizcloud.platform.common.base;

import java.io.Serializable;
import java.util.Date;

/**
 * BO（Business Object）为数据库表的映射对象
 * <br/> BaseBO中定义了公共字段，所有数据库表的映射对象都需要继承BaseBO
 *
 */
public class BaseBO implements Serializable {

    private static final long serialVersionUID = -1780641891593648845L;
    /**
     * 主键ID
     */
    protected String id;

    /**
     * 创建时间
     */
    protected Date createdTime;

    /**
     * 更新时间
     */
    protected Date modifiedTime;

    /**
     * 逻辑删除标记; 0-未删除，1-已删除
     */
    protected String isDeleted;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }
}