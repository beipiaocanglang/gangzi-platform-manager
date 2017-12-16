package com.bizcloud.platform.model.vo;

import com.bizcloud.platform.model.bo.MsgTemplateBO;

import java.util.Set;

/**
 * @author biz
 */
public class MsgTemplateVO extends MsgTemplateBO {
    /**
     * 模板id集合
     */
    private Set<String> templateIds;

    public Set<String> getTemplateIds() {
        return templateIds;
    }

    public void setTemplateIds(Set<String> templateIds) {
        this.templateIds = templateIds;
    }
}