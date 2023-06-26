package com.piersoft.purchase.util;

import okhttp3.*;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.Charset;

@Component
public class ApiClientUtil {

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(ApiClientUtil.class);


    public String makePostCall(String url , RequestBody requestBody){
        OkHttpClient client = new OkHttpClient.Builder().build();


        Request request = new Request.Builder()
                .addHeader("Content-Type","application/json")
                //.addHeader("Authorization",token)
                .url(url)
                .post(requestBody)
                .build();

        Call call = client.newCall(request);


        try {
            Long start = System.currentTimeMillis();
            Response response = call.execute();
            Long end = System.currentTimeMillis();
            logger.debug("Time taken to get gst call execution details:"+(end-start));
            ResponseBody responseBody = response.body();
            return  new String(responseBody.bytes(), Charset.forName("ISO-8859-1"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
