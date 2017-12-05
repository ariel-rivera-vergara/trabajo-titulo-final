/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Ivan
 */
public class venta {
   
   private  int id_venta;   
   private  String rut_cliente; 
   private  String id_usuario;      
   private  String fecha_rec;
   private  String fecha_ent;
   private  int abono;
   private  int saldo;
   private  int total_vent;
   private  String tipo_pago;
   private  int num_boleta;      
   private  String rut_pretiro;
   private String receta;

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

  
   
   
    public String getRut_cliente() {
        return rut_cliente;
    }

    public void setRut_cliente(String rut_cliente) {
        this.rut_cliente = rut_cliente;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

  

    public String getFecha_rec() {
        return fecha_rec;
    }

    public void setFecha_rec(String fecha_rec) {
        this.fecha_rec = fecha_rec;
    }

    public String getFecha_ent() {
        return fecha_ent;
    }

    public void setFecha_ent(String fecha_ent) {
        this.fecha_ent = fecha_ent;
    }

    public int getAbono() {
        return abono;
    }

    public void setAbono(int abono) {
        this.abono = abono;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getTotal_vent() {
        return total_vent;
    }

    public void setTotal_vent(int total_vent) {
        this.total_vent = total_vent;
    }

    public String getTipo_pago() {
        return tipo_pago;
    }

    public void setTipo_pago(String tipo_pago) {
        this.tipo_pago = tipo_pago;
    }

 

    public int getNum_boleta() {
        return num_boleta;
    }

    public void setNum_boleta(int num_boleta) {
        this.num_boleta = num_boleta;
    }

    public String getRut_pretiro() {
        return rut_pretiro;
    }

    public void setRut_pretiro(String rut_pretiro) {
        this.rut_pretiro = rut_pretiro;
    }

    public String getReceta() {
        return receta;
    }

    public void setReceta(String receta) {
        this.receta = receta;
    }
           
          
   
   
   
   
           
}
