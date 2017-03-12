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
 * @author Omar
 */
public class DatabaseNGTest {
    
    public DatabaseNGTest() {
    }
@DataProvider(name = "t1")
public static Object [][] SignUpData() {
    // type , name ,email,password , gender , age
	return new Object [][] { 
            {false,"S","amy","amy","12","Female",14} ,  // invalid email
            {false,"S","will","mostafa@yahoo.com","12","Male",14} ,   // repeated email
            {false,"S","mostafa","amy@hotmail.com","12","Female",14} ,    // repeated name
            {true,"S","bibo","sw@hotmail.com","12","Female",14} // valid test case
        }; 
}

@DataProvider(name = "t2")
public static Object [][] LogiInData() {
    // type , name ,email,password , gender , age
	return new Object [][] { 
            {false,"foo","12"} ,  //  non existen account
            {true,"mostafa","123"} ,   // account exisits
           
        }; 
}





@Test(dataProvider = "t1")
  public void SignUp(boolean r , String type , String name , String email ,String pass , String gender , int age) {
        Account a = new Account(type,name,email,pass,gender,age);
        Database db = new Database(a);
        boolean result = false;
        try {
           result = db.register();
        } catch (IOException ex) {
            Logger.getLogger(DatabaseNGTest.class.getName()).log(Level.SEVERE, null, ex);
        }
	Assert.assertEquals(r,result);
    //throw new RuntimeException("Test not implemented");
  }
  
  @Test(dataProvider = "t2")
  public void LogIn(boolean r , String name ,String pass) {
        Account a = new Account("",name,"",pass,"",0);
        Database db = new Database(a);
        boolean result = false;
        try {
            result = db.login();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DatabaseNGTest.class.getName()).log(Level.SEVERE, null, ex);
        }
	Assert.assertEquals(r,result);
    //throw new RuntimeException("Test not implemented");
  }


    
}
