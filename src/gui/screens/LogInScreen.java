package gui.screens;

import api.Database;
import api.User;
import gui.components.Button;
import gui.components.PasswordField;
import gui.components.TextField;
import static gui.bootstrap.Colors.*;

/**This is the screen in which a user can Log In in
 * the application. The class checks if the given
 * credentials exist in the database and if they are
 * correct the user proceeds in the next screen of the
 * program. The user also has the ability to go in the
 * Sign-Up screen if he doesn't have an account.
 *
 * @author tzikaman
 */
public class LogInScreen extends SignTemplate {

    TextField usernameField = new TextField(250,50,primaryColor,secondaryColor,accentColor,secondaryColor,"username");
    PasswordField passwordField = new PasswordField(250,50,primaryColor,secondaryColor,accentColor,secondaryColor,"password");
    Button signInButton = new Button("Log In",100,50,accentColor,secondaryColor);
    Button backButton = new Button("Back",100,50,accentColor,secondaryColor);
    public LogInScreen(String title) {
        super(title,5);

        // add text fields to the screen
        this.fieldsPanel.add(usernameField);
        this.fieldsPanel.add(passwordField);

        // add action listeners in buttons
        // and add buttons to the screen
        backButton.addActionListener(e -> {
            dispose();
            new SignUpScreen("Sign Up Screen");
        });
        this.buttonsPanel.add(backButton);

        Database api = new Database();
        signInButton.addActionListener(e -> {

            String username = usernameField.getText();
            String password = String.valueOf(passwordField.getPassword());


            User user = api.getUser(api.validateSignInCredentials(username,password));
            System.out.println("Hello " + user.getName() + " " + user.getSurname());

            System.out.println(usernameField.getText());
            System.out.println(String.valueOf(passwordField.getPassword()));
        });
        this.buttonsPanel.add(signInButton);

        this.setVisible(true);
    }

    public static void main(String[] args) {

        LogInScreen p = new LogInScreen("Log In Screen");
    }

}
