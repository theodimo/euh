package gui.components;

import javax.swing.*;
import java.awt.*;

import static gui.bootstrap.Fonts.*;

/**This is a simple button class which extends JButton
 *
 * @author tzikaman
 */
public class Button extends JButton {
    public Button(String text, int width, int height, Color backgroundColor, Color foregroundColor){

        this.setText(text);

        //styling
        this.setFont(buttonFont);
        this.setBackground(backgroundColor);
        this.setForeground(foregroundColor);
        this.setPreferredSize(new Dimension(width, height));

        this.setBorder(BorderFactory.createLineBorder(foregroundColor,2));
    }
}
