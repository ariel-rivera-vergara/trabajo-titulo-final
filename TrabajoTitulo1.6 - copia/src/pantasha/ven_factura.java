/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pantasha;

import clases.DetalleFacturaCompra;
import clases.FacturaCompra;
import clases.Proveedores;
import clases.Validar;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import querys.QDetalleFacturaCompra;
import querys.QfacturaCompra;
import querys.Qproductos;
import querys.Qproveedor;

 
public class ven_factura extends javax.swing.JFrame {

    
    Qproductos qp = new Qproductos();
    Validar vali = new Validar(); 
      DefaultTableModel modeloFs = new DefaultTableModel();
      DefaultTableModel modelop = new DefaultTableModel();
      FacturaCompra fc = new FacturaCompra();
      DetalleFacturaCompra dfc = new DetalleFacturaCompra();
      QfacturaCompra qfc = new QfacturaCompra();
      QDetalleFacturaCompra qdfc = new QDetalleFacturaCompra();
      Qproveedor qprov = new Qproveedor();
      int Total = 0;
      int quitar;
      int sw ;
    public ven_factura() {
        initComponents();
        this.setLocationRelativeTo(null);
        tbl_productos.setModel(qp.cargardatos());
        cmb_filtro_productos.setModel(cargarcmb_filtro());
       
        modelop.addColumn("Codigo de proveedor");
        modelop.addColumn("Nombre de proveedor");
        modelop.addColumn("fono");
        tbl_proveedor_selec.setModel(modelop);
        
        modeloFs.addColumn("Codigo");
        modeloFs.addColumn("Cantidad Comprada");
        modeloFs.addColumn("Precio de Compra");
       
        tbl_productos_seleccionados.setModel(modeloFs);
        sw=1;
        btn_modificar.setVisible(false);

        
    }

    ven_factura(Proveedores p) {
        initComponents();
        this.setLocationRelativeTo(null);
        tbl_productos.setModel(qp.cargardatos());
        cmb_filtro_productos.setModel(cargarcmb_filtro());
       
        modelop.addColumn("Codigo de proveedor");
        modelop.addColumn("Nombre de proveedor");
        modelop.addColumn("fono");
        String[] arreglo = new String[3];
        arreglo[0] = p.getCod_prov();
        arreglo[1] = p.getNom_prov();
        arreglo[2] = p.getFono_prov();
            modelop.addRow(arreglo);
        tbl_proveedor_selec.setModel(modelop);
    
        
        modeloFs.addColumn("Codigo");
        modeloFs.addColumn("Nombre");
        modeloFs.addColumn("Cantidad Comprada");
        modeloFs.addColumn("Precio de Compra");
       
        tbl_productos_seleccionados.setModel(modeloFs);
        sw=1;
    }

    ven_factura(FacturaCompra fc) {
        initComponents(); 
          this.setLocationRelativeTo(null);
          
        modeloFs.addColumn("Codigo");
        modeloFs.addColumn("Cantidad Comprada");
        modeloFs.addColumn("Precio de Compra");
        tbl_productos_seleccionados.setModel(modeloFs);
        tbl_productos.setModel(qp.cargardatos());
        cmb_filtro_productos.setModel(cargarcmb_filtro());
        tbl_proveedor_selec.setModel(qprov.cargardatosprov(fc.getCod_prov()));
        quitar = 1;
          
       modeloFs = qdfc.cargardatosEspecificos(fc);
        tbl_productos_seleccionados.setModel(modeloFs);
        
        txt_num_factura.setText(String.valueOf(fc.getNum_factura()));
        txt_fecha_compra.setText(fc.getFecha_compra());
        lbl_Total.setText(String.valueOf(fc.getTotal()));
        Total = fc.getTotal(); 
        sw=2;
        btn_guardar.setVisible(false);
        txt_num_factura.setEditable(false);
         
    }

    ven_factura(Proveedores p, int num_factura, String fecha_compra, int total) {
         initComponents();
          this.setLocationRelativeTo(null);
        tbl_productos.setModel(qp.cargardatos());
        cmb_filtro_productos.setModel(cargarcmb_filtro());
         modelop.addColumn("Codigo de proveedor");
        modelop.addColumn("Nombre de proveedor");
        modelop.addColumn("fono");
        String[] arreglo = new String[3];
        arreglo[0] = p.getCod_prov();
        arreglo[1] = p.getNom_prov();
        arreglo[2] = p.getFono_prov();
            modelop.addRow(arreglo);
        tbl_proveedor_selec.setModel(modelop);
            
       modeloFs = qdfc.cargardatos();
        tbl_productos_seleccionados.setModel(modeloFs);
        txt_num_factura.setText(String.valueOf(num_factura));
        txt_fecha_compra.setText(fecha_compra);
        lbl_Total.setText(String.valueOf(total));
        Total = total;
         btn_guardar.setVisible(false);
        txt_num_factura.setEditable(false);
        sw = 2;
    }
    
    
     public ven_factura(String consultar,FacturaCompra fc) {
        initComponents();
          this.setLocationRelativeTo(null);
         
     
      
      
        
        tbl_productos.setModel(qp.cargardatos());
        cmb_filtro_productos.setModel(cargarcmb_filtro());
        tbl_proveedor_selec.setModel(qprov.cargardatosprov(fc.getCod_prov()));
        quitar = 1;
          
        modeloFs = qdfc.cargardatosEspecificos(fc);
        tbl_productos_seleccionados.setModel(modeloFs);
        
        txt_num_factura.setText(String.valueOf(fc.getNum_factura()));
        txt_fecha_compra.setText(fc.getFecha_compra());
        lbl_Total.setText(String.valueOf(fc.getTotal()));
        Total = fc.getTotal(); 
        
        
         btn_buscarp.setVisible(false);
          txt_num_factura.setEditable(false);
          txt_fecha_compra.setEditable(false);
          btn_seleccionar.setVisible(false);
          btn_quitar.setVisible(false);
          btn_modificar.setVisible(false);
          btn_guardar.setVisible(false);
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
        lbl_proveedor = new javax.swing.JLabel();
        btn_buscarp = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_proveedor_selec = new javax.swing.JTable();
        lbl_num_factura = new javax.swing.JLabel();
        txt_num_factura = new javax.swing.JTextField();
        lbl_fecha_compra = new javax.swing.JLabel();
        txt_fecha_compra = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_productos = new javax.swing.JTable();
        lbl_productos = new javax.swing.JLabel();
        txt_precio = new javax.swing.JTextField();
        lbl_precio = new javax.swing.JLabel();
        lbl_cantidad = new javax.swing.JLabel();
        txt_cantidad = new javax.swing.JTextField();
        btn_seleccionar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_productos_seleccionados = new javax.swing.JTable();
        btn_quitar = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        cmb_filtro_productos = new javax.swing.JComboBox<>();
        txt_filtro_productos = new javax.swing.JTextField();
        lbl_titulo_total = new javax.swing.JLabel();
        lbl_Total = new javax.swing.JLabel();
        btn_volver = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_proveedor.setText("Proveedor");

        btn_buscarp.setText("buscar p");
        btn_buscarp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_buscarpMouseClicked(evt);
            }
        });

        tbl_proveedor_selec.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbl_proveedor_selec);

        lbl_num_factura.setText("Num Factura");

        txt_num_factura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_num_facturaKeyTyped(evt);
            }
        });

        lbl_fecha_compra.setText("Fecha compra");

        txt_fecha_compra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_fecha_compraKeyTyped(evt);
            }
        });

        tbl_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tbl_productos);

        lbl_productos.setText("Productos");

        txt_precio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_precioKeyTyped(evt);
            }
        });

        lbl_precio.setText("Precio");

        lbl_cantidad.setText("Cantidad");

        txt_cantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cantidadKeyTyped(evt);
            }
        });

        btn_seleccionar.setText("Seleccionar");
        btn_seleccionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_seleccionarMouseClicked(evt);
            }
        });

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

        btn_guardar.setText("Guardar");
        btn_guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_guardarMouseClicked(evt);
            }
        });

        cmb_filtro_productos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txt_filtro_productos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_filtro_productosKeyReleased(evt);
            }
        });

        lbl_titulo_total.setText("Total:");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_precio, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_precio, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_seleccionar)))
                        .addGap(123, 123, 123))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_titulo_total, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addComponent(btn_quitar)
                        .addGap(153, 153, 153))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_productos, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmb_filtro_productos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(txt_filtro_productos, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(114, 114, 114))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_fecha_compra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_num_factura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_proveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(btn_buscarp)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_num_factura)
                                    .addComponent(txt_fecha_compra, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_volver, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(153, 153, 153)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_buscarp)
                    .addComponent(lbl_proveedor)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_num_factura)
                    .addComponent(txt_num_factura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_fecha_compra)
                    .addComponent(txt_fecha_compra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(lbl_productos, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbl_precio, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbl_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn_seleccionar)))
                        .addGap(59, 59, 59)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmb_filtro_productos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_filtro_productos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btn_quitar)
                                .addComponent(lbl_titulo_total, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_volver, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(146, Short.MAX_VALUE))
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

    private void btn_buscarpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_buscarpMouseClicked
      if (sw==2){
          ven_buscar_proveedor vbuscarp = new ven_buscar_proveedor(sw,Integer.parseInt(txt_num_factura.getText()),txt_fecha_compra.getText(),Integer.parseInt(lbl_Total.getText()));
        vbuscarp.setVisible(true);
        this.dispose(); 
      }else if(sw==1){
          ven_buscar_proveedor vbuscarprov = new ven_buscar_proveedor(sw);
          vbuscarprov.setVisible(true);
          this.dispose();
      }
       
    }//GEN-LAST:event_btn_buscarpMouseClicked

    private void txt_filtro_productosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_filtro_productosKeyReleased
        String buscar = (String) cmb_filtro_productos.getSelectedItem();
        Qproductos qp = new Qproductos();
        tbl_productos.setModel(qp.buscarDatos(txt_filtro_productos.getText(), buscar));
    }//GEN-LAST:event_txt_filtro_productosKeyReleased

    private void btn_seleccionarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_seleccionarMouseClicked
      
        int fila = tbl_productos.getSelectedRow();

        String codigo = (String) tbl_productos.getValueAt(fila,0);
        
        String[] arreglo = new String[4];
      
        arreglo[0] =  codigo;
        arreglo[1] = txt_cantidad.getText();
        arreglo[2] = txt_precio.getText();
        modeloFs.addRow(arreglo);
        tbl_productos_seleccionados.setModel(modeloFs);
        Total = Total + (Integer.parseInt(txt_precio.getText())*Integer.parseInt(txt_cantidad.getText()));
        txt_cantidad.setText("");
        txt_precio.setText("");
        lbl_Total.setText(String.valueOf(Total));
    }//GEN-LAST:event_btn_seleccionarMouseClicked

    private void btn_quitarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_quitarMouseClicked
       int index = tbl_productos_seleccionados.getSelectedRow();
      
     String cantidad =  (String) tbl_productos_seleccionados.getValueAt(index,1);
      String precio = (String) tbl_productos_seleccionados.getValueAt(index,2);
       Total = Total - (Integer.parseInt(cantidad)*Integer.parseInt(precio));
       lbl_Total.setText(String.valueOf(Total));  
       if(index >= 0){
              modeloFs.removeRow(index);
          }
    }//GEN-LAST:event_btn_quitarMouseClicked

    private void btn_guardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_guardarMouseClicked
        fc.setNum_factura(Integer.parseInt(txt_num_factura.getText()));
        fc.setCod_prov((String) tbl_proveedor_selec.getValueAt(0,0));
        fc.setFecha_compra(txt_fecha_compra.getText());
        fc.setTotal(Total);
        int error = 0;
    if(txt_num_factura.getText().equals("")){
        error = 1;
    }else if(tbl_proveedor_selec.getRowCount()==0){
        error = 1;
    }else if(txt_fecha_compra.getText().equals("")){
        error = 1;
    }else if (tbl_productos_seleccionados.getRowCount()==0){
        error = 1;
    }    
    
    if(error == 1){
        System.out.println("error");
    }else{
        try {
            qfc.agregarFacturaCompra(fc);
        } catch (ParseException ex) {
            Logger.getLogger(ven_pedido.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        //-----------------------------------detalle factura compra
        
           int i = tbl_productos_seleccionados.getRowCount();
         int num_factura = Integer.parseInt(txt_num_factura.getText());
         int cont = 0;
        while (i>0){  
         dfc.setCod_prod((String) tbl_productos_seleccionados.getValueAt(cont,0));
         String cantidad = ((String) tbl_productos_seleccionados.getValueAt(cont,1));
         String precio = ((String) tbl_productos_seleccionados.getValueAt(cont, 2));
         dfc.setCant_prod(Integer.parseInt(cantidad));
         dfc.setPrecio(Integer.parseInt(precio));
         dfc.setCod_prov((String) tbl_proveedor_selec.getValueAt(0,0));
            
            
         qdfc.agregarDetalleFacturaCompra(dfc,num_factura);
          cont++;
         i--;   
        }
         
        ven_mantenedor_factura vmf = new ven_mantenedor_factura();
        vmf.setVisible(true);
        this.dispose();
    }    
    }//GEN-LAST:event_btn_guardarMouseClicked

    private void btn_modificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_modificarMouseClicked
         fc.setNum_factura(Integer.parseInt(txt_num_factura.getText()));
        fc.setCod_prov((String) tbl_proveedor_selec.getValueAt(0,0));
        fc.setFecha_compra(txt_fecha_compra.getText());
        fc.setTotal(Total);
        
        if (JOptionPane.showConfirmDialog(null, "Desea modificar la factura  " + fc.getNum_factura(), "Modificar factura",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null) == JOptionPane.OK_OPTION) {
        qdfc.eliminarDetalleFacturaCompra(fc.getNum_factura());
        qfc.eliminarFacturaCompra(fc.getNum_factura());
        
           try {
            qfc.agregarFacturaCompra(fc);
        } catch (ParseException ex) {
            Logger.getLogger(ven_pedido.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        //-----------------------------------detalle factura compra
        
           int i = tbl_productos_seleccionados.getRowCount();
         int num_factura = Integer.parseInt(txt_num_factura.getText());
         int cont = 0;
        while (i>0){  
         dfc.setCod_prod((String) tbl_productos_seleccionados.getValueAt(cont,0));
         String cantidad = ((String) tbl_productos_seleccionados.getValueAt(cont,1));
         String precio = ((String) tbl_productos_seleccionados.getValueAt(cont, 2));
         dfc.setCant_prod(Integer.parseInt(cantidad));
         dfc.setPrecio(Integer.parseInt(precio));
         dfc.setCod_prov((String) tbl_proveedor_selec.getValueAt(0,0));
            
            
         qdfc.agregarDetalleFacturaCompra(dfc,num_factura);
          cont++;
         i--;   
        }
         
        ven_mantenedor_factura vmf = new ven_mantenedor_factura();
        vmf.setVisible(true);
        this.dispose();
        
        }
       
    }//GEN-LAST:event_btn_modificarMouseClicked

    private void btn_volverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_volverMouseClicked
       ven_mantenedor_factura vmf = new ven_mantenedor_factura();
       vmf.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btn_volverMouseClicked

    private void txt_num_facturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_num_facturaKeyTyped
        // TODO add your handling code here:
  
        vali.validarlargonumerico(evt, txt_num_factura,6);
    }//GEN-LAST:event_txt_num_facturaKeyTyped

    private void txt_fecha_compraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_fecha_compraKeyTyped
        
        vali.validarlargoalfa(evt, txt_fecha_compra,10);
    }//GEN-LAST:event_txt_fecha_compraKeyTyped

    private void txt_precioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_precioKeyTyped
      
        vali.validarlargonumerico(evt, txt_precio,6);
    }//GEN-LAST:event_txt_precioKeyTyped

    private void txt_cantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cantidadKeyTyped

        vali.validarlargonumerico(evt, txt_cantidad,3);
    }//GEN-LAST:event_txt_cantidadKeyTyped

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
            java.util.logging.Logger.getLogger(ven_factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ven_factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ven_factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ven_factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ven_factura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_buscarp;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_quitar;
    private javax.swing.JButton btn_seleccionar;
    private javax.swing.JButton btn_volver;
    private javax.swing.JComboBox<String> cmb_filtro_productos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_Total;
    private javax.swing.JLabel lbl_cantidad;
    private javax.swing.JLabel lbl_fecha_compra;
    private javax.swing.JLabel lbl_num_factura;
    private javax.swing.JLabel lbl_precio;
    private javax.swing.JLabel lbl_productos;
    private javax.swing.JLabel lbl_proveedor;
    private javax.swing.JLabel lbl_titulo_total;
    private javax.swing.JTable tbl_productos;
    private javax.swing.JTable tbl_productos_seleccionados;
    private javax.swing.JTable tbl_proveedor_selec;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JTextField txt_fecha_compra;
    private javax.swing.JTextField txt_filtro_productos;
    private javax.swing.JTextField txt_num_factura;
    private javax.swing.JTextField txt_precio;
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
