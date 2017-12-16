package com.bizcloud.platform.service.impl;

import com.bizcloud.architect.idgnrt.IdGenUtil;
import com.bizcloud.framework.exception.BizException;
import com.bizcloud.framework.logging.Logger;
import com.bizcloud.framework.logging.LoggerFactory;
import com.bizcloud.framework.mybatis.PageHelper;
import com.bizcloud.framework.util.BeanConvertUtil;
import com.bizcloud.platform.dao.TemplateDAO;
import com.bizcloud.platform.dto.Template;
import com.bizcloud.platform.model.bo.MsgTemplateBO;
import com.bizcloud.platform.model.vo.MsgTemplateVO;
import com.bizcloud.platform.service.TemplateManagerService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by leon on 2017/3/30.
 */
@Service("templateManagerService")
public class TemplateManagerServiceImpl implements TemplateManagerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TemplateManagerServiceImpl.class);
    private static final String NOTIFY_TEMPLATE_ID_STR = "BIZCLOUD_PLATFORM.NOTIFY_MSG_TEMPLATE";

    @Resource(name="templateDAO")
    private TemplateDAO templateDAO;

    @Resource(name = "idGenUtil")
    private IdGenUtil idGenUtil;

    @Override
    public List<MsgTemplateBO> getAllTemplates(String templateId) {
        return templateDAO.getAllTemplates(templateId);
    }

    @Override
    public MsgTemplateBO getTemplateById(String templateId) {
        return templateDAO.getTemplateById(templateId);
    }

    @Override
    public MsgTemplateBO getTemplateByType(String platformId, String templateType) {
        MsgTemplateVO entity = new MsgTemplateVO();
        entity.setPlatformId(platformId);
        entity.setTemplateType(templateType);
        List<MsgTemplateBO> templatesBos = templateDAO.getTemplatesByCondition(entity);
        if (CollectionUtils.isNotEmpty(templatesBos)) {
            return templatesBos.get(0);
        }
        return null;
    }

    @Override
    public int createTemplate(Template template) throws BizException {
        MsgTemplateBO entity = new MsgTemplateBO();
        int returnInt = 0;
        try {
            BeanUtils.copyProperties(entity, template);
            entity.setId(idGenUtil.nextAsStr(NOTIFY_TEMPLATE_ID_STR));
            entity.setCreatedTime(new Date());
            entity.setModifiedTime(new Date());
            entity.setIsDeleted("0");
            returnInt = templateDAO.saveTemplateBO(entity);
        } catch (Exception e) {
            LOGGER.error(e);
            throw new BizException("数据库操作错误，请核查数据是否正确！");
        }
        return returnInt;
    }

    @Override
    public int updateTemplate(Template template) throws BizException {
        MsgTemplateBO entity = new MsgTemplateBO();
        int returnInt = 0;
        try {
            BeanUtils.copyProperties(entity, template);
            entity.setModifiedTime(new Date());
            returnInt = templateDAO.updateTemplateBO(entity);
        } catch (Exception e) {
            LOGGER.error(e);
            throw new BizException("数据库操作错误，请核查数据是否正确！");
        }
        return returnInt;
    }

    @Override
    public PageInfo<Template> listTemplateByCondition(String templateName, Integer pageNo, Integer pageSize) {
        if (pageNo != null && pageNo > 0 && pageSize != null && pageSize > 0) {
            PageHelper.startPage(pageNo, pageSize);
        } else {
            PageHelper.startPage(1, 20);
        }
        MsgTemplateVO entity = new MsgTemplateVO();
        entity.setTemplateName(templateName);
        List<MsgTemplateBO> templatesBos = templateDAO.getTemplatesByCondition(entity);
        Page<Template> templatePages = null;
        try {
            templatePages = BeanConvertUtil.convertPageModels(templatesBos, Template.class);
        } catch (Exception e) {
            LOGGER.error("convertPageModels error,templatesBos={}", templatesBos, e);
        }
        PageInfo<Template> templatePageInfo = new PageInfo<>(templatePages);
        return templatePageInfo;
    }
}
