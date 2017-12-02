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
public class ProductoVenta {
    
    private  String cod_prod;
    private  String id_venta;
    private  int cant_vent;
    private  int precio_unit;
    private String detalle_receta;

    public String getCod_prod() {
        return cod_prod;
    }

    public void setCod_prod(String cod_prod) {
        this.cod_prod = cod_prod;
    }

    public String getId_venta() {
        return id_venta;
    }

    public void setId_venta(String id_venta) {
        this.id_venta = id_venta;
    }

    public int getCant_vent() {
        return cant_vent;
    }

    public void setCant_vent(int cant_vent) {
        this.cant_vent = cant_vent;
    }

    public int getPrecio_unit() {
        return precio_unit;
    }

    public void setPrecio_unit(int precio_unit) {
        this.precio_unit = precio_unit;
    }

    public String getDetalle_receta() {
        return detalle_receta;
    }

    public void setDetalle_receta(String detalle_receta) {
        this.detalle_receta = detalle_receta;
    }
    
    
     
    
}
