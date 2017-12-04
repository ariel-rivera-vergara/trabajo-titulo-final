/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package querys;

import clases.Cliente;
import clases.Conectar;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Qcliente {

    public void agregarcliente(Cliente cli) {
        Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        try {
            String query = "INSERT INTO cliente VALUES ("
                    + "'" + cli.getRut_cliente() + "',"
                    + "'" + cli.getNom_cliente() + "',"
                    + "'" + cli.getFono_cliente() + "',"
                    + "'" + cli.getDir_cliente() + "'"
                    + ")";
            Statement st = cn.createStatement();
            st.executeUpdate(query);

            System.out.println("ingresado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Codigo de cliente ya ingresado");
            System.out.println("error" + e);
        } finally {
            try {
                connection.cerrar();
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Qcliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void modificarcliente(Cliente cli) {
        Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        try {
            String query = "UPDATE cliente SET "
                    + "nom_cliente='" + cli.getNom_cliente() + "',"
                    + "fono_cliente='" + cli.getFono_cliente() + "',"
                    + "dir_cliente='" + cli.getDir_cliente() + "'"
                    + " where rut_cliente='" + cli.getRut_cliente() + "'"; //espacio + where para evitar error de sintaxis
            Statement st = cn.createStatement();
            st.executeUpdate(query);
            System.out.println("modificado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "no existe ese rut para modificar");
            System.out.println("error" + e);
        } finally {
            try {
                connection.cerrar();
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Qcliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

   

    public void eliminarcliente(Cliente cli) {
        Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        try {
            String query = "Delete FROM `cliente`"
                    + " where rut_cliente='" + cli.getRut_cliente() + "'"; //espacio + where para evitar error de sintaxis

            Statement st = cn.createStatement();
            st.executeUpdate(query);
            System.out.println("eliminado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "no existe ese rut a eliminar");
            System.out.println("error" + e);
        } finally {
            try {
                connection.cerrar();
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Qcliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void eliminarcliente(String rut_cliente) {
        Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        try {
            String query = "Delete FROM `cliente`"
                    + " where rut_cliente='" + rut_cliente + "'"; //espacio + where para evitar error de sintaxis

            Statement st = cn.createStatement();
            st.executeUpdate(query);
            System.out.println("eliminado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "no existe ese rut a eliminar");
            System.out.println("error" + e);
        } finally {
            try {
                connection.cerrar();
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Qcliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void consultarcliente(Cliente cli) {
        Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        try {
            String query = "Select * FROM `cliente`"
                    + " where rut_cliente='" + cli.getRut_cliente() + "'"; //espacio + where para evitar error de sintaxis

            Statement st = cn.createStatement();

            ResultSet rs = st.executeQuery(query);
            rs.next();
            System.out.println("consulta del producto realizada");
            String nom_cliente = rs.getString("nom_cliente");
            String fono_cliente = rs.getString("fono_cliente");
            String dir_cliente = rs.getString("dir_cliente");
           

            JOptionPane.showMessageDialog(null, " rut: " + cli.getRut_cliente()  + " \n " + "nombre: " + nom_cliente + " \n " + "fono: " + fono_cliente + " \n " + "direccion: " + dir_cliente);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "no existe ese codigo");
            System.out.println("error" + e);
        } finally {
            try {
                connection.cerrar();
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Qcliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public DefaultTableModel cargardatos() {
        Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        DefaultTableModel modelo = crearbase();
        try {

            String query = "SELECT * FROM `cliente`";
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
        modelo.addColumn("Rut de cliente");
        modelo.addColumn("Nombre de cliente");
        modelo.addColumn("Fono de cliente");
        modelo.addColumn("Direccion de cliente");
        return modelo;
    }
    private DefaultTableModel crearbaseEspecifica() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Rut de cliente");
        modelo.addColumn("Nombre de cliente");
        modelo.addColumn("Fono de cliente");
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

                case "Rut de cliente":
                    query = "SELECT * FROM cliente WHERE rut_cliente LIKE '%" + txt + "%'";
                    break;

                case "Nombre de cliente":
                    query = "SELECT * FROM cliente WHERE nom_cliente  LIKE '%" + txt + "%'";
                    break;

                case "Fono de cliente":
                    query = "SELECT * FROM cliente WHERE fono_cliente  LIKE '%" + txt + "%'";
                    break;

                case "Direccion de cliente":
                    query = "SELECT * FROM cliente WHERE dir_cliente  LIKE '%" + txt + "%'";
                    break;
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

    public DefaultTableModel cargardatosEspecificos(String rut_cliente) {

        Conectar connection = new Conectar();//conectarme a la base de datos
        Connection cn = connection.getconnect(); // tener un elemento cn con el cual nos permite hacer la sentencias.
        DefaultTableModel modelo = crearbaseEspecifica();
        try {

             String query = "select rut_cliente,nom_cliente,fono_cliente FROM cliente"
                    + " where rut_cliente ='" + rut_cliente + "'";
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
                Logger.getLogger(Qcliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return modelo;
    }

    

}
