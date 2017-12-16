package com.bizcloud.platform;

import com.bizcloud.framework.base.ResultDTO;
import com.bizcloud.platform.dto.Platform;
import com.github.pagehelper.PageInfo;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by biz on 2017/2/21.
 */
public interface PlatformManagerClient {

    /**
     * 查询所有平台
     * @return 平台列表
     */
    ResultDTO<List<Platform>> getAllPlatform();

    /**
     * 按id查询平台
     * @param platformId 平台Id
     * @return
     */
    ResultDTO<Platform> getPlatformById(@NotBlank String platformId);

    /**
     * 按id查询平台
     * @param appId 微信公众平台id
     * @return
     */
    ResultDTO<Platform> getPlatformByAppId(@NotBlank String appId);

    /**
     * 按企业码查询平台
     * @param platformCode 平台企业码
     * @return
     */
    ResultDTO<Platform> getPlatformByCode(@NotBlank(message="平台代码不可以为空") String platformCode);

    /**
     * 创建平台
     * @param platform 平台信息
     * @return
     */
    ResultDTO<Boolean> createPlatform(@NotNull(message="平台类不可为空") @Valid Platform platform);

    /**
     * 更新平台
     * @param platform 平台信息
     * @return
     */
    ResultDTO<Boolean> updatePlatform(@NotNull @Valid Platform platform);

    /**
     * 禁用平台
     * @param platformId
     * @return
     */
    ResultDTO<Boolean> disablePlatform(@NotBlank String platformId);

    /**
     * 解禁平台
     * @param platformId
     * @return
     */
    ResultDTO<Boolean> enablePlatform(@NotBlank String platformId);

    /**
     * 分页查询平台
     * @param keyWord 企业码关键字
     * @param pageNo 页码
     * @param pageSize 分页大小
     * @return
     */
    ResultDTO<PageInfo<Platform>> listPlatform(String keyWord, @NotNull Integer pageNo, @NotNull Integer pageSize);


    /**
     * 获取所有平台的企业码
     * @return
     */
    ResultDTO<List<String>> listAllPlatformCodes();
}
