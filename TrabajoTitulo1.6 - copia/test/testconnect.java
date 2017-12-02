
import clases.Conectar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ivan
 */
public class testconnect {
    public static void main(String[] args) {
        Conectar  connection= new Conectar();
        if (connection.getconnect() == null){
            System.out.println ("no es posible la conexion");
        }else{
            System.out.println("conexion exitosa");
        }
    }
}
