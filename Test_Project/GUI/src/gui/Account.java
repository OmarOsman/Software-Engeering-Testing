/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author ESC
 */
public class Account {
    String name;
    String type;
    String password;
    String gender;
    String email;
    int age;
    int id;
    
    Account () {};
    Account (String t , String n , String e ,String p , String g , int a) {
        age = a;
        email = e;
        gender = g;
        password = p;
        type = t;
        name = n;
        
    }
    
    void set_name(String name){
        this.name = name;
    }
    void set_gender(String gender){
        this.gender = gender;
    }
    void set_age(int age){
        this.age = age;
    }
    void set_id(int id){
        this.id = id;
    }
    String get_name(){
        return this.name;
    }
    String get_gender(){
        return this.gender;
    }
    int get_age(){
        return this.age;
    }
    int get_id(){
        return this.id;
    }
    void set_password(String pass){
        this.password = pass;
    }
    String get_password(){
        return this.password;
    }
    void set_type(String t){
        this.type = t;
    }
    String get_type(){
        return this.type;
    }
    void set_email(String em){
        this.email = em;
    }
    String get_email(){
        return this.email;
    }
}
