/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.*;
import static java.lang.System.arraycopy;
import java.util.Arrays;
import static javafx.scene.input.KeyCode.T;
/**
 *
 * @author ESC
 */
public class GUI {

static boolean emptyfile() throws FileNotFoundException, IOException{
        BufferedReader br = new BufferedReader(new FileReader("games.txt"));
        
        if(br.readLine()!=null){  
            return false;
        }
        br.close();
        
        return true;
    }
        
    public static ArrayList<String> shuffle(ArrayList<String> arr){
        Collections.shuffle(arr);
        return arr;
    }
    
 
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        
        new Register();
        
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1 for register & Enter 2 for login : ");  
        int choice = sc.nextInt();
        if(choice==1){
 
            
            System.out.println("Enter Username : ");
            String name = sc.next();
            System.out.println("Enter Email : ");
            String email = sc.next();
            
            System.out.println("Enter Password : ");
            String password = sc.next();
            System.out.println("Enter Gender : ");
            String gender = sc.next();
            System.out.println("Enter age : ");
            int age = sc.nextInt();
            System.out.println("Enter type : ");
            String type = sc.next();
            Account a = new Account();
            a.age = age;
            a.email = email;
            a.gender = gender;
            a.password = password;
            a.type = type;
            a.name = name;
            
            Database db = new Database(a);
            
            boolean result = db.register();
            if(result == false){
                 System.out.println("re enter fields");
            }else{
                System.out.println("successfully register");
            }
            db.login();
            
        }else{
            
            System.out.println("Enter Username : ");
            String name = sc.next();
            
            System.out.println("Enter Password : ");
            String password = sc.next();
            Account a = new Account();
            a.password = password;
            a.name = name;
            a.email = "";
            Database db = new Database(a);
            
            boolean login = db.login();
            
            
            if(login){
                System.out.println("Successfully Login");
            
                if (db.getType().equals("S")){
                    System.out.println("You are Student");
                    Game g = new Game();
                    
                    Server s2 = new Server();
                    
                    System.out.println("Game Categories available are Math and Programming");
                    System.out.println("Enter game category");
                    
                    String cat=sc.next();
                    g.category=cat;
                    s2.gameobject=g;
                    ArrayList<String> arro=s2.getGameWithCat(); 
                    for(int i=0;i<arro.size();i++){
                        System.out.println(arro.get(i));
                    }
                     System.out.println("Enter game name : ");
                     sc.nextLine();
                     String game = sc.nextLine();
                     g.gamename=game;
                     s2.gameobject=g;
                     String desc=s2.getGameDisc();
                     System.out.println(desc);
                     
                     System2 s = new System2(s2);
                     
                     ArrayList<Question> questions = s.playGame();
                     ArrayList<String> tempResults = new ArrayList<String>();
                     ArrayList<String> Ans=new ArrayList<String>();
                     int score=0;
                     
                     if(questions.get(0).results.size() > 2){
                         for(int i=0;i<questions.size();i++){
                             String[] arr = new String[questions.get(i).results.size()];
                             String[] arr2 = new String[questions.get(i).results.size()];
                             arr = questions.get(i).results.toArray(arr);
                             arraycopy(arr, 0, arr2, 0,questions.get(i).results.size());
                             tempResults = new ArrayList<String>(Arrays.asList(arr2));
                             System.out.println(questions.get(i).Qnum+" )"+questions.get(i).question);
                             shuffle(tempResults);
                             for(int j = 0; j<4;j++){
                                 System.out.println( j+1 + ") "+tempResults.get(j));
                             }
                             String result = sc.nextLine();
                             Ans.add(result);
                         }
                         for(int i=0;i<Ans.size();i++){
                             if(Ans.get(i)==questions.get(i).results.get(0)){
                                 score++;
                             }
                         }
                         
                     }
                      else{
                         for(int i=0;i<questions.size();i++){
                              String[] arr = new String[questions.get(i).results.size()];
                             String[] arr2 = new String[questions.get(i).results.size()];
                             arr = questions.get(i).results.toArray(arr);
                             arraycopy(arr, 0, arr2, 0,questions.get(i).results.size());
                             tempResults = new ArrayList<String>(Arrays.asList(arr2));
                             System.out.println(questions.get(i).Qnum+" )"+questions.get(i).question);  
                             shuffle(tempResults);
                             for(int j = 0; j<2;j++){
                                 System.out.print( j+1 + ") "+tempResults.get(j)+"  ");
                             }
                             System.out.println("Enter the answer:");
                             String result = sc.nextLine();
                             Ans.add(result);
                         }
                         for(int i=0;i<Ans.size();i++){
                             if(Ans.get(i).equals(questions.get(i).results.get(0))){
                                 score++;
                             }
                         }
                         
                     }
                     System.out.println("Your score is "+score);
                     s2.storeScore(a.name, score);
                    
                }else{
                    System.out.println("You are teacher");
                    int u ; 
                    System.out.println("Enter 1 to addG , 2 to try");
                    u = sc.nextInt();
                    if(u == 1){
                        System.out.println("Enter game category");
                        sc.nextLine();
                        String category = sc.nextLine();
                        System.out.println("Enter game name : ");
                        String gamename = sc.nextLine();
                        System.out.println("Enter game description : ");
                        String desc = sc.nextLine();
                        
                        System.out.println("Enetr type");
                        String t = sc.next();
                        
                        ArrayList<Question> questions = new ArrayList<Question>();
                        ArrayList<String> results = new ArrayList<String>();
               
                        if(t.equals("TF")){
                            System.out.println("Enter number of question : " );
                            int numofquestions = sc.nextInt();
                            
                            for(int i=0;i<numofquestions;i++){
                                sc.nextLine();
                                System.out.println("Enter question : " );
                                String temp = sc.nextLine();
                                Question q = new Question();
                                q.question = temp;
                                q.Qnum = i+1;
                                for(int j=0;j<2;j++){
                                    System.out.println("Enter the answer : " );
                                    temp = sc.next();
                                    results.add(temp);
                                }
                                q.results = results;
                                questions.add(q);
                            }
                    }else if(t.equals("MCQ")){
                            System.out.println("Enter number of question : " );
                            int numofquestions = sc.nextInt();
                            for(int i=0;i<numofquestions;i++){
                                sc.nextLine();
                                System.out.println("Enter question : " );
                                String temp = sc.nextLine();
                                Question q = new Question();
                                q.question = temp;
                                q.Qnum = i+1;
                                for(int j=0;j<4;j++){
                                    System.out.println("Enter the answer : " );
                                    temp = sc.next();
                                    results.add(temp);
                                }
                                q.results = results;
                                questions.add(q);
                            }
                    }
                
                     Game g = new Game(t , gamename , desc , a,  questions,category);
                     Server s = new Server(g);
                     s.addgame();
                     
                }else{
         
                    Game g = new Game();
                    
                    Server s2 = new Server();
                    
                    System.out.println("Game Categories available are Math and Programming");
                    System.out.println("Enter game category");
                    
                    String cat=sc.next();
                    g.category=cat;
                    s2.gameobject=g;
                    
                    ArrayList<String> arro=s2.getGameWithCat(); 
                    for(int i=0;i<arro.size();i++){
                        System.out.println(arro.get(i));
                    }
                    
                    System.out.println("Enter game name : ");
                     sc.nextLine();
                     String game = sc.nextLine();
                      g.gamename=game;
                     s2.gameobject=g;
                     String desc=s2.getGameDisc();
                     System.out.println(desc);
                     
                     System2 s = new System2(s2);
                     
                     ArrayList<Question> questions = s.playGame();
                     ArrayList<String> tempResults = new ArrayList<String>();
                     ArrayList<String> Ans=new ArrayList<String>();
                     int score=0;
                     
                     if(questions.get(0).results.size() > 2){
                         for(int i=0;i<questions.size();i++){
                            String[] arr = new String[questions.get(i).results.size()];
                             String[] arr2 = new String[questions.get(i).results.size()];
                             arr = questions.get(i).results.toArray(arr);
                             arraycopy(arr, 0, arr2, 0,questions.get(i).results.size());
                             tempResults = new ArrayList<String>(Arrays.asList(arr2));
                             System.out.println(questions.get(i).Qnum+" )"+questions.get(i).question);  
                             shuffle(tempResults);
                             for(int j = 0; j<4;j++){
                                 System.out.print( j+1 + ") "+tempResults.get(j)+"  ");
                             }
                             String result = sc.nextLine();
                             Ans.add(result);
                         }
                         for(int i=0;i<Ans.size();i++){
                             if(Ans.get(i)==questions.get(i).results.get(0)){
                                 score++;
                             }
                         }
                         
                     }
                     else{
                         for(int i=0;i<questions.size();i++){
                              String[] arr = new String[questions.get(i).results.size()];
                             String[] arr2 = new String[questions.get(i).results.size()];
                             arr = questions.get(i).results.toArray(arr);
                             arraycopy(arr, 0, arr2, 0,questions.get(i).results.size());
                             tempResults = new ArrayList<String>(Arrays.asList(arr2));
                             System.out.println(questions.get(i).Qnum+" )"+questions.get(i).question);  
                             shuffle(tempResults);
                             for(int j = 0; j<2;j++){
                                 System.out.print( j+1 + ") "+tempResults.get(j)+"  ");
                             }
                             System.out.println("Enter the answer:");
                             String result = sc.nextLine();
                             Ans.add(result);
                         }
                         for(int i=0;i<Ans.size();i++){
                             if(Ans.get(i).equals(questions.get(i).results.get(0))){
                                 score++;
                             }
                         }
                         System.out.println("Your score is "+score);
                     }
                     
                }
            
            
            }
            
        }
        
            else{
                System.out.println("ReEnter Login");
            }
        
      
        
    }
    
}
}