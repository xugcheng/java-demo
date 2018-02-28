/**
 *
 */
package com.xugc.weixin.api;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xugc.common.http.HttpUtil;

/**
 * 微信用户管理接口调用类
 */
public class UserInfoClient {

    public static final String GET_USER_INFO_URL = "https://api.weixin.qq.com/cgi-bin/user/info";
    public static final String GET_USER_INFO_BATCH_URL = "https://api.weixin.qq.com/cgi-bin/user/info/batchget";

    /**
     * 获取用户基本信息
     *
     * @param access_token
     * @param openId
     * @return {
     * "subscribe": 1,
     * "openid": "o6_bmjrPTlm6_2sgVt7hMZOPfL2M",
     * "nickname": "Band",
     * "sex": 1,
     * "language": "zh_CN",
     * "city": "广州",
     * "province": "广东",
     * "country": "中国",
     * "headimgurl":    "http://wx.qlogo.cn/mmopen/g3MonUZtNHkdmzicIlibx6iaFqAc56vxLSUfpb6n5WKSYVY0ChQKkiaJSgQ1dZuTOgvLLrhJbERQQ4eMsv84eavHiaiceqxibJxCfHe/0",
     * "subscribe_time": 1382694957,
     * "unionid": " o6_bmasdasdsad6_2sgVt7hMZOPfL"
     * "remark": "",
     * "groupid": 0
     * }
     * @throws Exception
     */
    public static JSONObject getUserInfo(String access_token, String openId, String language) throws Exception {
        //https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN
        String url = GET_USER_INFO_URL + "?access_token=" + access_token + "&openid=" + openId + "&lang=" + language;
        String result = HttpUtil.get(url);
        return JSONObject.parseObject(result);
    }

    /**
     * 批量获取用户基本信息,最多支持一次拉取100条。
     *
     * @param access_token
     * @param openIds
     * @return {
     * "user_info_list": [
     * {
     * "subscribe": 1,
     * "openid": "otvxTs4dckWG7imySrJd6jSi0CWE",
     * "nickname": "iWithery",
     * "sex": 1,
     * "language": "zh_CN",
     * "city": "Jieyang",
     * "province": "Guangdong",
     * "country": "China",
     * "headimgurl": "http://wx.qlogo.cn/mmopen/xbIQx1GRqdvyqkMMhEaGOX802l1CyqMJNgUzKP8MeAeHFicRDSnZH7FY4XB7p8XHXIf6uJA2SCunTPicGKezDC4saKISzRj3nz/0",
     * "subscribe_time": 1434093047,
     * "unionid": "oR5GjjgEhCMJFyzaVZdrxZ2zRRF4",
     * "remark": "",
     * "groupid": 0
     * },
     * {
     * "subscribe": 0,
     * "openid": "otvxTs_JZ6SEiP0imdhpi50fuSZg",
     * "unionid": "oR5GjjjrbqBZbrnPwwmSxFukE41U",
     * }
     * ]
     * }
     * @throws Exception
     */
    public static JSONObject getUserInfoList(String access_token, List<String> openIds, String language) throws Exception {
        String url = GET_USER_INFO_BATCH_URL + "?access_token=" + access_token;

        JSONArray userArray = new JSONArray();
        for (String openId : openIds) {
            JSONObject userObject = new JSONObject();
            userObject.put("openid", openId);
            userObject.put("lang", language);
            userArray.add(userObject);
        }

        JSONObject contentJSON = new JSONObject();
        contentJSON.put("user_list", userArray);

        String result = HttpUtil.post(url, null, contentJSON.toString());
        return JSONObject.parseObject(result);
    }

}
