/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pantasha;

import clases.Persona;
import clases.Usuario;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static jdk.nashorn.internal.objects.NativeString.trim;
import querys.Qpersona;
import querys.Qusuario;

/**
 *
 * @author Ivan
 * 
 * 
 * 
 * 
 */
public class ven_usuario extends javax.swing.JFrame {

    /**
     * Creates new form ven_agregaru
     * 
     * 
     *
     */
    
    
     Qusuario qusu = new Qusuario();
    
    
    public ven_usuario() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_usu = new javax.swing.JTextField();
        txt_cargo = new javax.swing.JTextField();
        jp_pass = new javax.swing.JPasswordField();
        btn_volver = new javax.swing.JButton();
        btn_aceptar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txt_nom_usuario = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_usuario = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(500, 500));
        setMinimumSize(new java.awt.Dimension(500, 500));

        jPanel1.setMaximumSize(new java.awt.Dimension(500, 500));
        jPanel1.setMinimumSize(new java.awt.Dimension(500, 500));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 500));
        jPanel1.setLayout(null);

        jLabel1.setText("id_usuario");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(32, 45, 137, 20);

        jLabel2.setText("password");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 210, 137, 23);

        jLabel3.setText("cargo");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 90, 137, 26);

        txt_usu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usuActionPerformed(evt);
            }
        });
        jPanel1.add(txt_usu);
        txt_usu.setBounds(170, 40, 160, 30);
        jPanel1.add(txt_cargo);
        txt_cargo.setBounds(170, 90, 160, 30);
        jPanel1.add(jp_pass);
        jp_pass.setBounds(170, 200, 170, 30);

        btn_volver.setText("volver");
        btn_volver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_volverMouseClicked(evt);
            }
        });
        jPanel1.add(btn_volver);
        btn_volver.setBounds(480, 463, 70, 30);

        btn_aceptar.setText("agregar");
        btn_aceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_aceptarMouseClicked(evt);
            }
        });
        jPanel1.add(btn_aceptar);
        btn_aceptar.setBounds(20, 273, 100, 30);

        btn_eliminar.setText("eliminar");
        btn_eliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_eliminarMouseClicked(evt);
            }
        });
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_eliminar);
        btn_eliminar.setBounds(400, 270, 110, 30);

        jLabel5.setText("nombre usuario");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(30, 160, 80, 14);
        jPanel1.add(txt_nom_usuario);
        txt_nom_usuario.setBounds(170, 150, 160, 30);

        jButton1.setText("consultar");
        jPanel1.add(jButton1);
        jButton1.setBounds(150, 273, 90, 30);

        jButton2.setText("modificar");
        jPanel1.add(jButton2);
        jButton2.setBounds(270, 273, 90, 30);

        tbl_usuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tbl_usuario);

        jPanel1.add(jScrollPane4);
        jScrollPane4.setBounds(20, 330, 490, 100);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_usuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usuActionPerformed

    private void btn_volverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_volverMouseClicked
     ven_principal vp = new ven_principal();
       vp.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btn_volverMouseClicked

    private void btn_aceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_aceptarMouseClicked
      
        
      
        Usuario usu = new Usuario();
        usu.setUsuario(trim(txt_usu.getText()));
           
        
         if  (trim(usu.getUsuario()).equals("") || trim(usu.getUsuario()).equals("")){
              JOptionPane.showMessageDialog(null, "indique codigo no se puede agregar un usuario sin codigo");
              
          }else{
           
        
              if                                  
                      (JOptionPane.showConfirmDialog(null, "Desea agregar el codigo  " + usu.getUsuario(), "agregar usuario",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null) == JOptionPane.OK_OPTION) {     
                  
                   } else {
                  
                   if (JOptionPane.showConfirmDialog(null, "Desea agregar el usuario de Id  " + usu.getUsuario(), "agregar usuario",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null) == JOptionPane.OK_OPTION) {

                usu.setId_cargo(txt_cargo.getText());
                usu.setNom_usuario(txt_nom_usuario.getText());
                usu.setPassword(String.valueOf(jp_pass.getPassword()));
                qusu.agregarusuario(usu);
                actualizar();
                Limpiar();
            }

            Limpiar();
              }    

          } 
        
        
    
         
        
      
    }//GEN-LAST:event_btn_aceptarMouseClicked

    private void btn_eliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_eliminarMouseClicked
        
        Usuario usu = new Usuario();
        usu.setUsuario(txt_usu.getText());
        Qusuario query = new Qusuario();   
        query.eliminarusuario(usu);
        JOptionPane.showMessageDialog(null,"eliminado con exito");
    }//GEN-LAST:event_btn_eliminarMouseClicked

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_eliminarActionPerformed

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
            java.util.logging.Logger.getLogger(ven_usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ven_usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ven_usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ven_usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ven_usuario().setVisible(true);
            }
        });
    }

    
    
    
    
     public void Limpiar() {
         
        jp_pass.setText("");   
        txt_usu.setText("");
        txt_cargo.setText("");
        txt_nom_usuario.setText("");
        
    }

     
    public void actualizar() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo = qusu.cargardatos();
        tbl_usuario.setModel(modelo);
    
    
    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_aceptar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_volver;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JPasswordField jp_pass;
    private javax.swing.JTable tbl_usuario;
    private javax.swing.JTextField txt_cargo;
    private javax.swing.JTextField txt_nom_usuario;
    private javax.swing.JTextField txt_usu;
    // End of variables declaration//GEN-END:variables
}
