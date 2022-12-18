package gui.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Objects;
import static gui.bootstrap.Fonts.*;

/**
 * This is a custom class that extends JTextField and
 * implements FocusListener. It initializes and customizes
 * a TextField component
 *
 * @author tzikaman
 */
public class TextField extends JTextField implements FocusListener{

    private final Color idleBorderColor; //the color of the border when it is NOT interacted
    private final Color focusBorderColor; //the color of the border when it is interacted
    private final  Color backgroundColor; //the color of the field
    private final Color foregroundColor; //the color of the text in the field
    private final Color defaultMessageColor; //the color of the default text in the field
    private final String defaultMessage; //the text

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

        this.setFont(mainFont);
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
            this.setText(defaultMessage);
            this.setForeground(defaultMessageColor);
        }
    }

}
