/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pantasha;

import clases.Cliente;
import clases.ProductoVenta;
import clases.venta;
import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import querys.Qcliente;
import querys.Qprod_ventas;
import querys.Qventa;

public class ven_detalle_venta extends javax.swing.JFrame {

    DefaultTableModel modelopsl = new DefaultTableModel();
    DefaultTableModel modelocli = new DefaultTableModel();
    Qprod_ventas qproven = new Qprod_ventas();
    Qventa qven = new Qventa();
    Qcliente qcli = new Qcliente();
    String receta = "";
    Calendar c2 = new GregorianCalendar();
    int total = 0;
    venta ven = new venta();
    ProductoVenta proven = new ProductoVenta();
    String modificar = "";

    public ven_detalle_venta() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    ven_detalle_venta(DefaultTableModel modelopsl, JTextArea Atxt_receta, int total) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.modelopsl = modelopsl;
        tbl_productos_seleccionados.setModel(this.modelopsl);
        cmb_tipo_pago.setModel(cargarcmb_tipopago());
        this.receta = Atxt_receta.getText();
        String dia = Integer.toString(c2.get(Calendar.DATE));
        // recordar buscar como arreglar el problema de la fecha
        String mes = Integer.toString(c2.get(Calendar.MONTH) + 1);
        String annio = Integer.toString(c2.get(Calendar.YEAR));
        String fecha = annio + "-" + mes + "-" + dia;
        this.total = total;
        lbl_total.setText(String.valueOf(total));
        lbl_fecha_actual.setText(fecha);
    }

    ven_detalle_venta(Cliente cli, DefaultTableModel modelopsl, String receta, int total) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.modelopsl = modelopsl;
        tbl_productos_seleccionados.setModel(this.modelopsl);
        modelocli.addColumn("Rut de Cliente");
        modelocli.addColumn("Nombre de Cliente");
        modelocli.addColumn("fono");
        String[] arreglo = new String[3];
        arreglo[0] = cli.getRut_cliente();
        arreglo[1] = cli.getNom_cliente();
        arreglo[2] = cli.getFono_cliente();
        modelocli.addRow(arreglo);
        tbl_cliente.setModel(modelocli);
        cmb_tipo_pago.setModel(cargarcmb_tipopago());
        System.out.println(receta);
        String dia = Integer.toString(c2.get(Calendar.DATE));
        // recordar buscar como arreglar el problema de la fecha
        String mes = Integer.toString(c2.get(Calendar.MONTH) + 1);
        String annio = Integer.toString(c2.get(Calendar.YEAR));
        String fecha = annio + "-" + mes + "-" + dia;
        this.total = total;
        this.receta = receta;
        System.out.println(fecha);
        lbl_total.setText(String.valueOf(total));
        lbl_fecha_actual.setText(fecha);
    }

    ven_detalle_venta(int total, String consultar, venta ven) {
        initComponents();
        this.setLocationRelativeTo(null);
        cmb_tipo_pago.setModel(cargarcmb_tipopago());
        btn_buscar_cliente.setVisible(false);
        btn_agregar_cliente.setVisible(false);
        btn_Generar_venta.setVisible(false);
        modelocli = qcli.cargardatosEspecificos(ven.getRut_cliente());
        tbl_cliente.setModel(modelocli);
        tbl_productos_seleccionados.setModel(qproven.cargardatosEspecificos(ven));
        lbl_total.setText(String.valueOf(total));
        lbl_fecha_actual.setText(ven.getFecha_rec());
        txt_fecha_entrega.setText(ven.getFecha_ent());
        txt_fecha_entrega.setEditable(false);
        txt_num_boleta.setText(String.valueOf(ven.getNum_boleta()));
        txt_num_boleta.setEditable(false);
        txt_abono.setText(String.valueOf(ven.getAbono()));
        txt_abono.setEditable(false);
        lbl_saldo_pagar.setText(String.valueOf(ven.getSaldo()));

        if (ven.getTipo_pago().equals("E")) {
            cmb_tipo_pago.setSelectedIndex(0);
        } else if (ven.getTipo_pago().equals("T")) {
            cmb_tipo_pago.setSelectedIndex(1);
        } else if (ven.getTipo_pago().equals("C")) {
            cmb_tipo_pago.setSelectedIndex(2);
        }

        txt_rutpretira.setText(ven.getRut_pretiro());
        txt_rutpretira.setEditable(false);

    }

    ven_detalle_venta(int total, venta ven, String modificar, DefaultTableModel modelopsl) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.modificar = modificar;
        this.ven = ven;
        System.out.println("venta de constructor en detalle venta" + ven.getId_venta());
        this.total = total;
        btn_Generar_venta.setVisible(false);
        cmb_tipo_pago.setModel(cargarcmb_tipopago());
        modelocli = qcli.cargardatosEspecificos(ven.getRut_cliente());
        tbl_cliente.setModel(modelocli);
        this.modelopsl = modelopsl;
        tbl_productos_seleccionados.setModel(modelopsl);
        lbl_total.setText(String.valueOf(total));
        lbl_fecha_actual.setText(ven.getFecha_rec());
        txt_fecha_entrega.setText(ven.getFecha_ent());
        txt_num_boleta.setText(String.valueOf(ven.getNum_boleta()));
        txt_abono.setText(String.valueOf(ven.getAbono()));
        lbl_saldo_pagar.setText(String.valueOf(ven.getSaldo()));
        if (ven.getTipo_pago().equals("E")) {
            cmb_tipo_pago.setSelectedIndex(0);
        } else if (ven.getTipo_pago().equals("T")) {
            cmb_tipo_pago.setSelectedIndex(1);
        } else if (ven.getTipo_pago().equals("C")) {
            cmb_tipo_pago.setSelectedIndex(2);
        }
        txt_rutpretira.setText(ven.getRut_pretiro());
    }

    ven_detalle_venta(Cliente cli, venta ven, String modificar, int total, DefaultTableModel modelopsl) {
        initComponents();
        this.setLocationRelativeTo(null);

        modelocli.addColumn("Rut de Cliente");
        modelocli.addColumn("Nombre de Cliente");
        modelocli.addColumn("fono");
        String[] arreglo = new String[3];
        arreglo[0] = cli.getRut_cliente();
        arreglo[1] = cli.getNom_cliente();
        arreglo[2] = cli.getFono_cliente();
        modelocli.addRow(arreglo);
        tbl_cliente.setModel(modelocli);

        this.modificar = modificar;
        this.total = total;
        receta = ven.getReceta();
        this.ven = ven;
        this.modelopsl = modelopsl;
        System.out.println("venta en constructor de detalle despues de buscar cliente" + ven.getId_venta());
        btn_Generar_venta.setVisible(false);

        cmb_tipo_pago.setModel(cargarcmb_tipopago());

        tbl_productos_seleccionados.setModel(modelopsl);

        lbl_total.setText(String.valueOf(total));

        lbl_fecha_actual.setText(ven.getFecha_rec());

        txt_fecha_entrega.setText(ven.getFecha_ent());

        txt_num_boleta.setText(String.valueOf(ven.getNum_boleta()));

        txt_abono.setText(String.valueOf(ven.getAbono()));

        lbl_saldo_pagar.setText(String.valueOf(ven.getSaldo()));

        if (ven.getTipo_pago().equals("E")) {
            cmb_tipo_pago.setSelectedIndex(0);

        } else if (ven.getTipo_pago().equals("T")) {
            cmb_tipo_pago.setSelectedIndex(1);

        } else if (ven.getTipo_pago().equals("C")) {
            cmb_tipo_pago.setSelectedIndex(2);
        }

        txt_rutpretira.setText(ven.getRut_pretiro());
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
        tbl_cliente = new javax.swing.JTable();
        btn_buscar_cliente = new javax.swing.JButton();
        btn_agregar_cliente = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_productos_seleccionados = new javax.swing.JTable();
        lbl_fecha_emision = new javax.swing.JLabel();
        lbl_fecha_entrega = new javax.swing.JLabel();
        lbl_num_boleta = new javax.swing.JLabel();
        lbl_abono = new javax.swing.JLabel();
        lbl_saldo = new javax.swing.JLabel();
        cmb_tipo_pago = new javax.swing.JComboBox<>();
        lbl_tipo_pago = new javax.swing.JLabel();
        txt_fecha_entrega = new javax.swing.JTextField();
        txt_num_boleta = new javax.swing.JTextField();
        txt_abono = new javax.swing.JTextField();
        lbl_nomtotal = new javax.swing.JLabel();
        lbl_total = new javax.swing.JLabel();
        btn_Generar_venta = new javax.swing.JButton();
        btn_volver = new javax.swing.JButton();
        lbl_fecha_actual = new javax.swing.JLabel();
        lbl_saldo_pagar = new javax.swing.JLabel();
        lbl_rut_pretira = new javax.swing.JLabel();
        txt_rutpretira = new javax.swing.JTextField();
        btn_modificar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbl_cliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbl_cliente);

        btn_buscar_cliente.setText("Buscar cliente");
        btn_buscar_cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_buscar_clienteMouseClicked(evt);
            }
        });

        btn_agregar_cliente.setText("Agregar cliente");
        btn_agregar_cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_agregar_clienteMouseClicked(evt);
            }
        });

        tbl_productos_seleccionados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tbl_productos_seleccionados);

        lbl_fecha_emision.setText("Fecha Emision");

        lbl_fecha_entrega.setText("Fecha Entrega");

        lbl_num_boleta.setText("Numero De Boleta");

        lbl_abono.setText("Abono");

        lbl_saldo.setText("Saldo");

        cmb_tipo_pago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lbl_tipo_pago.setText("Tipo De Pago");

        txt_abono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_abonoKeyReleased(evt);
            }
        });

        lbl_nomtotal.setText("Total:");

        lbl_total.setText("0");

        btn_Generar_venta.setText("Generar Venta");
        btn_Generar_venta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_Generar_ventaMouseClicked(evt);
            }
        });

        btn_volver.setText("Volver");
        btn_volver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_volverMouseClicked(evt);
            }
        });

        lbl_saldo_pagar.setText("0");

        lbl_rut_pretira.setText("Rut persona que retira ");

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
                .addContainerGap()
                .addComponent(btn_buscar_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_agregar_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(91, 91, 91))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_nomtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_fecha_emision, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addComponent(lbl_fecha_actual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_Generar_venta)
                                .addGap(18, 18, 18)
                                .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_abono, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_abono, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_saldo, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_fecha_entrega, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_fecha_entrega, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                    .addComponent(lbl_saldo_pagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(33, 33, 33)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbl_num_boleta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbl_tipo_pago, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addComponent(cmb_tipo_pago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_num_boleta, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(254, 254, 254)
                                .addComponent(btn_volver, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(lbl_rut_pretira, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_rutpretira, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_buscar_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_agregar_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_nomtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_total, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_fecha_emision, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_fecha_entrega, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_fecha_entrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_num_boleta, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_num_boleta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_fecha_actual, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_abono, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_saldo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmb_tipo_pago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_tipo_pago, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_abono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_saldo_pagar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_rut_pretira, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(txt_rutpretira, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_Generar_venta)
                        .addComponent(btn_volver))
                    .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 47, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_abonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_abonoKeyReleased
        if (txt_abono.getText().equals("")) {
            txt_abono.setText(String.valueOf(0));
        } else if (Integer.parseInt(txt_abono.getText()) > total) {
            txt_abono.setText(String.valueOf(total));
        }
        lbl_saldo_pagar.setText(String.valueOf(total - Integer.parseInt(txt_abono.getText())));
    }//GEN-LAST:event_txt_abonoKeyReleased

    private void btn_buscar_clienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_buscar_clienteMouseClicked
        if (modificar.equals("s")) {
            System.out.println("venta antes de ir a buscar cliente " + ven.getId_venta());
            ven_buscar_cliente vbc = new ven_buscar_cliente(ven, total, modificar, modelopsl);
            this.dispose();
            vbc.setVisible(true);
        } else {
            ven_buscar_cliente vbc = new ven_buscar_cliente(modelopsl, receta, total);
            this.dispose();
            vbc.setVisible(true);
        }
    }//GEN-LAST:event_btn_buscar_clienteMouseClicked

    private void btn_agregar_clienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_agregar_clienteMouseClicked

        if (modificar.equals("s")) {
            ven_agregar_cliente vac = new ven_agregar_cliente(ven, total, modificar, modelopsl);
            this.dispose();
            vac.setVisible(true);
        } else {
            ven_agregar_cliente vac = new ven_agregar_cliente(modelopsl, receta, total);
            this.dispose();
            vac.setVisible(true);
        }

    }//GEN-LAST:event_btn_agregar_clienteMouseClicked

    private void btn_Generar_ventaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_Generar_ventaMouseClicked
        ven.setRut_cliente((String) tbl_cliente.getValueAt(0, 0));
        ven.setId_usuario("rutusuario");
        ven.setFecha_rec(lbl_fecha_actual.getText());
        ven.setFecha_ent(txt_fecha_entrega.getText());
        ven.setAbono(Integer.parseInt(txt_abono.getText()));
        ven.setNum_boleta(Integer.parseInt(txt_num_boleta.getText()));
        ven.setSaldo(Integer.parseInt(lbl_saldo_pagar.getText()));
        ven.setTotal_vent(total);

        if (cmb_tipo_pago.getSelectedItem().equals("Efectivo")) {
            ven.setTipo_pago("E");
        } else if (cmb_tipo_pago.getSelectedItem().equals("Tarjeta")) {
            ven.setTipo_pago("T");
        } else if (cmb_tipo_pago.getSelectedItem().equals("Cheque")) {
            ven.setTipo_pago("C");
        }
        ven.setRut_pretiro(txt_rutpretira.getText());
        ven.setReceta(receta);

        try {
            qven.agregarventa(ven);

        } catch (ParseException ex) {
            Logger.getLogger(ven_pedido.class.getName()).log(Level.SEVERE, null, ex);
        }

        // -----------------------------------------------------------  
        int i = tbl_productos_seleccionados.getRowCount();
        int cont = 0;
        while (i > 0) {
            String cantidad = (String) tbl_productos_seleccionados.getValueAt(cont, 3);
            String precio = (String) tbl_productos_seleccionados.getValueAt(cont, 2);
            String subtotal = (String) tbl_productos_seleccionados.getValueAt(cont, 4);

            proven.setCod_prod((String) tbl_productos_seleccionados.getValueAt(cont, 0));
            proven.setCant_vent(Integer.parseInt(cantidad));
            proven.setPrecio_unit(Integer.parseInt(precio));
            proven.setSub_total(Integer.parseInt(subtotal));
            qproven.agregarProductoventa(proven);
            cont++;
            i--;
        }


    }//GEN-LAST:event_btn_Generar_ventaMouseClicked

    private void btn_volverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_volverMouseClicked
        ven_ventas vven = new ven_ventas();
        this.dispose();
        vven.setVisible(true);
    }//GEN-LAST:event_btn_volverMouseClicked

    private void btn_modificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_modificarMouseClicked
        String id_ventas = String.valueOf(ven.getId_venta());

        if (JOptionPane.showConfirmDialog(null, "Desea modificar la venta  " + id_ventas, "modificar venta",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null) == JOptionPane.OK_OPTION) {
            qproven.eliminarProductoVenta(id_ventas);
            qven.eliminarVenta(id_ventas);

            ven.setRut_cliente((String) tbl_cliente.getValueAt(0, 0));
            ven.setId_usuario("rutusuario");
            ven.setFecha_rec(lbl_fecha_actual.getText());
            ven.setFecha_ent(txt_fecha_entrega.getText());
            ven.setAbono(Integer.parseInt(txt_abono.getText()));
            ven.setNum_boleta(Integer.parseInt(txt_num_boleta.getText()));
            ven.setSaldo(Integer.parseInt(lbl_saldo_pagar.getText()));
            ven.setTotal_vent(total);

            if (cmb_tipo_pago.getSelectedItem().equals("Efectivo")) {
                ven.setTipo_pago("E");
            } else if (cmb_tipo_pago.getSelectedItem().equals("Tarjeta")) {
                ven.setTipo_pago("T");
            } else if (cmb_tipo_pago.getSelectedItem().equals("Cheque")) {
                ven.setTipo_pago("C");
            }
            ven.setRut_pretiro(txt_rutpretira.getText());

            try {
                qven.agregarventaM(ven);

            } catch (ParseException ex) {
                Logger.getLogger(ven_pedido.class.getName()).log(Level.SEVERE, null, ex);
            }

            // -----------------------------------------------------------  
            int i = tbl_productos_seleccionados.getRowCount();
            int cont = 0;
            while (i > 0) {
                String cantidad = (String) tbl_productos_seleccionados.getValueAt(cont, 3);
                String precio = (String) tbl_productos_seleccionados.getValueAt(cont, 2);
                String subtotal = (String) tbl_productos_seleccionados.getValueAt(cont, 4);

                proven.setCod_prod((String) tbl_productos_seleccionados.getValueAt(cont, 0));
                proven.setCant_vent(Integer.parseInt(cantidad));
                proven.setPrecio_unit(Integer.parseInt(precio));
                proven.setSub_total(Integer.parseInt(subtotal));
                qproven.agregarProductoventa(proven);
                cont++;
                i--;
            }
            ven_mantenedor_ventas vmv = new ven_mantenedor_ventas();
            this.dispose();
            vmv.setVisible(true);
        }


    }//GEN-LAST:event_btn_modificarMouseClicked

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
            java.util.logging.Logger.getLogger(ven_detalle_venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ven_detalle_venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ven_detalle_venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ven_detalle_venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ven_detalle_venta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Generar_venta;
    private javax.swing.JButton btn_agregar_cliente;
    private javax.swing.JButton btn_buscar_cliente;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_volver;
    private javax.swing.JComboBox<String> cmb_tipo_pago;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_abono;
    private javax.swing.JLabel lbl_fecha_actual;
    private javax.swing.JLabel lbl_fecha_emision;
    private javax.swing.JLabel lbl_fecha_entrega;
    private javax.swing.JLabel lbl_nomtotal;
    private javax.swing.JLabel lbl_num_boleta;
    private javax.swing.JLabel lbl_rut_pretira;
    private javax.swing.JLabel lbl_saldo;
    private javax.swing.JLabel lbl_saldo_pagar;
    private javax.swing.JLabel lbl_tipo_pago;
    private javax.swing.JLabel lbl_total;
    private javax.swing.JTable tbl_cliente;
    private javax.swing.JTable tbl_productos_seleccionados;
    private javax.swing.JTextField txt_abono;
    private javax.swing.JTextField txt_fecha_entrega;
    private javax.swing.JTextField txt_num_boleta;
    private javax.swing.JTextField txt_rutpretira;
    // End of variables declaration//GEN-END:variables

    public DefaultComboBoxModel cargarcmb_tipopago() {
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        modelo.addElement("Efectivo");
        modelo.addElement("Tarjeta");
        modelo.addElement("Cheque");
        return modelo;
    }

}
