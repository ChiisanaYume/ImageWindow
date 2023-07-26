package com.faintdream.gui.swing.imagewindow;
/**
 * 文件系统(操作系统)
 * @version 1.0
 * @author faintdream
 * */
public enum FileSystem {

    OTHER(0),
    WINDOWS(1),
    LINUX(2),
    MAC(3);

    private final int value;

    FileSystem(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
