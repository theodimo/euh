package gui.screens;

import gui.bootstrap.Colors;
import gui.bootstrap.Fonts;
import gui.components.Panel;
import gui.components.Label;

import javax.swing.*;
import java.awt.*;

//This class is a template that will be used by the ui classes SignUpScreen & SignInScreen
//It contains code that both these classes have in common
//It creates a frame 1080x720, centers a panel where the content will be displayed, and applies styles

public class SignTemplate extends JFrame {


    private int width = 1080;
    private int height = 720;

    //components
    private Label titleLabel;
    Panel container;
    Panel fieldsPanel; //the panel that contains all fields and their labels
    Panel buttonsPanel; //the panel that contains the buttons, such as Sign Up etc




    public SignTemplate(String title) {
        //initialization
        this.setSize(this.width, this.height);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setLayout(null);

        //components
        this.container = new Panel(this.width / 2, this.height * 1 / 2, Colors.secondaryColor, 0, "size");
        this.container.setLayout(new BorderLayout());
        this.fieldsPanel = new Panel(this.container.getWidth(), this.container.getHeight() * 2 / 3, Colors.secondaryColor, 10, "preferredSize");
        this.buttonsPanel = new Panel(this.container.getWidth(), this.container.getHeight() * 1 / 3, Colors.secondaryColor, 0, "preferredSize");
        this.titleLabel = new Label(title, 450, 40, true);


        this.fieldsPanel.setLayout(null);
        this.buttonsPanel.setLayout(new FlowLayout());

        //styling
        this.getContentPane().setBackground(Colors.primaryColor);
        this.titleLabel.style(Colors.accentColor, Colors.secondaryColor, Fonts.titleFont);

        //additions
        this.getContentPane().add(this.container);
        this.getContentPane().add(this.titleLabel);
        this.container.add(this.fieldsPanel, BorderLayout.NORTH);
        this.container.add(this.buttonsPanel, BorderLayout.SOUTH);

        this.setVisible(true);

        //other functionality
        this.container.center(this);
        this.titleLabel.centerX(this, (this.container.getY() - this.getContentPane().getY() - this.titleLabel.getHeight()) / 2);
    }

    public static void main(String[] args) {
        SignTemplate p = new SignTemplate("Sign Up Screen");
    }
}
