package com.faintdream.application;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public class FileChooser {
    public static void main(String[] args) {
        new FileChooser().selectedFile();
    }

    public File selectedFile(){

        // 创建文件选择器对象
        JFileChooser fileChooser = new JFileChooser();

        // 设置文件过滤器，仅显示文本文件（可根据需要更改过滤器）
        FileNameExtensionFilter filter = new FileNameExtensionFilter("文本文件 (*.txt)", "txt");
        fileChooser.setFileFilter(filter);

        // 显示打开对话框
        int result = fileChooser.showOpenDialog(null);

        // 处理用户选择的操作(阻塞)
        if (result == JFileChooser.APPROVE_OPTION) {
            // 获取用户选择的文件
            File selectedFile = fileChooser.getSelectedFile();

            // 打印文件路径（可根据需要进行其他处理）
            System.out.println("选择的文件: " + selectedFile.getAbsolutePath());

            return selectedFile;
        }
        return null;
    }
    public FileChooser() {

    }
}
