package com.faintdream.gui.swing.imagewindow;

import java.io.File;

/**
 * 缓存：
 *
 * @author faintdream
 * @version 1.0
 */
public class ImageWindowCache implements CheckFileSystem {

    File cacheFile = new File("C:\\Program Files\\");

    /**
     * 缓存文件
     */
    private void Cache() {
        switch (getFileSystem()){
            case WINDOWS:
                cacheFile = new File("C:\\Program Files\\imageWindow\\");
                break;
            case LINUX:
                cacheFile = new File("/usr/bin/imageWindow");
                break;
            case MAC:
                break;
            case OTHER:
        }

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
}
