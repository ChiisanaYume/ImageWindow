package com.faintdream.gui.swing.imagewindow;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FolderFileChooser implements ActionListener {
    public static void main(String[] args) {
        new FolderFileChooser().selectedFile();
    }

    public File selectedFile(){

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

            // 如果文件存在
            if(selectedFolder.exists()){
                return selectedFolder;
            }
        }

        // 基本上永远执行不到这里
        return null;
    }
    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        selectedFile();
    }
}
