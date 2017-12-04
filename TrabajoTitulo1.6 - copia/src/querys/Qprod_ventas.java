/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package querys;

import clases.Conectar;
import clases.ProductoVenta;
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
 * @author Ivan
 */
public class Qprod_ventas {

    public DefaultTableModel cargardatos() {
        Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        DefaultTableModel modelo = crearbase();
        try {

            String query = "SELECT * FROM `producto_venta`";
            String[] arreglo = new String[5];
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                arreglo[0] = rs.getString(1);
                arreglo[1] = rs.getString(2);
                arreglo[2] = rs.getString(3);
                arreglo[3] = rs.getString(4);
                arreglo[4] = rs.getString(5);
                modelo.addRow(arreglo);

            }

        } catch (SQLException e) {
            System.out.println("error" + e);
        } finally {

            try {
                connection.cerrar();
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Qproductos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return modelo;
    }

    private DefaultTableModel crearbase() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Codigo de producto");
        modelo.addColumn("id venta");
        modelo.addColumn("cantidad");
        modelo.addColumn("precio unitario");
        modelo.addColumn("Detalle receta");

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

                case "Codigo de producto":
                    query = "SELECT * FROM producto_venta WHERE cod_prod LIKE '%" + txt + "%'";
                    break;

                case "id venta":
                    query = "SELECT * FROM producto_venta WHERE id_venta  LIKE '%" + txt + "%'";
                    break;

                case "cantidad":
                    query = "SELECT * FROM producto_venta WHERE cantidad  LIKE '%" + txt + "%'";
                    break;

                case "precio":
                    query = "SELECT * FROM producto_venta WHERE precio_unit  LIKE '%" + txt + "%'";
                    break;

                case "Detalle receta":
                    query = "SELECT * FROM producto_venta WHERE detalle_receta LIKE '%" + txt + "%'";
                    break;

            }
            String[] arreglo = new String[5];
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                arreglo[0] = rs.getString(1);
                arreglo[1] = rs.getString(2);
                arreglo[2] = rs.getString(3);
                arreglo[3] = rs.getString(4);
                arreglo[4] = rs.getString(5);
                modelo.addRow(arreglo);

            }

        } catch (SQLException e) {
            System.out.println("error" + e);
        } finally {

            try {
                connection.cerrar();
                cn.close();
            } catch (SQLException ex) {
                /* Logger.getLogger(Querys..class.getName()).log(Level.SEVERE, null, ex); */
            }
        }
        return modelo;

    }

    public void agregarProductoventa(ProductoVenta proven) {
        Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        int codigo = 0;
        try {

            String query2 = "select max(id_venta) from venta";

            Statement st = cn.createStatement();

            ResultSet rs = st.executeQuery(query2);
            while (rs.next()) {
                codigo = rs.getInt(1);
            }
            

            String query = "INSERT INTO producto_venta() VALUES ("
                    + "'" + codigo + "',"
                    + "'" + proven.getCod_prod() + "',"
                    + "'" + proven.getCant_vent() + "',"
                    + "'" + proven.getPrecio_unit() + "',"
                    + "'" + proven.getSub_total() + "'"
                    + ")";
            st.executeUpdate(query);

            System.out.println("ingresado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Codigo de venta y producto ya ingresado");
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

}
