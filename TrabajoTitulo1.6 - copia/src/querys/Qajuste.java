/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package querys;

import clases.Ajuste;
import clases.Conectar;
import clases.Producto;
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
public class Qajuste {
    Validar vali = new Validar(); 
    Qproductos qp = new Qproductos();

    public void agregarajuste(Ajuste aj) throws ParseException  {
        Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        try {
            String query = "INSERT INTO ajuste(cod_prod,tipo_ajuste,cant_ajuste,fecha_ajuste,comentario) VALUES ("
                  //  + "'" + aj.getCod_ajuste() + "',"
                    + "'" + aj.getCod_prod() + "',"
                    + "'" + aj.getTipo_ajuste() + "',"
                    + "'" + aj.getCant_ajuste() + "',"
                    + "'" + vali.ParseFecha(aj.getFecha_ajuste()) + "',"
                    + "'" + aj.getComentario() + "'"
                    + ")";
            System.out.println(query);
            Statement st = cn.createStatement();
            st.executeUpdate(query);

          qp.modificarproducto(aj.getCod_prod(), aj.getCant_ajuste());

            System.out.println("ingresado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ocurrio un error");
            System.out.println("error" + e);
        } finally {
            try {
                connection.cerrar();
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Qajuste.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
   
    }

    public void modificarajuste(Ajuste aj)  {
        Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        try {
            String query = "UPDATE ajuste SET "
                    + "tipo_ajuste='" + aj.getTipo_ajuste() + "',"
                    + "cant_ajuste='" + aj.getCant_ajuste() + "',"
                    + "fecha_ajuste='" + aj.getFecha_ajuste()+ "',"
                    + "comentario='" + aj.getComentario() + "'"
                    + " where cod_ajuste='" + aj.getCod_ajuste() + "' and cod_prod='" + aj.getCod_prod() + "'"; //espacio + where para evitar error de sintaxis
            System.out.println(query);
            Statement st = cn.createStatement();
            st.executeUpdate(query);

//            qp.modificarproducto(aj.getCod_prod(), aj.getCant_ajuste());

            System.out.println("modificado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "no existe ese codigo para modificar");
            System.out.println("error" + e);
        } finally {
            try {
                connection.cerrar();
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Qajuste.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void eliminarajuste(Ajuste aj) {
        Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        try {
           
            String query = "Delete FROM `ajuste`"
                    + " where cod_ajuste='" + aj.getCod_prod() + "' and cod_prod='" + aj.getCod_prod() + "'"; //espacio + where para evitar error de sintaxis
            System.out.println(query);
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
                Logger.getLogger(Qajuste.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void eliminarajuste(int codigo_ajuste, String cod_prod) {
        Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        try {
            String query = "Delete FROM `ajuste`"
                    + " where cod_ajuste='" + codigo_ajuste + "' and cod_prod='" + cod_prod + "'"; //espacio + where para evitar error de sintaxis

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
                Logger.getLogger(Qajuste.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void consultarajuste(Ajuste aj) {
        Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        try {
            String query = "Select * FROM `ajuste`"
                    + " where cod_ajuste='" + aj.getCod_ajuste() + "' and cod_prod='" + aj.getCod_prod() + "'"; //espacio + where para evitar error de sintaxis

            Statement st = cn.createStatement();

            ResultSet rs = st.executeQuery(query);
            rs.next();
            System.out.println("consulta del producto realizada");
            String tipo_ajuste = rs.getString("tipo_ajuste");
            String cant_ajuste = rs.getString("cant_ajuste");
            String fecha_ajuste = rs.getString("fecha_ajuste");
            String comentario = rs.getString("comentario");

            JOptionPane.showMessageDialog(null, "codigo de ajuste: " + aj.getCod_ajuste() + " \n " + "codigo de producto: "
                    + aj.getCod_prod() + " \n " + "tipo de ajuste: " + tipo_ajuste + " \n "
                    + "cantidad de ajuste: " + cant_ajuste + " \n " + "fehca_ajuste: " + fecha_ajuste + " \n " + "comentario: " + comentario);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "no existe ese codigo");
            System.out.println("error" + e);
        } finally {
            try {
                connection.cerrar();
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Qajuste.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public DefaultTableModel cargardatos() {
        Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        DefaultTableModel modelo = crearbase();
        try {

            String query = "SELECT * FROM `ajuste`";
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
                Logger.getLogger(Qajuste.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return modelo;
    }

    private DefaultTableModel crearbase() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Codigo de ajuste");
        modelo.addColumn("Codigo de producto");
        modelo.addColumn("Tipo de ajuste");
        modelo.addColumn("Cantidad de ajuste");
        modelo.addColumn("Fehca de ajuste");
        modelo.addColumn("Comentario");

        return modelo;
    }

    public DefaultTableModel buscarDatos(String txt, String buscar) {
        DefaultTableModel modelo = crearbase();
        Conectar connection = new Conectar();
        Connection cn = connection.getconnect();

        try {
            String query = "";
            buscar = buscar.trim();
            switch (buscar) {

                case "Codigo de ajuste":
                    query = "SELECT * FROM ajuste WHERE cod_ajuste LIKE '%" + txt + "%'";
                    break;

                case "Codigo de producto":
                    query = "SELECT * FROM ajuste WHERE cod_prod  LIKE '%" + txt + "%'";
                    break;

                case "Tipo de ajuste":
                    query = "SELECT * FROM ajuste WHERE tipo_ajuste  LIKE '%" + txt + "%'";
                    break;

                case "Cantidad de ajuste":
                    query = "SELECT * FROM ajuste WHERE cant_ajuste  LIKE '%" + txt + "%'";
                    break;

                case "Fecha d ajuste":
                    query = "SELECT * FROM ajuste WHERE fecha_ajuste LIKE '%" + txt + "%'";
                    break;

                case "Comentario":
                    query = "SELECT * FROM ajuste WHERE comentario LIKE '%" + txt + "%'";
                    break;
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
