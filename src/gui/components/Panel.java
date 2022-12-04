package gui.components;


import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Component;

public class Panel extends JPanel {
    public Panel(int width, int height, Color backgroundColor) {
        this.setSize(width, height);
        this.setBackground(backgroundColor);
        this.setOpaque(true);
    }

    public void center(JFrame frame) {
        this.setLocation(frame.getWidth() / 2 - this.getWidth() / 2, 0);
        this.setLocation((frame.getWidth() - this.getWidth()) / 2, (frame.getHeight() - this.getHeight()) / 2);
    }

}
