/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package querys;

import clases.Cargo;
import clases.Ciudad;
import clases.Conectar;
import clases.Persona;
import clases.Proveedores;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Qciudad {
    
     
    public void agregarciudad(Ciudad ci) {
        Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        try {
            String query = "INSERT INTO ciudad VALUES ("
                    + "'" + ci.getCod_ciudad() + "',"
                    + "'" + ci.getNom_ciudad() + "'"
                    + ")";

            Statement st = cn.createStatement();
            st.executeUpdate(query);

       
            System.out.println("ingresado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Codigo de ciudad ya ingresado");
            System.out.println("error" + e);
        } finally {
            try {
                connection.cerrar();
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Qciudad.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void modificarciudad(Ciudad ci) {
        Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        try {
            String query = "UPDATE ciudad SET "
                    + "nom_ciudad='" + ci.getNom_ciudad() + "'"
                    
                    + " where cod_ciudad='" + ci.getCod_ciudad()+ "'"; //espacio + where para evitar error de sintaxis

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
                Logger.getLogger(Qciudad.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

     
    
    
    
    
    public void eliminarciudad(Ciudad ci) {
        Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        try {
            String query = "Delete FROM `ciudad`"
                    + " where cod_ciudad='" + ci.getCod_ciudad() + "'"; //espacio + where para evitar error de sintaxis

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
                Logger.getLogger(Qciudad.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void eliminarciudad(String codigo) {
        Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        try {
            String query = "Delete FROM `ciudad`"
                    + " where cod_ciudad='" + codigo + "'"; //espacio + where para evitar error de sintaxis

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
                Logger.getLogger(Qciudad.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void consultarciudad(Ciudad ci) {
        Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        try {
            String query = "Select * FROM `ciudad`"
                    + " where cod_ciudad='" + ci.getCod_ciudad()+ "'"; //espacio + where para evitar error de sintaxis

            Statement st = cn.createStatement();

            ResultSet rs = st.executeQuery(query);
            rs.next();
            System.out.println("consulta de la ciudad realizada");
            String nom_ciudad = rs.getString("nom_ciudad");
            

            JOptionPane.showMessageDialog(null, " codigo: " + ci.getCod_ciudad()+ " \n " + "nombre: " + nom_ciudad);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "no existe ese codigo");
            System.out.println("error" + e);
        } finally {
            try {
                connection.cerrar();
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Qciudad.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public DefaultTableModel cargardatos() {
        Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        DefaultTableModel modelo = crearbase();
        try {

            String query = "SELECT * FROM `ciudad`";
            String[] arreglo = new String[2];
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                arreglo[0] = rs.getString(1);
                arreglo[1] = rs.getString(2);
                modelo.addRow(arreglo);

            }

        } catch (SQLException e) {
            System.out.println("error" + e);
        } finally {

            try {
                connection.cerrar();
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Qciudad.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return modelo;
    }

    private DefaultTableModel crearbase() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Codigo de ciudad");
        modelo.addColumn("Nombre de ciudad");
        return modelo;
    }
    
    
   public DefaultTableModel buscarDatos(String txt, String buscar){
         DefaultTableModel modelo = crearbase(); Conectar connection = new Conectar();
         Connection cn = connection.getconnect();
             
     try {
         String query = "";
         buscar = buscar.trim();
         switch (buscar){
             
             case "Codigo" : query = "SELECT * FROM ciudad WHERE cod_ciudad LIKE '%"+txt+"%'"; break;
                            
             case "Nombre" : query = "SELECT * FROM ciudad WHERE nom_ciudad  LIKE '%"+txt+"%'"; break;
                     
           
         }
            String[] arreglo = new String[2];
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                arreglo[0] = rs.getString(1);
                arreglo[1] = rs.getString(2);
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
    
