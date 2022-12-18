package gui.screens;

import api.Lodge;
import api.User;
import gui.components.Button;
import gui.components.MinimizedLodge;
import gui.components.RoundedLineBorder;
import gui.components.TextField;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static gui.bootstrap.Colors.*;

public class SearchScreen extends JFrame {
    User currentUser;
    ArrayList<Lodge> recentSearches = new ArrayList<>();

    TextField searchBar;
    Button searchButton;

    public SearchScreen(User currentUser){
        this.currentUser = currentUser;
        //this.currentUser.addRecentlyWatchedLodge(new Lodge("Blue Ocean","House", "Olympou 1","Thessaloniki",54365,"hello there"));
        //this.recentSearches = currentUser.getSearchingHistory();

        //initialization of Panels
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,0,100));
        searchPanel.setPreferredSize(new Dimension(1080,250));
        searchPanel.setBackground(Color.orange);
        this.add(searchPanel,BorderLayout.CENTER);


        JPanel recentSearchesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,0,35));
        recentSearchesPanel.setPreferredSize(new Dimension(1080,470));
        recentSearchesPanel.setBackground((Color.yellow));
        this.add(recentSearchesPanel,BorderLayout.SOUTH);

        JPanel minimizedLodgesContainer = new JPanel(new FlowLayout(FlowLayout.CENTER,0,25));
        minimizedLodgesContainer.setPreferredSize(new Dimension(1010,400));
        minimizedLodgesContainer.setBackground(Color.lightGray);
        recentSearchesPanel.add(minimizedLodgesContainer);


        //initialization of components
        searchBar = new TextField(500,50,Color.white,secondaryColor,accentColor,secondaryColor,"Search");
        searchButton = new Button("Search",100,50,characterColor,secondaryColor);

        MinimizedLodge lodge1 = new MinimizedLodge(800,60,"Blue Ocean","Hotel","Kalamaria",
                Color.white, secondaryColor,accentColor);
        MinimizedLodge lodge2 = new MinimizedLodge(800,60,"To tsantiri tou mitsou","Rooms to let","Platamon",
                Color.white, secondaryColor,accentColor);
        MinimizedLodge lodge3 = new MinimizedLodge(800,60,"H paragka tou Dimou","House","Velika",
                Color.white, secondaryColor,accentColor);

        //adding components to the frame
        searchPanel.add(searchBar);
        searchPanel.add(searchButton);

        minimizedLodgesContainer.add(lodge1);
        minimizedLodgesContainer.add(lodge2);
        minimizedLodgesContainer.add(lodge3);


        this.getRootPane().setDefaultButton(searchButton); //this will automatically listen to the "Enter" key
                                                           //and trigger the action listener of the given button

        this.setTitle("Search Screen");
        this.setSize(new Dimension(1080,720 + 48));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {

        new SearchScreen(new User("Dimitris", "Tzikas", "tzikaman", "1234", "provider"));
    }
}
