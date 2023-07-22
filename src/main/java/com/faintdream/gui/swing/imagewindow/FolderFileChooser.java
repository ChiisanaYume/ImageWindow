package com.faintdream.gui.swing.imagewindow;

import com.faintdream.gui.swing.imagewindow.ExitAction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FolderFileChooser implements ActionListener {

    public static File selectedFile() {

        // 创建文件选择器对象
        JFileChooser fileChooser = new JFileChooser();

        // 设置文件选择模式为仅选择文件夹
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        // 显示文件选择对话框
        int result = fileChooser.showOpenDialog(null);

        // 处理用户选择的操作
        if (result == JFileChooser.APPROVE_OPTION) {
            // 获取用户选择的文件夹
            java.io.File selectedFolder = fileChooser.getSelectedFile();

            // 打印文件夹路径（可根据需要进行其他处理）
            // System.out.println("选择的文件夹: " + selectedFolder.getAbsolutePath());

            // 如果文件存在
            if (selectedFolder.exists()) {
                return selectedFolder.getAbsoluteFile();
            }
        }

        // 没有选择任何文件
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // 选择文件
        selectedFile();
        // code
    }
}
