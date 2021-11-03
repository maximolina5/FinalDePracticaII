/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

/**
 *
 * @author maxim
 */
public class iniciarSesion extends javax.swing.JFrame {

    /**
     * Creates new form iniciarSesion
     */
    public iniciarSesion() {
        initComponents();
        trasparenciaButton();
    }

     public void trasparenciaButton(){
        btnIngresar.setOpaque(false);
        btnIngresar.setContentAreaFilled(false);
        btnIngresar.setBorderPainted(false);
    }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        btnIngresar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(51, 51, 51)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Avatar_Container.png"))); // NOI18N
        jLabel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 1, new java.awt.Color(51, 51, 51)));
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, -1, 80));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Card_Header.jpg"))); // NOI18N
        jLabel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 0, 1, new java.awt.Color(51, 51, 51)));
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, -1));

        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        jTextField1.setFont(new java.awt.Font("Futura Bk BT", 0, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(51, 51, 51));
        jTextField1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 51, 51)));
        jPanel3.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 250, 40));

        btnIngresar.setBackground(new java.awt.Color(255, 255, 255));
        btnIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Group5.png"))); // NOI18N
        jPanel3.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, 270, -1));

        jLabel4.setFont(new java.awt.Font("Futura Bk BT", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Contraseña");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, -1, -1));

        jLabel5.setFont(new java.awt.Font("Futura Bk BT", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Nombre de usuario");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, -1, -1));

        jPasswordField1.setBackground(new java.awt.Color(255, 255, 255));
        jPasswordField1.setFont(new java.awt.Font("Futura Bk BT", 0, 14)); // NOI18N
        jPasswordField1.setForeground(new java.awt.Color(51, 51, 51));
        jPasswordField1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 51, 51)));
        jPanel3.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 269, 250, 40));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 450, 450));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Wallpaper 02.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 500));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(iniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(iniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(iniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(iniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new iniciarSesion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
