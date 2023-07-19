package com.faintdream.gui.swing.imagewindow;

import com.faintdream.tool.util.IOUtil;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertiesUtil {

    private final Properties properties = new Properties();
    private File propertiesFile;

    // 构造方法
    public PropertiesUtil() {
    }


    /**
     * 加载配置文件
     * @param configFile 配置文件名
     * @throws IOException IO异常
     * */
    public void load(String configFile) throws IOException{
        // 加载配置文件
        propertiesFile = IOUtil.getFile(configFile);
        FileInputStream inputStream = new FileInputStream(propertiesFile);
        properties.load(inputStream);
        inputStream.close();
    }

    /**
     * (根据key)读配置文件(value)
     * @param key 配置文件key
     * @return value 配置文件value
     */
    public String get(String key){
        return properties.getProperty(key);
    }

    /**
     * 修改(设置)配置文件
     * @param key 配置文件key
     * @param value 配置文件value
     * @throws IOException IO异常
     */
    public void set(String key,String value) throws IOException {
        properties.setProperty(key,value);
        if(!propertiesFile.exists()){
            IOUtil.createNewFile(propertiesFile);
        }
        save(propertiesFile);
    }

    /**
     * set方法的别名
     * @see this.set()
     * */
    public void put(String key,String value) throws IOException {
        set(key,value);
    }

    /**
     * 保存配置文件
     * */
    public void save(File file) throws IOException {
        OutputStream outputStream = Files.newOutputStream(Paths.get(file.toURI()));
        properties.store(outputStream, null);
        outputStream.close();
    }

    /**
     * getter & setter
     * */
    public File getPropertiesFile() {
        return propertiesFile;
    }

    public void setPropertiesFile(File propertiesFile) {
        this.propertiesFile = propertiesFile;
    }
}