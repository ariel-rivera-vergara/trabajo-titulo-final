/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pantasha;

import clases.Cargo;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import querys.Qcargo;


public class ven_cargo extends javax.swing.JFrame {
         
    public ven_cargo() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        tbl_cargo.setModel(qp.cargardatos());
          cmb_cargo.setModel(cargarcmb_filtro());
    }
    
    Qcargo qp= new Qcargo();
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        lbl_id_cargo = new javax.swing.JLabel();
        lbl_nom_cargo = new javax.swing.JLabel();
        lbl_desc_cargo = new javax.swing.JLabel();
        txt_id_cargo = new javax.swing.JTextField();
        txt_nom_cargo = new javax.swing.JTextField();
        txt_desc_cargo = new javax.swing.JTextField();
        btn_agregar_cargo = new javax.swing.JButton();
        btn_modificar_cargo = new javax.swing.JButton();
        btn_consultar_cargo = new javax.swing.JButton();
        btn_eliminar_cargo = new javax.swing.JButton();
        btn_salir_cargo = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_cargo = new javax.swing.JTable();
        txt_cargo = new javax.swing.JTextField();
        cmb_cargo = new javax.swing.JComboBox<>();
        btn_limpiar = new javax.swing.JButton();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(500, 500));
        setMinimumSize(new java.awt.Dimension(500, 500));

        jPanel1.setMaximumSize(new java.awt.Dimension(500, 500));
        jPanel1.setMinimumSize(new java.awt.Dimension(500, 500));

        lbl_id_cargo.setText("id cargo");

        lbl_nom_cargo.setText("nombre del cargo");

        lbl_desc_cargo.setText("descripción del cargo");

        btn_agregar_cargo.setText("agregar");
        btn_agregar_cargo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_agregar_cargoMouseClicked(evt);
            }
        });

        btn_modificar_cargo.setText("modificar");
        btn_modificar_cargo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_modificar_cargoMouseClicked(evt);
            }
        });

        btn_consultar_cargo.setText("consultar");
        btn_consultar_cargo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_consultar_cargoMouseClicked(evt);
            }
        });

        btn_eliminar_cargo.setText("eliminar");
        btn_eliminar_cargo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_eliminar_cargoMouseClicked(evt);
            }
        });

        btn_salir_cargo.setText("volver");
        btn_salir_cargo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_salir_cargoMouseClicked(evt);
            }
        });

        tbl_cargo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tbl_cargo);

        cmb_cargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btn_limpiar.setText("Limpiar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_agregar_cargo)
                                .addGap(45, 45, 45)
                                .addComponent(btn_modificar_cargo)
                                .addGap(47, 47, 47)
                                .addComponent(btn_consultar_cargo)
                                .addGap(40, 40, 40)
                                .addComponent(btn_eliminar_cargo))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_id_cargo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_nom_cargo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_desc_cargo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_id_cargo)
                            .addComponent(txt_nom_cargo)
                            .addComponent(txt_desc_cargo, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_limpiar)))
                .addContainerGap(117, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_salir_cargo)
                        .addGap(44, 44, 44))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(cmb_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_id_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_id_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_nom_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_nom_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_desc_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_desc_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_limpiar))
                .addGap(87, 87, 87)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_agregar_cargo)
                    .addComponent(btn_consultar_cargo)
                    .addComponent(btn_modificar_cargo)
                    .addComponent(btn_eliminar_cargo))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                .addGap(37, 37, 37)
                .addComponent(btn_salir_cargo)
                .addGap(21, 21, 21))
        );

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
    }// </editor-fold>//GEN-END:initComponents

    private void btn_agregar_cargoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_agregar_cargoMouseClicked
         Cargo carg = new Cargo();
        carg.setId_cargo(txt_id_cargo.getText());
        carg.setNom_cargo(txt_nom_cargo.getText());
        carg.setDesc_cargo(txt_desc_cargo.getText());  
       
        Qcargo query = new Qcargo();
          query.agregarcargo(carg);
      /*   tabla.removeAll();
          actualizar();*/
    }//GEN-LAST:event_btn_agregar_cargoMouseClicked

    private void btn_modificar_cargoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_modificar_cargoMouseClicked
         Cargo carg = new Cargo();
        carg.setId_cargo(txt_id_cargo.getText());
        carg.setNom_cargo(txt_nom_cargo.getText());
        carg.setDesc_cargo(txt_desc_cargo.getText());  
       
        Qcargo query = new Qcargo();
          query.modificarcargo(carg);
       /*   tabla.removeAll();
          actualizar();*/
    }//GEN-LAST:event_btn_modificar_cargoMouseClicked

    private void btn_consultar_cargoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_consultar_cargoMouseClicked
        Cargo carg = new Cargo();
        carg.setId_cargo(txt_id_cargo.getText());
        carg.setNom_cargo(txt_nom_cargo.getText());
        carg.setDesc_cargo(txt_desc_cargo.getText());  
       
        Qcargo query = new Qcargo();
          query.consultarcargo(carg);
        /*  tabla.removeAll();
          actualizar();*/
    }//GEN-LAST:event_btn_consultar_cargoMouseClicked

    private void btn_eliminar_cargoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_eliminar_cargoMouseClicked
        Cargo carg = new Cargo();
        carg.setId_cargo(txt_id_cargo.getText());
        carg.setNom_cargo(txt_nom_cargo.getText());
        carg.setDesc_cargo(txt_desc_cargo.getText());  
       
        Qcargo query = new Qcargo();
          query.eliminarcargo(carg);
        /*  tabla.removeAll();
          actualizar();*/
    }//GEN-LAST:event_btn_eliminar_cargoMouseClicked

    private void btn_salir_cargoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_salir_cargoMouseClicked
         ven_principal vp = new ven_principal();
        vp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_salir_cargoMouseClicked

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
            java.util.logging.Logger.getLogger(ven_cargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ven_cargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ven_cargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ven_cargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ven_cargo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregar_cargo;
    private javax.swing.JButton btn_consultar_cargo;
    private javax.swing.JButton btn_eliminar_cargo;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JButton btn_modificar_cargo;
    private javax.swing.JButton btn_salir_cargo;
    private javax.swing.JComboBox<String> cmb_cargo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lbl_desc_cargo;
    private javax.swing.JLabel lbl_id_cargo;
    private javax.swing.JLabel lbl_nom_cargo;
    private javax.swing.JTable tbl_cargo;
    private javax.swing.JTextField txt_cargo;
    private javax.swing.JTextField txt_desc_cargo;
    private javax.swing.JTextField txt_id_cargo;
    private javax.swing.JTextField txt_nom_cargo;
    // End of variables declaration//GEN-END:variables
  public void Limpiar() {
        txt_id_cargo.setText("");
        txt_nom_cargo.setText("");
        txt_desc_cargo.setText("");
    }

       public void actualizar(){
         DefaultTableModel modelo = new DefaultTableModel();
         modelo=qp.cargardatos();
         tbl_cargo.setModel(modelo);
    }
    
    
      public DefaultComboBoxModel cargarcmb_filtro(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        modelo.addElement("Codigo de producto");
        modelo.addElement("Nombre de producto");       
        modelo.addElement("Precio");
        return modelo;
    }



}
