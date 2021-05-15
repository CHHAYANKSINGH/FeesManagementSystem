/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fees_management_system;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class Signup_Page extends javax.swing.JFrame {

    /**
     * Creates new form Signup_Page
     */
    String fname,lname,uname,password,con_pass,contact_no;
            Date dob;
    public Signup_Page() {
        initComponents();
    }
    public int getId()
    {
        ResultSet rs=null;
        int id = 0;
        try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
                Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/fees_management", "TCET","2001");
                String sql="select max(id) from signup";
                Statement st= con.createStatement();
                rs=st.executeQuery(sql);
                while(rs.next())
                {
                    id=rs.getInt(1);
                    id++;
                }
        } catch(Exception e)
        {
            e.printStackTrace();
        }
        return id;
    }
        boolean validation()
        {
            
            fname=txt_Firstname.getText();
            lname=txt_Lastname.getText();
            uname=txt_Username.getText();
            password=txt_Password.getText();
            con_pass=txt_Confirmpassword.getText();
            contact_no=txt_Contact.getText();
            dob=txt_DOB.getDate();
            if(fname.equals(""))
            {
                JOptionPane.showMessageDialog(this,"Please enter Firstname");
                return false;
            }
            if(lname.equals(""))
            {
                JOptionPane.showMessageDialog(this,"Please enter Lastname");
                return false;
            }
            if(uname.equals(""))
            {
                JOptionPane.showMessageDialog(this,"Please enter Username");
                return false;
            }
            if(password.equals(""))
            {
                JOptionPane.showMessageDialog(this,"Please enter Password");
                return false;
            }
            if(con_pass.equals(""))
            {
                JOptionPane.showMessageDialog(this,"Please confirm the password");
                return false;
            }
            if(dob == null)
            {
                JOptionPane.showMessageDialog(this,"Please enter Date Of Birth");
                return false;
            }
            if(!password.equals(con_pass))
            {
                JOptionPane.showMessageDialog(this,"Password not matched");
                return false;
            }
            
            
            
            
            return true;
        }
        public void checkPassword()
        {
            password=txt_Password.getText();
            if(password.length()<8)
            {
                lbl_password_error.setText("Password should be of 8 digit");
            }
            else
            {
                lbl_password_error.setText("");
            }
            
        }
        public void checkContactNo()
        {
            contact_no=txt_Contact.getText();
            if(contact_no.length()==10)
            {
                lbl_contact_error.setText("");
            }
            else
            {
                lbl_contact_error.setText("Contact number should be 10 digit");
            }
        }
        void insertDetails()
        {
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
            String myDob=format.format(dob);
            try
            {
                Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
                Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/fees_management", "TCET","2001");
                String sql="insert into signup values(?,?,?,?,?,?,?)";
                PreparedStatement stmt=con.prepareStatement(sql);
                stmt.setInt(1, getId());
                stmt.setString(2, fname);
                stmt.setString(3,lname);
                stmt.setString(4,uname);
                stmt.setString(5,password);
                stmt.setString(6,myDob);
                stmt.setString(7,contact_no);
                int i=stmt.executeUpdate();
                if(i>0)
                {
                    JOptionPane.showMessageDialog(this,"Record inserted");
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Record not inserted");
                }
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_Firstname = new javax.swing.JTextField();
        txt_Username = new javax.swing.JTextField();
        txt_Lastname = new javax.swing.JTextField();
        txt_Contact = new javax.swing.JTextField();
        txt_Password = new javax.swing.JPasswordField();
        txt_Confirmpassword = new javax.swing.JPasswordField();
        btn_Signup = new javax.swing.JButton();
        btn_login = new javax.swing.JButton();
        txt_DOB = new com.toedter.calendar.JDateChooser();
        lbl_password_error = new javax.swing.JLabel();
        lbl_contact_error = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 42)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Sign Up");

        jLabel10.setIcon(new javax.swing.ImageIcon("C:\\Users\\hp\\Pictures\\TcetLogo.jpeg")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addGap(73, 73, 73)
                .addComponent(jLabel1)
                .addContainerGap(224, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 100));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Firstname:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Username:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Lastname:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Password:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("D.O.B:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Confirm Password:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Contact no.:");

        txt_Firstname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_Firstname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_FirstnameActionPerformed(evt);
            }
        });

        txt_Username.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_Username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_UsernameActionPerformed(evt);
            }
        });

        txt_Lastname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_Lastname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_LastnameActionPerformed(evt);
            }
        });

        txt_Contact.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_Contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ContactActionPerformed(evt);
            }
        });
        txt_Contact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_ContactKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_ContactKeyReleased(evt);
            }
        });

        txt_Password.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_Password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_PasswordActionPerformed(evt);
            }
        });
        txt_Password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_PasswordKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_PasswordKeyReleased(evt);
            }
        });

        txt_Confirmpassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_Confirmpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ConfirmpasswordActionPerformed(evt);
            }
        });

        btn_Signup.setBackground(new java.awt.Color(153, 153, 153));
        btn_Signup.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btn_Signup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/signup.png"))); // NOI18N
        btn_Signup.setText("Sign Up");
        btn_Signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SignupActionPerformed(evt);
            }
        });

        btn_login.setBackground(new java.awt.Color(153, 153, 153));
        btn_login.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btn_login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/login.png"))); // NOI18N
        btn_login.setText("Login");
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });

        lbl_password_error.setBackground(new java.awt.Color(204, 204, 204));
        lbl_password_error.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_password_error.setForeground(new java.awt.Color(255, 0, 0));
        lbl_password_error.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lbl_password_errorKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lbl_password_errorKeyReleased(evt);
            }
        });

        lbl_contact_error.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_contact_error.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3))
                                .addComponent(jLabel5))
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_Contact, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                            .addComponent(txt_Username, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                            .addComponent(txt_Firstname)
                            .addComponent(txt_Lastname, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                            .addComponent(txt_Password)
                            .addComponent(txt_Confirmpassword)
                            .addComponent(txt_DOB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_contact_error, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                            .addComponent(lbl_password_error, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(btn_Signup)
                        .addGap(75, 75, 75)
                        .addComponent(btn_login, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(txt_Firstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_Lastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_Username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_password_error, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Confirmpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7))
                    .addComponent(txt_DOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Contact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_contact_error, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Signup, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_login, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 540, 390));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_SignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SignupActionPerformed
        if(validation())
        {
            insertDetails();
        }
    }//GEN-LAST:event_btn_SignupActionPerformed

    private void txt_ConfirmpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ConfirmpasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ConfirmpasswordActionPerformed

    private void txt_ContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ContactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ContactActionPerformed

    private void txt_LastnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_LastnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_LastnameActionPerformed

    private void txt_UsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_UsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_UsernameActionPerformed

    private void txt_FirstnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_FirstnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_FirstnameActionPerformed

    private void lbl_password_errorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lbl_password_errorKeyPressed
        
    }//GEN-LAST:event_lbl_password_errorKeyPressed

    private void txt_PasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_PasswordActionPerformed
        
    }//GEN-LAST:event_txt_PasswordActionPerformed

    private void lbl_password_errorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lbl_password_errorKeyReleased
        
    }//GEN-LAST:event_lbl_password_errorKeyReleased

    private void txt_PasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_PasswordKeyPressed
        checkPassword();
    }//GEN-LAST:event_txt_PasswordKeyPressed

    private void txt_PasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_PasswordKeyReleased
        checkPassword();
    }//GEN-LAST:event_txt_PasswordKeyReleased

    private void txt_ContactKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ContactKeyPressed
        checkContactNo();
    }//GEN-LAST:event_txt_ContactKeyPressed

    private void txt_ContactKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ContactKeyReleased
        checkContactNo();
    }//GEN-LAST:event_txt_ContactKeyReleased

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        Login login=new Login();
        login.show();
        this.dispose();
    }//GEN-LAST:event_btn_loginActionPerformed

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
            java.util.logging.Logger.getLogger(Signup_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Signup_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Signup_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Signup_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Signup_Page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Signup;
    private javax.swing.JButton btn_login;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_contact_error;
    private javax.swing.JLabel lbl_password_error;
    private javax.swing.JPasswordField txt_Confirmpassword;
    private javax.swing.JTextField txt_Contact;
    private com.toedter.calendar.JDateChooser txt_DOB;
    private javax.swing.JTextField txt_Firstname;
    private javax.swing.JTextField txt_Lastname;
    private javax.swing.JPasswordField txt_Password;
    private javax.swing.JTextField txt_Username;
    // End of variables declaration//GEN-END:variables

    
    
}
