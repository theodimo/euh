package gui.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Objects;

/**
 * This is a custom class that extends JTextField and
 * implements FocusListener. It initializes and customizes
 * a TextField component
 *
 * @author tzikaman
 */
public class TextField extends JTextField implements FocusListener{

    private final Color idleBorderColor;
    private final Color focusBorderColor;
    private final  Color backgroundColor;
    private final Color foregroundColor;
    private final Color defaultMessageColor;
    private final String defaultMessage;

    public TextField(int width, int height,
                     Color backgroundColor, Color foregroundColor,
                     Color idleBorderColor, Color focusBorderColor,
                     String defaultMessage) {

        this.idleBorderColor = idleBorderColor;
        this.focusBorderColor = focusBorderColor;
        this.backgroundColor = backgroundColor;
        this.foregroundColor = foregroundColor;
        this.defaultMessageColor = idleBorderColor;
        this.defaultMessage = defaultMessage;

        this.setBackground(this.backgroundColor);
        this.setForeground(this.defaultMessageColor);

        this.setBorder(new RoundedLineBorder(idleBorderColor,1,10,true));
        this.setText(defaultMessage);
        this.setCaretColor(focusBorderColor);

        this.setFont(new Font("Rapor",Font.PLAIN,height*2/5));
        this.setPreferredSize(new Dimension(width, height));
        this.addFocusListener(this);
    }

    @Override
    public void focusGained(FocusEvent e) {
        this.setBorder(new RoundedLineBorder(focusBorderColor,1,10,true));

        if(Objects.equals(getText(), defaultMessage)){
            this.setText("");
            this.setForeground(foregroundColor);
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        this.setBorder(new RoundedLineBorder(idleBorderColor,1,10,true));

        if(Objects.equals(this.getText(), "")){
            this.setText("username");
            this.setForeground(defaultMessageColor);
        }
    }

}
