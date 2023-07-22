package com.faintdream.gui.swing.imagewindow;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ImageFileChooser implements ActionListener {
    public static File selectedFile() {
        // 创建文件选择器
        JFileChooser fileChooser = new JFileChooser();

        // 创建图片文件过滤器
        FileNameExtensionFilter imageFilter = new FileNameExtensionFilter(
                "图片文件", "jpg", "jpeg", "png", "gif", "bmp");

        // 设置过滤器
        fileChooser.setFileFilter(imageFilter);

        // 打开文件选择窗口
        int returnValue = fileChooser.showOpenDialog(null);

        // 处理用户选择的文件
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            return selectedFile.getAbsoluteFile();
        } else {
            return null;
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        selectedFile();
    }
}
