package com.bizcloud.platform.dao;

import com.bizcloud.platform.model.bo.MsgTemplateBO;
import com.bizcloud.platform.model.vo.MsgTemplateVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by leon on 2017/3/30.
 */
@Repository("templateDAO")
public interface TemplateDAO {

    int saveTemplateBO(MsgTemplateBO msgTemplateBO);

    int deleteTemplateBOById(String id);

    int updateTemplateBO(MsgTemplateBO msgTemplateBO);

    MsgTemplateBO getTemplateById(String id);

    List<MsgTemplateBO> getTemplateByIds(List<String> ids);

    List<MsgTemplateBO> getAllTemplates(String platformId);

    List<MsgTemplateBO> getTemplatesByCondition(MsgTemplateVO msgTemplateVO);
}
