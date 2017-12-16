package com.bizcloud.platform.dao;

import com.bizcloud.platform.model.bo.PlatformBO;
import com.bizcloud.platform.model.vo.PlatformVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author biz
 */
@Repository("platformDAO")
public interface PlatformDAO {

    int savePlatformBO(PlatformBO platformBO);

    int deletePlatformBOById(String id);

    int updatePlatformBO(PlatformBO platformBO);

    PlatformBO getPlatformBOById(String id);

    List<PlatformBO> getPlatformNameByIds(List<String> ids);

    List<PlatformBO> getAllPlatforms();

    List<String> getAllPlatformCodes();

    List<PlatformBO> getPlatformsByCondition(PlatformVO platformVO);
}