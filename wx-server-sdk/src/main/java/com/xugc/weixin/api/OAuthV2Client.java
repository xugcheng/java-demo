/**
 * 文件：OAuthV2Client.java
 * 系统：WECARE-WEIXIN-WEB
 * 版权：Copyright (c) 2016, All Rights Reserved.
 * 包名：com.wecare.weixin.sdk
 * 日期：2016-1-29下午4:03:24
 * 描述：
 */
package com.xugc.weixin.api;

import com.xugc.common.http.HttpUtil;

import java.security.MessageDigest;
import java.util.Arrays;


/**
 * 描述：OAuth2.0授权接口调用<br/>
 * 类名：OAuthV2Client <br/>
 * 日期：2016-1-29 下午4:03:24 <br/>
 *
 * @author 徐国诚
 * @since JDK 1.6
 */
public class OAuthV2Client {
    public static final String AUTHORIZE_URL = "https://open.weixin.qq.com/connect/oauth2/authorize";
    public static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token";
    public static final String REFRESH_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/refresh_token";
    public static final String GET_USER_INFO_URL = "https://api.weixin.qq.com/sns/userinfo";
    public static final String VALIDATE_TOKEN_URL = "https://api.weixin.qq.com/sns/auth";
    public static final String GET_JSAPI_TICKET_URL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket";

    /**
     * 获取oauth授权URL
     *
     * @param appId
     * @param redirct_uri
     * @param state
     * @return
     * @throws Exception
     * @author 徐国诚
     * @since JDK 1.6
     */
    public static String getAuthorizeUrl(String appId, String redirct_uri, String scope, String state) throws Exception {
        //https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect
        StringBuffer sb = new StringBuffer();
        sb.append(AUTHORIZE_URL);
        sb.append("?appid=").append(appId);
        sb.append("&redirect_uri=").append(redirct_uri);
        sb.append("&response_type=code");
        sb.append("&scope=").append(scope);
        sb.append("&state=").append(state);
        sb.append("#wechat_redirect");
        return sb.toString();
    }

    /**
     * oauth授权通过code获取access_token
     *
     * @param appId
     * @param appSecret
     * @param code
     * @return
     * @throws Exception
     * @author 徐国诚
     * @since JDK 1.6
     */
    public static String getAccessToken(String appId, String appSecret, String code) throws Exception {
        //https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code
        String response = null;
        StringBuffer sb = new StringBuffer();
        sb.append(ACCESS_TOKEN_URL);
        sb.append("?appid=").append(appId);
        sb.append("&secret=").append(appSecret);
        sb.append("&code=").append(code);
        sb.append("&grant_type=authorization_code");
        response = HttpUtil.get(sb.toString());
        return response;
    }

    /**
     * 刷新oauth授权获取的access_token
     *
     * @param appId
     * @param refreshToken
     * @return
     * @throws Exception
     * @author 徐国诚
     * @since JDK 1.6
     */
    public static String refreshToken(String appId, String refreshToken) throws Exception {
        //https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN
        String response = null;
        StringBuffer sb = new StringBuffer();
        sb.append(REFRESH_TOKEN_URL);
        sb.append("?appid=").append(appId);
        sb.append("&grant_type=refresh_token");
        sb.append("&refresh_token=").append(refreshToken);
        response = HttpUtil.get(sb.toString());
        return response;
    }

    /**
     * 拉取用户信息(需scope为 snsapi_userinfo)
     *
     * @param access_token
     * @param openId
     * @return
     * @throws Exception
     * @author 徐国诚
     * @since JDK 1.6
     */
    public static String getUserInfo(String access_token, String openId) throws Exception {
        //https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN
        String response = null;
        StringBuffer sb = new StringBuffer();
        sb.append(GET_USER_INFO_URL);
        sb.append("?access_token=").append(access_token);
        sb.append("&openid=").append(openId);
        sb.append("&lang=zh_CN");
        response = HttpUtil.get(sb.toString());
        return response;
    }

    /**
     * 检验授权凭证（access_token）是否有效
     *
     * @param access_token
     * @param openId
     * @return
     * @throws Exception
     * @author 徐国诚
     * @since JDK 1.6
     */
    public static String validateAccessToken(String access_token, String openId) throws Exception {
        //https://api.weixin.qq.com/sns/auth?access_token=ACCESS_TOKEN&openid=OPENID
        String response = null;
        StringBuffer sb = new StringBuffer();
        sb.append(VALIDATE_TOKEN_URL);
        sb.append("?access_token=").append(access_token);
        sb.append("&openid=").append(openId);
        response = HttpUtil.get(sb.toString());
        return response;
    }

    /**
     * 获取jsapi_ticket,jsapi_ticket是公众号用于调用微信JS接口的临时票据。正常情况下，jsapi_ticket的有效期为7200秒，通过access_token来获取
     *
     * @param access_token
     * @return
     * @throws Exception
     */
    public static String getJsApiTicket(String access_token) throws Exception {
        //https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi
        String response = null;
        StringBuffer sb = new StringBuffer();
        sb.append(GET_JSAPI_TICKET_URL);
        sb.append("?access_token=").append(access_token);
        sb.append("&type=jsapi");
        response = HttpUtil.get(sb.toString());
        return response;
    }

    /**
     * 获取JS-SDK使用权限签名
     *
     * @param jsapi_ticket
     * @param noncestr
     * @param timestamp
     * @param url
     * @return
     */
    public static String getSignature(String jsapi_ticket, String noncestr, long timestamp, String url) throws Exception {
        String[] tempArr = new String[]{
                "jsapi_ticket=" + jsapi_ticket,
                "noncestr=" + noncestr,
                "timestamp=" + timestamp,
                "url=" + url
        };
        Arrays.sort(tempArr);

        StringBuffer str = new StringBuffer();
        for (String tempStr : tempArr) {
            if (str.length() > 0) {
                str.append("&");
            }
            str.append(tempStr);
        }

        MessageDigest md = MessageDigest.getInstance("SHA-1");
        md.update(str.toString().getBytes());
        byte[] digest = md.digest();

        StringBuffer hexstr = new StringBuffer();
        String shaHex = "";
        for (int i = 0; i < digest.length; i++) {
            shaHex = Integer.toHexString(digest[i] & 0xFF);
            if (shaHex.length() < 2) {
                hexstr.append(0);
            }
            hexstr.append(shaHex);
        }
        return hexstr.toString();
    }
}
