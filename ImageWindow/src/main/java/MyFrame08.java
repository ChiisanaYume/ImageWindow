import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame08 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("BoxLayout Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Box box = Box.createVerticalBox(); // 创建一个垂直盒子
        
        JButton topButton = new JButton("Top Button");
        JButton bottomButton = new JButton("Bottom Button");
        
        box.add(topButton); // 添加按钮到盒子中
        box.add(Box.createVerticalGlue()); // 添加垂直空间
        box.add(bottomButton); // 添加按钮到盒子中
        
        frame.setContentPane(box); // 将盒子设置为框架的内容面板
        
        frame.pack(); // 自适应大小
        frame.setVisible(true); // 显示框架
    }
}
