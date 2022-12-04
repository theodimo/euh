package gui.screens;

import gui.bootstrap.Colors;
import gui.components.Panel;

import javax.swing.JFrame;
import java.awt.*;

//This class is a template that will be used by the ui classes SignUpScreen & SignInScreen
//It contains code that both these classes have in common
//It creates a frame 1080x720, centers a panel where the content will be displayed, and applies styles

public class SignTemplate extends JFrame {
    private int width = 1080;
    private int height = 720;

    Panel container;

    public SignTemplate() {
        //initialization
        this.setSize(this.width, this.height);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.container = new Panel(this.width / 2, this.height / 2, Colors.secondaryColor);
        this.container.center(this);

        //styling
        this.setSize(this.width, this.height);
        this.getContentPane().setBackground(Colors.primaryColor);

        //additions
        this.add(this.container);

        this.setVisible(true);

    }

    public static void main(String[] args) {
        SignTemplate p = new SignTemplate();
    }
}
