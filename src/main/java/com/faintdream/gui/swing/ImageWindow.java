package com.faintdream.gui.swing;

import com.faintdream.gui.swing.imagewindow.ExitAction;
import com.faintdream.gui.swing.imagewindow.GlobalData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.ResourceBundle;

public class ImageWindow extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;

    private JMenuBar menuBar; // 菜单栏
    private JLabel label; // 显示图片的标签
    private JButton prevButton; // 上一张按钮
    private JButton nextButton; // 下一张按钮
    private int currentImageIndex = 0; // 当前显示的图片在文件列表中的索引


    private final ResourceBundle BUNDLE = ResourceBundle.getBundle("ImageWindow"); // 资源绑定器(获取配置)

    private final int windowWidth = Integer.parseInt(BUNDLE.getString("windowWidth")); // 窗口默认宽度
    private final int windowHeight = Integer.parseInt(BUNDLE.getString("windowHeight")); // 窗口默认高度

    private String imageDirPath = BUNDLE.getString("imageDirPath"); // 图片文件路径
    private File[] imageFiles = getListFiles(); // 存储所有图片文件的数组

    private final boolean imageLoop = Boolean.parseBoolean(BUNDLE.getString("imageLoop")); // 图片是否循环播放
    // 显示图片的最大宽度(超过这个宽度会进行二次裁剪)
    private final int maxImageWidth = Integer.parseInt(BUNDLE.getString("maxImageWidth")); // 显示图片的最大宽度

    private final String iconPath = BUNDLE.getString("iconPath"); // 窗口图标路径

    private GlobalData globalData = new GlobalData();

    /**
     * 构造方法
     */
    public ImageWindow() {
        // 设置窗口标题
        super("图片浏览");

        // 全局UI设置
        setGlobalUI();

        // 获取图片文件目录
        imageFiles = getListFiles();

        // 创建标签
        label = new JLabel();

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
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource(iconPath)); // 加载图标
        setIconImage(icon);

        // 向窗口的内容面板添加组件
        getContentPane().add(panel);

        // 设置窗口大小和位置
        setSize(windowWidth, windowHeight);
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
        File imageDir = new File(imageDirPath);
        File[] files = imageDir.listFiles(new ImageFilter());
        if(files.length==0){ // 如果没有图片(显示一张默认图片)
            return imageDir.listFiles(new ImageFilter());
        }
        return imageDir.listFiles(new ImageFilter());

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
        openFolderMenuItem.addActionListener(new FolderFileChooser());
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
            icon = cropIconH(icon, windowHeight - 100, maxImageWidth);
            label.setIcon(icon);

            // label.setBorder(BorderFactory.createLineBorder(Color.pink));
            // label.setAlignmentX(Component.CENTER_ALIGNMENT);

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
            if (currentImageIndex <= 0 && imageLoop) {
                currentImageIndex = imageFiles.length;
            }
            showImage(currentImageIndex - 1);
        } else if (e.getSource() == nextButton) { // 下一张按钮被点击

            if (currentImageIndex >= imageFiles.length - 1 && imageLoop) {
                currentImageIndex = -1;
            }
            showImage(currentImageIndex + 1);

        }
    }

    WindowListener windowListener = new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            // 处理关闭窗口事件的逻辑
            System.out.println(ImageWindow.this.toString());
            new ExitAction().exit(0);
        }
    };

    class FolderFileChooser implements ActionListener {

        public File selectedFile() {

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
                if (selectedFolder.exists()) {
                    return selectedFolder;
                }
            }

            // 基本上永远执行不到这里
            return null;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            File file = selectedFile();
            imageDirPath = file.getAbsolutePath();
            imageFiles = getListFiles();
            showImage(0);
        }
    }

    @Override
    public String toString() {
        return "ImageWindow{\n" +
//                "menuBar=" + menuBar +
//                ",\n label=" + label +
//                ",\n prevButton=" + prevButton +
//                ",\n nextButton=" + nextButton +
                ",\n currentImageIndex=" + currentImageIndex +
                ",\n BUNDLE=" + BUNDLE +
                ",\n windowWidth=" + windowWidth +
                ",\n windowHeight=" + windowHeight +
                ",\n imageDirPath='" + imageDirPath + '\'' +
//                ",\n imageFiles=" + Arrays.toString(imageFiles) +
                ",\n imageLoop=" + imageLoop +
                ",\n maxImageWidth=" + maxImageWidth +
                ",\n iconPath='" + iconPath + '\'' +
                ",\n globalData=" + globalData +
                "\n}";
    }

    /**
     * 程序入口
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        new ImageWindow();
    }
}
