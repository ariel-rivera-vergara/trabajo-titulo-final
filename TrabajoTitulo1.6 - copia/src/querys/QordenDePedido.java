/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package querys;

import clases.Conectar;
import clases.OrdenPedido;
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

/**
 *
 * @author Ariel
 */
public class QordenDePedido {
    
    
    Validar vali = new Validar();
    
    
    
    public void agregarOrdenPedido(OrdenPedido op) throws ParseException {
        Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        try {
            //hay que cambiar los valores para integrar el idusuario
            String query = "INSERT INTO orden_de_pedido(cod_prov,id_usuario,fecha_pedido,fecha_entrega,estado_pedido) VALUES ("
                   // + "'" + op.getCod_pedido() + "',"
                    + "'" + op.getCod_prov() + "',"
                    + "'" + "usuario" + "',"
                    + "'" + vali.ParseFecha(op.getFecha_pedido())+ "',"
                    + "'" + vali.ParseFecha(op.getFecha_entrega())+ "',"
                    + "'" + op.getEstado_pedido() + "'"
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
        
         public void eliminarOrdenDePedido(String codigo) {
        Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        try {
            String query = "Delete FROM orden_de_pedido"
                    + " where cod_pedido='" + codigo + "'"; //espacio + where para evitar error de sintaxis

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

            String query = "SELECT * FROM orden_de_pedido";
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
                Logger.getLogger(QordenDePedido.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return modelo;
    }

    private DefaultTableModel crearbase() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Codigo de pedido");
        modelo.addColumn("Codigo proveedor");
        modelo.addColumn("ID usuario");
        modelo.addColumn("Fecha Pedido");
        modelo.addColumn("Fecha entrega");
        modelo.addColumn("Estado del Pedido");

        return modelo;
    }
    
    
   public DefaultTableModel buscarDatos(String txt, String buscar){
         DefaultTableModel modelo = crearbase(); Conectar connection = new Conectar();
         Connection cn = connection.getconnect();
             
     try {
         String query = "";
         buscar = buscar.trim();
         switch (buscar){
             
             case "Codigo de Pedido" : query = "SELECT * FROM orden_de_pedido WHERE cod_pedido LIKE '%"+txt+"%'"; break;
                            
             case "Codigo de Proveedor" : query = "SELECT * FROM orden_de_pedido WHERE cod_prov  LIKE '%"+txt+"%'"; break;
                     
             case "ID Usuario" : query = "SELECT * FROM orden_de_pedido WHERE id_usuario  LIKE '%"+txt+"%'"; break;
                     
             case "Fecha Pedido": query = "SELECT * FROM orden_de_pedido WHERE fecha_pedido  LIKE '%"+txt+"%'"; break;
                              
             case "Fecha Entrega" : query = "SELECT * FROM orden_de_pedido WHERE fecha_entrega LIKE '%"+txt+"%'"; break;
             
             case "Estado del Pedido" : query = "SELECT * FROM orden_de_pedido WHERE estado_pedido LIKE '%"+txt+"%'"; break;

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
              //  Logger.getLogger(Querys..class.getName()).log(Level.SEVERE, null, ex); 
            }
        }
        return modelo;
    
   }

    public void agregarOrdenPedidoM(OrdenPedido odp) throws ParseException {
         Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        try {
            //hay que cambiar los valores para integrar el idusuario
            String query = "INSERT INTO orden_de_pedido VALUES ("
                    + "'" + Integer.parseInt(odp.getCod_pedido()) + "',"
                    + "'" + odp.getCod_prov() + "',"
                    + "'" + odp.getId_usuario() + "',"
                    + "'" + vali.ParseFecha(odp.getFecha_pedido())+ "',"
                    + "'" + vali.ParseFecha(odp.getFecha_entrega())+ "',"
                    + "'" + odp.getEstado_pedido() + "'"
                    + ")";
       System.out.println(odp.getEstado_pedido());
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
    
    
}
