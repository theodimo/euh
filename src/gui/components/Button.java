package gui.components;

import javax.swing.*;
import java.awt.*;

public class Button extends JButton {
    public Button(String text, int width, int height, Color backgroundColor, Color foregroundColor){
        this.setText(text);
        this.setFont(new Font("Rapor", Font.BOLD,height*2/5));
        this.setBackground(backgroundColor);
        this.setForeground(foregroundColor);
        this.setPreferredSize(new Dimension(width, height));

        this.setBorder(BorderFactory.createLineBorder(foregroundColor,2));
    }
}
