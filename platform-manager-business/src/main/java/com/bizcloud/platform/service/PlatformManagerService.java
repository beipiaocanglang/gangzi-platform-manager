package com.bizcloud.platform.service;

import com.bizcloud.framework.exception.BizException;
import com.bizcloud.platform.dto.Platform;
import com.bizcloud.platform.model.bo.PlatformBO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by biz on 2017/2/21.
 */
public interface PlatformManagerService {

    List<PlatformBO> getAllPlatform();

    PlatformBO getPlatformById(String platformId);

    PlatformBO getPlatformByCode(String platformCode);

    PlatformBO getPlatformByAppId(String appId);

    int createPlatform(Platform platform) throws BizException;

    int updatePlatform(Platform platform) throws BizException;

    int disablePlatform(String platformId) throws BizException;

    int enablePlatform(String platformId) throws BizException;

    PageInfo<Platform> listPlatformByCondition(String keyWord, Integer pageNo, Integer pageSize);

    List<String> getAllPlatformCodes();
}
