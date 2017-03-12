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
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ESC
 */
public class System2 {
    Server serverobject;
    System2(Server serverobject){
        this.serverobject=serverobject;
    }
    
    ArrayList<Question> playGame() throws FileNotFoundException, IOException{
        int id = serverobject.search();
        if (id == -1){
            return null;
        }
        FileReader file = new FileReader("games.txt");
        BufferedReader br = new BufferedReader(file);
        
        String type="";
        while(br.ready()){
            String tmp = br.readLine();
            if(id == Integer.parseInt(tmp.split(",")[0])){
                type = tmp.split(",")[2];
            }
        }
        br.close();
        
        // Test Addition
        String cur = "E:\\College\\Third Year\\Sec Term\\SW 2\\Project\\swe review\\CS251-OmarKhaled-20140267-Phase3-GUIVersion-0.4\\CS251-OmarKhaled-20140267-Phase3-GUIVersion 0.2.1\\GUI\\games";
        //String cur="C:\\Users\\ESC1\\Documents\\NetBeansProjects\\GUI\\games\\";
       
       if(System.getProperty("os.name").startsWith("Windows")){
           cur = ".\\games\\";
       }else {
           cur = "./games/";
       }
        
        FileReader f = new FileReader(cur+Integer.toString(id)+".txt");
        
        br = new BufferedReader(f);
        
        ArrayList<String> question = new ArrayList<String>();
        
        ArrayList<Question> questions = new ArrayList<Question>();
        
        while(br.ready()){
            String tmp = br.readLine();
            question.add(tmp);
        }
        
        br.close();
        
        if(type.equals("TF")){
            
            for(int i =0 ; i<question.size();i++){
                Question q = new Question();
                q.Qnum = i+1;
                q.question = question.get(i).split(",")[1];
                q.results.add(question.get(i).split(",")[2]);
                q.results.add(question.get(i).split(",")[3]);
                questions.add(q);
            }
            
        }else{
            
            for(int i =0 ; i<question.size();i++){
                Question q = new Question();
                q.Qnum = i+1;
                q.question = question.get(i).split(",")[1];
                
                q.results.add(question.get(i).split(",")[2]);
                q.results.add(question.get(i).split(",")[3]);
                q.results.add(question.get(i).split(",")[4]);
                q.results.add(question.get(i).split(",")[5]);
  
                questions.add(q);
            }
            
        }
        return questions;
    }
    
    
    
    
    
}