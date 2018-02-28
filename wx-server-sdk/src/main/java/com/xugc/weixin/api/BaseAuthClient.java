/**
 * 文件：BaseAuth.java
 * 系统：WECARE-WEIXIN-WEB
 * 版权：Copyright (c) 2016, All Rights Reserved.
 * 包名：com.wecare.weixin.sdk
 * 日期：2016-1-29下午2:22:26
 * 描述：
 */
package com.xugc.weixin.api;

import com.alibaba.fastjson.JSONObject;
import com.xugc.common.http.HttpUtil;
import com.xugc.common.http.StringUtil;


/**
 * 描述：微信基础权限接口调用类 <br/>
 * 类名：BaseAuth <br/>
 * 日期：2016-1-29 下午2:22:26 <br/>
 *
 * @author 徐国诚
 * @since JDK 1.6
 */
public class BaseAuthClient {

    /**
     * 微信获取access_token接口地址
     */
    public static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token";

    /**
     * 获取微信服务器IP地址接口地址
     */
    public static final String GET_CALBACK_IP_URL = "https://api.weixin.qq.com/cgi-bin/getcallbackip";

    /**
     * 获取用户基本信息（包括UnionID机制）
     */
    public static final String GET_USER_INFORMATION_URL = "https://api.weixin.qq.com/cgi-bin/user/info";

    /**
     * 获取access_token
     *
     * @param appId
     * @param appSecret
     * @return {"access_token":"VOvlaJ07gQoIcP_eTNQyRjrlS8vpZ9HbA3i1TpsWSLlTwiP9wNBGG6cq83Kk6hWyiG56ZS10nsvwGBVu9sumraavDYu-HRNY7v2HN8kJrfeTeR-BCBx1TAzAOYKNqrPeAPMbAGALAX","expires_in":7200}
     * @throws Exception
     * @author 徐国诚
     * @since JDK 1.6
     */
    public static String getAccessTokenResponse(String appId, String appSecret) throws Exception {
        String url = ACCESS_TOKEN_URL + "?grant_type=client_credential&appid=" + appId + "&secret=" + appSecret;
        return HttpUtil.get(url);
    }

    /**
     * 获取access_token
     *
     * @param appId
     * @param appSecret
     * @return {"access_token":"VOvlaJ07gQoIcP_eTNQyRjrlS8vpZ9HbA3i1TpsWSLlTwiP9wNBGG6cq83Kk6hWyiG56ZS10nsvwGBVu9sumraavDYu-HRNY7v2HN8kJrfeTeR-BCBx1TAzAOYKNqrPeAPMbAGALAX","expires_in":7200}
     * @throws Exception
     * @author 徐国诚
     * @since JDK 1.6
     */
    public static JSONObject getAccessTokenJSON(String appId, String appSecret) throws Exception {
        JSONObject result = null;
        String response = getAccessTokenResponse(appId, appSecret);
        if (!StringUtil.isNullOrEmpty(response)) {
            result = JSONObject.parseObject(response);
        }
        return result;
    }

    /**
     * 获取access_token
     *
     * @param appId
     * @param appSecret
     * @return VOvlaJ07gQoIcP_eTNQyRjrlS8vpZ9HbA3i1TpsWSLlTwiP9wNBGG6cq83Kk6hWyiG56ZS10nsvwGBVu9sumraavDYu-HRNY7v2HN8kJrfeTeR-BCBx1TAzAOYKNqrPeAPMbAGALAX
     * @throws Exception
     * @author 徐国诚
     * @since JDK 1.6
     */
    public static String getAccessToken(String appId, String appSecret) throws Exception {
        String access_token = null;
        JSONObject response = getAccessTokenJSON(appId, appSecret);
        if (response != null && response.containsKey("access_token")) {
            access_token = response.getString("access_token");
        }
        return access_token;
    }

    /**
     * 获取微信服务器IP地址
     *
     * @param access_token
     * @return
     * @throws Exception
     * @author 徐国诚
     * @since JDK 1.6
     */
    public static String getCallBackIP(String access_token) throws Exception {
        String response = null;
        String url = GET_CALBACK_IP_URL + "?access_token=" + access_token;
        response = HttpUtil.get(url);
        return response;
    }

    /**
     * 获取微信服务器IP地址
     *
     * @param access_token
     * @return
     * @throws Exception
     * @author 徐国诚
     * @since JDK 1.6
     */
    public static JSONObject getCallBackIPJSON(String access_token) throws Exception {
        JSONObject retObj = null;
        String response = getCallBackIP(access_token);
        if (!StringUtil.isNullOrEmpty(response)) {
            retObj = JSONObject.parseObject(response);
        }
        return retObj;
    }


    /**
     * getUserInformation:(获取用户基本信息). <br/>
     *
     * @param access_token
     * @param openId
     * @param language
     * @return
     * @throws Exception
     * @author 宾勇
     * @since JDK 1.6
     */
    public static String getUserInformation(String access_token, String openId, String language) throws Exception {
        String response = null;
        String url = GET_USER_INFORMATION_URL + "?access_token=" + access_token + "&openid=" + openId + "&lang=" + language;
        response = HttpUtil.get(url);
        return response;
    }

    /**
     * getUserInformationJSON:(获取用户基本信息). <br/>
     *
     * @param access_token
     * @param openId
     * @param language
     * @return
     * @throws Exception
     * @author 宾勇
     * @since JDK 1.6
     */
    public static JSONObject getUserInformationJSON(String access_token, String openId, String language) throws Exception {
        JSONObject retObj = null;
        String response = getUserInformation(access_token, openId, language);
        if (!StringUtil.isNullOrEmpty(response)) {
            retObj = JSONObject.parseObject(response);
        }
        return retObj;
    }
}
