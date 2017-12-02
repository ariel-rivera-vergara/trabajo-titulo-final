/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package querys;

import clases.Conectar;
import clases.Persona;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ivan
 */
public class Qpersona {

    public void agregarpersona(Persona per) {
        Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        try {
            String query ="INSERT INTO `persona`(`rut`, `nombre`, `apellido`) VALUES ("
                    + "'"+per.getRut()+"',"
                    + "'"+per.getNombre()+"',"
                    + "'"+per.getApellido()+"'"
                    + ")";
            
            Statement st = cn.createStatement();
            st.executeUpdate(query);
            System.out.println("ingresa3");
        } catch (SQLException e) {
            System.out.println("error"+e);
        } finally{
            try {
                connection.cerrar();
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Qpersona.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
      public void modificarpersona(Persona per) {
          Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        try {
            String query="Update persona set "
                    
                    + "nombre='"+per.getNombre()+"',"
                    + "apellido='"+per.getApellido()+"'"
                    + " where rut='"+per.getRut()+"'"; //espacio + where para evitar error de sintaxis
            
            Statement st = cn.createStatement();
            st.executeUpdate(query);
            System.out.println("modifica3");
        } catch (SQLException e) {
            System.out.println("error"+e);
        } finally{
            try {
                connection.cerrar();
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Qpersona.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
      }
     public void eliminarpersona(Persona per) {
          Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        try {
            String query="Delete FROM `persona`"
                    + " where rut='"+per.getRut()+"'"; //espacio + where para evitar error de sintaxis
            
            Statement st = cn.createStatement();
            st.executeUpdate(query);
            System.out.println("elimina3");
        } catch (SQLException e) {
            System.out.println("error"+e);
        } finally{
            try {
                connection.cerrar();
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Qpersona.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
      } 
     public DefaultTableModel cargardatos() {
        Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        DefaultTableModel modelo = crearbase();
        try {
            
            String query="SELECT * FROM `persona`";
            String[] arreglo= new String[3];           
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                arreglo[0]=rs.getString("rut");
                 arreglo[1]=rs.getString("nombre");
                   arreglo[2]=rs.getString("apellido");
                   
                modelo.addRow(arreglo);
                
            }
              
           
        } catch (SQLException e) {
            System.out.println("error"+e);
        } finally{ 
           
            try {
                connection.cerrar();
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Qpersona.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return modelo;
      }  
     public DefaultTableModel crearbase() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("rut");
        modelo.addColumn("nombre");
        modelo.addColumn("apellido");
          return modelo;
    }
}
