package demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Api("service的API接口")
@RestController
@RequestMapping("/service4")
public class ZipkinBraveController {


    @Autowired
    private OkHttpClient client;

    @ApiOperation("trace第一步")
    @RequestMapping("/test")
    public String service1(HttpServletRequest httpServletRequest) throws Exception {
        Thread.sleep(200);
        return "server4";
    }

}
