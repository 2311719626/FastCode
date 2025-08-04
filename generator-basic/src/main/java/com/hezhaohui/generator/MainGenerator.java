package com.hezhaohui.generator;

import com.hezhaohui.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

public class MainGenerator {

    public static void main(String[] args) throws TemplateException, IOException {
        // 1. 静态文件生成
        String projectPath = System.getProperty("user.dir");
        String srcPath = projectPath + File.separator + "demo-projects" + File.separator + "acm-template";
        String destPath = projectPath;
        StaticGenerator.copyFilesByRecursive(srcPath, destPath);

        // 2. 动态文件生成
        String dynamicSrcPath = projectPath + File.separator + "generator-basic" + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        String dynamicTargetPath = projectPath + File.separator + "acm-template/src/com/hezhaohui/acm/MainTemplate.java";
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("Wonder");
        mainTemplateConfig.setOutputText("我的输出");
        mainTemplateConfig.setLoop(true);
        DynamicGenerator.doGenerator(dynamicSrcPath, dynamicTargetPath, mainTemplateConfig);
    }
}
