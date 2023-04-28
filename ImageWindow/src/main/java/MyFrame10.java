import javax.swing.*;
import java.awt.*;

public class MyFrame10 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("BoxLayout Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JButton button = new JButton("Click Me");
        button.setPreferredSize(new Dimension(200, 200)); // 设置按钮大小
        button.setMinimumSize(new Dimension(300,300));
        panel.add(Box.createVerticalGlue());
        panel.add(button);
        panel.add(Box.createVerticalGlue());

        frame.add(panel);
        //frame.pack();

        frame.setSize(500,500);
        frame.setVisible(true);
    }
}
