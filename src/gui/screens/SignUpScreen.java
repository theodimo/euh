package gui.screens;

import api.Database;
import gui.components.Button;
import gui.components.PasswordField;
import gui.components.TextField;

import static gui.bootstrap.Colors.*;
import static gui.bootstrap.Colors.secondaryColor;

/**This is the screen in which a new user can sign up
 * in the application. The data of the user are used
 * to create an instance of the User class which is saved
 * in the database. If the credentials are valid the user
 * can proceed to the next page of the program. The user
 * also has the ability to go in the Log-In screen if he
 * already has an account.
 *
 * @author tzikaman
 */

public class SignUpScreen extends SignTemplate{

    TextField nameField = new TextField(250,50,primaryColor,secondaryColor,accentColor,secondaryColor,"name");
    TextField surnameField = new TextField(250,50,primaryColor,secondaryColor,accentColor,secondaryColor,"surname");
    TextField usernameField = new TextField(250,50,primaryColor,secondaryColor,accentColor,secondaryColor,"username");
    PasswordField passwordField = new PasswordField(250,50,primaryColor,secondaryColor,accentColor,secondaryColor,"password");
    PasswordField validatePasswordField = new PasswordField(250,50,primaryColor,secondaryColor,accentColor,secondaryColor,"validate password");

    Button signUpButton = new Button("Sign Up",100,50,accentColor,secondaryColor);
    Button backButton = new Button("Back",100,50,accentColor,secondaryColor);

    Database api = new Database();
        public SignUpScreen(String title) {
        super(title,5);

        this.fieldsPanel.add(nameField);
        this.fieldsPanel.add(surnameField);
        this.fieldsPanel.add(usernameField);
        this.fieldsPanel.add(passwordField);
        this.fieldsPanel.add(validatePasswordField);

        backButton.addActionListener(e -> {
            dispose();
            new LogInScreen("Log In Screen");
        });
        this.buttonsPanel.add(backButton);

        signUpButton.addActionListener(e -> {
            String name = nameField.getText();
            String surname = surnameField.getText();
            String username = usernameField.getText();
            String password = String.valueOf(passwordField.getPassword());
            String validatePassword = String.valueOf(validatePasswordField.getPassword());

            if(api.validateSignUpCredentials(username,password,validatePassword)){
                api.createUser(name,surname,username,password,"user");
                System.out.println("hello");
            }


        });
        this.buttonsPanel.add(signUpButton);

        this.setVisible(true);
    }
}
