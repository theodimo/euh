package gui.components;


import gui.screens.SignTemplate;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {
     /**
     * Constructor of Panel. Creates a new Panel with the given properties
     * @param width: The width of the panel
     * @param height The height of the panel
     * @param backgroundColor The background color of the panel
     * @param sizeType Either 'size' or 'preferredSize'. Some panels need their size to be set differently based on
     * whether the frame/panel where they are added has a layout or not.
     */
    public Panel(int width, int height, Color backgroundColor, String sizeType) {
        if (sizeType.equals("size")) {
            this.setSize(width, height);
        } else if (sizeType.equals("preferredSize")){
            this.setPreferredSize(new Dimension(width, height));
        }
        this.setBackground(backgroundColor);
        this.setOpaque(true);
    }

}
