import javax.swing.*;
import java.awt.*;

public class MyFrame13 extends JFrame {
    public MyFrame13() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Image Demo");
        setSize(500, 500);

        // 创建一个面板用于显示图片和标签
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // 创建一个标签并设置图片
        JLabel label = new JLabel(new ImageIcon("E:\\BaiduSyncdisk\\copy\\logo\\self\\kaguyahime.png"));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        // 添加标签到面板中
        panel.add(Box.createVerticalGlue());
        panel.add(label);
        panel.add(Box.createVerticalGlue());

        // 将面板添加到窗口中
        getContentPane().add(panel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new MyFrame13().setVisible(true);
    }
}
