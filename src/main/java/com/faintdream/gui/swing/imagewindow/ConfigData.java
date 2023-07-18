package com.faintdream.gui.swing.imagewindow;

import com.faintdream.tool.util.IOUtil;

import java.io.File;
import java.io.IOException;

public class ConfigData {

    private String propertiesFilePath = "ImageWindow.properties";

    private String windowWidth;
    private String windowHeight;
    private String imageDirPath;
    private String imageLoop;
    private String iconPath;
    private String maxImageWidth;

    public String getWindowWidth() {
        return windowWidth;
    }

    public void setWindowWidth(String windowWidth) {
        this.windowWidth = windowWidth;
    }

    public String getWindowHeight() {
        return windowHeight;
    }

    public void setWindowHeight(String windowHeight) {
        this.windowHeight = windowHeight;
    }

    public String getImageDirPath() {
        return imageDirPath;
    }

    public void setImageDirPath(String imageDirPath) {
        this.imageDirPath = imageDirPath;
    }

    public String getImageLoop() {
        return imageLoop;
    }

    public void setImageLoop(String imageLoop) {
        this.imageLoop = imageLoop;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    public String getMaxImageWidth() {
        return maxImageWidth;
    }

    public void setMaxImageWidth(String maxImageWidth) {
        this.maxImageWidth = maxImageWidth;
    }


    public String getPropertiesFilePath() {
        return propertiesFilePath;
    }

    public void setPropertiesFilePath(String propertiesFilePath) {
        this.propertiesFilePath = propertiesFilePath;
    }

    /**
     * 从配置文件中读取配置
     * */
    public void read() throws IOException {
        PropertiesUtil config = new PropertiesUtil();
        config.load(propertiesFilePath);

        setWindowWidth(config.get("windowWidth"));
        setWindowHeight(config.get("windowHeight"));
        setIconPath(config.get("iconPath"));
        setImageLoop(config.get("imageLoop"));
        setImageDirPath(config.get("imageDirPath"));
        setMaxImageWidth(config.get("maxImageWidth"));
    }

    /**
     * 保存修改的配置
     * */
    public void save() throws IOException {
        PropertiesUtil config = new PropertiesUtil();
        config.setPropertiesFile(IOUtil.getFile(propertiesFilePath));

        if(getWindowWidth()!=null){
            config.put("windowWidth",getWindowWidth());
        }

        if(getWindowHeight()!=null){
            config.put("windowHeight",getWindowHeight());
        }

        if(getIconPath()!=null){
            config.put("iconPath",getIconPath());
        }

        if(getImageLoop()!=null){
            config.put("imageLoop",getImageLoop());
        }

        if(getImageDirPath()!=null){
            config.put("imageDirPath",getImageDirPath());
        }

        if(getMaxImageWidth()!=null){
            config.put("maxImageWidth",getMaxImageWidth());
        }

    }

    @Override
    public String toString() {
        return "ConfigData{" +
                "propertiesFilePath='" + propertiesFilePath + '\'' +
                ", windowWidth='" + windowWidth + '\'' +
                ", windowHeight='" + windowHeight + '\'' +
                ", imageDirPath='" + imageDirPath + '\'' +
                ", imageLoop='" + imageLoop + '\'' +
                ", iconPath='" + iconPath + '\'' +
                ", maxImageWidth='" + maxImageWidth + '\'' +
                '}';
    }
}
