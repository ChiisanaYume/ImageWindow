import javax.swing.*;
import java.awt.*;

public class MyFrame12 extends JFrame {
    public MyFrame12() {
        super("My Frame");
        Image icon = Toolkit.getDefaultToolkit().getImage("E:\\BaiduSyncdisk\\copy\\logo\\self\\kaguyahime.png"); // 加载图标
        setIconImage(icon); // 设置图标
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MyFrame12::new);
    }
}
