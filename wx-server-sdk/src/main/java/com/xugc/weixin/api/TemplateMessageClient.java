/**
 *
 */
package com.xugc.weixin.api;

import com.alibaba.fastjson.JSONObject;
import com.xugc.common.http.HttpUtil;

/**
 * 微信模板消息接口调用类
 */
public class TemplateMessageClient {
    public static final String SET_INDUSTRY_URL = "https://api.weixin.qq.com/cgi-bin/template/api_set_industry";
    public static final String GET_INDUSTRY_URL = "https://api.weixin.qq.com/cgi-bin/template/get_industry";
    public static final String GET_TEMPLATE_ID_URL = "https://api.weixin.qq.com/cgi-bin/template/api_add_template";
    public static final String GET_ALL_TEMPLATE_URL = "https://api.weixin.qq.com/cgi-bin/template/get_all_private_template";
    public static final String DELETE_TEMPLATE_URL = "https://api,weixin.qq.com/cgi-bin/template/del_private_template";
    public static final String TEMPLATE_MESSAGE_SEND_URL = "https://api.weixin.qq.com/cgi-bin/message/template/send";

    /**
     * 设置所属行业
     *
     * @param access_token
     * @param industry_id1
     * @param industry_id2
     * @return
     * @throws Exception
     */
    public static JSONObject setIndustry(String access_token, String industry_id1, String industry_id2) throws Exception {
        //https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=ACCESS_TOKEN
        String url = SET_INDUSTRY_URL + "?access_token=" + access_token;
        JSONObject data = new JSONObject();
        data.put("industry_id1", industry_id1);
        data.put("industry_id2", industry_id2);
        String response = HttpUtil.post(url, null, data.toString());
        return JSONObject.parseObject(response);
    }

    /**
     * 获取设置的行业信息
     *
     * @param access_token
     * @return
     * @throws Exception
     */
    public static JSONObject getIndustry(String access_token) throws Exception {
        //https://api.weixin.qq.com/cgi-bin/template/get_industry?access_token=ACCESS_TOKEN
        String url = GET_INDUSTRY_URL + "?access_token=" + access_token;
        String response = HttpUtil.get(url);
        return JSONObject.parseObject(response);
    }

    /**
     * 获取模板ID
     *
     * @param access_token
     * @param template_id_short 模板库中模板的编号，有“TM**”和“OPENTMTM**”等形式
     * @return
     * @throws Exception
     */
    public static JSONObject getTemplateId(String access_token, String template_id_short) throws Exception {
        //https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=ACCESS_TOKEN
        String url = GET_TEMPLATE_ID_URL + "?access_token=" + access_token;
        JSONObject data = new JSONObject();
        data.put("template_id_short", template_id_short);
        String response = HttpUtil.post(url, null, data.toString());
        return JSONObject.parseObject(response);
    }

    /**
     * 获取模板列表
     *
     * @param access_token
     * @return
     * @throws Exception
     */
    public static JSONObject getAllTemplate(String access_token) throws Exception {
        //https://api.weixin.qq.com/cgi-bin/template/get_all_private_template?access_token=ACCESS_TOKEN
        String url = GET_ALL_TEMPLATE_URL + "?access_token=" + access_token;
        String response = HttpUtil.get(url);
        return JSONObject.parseObject(response);
    }

    /**
     * 删除模板
     *
     * @param access_token
     * @param template_id
     * @return
     * @throws Exception
     */
    public static JSONObject deleteTemplate(String access_token, String template_id) throws Exception {
        //https://api,weixin.qq.com/cgi-bin/template/del_private_template?access_token=ACCESS_TOKEN
        String url = DELETE_TEMPLATE_URL + "?access_token=" + access_token;
        JSONObject data = new JSONObject();
        data.put("template_id", template_id);
        String response = HttpUtil.post(url, null, data.toString());
        return JSONObject.parseObject(response);
    }

    /**
     * 发送模板消息
     *
     * @param access_token
     * @param openid
     * @param template_id
     * @param url
     * @param data
     * @return
     * @throws Exception
     */
    public static JSONObject sendTemplateMessage(String access_token, String openid, String template_id, String url, JSONObject data) throws Exception {
        //https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN
        String msgUrl = TEMPLATE_MESSAGE_SEND_URL + "?access_token=" + access_token;
        JSONObject msgJSON = new JSONObject();
        msgJSON.put("touser", openid);
        msgJSON.put("template_id", template_id);
        msgJSON.put("url", url);
        msgJSON.put("data", data);

        String response = HttpUtil.post(msgUrl, null, msgJSON.toString());

        return JSONObject.parseObject(response);
    }

}
