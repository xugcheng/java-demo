package com.xugc.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("service的API接口")
@RestController
@RequestMapping("/service2")
public class ZipkinBraveController {


    @Autowired
    private OkHttpClient client;

    @ApiOperation("trace第一步")
    @RequestMapping("/test")
    public String service1() throws Exception {
        Thread.sleep(200);
        Request request3 = new Request.Builder().url("http://localhost:8003/service3/test").build();
        Response response3 = client.newCall(request3).execute();

        Request request4 = new Request.Builder().url("http://localhost:8004/service4/test").build();
        Response response4 = client.newCall(request4).execute();
        return response3.toString()+":"+response4.toString();
    }

}
