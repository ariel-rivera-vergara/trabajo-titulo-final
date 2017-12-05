/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package querys;


import clases.Conectar;
import clases.Producto;
import clases.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pantasha.ven_principal;


/**
 *
 * @author Ivan
 */
public class Qusuario {
    
    public void agregarusuario(Usuario usu) {
        Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        try {
            String query ="INSERT INTO usuario  VALUES ("
                    + "'"+usu.getUsuario()+"',"
                    + "'"+usu.getId_cargo()+"',"
                    + "'"+usu.getNom_usuario()+"',"
                    + "'"+usu.getPassword()+"'"
                    + ")";
            
            Statement st = cn.createStatement();
            st.executeUpdate(query);
            System.out.println("ingresado con exito");
        } catch (SQLException e) {
            System.out.println("error"+e);
        } finally{
            try {
                connection.cerrar();
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Qusuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            
              
            
        } 
    
      public void modificarusuario(Usuario usu) {
          Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        try {
            String query="Update usuario set "
                    + "id_cargo='"+usu.getId_cargo()+"',"
                    + "nom_usuario='"+usu.getNom_usuario()+"',"
                    + "contrasena='"+usu.getPassword()+"'"
                    + " where id_usuario='"+usu.getUsuario()+"'"; //espacio + where para evitar error de sintaxis
            
            Statement st = cn.createStatement();
            st.executeUpdate(query);
            System.out.println("modificado con exito");
        } catch (SQLException e) {
            System.out.println("error"+e);
        } finally{
            try {
                connection.cerrar();
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Qusuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
      }
     public void eliminarusuario(Usuario usu) {
          Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        try {
            String query="Delete FROM usuario"
                    + " where id_usuario='"+usu.getUsuario()+"'"; //espacio + where para evitar error de sintaxis
            
            Statement st = cn.createStatement();
            st.executeUpdate(query);
            System.out.println("eliminado con exito");
        } catch (SQLException e) {
            System.out.println("error"+e);
        } finally{
            try {
                connection.cerrar();
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Qusuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
      }    
    
      public int consultarusuario(Usuario usu) {
          Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
         int existe=0;
        try {
            String query="Select * FROM usuario"
                    + " where id_usuario='"+usu.getUsuario()+"' and contrasena ='"+ usu.getPassword()+"'"; //espacio + where para evitar error de sintaxis
            
            Statement st = cn.createStatement();
             ResultSet rs = st.executeQuery(query);
              
            System.out.println("consulta usuario realizada");
              rs.next();
             if (rs.getString(1)!= null){
                 existe=1;    
             }
      
               
     
        } catch (SQLException e) {
            System.out.println("error"+e);
        } finally{
            try {
                connection.cerrar();
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Qproductos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return existe;
      } 
     
      
       public DefaultTableModel cargardatos() {
        Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        DefaultTableModel modelo = crearbase();
        try {

            String query = "SELECT * FROM `usuario`";
            String[] arreglo = new String[4];
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                arreglo[0] = rs.getString(1);
                arreglo[1] = rs.getString(2);
                arreglo[2] = rs.getString(3);
                arreglo[3] = rs.getString(4);
                modelo.addRow(arreglo);

            }

        } catch (SQLException e) {
            System.out.println("error" + e);
        } finally {

            try {
                connection.cerrar();
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Qcliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return modelo;
    }
      
      
          private DefaultTableModel crearbase() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Id de usuario");
        modelo.addColumn("Cargo");
        modelo.addColumn("Nombre usuario");
        modelo.addColumn("Password");
        return modelo;
    }
      

      public DefaultTableModel buscarDatos(String txt, String buscar){
         DefaultTableModel modelo = crearbase(); Conectar connection = new Conectar();
         Connection cn = connection.getconnect();
           
     try {
         String query = "";
         buscar = buscar.trim();
         switch (buscar){
             
             case "Id de usuario" : query = "SELECT * FROM usuario WHERE id_usuario LIKE '%"+txt+"%'"; break;
                            
             case "Cargo" : query = "SELECT * FROM usuario WHERE id_cargo  LIKE '%"+txt+"%'"; break;
                     
             case "Nombre de usuario" : query = "SELECT * FROM usuario WHERE nom_usuario  LIKE '%"+txt+"%'"; break;
                     
             case "Password": query = "SELECT * FROM proveedores WHERE contrasena  LIKE '%"+txt+"%'"; break;
                              
             
                              
         }
            String[] arreglo = new String[4];
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                arreglo[0] = rs.getString(1);
                arreglo[1] = rs.getString(2);
                arreglo[2] = rs.getString(3);
                arreglo[3] = rs.getString(4);
                
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


