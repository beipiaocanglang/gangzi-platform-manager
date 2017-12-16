package com.bizcloud.platform.model.bo;

import com.bizcloud.platform.common.base.BaseBO;
import org.hibernate.validator.constraints.NotBlank;


/**
 * @author biz
 */
public class MsgTemplateBO extends BaseBO {

    /**
     * 所属平台ID
     */
    private String platformId;
    /**
     * 模板名称
     */
    private String templateName;

    /**
     * 模板代码
     */
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