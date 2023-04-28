
import java.awt.*;
import javax.swing.*;

public class MyFrame07 {

    public static void main(String[] args) {
        JFrame frame = new JFrame();

        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new GridLayout(0, 2, 15, 0));

        // Add to left side (WEST)
        frame.add(detailsPanel, BorderLayout.WEST);

        // Add some labels:
        detailsPanel.add(getLabel("Some text:"));
        detailsPanel.add(new JLabel("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc id mauris "));


        detailsPanel.add(getLabel("Some text 2:"));
        detailsPanel.add(new JLabel("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc id mauris "));

        detailsPanel.add(getLabel("Some other text 3:"));
        detailsPanel.add(new JLabel("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc id mauris "));

        frame.setSize(new Dimension(900, 100));
        frame.setVisible(true);
        frame.pack();
    }

    public static JLabel getLabel(String text)
    {
        JLabel lbl = new JLabel(text);
        lbl.setHorizontalAlignment(SwingConstants.TRAILING);
        return lbl;
    }

}