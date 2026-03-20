import javax.swing.JFrame;
import custom.panel.MainPanel;
import custom.frame.MainFrame;

import javax.swing.JPanel;
import java.awt.Dimension;

public class UIMain {
    public static void main(String[] args) {
        var dimension = new Dimension(600, 600);
        JPanel maiPanel = new MainPanel(dimension);
        JFrame mainFrame = new MainFrame(dimension, maiPanel);
        mainFrame.revalidate();
        mainFrame.repaint();

    }
}
