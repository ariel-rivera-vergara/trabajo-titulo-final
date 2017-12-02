/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package querys;

import clases.Conectar;
import clases.Persona;
import clases.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Qproductos {
 

    
    public void agregarproducto(Producto pro) {
        Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        try {
            String query = "INSERT INTO producto VALUES ("
                    + "'" + pro.getCod_prod() + "',"
                    + "'" + pro.getNom_prod() + "',"
                    + "'" + pro.getPrecio_unitprod()+ "',"
                    + "'" + pro.getExistencia()+ "',"
                    + "'" + pro.getDesc_prod() + "'"
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

    public void modificarproducto(Producto pro) {
        Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        try {
            String query = "UPDATE producto SET "
                    + "nom_prod='" + pro.getNom_prod() + "',"
                    + "precio_unitprod='" + pro.getPrecio_unitprod() + "',"
                    + "existencia='" + pro.getExistencia() + "',"
                    + "desc_prod='" + pro.getDesc_prod() + "'"
                    + " where cod_prod='" + pro.getCod_prod() + "'"; //espacio + where para evitar error de sintaxis

            Statement st = cn.createStatement();
            st.executeUpdate(query);
            System.out.println("modificado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "no existe ese codigo para modificar");
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

    
    // este modificar Producto es para cuando se realiza un ajuste
     public void modificarproducto(String cod_prod,int cant_ajuste) {
        Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        try {
            
           
             String sql = "Select * FROM producto "
                    + " where cod_prod='" + cod_prod + "'"; //espacio + where para evitar error de sintaxis

            Statement smt = cn.createStatement();
            System.out.println(sql);
            ResultSet rs = smt.executeQuery(sql);
            rs.next();
            
            String cant = rs.getString("existencia");       
             int ajuste_total = Integer.parseInt(cant) + cant_ajuste;
            String query = "UPDATE producto SET "             
                    + "existencia='" + ajuste_total + "'"                 
                    + " where cod_prod='" + cod_prod + "'"; //espacio + where para evitar error de sintaxis

            Statement st = cn.createStatement();
            st.executeUpdate(query);
           
            System.out.println("modificado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "no existe ese codigo para modificar");
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
    
    
    
    
    
    public void eliminarproducto(Producto pro) {
        Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        try {
            String query = "Delete FROM `producto`"
                    + " where cod_prod='" + pro.getCod_prod() + "'"; //espacio + where para evitar error de sintaxis

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
                Logger.getLogger(Qproductos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void eliminarproducto(String codigo) {
        Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        try {
            String query = "Delete FROM `producto`"
                    + " where cod_prod='" + codigo + "'"; //espacio + where para evitar error de sintaxis

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
                Logger.getLogger(Qproductos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void consultarproducto(Producto pro) {
        Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        try {
            String query = "Select * FROM `producto`"
                    + " where cod_prod='" + pro.getCod_prod() + "'"; //espacio + where para evitar error de sintaxis

            Statement st = cn.createStatement();

            ResultSet rs = st.executeQuery(query);
            rs.next();
            System.out.println("consulta del producto realizada");
            String nom = rs.getString("nom_prod");
            String prec = rs.getString("precio_unitprod");
            String cant = rs.getString("existencia");
            String descrip = rs.getString("desc_prod");

            JOptionPane.showMessageDialog(null, " codigo: " + pro.getCod_prod() + " \n " + "nombre: " + nom + " \n " + "precio: " + prec + " \n " + "cantidad: " + cant + " \n " + "descripcion: " + descrip);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "no existe ese codigo");
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

    public DefaultTableModel cargardatos() {
        Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        DefaultTableModel modelo = crearbase();
        try {

            String query = "SELECT * FROM producto";
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
        modelo.addColumn("Nombre de producto");
        modelo.addColumn("Precio");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Descripcion");
      

        return modelo;
    }
    
    
   public DefaultTableModel buscarDatos(String txt, String buscar){
         DefaultTableModel modelo = crearbase(); Conectar connection = new Conectar();
         Connection cn = connection.getconnect();
             
     try {
         String query = "";
         buscar = buscar.trim();
         switch (buscar){
             
             case "Codigo de producto" : query = "SELECT * FROM producto WHERE cod_prod LIKE '%"+txt+"%'"; break;
                            
             case "Nombre de producto" : query = "SELECT * FROM producto WHERE nom_prod  LIKE '%"+txt+"%'"; break;
                     
             case "Precio" : query = "SELECT * FROM producto WHERE precio_unitprod  LIKE '%"+txt+"%'"; break;
                     
             case "Cantidad": query = "SELECT * FROM producto WHERE existencia  LIKE '%"+txt+"%'"; break;
                              
             case "Descripcion" : query = "SELECT * FROM producto WHERE desc_prod LIKE '%"+txt+"%'"; break;

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
