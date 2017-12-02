/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.text.ParseException;
import static jdk.nashorn.internal.objects.NativeString.trim;
public class probandoencriptar {

  public static void main(String[] args) throws ParseException {
      String prueba = "0123456789abcdefghijklmnñopqrstuvwxyz";
       String desen ="1234567890bcdefghijklmnñopqrstuvwxyza";
      Validar vali = new Validar();
              System.out.println("string de prueba: " + prueba);
              System.out.println("String encriptado: " + vali.passencriptar(prueba));
              System.out.println("String desenciptado: " +vali.passdesencriptar(desen)); 
               
                
                
                 
             }
             
    }
