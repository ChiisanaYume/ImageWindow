package com.faintdream.application;

import javax.swing.JFileChooser;

public class FolderFileChooser {
    public static void main(String[] args) {
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
            System.out.println("选择的文件夹: " + selectedFolder.getAbsolutePath());
        }
    }
}
