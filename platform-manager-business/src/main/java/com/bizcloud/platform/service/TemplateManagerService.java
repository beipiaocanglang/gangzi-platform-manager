package com.bizcloud.platform.service;

import com.bizcloud.framework.exception.BizException;
import com.bizcloud.platform.dto.Template;
import com.bizcloud.platform.model.bo.MsgTemplateBO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by biz on 2017/2/21.
 */
public interface TemplateManagerService {

    List<MsgTemplateBO> getAllTemplates(String platformId);

    MsgTemplateBO getTemplateById(String templateId);

    MsgTemplateBO getTemplateByType(String platformId, String templateType);

    int createTemplate(Template template) throws BizException;

    int updateTemplate(Template template) throws BizException;

    PageInfo<Template> listTemplateByCondition(String templateName, Integer pageNo, Integer pageSize);
}
