import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame03 extends JFrame {
    private JButton leftButton, rightButton;
    
    public MyFrame03() {
        // 设置窗口大小为400x400
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 对JFrame的默认布局管理器设为空
        setLayout(null);
        
        // 创建左右按钮
        leftButton = new JButton("上");
        leftButton.setBounds(10, getHeight() / 2 - 10, 50, 20);
        rightButton = new JButton("下");
        rightButton.setBounds(getWidth() - 60, getHeight() / 2 - 10, 50, 20);
        
        // 将按钮添加到窗口中
        add(leftButton);
        add(rightButton);
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new MyFrame03();
    }
}
