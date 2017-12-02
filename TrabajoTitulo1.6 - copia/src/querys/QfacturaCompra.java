/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package querys;

import clases.Conectar;
import clases.FacturaCompra;
import clases.Validar;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class QfacturaCompra {
      Validar vali = new Validar();
    
    
    
    public void agregarFacturaCompra(FacturaCompra fc) throws ParseException {
        Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        try {
            //hay que cambiar los valores para integrar el idusuario
            String query = "INSERT INTO factura_compra VALUES ("
                    + "'" + fc.getNum_factura() + "',"
                    + "'" + fc.getCod_prov() + "',"
                    + "'" + vali.ParseFecha(fc.getFecha_compra()) + "',"
                    + "'" + fc.getTotal()+ "'"
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
        
         public void eliminarFacturaCompra(int numfactura) {
        Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        try {
            String query = "Delete FROM factura_compra "
                    + " where num_factura='" + numfactura + "'"; //espacio + where para evitar error de sintaxis

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
                Logger.getLogger(QordenDePedido.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
         
         
         
           public DefaultTableModel cargardatos() {
        Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        DefaultTableModel modelo = crearbase();
        try {

            String query = "SELECT * FROM factura_compra";
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
                Logger.getLogger(QordenDePedido.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return modelo;
    }

    private DefaultTableModel crearbase() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Numero de Factura");
        modelo.addColumn("Codigo proveedor");
        modelo.addColumn("Fecha de Compra");
        modelo.addColumn("Total");
        return modelo;
    }
    
    
   public DefaultTableModel buscarDatos(String txt, String buscar){
         DefaultTableModel modelo = crearbase(); Conectar connection = new Conectar();
         Connection cn = connection.getconnect();
             
     try {
         String query = "";
         buscar = buscar.trim();
         switch (buscar){
             
             case "Numero de Factura" : query = "SELECT * FROM factura_compra WHERE num_factura LIKE '%"+txt+"%'"; break;
                            
             case "Codigo de Proveedor" : query = "SELECT * FROM factura_compra WHERE cod_prov  LIKE '%"+txt+"%'"; break;
                     
             case "Fecha de Compra" : query = "SELECT * FROM factura_compra WHERE fecha_compra  LIKE '%"+txt+"%'"; break;
                     
             case "Total": query = "SELECT * FROM factura_compra WHERE total  LIKE '%"+txt+"%'"; break;
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
              //  Logger.getLogger(Querys..class.getName()).log(Level.SEVERE, null, ex); 
            }
        }
        return modelo;
    
   }
    
         
         
         
         
         
         
         
}
