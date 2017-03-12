package gui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;


public class playGame extends javax.swing.JFrame {

    
    int f = 0;
    
    String type = "";
    String uname="";
    String upass="";
    
    playGame(String a , String b ,String h){
        type = h;
        uname = a;
        upass= b;
        initComponents();
        init();
    }
    
    public void init(){
        jComboBox1.removeAllItems();     
        jComboBox1.addItem("Choose Category");
        jComboBox1.setSelectedItem("Choose Category");
        jComboBox1.addItem("math");
        jComboBox1.addItem("programming");
        jComboBox2.removeAllItems();        
        jComboBox2.addItem("Choose GameName");
        jComboBox2.setSelectedItem("Choose GameName");
        setLocation(450 ,100);
        setVisible(true);

    }
    public playGame() {
        initComponents();
        init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        submit = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 76, -1, -1));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 123, -1, -1));

        jLabel1.setText("category");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 79, -1, -1));

        jLabel2.setText("game");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 126, -1, -1));

        submit.setText("submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        getContentPane().add(submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 247, -1, -1));

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 4, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
       
    
            
        if(jComboBox1.getSelectedItem() != null){

            
                String str = (String)jComboBox1.getSelectedItem();
            
            if(str.equals("Choose Category")){

                jComboBox2.removeAllItems();
                jComboBox2.addItem("Choose GameName");
                jComboBox2.setSelectedItem("Choose GameName");

            }else{
            
            
                jComboBox2.removeAllItems();
                Game g = new Game();            
                Server s2 = new Server();

                g.category=(String)jComboBox1.getSelectedItem();
                s2.gameobject=g;

                ArrayList<String> arro ; 
                try {
                    arro = s2.getGameWithCat();
                    for(int i=0;i<arro.size();i++){
                        jComboBox2.addItem(arro.get(i));
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(playGame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } 
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        
        
        
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        
        String str = (String)jComboBox1.getSelectedItem();
        
        String str2 = (String)jComboBox2.getSelectedItem();
        
        if(!str.equals("Choose Category") && !str2.equals("Choose GameName") ){
        
            Game g = new Game();  
            
            g.gamename=(String)jComboBox2.getSelectedItem();
            
            Server s2 = new Server();
            s2.gameobject=g;
            String desc;
            try {
                desc = s2.getGameDisc();
                System2 s = new System2(s2);
                ArrayList<Question> questions = s.playGame();

                if(questions.get(0).results.size() <= 2){
                     new viewGame(uname  , upass , desc , (String)jComboBox2.getSelectedItem(), (String)jComboBox1.getSelectedItem() , type);
                    this.dispose();
                }else{
                    new viewGameMCQ(uname , upass , desc , (String)jComboBox2.getSelectedItem(), (String)jComboBox1.getSelectedItem() , type);
                    this.dispose();
                }


            } catch (FileNotFoundException ex) {
                Logger.getLogger(playGame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(playGame.class.getName()).log(Level.SEVERE, null, ex);
           } 

        }
        
    }//GEN-LAST:event_submitActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        if(type.equals("S")){
            new InteractS(uname , upass);
            this.dispose();
        }else{
            new InteractT(uname , upass);
            this.dispose();
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(playGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(playGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(playGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(playGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new playGame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables
}
