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
import java.util.Scanner;

public class Database {

    Account acc_object;
     Database() {
    }

    Database(Account acc_object) {
        this.acc_object = acc_object;
    }

    
    String getType() throws FileNotFoundException{
            File f=new File("database.txt");
            Scanner sc=new Scanner(f);
            String tmp="";
            while(sc.hasNextLine()){
                tmp=sc.nextLine();
                String []tr=tmp.split(",");
                if(this.acc_object.name.equals(tr[2])){
                    return tr[1];
                }
            }
        return "";
    }
    
    boolean isValid() throws FileNotFoundException { // check uniqness of username
            File f=new File("database.txt");
            Scanner sc=new Scanner(f);
            String tmp="";
            while(sc.hasNextLine()){
                tmp=sc.nextLine();
                String []tr=tmp.split(",");
                if(this.acc_object.name.equals(tr[2])){
                    return false;
                }
            }
            return true;
    }
    boolean verifyEmail(){
        String domain="";
        String company="";
        
        String tmp ="";
        
        for(int i=this.acc_object.email.length()-1;i>0;i--){
            if(this.acc_object.email.charAt(i) == '.'){
                domain =tmp;
                tmp="";
                i--;
            }else if(this.acc_object.email.charAt(i)=='@'){
                company = tmp;
                break;
            }
            tmp = this.acc_object.email.charAt(i) + tmp;
        }
        
        if(!domain.equals("com")){
            return false;
        }
        
        if ((!company.equals("gmail"))&&(!company.equals("yahoo"))&&(!company.equals("hotmail"))){
            return false;
        }
        
        
        return true;
    }
    boolean repeatedemails() throws FileNotFoundException{
                File f=new File("database.txt");
                Scanner sc=new Scanner(f);
               String tmp="";
            while(sc.hasNextLine()){
                tmp=sc.nextLine();
                String []tr=tmp.split(",");
                if(this.acc_object.email.equals(tr[3])){
                    return false;
                    
                }
            }
            return true;
    }
    boolean repeatedEmail() throws FileNotFoundException, IOException{
        BufferedReader br = new BufferedReader(new FileReader("database.txt"));
        
        while(br.ready()){
             if(acc_object.email.equals(br.readLine().split(",")[3])){

            return false;
            
            }
        }
        br.close();
        
        return true;
    }
    
    boolean register() throws FileNotFoundException, IOException {
        if (isValid() == false) {
            return false;
        }
        if(repeatedEmail()==false){
            return false;
        }
        if(repeatedemails()==false){
            return false;
        }
        int counter=0;
        File f2 = new File("database.txt");
        Scanner sc = new Scanner(f2);
        ArrayList<String>arr=new ArrayList<String>();
        String temp="";
        if(!sc.hasNext()){
            counter=0;
            temp="0";
        }
        
        else{
            while(sc.hasNextLine()){
                temp=sc.nextLine();
                arr.add(temp);
            }
            String [] t=temp.split(",");
            temp=t[0];
        }
        sc.close();
        counter=1+Integer.parseInt(temp);
        File f = new File("database.txt");
        PrintWriter p = new PrintWriter(f); // Writing the whole file from scratch
        for(int i=0;i<arr.size();i++){
            p.print(arr.get(i));
            p.println();
        }
        p.print(Integer.toString(counter));
        p.print(",");
        p.print(this.acc_object.type);
        p.print(",");
        p.print(this.acc_object.name);
        p.print(",");
        p.print(this.acc_object.email);
        p.print(",");
        p.print(this.acc_object.password);
        p.print(",");
        p.print(this.acc_object.gender);
        p.print(",");
        p.print(Integer.toString(this.acc_object.age));
        p.println();
        p.close();
        return true;
    }
    boolean login() throws FileNotFoundException{
        File f=new File("database.txt");
            Scanner sc=new Scanner(f);
            String tmp="";
            if(!sc.hasNext()){
                return false;
            }
            while(sc.hasNextLine()){
                tmp=sc.nextLine();
                String []tr=tmp.split(",");
                if((this.acc_object.name.equals(tr[2])/* || this.acc_object.email.equals(tr[3])*/) && this.acc_object.password.equals(tr[4])){
                    return true;
                    
                }
            }
            return false;
    }
}
