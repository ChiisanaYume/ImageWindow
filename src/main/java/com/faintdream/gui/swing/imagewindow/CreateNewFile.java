package com.faintdream.gui.swing.imagewindow;

import java.io.File;
import java.io.IOException;

/**
 * 创建新文件
 * @author faintdream
 * @version 1.0
 * */
public interface CreateNewFile {
    /**
     * 创建新文件
     * @param file 文件名(路径)
     * @throws IOException IO异常
     * */
    void createNewFile(File file) throws IOException;
}
