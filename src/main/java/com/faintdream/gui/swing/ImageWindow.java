package com.faintdream.gui.swing;

import com.faintdream.gui.swing.imagewindow.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Objects;
import java.util.ResourceBundle;

public class ImageWindow extends JFrame implements ActionListener, Serializable {
    private static final long serialVersionUID = 1L;

    private JMenuBar menuBar; // 菜单栏
    private JLabel label; // 显示图片的标签
    private JButton prevButton; // 上一张按钮
    private JButton nextButton; // 下一张按钮
    private int currentImageIndex = 0; // 当前显示的图片在文件列表中的索引

    /**
     * 配置
     */
    private final ConfigData config = new ConfigData();
    private File[] imageFiles; // 存储所有图片文件的数组
    private GlobalData globalData = new GlobalData();

    /**
     * 构造方法
     */
    public ImageWindow() throws IOException {

        // 设置窗口标题
        super("图片浏览");

        // 读取配置
        config.read();

        // 全局UI设置
        setGlobalUI();

        // 创建标签
        label = new JLabel();

        // 获取图片文件目录
        imageFiles = getListFiles();

        // 显示第一张图片
        showImage(0);

        // 组装(显示)显示按钮
        showButton();

        // 组装(显示)菜单栏
        showMenuBar();

        // 组合成面板并添加到窗口中
        JPanel panel = new JPanel();

        // 设置布局为BoxLayout(盒模型布局)
        BoxLayout layout = new BoxLayout(panel, BoxLayout.X_AXIS);
        panel.setLayout(layout);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createRigidArea(new Dimension(50, 0)));
        //panel.add(Box.createHorizontalGlue());
        panel.add(prevButton);
        panel.add(Box.createHorizontalGlue());
        panel.add(label);
        panel.add(Box.createHorizontalGlue());
        panel.add(nextButton);
        panel.add(Box.createRigidArea(new Dimension(50, 0)));
        //panel.add(Box.createHorizontalGlue());

        getContentPane().add(panel);

        // 设置窗口图标
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource(config.getIconPath())); // 加载图标
        setIconImage(icon);

        // 向窗口的内容面板添加组件
        getContentPane().add(panel);

        // 设置窗口大小和位置
        setSize(Integer.parseInt(config.getWindowWidth()), Integer.parseInt(config.getWindowHeight()));
        setLocationRelativeTo(null);

        // 添加关闭按钮事件(退出程序)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addWindowListener(windowListener);

        // 显示窗口
        setVisible(true);
    }

    /**
     * 获取图片文件目录
     */
    private File[] getListFiles() {
        File imageDir = new File(config.getImageDirPath());
        File[] files = imageDir.listFiles(new ImageFilter());
        if (files != null && files.length == 0) { // 如果没有图片(显示一张默认图片)
            //
            System.out.println("如果没有图片(显示一张默认图片");
        }
        return files;

    }

    /**
     * 图片文件过滤器
     */
    private static class ImageFilter implements FilenameFilter {
        @Override
        public boolean accept(File dir, String name) {
            String lowerCaseName = name.toLowerCase();
            return lowerCaseName.endsWith(".jpg")
                    || lowerCaseName.endsWith(".jpeg")
                    || lowerCaseName.endsWith(".gif")
                    || lowerCaseName.endsWith(".png");
        }
    }

    /**
     * 调用UIManager设置全局UI
     */
    private void setGlobalUI() {

        // 设置菜单之间设置的间距大小
        //UIManager.put("Menu.margin", new InsetsUIResource(0, 100, 0, 100));

    }

    /**
     * 设置/初始化button(按钮)对象
     */
    private void showButton() {

        // 创建按钮
        prevButton = new JButton("上 一 张");
        nextButton = new JButton("下 一 张");

        // 设置按钮样式
        prevButton.setPreferredSize(new Dimension(100, 40));
        nextButton.setPreferredSize(new Dimension(100, 40));

        // 注册按钮事件监听器
        prevButton.addActionListener(this);
        nextButton.addActionListener(this);

    }

    /**
     * 设置/初始化menuBar(菜单)对象
     */
    private void showMenuBar() {

        // 创建菜单
        JMenu fileMenu = new JMenu("文件");
        JMenu settingMenu = new JMenu("设置");

        // 创建菜单项
        JMenuItem openFIleMenuItem = new JMenuItem("打开文件");
        JMenuItem openFolderMenuItem = new JMenuItem("打开文件夹");
        JMenuItem saveMenuItem = new JMenuItem("另存");
        JMenuItem exitMenuItem = new JMenuItem("退出");

        // 添加菜单项到菜单
        fileMenu.add(openFIleMenuItem);
        fileMenu.add(openFolderMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);

        // 添加菜单到菜单栏
        menuBar = new JMenuBar();
        menuBar.add(fileMenu);
        menuBar.add(settingMenu);

        //布局相关
        fileMenu.setPreferredSize(new Dimension(50, 30));
        settingMenu.setPreferredSize(new Dimension(50, 30));

        // 将菜单栏设置到窗口
        setJMenuBar(menuBar);

        // 事件
        // 打开文件
        openFIleMenuItem.addActionListener((event) -> {
            File file = ImageFileChooser.selectedFile();

            // 没有选择文件
            if(file == null || !file.exists()){
                return; // 无事发生
            }

            // 获取图片父目录
            config.setImageDirPath(file.getParent());

            // 获取图片文件目录
            imageFiles = getListFiles();

            // 找到图片的下标，显示这张图片
            for (int i = 0; i < imageFiles.length; i++) {
                if(file.equals(imageFiles[i])){
                    showImage(i);
                }
            }
            // showImage(0);

        });

        // 打开文件夹
        openFolderMenuItem.addActionListener((event) -> {
            File file = FolderFileChooser.selectedFile();

            // 没有选择文件
            if(file == null || !file.exists()){
                return; // 无事发生
            }

            config.setImageDirPath(file.getAbsolutePath());

            // 获取图片文件目录
            imageFiles = getListFiles();

            // 显示第一张图片
            showImage(0);
        });

        // 退出
        exitMenuItem.addActionListener(new ExitAction());
    }

    /**
     * 显示指定索引的图片
     *
     * @param index 图片索引
     */
    private void showImage(int index) {
        if (index < 0 || index >= imageFiles.length) {
            return;
        }
        File imageFile = imageFiles[index];
        try {
            // 获取图片
            // 存储当前显示的图片
            ImageIcon icon = new ImageIcon(imageFile.getCanonicalPath());

            // 裁剪图片
            icon = cropIconH(icon, Integer.parseInt(config.getWindowHeight()) - 100, Integer.parseInt(config.getMaxImageWidth()));
            label.setIcon(icon);

            currentImageIndex = index;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 按宽高比例裁剪图片，给定高与最大宽度
     *
     * @param icon     要裁剪图片的高
     * @param height   图片的高
     * @param maxWidth 图片的最大宽度
     * @return ImageIcon 裁剪完成后的图片
     */
    private ImageIcon cropIconH(final ImageIcon icon, final int height, final int maxWidth) {

        ImageIcon temp = icon;
        int h = height;

        //判断图片宽度是否超过最大宽度，如果超过，继续裁剪
        while (temp.getIconWidth() >= maxWidth) {
            temp = cropIconH(temp, h);
            h = h * 9 / 10;
        }

        return temp;

    }

    /**
     * 按宽高比例裁剪图片，给定高
     *
     * @param icon   要裁剪图片的高
     * @param height 图片的高
     * @return ImageIcon 裁剪完成后的图片
     */
    private ImageIcon cropIconH(final ImageIcon icon, final int height) {
        //计算缩放比例
        int width = height * icon.getIconWidth() / icon.getIconHeight();
        Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }

    /**
     * 按宽高比例裁剪图片，给定宽
     *
     * @param icon  要裁剪图片的高
     * @param width 图片的高
     * @return ImageIcon 裁剪完成后的图片
     */
    private ImageIcon cropIconW(final ImageIcon icon, final int width) {
        //计算缩放比例
        int height = width * icon.getIconHeight() / icon.getIconWidth();
        Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }

    /**
     * 按钮事件处理方法
     *
     * @param e 事件对象
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == prevButton) {          // 上一张按钮被点击
            if (currentImageIndex <= 0 && Boolean.parseBoolean(config.getImageLoop())) {
                currentImageIndex = imageFiles.length;
            }
            showImage(currentImageIndex - 1);
        } else if (e.getSource() == nextButton) { // 下一张按钮被点击

            if (currentImageIndex >= imageFiles.length - 1 && Boolean.parseBoolean(config.getImageLoop())) {
                currentImageIndex = -1;
            }
            showImage(currentImageIndex + 1);

        }
    }

    WindowListener windowListener = new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            ExitAction.exit(0);
        }
    };


    @Override
    public String toString() {
        return null;
    }

    /**
     * 程序入口
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) throws IOException {
        new ImageWindow();
    }
}
