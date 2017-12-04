/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pantasha;

import clases.venta;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import querys.Qprod_ventas;
import querys.Qproductos;

/**
 *
 * @author Ariel
 */
public class ven_ventas extends javax.swing.JFrame {

    Qproductos qp = new Qproductos();
    DefaultTableModel modelopsl = new DefaultTableModel();
    Qprod_ventas qprodven = new Qprod_ventas();
    venta ven = new venta();
    String consultar = "";
    String modificar = "";

    public ven_ventas() {
        initComponents();
        this.setLocationRelativeTo(null);
        tbl_productos.setModel(qp.cargardatos());
        cmb_filtro_productos.setModel(cargarcmb_filtro());
        modelopsl.addColumn("Codigo");
        modelopsl.addColumn("Nombre");
        modelopsl.addColumn("Precio");
        modelopsl.addColumn("Cantidad");
        modelopsl.addColumn("SubTotal");

    }

    ven_ventas(venta ven, String consultar) {
        initComponents();
        this.setLocationRelativeTo(null);
        tbl_productos.setModel(qp.cargardatos());
        Atxt_receta.setText(ven.getReceta());
        Atxt_receta.setEditable(false);
        modelopsl = qprodven.cargardatosEspecificos(ven);
        tbl_productos_seleccionados.setModel(modelopsl);
        qprodven.cargardatosEspecificos(ven);

        btn_seleccionar.setVisible(false);
        btn_quitar.setVisible(false);
        this.consultar = "s";
        this.ven = ven;

    }

    ven_ventas(String modificar, venta ven) {
        initComponents();
        this.setLocationRelativeTo(null);
        tbl_productos.setModel(qp.cargardatos());
        Atxt_receta.setText(ven.getReceta());
        modelopsl = qprodven.cargardatosEspecificos(ven);
        tbl_productos_seleccionados.setModel(modelopsl);
        qprodven.cargardatosEspecificos(ven);
        this.modificar = "s";
        this.ven = ven;
        System.out.println("id venta de constructor de venta "+ven.getId_usuario());
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_productos = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_productos_seleccionados = new javax.swing.JTable();
        txt_cantidad = new javax.swing.JTextField();
        btn_seleccionar = new javax.swing.JButton();
        lbl_cantidad = new javax.swing.JLabel();
        cmb_filtro_productos = new javax.swing.JComboBox<>();
        txt_filtro_productos = new javax.swing.JTextField();
        btn_crear_venta = new javax.swing.JButton();
        btn_volver = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        Atxt_receta = new javax.swing.JTextArea();
        lbl_receta = new javax.swing.JLabel();
        btn_quitar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbl_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbl_productos);

        tbl_productos_seleccionados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tbl_productos_seleccionados);

        btn_seleccionar.setText("Seleccionar");
        btn_seleccionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_seleccionarMouseClicked(evt);
            }
        });

        lbl_cantidad.setText("Cantidad");

        cmb_filtro_productos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txt_filtro_productos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_filtro_productosKeyReleased(evt);
            }
        });

        btn_crear_venta.setText("Crear Venta");
        btn_crear_venta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_crear_ventaMouseClicked(evt);
            }
        });

        btn_volver.setText("Volver");
        btn_volver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_volverMouseClicked(evt);
            }
        });

        Atxt_receta.setColumns(20);
        Atxt_receta.setRows(5);
        jScrollPane3.setViewportView(Atxt_receta);

        lbl_receta.setText("Receta");

        btn_quitar.setText("quitar");
        btn_quitar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_quitarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_seleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(135, 135, 135))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(cmb_filtro_productos, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txt_filtro_productos, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGap(27, 27, 27)
                                    .addComponent(btn_crear_venta)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_volver, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(145, 145, 145))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_receta, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_quitar)
                        .addGap(154, 154, 154))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_filtro_productos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_filtro_productos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_cantidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_seleccionar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(lbl_receta, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_quitar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_crear_venta)
                    .addComponent(btn_volver, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_seleccionarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_seleccionarMouseClicked
        int fila = tbl_productos.getSelectedRow();

        String codigo = (String) tbl_productos.getValueAt(fila, 0);
        String SubTotal = String.valueOf(Integer.parseInt((String) tbl_productos.getValueAt(fila, 2)) * Integer.parseInt(txt_cantidad.getText()));
        String[] arreglo = new String[5];
        arreglo[0] = codigo;
        arreglo[1] = (String) tbl_productos.getValueAt(fila, 1);
        arreglo[2] = (String) tbl_productos.getValueAt(fila, 2);
        arreglo[3] = txt_cantidad.getText();
        arreglo[4] = SubTotal;
        modelopsl.addRow(arreglo);
        tbl_productos_seleccionados.setModel(modelopsl);
        txt_cantidad.setText("");
    }//GEN-LAST:event_btn_seleccionarMouseClicked

    private void txt_filtro_productosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_filtro_productosKeyReleased
        String buscar = (String) cmb_filtro_productos.getSelectedItem();
        Qproductos qp = new Qproductos();
        tbl_productos.setModel(qp.buscarDatos(txt_filtro_productos.getText(), buscar));
    }//GEN-LAST:event_txt_filtro_productosKeyReleased

    private void btn_quitarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_quitarMouseClicked
        int index = tbl_productos_seleccionados.getSelectedRow();
        if (index >= 0) {
            modelopsl.removeRow(index);
        }
    }//GEN-LAST:event_btn_quitarMouseClicked

    private void btn_crear_ventaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_crear_ventaMouseClicked
     ven.setReceta(Atxt_receta.getText());
        int total = 0;
        int i = tbl_productos_seleccionados.getRowCount();
        int cont = 0;
        while (i > 0) {
            String subtotal = (String) tbl_productos_seleccionados.getValueAt(cont, 4);
            total = total + Integer.parseInt(subtotal);
            i--;
            cont++;
        }
        if (consultar.equals("s")) {

            ven_detalle_venta vdv = new ven_detalle_venta(total, consultar, ven);

            this.dispose();
            vdv.setVisible(true);
        } else if (modificar.equals("s")) {
            System.out.println("venta de boton generar venta en venta " + ven.getId_venta());
            ven_detalle_venta vdv = new ven_detalle_venta(total, ven, modificar,modelopsl);
            this.dispose();
            vdv.setVisible(true);
        } else {
            ven_detalle_venta vdv = new ven_detalle_venta(modelopsl, Atxt_receta, total);
            this.dispose();
            vdv.setVisible(true);

        }

    }//GEN-LAST:event_btn_crear_ventaMouseClicked

    private void btn_volverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_volverMouseClicked
        ven_mantenedor_ventas vmv = new ven_mantenedor_ventas();
        this.dispose();
        vmv.setVisible(true);
    }//GEN-LAST:event_btn_volverMouseClicked

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
            java.util.logging.Logger.getLogger(ven_ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ven_ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ven_ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ven_ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ven_ventas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Atxt_receta;
    private javax.swing.JButton btn_crear_venta;
    private javax.swing.JButton btn_quitar;
    private javax.swing.JButton btn_seleccionar;
    private javax.swing.JButton btn_volver;
    private javax.swing.JComboBox<String> cmb_filtro_productos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_cantidad;
    private javax.swing.JLabel lbl_receta;
    private javax.swing.JTable tbl_productos;
    private javax.swing.JTable tbl_productos_seleccionados;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JTextField txt_filtro_productos;
    // End of variables declaration//GEN-END:variables

    public DefaultComboBoxModel cargarcmb_filtro() {
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        modelo.addElement("Codigo de producto");
        modelo.addElement("Nombre de producto");
        modelo.addElement("Precio");
        modelo.addElement("Cantidad");
        modelo.addElement("Descripcion");
        return modelo;
    }

}
