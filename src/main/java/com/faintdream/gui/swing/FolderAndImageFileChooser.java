package com.faintdream.gui.swing;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FolderAndImageFileChooser {
    public static void main(String[] args) {
        // 创建文件选择器对象
        JFileChooser fileChooser = new JFileChooser();

        // 创建文件夹过滤器
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        // 创建图片文件过滤器
        FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("图片文件", "jpg", "jpeg", "png", "gif");
        fileChooser.addChoosableFileFilter(imageFilter);

        // 显示文件选择对话框
        int result = fileChooser.showOpenDialog(null);

        // 处理用户选择的操作
        if (result == JFileChooser.APPROVE_OPTION) {
            // 获取用户选择的文件或文件夹
            java.io.File selectedFile = fileChooser.getSelectedFile();

            // 打印文件或文件夹路径（可根据需要进行其他处理）
            System.out.println("选择的文件或文件夹: " + selectedFile.getAbsolutePath());
        }
    }
}
