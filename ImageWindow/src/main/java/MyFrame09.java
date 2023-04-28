import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyFrame09 extends JFrame {
    private JButton button;
    private JTextField textField;

    public MyFrame09() {
        super("Hello, World!");

        button = new JButton("Click Me");
        textField = new JTextField(20);

        // 添加按钮事件监听器
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.setText("Hello, World!");
            }
        });

        // 将按钮和文本框添加到窗口中
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());
        contentPane.add(button);
        contentPane.add(textField);

        // 设置窗口大小和关闭行为
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MyFrame09().setVisible(true);
            }
        });
    }
}
