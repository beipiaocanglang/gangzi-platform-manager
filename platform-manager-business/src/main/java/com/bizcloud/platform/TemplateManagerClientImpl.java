package com.bizcloud.platform;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.bizcloud.framework.base.ResultDTO;
import com.bizcloud.framework.base.ResultDTOBuilder;
import com.bizcloud.framework.exception.BizException;
import com.bizcloud.platform.TemplateManagerClient;
import com.bizcloud.platform.constant.TemplateTypeEnum;
import com.bizcloud.platform.dto.Platform;
import com.bizcloud.platform.dto.Template;
import com.bizcloud.platform.model.bo.MsgTemplateBO;
import com.bizcloud.platform.service.TemplateManagerService;
import com.github.pagehelper.PageInfo;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by biz on 2017/2/21.
 */
@Validated
@Service("templateManagerClientImpl")
public class TemplateManagerClientImpl implements TemplateManagerClient {

    @Resource(name="templateManagerService")
    private TemplateManagerService templateManagerService;
    @Override
    public ResultDTO<List<Template>> getAllTemplates(@NotBlank String platformId) {
        List<Template> returnList = null;
        try {
            List<MsgTemplateBO> allTemplates = templateManagerService.getAllTemplates(platformId);
            if (CollectionUtils.isNotEmpty(allTemplates)) {
                returnList = new ArrayList<>(allTemplates.size());
                for (MsgTemplateBO msgTemplateBO : allTemplates) {
                    Template entity = new Template();
                    BeanUtils.copyProperties(entity,msgTemplateBO);
                    returnList.add(entity);
                }
            }
        }catch (Exception e) {
            return ResultDTOBuilder.failure(e);
        }
        return ResultDTOBuilder.success(returnList);
    }

    @Override
    public ResultDTO<Template> getTemplateById(@NotBlank String templateId) {
        Template returnEntity = null;
        try {
            MsgTemplateBO bo = templateManagerService.getTemplateById(templateId);
            if (null != bo) {
                returnEntity = new Template();
                BeanUtils.copyProperties(returnEntity, bo);
            }
        }catch (Exception e) {
            return ResultDTOBuilder.failure(e);
        }
        return ResultDTOBuilder.success(returnEntity);
    }

    @Override
    public ResultDTO<Template> getTemplateByType(@NotBlank String templateType, @NotBlank String platformId) {
        Template returnEntity = null;
        try {
            MsgTemplateBO bo = templateManagerService.getTemplateByType(platformId,templateType);
            if (null != bo) {
                returnEntity = new Template();
                BeanUtils.copyProperties(returnEntity, bo);
            }
        }catch (Exception e) {
            return ResultDTOBuilder.failure(e);
        }
        return ResultDTOBuilder.success(returnEntity);
    }

    @Override
    public ResultDTO<Boolean> createTemplate(@NotNull(message = "模板不可为空") @Valid Template template) {
        Boolean success = false;
        try {
            validateTemplateType(template.getTemplateType());
            int successCount = templateManagerService.createTemplate(template);
            success = successCount>0;
        }catch (Exception e) {
            return ResultDTOBuilder.failure(e);
        }
        return ResultDTOBuilder.success(success);
    }

    @Override
    public ResultDTO<Boolean> updateTemplate(@NotNull @Valid Template template) {
        Boolean success = false;
        try {
            validateTemplateType(template.getTemplateType());
            int successCount = templateManagerService.updateTemplate(template);
            success = successCount>0;
        }catch (Exception e) {
            return ResultDTOBuilder.failure(e);
        }
        return ResultDTOBuilder.success(success);
    }

    @Override
    public ResultDTO<PageInfo<Template>> listTemplate(String templateName, @NotNull Integer pageNo, @NotNull Integer pageSize) {
        PageInfo<Template> templatePageInfo = null;
        try {
            templatePageInfo = templateManagerService.listTemplateByCondition(templateName, pageNo, pageSize);
        }catch (Exception e) {
            return ResultDTOBuilder.failure(e);
        }
        return ResultDTOBuilder.success(templatePageInfo);
    }


    private void validateTemplateType(String value) throws BizException{
        if (StringUtils.isEmpty(TemplateTypeEnum.getDescByValue(value)))
            throw new BizException("模板类型不符合系统规格");
    }
}
