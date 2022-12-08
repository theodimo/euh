package gui.components;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;

public class Label extends JLabel {

     /**
     * Constructor of Label. Creates a new Label with the given properties
     * @param text: The text of the Label
     * @param width: The width of the Label
     * @param height: The height of the label
     * @param alignCenter: Whether or not we want to center the label
     */
    public Label(String text, int width, int height, boolean alignCenter) {
        super(text);
        this.setSize(width, height);
        if (alignCenter) {
            this.setHorizontalAlignment(0);
        }
    }

     /**
     * Styles the Label with the given style properties
     * @param background: The background color of the Label
     * @param foreground: The color of the text of the Label
     * @param font: The font of the text of the Label
     */
    public void style(Color background, Color foreground, Font font) {
        this.setBackground(background);
        this.setForeground(foreground);
        this.setFont(font);
        this.setOpaque(true);
    }

     /**
     * Horizontally centers the Label inside the given frame
     * @param frame: the frame in which the label will be centered horizontally
     * @param y: the point at the y-axis where the label will be placed
     */
    //centers the label at the x-axis and sets the y coordinate to the given coordinate
    public void centerX(JFrame frame, int y) {
        this.setLocation((frame.getContentPane().getWidth() - this.getWidth()) / 2, y);
    }
}
