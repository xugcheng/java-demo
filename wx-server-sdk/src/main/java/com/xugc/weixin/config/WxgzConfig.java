package com.xugc.weixin.config;

/**
 * 微信公众号的配置参数
 */
public class WxgzConfig {

    private String appId;

    private String appSecret;

    private String encodingAESKey;

    private String productId;

    private String brandUserName;

    private String token;

    private String host;

    private String cdnHost;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getEncodingAESKey() {
        return encodingAESKey;
    }

    public void setEncodingAESKey(String encodingAESKey) {
        this.encodingAESKey = encodingAESKey;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getBrandUserName() {
        return brandUserName;
    }

    public void setBrandUserName(String brandUserName) {
        this.brandUserName = brandUserName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getCdnHost() {
        return cdnHost;
    }

    public void setCdnHost(String cdnHost) {
        this.cdnHost = cdnHost;
    }

    @Override
    public String toString() {
        return "WxgzConfig{" +
                "appId='" + appId + '\'' +
                ", appSecret='" + appSecret + '\'' +
                ", encodingAESKey='" + encodingAESKey + '\'' +
                ", productId='" + productId + '\'' +
                ", brandUserName='" + brandUserName + '\'' +
                ", token='" + token + '\'' +
                ", host='" + host + '\'' +
                ", cdnHost='" + cdnHost + '\'' +
                '}';
    }
}
