/**
 *
 */
package com.xugc.weixin.api;

import java.net.URLEncoder;

import com.alibaba.fastjson.JSONObject;
import com.xugc.common.http.HttpUtil;

/**
 * 微信生成带参数二维码接口调用类
 */
public class QrCodeClient {

    public static final String QRCODE_CREATE_URL = "https://api.weixin.qq.com/cgi-bin/qrcode/create";
    public static final String QRCODE_SHOW_URL = "https://mp.weixin.qq.com/cgi-bin/showqrcode";

    /**
     * 临时二维码的默认有效时间1小时=3600秒.
     */
    public static final Integer DEFAULT_EXPIRE_SECONDS = 60 * 60;

    /**
     * 生成临时带参数二维码
     *
     * @param access_token
     * @param sceneId
     * @return {"ticket":"gQH47joAAAAAAAAAASxodHRwOi8vd2VpeGluLnFxLmNvbS9xL2taZ2Z3TVRtNzJXV1Brb3ZhYmJJAAIEZ23sUwMEmm3sUw==","expire_seconds":60,"url":"http:\/\/weixin.qq.com\/q\/kZgfwMTm72WWPkovabbI"}
     * @throws Exception
     */
    public static JSONObject createQrCodeSence(String access_token, Integer sceneId) throws Exception {
        String url = QRCODE_CREATE_URL + "?access_token=" + access_token;
        //{"expire_seconds": 604800, "action_name": "QR_SCENE", "action_info": {"scene": {"scene_id": 123}}}

        JSONObject scene = new JSONObject();
        scene.put("scene_id", sceneId);
        JSONObject action_info = new JSONObject();
        action_info.put("scene", scene);

        JSONObject content = new JSONObject();
        content.put("expire_seconds", DEFAULT_EXPIRE_SECONDS);
        content.put("action_name", "QR_SCENE");
        content.put("action_info", action_info);

        String result = HttpUtil.post(url, null, content.toString());

        return JSONObject.parseObject(result);
    }

    /**
     * 生成永久带参数二维码
     *
     * @param access_token
     * @param sceneId
     * @return
     * @throws Exception
     */
    public static JSONObject createQrCodeSenceLimit(String access_token, Integer sceneId) throws Exception {
        String url = QRCODE_CREATE_URL + "?access_token=" + access_token;
        //{"action_name": "QR_LIMIT_SCENE", "action_info": {"scene": {"scene_id": 123}}}

        JSONObject scene = new JSONObject();
        scene.put("scene_id", sceneId);
        JSONObject action_info = new JSONObject();
        action_info.put("scene", scene);

        JSONObject content = new JSONObject();
        content.put("action_name", "QR_LIMIT_SCENE");
        content.put("action_info", action_info);

        String result = HttpUtil.post(url, null, content.toString());

        return JSONObject.parseObject(result);
    }

    /**
     * 生成永久带参数二维码
     *
     * @param access_token
     * @param scene_str
     * @return
     * @throws Exception
     */
    public static JSONObject createQrCodeSenceLimit(String access_token, String scene_str) throws Exception {
        String url = QRCODE_CREATE_URL + "?access_token=" + access_token;
        //{"action_name": "QR_LIMIT_STR_SCENE", "action_info": {"scene": {"scene_str": "123"}}}

        JSONObject scene = new JSONObject();
        scene.put("scene_str", scene_str);
        JSONObject action_info = new JSONObject();
        action_info.put("scene", scene);

        JSONObject content = new JSONObject();
        content.put("action_name", "QR_LIMIT_STR_SCENE");
        content.put("action_info", action_info);

        String result = HttpUtil.post(url, null, content.toString());

        return JSONObject.parseObject(result);
    }

    /**
     * 通过ticket换取二维码url地址
     *
     * @param ticket
     * @return
     * @throws Exception
     */
    public static String showQrCodeUrl(String ticket) throws Exception {
        //https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=TICKET
        //提醒：TICKET记得进行UrlEncode
        String url = QRCODE_SHOW_URL + "?ticket=" + URLEncoder.encode(ticket, "utf-8");
        return url;
    }
}
