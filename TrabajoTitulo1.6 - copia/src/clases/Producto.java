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
public class Producto {
    private String cod_prod;
    private String nom_prod;
    private int existencia;
    private String desc_prod;
    private int precio_unitprod;

    public String getDesc_prod() {
        return desc_prod;
    }

    public void setDesc_prod(String desc_prod) {
        this.desc_prod = desc_prod;
    }

    public int getPrecio_unitprod() {
        return precio_unitprod;
    }

    public void setPrecio_unitprod(int precio_unitprod) {
        this.precio_unitprod = precio_unitprod;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }
    
    
    public String getCod_prod() {
        return cod_prod;
    }

    public void setCod_prod(String cod_prod) {
        this.cod_prod = cod_prod;
    }

    public String getNom_prod() {
        return nom_prod;
    }

    public void setNom_prod(String nom_prod) {
        this.nom_prod = nom_prod;
    }



    public Producto() {
    }  
      
}
