package gui.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class ComboBox extends JComboBox implements FocusListener {
    private Color backgroundColor;
    private Color foregroundColor;
    private Color idleBorderColor;
    private Color focusBorderColor;

    public ComboBox(int width, int height, String[] values) {
        super(values);
        this.setPreferredSize(new Dimension(width, height));
        this.setFocusable(false);

        //add listeners
        this.addFocusListener(this);
    }

    public void style(Color backgroundColor, Color foregroundColor, Color idleBorderColor, Color focusBorderColor, Font font) {
        this.backgroundColor = backgroundColor;
        this.foregroundColor = foregroundColor;
        this.idleBorderColor = idleBorderColor;
        this.focusBorderColor = focusBorderColor;

        this.setBackground(this.backgroundColor);
        this.setForeground(this.foregroundColor);
        this.setFont(font);
        this.setBorder(new RoundedLineBorder(this.idleBorderColor,1,10,true));
    }

    /**
     * Invoked when a component gains the keyboard focus.
     *
     * @param e the event to be processed
     */
    @Override
    public void focusGained(FocusEvent e) {
        this.setBorder(new RoundedLineBorder(this.focusBorderColor,1,10,true));
    }

    /**
     * Invoked when a component loses the keyboard focus.
     *
     * @param e the event to be processed
     */
    @Override
    public void focusLost(FocusEvent e) {
        this.setBorder(new RoundedLineBorder(this.idleBorderColor,1,10,true));
    }
}
