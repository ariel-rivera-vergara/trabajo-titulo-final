/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package querys;

import clases.Conectar;
import clases.DetalleFacturaCompra;
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
public class QDetalleFacturaCompra {
    
    
     public void agregarDetalleFacturaCompra (DetalleFacturaCompra dfc ,int num_factura) {
        Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        try {
            String query = "INSERT INTO detalle_factura_compra VALUES ("
                    + "'" + num_factura + "',"
                    + "'" + dfc.getCod_prov() + "',"
                    + "'" +  dfc.getCod_prod()+ "',"
                    + "'" +  dfc.getCant_prod()+ "',"
                    + "'" + dfc.getPrecio() + "'"
                    + ")";

            Statement st = cn.createStatement();
            st.executeUpdate(query);

       
            System.out.println("ingresado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Numero de factura ya ingresada");
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
     
          public void eliminarDetalleFacturaCompra(int num_factura) {
        Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        try {
            String query = "Delete FROM detalle_factura_compra"
                    + " where num_factura='" + num_factura + "'"; //espacio + where para evitar error de sintaxis

            Statement st = cn.createStatement();
            st.executeUpdate(query);
            System.out.println("eliminado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "no existe ese numero de factura a eliminar");
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

            String query = "SELECT cod_prod,cant_prod,precio FROM detalle_factura_compra";
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
                Logger.getLogger(QDetalleFacturaCompra.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return modelo;
    }
           
           
    private DefaultTableModel crearbase() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Codigo de Producto");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio");
        return modelo;
    }
        
    
}
