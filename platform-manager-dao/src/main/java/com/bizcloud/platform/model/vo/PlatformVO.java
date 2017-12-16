package com.bizcloud.platform.model.vo;

import com.bizcloud.platform.model.bo.PlatformBO;

import java.util.Set;

/**
 * @author biz
 */
public class PlatformVO extends PlatformBO {
    /**
     * 平台id集合
     */
    private Set<String> platformIds;

    public Set<String> getPlatformIds() {
        return platformIds;
    }

    public void setPlatformIds(Set<String> platformIds) {
        this.platformIds = platformIds;
    }
}