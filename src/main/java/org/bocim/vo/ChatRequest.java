package org.bocim.vo;

import java.util.List;

/**
 * @ Author     ：ljc
 * @ Date       ：Created in 15:51 2023/3/22
 * @ Description：
 */

public class ChatRequest {
    private List<Message> messages;

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
