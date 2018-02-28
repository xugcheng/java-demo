/**
 * 文件：CustomMessageClient.java
 * 系统：WECARE-WEIXIN-WEB
 * 版权：Copyright (c) 2016, All Rights Reserved.
 * 包名：com.wecare.weixin.sdk
 * 日期：2016-1-29下午3:21:42
 * 描述：
 */
package com.xugc.weixin.api;

import com.alibaba.fastjson.JSONObject;
import com.xugc.common.http.HttpUtil;
import com.xugc.common.http.StringUtil;


/**
 * 描述：客服消息接口调用 <br/>
 * 类名：CustomMessageClient <br/>
 * 日期：2016-1-29 下午3:21:42 <br/>
 *
 * @author 徐国诚
 * @since JDK 1.6
 */
public class CustomMessageClient {

    public static final String CUSTOME_SEND_URL = "https://api.weixin.qq.com/cgi-bin/message/custom/send";

    /**
     * 发送客服消息
     *
     * @param access_token
     * @param content
     * @return
     * @throws Exception
     * @author 徐国诚
     * @since JDK 1.6
     */
    public static String sendMessage(String access_token, String content) throws Exception {
        String response = null;
        String url = CUSTOME_SEND_URL + "?access_token=" + access_token;
        response = HttpUtil.post(url, null, content);
        return response;
    }

    /**
     * 发送客服消息
     *
     * @param access_token
     * @param content
     * @return
     * @throws Exception
     * @author 徐国诚
     * @since JDK 1.6
     */
    public static JSONObject sendMessageJSON(String access_token, String content) throws Exception {
        JSONObject retObj = null;
        String response = sendMessage(access_token, content);
        if (!StringUtil.isNullOrEmpty(response)) {
            retObj = JSONObject.parseObject(response);
        }
        return retObj;
    }

    /**
     * 获取客服消息-文本消息报文
     *
     * @param openId
     * @param content
     * @return
     * @author 徐国诚
     * @since JDK 1.6
     */
    public static String getTextMessage(String openId, String content) {

        JSONObject text = new JSONObject();
        text.put("content", content);
        JSONObject retObj = new JSONObject();
        retObj.put("touser", openId);
        retObj.put("msgtype", "text");
        retObj.put("text", text);
        return retObj.toString();
    }

    /**
     * 获取客服消息-图片消息报文
     *
     * @param openId
     * @param mediaId
     * @author 徐国诚
     * @since JDK 1.6
     */
    public static String getImageMessage(String openId, String mediaId) {
        JSONObject image = new JSONObject();
        image.put("media_id", mediaId);
        JSONObject retObj = new JSONObject();
        retObj.put("touser", openId);
        retObj.put("msgtype", "image");
        retObj.put("image", image);
        return retObj.toString();
    }

    /**
     * 获取客服消息-语音消息报文
     *
     * @param openId
     * @param mediaId
     * @author 徐国诚
     * @since JDK 1.6
     */
    public static String getVoiceMessage(String openId, String mediaId) {
        JSONObject voice = new JSONObject();
        voice.put("media_id", mediaId);
        JSONObject retObj = new JSONObject();
        retObj.put("touser", openId);
        retObj.put("msgtype", "voice");
        retObj.put("voice", voice);
        return retObj.toString();
    }

    /**
     * 获取客服消息-视频消息报文
     *
     * @param openId
     * @param mediaId
     * @param title
     * @param description
     * @author 徐国诚
     * @since JDK 1.6
     */
    public static String getVideoMessage(String openId, String mediaId, String title, String description) {
        JSONObject video = new JSONObject();
        video.put("media_id", mediaId);
        video.put("title", title);
        video.put("description", description);

        JSONObject retObj = new JSONObject();
        retObj.put("touser", openId);
        retObj.put("msgtype", "video");
        retObj.put("video", video);

        return retObj.toString();
    }

}
