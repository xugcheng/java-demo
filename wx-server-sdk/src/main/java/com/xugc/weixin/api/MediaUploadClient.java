/**
 * 文件：MediaUpload.java
 * 系统：WECARE-WEIXIN-WEB
 * 版权：Copyright (c) 2016, All Rights Reserved.
 * 包名：com.wecare.weixin.sdk
 * 日期：2016-1-29下午2:43:59
 * 描述：
 */
package com.xugc.weixin.api;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.alibaba.fastjson.JSONObject;
import com.xugc.common.http.HttpUtil;
import com.xugc.common.http.StringUtil;


/**
 * 描述：多媒体文件上传接口调用<br/>
 * 类名：MediaUpload <br/>
 * 日期：2016-1-29 下午2:43:59 <br/>
 *
 * @author 徐国诚
 * @since JDK 1.6
 */
public class MediaUploadClient {

    public static final String[] VOICE_SUFFIX = new String[]{".amr", ".mp3"};
    public static final String[] VIDEO_SUFFIX = new String[]{".mp4"};
    public static final String[] IMAGE_SUFFIX = new String[]{".jpg", ".png", ".jpeg", ".bmp", ".gif"};
    public static final String[] THUMB_SUFFIX = new String[]{".jpg"};

    /**
     * 多媒体文件上传url
     */
    public static final String MEDIA_UPLOAD_URL = "https://api.weixin.qq.com/cgi-bin/media/upload";

    /**
     * 多媒体文件下载url
     */
    public static final String MEDIA_DOWNLOAD_URL = "https://api.weixin.qq.com/cgi-bin/media/get";

    /**
     * 上传语音
     *
     * @param access_token
     * @param filepath
     * @return
     * @throws Exception
     * @author 徐国诚
     * @since JDK 1.6
     */
    public static String uploadVoice(String access_token, String filepath) throws Exception {
        String response = null;
        String filename = null;
        if (!isFileTypeSupported(filepath, VOICE_SUFFIX)) {
            filename = UUID.randomUUID().toString() + VOICE_SUFFIX[0];
        }
        String url = MEDIA_UPLOAD_URL + "?access_token=" + access_token + "&type=voice";
        Map<String, File> fileMap = new HashMap<String, File>();
        fileMap.put(filename, new File(filepath));
        response = HttpUtil.upload(url, null, fileMap);
        return response;
    }

    /**
     * 上传语音
     *
     * @param access_token
     * @param filepath
     * @return
     * @throws Exception
     * @author 徐国诚
     * @since JDK 1.6
     */
    public static JSONObject uploadVoiceJSON(String access_token, String filepath) throws Exception {
        JSONObject retObj = null;
        String response = uploadVoice(access_token, filepath);
        if (!StringUtil.isNullOrEmpty(response)) {
            retObj = JSONObject.parseObject(response);
        }
        return retObj;
    }

    /**
     * 上传视频
     *
     * @param access_token
     * @param filepath
     * @return
     * @throws Exception
     * @author 徐国诚
     * @since JDK 1.6
     */
    public static String uploadVideo(String access_token, String filepath) throws Exception {
        String response = null;
        String filename = null;
        if (!isFileTypeSupported(filepath, VIDEO_SUFFIX)) {
            filename = UUID.randomUUID().toString() + VIDEO_SUFFIX[0];
        }
        String url = MEDIA_UPLOAD_URL + "?access_token=" + access_token + "&type=video";
        Map<String, File> fileMap = new HashMap<String, File>();
        fileMap.put(filename, new File(filepath));
        response = HttpUtil.upload(url, null, fileMap);
        return response;
    }

    /**
     * 上传视频
     *
     * @param access_token
     * @param filepath
     * @return
     * @throws Exception
     * @author 徐国诚
     * @since JDK 1.6
     */
    public static JSONObject uploadVideoJSON(String access_token, String filepath) throws Exception {
        JSONObject retObj = null;
        String response = uploadVideo(access_token, filepath);
        if (!StringUtil.isNullOrEmpty(response)) {
            retObj = JSONObject.parseObject(response);
        }
        return retObj;
    }

    /**
     * 上传图片
     *
     * @param access_token
     * @param filepath
     * @return
     * @throws Exception
     * @author 徐国诚
     * @since JDK 1.6
     */
    public static String uploadImage(String access_token, String filepath) throws Exception {
        String response = null;
        String filename = null;
        if (!isFileTypeSupported(filepath, IMAGE_SUFFIX)) {
            filename = UUID.randomUUID().toString() + IMAGE_SUFFIX[0];
        }
        String url = MEDIA_UPLOAD_URL + "?access_token=" + access_token + "&type=image";
        Map<String, File> fileMap = new HashMap<String, File>();
        fileMap.put(filename, new File(filepath));
        response = HttpUtil.upload(url, null, fileMap);
        return response;
    }

    /**
     * 上传图片
     *
     * @param access_token
     * @param filepath
     * @return
     * @throws Exception
     * @author 徐国诚
     * @since JDK 1.6
     */
    public static JSONObject uploadImageJSON(String access_token, String filepath) throws Exception {
        JSONObject retObj = null;
        String response = uploadImage(access_token, filepath);
        if (!StringUtil.isNullOrEmpty(response)) {
            retObj = JSONObject.parseObject(response);
        }
        return retObj;
    }

    /**
     * 上传缩略图
     *
     * @param access_token
     * @param filepath
     * @return
     * @throws Exception
     * @author 徐国诚
     * @since JDK 1.6
     */
    public static String uploadThumb(String access_token, String filepath) throws Exception {
        String response = null;
        String filename = null;
        if (!isFileTypeSupported(filepath, THUMB_SUFFIX)) {
            filename = UUID.randomUUID().toString() + THUMB_SUFFIX[0];
        }
        String url = MEDIA_UPLOAD_URL + "?access_token=" + access_token + "&type=thumb";
        Map<String, File> fileMap = new HashMap<String, File>();
        fileMap.put(filename, new File(filepath));
        response = HttpUtil.upload(url, null, fileMap);
        return response;
    }

    /**
     * 上传缩略图
     *
     * @param access_token
     * @param filepath
     * @return
     * @throws Exception
     * @author 徐国诚
     * @since JDK 1.6
     */
    public static JSONObject uploadThumbJSON(String access_token, String filepath) throws Exception {
        JSONObject retObj = null;
        String response = uploadThumb(access_token, filepath);
        if (!StringUtil.isNullOrEmpty(response)) {
            retObj = JSONObject.parseObject(response);
        }
        return retObj;
    }

    /**
     * 判断微信服务器是否支持上传改文件格式.
     *
     * @param filepath
     * @return
     */
    public static boolean isFileTypeSupported(String filepath, String[] suffixs) {
        boolean result = false;
        for (String suffix : suffixs) {
            if (filepath.toLowerCase().endsWith(suffix.toLowerCase())) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * 从微信服务器下载文件
     *
     * @param access_token
     * @param mediaId
     * @param savepath
     * @return
     */
    public static File downloadMedia(String access_token, String mediaId, String savepath) throws Exception {
        File file = null;
        String url = MEDIA_DOWNLOAD_URL + "?access_token=" + access_token + "&media_id=" + mediaId;
        file = HttpUtil.download(url, savepath);
        return file;
    }
}
