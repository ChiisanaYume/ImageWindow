package com.faintdream.appliaction;

import javax.swing.*;

public class MyFrame01 extends JFrame {
    public MyFrame01() {
        super("My Frame");

        // 创建菜单栏
        JMenuBar menuBar = new JMenuBar();

        // 创建菜单
        JMenu fileMenu = new JMenu("File");

        // 创建菜单项
        JMenuItem openMenuItem = new JMenuItem("Open");
        JMenuItem saveMenuItem = new JMenuItem("Save");
        JMenuItem exitMenuItem = new JMenuItem("Exit");

        // 添加菜单项到菜单
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);

        // 添加菜单到菜单栏
        menuBar.add(fileMenu);

        // 将菜单栏设置到窗口
        setJMenuBar(menuBar);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MyFrame01();
    }
}
