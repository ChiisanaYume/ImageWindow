package com.faintdream.gui.swing.imagewindow;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

public class ConfigFile {
    private int windowWidth; // 窗口默认宽度
    private int windowHeight; // 窗口默认高度

    private Properties properties;

    public ConfigFile() {
        init();
    }

    private void init(){

    }

    /**
     * 加载配置文件
     * */
    void load(String configFile) throws IOException{
        // 加载配置文件
        FileInputStream inputStream = new FileInputStream(configFile);
        properties.load(inputStream);
        inputStream.close();
    }

    /**
     * 读配置
     * @param args
     */

    /**
     * 修改资源
     */
    private void update(){

    }
    public static void main(String[] args) {
        Properties properties = new Properties();
        try {
            // 加载配置文件
            FileInputStream inputStream = new FileInputStream("config.properties");
            properties.load(inputStream);
            inputStream.close();

            // 修改配置项的值
            properties.setProperty("key", "new value");

            // 保存修改后的配置文件
            FileOutputStream outputStream = new FileOutputStream("config.properties");
            properties.store(outputStream, "Modified by ConfigFile");
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}