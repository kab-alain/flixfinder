
package pkgfinal.project;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Recommendationsystem extends javax.swing.JFrame {
    private Connection connection = null;
    private PreparedStatement statement = null;
    private ResultSet result;
    private JTextField nameField;
    //private JTextArea jdescription;
    

    public Recommendationsystem() {
        initComponents();

        connection = getConnection();
        nameField = new JTextField(20);

        jsearch.addActionListener((ActionEvent e) -> {
            String searchTerm = jsearchfield.getText();
            displayImage(searchTerm);
        });
    
        //Getrecommendation.addActionListener((ActionEvent e) -> {
           // getRecommendations();
        //getRecommendations();});
        jdisplayrecommendation.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    String selectedMovie = jdisplayrecommendation.getSelectedValue();
                    if (selectedMovie != null) {
                        displayImage(selectedMovie);
                    }
                }
            }
        });
    

    }
private void getRecommendations() {
        try {
            String selectedYear = jComboyear.getSelectedItem().toString();
            String selectedGenre = jCombogenre.getSelectedItem().toString();

            statement = connection.prepareStatement(
                "SELECT name FROM movies WHERE year >= ? AND genre LIKE ?"
            );
            statement.setString(1, selectedYear);
            statement.setString(2, "%" + selectedGenre + "%");
            result = statement.executeQuery();

            DefaultListModel<String> listModel = new DefaultListModel<>();
            while (result.next()) {
                String movieName = result.getString("name");
                listModel.addElement(movieName);
            }
            jdisplayrecommendation.setModel(listModel);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


     private void displayImage(String name) {
    try {
        statement = connection.prepareStatement("SELECT image, name, year, imdbrate, prod, description FROM movies WHERE name = ?");
        statement.setString(1, name);
        result = statement.executeQuery();
        
        if (!result.isBeforeFirst()) { 
            displayNoImageFoundMessage();
            return;
        }
        byte[] image = null;
        String actualName = "";
        int releaseYear = 0;
        double rate = 0;
        String prod = "";
        String description = "";
        
        while (result.next()) {
            image = result.getBytes("image");
            actualName = result.getString("name");
            releaseYear = result.getInt("year");
            rate = result.getDouble("imdbrate");
            prod = result.getString("prod");
            description = result.getString("description");
        }

        if (image != null && actualName.equalsIgnoreCase(name)) {
            Image img = Toolkit.getDefaultToolkit().createImage(image);
            ImageIcon icon = new ImageIcon(img);
            jimage.setIcon(icon);

            jname.setText(actualName);
            jyear.setText("" + releaseYear);
            jrating.setText("" + rate);
            jprod.setText("" + prod);
            displaydescription.setText(description); // Set the description in the JTextArea

            revalidate();
            repaint();
        } else {
            displayNoImageFoundMessage();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

private void displayNoImageFoundMessage() {
    // Clear the previous movie details
    jimage.setIcon(null);
    jname.setText("");
    jyear.setText("");
    jrating.setText("");
    jprod.setText("");
    displaydescription.setText("");

    // Show a message dialog to indicate no image was found
    javax.swing.JOptionPane.showMessageDialog(this, "No Movie found with the given name.", "No Results", javax.swing.JOptionPane.INFORMATION_MESSAGE);
}
   

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/login", "root", "");
        } catch (Exception e) {
            System.out.println("Error OccurredWhile Getting the Connection: " + e);
        }
        return connection;
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jsearchfield = new javax.swing.JTextField();
        jsearch = new swing.ButtonGradient();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboyear = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jCombogenre = new javax.swing.JComboBox<>();
        Getrecommendation = new swing.ButtonGradient();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        buttonGradient1 = new swing.ButtonGradient();
        jScrollPane1 = new javax.swing.JScrollPane();
        jdisplayrecommendation = new javax.swing.JList<>();
        buttonGradient4 = new swing.ButtonGradient();
        buttonGradient3 = new swing.ButtonGradient();
        jimage = new javax.swing.JLabel();
        jname = new javax.swing.JLabel();
        jyear = new javax.swing.JLabel();
        jrating = new javax.swing.JLabel();
        jprod = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        displaydescription = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgfinal/project/tiny (1).png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 125, 87));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 0));
        jLabel5.setText("search");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, 30));

        jsearchfield.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jPanel1.add(jsearchfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 170, 30));

        jsearch.setText("search");
        jsearch.setColor1(new java.awt.Color(102, 0, 102));
        jsearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jsearchActionPerformed(evt);
            }
        });
        jPanel1.add(jsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, -1, 20));

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("Get recommendations");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 190, 38));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setText("Release Year  >");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 110, 20));

        jComboyear.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jComboyear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2024", "2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", " ", " " }));
        jPanel1.add(jComboyear, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 90, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 0));
        jLabel4.setText("Genre");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, -1, -1));

        jCombogenre.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jCombogenre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Action", "Thriller", "Adventure", "Comedy", "Romance", "Indie", "Documentary", "Horror", "Crime", "Scifi", "Sport" }));
        jPanel1.add(jCombogenre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 90, 30));

        Getrecommendation.setText("Get Recommendations");
        Getrecommendation.setColor1(new java.awt.Color(102, 0, 102));
        Getrecommendation.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Getrecommendation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GetrecommendationActionPerformed(evt);
            }
        });
        jPanel1.add(Getrecommendation, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 250, 30));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("be part of our community's movie suggestions.");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 560, -1, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Join the conversation! Leave your movie recommendations and ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 540, -1, -1));

        buttonGradient1.setForeground(new java.awt.Color(255, 255, 0));
        buttonGradient1.setText("Leave Recommendations");
        buttonGradient1.setColor1(new java.awt.Color(102, 0, 102));
        buttonGradient1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        buttonGradient1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGradient1ActionPerformed(evt);
            }
        });
        jPanel1.add(buttonGradient1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 590, 320, 20));

        jdisplayrecommendation.setBackground(new java.awt.Color(0, 0, 0));
        jdisplayrecommendation.setFont(new java.awt.Font("Monospaced", 1, 16)); // NOI18N
        jdisplayrecommendation.setForeground(new java.awt.Color(255, 255, 0));
        jScrollPane1.setViewportView(jdisplayrecommendation);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 210, 140));

        buttonGradient4.setText("LOGOUT");
        buttonGradient4.setColor1(new java.awt.Color(102, 0, 102));
        buttonGradient4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buttonGradient4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGradient4ActionPerformed(evt);
            }
        });
        jPanel1.add(buttonGradient4, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 10, 100, 30));

        buttonGradient3.setText("X");
        buttonGradient3.setColor1(new java.awt.Color(102, 0, 102));
        buttonGradient3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGradient3ActionPerformed(evt);
            }
        });
        jPanel1.add(buttonGradient3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 10, 50, 40));
        jPanel1.add(jimage, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, 270, 310));

        jname.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jname.setForeground(new java.awt.Color(255, 255, 0));
        jPanel1.add(jname, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 460, 290, 40));

        jyear.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jyear.setForeground(new java.awt.Color(255, 255, 0));
        jPanel1.add(jyear, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 500, 60, 30));

        jrating.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jrating.setForeground(new java.awt.Color(255, 255, 0));
        jPanel1.add(jrating, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 530, 62, 20));

        jprod.setFont(new java.awt.Font("Trebuchet MS", 1, 22)); // NOI18N
        jprod.setForeground(new java.awt.Color(255, 255, 0));
        jPanel1.add(jprod, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 550, 250, 30));

        displaydescription.setBackground(new java.awt.Color(0, 0, 0));
        displaydescription.setColumns(20);
        displaydescription.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        displaydescription.setForeground(new java.awt.Color(255, 255, 255));
        displaydescription.setLineWrap(true);
        displaydescription.setRows(5);
        displaydescription.setWrapStyleWord(true);
        jScrollPane2.setViewportView(displaydescription);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 250, 330, 160));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home.jpg"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 620));

        jLabel9.setText("jLabel9");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonGradient4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGradient4ActionPerformed
   this.dispose();
  new Login().setVisible(true);
    }//GEN-LAST:event_buttonGradient4ActionPerformed

    private void buttonGradient3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGradient3ActionPerformed
System.exit(0);         // TODO add your handling code here:
    }//GEN-LAST:event_buttonGradient3ActionPerformed

    private void jsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jsearchActionPerformed
 String searchTerm = jsearchfield.getText();
 displayImage(searchTerm);        // TODO add your handling code here:
    }//GEN-LAST:event_jsearchActionPerformed

    private void GetrecommendationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GetrecommendationActionPerformed
     getRecommendations();        // TODO add your handling code here:
    }//GEN-LAST:event_GetrecommendationActionPerformed

    private void buttonGradient1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGradient1ActionPerformed
    this.dispose();
    new Addtodatabase().setVisible(true);
    }//GEN-LAST:event_buttonGradient1ActionPerformed

    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Recommendationsystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Recommendationsystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Recommendationsystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Recommendationsystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Recommendationsystem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.ButtonGradient Getrecommendation;
    private swing.ButtonGradient buttonGradient1;
    private swing.ButtonGradient buttonGradient3;
    private swing.ButtonGradient buttonGradient4;
    private javax.swing.JTextArea displaydescription;
    private javax.swing.JComboBox<String> jCombogenre;
    private javax.swing.JComboBox<String> jComboyear;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> jdisplayrecommendation;
    private javax.swing.JLabel jimage;
    private javax.swing.JLabel jname;
    private javax.swing.JLabel jprod;
    private javax.swing.JLabel jrating;
    private swing.ButtonGradient jsearch;
    private javax.swing.JTextField jsearchfield;
    private javax.swing.JLabel jyear;
    // End of variables declaration//GEN-END:variables
}
