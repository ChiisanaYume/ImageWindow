package com.faintdream.gui.swing.temp;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfigFromJar {
    public static void main(String[] args) {
        // 配置文件名
        String configFile = "ImageWindow.properties";

        // 使用ClassLoader获取配置文件的输入流
        try (InputStream inputStream = ReadConfigFromJar.class.getClassLoader().getResourceAsStream(configFile)) {
            if (inputStream != null) {
                Properties properties = new Properties();
                properties.load(inputStream);

                // 读取配置项
                String propertyValue = properties.getProperty("iconPath");
                System.out.println("Value of key in config.properties: " + propertyValue);
            } else {
                System.out.println("Config file not found!");
            }
        } catch (IOException e) {
            System.out.println("Error while reading config file: " + e.getMessage());
        }
    }
}
