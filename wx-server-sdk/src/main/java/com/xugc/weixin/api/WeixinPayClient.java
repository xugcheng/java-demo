package com.xugc.weixin.api;

import com.xugc.common.http.HttpUtil;
import com.xugc.weixin.util.WxMessageParseUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: WeixinPayClient.java
 * Description: 微信支付
 *
 * @author 徐国诚
 * @created 2016-3-28 下午3:37:16
 */
public class WeixinPayClient {

    public static final String COMPANY_PAY_URL = "https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers";

    public static final String SCAN_CODE_PAY_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";

    public static String companyPay(String certPath, String signKey, String certPwd, Map<String, String> params) throws Exception {
        params.put("sign", WxMessageParseUtil.generateSign(signKey, params));
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Connection", "keep-alive");
        headers.put("Accept", "*/*");
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        headers.put("Host", "api.mch.weixin.qq.com");
        headers.put("X-Requested-With", "XMLHttpRequest");
        headers.put("Cache-Control", "max-age=0");
        headers.put("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0) ");
        return HttpUtil.post(COMPANY_PAY_URL, headers, WxMessageParseUtil.parseXml(params));
    }

    public static String scanCodePay(String signKey, Map<String, String> params) throws Exception {
        params.put("sign", WxMessageParseUtil.generateSign(signKey, params));
        return HttpUtil.post(SCAN_CODE_PAY_URL, null, WxMessageParseUtil.parseXml(params));
    }
}
