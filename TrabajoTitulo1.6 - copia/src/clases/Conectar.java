/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ivan
 */
public class Conectar {

    Connection conecta3;
   // String url = "localhost"; // Url es una var local. Redireccionar mi BD. Decir donde esta fisicamente
  //  String BD = "basedatos";
    String usuario = "root";
    String password = "";

    public Conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");   //Nombre del driver de conexion
        } catch (ClassNotFoundException ex) {

        }
        try {
            conecta3 = (Connection) DriverManager.getConnection("jdbc:mysql://" + "localhost/" + "basedatos", usuario, password);
        } catch (SQLException ex) {
            System.out.println(""+ex);

        }
    }
    

  public Connection getconnect(){
      return conecta3;
  } 
  
  public void cerrar(){
      if (conecta3 != null){
          try {
              conecta3.close();
          } catch (SQLException ex) {
              System.out.println("ya esta cerrado"+ex);
          }
      } 
  }
  
}
