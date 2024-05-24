
package pkgfinal.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Addtodatabase extends javax.swing.JFrame {
 
   
    public Addtodatabase() {
        initComponents();
        
    }
private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/login";
        String user = "root";
        String password = ""; // No password

        return DriverManager.getConnection(url, user, password);
    }
    




    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        buttonGradient1 = new swing.ButtonGradient();
        buttonGradient2 = new swing.ButtonGradient();
        buttonGradient3 = new swing.ButtonGradient();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jsavebutton = new swing.ButtonGradient();
        jyearfield = new javax.swing.JTextField();
        jratefield = new javax.swing.JTextField();
        jprodfield = new javax.swing.JTextField();
        jnamefield = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jdescfield = new javax.swing.JTextArea();
        uploadposter = new swing.ButtonGradient();
        jLabel9 = new javax.swing.JLabel();
        jGenrefield = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgfinal/project/tiny (1).png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 123, 85));

        buttonGradient1.setText("BACK");
        buttonGradient1.setColor1(new java.awt.Color(102, 0, 102));
        buttonGradient1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        buttonGradient1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGradient1ActionPerformed(evt);
            }
        });
        jPanel1.add(buttonGradient1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 20, 80, 27));

        buttonGradient2.setText("LOGOUT");
        buttonGradient2.setColor1(new java.awt.Color(102, 0, 102));
        buttonGradient2.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        buttonGradient2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGradient2ActionPerformed(evt);
            }
        });
        jPanel1.add(buttonGradient2, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 20, -1, 27));

        buttonGradient3.setText("X");
        buttonGradient3.setColor1(new java.awt.Color(102, 0, 102));
        buttonGradient3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        buttonGradient3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGradient3ActionPerformed(evt);
            }
        });
        jPanel1.add(buttonGradient3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 10, 46, 48));

        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("Movie information");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, -1, -1));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setText("Movie Name");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, -1, -1));

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 0));
        jLabel4.setText("Release Year");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 240, -1, -1));

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 0));
        jLabel5.setText("IMDB rate");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 320, -1, -1));

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 0));
        jLabel6.setText("Genre");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 390, -1, -1));

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 0));
        jLabel7.setText("Description");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 390, -1, -1));

        jsavebutton.setText("Upload");
        jsavebutton.setColor1(new java.awt.Color(102, 0, 102));
        jsavebutton.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jsavebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jsavebuttonActionPerformed(evt);
            }
        });
        jPanel1.add(jsavebutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 530, 570, 30));
        jPanel1.add(jyearfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 230, 180, 30));
        jPanel1.add(jratefield, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 310, 180, 30));
        jPanel1.add(jprodfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 310, 180, 30));
        jPanel1.add(jnamefield, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, 180, 30));

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 0));
        jLabel8.setText("Poster");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 460, -1, -1));

        jdescfield.setColumns(20);
        jdescfield.setRows(5);
        jdescfield.setText("\n");
        jScrollPane1.setViewportView(jdescfield);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 390, 190, 90));

        uploadposter.setText("CHOOSE FILE");
        uploadposter.setColor1(new java.awt.Color(255, 0, 0));
        uploadposter.setColor2(new java.awt.Color(102, 0, 102));
        uploadposter.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel1.add(uploadposter, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 440, 140, 50));

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 0));
        jLabel9.setText("Production Company");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, -1, -1));
        jPanel1.add(jGenrefield, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 380, 180, 30));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.jpg"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 610));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1091, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonGradient1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGradient1ActionPerformed
 this.dispose();
  new Recommendationsystem().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_buttonGradient1ActionPerformed

    private void buttonGradient2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGradient2ActionPerformed
 this.dispose();
 new Login().setVisible(true);
    }//GEN-LAST:event_buttonGradient2ActionPerformed

    private void buttonGradient3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGradient3ActionPerformed
     System.exit(0);
    }//GEN-LAST:event_buttonGradient3ActionPerformed

    private void jsavebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jsavebuttonActionPerformed
      
        String name = jnamefield.getText();
        String year = jyearfield.getText();
        String rate = jratefield.getText();
        String production = jprodfield.getText();
        String genre = jGenrefield.getText();
        String description = jdescfield.getText();

        if (name.isEmpty() || year.isEmpty() || rate.isEmpty() || production.isEmpty() || genre.isEmpty() || description.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String query = "INSERT INTO movies (name, year, imdbrate,  Prod, genre, description) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, name);
            pst.setString(2, year);
            pst.setString(3, rate);
            pst.setString(4, production);
            pst.setString(5, genre);
            pst.setString(6, description);

            int rowsInserted = pst.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Movie added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Failed to add movie", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
         // TODO add your handling code here:
    }//GEN-LAST:event_jsavebuttonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(Addtodatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Addtodatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Addtodatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Addtodatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Addtodatabase().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.ButtonGradient buttonGradient1;
    private swing.ButtonGradient buttonGradient2;
    private swing.ButtonGradient buttonGradient3;
    private javax.swing.JTextField jGenrefield;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jdescfield;
    private javax.swing.JTextField jnamefield;
    private javax.swing.JTextField jprodfield;
    private javax.swing.JTextField jratefield;
    private swing.ButtonGradient jsavebutton;
    private javax.swing.JTextField jyearfield;
    private swing.ButtonGradient uploadposter;
    // End of variables declaration//GEN-END:variables
}
