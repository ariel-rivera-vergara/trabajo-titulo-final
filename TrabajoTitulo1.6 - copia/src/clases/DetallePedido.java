
package clases;


public class DetallePedido {
    private String Cod_pedido;
    private String Cod_producto;
    private int   cantidad; 

    public String getCod_pedido() {
        return Cod_pedido;
    }

    public void setCod_pedido(String Cod_pedido) {
        this.Cod_pedido = Cod_pedido;
    }

    public String getCod_producto() {
        return Cod_producto;
    }

    public void setCod_producto(String Cod_producto) {
        this.Cod_producto = Cod_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
    
    
}
