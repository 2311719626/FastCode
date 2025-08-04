package com.hezhaohui.model;

import lombok.Data;

@Data
public class MainTemplateConfig {

    /**
     * 作者
     */
    private String author;

    /**
     * 输出文本
     */
    private String outputText;

    /**
     * 是否循环
     */
    private boolean loop;
}
