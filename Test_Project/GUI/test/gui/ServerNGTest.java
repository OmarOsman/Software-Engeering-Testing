/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author Omar
 */
public class ServerNGTest {
    
    public ServerNGTest() {
    }

   @DataProvider(name = "t3")
public static Object [][] AddGameData() {
    // type , name 
	return new Object [][] { 
            {true,"TF","boo7a"} ,  // TF game
            {true,"MCQ","mnoof"} ,   // MCQ game
            {false,"NoGame","mnoof"} , // game type doesn't exist game
            {false,"MCQ","mnoof"} // repeated game
                
        }; 
}
        
  @Test(dataProvider = "t3")
  public void AddGame (boolean r , String type , String name) {
        Account a = new Account();
        a.password = "123";
        a.name = "mostafa";
        a.email = "";
        ArrayList<Question> Q  =new ArrayList<>();
        ArrayList<String> res  =new ArrayList<>();
        res.add("Q1");
        Q.add(new Question (" this is a question ?",1,res));
        Game g = new Game(type,name ,"description",a, Q,"math");
        Server s = new Server(g);
        boolean result = false;
        try {
           s.addgame();
        } catch (IOException ex) {
            Logger.getLogger(ServerNGTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        try {
            result = s. getGameID() != -1;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ServerNGTest.class.getName()).log(Level.SEVERE, null, ex);
        }
	Assert.assertEquals(r,result);
  }     
           
}
   
