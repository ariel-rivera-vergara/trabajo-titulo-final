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
     
     
 } 


