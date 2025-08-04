package com.hezhaohui.generator;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ArrayUtil;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class StaticGenerator {

    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        String srcPath = projectPath + File.separator + "demo-projects" + File.separator + "acm-template";
        String destPath = projectPath;
        copyFilesByRecursive(srcPath, destPath);
    }

    /**
     * 复制文件
     *
     * @param srcPath  源文件路径
     * @param destPath 目标文件路径
     */
    public static void copyFilesByHutool(String srcPath, String destPath) {
        FileUtil.copy(srcPath, destPath, false);
    }

    /**
     * 复制文件
     *
     * @param srcPath  源文件路径
     * @param destPath 目标文件路径
     */
    public static void copyFilesByRecursive(String srcPath, String destPath) {
        File srcFile = new File(srcPath);
        File destFile = new File(destPath);
        try {
            copyFileByRecursive(srcFile, destFile);
        } catch (Exception e) {
            System.out.println("复制文件失败");
            e.printStackTrace();
        }
    }

    /**
     * 递归复制文件
     *
     * @param srcFile  源文件
     * @param destFile 目标文件
     * @throws Exception 异常
     */
    private static void copyFileByRecursive(File srcFile, File destFile) throws Exception {
        if (srcFile.isDirectory()) {
            System.out.println(srcFile.getName());
            File destDir = new File(destFile, srcFile.getName());
            if (!destDir.exists()) {
                destDir.mkdirs();
            }
            File[] files = srcFile.listFiles();
            if (ArrayUtil.isEmpty(files)) {
                return;
            }
            for (File file : files) {
                copyFileByRecursive(file, destDir);
            }
        } else {
            Path destPath = destFile.toPath().resolve(srcFile.getName());
            Files.copy(srcFile.toPath(), destPath, StandardCopyOption.REPLACE_EXISTING);
        }
    }
}