package com.bizcloud.platform;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.bizcloud.framework.base.ResultDTO;
import com.bizcloud.framework.base.ResultDTOBuilder;
import com.bizcloud.platform.dto.Platform;
import com.bizcloud.platform.model.bo.PlatformBO;
import com.bizcloud.platform.service.PlatformManagerService;
import com.github.pagehelper.PageInfo;
import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by biz on 2017/2/21.
 */
@Validated
@Service("platformManagerClientImpl")
public class PlatformManagerClientImpl implements PlatformManagerClient{

    @Resource(name="platformManagerService")
    private PlatformManagerService platformManagerService;

    @Override
    public ResultDTO<List<Platform>> getAllPlatform() {
        List<Platform> returnList = null;
        try {
            List<PlatformBO> allPlatform = platformManagerService.getAllPlatform();
            if (CollectionUtils.isNotEmpty(allPlatform)) {
                returnList = new ArrayList<>(allPlatform.size());
                for (PlatformBO platformBO : allPlatform) {
                    Platform entity = new Platform();
                    BeanUtils.copyProperties(entity,platformBO);
                    returnList.add(entity);
                }
            }
        }catch (Exception e) {
            return ResultDTOBuilder.failure(e);
        }
        return ResultDTOBuilder.success(returnList);
    }

    @Override
    public ResultDTO<Platform> getPlatformById(String platformId) {
        Platform returnEntity = null;
        try {
            PlatformBO bo = platformManagerService.getPlatformById(platformId);
            if (null != bo) {
                returnEntity = new Platform();
                BeanUtils.copyProperties(returnEntity, bo);
            }
        }catch (Exception e) {
            return ResultDTOBuilder.failure(e);
        }
        return ResultDTOBuilder.success(returnEntity);
    }

    @Override
    public ResultDTO<Platform> getPlatformByAppId(@NotBlank String appId) {
        Platform returnEntity = null;
        try {
            PlatformBO bo = platformManagerService.getPlatformByAppId(appId);
            if (null != bo) {
                returnEntity = new Platform();
                BeanUtils.copyProperties(returnEntity, bo);
            }
        }catch (Exception e) {
            return ResultDTOBuilder.failure(e);
        }
        return ResultDTOBuilder.success(returnEntity);
    }

    @Override
    public ResultDTO<Platform> getPlatformByCode(String platformCode) {
        Platform returnEntity = null;
        try {
            PlatformBO bo = platformManagerService.getPlatformByCode(platformCode);
            if (null != bo) {
                returnEntity = new Platform();
                BeanUtils.copyProperties(returnEntity, bo);
            }
        }catch (Exception e) {
            return ResultDTOBuilder.failure(e);
        }
        return ResultDTOBuilder.success(returnEntity);
    }

    @Override
    public ResultDTO<Boolean> createPlatform(Platform platform) {
        Boolean success = false;
        try {
            int successCount = platformManagerService.createPlatform(platform);
            success = successCount>0;
        }catch (Exception e) {
            return ResultDTOBuilder.failure(e);
        }
        return ResultDTOBuilder.success(success);
    }

    @Override
    public ResultDTO<Boolean> updatePlatform(Platform platform) {
        Boolean success = false;
        try {
            int successCount = platformManagerService.updatePlatform(platform);
            success = successCount>0;
        }catch (Exception e) {
            return ResultDTOBuilder.failure(e);
        }
        return ResultDTOBuilder.success(success);
    }

    @Override
    public ResultDTO<Boolean> disablePlatform(String platformId) {
        Boolean success = false;
        try {
            int successCount = platformManagerService.disablePlatform(platformId);
            success = successCount>0;
        }catch (Exception e) {
            return ResultDTOBuilder.failure(e);
        }
        return ResultDTOBuilder.success(success);
    }

    @Override
    public ResultDTO<Boolean> enablePlatform(String platformId) {
        Boolean success = false;
        try {
            int successCount = platformManagerService.enablePlatform(platformId);
            success = successCount>0;
        }catch (Exception e) {
            return ResultDTOBuilder.failure(e);
        }
        return ResultDTOBuilder.success(success);
    }

    @Override
    public ResultDTO<PageInfo<Platform>> listPlatform(String keyWord, Integer pageNo, Integer pageSize) {
        PageInfo<Platform> platformPageInfo = null;
        try {
            platformPageInfo = platformManagerService.listPlatformByCondition(keyWord, pageNo, pageSize);
        }catch (Exception e) {
            return ResultDTOBuilder.failure(e);
        }
        return ResultDTOBuilder.success(platformPageInfo);
    }

    @Override
    public ResultDTO<List<String>> listAllPlatformCodes() {
        List<String> returnList = null;
        try {
            List<String> allPlatformCodes = platformManagerService.getAllPlatformCodes();
            if (CollectionUtils.isNotEmpty(allPlatformCodes)) {
                returnList = new ArrayList<>(allPlatformCodes.size());
                for (String code : allPlatformCodes) {
                    returnList.add(code);
                }
            }
        }catch (Exception e) {
            return ResultDTOBuilder.failure(e);
        }
        return ResultDTOBuilder.success(returnList);
    }
}
