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
public class System2NGTest {
    
    public System2NGTest() {
    }
    @DataProvider(name = "t4")
    public static Object [][] PlayGameData() {
    //  game name 
	return new Object [][] { 
            {true,"org"} ,  // TF game
            {true,"Mcq"},   // MCQ game
            {false,"shiko"} // non existent game
        }; 
}
        
  @Test(dataProvider = "t4")
  public void PlayGame (boolean r ,String name) {
        Game g = new Game();     
        g.gamename= name;
        Server s2 = new Server(g);
        try {
            String desc = s2.getGameDisc();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(System2NGTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        System2 s = new System2(s2);
        ArrayList<Question> questions = null;
        try {
            questions = s.playGame();
        } catch (IOException ex) {
            Logger.getLogger(System2NGTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        boolean result =  !questions.isEmpty();
	Assert.assertEquals(r,result);
  }     
    
}
