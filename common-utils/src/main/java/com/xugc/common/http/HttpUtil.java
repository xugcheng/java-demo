package com.xugc.common.http;

import okhttp3.*;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.FileNameMap;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * Http请求工具类
 * Created by xuguocheng on 2016/10/9.
 */
public class HttpUtil {

    private static OkHttpClient client = new OkHttpClient();

    private static Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    /**
     * http get请求
     *
     * @param url
     * @return
     */
    public static String get(String url) {
        try {
            Response response = getForResponse(url);
            return parseString(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Response getForResponse(String url) throws Exception {
        Request request = new Request.Builder()
                .url(url)
                .build();
        return client.newCall(request).execute();
    }

    public static String get(String url, Map<String, String> headerParams) {
        try {
            Response response = getForResponse(url, headerParams);
            return parseString(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Response getForResponse(String url, Map<String, String> headerParams) throws Exception {
        Headers headers = buildHeaders(headerParams);
        Request request = new Request.Builder()
                .url(url)
                .headers(headers)
                .build();
        return client.newCall(request).execute();
    }


    /**
     * http post请求
     *
     * @param url
     * @param headerParams
     * @param bodyParams
     * @return
     */
    public static String post(String url, Map<String, String> headerParams, Map<String, String> bodyParams) {

        try {
            Response response = postForResponse(url, headerParams, bodyParams);
            return parseString(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public static Response postForResponse(String url, Map<String, String> headerParams, Map<String, String> bodyParams) throws Exception {

        Headers headers = buildHeaders(headerParams);
        RequestBody requestBody = buildRequestBody(bodyParams, null);

        Request request = new Request.Builder()
                .url(url)
                .headers(headers)
                .post(requestBody)
                .build();
        return client.newCall(request).execute();
    }

    /**
     * http post 发送字符串body
     *
     * @param url
     * @param headerParams
     * @param body
     * @return
     */
    public static String post(String url, Map<String, String> headerParams, String body) {

        try {
            Response response = postForResponse(url, headerParams, body);
            return parseString(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Response postForResponse(String url, Map<String, String> headerParams, String body) throws Exception {
        Headers headers = buildHeaders(headerParams);
        RequestBody requestBody = buildRequestBody(body);
        Request request = new Request.Builder()
                .url(url)
                .headers(headers)
                .post(requestBody)
                .build();
        return client.newCall(request).execute();
    }


    /**
     * Http delete请求
     *
     * @param url
     * @param headerParams
     * @return
     */
    public static String delete(String url, Map<String, String> headerParams) {
        try {
            Response response = deleteForResponse(url, headerParams);
            return parseString(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Response deleteForResponse(String url, Map<String, String> headerParams) throws Exception {

        Headers headers = buildHeaders(headerParams);
        Request request = new Request.Builder()
                .url(url)
                .headers(headers)
                .delete()
                .build();
        return client.newCall(request).execute();
    }


    /**
     * 文件下载
     *
     * @param url
     * @param savedir 指定下载目录
     * @return
     */
    public static File download(String url, String savedir) {
        try {
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            Response response = client.newCall(request).execute();
            logger.debug("response:" + response.toString());
            return parseFile(response, savedir);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    /**
     * 下载文件
     *
     * @param url
     * @return
     */
    public static File download(String url) {
        String savedir = System.getProperty("java.io.tmpdir");
        return download(url, savedir);
    }

    /**
     * 文件上传
     *
     * @param url
     * @param bodyParams
     * @param fileParams
     * @return
     */
    public static String upload(String url, Map<String, String> bodyParams, Map<String, File> fileParams) {
        try {
            RequestBody requestBody = buildRequestBody(bodyParams, fileParams);
            Request request = new Request.Builder()
                    .url(url)
                    .post(requestBody)
                    .build();

            Response response = client.newCall(request).execute();
            return parseString(response);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 构建RequestBody
     *
     * @param bodyParams
     * @param fileParams
     * @return
     */
    private static RequestBody buildRequestBody(Map<String, String> bodyParams, Map<String, File> fileParams) {
        MultipartBody.Builder bodyBuilder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        if (bodyParams != null && bodyParams.size() > 0) {
            Set<String> keys = bodyParams.keySet();
            for (String key : keys) {
                bodyBuilder.addFormDataPart(key, bodyParams.get(key));
            }
        }

        if (fileParams != null && fileParams.size() > 0) {
            Set<String> keys = fileParams.keySet();
            for (String key : keys) {
                File file = fileParams.get(key);
                if (file != null && file.exists()) {
                    RequestBody fileBody = RequestBody.create(null, file);
                    bodyBuilder.addFormDataPart(key, file.getName(), fileBody);
                }
            }
        }
        return bodyBuilder.build();
    }

    /**
     * 构造RequestBody
     *
     * @param body
     * @return
     */
    private static RequestBody buildRequestBody(String body) {
        return RequestBody.create(null, body);
    }

    /**
     * 构建header参数
     *
     * @param headerParams
     */
    private static Headers buildHeaders(Map<String, String> headerParams) {
        Headers.Builder headersBuilder = new Headers.Builder();
        //add header
        if (headerParams != null && headerParams.size() > 0) {
            Set<String> keys = headerParams.keySet();
            for (String key : keys) {
                headersBuilder.add(key, headerParams.get(key));
            }
        }
        return headersBuilder.build();
    }

    /**
     * 从响应中解析文本内容
     *
     * @param response
     * @return
     * @throws Exception
     */
    private static String parseString(Response response) throws Exception {
        return response != null ? response.body().string() : null;
    }

    /**
     * 从响应中解析文件
     *
     * @param response
     * @param savedir
     * @return
     * @throws Exception
     */
    private static File parseFile(Response response, String savedir) throws Exception {
        File file = null;
        if (response.isSuccessful()) {

            //从响应中获取文件名称(Content-disposition: attachment; filename="MEDIA_ID.jpg")
            String contentDispostion = response.header("Content-disposition");
            if (contentDispostion != null && contentDispostion.length() > 0) {

                String filenameFlag = "filename=\"";
                int filenameIndex = contentDispostion.indexOf(filenameFlag);
                String filename = (contentDispostion != null && filenameIndex != -1) ?
                        contentDispostion.substring(filenameIndex + 10, contentDispostion.length() - 1) : UUID.randomUUID().toString();
                String filepath = savedir.endsWith(File.separator) ? savedir + filename : savedir + File.separator + filename;

                file = new File(filepath);
                try {
                    BufferedSource source = response.body().source();
                    BufferedSink sink = Okio.buffer(Okio.sink(file));
                    sink.writeAll(source);
                    sink.flush();
                    sink.close();
                    source.close();
                } catch (Exception e) {
                    throw e;
                }
            } else {
                throw new Exception("Http下载文件失败!" + response.body().string());
            }
        } else {
            throw new Exception("Http下载文件失败!" + response.body().string());
        }
        return file;
    }

    private static String getContentType(File file) {
        FileNameMap fileNameMap = URLConnection.getFileNameMap();
        return fileNameMap.getContentTypeFor(file.getName());
    }

    /**
     * 解析queryString
     *
     * @param query
     * @return
     */
    public static Map<String, String> getQueryParams(String query) {
        try {
            Map<String, String> params = new HashMap<String, String>();

            if (query != null && query.length() > 0) {
                for (String param : query.split("&")) {
                    String[] pair = param.split("=");
                    String key = URLDecoder.decode(pair[0], "UTF-8");
                    String value = "";
                    if (pair.length > 1) {
                        value = URLDecoder.decode(pair[1], "UTF-8");
                    }
                    params.put(key, value);
                }
            }
            return params;
        } catch (UnsupportedEncodingException ex) {
            throw new AssertionError(ex);
        }
    }
}
