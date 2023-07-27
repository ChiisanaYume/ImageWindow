package com.faintdream.gui.swing.imagewindow;

import java.io.File;
import java.io.IOException;

/**
 * 删除目录
 * @author faintdream
 * @version 1.0
 * */
public interface DeleteDirectory {

    /**
     * 删除目录并递归的删除子目录
     * */
    void deleteDirectory(File file) throws IOException;
}
