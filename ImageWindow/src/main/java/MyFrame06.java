import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame06 extends JFrame {
    private JButton leftButton, rightButton;

    public MyFrame06() {
        // 设置窗口大小为400x400
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 创建包含左右按钮的面板
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        leftButton = new JButton("上");
        rightButton = new JButton("下");
        buttonPanel.add(leftButton, BorderLayout.WEST);
        buttonPanel.add(rightButton, BorderLayout.EAST);

        // 将面板添加到窗口中
        getContentPane().add(buttonPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new MyFrame06();
    }
}
