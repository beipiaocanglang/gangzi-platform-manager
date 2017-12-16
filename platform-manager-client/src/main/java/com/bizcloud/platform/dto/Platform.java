package com.bizcloud.platform.dto;

import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by biz on 2017/2/21.
 */
public class Platform  implements Serializable{
    private static final long serialVersionUID = 8972431269358734298L;

    /**
     * 主键ID
     */
    private String id;

    /**
     * 平台名称
     */
    @NotBlank(message = "平台名称不可以为空")
    private String platformName;

    /**
     * 平台代码
     */
    @NotBlank(message = "平台代码不可以为空")
    private String platformCode;

    /**
     * 平台状态
     */
    private String platformStatus;

    /**
     * 商城URL
     */
    private String mallUrl;

    /**
     * 分销URL
     */
    private String distributionUrl;

    /**
     * 微信公众号appId
     */
    private String appId;

    /**
     * 微信支付分配的商户号
     */
    private String merchantId;

    /**
     * 微信支付时使用的key
     * key设置路径：微信商户平台(pay.weixin.qq.com)-->账户设置-->API安全-->密钥设置
     */
    private String paySecretKey;

    /**
     * 支付证书路径
     */
    private String payCertPath;

    /**
     * 支付证书密码
     */
    private String payCertPassword;

    /**
     * 支付描述 (例：XX商城提现XX元，请查收！)
     */
    private String payDesc;

    /**
     * 商城SiteId
     */
    private String mallSiteId;
    /**
     * 分销SiteId
     */
    private String disSiteId;

    /**
     * 短信验证发送代码
     */
    private String smsMallAuthCode;

    /**
     *门店id
     */
    private String shopId;

    /**
     *登录信息保存名称
     */
    private String cookiesDomain;

    /**
     *支付id
     */
    private String payOrderSource;

    /**
     *首页Banner配置信息
     * pro:/pro/pro20170401.jpg:/pro20170401.html|1002155|195974|195994
     */
    private String bannerConfigString;

    /**
     * 首页热销商品配置信息
     * 232|21312321|2131231
     */
    private String hotGoodsConfigString;

    /**
     * 首页超值商品配置信息
     * 321321321|21312321|42342
     */
    private String valueGoodsConfigString;

    /**
     *首页新品推荐配置信息
     * 23421342|23243|23424234
     */
    private String newGoodsConfigString;

    /**
     *七牛云Key
     */
    private String qiniuAccessKey;

    /**
     *七牛云密钥
     */
    private String qiniuSecertKey;

    /**
     *七牛云图片存储位置名称
     */
    private String qiniuBucket;

    /**
     *包邮提示信息
     */
    private String postFeeLabel;

    /**
     * Json格式的内容
     */
    private String jsonContent;
    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新时间
     */
    private Date modifiedTime;

    /**
     * 逻辑删除标记; 0-未删除，1-已删除
     */
    private String isDeleted;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getPlatformCode() {
        return platformCode;
    }

    public void setPlatformCode(String platformCode) {
        this.platformCode = platformCode;
    }

    public String getPlatformStatus() {
        return platformStatus;
    }

    public void setPlatformStatus(String platformStatus) {
        this.platformStatus = platformStatus;
    }

    public String getMallUrl() {
        return mallUrl;
    }



    public void setMallUrl(String mallUrl) {
        this.mallUrl = mallUrl;
    }

    public String getDistributionUrl() {
        return distributionUrl;
    }

    public void setDistributionUrl(String distributionUrl) {
        this.distributionUrl = distributionUrl;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getPaySecretKey() {
        return paySecretKey;
    }

    public void setPaySecretKey(String paySecretKey) {
        this.paySecretKey = paySecretKey;
    }

    public String getPayCertPath() {
        return payCertPath;
    }

    public void setPayCertPath(String payCertPath) {
        this.payCertPath = payCertPath;
    }

    public String getPayCertPassword() {
        return payCertPassword;
    }

    public void setPayCertPassword(String payCertPassword) {
        this.payCertPassword = payCertPassword;
    }

    public String getPayDesc() {
        return payDesc;
    }

    public void setPayDesc(String payDesc) {
        this.payDesc = payDesc;
    }

    public String getMallSiteId() {
        return mallSiteId;
    }

    public void setMallSiteId(String mallSiteId) {
        this.mallSiteId = mallSiteId;
    }

    public String getDisSiteId() {
        return disSiteId;
    }

    public void setDisSiteId(String disSiteId) {
        this.disSiteId = disSiteId;
    }

    public String getSmsMallAuthCode() {
        return smsMallAuthCode;
    }

    public void setSmsMallAuthCode(String smsMallAuthCode) {
        this.smsMallAuthCode = smsMallAuthCode;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getCookiesDomain() {
        return cookiesDomain;
    }

    public void setCookiesDomain(String cookiesDomain) {
        this.cookiesDomain = cookiesDomain;
    }

    public String getPayOrderSource() {
        return payOrderSource;
    }

    public void setPayOrderSource(String payOrderSource) {
        this.payOrderSource = payOrderSource;
    }

    public String getBannerConfigString() {
        return bannerConfigString;
    }

    public void setBannerConfigString(String bannerConfigString) {
        this.bannerConfigString = bannerConfigString;
    }

    public String getHotGoodsConfigString() {
        return hotGoodsConfigString;
    }

    public void setHotGoodsConfigString(String hotGoodsConfigString) {
        this.hotGoodsConfigString = hotGoodsConfigString;
    }

    public String getValueGoodsConfigString() {
        return valueGoodsConfigString;
    }

    public void setValueGoodsConfigString(String valueGoodsConfigString) {
        this.valueGoodsConfigString = valueGoodsConfigString;
    }

    public String getNewGoodsConfigString() {
        return newGoodsConfigString;
    }

    public void setNewGoodsConfigString(String newGoodsConfigString) {
        this.newGoodsConfigString = newGoodsConfigString;
    }

    public String getQiniuAccessKey() {
        return qiniuAccessKey;
    }

    public void setQiniuAccessKey(String qiniuAccessKey) {
        this.qiniuAccessKey = qiniuAccessKey;
    }

    public String getQiniuSecertKey() {
        return qiniuSecertKey;
    }

    public void setQiniuSecertKey(String qiniuSecertKey) {
        this.qiniuSecertKey = qiniuSecertKey;
    }

    public String getQiniuBucket() {
        return qiniuBucket;
    }

    public void setQiniuBucket(String qiniuBucket) {
        this.qiniuBucket = qiniuBucket;
    }

    public String getPostFeeLabel() {
        return postFeeLabel;
    }

    public void setPostFeeLabel(String postFeeLabel) {
        this.postFeeLabel = postFeeLabel;
    }

    public String getJsonContent() {
        return jsonContent;
    }

    public void setJsonContent(String jsonContent) {
        this.jsonContent = jsonContent;
    }
}
