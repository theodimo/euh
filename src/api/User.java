package api;

import gui.screens.SearchScreen;

import java.util.ArrayList;

public class User implements java.io.Serializable {
    private String name;
    private String surname;
    private String username;
    private String password;
    private String type;
    private ArrayList<Lodge> searchingHistory;

    public User(String name, String surname, String username, String password, String type) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.type = type;

        this.searchingHistory = new ArrayList<>();
    }

    //Getters
    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getUsername() {
        return this.username;
    }
    public String getPassword() {
        return this.password;
    }
    public String getType() {
        return this.type;
    }
    public void addRecentlyWatchedLodge(Lodge lodge){
        this.searchingHistory.add(lodge);
    }
    public void removeRecentlyWatchedLodge(Lodge lodge){
        this.searchingHistory.remove(lodge);
    }

    public ArrayList<Lodge> getSearchingHistory(){
        return this.searchingHistory;
    }

    public void printUserData() {
        System.out.println("Name: " + this.name);
        System.out.println("Surname: " + this.surname);
    }
}
