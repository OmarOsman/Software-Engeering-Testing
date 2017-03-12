package gui;

import java.util.ArrayList;

public class Game {
    String gamename;
    String gametype;
    int rate;
    String description;
    String category;
    
    int game_id;
    Account ac;
    Student student;
    ArrayList<Question>Qarr;
    Game(){
        
    }
    Game(String gametype,String gamename,String description , Account a,ArrayList<Question>arr,String category){        //Create game
        this.gamename = gamename;
        this.gametype = gametype;
        this.description = description;
        ac = a;
        this.Qarr=arr;
        this.category = category;
    }
    Game(String gamename){                  //Try Game
        this.gamename = gamename;
    }
    
    Game(String gamename,Student s){   // play
        this.gamename = gamename;
        this.student = s;
        
    }
    
    void setrate(int rate){
        this.rate = rate;
    }
    int getrate(){
       return this.rate;
    }
    
}

