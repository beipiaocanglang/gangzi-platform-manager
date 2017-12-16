package com.bizcloud.platform;

import com.bizcloud.framework.base.ResultDTO;
import com.bizcloud.platform.dto.Platform;
import com.bizcloud.platform.dto.Template;
import com.github.pagehelper.PageInfo;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by biz on 2017/2/21.
 */
public interface TemplateManagerClient {

    /**
     * 查询平台下的所有模板
     * @return 模板列表
     */
    ResultDTO<List<Template>> getAllTemplates(@NotBlank String platformId);

    /**
     * 按id查询模板
     * @param templateId 模板Id
     * @return
     */
    ResultDTO<Template> getTemplateById(@NotBlank String templateId);

    /**
     *
     * @param templateType 模板类型，TemplateTypeEnum中的value值
     * @param platformId 平台id
     * @return
     */
    ResultDTO<Template> getTemplateByType(@NotBlank String templateType, @NotBlank String platformId);



    /**
     * 创建模板
     * @param template 模板信息
     * @return
     */
    ResultDTO<Boolean> createTemplate(@NotNull(message = "模板不可为空") @Valid Template template);

    /**
     * 更新模板
     * @param template 模板信息
     * @return
     */
    ResultDTO<Boolean> updateTemplate(@NotNull @Valid Template template);


    /**
     * 分页查询模板
     * @param templateName 模板名称关键字
     * @param pageNo 页码
     * @param pageSize 分页大小
     * @return
     */
    ResultDTO<PageInfo<Template>> listTemplate(String templateName, @NotNull Integer pageNo, @NotNull Integer pageSize);
}
