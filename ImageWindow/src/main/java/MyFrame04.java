import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame04 extends JFrame {
    private JButton leftButton, rightButton;
    
    public MyFrame04() {
        // 设置窗口大小为400x400
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 对JFrame的默认布局管理器设为空
        setLayout(null);
        
        // 创建左右按钮
        leftButton = new JButton("上");
        leftButton.setBounds(10, getHeight() / 2 - 10, 50, 20);
        rightButton = new JButton("下");
        rightButton.setBounds(getWidth() - 50 - 10 - 15, getHeight() / 2 - 10, 50, 20);

		System.out.println("Width:" + getWidth());
		System.out.println("Height:" + getHeight());
        
        // 将按钮添加到窗口中
        getContentPane().add(leftButton);
        getContentPane().add(rightButton);
        
        setVisible(true);
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }
    
    public static void main(String[] args) {
        new MyFrame04();
    }
}

