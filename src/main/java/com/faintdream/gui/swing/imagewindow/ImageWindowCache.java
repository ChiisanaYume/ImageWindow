package com.faintdream.gui.swing.imagewindow;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

/**
 * 缓存：
 *
 * @author faintdream
 * @version 1.0
 */
public class ImageWindowCache implements CheckFileSystem, CreateNewFile,DeleteDirectory {

    // File cacheFile = new File("C:\\Program Files\\");

    /**
     * 核心配置文件路径
     */
    File coreProperties;
    Path parentPath;

    /**
     * 缓存文件
     */
    public void cacheFile() throws IOException {
        switch (getFileSystem()) {
            case WINDOWS:
                coreProperties = new File("C:\\Program Files\\ImageWindow\\ImageWindow.properties");
                break;
            case LINUX:
                coreProperties = new File("/usr/bin/imageWindow/ImageWindow.properties");
                break;
            case MAC:
                break;
            case OTHER:
        }

        // 文件不存在,创建文件
        createNewFile(coreProperties);

        PropertiesUtil propertiesUtil = new PropertiesUtil();
        propertiesUtil.load("ImageWindow.properties");
        Properties properties = propertiesUtil.getProperties();

        System.out.println(properties);
    }

    /**
     * 获取当前文件系统
     *
     * @return FileSystem
     * @see FileSystem
     */
    @Override
    public FileSystem getFileSystem() {

        String osName = System.getProperty("os.name").toLowerCase();

        if (osName.contains("windows")) {
            return FileSystem.WINDOWS;
        } else if (osName.contains("linux")) {
            return FileSystem.LINUX;
        } else if (osName.contains("mac")) {
            return FileSystem.MAC;
        } else {
            return FileSystem.OTHER;
        }

    }

    /**
     * 创建新文件
     *
     * @param file 文件名(路径)
     * @throws IOException IO异常
     */
    @Override
    public void createNewFile(File file) throws IOException {

        Path path = file.toPath();
        if (!path.getParent().toFile().exists()) {
            Files.createDirectories(path.getParent());
        }
        try {
            Files.createFile(path);
            // System.out.println("File created successfully.");
        } catch (FileAlreadyExistsException e) {
            // 捕捉并忽略文件已经存在异常
        }
    }

    @Override
    public  void deleteDirectory(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File subFile : files) {
                    deleteDirectory(subFile);
                }
            }
        }
        file.delete();
        // System.out.println("File deleted.");
    }

}
