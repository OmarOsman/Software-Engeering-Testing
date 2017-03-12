/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.ArrayList;

/**
 *
 * @author ESC
 */
public class Question {
    String question;
    int Qnum;
    ArrayList<String>results=new ArrayList<String>();

    Question(String a, int b ,   ArrayList<String> r) {
        question = a;
        Qnum  = b;
        results = r;
       
    }
    Question (){}

  
}
