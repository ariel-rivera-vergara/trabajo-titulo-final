/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package querys;

import clases.Conectar;
import clases.Persona;
import clases.Producto;
import clases.Proveedores;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;




public class Qproveedor {
   
   public void agregarproveedor(Proveedores prov) {
        Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        try {
            String query = "INSERT INTO proveedores VALUES ("
                    + "'" + prov.getCod_prov() + "',"
                    + "'" + prov.getCod_ciudad()+ "',"
                    + "'" + prov.getNom_prov()+ "',"
                    + "'" + prov.getFono_prov()+ "',"
                    + "'" + prov.getDirec_prov() + "',"
                    + "'" + prov.getDesc_prov() + "'"
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
                Logger.getLogger(Qproveedor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void modificarproveedor(Proveedores prov) {
        Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        try {
            // Aqui hay que validad que el codigo a la ciudad modificada exista en la tabla ciudad o de lo contrario no se acepta 
            // la modificacion 
            String query = "UPDATE proveedores SET "
                    + "cod_ciudad='" + prov.getCod_ciudad() + "',"
                    + "nom_prov='" + prov.getNom_prov() + "',"
                    + "fono_prov='" + prov.getFono_prov() + "',"
                    + "direc_prov='" + prov.getDirec_prov() + "'"
                    + "desc_prov='" + prov.getDesc_prov() + "',"
                    + " where cod_prov='" + prov.getCod_prov() + "'"; //espacio + where para evitar error de sintaxis

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
                Logger.getLogger(Qproveedor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    
    
    
    
    
    public void eliminarproveedor(Proveedores prov) {
        Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        try {
            String query = "Delete FROM `proveedores`"
                    + " where cod_prov='" + prov.getCod_prov() + "'"; //espacio + where para evitar error de sintaxis

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
                Logger.getLogger(Qproveedor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void eliminarproveedor(String codigo) {
        Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        try {
            String query = "Delete FROM `proveedores`"
                    + " where cod_prov='" + codigo + "'"; //espacio + where para evitar error de sintaxis

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
                Logger.getLogger(Qproveedor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void consultarproveedor(Proveedores prov) {
        Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        try {
            String query = "Select * FROM `proveedores`"
                    + " where cod_prov='" + prov.getCod_prov() + "'"; //espacio + where para evitar error de sintaxis

            Statement st = cn.createStatement();

            ResultSet rs = st.executeQuery(query);
            rs.next();
            System.out.println("consulta de proveedores realizada");
            String cod_ciudad = rs.getString("cod_ciudad");
            String nom_prov = rs.getString("nom_prov");
            String fono_prov = rs.getString("fono_prov");
            String direc_prov = rs.getString("direc_prov");
            String desc_prov = rs.getString("desc_prov");

            JOptionPane.showMessageDialog(null, " codigo de prov: " + prov.getCod_prov() + " \n " + "codigo de ciudad: " + cod_ciudad + " \n " + "nombre del prov: " + nom_prov
                       + " \n " + "fono del proveedor: " + fono_prov + " \n " + "direccion: " + direc_prov + " \n" + "descripción: " +desc_prov);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "no existe ese codigo");
            System.out.println("error" + e);
        } finally {
            try {
                connection.cerrar();
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Qproveedor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public DefaultTableModel cargardatos() {
        Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        DefaultTableModel modelo = crearbase();
        try {

            String query = "SELECT * FROM `proveedores`";
            String[] arreglo = new String[6];
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                arreglo[0] = rs.getString(1);
                arreglo[1] = rs.getString(2);
                arreglo[2] = rs.getString(3);
                arreglo[3] = rs.getString(4);
                arreglo[4] = rs.getString(5);
                arreglo[5] = rs.getString(6);

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

    // este cargar datos es para cargar la tabla proveedor en la ventana pedido despues de apretar el boton modificar 
    // en el mantenedor de pedidos tira un error despues de la query en el result set
        public DefaultTableModel cargardatosprov(String codigo) {
        Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        DefaultTableModel modelo = crearbasepedido();
        try {
  System.out.println(codigo);
            String query =  "select cod_prov,nom_prov,fono_prov FROM proveedores "
                    + " where cod_prov = '" + codigo + "'";
            System.out.println(query);
            String[] arreglo = new String[3];
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
                rs.next();
                arreglo[0] = rs.getString(1);
                arreglo[1] = rs.getString(2);
                arreglo[2] = rs.getString(3);
                modelo.addRow(arreglo);
        } catch (SQLException e) {
            System.out.println("error" + e);
        } finally {

            try {
                connection.cerrar();
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Qproveedor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return modelo;
    }
    
    
    private DefaultTableModel crearbase() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Codigo de proveedor");
        modelo.addColumn("Codigo de ciudad");
        modelo.addColumn("Nombre de proveedor");
        modelo.addColumn("Fono de proveedor");
        modelo.addColumn("Direccion de proveedor");
        modelo.addColumn("Descripcion");

        return modelo;
    }
    
       
    private DefaultTableModel crearbasepedido() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Codigo de proveedor");
        modelo.addColumn("Nombre de proveedor");
        modelo.addColumn("Fono de proveedor");
        return modelo;
    }
    
    
    
   public DefaultTableModel buscarDatos(String txt, String buscar){
         DefaultTableModel modelo = crearbase(); Conectar connection = new Conectar();
         Connection cn = connection.getconnect();
           
     try {
         String query = "";
         buscar = buscar.trim();
         switch (buscar){
             
             case "Codigo de proveedor" : query = "SELECT * FROM proveedores WHERE cod_prov LIKE '%"+txt+"%'"; break;
                            
             case "Codigo de ciudad" : query = "SELECT * FROM proveedores WHERE cod_ciudad  LIKE '%"+txt+"%'"; break;
                     
             case "Nombre de proveedor" : query = "SELECT * FROM proveedores WHERE nom_prov  LIKE '%"+txt+"%'"; break;
                     
             case "Fono de proveedor": query = "SELECT * FROM proveedores WHERE fono_prov  LIKE '%"+txt+"%'"; break;
                              
             case "Direccion de proveedor" : query = "SELECT * FROM proveedores WHERE direc_prov LIKE '%"+txt+"%'"; break;
             
             case "Descripcion": query = "SELECT * FROM proveedores WHERE desc_prov  LIKE '%"+txt+"%'"; break;
                              
         }
            String[] arreglo = new String[6];
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                arreglo[0] = rs.getString(1);
                arreglo[1] = rs.getString(2);
                arreglo[2] = rs.getString(3);
                arreglo[3] = rs.getString(4);
                arreglo[4] = rs.getString(5);
                arreglo[5] = rs.getString(6);
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

