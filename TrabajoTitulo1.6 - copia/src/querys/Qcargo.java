
package querys;

import clases.Cargo;
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



public class Qcargo {
    
    public void agregarcargo(Cargo carg) {
        Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        try {
            String query ="INSERT INTO `cargo`(`id_cargo`, `nom_cargo`, `desc_cargo`) VALUES ("
                    + "'"+carg.getId_cargo()+"',"
                    + "'"+carg.getNom_cargo()+"',"
                    + "'"+carg.getDesc_cargo()+"'"
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
                Logger.getLogger(Qcargo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
      public void modificarcargo(Cargo carg) {
          Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        try {
            String query="Update cargo set "
                    
                    + "nom_cargo='"+carg.getNom_cargo()+"',"
                    + "desc_cargo='"+carg.getDesc_cargo()+"'"
                    + " where id_cargo='"+carg.getId_cargo()+"'"; //espacio + where para evitar error de sintaxis
            
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
                Logger.getLogger(Qcargo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
      }
     public void eliminarcargo(Cargo carg) {
          Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        try {
            String query="Delete FROM `cargo`"
                    + " where id_cargo='"+carg.getId_cargo()+"'"; //espacio + where para evitar error de sintaxis
            
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
                Logger.getLogger(Qcargo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
      } 
     
     
         public void consultarcargo(Cargo carg) {
        Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        try {
            String query = "Select * FROM `cargo`"
                    + " where id_cargo='" + carg.getId_cargo()+ "'"; //espacio + where para evitar error de sintaxis

            Statement st = cn.createStatement();

            ResultSet rs = st.executeQuery(query);
            rs.next();
            System.out.println("consulta realizada");
            String nom_carg = rs.getString("nom_cargo");
            String desc_carg = rs.getString("desc_cargo");

            JOptionPane.showMessageDialog(null, carg.getId_cargo()+ " " + nom_carg+ " " + desc_carg);

        } catch (SQLException e) {
            System.out.println("error" + e);
        } finally {
            try {
                connection.cerrar();
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Qcargo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         
    } 
     
     
     
     
    public DefaultTableModel cargardatos() {
        Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        DefaultTableModel modelo = crearbase();
        try {

            String query = "SELECT * FROM `cargo`";
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
                Logger.getLogger(Qcargo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return modelo;
    }

    private DefaultTableModel crearbase() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Id de cargo");
        modelo.addColumn("Nombre de cargo");
        modelo.addColumn("Descripcion de cargo");

        return modelo;
    }
    
    
   public DefaultTableModel buscarDatos(String txt, String buscar){
         DefaultTableModel modelo = crearbase(); Conectar connection = new Conectar();
         Connection cn = connection.getconnect();
             
     try {
         String query = "";
         buscar = buscar.trim();
         switch (buscar){
             
             case "Id de cargo" : query = "SELECT * FROM cargo WHERE id_cargo LIKE '%"+txt+"%'"; break;
                            
             case "Nombre de cargo" : query = "SELECT * FROM cargo WHERE nom_cargo  LIKE '%"+txt+"%'"; break;
                     
             case "Descripcion de cargo" : query = "SELECT * FROM cargo WHERE desc_cargo  LIKE '%"+txt+"%'"; break;
                     
         }
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
               /* Logger.getLogger(Querys..class.getName()).log(Level.SEVERE, null, ex); */
            }
        }
        return modelo;
    
   }
}    

