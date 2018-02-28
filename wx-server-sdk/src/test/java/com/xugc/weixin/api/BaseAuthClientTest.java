package com.xugc.weixin.api;

import org.junit.Test;

public class BaseAuthClientTest {

    @Test
    public void testGetAccessToken() throws Exception {
        String appId = "wx78747eb8da6140eb";
        String serect = "dc9910bf1e919a11acd7bf0c82bd25f8";
        String response = BaseAuthClient.getAccessTokenResponse(appId, serect);
        System.out.println("response:" + response);
    }

    @Test
    public void testGetCallBackIp() {

        String accessToken = "7_NIHImJMFMDNcBkT6KjtomsM40z9Ejk4boHOa5X6JDQ2pfOI4Wxg1g4OYYuECJIf0w2i34dYOiAbezexfEpA1amtxIX0haj9vQ08jV4Iaf4SjdeVnCwR1HsRTlnhKVDsh_6SZDenSUD97KXU1XJHdAHAEQO";
        String response = BaseAuthClient.getCallBackIP(accessToken);
        System.out.println("response:" + response);
    }
}
