/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pantasha;

import clases.DetallePedido;
import clases.OrdenPedido;
import clases.Proveedores;
import clases.Validar;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import querys.QdetallePedido;
import querys.QordenDePedido;
import querys.Qpedidos;
import querys.Qproductos;
import querys.Qproveedor;


public class ven_pedido extends javax.swing.JFrame {

    Qproductos qp = new Qproductos();
    Validar vali = new Validar();
    Qpedidos qpedi = new Qpedidos();
    OrdenPedido op = new OrdenPedido();
    Qproveedor qprov = new Qproveedor();
      DefaultTableModel modelop = new DefaultTableModel();
    DefaultTableModel modeloaux = new DefaultTableModel();
    DefaultTableModel modelo = new DefaultTableModel();
    DetallePedido dp = new DetallePedido();
    QdetallePedido qdp = new QdetallePedido();
    QordenDePedido qop = new QordenDePedido();
    OrdenPedido odp = new OrdenPedido(); 
   String modificar = "";
        String codigopedido;
    public ven_pedido() {
        initComponents();

        this.setLocationRelativeTo(null);
        tbl_productos.setModel(qp.cargardatos());
        cmb_filtro_productos.setModel(cargarcmb_filtro());
        cmb_estado.setModel(cargarcmb_estado());
         modelop.addColumn("Codigo de proveedor");
        modelop.addColumn("Nombre de proveedor");
        modelop.addColumn("fono");
     
        tbl_proveedor.setModel(modelop);
         modeloaux.addColumn("Cod");
        modeloaux.addColumn("Nombre");
        modeloaux.addColumn("Cantidad pedida");
        cmb_estado.setVisible(false);
        lbl_estado.setVisible(false);
        btn_modificar.setVisible(false);
        
    }

    ven_pedido(Proveedores p , String text) {
   
        initComponents();
       
        this.setLocationRelativeTo(null);
        tbl_productos.setModel(qp.cargardatos());
        cmb_filtro_productos.setModel(cargarcmb_filtro());
        cmb_estado.setModel(cargarcmb_estado()); 
         modeloaux.addColumn("Cod");
        modeloaux.addColumn("Nombre");
        modeloaux.addColumn("Cantidad pedida");
        
         modelop.addColumn("Codigo de proveedor");
        modelop.addColumn("Nombre de proveedor");
        modelop.addColumn("fono");
        String[] arreglo = new String[3];
        arreglo[0] = p.getCod_prov();
        arreglo[1] = p.getNom_prov();
        arreglo[2] = p.getFono_prov();
            modelop.addRow(arreglo);
        tbl_proveedor.setModel(modelop);
      
    }

    ven_pedido(OrdenPedido odp) {
         initComponents();
         this.setLocationRelativeTo(null);
        tbl_productos.setModel(qp.cargardatos());
        cmb_filtro_productos.setModel(cargarcmb_filtro());
        cmb_estado.setModel(cargarcmb_estado());
        tbl_proveedor.setModel(qprov.cargardatosprov(odp.getCod_prov()));
        modeloaux = qdp.cargardatos();
        tbl_productos_seleccionados.setModel(modeloaux);
        txt_fecha_pedido.setText(odp.getFecha_pedido());
        txt_fecha_entrega.setText(odp.getFecha_entrega());
        
       if(odp.getEstado_pedido().equals("E")){
            cmb_estado.setSelectedIndex(0);
       } else if (odp.getEstado_pedido().equals("P")){
           cmb_estado.setSelectedIndex(2);
       }else if (odp.getEstado_pedido().equals("R")){
           cmb_estado.setSelectedIndex(1);
       }
        
         btn_insertar.setVisible(false);
         
        
         modificar = "s";
         codigopedido = odp.getCod_pedido();
        this.odp = odp;
    }
    
     ven_pedido(OrdenPedido odp, String consultar) {
         initComponents();
         this.setLocationRelativeTo(null);
        tbl_productos.setModel(qp.cargardatos());
        cmb_filtro_productos.setModel(cargarcmb_filtro());
        cmb_estado.setModel(cargarcmb_estado());
        tbl_proveedor.setModel(qprov.cargardatosprov(odp.getCod_prov()));
        modeloaux = qdp.cargardatos();
        tbl_productos_seleccionados.setModel(modeloaux);
        txt_fecha_pedido.setText(odp.getFecha_pedido());
        txt_fecha_entrega.setText(odp.getFecha_entrega());
         cmb_estado.setSelectedItem(odp.getEstado_pedido());
         btn_insertar.setVisible(false);
         btn_modificar.setVisible(false);
         btn_buscarprov.setVisible(false);
         btn_quitar.setVisible(false);
         btn_quitarprov.setVisible(false);
         btn_seleccionar.setVisible(false);
         txt_fecha_entrega.setEditable(false);
         txt_fecha_pedido.setEditable(false);
         cmb_estado.setEditable(false);
         
        if(odp.getEstado_pedido().equals("E")){
            cmb_estado.setSelectedIndex(0);
       } else if (odp.getEstado_pedido().equals("P")){
           cmb_estado.setSelectedIndex(2);
       }else if (odp.getEstado_pedido().equals("R")){
           cmb_estado.setSelectedIndex(1);
       }
    }
     
    ven_pedido(String modificar, OrdenPedido odp, Proveedores p) {
         initComponents();
         this.setLocationRelativeTo(null);
          this.odp = odp;
        tbl_productos.setModel(qp.cargardatos());
        cmb_filtro_productos.setModel(cargarcmb_filtro());
        cmb_estado.setModel(cargarcmb_estado());
        tbl_proveedor.setModel(qprov.cargardatosprov(p.getCod_prov()));
        modeloaux = qdp.cargardatos();
        tbl_productos_seleccionados.setModel(modeloaux);
        txt_fecha_pedido.setText(odp.getFecha_pedido());
        txt_fecha_entrega.setText(odp.getFecha_entrega());
        
       if(odp.getEstado_pedido().equals("E")){
            cmb_estado.setSelectedIndex(0);
       } else if (odp.getEstado_pedido().equals("P")){
           cmb_estado.setSelectedIndex(2);
       }else if (odp.getEstado_pedido().equals("R")){
           cmb_estado.setSelectedIndex(1);
       }
        
         btn_insertar.setVisible(false);
         
        
         this.modificar = "s";
         codigopedido = odp.getCod_pedido();
       
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
        jLabel2 = new javax.swing.JLabel();
        btn_buscarprov = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_proveedor = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txt_fecha_pedido = new javax.swing.JTextField();
        btn_quitarprov = new javax.swing.JButton();
        lbl_Fecha_Entrega = new javax.swing.JLabel();
        txt_fecha_entrega = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_productos = new javax.swing.JTable();
        lbl_cantidad = new javax.swing.JLabel();
        txt_cantidad = new javax.swing.JTextField();
        btn_seleccionar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_productos_seleccionados = new javax.swing.JTable();
        btn_quitar = new javax.swing.JButton();
        btn_insertar = new javax.swing.JButton();
        cmb_filtro_productos = new javax.swing.JComboBox<>();
        txt_filtro_productos = new javax.swing.JTextField();
        cmb_estado = new javax.swing.JComboBox<>();
        lbl_estado = new javax.swing.JLabel();
        btn_volver = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Proveedor");

        btn_buscarprov.setText("Buscar P");
        btn_buscarprov.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_buscarprovMouseClicked(evt);
            }
        });

        tbl_proveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbl_proveedor);

        jLabel3.setText("Fecha pedido");

        btn_quitarprov.setText("Quitar");
        btn_quitarprov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_quitarprovActionPerformed(evt);
            }
        });

        lbl_Fecha_Entrega.setText("Fecha entrega");

        tbl_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tbl_productos);

        lbl_cantidad.setText("Cantidad");

        btn_seleccionar.setText("Seleccionar");
        btn_seleccionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_seleccionarMouseClicked(evt);
            }
        });
        btn_seleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_seleccionarActionPerformed(evt);
            }
        });

        jLabel5.setText("Productos a seleccionar");

        tbl_productos_seleccionados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tbl_productos_seleccionados);

        btn_quitar.setText("Quitar");
        btn_quitar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_quitarMouseClicked(evt);
            }
        });

        btn_insertar.setText("Insertar");
        btn_insertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_insertarActionPerformed(evt);
            }
        });
        btn_insertar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_insertarKeyPressed(evt);
            }
        });

        cmb_filtro_productos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txt_filtro_productos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_filtro_productosKeyReleased(evt);
            }
        });

        cmb_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lbl_estado.setText("Estado");

        btn_volver.setText("Volver");
        btn_volver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_volverMouseClicked(evt);
            }
        });

        btn_modificar.setText("Modificar");
        btn_modificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_modificarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(230, 230, 230)
                        .addComponent(cmb_filtro_productos, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_filtro_productos, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 115, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lbl_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmb_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(lbl_Fecha_Entrega))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_fecha_pedido, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(316, 316, 316)
                                .addComponent(btn_quitarprov))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btn_buscarprov)
                                    .addGap(18, 18, 18)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txt_fecha_entrega, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_seleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(83, 83, 83))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_quitar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40))))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(btn_insertar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_volver, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(265, 265, 265))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_buscarprov))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_fecha_pedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(btn_quitarprov)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Fecha_Entrega, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_fecha_entrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_filtro_productos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_filtro_productos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_seleccionar))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_quitar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmb_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_insertar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_volver, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(291, 291, 291)
                        .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(164, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_seleccionarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_seleccionarMouseClicked
        //DefaultTableModel modelo = new DefaultTableModel();
        // modeloaux=qpedi.Pasardatos(tbl_productos,txt_cantidad.getText());
        // tbl_productos_seleccionados.setModel(modeloaux);
  if(modificar.equals("s")){
       int fila = tbl_productos.getSelectedRow();
 
       System.out.println("Codigo de pedido" + codigopedido);
       String codigoprod = (String) tbl_productos.getValueAt(fila, 0);
        String[] arreglo = new String[3];
        arreglo[0] = codigopedido;
        arreglo[1] = codigoprod;
        arreglo[2] = txt_cantidad.getText();
         modeloaux.addRow(arreglo);
        tbl_productos_seleccionados.setModel(modeloaux);
        txt_cantidad.setText("");
  }else{
      int fila = tbl_productos.getSelectedRow();

        String codigo = (String) tbl_productos.getValueAt(fila, 0);
        String nombre = (String) tbl_productos.getValueAt(fila, 1);
        String[] arreglo = new String[3];
        arreglo[1] = codigo;
        arreglo[0] = nombre;
        arreglo[2] = txt_cantidad.getText();
        modeloaux.addRow(arreglo);
        tbl_productos_seleccionados.setModel(modeloaux);
        txt_cantidad.setText("");
  }
        
        
    }//GEN-LAST:event_btn_seleccionarMouseClicked

    private void btn_buscarprovMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_buscarprovMouseClicked
     if(modificar.equals("s")){
         ven_buscar_proveedor vbuscarp = new ven_buscar_proveedor(modificar,odp);
        vbuscarp.setVisible(true);
        this.dispose();
     }else{
          ven_buscar_proveedor vbuscarp = new ven_buscar_proveedor();
        vbuscarp.setVisible(true);
        this.dispose();
     }  
       

    }//GEN-LAST:event_btn_buscarprovMouseClicked

    private void txt_filtro_productosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_filtro_productosKeyReleased
        String buscar = (String) cmb_filtro_productos.getSelectedItem();
        Qproductos qp = new Qproductos();
        tbl_productos.setModel(qp.buscarDatos(txt_filtro_productos.getText(), buscar));
    }//GEN-LAST:event_txt_filtro_productosKeyReleased

    private void btn_quitarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_quitarMouseClicked
          int index = tbl_productos_seleccionados.getSelectedRow();
          if(index >= 0){
              modeloaux.removeRow(index);
          }

    }//GEN-LAST:event_btn_quitarMouseClicked

    private void btn_insertarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_insertarKeyPressed

    }//GEN-LAST:event_btn_insertarKeyPressed

    private void btn_seleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_seleccionarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_seleccionarActionPerformed

    private void btn_quitarprovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_quitarprovActionPerformed
         int index = tbl_proveedor.getSelectedRow();
          if(index >= 0){
              modelop.removeRow(index);
          }

    }//GEN-LAST:event_btn_quitarprovActionPerformed

    private void btn_insertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_insertarActionPerformed
     
        op.setCod_prov((String) tbl_proveedor.getValueAt(0,0));
        op.setFecha_pedido(txt_fecha_pedido.getText());
        op.setFecha_entrega(txt_fecha_entrega.getText());
       
        op.setEstado_pedido("E");
        
       
        
        try {
            qop.agregarOrdenPedido(op);
          
        } catch (ParseException ex) {
            Logger.getLogger(ven_pedido.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     
    //----------------------------------------la siguiente es para detalle pedido   
       
       int i = tbl_productos_seleccionados.getRowCount();
      
         int cont = 0;
        while (i>0){  
         dp.setCod_producto((String) tbl_productos_seleccionados.getValueAt(cont,0));
         String cantidad = ((String) tbl_productos_seleccionados.getValueAt(cont,2));
         dp.setCantidad(Integer.parseInt(cantidad));
         qdp.agregarDetallePedido(dp);
          cont++;
         i--;   
        }
         
        ven_mantenedor_pedido vmp = new ven_mantenedor_pedido();
        vmp.setVisible(true);
        this.dispose();
         
    }//GEN-LAST:event_btn_insertarActionPerformed

    private void btn_volverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_volverMouseClicked
       ven_mantenedor_pedido vmp = new ven_mantenedor_pedido();
       vmp.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btn_volverMouseClicked

    private void btn_modificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_modificarMouseClicked
        
        

        
        odp.setCod_pedido((String) tbl_productos_seleccionados.getValueAt(0,0));
        odp.setCod_prov((String) tbl_proveedor.getValueAt(0,0));
        // recordar cambiar el usuario despues por la variable global
        odp.setId_usuario("usuario");
        odp.setFecha_pedido(txt_fecha_pedido.getText());
        odp.setFecha_entrega(txt_fecha_entrega.getText());
        if(cmb_estado.getSelectedItem().equals("Emitido")){
              odp.setEstado_pedido("E");
        }else if(cmb_estado.getSelectedItem().equals("Pendiente")){
            odp.setEstado_pedido("P");
        }else if (cmb_estado.getSelectedItem().equals("Recibido")){
            odp.setEstado_pedido("R");
        }
       
        
          if (JOptionPane.showConfirmDialog(null, "Desea modificar el pedido  " + odp.getCod_pedido(), "Modificar pedido",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null) == JOptionPane.OK_OPTION) {
        qdp.eliminarDetalleDePedido(odp.getCod_pedido());
        qop.eliminarOrdenDePedido(odp.getCod_pedido());
          }
        
         try {
            qop.agregarOrdenPedidoM(odp);
        } catch (ParseException ex) {
            Logger.getLogger(ven_pedido.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
           int i = tbl_productos_seleccionados.getRowCount();
         int cont = 0;
        while (i>0){  
            String cantidad = (String) tbl_productos_seleccionados.getValueAt(cont,2);
        dp.setCod_pedido((String) tbl_productos_seleccionados.getValueAt(cont,0));
        dp.setCod_producto((String) tbl_productos_seleccionados.getValueAt(cont,1));
        dp.setCantidad(Integer.parseInt(cantidad));
         qdp.agregarDetallePedidoM(dp);
          cont++;
         i--;   
        }
       
        
        
    }//GEN-LAST:event_btn_modificarMouseClicked

  
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
            java.util.logging.Logger.getLogger(ven_pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ven_pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ven_pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ven_pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ven_pedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_buscarprov;
    private javax.swing.JButton btn_insertar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_quitar;
    private javax.swing.JButton btn_quitarprov;
    private javax.swing.JButton btn_seleccionar;
    private javax.swing.JButton btn_volver;
    private javax.swing.JComboBox<String> cmb_estado;
    private javax.swing.JComboBox<String> cmb_filtro_productos;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_Fecha_Entrega;
    private javax.swing.JLabel lbl_cantidad;
    private javax.swing.JLabel lbl_estado;
    private javax.swing.JTable tbl_productos;
    private javax.swing.JTable tbl_productos_seleccionados;
    private javax.swing.JTable tbl_proveedor;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JTextField txt_fecha_entrega;
    private javax.swing.JTextField txt_fecha_pedido;
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

    public DefaultComboBoxModel cargarcmb_estado() {
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        modelo.addElement("Emitido");
        modelo.addElement("Recibido");
        modelo.addElement("Pendiente");
        return modelo;
    }
    

}
