package com.bizcloud.platform.service.impl;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.bizcloud.architect.idgnrt.IdGenUtil;
import com.bizcloud.framework.exception.BizException;
import com.bizcloud.framework.logging.Logger;
import com.bizcloud.framework.logging.LoggerFactory;
import com.bizcloud.framework.mybatis.PageHelper;
import com.bizcloud.framework.util.BeanConvertUtil;
import com.bizcloud.platform.constant.PlatformStatusEnum;
import com.bizcloud.platform.dao.PlatformDAO;
import com.bizcloud.platform.dto.Platform;
import com.bizcloud.platform.model.bo.PlatformBO;
import com.bizcloud.platform.model.vo.PlatformVO;
import com.bizcloud.platform.service.PlatformManagerService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by biz on 2017/2/21.
 */
@Service("platformManagerService")
public class PlatformManagerServiceImpl implements PlatformManagerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PlatformManagerServiceImpl.class);
    private static final String PLATFORM_ID_STR = "BIZCLOUD_PLATFORM.PLATFORM";

    @Resource(name="platformDAO")
    private PlatformDAO platformDAO;

    @Resource(name = "idGenUtil")
    private IdGenUtil idGenUtil;

    @Override
    public List<PlatformBO> getAllPlatform() {
        return platformDAO.getAllPlatforms();
    }

    @Override
    public PlatformBO getPlatformById(String platformId) {
        return platformDAO.getPlatformBOById(platformId);
    }

    @Override
    public PlatformBO getPlatformByCode(String platformCode) {
        PlatformVO entity = new PlatformVO();
        entity.setPlatformCode(platformCode);
        PlatformBO returnBO = null;
        List<PlatformBO> returnList = platformDAO.getPlatformsByCondition(entity);
        if (CollectionUtils.isNotEmpty(returnList) && returnList.size()>0) {
            returnBO = returnList.get(0);
        }
        return returnBO;
    }

    @Override
    public PlatformBO getPlatformByAppId(String appId) {
        PlatformVO entity = new PlatformVO();
        entity.setAppId(appId);
        PlatformBO returnBO = null;
        List<PlatformBO> returnList = platformDAO.getPlatformsByCondition(entity);
        if (CollectionUtils.isNotEmpty(returnList) && returnList.size()>0) {
            returnBO = returnList.get(0);
        }
        return returnBO;
    }

    @Override
    public int createPlatform(Platform platform) throws BizException {
        PlatformVO entity = new PlatformVO();
        int returnInt = 0;
        try {
            BeanUtils.copyProperties(entity, platform);
            entity.setId(idGenUtil.nextAsStr(PLATFORM_ID_STR));
            entity.setCreatedTime(new Date());
            entity.setModifiedTime(new Date());
            entity.setIsDeleted("0");
            entity.setPlatformStatus("0");
            returnInt = platformDAO.savePlatformBO(entity);

        } catch (Exception e) {
            LOGGER.error(e);
            throw new BizException(e.getMessage(),e);
        }
        return returnInt;
    }

    @Override
    public int updatePlatform(Platform platform) throws BizException {
        PlatformVO entity = new PlatformVO();
        int returnInt = 0;
        try {
            BeanUtils.copyProperties(entity, platform);
            entity.setModifiedTime(new Date());
            returnInt = platformDAO.updatePlatformBO(entity);
        } catch (Exception e) {
            LOGGER.error(e);
            throw new BizException(e.getMessage(),e);
        }
        return returnInt;
    }

    @Override
    public int disablePlatform(String platformId) throws BizException {

        PlatformVO entity = new PlatformVO();
        int returnInt = 0;
        try {
            PlatformBO platform = platformDAO.getPlatformBOById(platformId);
            BeanUtils.copyProperties(entity, platform);
            entity.setModifiedTime(new Date());
            entity.setPlatformStatus(PlatformStatusEnum.DISABLED.getValue());
            returnInt = platformDAO.updatePlatformBO(entity);
        } catch (Exception e) {
            LOGGER.error(e);
            throw new BizException(e.getMessage(),e);
        }
        return returnInt;
    }

    @Override
    public int enablePlatform(String platformId) throws BizException {

        PlatformVO entity = new PlatformVO();
        int returnInt = 0;
        try {
            PlatformBO platform = platformDAO.getPlatformBOById(platformId);
            BeanUtils.copyProperties(entity, platform);
            entity.setModifiedTime(new Date());
            entity.setPlatformStatus(PlatformStatusEnum.ENABLE.getValue());
            returnInt = platformDAO.updatePlatformBO(entity);
        } catch (Exception e) {
            LOGGER.error(e);
            throw new BizException(e.getMessage(),e);
        }
        return returnInt;
    }

    @Override
    public PageInfo<Platform> listPlatformByCondition(String keyWord, Integer pageNum, Integer pageSize) {
        if (pageNum != null && pageNum > 0 && pageSize != null && pageSize > 0) {
            PageHelper.startPage(pageNum, pageSize);
        } else {
            PageHelper.startPage(1, 20);
        }
        PlatformVO entity = new PlatformVO();
        entity.setPlatformCode(keyWord);
        List<PlatformBO> platformBOs = platformDAO.getPlatformsByCondition(entity);
        Page<Platform> platformPages = null;
        try {
            platformPages = BeanConvertUtil.convertPageModels(platformBOs, Platform.class);
        } catch (Exception e) {
            LOGGER.error("convertPageModels error,platformBOs={}", platformBOs, e);
        }
        PageInfo<Platform> platPageInfo = new PageInfo<>(platformPages);
        return platPageInfo;
    }

    @Override
    public List<String> getAllPlatformCodes() {
        return platformDAO.getAllPlatformCodes();
    }
}
