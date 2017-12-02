
package querys;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Qpedidos {
 
   public DefaultTableModel Pasardatos(JTable producto ,String cant){
       DefaultTableModel modelo = crearbase();
       crearbase();
       String[] arreglo = new String[3]; 
       arreglo[0] = producto.getModel().getValueAt(producto.getSelectedRow(), 0).toString();
       arreglo[1] = producto.getModel().getValueAt(producto.getSelectedRow(), 1).toString();
       arreglo[2] = cant;

       
       
       modelo.addRow(arreglo);
  
     
       
       return modelo;
   } 
    
    public DefaultTableModel Pasardatosprov(JTable proveedor){
       
        DefaultTableModel modelo = crearbase();
        String[] arreglo = new String[3];
       arreglo[0] = proveedor.getModel().getValueAt(proveedor.getSelectedRow(), 0).toString();
       arreglo[1] = proveedor.getModel().getValueAt(proveedor.getSelectedRow(), 1).toString();
       arreglo[2] = proveedor.getModel().getValueAt(proveedor.getSelectedRow(), 2).toString();
       modelo.addRow(arreglo);
       return modelo;
   } 
     
     private DefaultTableModel crearbaseproveedor() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Codigo de proveedor");
        modelo.addColumn("Nombre de proveedor");
        modelo.addColumn("fono");
        return modelo;
    }
    
    
    
    
     private DefaultTableModel crearbase() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Codigo de producto");
        modelo.addColumn("Nombre de producto");
        modelo.addColumn("Cantidad pedida");
        return modelo;
    }
    
    
    
}
