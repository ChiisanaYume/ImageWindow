import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;

public class MyFrame05 extends JFrame {
    private JButton leftButton, rightButton;
    
    public MyFrame05() {
        // 设置窗口大小为400x400
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // 创建包含两个按钮的JPanel
        JPanel panel = new JPanel();
        leftButton = new JButton("Left Button");
        leftButton.setPreferredSize(new Dimension(100, 50));
        panel.add(leftButton);
        rightButton = new JButton("Right Button");
        rightButton.setPreferredSize(new Dimension(100, 50));
        panel.add(rightButton);
        
        // 将JPanel添加到窗口的SOUTH位置
        add(panel, BorderLayout.SOUTH);
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new MyFrame05();
    }
}
