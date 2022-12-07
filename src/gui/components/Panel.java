package gui.components;


import gui.screens.SignTemplate;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {
     private int horizontalPadding;
     private int nextYPos; //the position in Y axis of the component that will be added next


     /**
     * Constructor of Panel. Creates a new Panel with the given properties
     * @param width: The width of the panel
     * @param height The height of the panel
     * @param backgroundColor The background color of the panel
     * @param sizeType: Either 'size' or 'preferredSize'. Some panels need their size to be set differently based on
     * whether the frame/panel where they are added has a layout or not.
     */
    public Panel(int width, int height, Color backgroundColor, int horizontalPadding, String sizeType) {
        if (sizeType.equals("size")) {
            this.setSize(width, height);
        } else if (sizeType.equals("preferredSize")){
            this.setPreferredSize(new Dimension(width, height));
        }
        this.setBackground(backgroundColor);
        this.setOpaque(true);
        this.horizontalPadding = horizontalPadding;
        this.nextYPos = this.getY();
    }

    /**
     * Centers the panel inside of the given frame
     * @param frame: The frame which we want to center the panel in
     */
    public void center(SignTemplate frame) {
        int w = (int) this.getSize().getWidth();
        int h = (int) this.getSize().getHeight();
        int W = frame.getContentPane().getWidth();
        int H = frame.getContentPane().getHeight();
        this.setLocation((W - w) / 2, (H - h) / 2);
    }

     /**
     * Adds the given component (Label, JTextField, JPasswordField) to the panel, at the next available position in the flow.
     * This position is computing by adding to the nextYPos the desirable padding for the Y axis, and by adding the panel's
     * horizontal padding to the default position of the component
     * @param component: The component that is going to be placed in the panel
     */
    public void addComponent(Component component, int verticalPadding) {
        this.add(component);
        component.setLocation(this.horizontalPadding, this.nextYPos + verticalPadding);
        this.nextYPos += component.getHeight() + verticalPadding;
    }

}
