package org.bocim.controller;

/**
 * @ Author     ：ljc
 * @ Date       ：Created in 00:25 2023/3/21
 * @ Description：
 */
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import okhttp3.*;
import org.bocim.config.AppProperties;
import org.bocim.vo.ChatRequest;
import org.bocim.vo.ChatResponse;
import org.bocim.vo.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 *
 *
 *  {
 *     "messages": [
 *         {
 *             "role": "system",
 *             "content": "您是一个专家聊天。"
 *         },
 *         {
 *             "role": "user",
 *             "content": "给我一些 Java 编程技巧。"
 *         }
 *     ]
 * }
 */

@RestController
@CrossOrigin
@RequestMapping("/api/chatgpt")
public class ChatGptController {
//    private static final String API_URL = "https://api.openai.com/v1/engines/davinci-codex/chat/completions";
    private  static  final  String API_URL="https://api.openai.com/v1/chat/completions" ;
//    https://api.openai.com/v1/chat/completions
    private static final String API_KEY = "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";

    @Autowired
    private   AppProperties  appProperties   ;

    @PostMapping("/chat-mode")
    public ChatResponse chatWithGpt(@org.springframework.web.bind.annotation.RequestBody ChatRequest messages) throws IOException, JSONException {

        System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
//        System.setProperty("https.protocols", "TLSv1.2");
//        System.setProperty("jsse.enableSNIExtension", "false");
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(240, TimeUnit.SECONDS)
                .readTimeout(240, TimeUnit.SECONDS)    // 读取超时
                .writeTimeout(240, TimeUnit.SECONDS)   // 写入超时
                .build();

        ObjectMapper objectMapper = new ObjectMapper();
        JSONObject   jsonObject  =  new JSONObject(JsonUtils.toJson(messages));
//        JSONObject jsonObject = new JSONObject();
        jsonObject.put("model" , appProperties.getOpenaiMode()) ;
        System.out.println(jsonObject.toString());
       // jsonObject.put("max_tokens" , 4000) ;
     //   jsonObject.put("n" , 1) ;
      //  jsonObject.put("temperature" , 1) ;
/*
        String jsonData =
                String.format("""
                        {   
                            "model": gpt-3.5-turbo,
                            "messages": %s,
                            "max_tokens": 4000,
                               "n": 1,
                            "stop": null,
                            "temperature": 1
                                        }
                        """, messages.toString());*/

        //构建api请求
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jsonObject.toString());
        Request request = new Request.Builder()
                .url(appProperties.getApiWebsite())
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + appProperties.getOpenaiApiKey())
                .post(requestBody)
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                JsonNode responseJson = objectMapper.readTree(response.body().string());
                String generatedMessage = responseJson.get("choices").get(0).get("message").get("content").asText().trim();
                ChatResponse chatResponse = new ChatResponse();
                chatResponse.setResponse(generatedMessage);
                return  chatResponse ;
            } else {
                throw new IOException("请求OpenAI API时出现错误，错误代码：" + response.code());
            }
        }

    }
}