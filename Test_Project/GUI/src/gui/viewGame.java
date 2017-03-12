package gui;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;

public class viewGame extends javax.swing.JFrame {

    String gamename="";
    String gamecat="";
    String desc = "";
    ArrayList<Question> questions ;
    ArrayList<String> results = new ArrayList<String>();
    int idx = 0;
    int score=0;
    String type = "";
    String uname = "";
    String upass = "";
    
    viewGame(String u  , String p , String a , String b, String c , String t) throws IOException{
        desc = a;
        gamename = b;
        gamecat = c;
        type = t;
        uname = u;
        upass = p;
        
        initComponents();
        groupButton();
        init();
    }
    
    public void setVars(String c , String a , String b , String t){
        gamename=a;
        gamecat=b;
        desc = c;
        type = t;
    }
    private void groupButton(){
        ButtonGroup group = new ButtonGroup();
        group.add(jRadioButton1);
        group.add(jRadioButton2);
    }

    public void init() throws FileNotFoundException, IOException{
        setLocation(450 ,100);
        setVisible(true);
        jLabel2.setText(gamename);
        jLabel1.setText(desc);
        // 
        Game g = new Game();  
        g.gamename=gamename;
        Server s2 = new Server();
        s2.gameobject=g;
        String desc = s2.getGameDisc();
        System2 s = new System2(s2);
        questions = s.playGame();
        //
        jLabel3.setText(questions.get(0).question);
        
        ArrayList <String > ans = shuffleArray(questions.get(0).results);
        
        jRadioButton1.setText(ans.get(0));
        jRadioButton2.setText(ans.get(1));
        
    }
    public viewGame() throws IOException {
        initComponents();
        groupButton();
        init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("nextQ");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1));

        jButton2.setText("Add Rate");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("Add Comment");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTextArea1.setBackground(new java.awt.Color(0, 0, 0));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea1.setRows(5);
        jTextArea1.setText("Click on Show Comments");
        jScrollPane2.setViewportView(jTextArea1);

        jButton5.setText("Show Comments");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addGap(35, 35, 35))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jRadioButton1)
                                .addGap(36, 36, 36)
                                .addComponent(jRadioButton2))
                            .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(jButton4))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(103, 103, 103)
                        .addComponent(jButton5)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jButton1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jRadioButton2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton2)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new playGame(uname , upass , type);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    static ArrayList<String> shuffleArray(ArrayList<String> ar)
    {
        ArrayList <String>ar2 = (ArrayList <String>) ar.clone();
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar2.size() - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            String a = ar2.get(index);
            ar2.set(index, ar2.get(i));
            ar2.set(i, a);
        }
        return ar2;
    }
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

     if (idx == questions.size()-1){
      if(jRadioButton1.isSelected() || jRadioButton2.isSelected()){
            if(jRadioButton1.isSelected()){
                
                
            if(jRadioButton1.getText().equals(questions.get(idx).results.get(0))){
               score+= 10; 
            }
            
            }else{
               
            if(jRadioButton2.getText().equals(questions.get(idx).results.get(0))){
               score+= 10; 
            }
            
            }
        
          try {
              Score sc = new Score(score , type,gamename,uname);
          } catch (IOException ex) {
              Logger.getLogger(viewGame.class.getName()).log(Level.SEVERE, null, ex);
          }
        this.dispose();
        
        
     }
      else{
           jLabel4.setText("require 1 answer");
      }
     }else{
        if(jRadioButton1.isSelected() || jRadioButton2.isSelected()){
            if(jRadioButton1.isSelected()){
                
                
            if(jRadioButton1.getText().equals(questions.get(idx).results.get(0))){
               score+= 10; 
            }
            
            }else{
               
            if(jRadioButton2.getText().equals(questions.get(idx).results.get(0))){
               score+= 10; 
            }
            
            }

            
            idx = idx+1;

            ArrayList <String> ans = shuffleArray(questions.get(idx).results);

            jLabel3.setText(questions.get(idx).question);
            jRadioButton1.setText(ans.get(0));
            jRadioButton2.setText(ans.get(1));
        
            
        }else{
            jLabel4.setText("require 1 answer");
        }
     
    }//GEN-LAST:event_jButton3ActionPerformed
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      Game g=new Game();
      g.gamename=gamename;
      g.category=gamecat;
      g.description=desc;
      Server s1=new Server(g);
        try {
            s1.addRate(uname, jSpinner1.getValue().toString());
        } catch (IOException ex) {
            Logger.getLogger(viewGame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
      Game g=new Game();
      g.gamename=gamename;
      g.category=gamecat;
      g.description=desc;
      Comments cr=new Comments();
      cr.gname=gamename;
      cr.sname=uname;
      cr.comment=jTextField2.getText();
      String temp="";
      Server s1=new Server(g);
      try {
            s1.addcomment(cr);
        } catch (IOException ex) {
            Logger.getLogger(viewGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if(s1.getRate(uname).equals("")){
                temp=uname+" :"+ "\n"+jTextField2.getText();
                
            }
            else{
                
                try {
                    temp=uname+" :"+"  "+ s1.getRate(uname) +"\n"+jTextField2.getText();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(viewGame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(viewGame.class.getName()).log(Level.SEVERE, null, ex);
        }
      jTextArea1.append(temp);
      jTextArea1.append("\n");
      jTextArea1.append("----------------------------------------");
      jTextArea1.append("\n");
      
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Game g=new Game();
        g.gamename=gamename;
        g.category=gamecat;
        g.description=desc;
        Server st=new Server(g);
        ArrayList<Comments>arr=null;
        try {
            arr = st.commOnGame();
        } catch (IOException ex) {
            Logger.getLogger(viewGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<String> record=new ArrayList<String>();
        String temp="";
        
        if(arr==null){
             jTextArea1.setText("");
        }
        else{
            for(int i=0;i<arr.size();i++){
                try {
                    
                    if(st.getRate(arr.get(i).sname).equals("")){
                        if(st.isTeacher(uname)==true){
                            temp=arr.get(i).sname+"* :"+ "\n"+arr.get(i).comment;
                        }
                        else{
                        temp=arr.get(i).sname+" :"+ "\n"+arr.get(i).comment;
                        }
                        record.add(temp);
                    }
                    else{
                        try {
                            if(st.isTeacher(uname)==true){
                            temp=arr.get(i).sname+"* :"+"  "+ st.getRate(arr.get(i).sname) +"\n"+arr.get(i).comment;
                            }
                            else{
                             temp=arr.get(i).sname+" :"+"  "+ st.getRate(arr.get(i).sname) +"\n"+arr.get(i).comment;
                            }
                             record.add(temp);
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(viewGame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                       
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(viewGame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            jTextArea1.setBackground(Color.white);
            jTextArea1.setForeground(Color.black);
            jTextArea1.setText("");
            jTextArea1.setEditable(false);
        for(int i=0;i<record.size();i++){
                 jTextArea1.append(record.get(i));
                 jTextArea1.append("\n");
                 jTextArea1.append("----------------------------------------------");
                 jTextArea1.append("\n");
        }
        }
    }//GEN-LAST:event_jButton5ActionPerformed
    
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(viewGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new viewGame().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(viewGame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}