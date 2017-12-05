package clases;

import java.awt.event.KeyAdapter;
import java.sql.SQLXML;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static javax.print.attribute.Size2DSyntax.MM;
import static jdk.nashorn.internal.objects.NativeString.trim;
import java.util.Date;

public class Validar {

    public void solonumerospositivos(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            evt.consume();
        }
    }

    
    public void ValidarTipoFecha(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if ( c < '0' || c > '9' || c != '-') {
            
            evt.consume();
         
     }
    
    }
    
    
    
    
    public void validarstocknumerico(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if (c > '9' || c == ' ') {
            evt.consume();
        }
    }

    public void validarlargonumerico(java.awt.event.KeyEvent evt, JTextField jt, int lim) {
        int limite = lim;

        if (jt.getText().length() == limite) {
            evt.consume();
        }
    }

    public void validarlargoalfa(java.awt.event.KeyEvent evt, JTextField jt, int lim) {
        int limite = lim;

        if (jt.getText().length() == limite) {
            evt.consume();
        }
    }

    public static Date ParseFecha(String fecha) throws ParseException {
            SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
              Date parsed =  formatoDelTexto.parse(fecha);
        java.sql.Date sql = new java.sql.Date(parsed.getTime());   
         return sql;
    } 

    public String passencriptar(String pass) {
        String passcompleta = "";
        String passencrip = "";
        for (int i = 0; i < pass.length(); i++) {
            if (pass.codePointAt(i) + 1 == 123) {
                passencrip = "a";
            } else if (pass.codePointAt(i) + 1 == 58) {
                passencrip = "0";
            } else if (pass.codePointAt(i) + 1 == 164) {
                passencrip = "o";

            } else {
                passencrip = Character.toString((char) pass.codePointAt(i + 1));
            }
            passcompleta = passcompleta + passencrip;
        }
        return trim(passcompleta);
    }

    public String passdesencriptar(String contra) {
        String passcompleta = "";
        String passencrip = "";
        for (int i = 0; i < contra.length(); i++) {
            if (contra.codePointAt(i) - 1 == 96) {
                passencrip = "z";
            } else if (contra.codePointAt(i) - 1 == 47) {
                passencrip = "9";
             } else if(contra.codePointAt(i)-1 == 110){
                passencrip ="ñ";   
            } else if (contra.codePointAt(i)-1 == 163) {
                passencrip = "n";

            
            }else{
                passencrip = Character.toString((char) ((char) contra.codePointAt(i)-1));
            }
            
            
            passcompleta = passcompleta + passencrip;

        }
        return trim(passcompleta);
    }
    
   
    
public static boolean validarRut(String rut) {
 
boolean validacion = false;
try {
rut =  rut.toUpperCase();
rut = rut.replace(".", "");
rut = rut.replace("-", "");
int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));
 
char dv = rut.charAt(rut.length() - 1);
 
int m = 0, s = 1;
for (; rutAux != 0; rutAux /= 10) {
s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
}
if (dv == (char) (s != 0 ? s + 47 : 75)) {
validacion = true;
}
 
} catch (java.lang.NumberFormatException e) {
} catch (Exception e) {
}
return validacion;
}
    
    
    
    
    
    
    
    
    
            
            
            
            
            
}
