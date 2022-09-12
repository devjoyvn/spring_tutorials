package com.deft.requestbodyresponsebody;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ResponseTransfer {

    private String text;

    public ResponseTransfer() {
    }

    public ResponseTransfer(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
