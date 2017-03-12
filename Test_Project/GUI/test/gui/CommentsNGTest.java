/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author KHALED
 */
public class CommentsNGTest {
    
    public CommentsNGTest() {
    }
    
    @DataProvider(name = "comments")
public static Object [][] CommentData() {
    
	return new Object [][] 
            {
             {"Nice Game", "Nice Game" } ,
             {" " , " "} ,
             {"Bad Game", "Bad Game" }
            } ;
        
   
        }
             
         
    
   @Test (dataProvider = "comments") 
    public void testSomeMethod(String typed, String posted) {
        
            Game g=new Game();
            Comments cr = new Comments () ;
            cr.comment=typed ;
            Server s1=new Server(g);
            try {
            s1.addcomment(cr);
            } catch (IOException ex) {
            Assert.fail("faild to add comment");
            }  
            
            Assert.assertTrue(true);
            
          }
    
}
