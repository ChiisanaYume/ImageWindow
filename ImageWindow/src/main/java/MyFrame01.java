import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame01 extends JFrame {
    private JButton leftButton, rightButton;
    
    public MyFrame01() {
        // 设置窗口大小为400x400
        setSize(400, 400);
        
        // 创建左右按钮
        leftButton = new JButton("上");
        leftButton.setPreferredSize(new Dimension(20, 20));
        rightButton = new JButton("下");
        rightButton.setPreferredSize(new Dimension(20, 20));
        
        // 创建一个面板，并设置其布局为BorderLayout
        JPanel panel = new JPanel(new BorderLayout());
        
        // 创建一个流式布局，并将左右按钮添加到该布局中
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(leftButton);
        buttonPanel.add(rightButton);
        
        // 将该流式布局添加到面板的中央位置
        panel.add(buttonPanel, BorderLayout.CENTER);
        
        // 将面板添加到窗口中央位置
        add(panel, BorderLayout.CENTER);
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new MyFrame01();
    }
}
