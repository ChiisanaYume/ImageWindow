package com.faintdream.gui.swing.imagewindow;


import java.io.*;
import java.nio.file.Files;
import java.util.Properties;

public class PropertiesUtil {

    /**
     * `onlyUpdateMemory` 仅仅在内存中生效,进行修改(更新)操作时不会更改配置文件 (`.properties`)
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
     * @param configFile 配置文件名(注意配置文件要在类路径下)
     * @throws IOException IO异常
     */
    public void load(String configFile) throws IOException {
        // 加载配置文件(直接从流中加载)
        InputStream stream = getStream(configFile);
        properties.load(stream);
        stream.close();
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
            // throw new IOException("暂时不支持修改配置文件");
            // code
            save(propertiesFile);
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
     * 获取输入流
     */
    private InputStream getStream(String configFile) {
        return getClass().getClassLoader().getResourceAsStream(configFile);
    }

    /**
     * 保存 properties文件
     */
    public void save(File propertiesFile) throws IOException {

        propertiesFile = propertiesFile.getAbsoluteFile();

        try (OutputStream output = Files.newOutputStream(propertiesFile.toPath())) {
            properties.store(output, "Example properties file");

        } catch (IOException e) {
            throw new IOException(e);
        }
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