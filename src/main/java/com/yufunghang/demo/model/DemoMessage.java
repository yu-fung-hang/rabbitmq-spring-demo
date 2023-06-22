package com.yufunghang.demo.model;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class DemoMessage implements Serializable {
    @Serial
    private static final long serialVersionUID = -8440485001492273437L;

    String content;

    public DemoMessage(String content) {
        this.content = content;
    }
}
