/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package querys;

import clases.Conectar;
import clases.Validar;
import clases.venta;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ariel
 */
public class Qventa {

    Validar vali = new Validar();

    public void agregarventa(venta ven) throws ParseException {

        Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        try {
            //hay que cambiar los valores para integrar el idusuario
            String query = "INSERT INTO venta(rut_cliente,id_usuario,fecha_rec,fecha_ent,abono,saldo,total_venta,tipo_pago,"
                    + "num_boleta,rut_pretiro,receta) VALUES ("
                    // + "'" + ven.getid_venta + "',"
                    + "'" + ven.getRut_cliente() + "',"
                    + "'" + ven.getId_usuario() + "',"
                    + "'" + vali.ParseFecha(ven.getFecha_rec()) + "',"
                    + "'" + vali.ParseFecha(ven.getFecha_ent()) + "',"
                    + "'" + ven.getAbono() + "',"
                    + "'" + ven.getSaldo() + "',"
                    + "'" + ven.getTotal_vent() + "',"
                    + "'" + ven.getTipo_pago() + "',"
                    + "'" + ven.getNum_boleta() + "',"
                    + "'" + ven.getRut_pretiro() + "',"
                    + "'" + ven.getReceta() + "'"
                    + ")";

            Statement st = cn.createStatement();
            st.executeUpdate(query);

            System.out.println("ingresado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Codigo de venta ya ingresado");
            System.out.println("error" + e);
        } finally {
            try {
                connection.cerrar();
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Qproductos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    
    
    
     public void agregarventaM(venta ven) throws ParseException {

        Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        try {
            
            String query = "INSERT INTO venta(id_venta,rut_cliente,id_usuario,fecha_rec,fecha_ent,abono,saldo,total_venta,tipo_pago,"
                    + "num_boleta,rut_pretiro,receta) VALUES ("
                     + "'" + ven.getId_venta() + "',"
                    + "'" + ven.getRut_cliente() + "',"
                    + "'" + ven.getId_usuario() + "',"
                    + "'" + vali.ParseFecha(ven.getFecha_rec()) + "',"
                    + "'" + vali.ParseFecha(ven.getFecha_ent()) + "',"
                    + "'" + ven.getAbono() + "',"
                    + "'" + ven.getSaldo() + "',"
                    + "'" + ven.getTotal_vent() + "',"
                    + "'" + ven.getTipo_pago() + "',"
                    + "'" + ven.getNum_boleta() + "',"
                    + "'" + ven.getRut_pretiro() + "',"
                    + "'" + ven.getReceta() + "'"
                    + ")";

            Statement st = cn.createStatement();
            st.executeUpdate(query);

            System.out.println("ingresado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Codigo de venta ya ingresado");
            System.out.println("error" + e);
        } finally {
            try {
                connection.cerrar();
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Qproductos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    
     }
    
    
       
         public void eliminarVenta(String id_ventas) {
        Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        try {
            String query = "Delete FROM venta"
                    + " where id_venta ='" + id_ventas + "'"; //espacio + where para evitar error de sintaxis

            Statement st = cn.createStatement();
            st.executeUpdate(query);
            System.out.println("eliminado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "no existe ese codigo a eliminar");
            System.out.println("error" + e);
        } finally {
            try {
                connection.cerrar();
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(QordenDePedido.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    

    public DefaultTableModel cargardatos() {
        Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        DefaultTableModel modelo = crearbase();
        try {

            String query = "SELECT * FROM venta";
            String[] arreglo = new String[12];
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                arreglo[0] = rs.getString(1);
                arreglo[1] = rs.getString(2);
                arreglo[2] = rs.getString(3);
                arreglo[3] = rs.getString(4);
                arreglo[4] = rs.getString(5);
                arreglo[5] = rs.getString(6);
                arreglo[6] = rs.getString(7);
                arreglo[7] = rs.getString(8);
                arreglo[8] = rs.getString(9);
                arreglo[9] = rs.getString(10);
                arreglo[10] = rs.getString(11);
                arreglo[11] = rs.getString(12);

                modelo.addRow(arreglo);

            }

        } catch (SQLException e) {
            System.out.println("error" + e);
        } finally {

            try {
                connection.cerrar();
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(QordenDePedido.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return modelo;
    }

    private DefaultTableModel crearbase() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Id de venta");
        modelo.addColumn("Rut de Cliente");
        modelo.addColumn("ID usuario");
        modelo.addColumn("Fecha Recibo");
        modelo.addColumn("Fecha Entrega");
        modelo.addColumn("Abono");
        modelo.addColumn("Saldo");
        modelo.addColumn("Total de venta");
        modelo.addColumn("Tipo de pago");
        modelo.addColumn("Numero de boleta");
        modelo.addColumn("Rut persona que retira");
        modelo.addColumn("Receta");

        return modelo;
    }

    public DefaultTableModel buscarDatos(String txt, String buscar) {
        DefaultTableModel modelo = crearbase();
        Conectar connection = new Conectar();
        Connection cn = connection.getconnect();

        try {
            String query = "";
            buscar = buscar.trim();
            switch (buscar) {

                case "Id de venta":
                    query = "SELECT * FROM venta WHERE id_venta LIKE '%" + txt + "%'";
                    break;

                case "Rut de cliente":
                    query = "SELECT * FROM venta WHERE rut_cliente  LIKE '%" + txt + "%'";
                    break;

                case "ID usuario":
                    query = "SELECT * FROM venta WHERE id_usuario  LIKE '%" + txt + "%'";
                    break;

                case "Fecha recibo":
                    query = "SELECT * FROM venta WHERE fecha_rec  LIKE '%" + txt + "%'";
                    break;

                case "Fecha entrega":
                    query = "SELECT * FROM venta WHERE fecha_ent LIKE '%" + txt + "%'";
                    break;

                case "Abono":
                    query = "SELECT * FROM venta WHERE abono LIKE '%" + txt + "%'";
                    break;

                case "Saldo":
                    query = "SELECT * FROM venta WHERE saldo LIKE '%" + txt + "%'";
                    break;

                case "Total":
                    query = "SELECT * FROM venta WHERE total_venta LIKE '%" + txt + "%'";
                    break;

                case "Tipo de pago":
                    query = "SELECT * FROM venta WHERE tipo_pago LIKE '%" + txt + "%'";
                    break;

                case "Numero de boleta":
                    query = "SELECT * FROM venta WHERE num_boleta LIKE '%" + txt + "%'";
                    break;

                case "Rut persona que retira":
                    query = "SELECT * FROM venta WHERE rut_pretiro LIKE '%" + txt + "%'";
                    break;

                case "Receta":
                    query = "SELECT * FROM venta WHERE receta LIKE '%" + txt + "%'";
                    break;

            }

            String[] arreglo = new String[12];
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                arreglo[0] = rs.getString(1);
                arreglo[1] = rs.getString(2);
                arreglo[2] = rs.getString(3);
                arreglo[3] = rs.getString(4);
                arreglo[4] = rs.getString(5);
                arreglo[5] = rs.getString(6);
                arreglo[6] = rs.getString(7);
                arreglo[7] = rs.getString(8);
                arreglo[8] = rs.getString(9);
                arreglo[9] = rs.getString(10);
                arreglo[10] = rs.getString(11);
                arreglo[11] = rs.getString(12);

                modelo.addRow(arreglo);

            }

        } catch (SQLException e) {
            System.out.println("error" + e);
        } finally {

            try {
                connection.cerrar();
                cn.close();
            } catch (SQLException ex) {
                //  Logger.getLogger(Querys..class.getName()).log(Level.SEVERE, null, ex); 
            }
        }
        return modelo;

    }

}
