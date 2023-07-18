package com.faintdream.tool.io.impl;

import java.io.File;
import java.io.FilenameFilter;

/**
 * 图片文件过滤器
 * */
public class DefImageFilter implements FilenameFilter {

    @Override
    public boolean accept(File dir, String name) {
        String lowerCaseName = name.toLowerCase();
        return lowerCaseName.endsWith(".jpg")
                || lowerCaseName.endsWith(".png")
                || lowerCaseName.endsWith(".jpeg")
                || lowerCaseName.endsWith(".gif");
    }
}
