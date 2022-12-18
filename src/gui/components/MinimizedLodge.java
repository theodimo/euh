package gui.components;

import javax.swing.*;
import java.awt.*;

import static gui.bootstrap.Colors.*;
import static gui.bootstrap.Fonts.mainFont;
import static gui.bootstrap.Icons.placeholder;

public class MinimizedLodge extends JPanel {

    private JButton maximizeButton = new JButton();
    private JButton editButton = new JButton();
    private JButton deleteButton = new JButton();

    public MinimizedLodge(int width, int height, String name, String type, String location, Color backgroundColor, Color foregroundColor, Color borderColor){
        this.setPreferredSize(new Dimension(width,height));
        this.setLayout(new FlowLayout(FlowLayout.CENTER,5,10));
        this.setBackground(backgroundColor);
        this.setForeground(foregroundColor);
        //this.setBorder(new RoundedLineBorder(borderColor, 1, 10, true));

        JLabel lodgeName = createNewLabel(name, mainFont, 200, height-20, Color.white, secondaryColor);
        JLabel lodgeType = createNewLabel(type, mainFont, 100, height-20, Color.white, secondaryColor);
        JLabel lodgeLocation = createNewLabel(location, mainFont, 100, height-20, Color.white, secondaryColor);
        JLabel lodgeRating = createNewLabel("rating", mainFont, 80, height-20, Color.lightGray, secondaryColor);

        maximizeButton.setIcon(placeholder);
        maximizeButton.setBackground(Color.magenta);
        maximizeButton.setPreferredSize(new Dimension(40,40));
        maximizeButton.addActionListener(e -> {
            //new MaximizedLodge(lodge);
            //this.dispose();
        });

        editButton.setIcon(placeholder);
        editButton.setPreferredSize(new Dimension(30,30));

        deleteButton.setIcon(placeholder);
        deleteButton.setPreferredSize(new Dimension(30,30));


        this.add(lodgeName);
        this.add(lodgeType);
        this.add(lodgeLocation);
        this.add(lodgeRating);

        this.addMaximizeButton();
        this.addEditButtons();
    }

    private JLabel createNewLabel(String text, Font font, int width, int height, Color backgroundColor, Color foregroundColor){
        JLabel tempLabel = new JLabel(text, SwingConstants.CENTER);
        tempLabel.setFont(font);
        tempLabel.setPreferredSize(new Dimension(width, height));
        tempLabel.setBackground(backgroundColor);
        tempLabel.setOpaque(true);

        return tempLabel;
    }

    public void addMaximizeButton(){
        this.add(maximizeButton);

    }

    public void addEditButtons(){
        this.add(editButton);
        this.add(deleteButton);
    }
}
