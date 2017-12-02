/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package querys;

import clases.Conectar;
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
    
    
   /*   public void agregarproducto_venta(provent pv) {
        Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        try {
            String query = "INSERT INTO producto_venta VALUES ("
                    + "'" + pv.getCod_prod() + "',"
                    + "'" + pv.getId_venta() + "',"
                    + "'" + pv.getCant_ven()+ "',"
                    + "'" + pv.getPrecio_unit()+ "',"
                    + "'" + pv.getDetalle_receta() + "'"
                    + ")";

            Statement st = cn.createStatement();
            st.executeUpdate(query);

       
            System.out.println("ingresado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "codigo de producto y venta ya ingresado");
            System.out.println("error" + e);
        } finally {
            try {
                connection.cerrar();
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Qprod_ventas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void modificarproducto_venta(provent pv) {
        Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        try {
            String query = "UPDATE producto_venta SET "
                    + "cant_ven='" + pv.getCant_ven() + "',"
                    + "precio_unit='" + pv.getPrecio_unit() + "',"
                    + "detalle_receta='" + pv.getDetalle_receta() + "'"
                    + " where cod_prod='" + pv.getCod_prod() +  "and id_venta='" + pv.getId_venta() + "'"; //espacio + where para evitar error de sintaxis

            Statement st = cn.createStatement();
            st.executeUpdate(query);
            System.out.println("modificado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "no existe ese codigo, id para modificar");
            System.out.println("error" + e);
        } finally {
            try {
                connection.cerrar();
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Qprod_ventas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    
  
    
    
    
    
   /* public void eliminarproducto_venta(provent pv) {
        Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        try {
            String query = "Delete FROM `producto_venta`"
                    + " where cod_prod='" + pv.getCod_prod() +  "and id_venta='" + pv.getId_venta() + "'"; //espacio + where para evitar error de sintaxis

            Statement st = cn.createStatement();
            st.executeUpdate(query);
            System.out.println("eliminado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "no existe ese codigo, id a eliminar");
            System.out.println("error" + e);
        } finally {
            try {
                connection.cerrar();
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Qprod_ventas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

 /*   public void eliminarprod_ven(String codigo, Int id) {
        Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        try {
            String query = "Delete FROM `producto_venta`"
                    + " where cod_prod='" + codigo + "and id_venta='" + id + "'";  //espacio + where para evitar error de sintaxis

            Statement st = cn.createStatement();
            st.executeUpdate(query);
            System.out.println("eliminado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "no existe ese codigo, id a eliminar");
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

   /* public void consultarproducto_venta(provent pv) {
        Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        try {
            String query = "Select * FROM `producto_venta`"
                    + " where cod_prod='" + pv.getCod_prod() +  "and id_venta='" + pv.getId_venta() + "'";   //espacio + where para evitar error de sintaxis

            Statement st = cn.createStatement();

            ResultSet rs = st.executeQuery(query);
            rs.next();
            System.out.println("consulta del producto realizada");
            String cant = rs.getString("cant_ven");
            String pre_unit = rs.getString("precio_unit");
            String det_receta = rs.getString("detalle_receta");
           

            JOptionPane.showMessageDialog(null, " codigo: " + pv.getCod_prod() + " \n " + "cantidad: " + cant + " \n " + "precio: " + pre_unit + " \n " + "detalle receta: " + det_receta );

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "no existe ese codigo, id");
            System.out.println("error" + e);
        } finally {
            try {
                connection.cerrar();
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Qproductos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    } */

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
    
    
   public DefaultTableModel buscarDatos(String txt, String buscar){
         DefaultTableModel modelo = crearbase(); Conectar connection = new Conectar();
         Connection cn = connection.getconnect();
             
     try {
         String query = "";
         buscar = buscar.trim();
         switch (buscar){
             
             case "Codigo de producto" : query = "SELECT * FROM producto_venta WHERE cod_prod LIKE '%"+txt+"%'"; break;
                            
             case "id venta" : query = "SELECT * FROM producto_venta WHERE id_venta  LIKE '%"+txt+"%'"; break;
                     
             case "cantidad" : query = "SELECT * FROM producto_venta WHERE cantidad  LIKE '%"+txt+"%'"; break;
                     
             case "precio": query = "SELECT * FROM producto_venta WHERE precio_unit  LIKE '%"+txt+"%'"; break;
                              
             case "Detalle receta" : query = "SELECT * FROM producto_venta WHERE detalle_receta LIKE '%"+txt+"%'"; break;

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
    
    
    
}
