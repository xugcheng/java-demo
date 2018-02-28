/**
 * 文件：WxMessageParseUtil.java
 * 系统：WECARE-WEIXIN-WEB
 * 版权：Copyright (c) 2016, All Rights Reserved.
 * 包名：com.wecare.weixin.util
 * 日期：2016-1-28上午9:19:02
 * 描述：
 */
package com.xugc.weixin.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.xugc.common.http.StringUtil;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Text;


/**
 * 描述：微信消息解析工具类<br/>
 * 类名：WxMessageParseUtil <br/>
 * 日期：2016-1-28 上午9:19:02 <br/>
 *
 * @author 徐国诚
 * @since JDK 1.6
 */
public class WxMessageParseUtil {

    /**
     * 解析微信消息为Map
     *
     * @param message
     * @return
     * @author 徐国诚
     * @since JDK 1.6
     */
    public static Map<String, String> parseMessage(String message) {
        Map<String, String> resultMap = new HashMap<String, String>();

        try {
            Document messageDoc = DocumentHelper.parseText(message);
            Element root = messageDoc.getRootElement();
            List<?> elements = root.elements();
            for (Object object : elements) {
                Element element = (Element) object;
                resultMap.put(element.getName(), element.getText());
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return resultMap;
    }

    /**
     * 把map数据转换成xml
     *
     * @param params
     * @return
     * @throws DocumentException
     * @author 徐国诚
     * @since JDK 1.6
     */
    public static String parseXml(Map<String, String> params) throws DocumentException {
        Element e = DocumentHelper.createElement("xml");
        Element e1 = null;
        for (String key : params.keySet()) {
            e1 = DocumentHelper.createElement(key);
            e1.setText(params.get(key));
            e.add(e1);
        }
        return e.asXML();
    }

    /**
     * @param key
     * @param map
     * @return
     * @throws Exception
     * @discription 微信签名
     * @author 宾勇
     * @created 2016-3-29 上午10:26:07
     */
    public static String generateSign(String key, Map<String, String> map) throws Exception {
        //按map排序
        Map<String, String> sortMap = new TreeMap<String, String>();
        sortMap.putAll(map);
        StringBuffer sb = new StringBuffer();
        for (String str : sortMap.keySet()) {
            if (!StringUtil.isNullOrEmpty(sortMap.get(str))) {
                if (sb.length() > 0) {
                    sb.append("&");
                }
                sb.append(str).append("=").append(sortMap.get(str));
            }
        }
        sb.append("&key=").append(key);
        return EncryptUtil.md5Digest(sb.toString().trim()).toUpperCase();
    }


    public static void main(String[] args) throws Exception {

        System.out.println(EncryptUtil.md5Digest("amount=500.0&check_name=OPTION_CHECK&desc=维修师傅提现&mch_appid=wx756a2366f36b2457&mchid=1227431002&nonce_str=32c587030cf94dcd8df36eaaf7287687&openid=oXRwvs2tojqB__RWFOhixf9DvbTo&partner_trade_no=oXRwvs2tojqB__RWFOhixf9DvbTo_1459319402232&re_user_name=修理大师二代&spbill_create_ip=192.168.1.124&key=dd42c39fe0684b8f89cbf29047388b25").toUpperCase());

    }

}
