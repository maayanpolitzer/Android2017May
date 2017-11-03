package com.example.hackeru.whatsapp.infrastructure;

/**
 * Created by hackeru on 10/30/2017.
 */

public class Message {

    private String content;
    private boolean incoming;

    public Message(String content, boolean incoming) {
        this.content = content;
        this.incoming = incoming;
    }

    @Override
    public String toString() {
        return "Message{" +
                "content='" + content + '\'' +
                ", incoming=" + incoming +
                '}';
    }

    public String getContent() {
        return content;
    }

    public boolean isIncoming() {
        return incoming;
    }
}
