package org.bocim.vo;

import java.util.List;

/**
 * @ Author     ：ljc
 * @ Date       ：Created in 15:51 2023/3/22
 * @ Description：
 */

public class ChatRequest {
    private List<Message> messages;


    private String   chatMode ;



    private   String  apikey   ;

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public String getChatMode() {
        return chatMode;
    }

    public void setChatMode(String chatMode) {
        this.chatMode = chatMode;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
