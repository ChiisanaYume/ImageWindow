package com.faintdream.gui.swing.imagewindow;


import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * Properties的操作类
 * @author faintdream
 * @version 1.0
 * */
public class PropertiesUtil {

    /**
     * `onlyUpdateMemory` 仅仅在内存中生效,进行修改(更新)操作时不会更改配置文件 (`.properties`)
     * `properties` 对象内部维护的 properties对象(只读)
     * `propertiesFile` 与properties 对应的 properties配置文件(`.properties`)的路径
     */
    private boolean onlyUpdateMemory = true;
    private final Properties properties = new Properties();
    private File propertiesFile;

    // 构造方法
    public PropertiesUtil() {
    }


    /**
     * 加载配置文件
     *
     * @param configFile 配置文件名
     * @throws IOException IO异常
     */
    public void load(String configFile) throws IOException {
        InputStream stream = null;

        // 加载配置文件(尝试从绝对路径加载)
        try{
            stream = getStream(configFile);
            properties.load(stream);
            stream.close();
            return;
        }catch (IOException e){

            // 加载配置文件(加载配置文件,尝试从类路径加载)
            stream = getStreamAsClassPath(configFile);
            properties.load(stream);
            stream.close();
        }


    }

    /**
     * (根据key)读配置文件(value)
     *
     * @param key 配置文件key
     * @return value 配置文件value
     */
    public String get(String key) {
        return properties.getProperty(key);
    }

    /**
     * 修改(设置)配置文件
     *
     * @param key   配置文件key
     * @param value 配置文件value
     * @throws IOException IO异常
     */
    public void set(String key, String value) throws IOException {
        properties.setProperty(key, value);
        if (!isOnlyUpdateMemory()) {
            save();
        }
    }

    /**
     * set方法的别名
     *
     * @see this.set()
     */
    public void put(String key, String value) throws IOException {
        set(key, value);
    }


    /**
     * 保存 properties文件
     * @throws IOException
     */
    public void save() throws IOException {
        save(propertiesFile);
    }

    /**
     * 保存 properties文件
     * @param propertiesFile properties文件
     * @throws IOException
     */
    public void save(File propertiesFile) throws IOException {

        propertiesFile = propertiesFile.getAbsoluteFile();

        try (OutputStream output = Files.newOutputStream(propertiesFile.toPath())) {
            properties.store(output, getClass().getName());

        } catch (IOException e) {
            throw new IOException(e);
        }
    }


    /**
     * 获取输入流
     */
    private InputStream getStreamAsClassPath(String configFile) {
        return getClass().getClassLoader().getResourceAsStream(configFile);
    }

    private InputStream getStream(String configFile) throws IOException {
        return Files.newInputStream(Paths.get(configFile));
    }

    /**
     * getter & setter
     */
    public Properties getProperties() {
        return properties;
    }

    public boolean isOnlyUpdateMemory() {
        return onlyUpdateMemory;
    }

    public void setOnlyUpdateMemory(boolean onlyUpdateMemory) {
        this.onlyUpdateMemory = onlyUpdateMemory;
    }

    public void setConfigFile(File configFile) {
        this.propertiesFile = configFile;
    }

    public File getPropertiesFile() {
        return propertiesFile;
    }

    public void setPropertiesFile(File propertiesFile) {
        this.propertiesFile = propertiesFile;
    }
}