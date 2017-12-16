package com.bizcloud.platform.dto;

import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by leon on 2017/3/30.
 */
public class Template implements Serializable {
    private static final long serialVersionUID = 238192995747007437L;

    /**
     * 主键ID
     */
    private String id;

    /**
     * 所属平台ID
     */
    @NotBlank
    private String platformId;

    /**
     * 模板名称
     */
    private String templateName;

    /**
     * 模板代码
     */
    @NotBlank
    private String templateCode;

    /**
     * 模板类别
     */
    private String templateType;



    /**
     * 模板内容
     */
    private String templateContent;

    /**
     * 模板示例
     */
    private String templateExample;

    /**
     * 备注
     */
    private String remark;


    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新时间
     */
    private Date modifiedTime;

    /**
     * 逻辑删除标记; 0-未删除，1-已删除
     */
    private String isDeleted;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }

    public String getTemplateContent() {
        return templateContent;
    }

    public void setTemplateContent(String templateContent) {
        this.templateContent = templateContent;
    }

    public String getTemplateExample() {
        return templateExample;
    }

    public void setTemplateExample(String templateExample) {
        this.templateExample = templateExample;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public String getTemplateType() {
        return templateType;
    }

    public void setTemplateType(String templateType) {
        this.templateType = templateType;
    }
}
