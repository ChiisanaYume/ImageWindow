import javax.swing.*;
import java.awt.*;

public class MyFrame11 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("BoxLayout Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        JButton button3 = new JButton("Button 3");

        panel.add(Box.createVerticalGlue()); // 添加垂直间隔
        panel.add(button1);
        panel.add(Box.createVerticalGlue()); // 添加垂直间隔
        panel.add(button2);
        panel.add(Box.createVerticalGlue()); // 添加垂直间隔
        panel.add(button3);
        panel.add(Box.createVerticalGlue()); // 添加垂直间隔

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}