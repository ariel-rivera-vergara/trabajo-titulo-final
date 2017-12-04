/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package querys;

import clases.Conectar;
import clases.DetallePedido;
import clases.OrdenPedido;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ariel
 */
public class QdetallePedido {

    public void agregarDetallePedido(DetallePedido dp) {
        Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        int codigo = 0;
        try {
         

            String query2 = "select max(cod_pedido) from orden_de_pedido";

            Statement st = cn.createStatement();
            
            ResultSet rs = st.executeQuery(query2);
            while (rs.next()) {
                codigo = rs.getInt(1);
            }
            System.out.println(codigo);

               String query = "INSERT INTO detalle_pedido VALUES ("
                    + "'" + codigo + "',"
                    + "'" + dp.getCod_producto() + "',"
                    + "'" + dp.getCantidad() + "'"
                    + ")";
            st.executeUpdate(query);

            System.out.println("ingresado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Codigo de producto ya ingresado");
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

    public void eliminarDetalleDePedido(String codigo) {
        Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        try {
            String query = "Delete FROM detalle_pedido"
                    + " where cod_pedido='" + codigo + "'"; //espacio + where para evitar error de sintaxis

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

            String query = "SELECT * FROM detalle_pedido";
            String[] arreglo = new String[3];
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                arreglo[0] = rs.getString(1);
                arreglo[1] = rs.getString(2);
                arreglo[2] = rs.getString(3);
                modelo.addRow(arreglo);

            }

        } catch (SQLException e) {
            System.out.println("error" + e);
        } finally {

            try {
                connection.cerrar();
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(QdetallePedido.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return modelo;
    }

    private DefaultTableModel crearbase() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Codigo de pedido");
        modelo.addColumn("Codigo de producto");
        modelo.addColumn("Cantidad");
        return modelo;
    }

    public void agregarDetallePedidoM(DetallePedido dp) {
         Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        try {
               String query = "INSERT INTO detalle_pedido VALUES ("
                    + "'" + Integer.parseInt(dp.getCod_pedido()) + "',"
                    + "'" + dp.getCod_producto() + "',"
                    + "'" + dp.getCantidad() + "'"
                    + ")";
           Statement st = cn.createStatement();
            st.executeUpdate(query);


            System.out.println("ingresado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Codigo de producto ya ingresado");
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

    public DefaultTableModel cargardatosEspecifico(OrdenPedido odp) {

        Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        DefaultTableModel modelo = crearbase();
        try {

            String query = "select * FROM detalle_pedido"
                    + " where cod_pedido='" + odp.getCod_pedido() + "'";
            String[] arreglo = new String[3];
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                arreglo[0] = rs.getString(1);
                arreglo[1] = rs.getString(2);
                arreglo[2] = rs.getString(3);
                modelo.addRow(arreglo);

            }

        } catch (SQLException e) {
            System.out.println("error" + e);
        } finally {

            try {
                connection.cerrar();
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(QdetallePedido.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return modelo;
    }

}
