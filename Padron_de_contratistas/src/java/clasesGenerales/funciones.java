/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clasesGenerales;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Dayuda
 */
public class funciones {
    public static String limpiarCadena(String input) {
        
        String caracteresAceptados = "$abcdefghijklmnñopqrstuvwxyzáéíóúABCDEFGHIJKLMNÑOPQRSTUVWXYZÁÉÍÓÚ0123456789.@#";
        String cadenaSalida = "";
        
        // recorrelacadena
        for (int i=0; i<input.length(); i++) {
            if(caracteresAceptados.indexOf(input.charAt(i))>0) {
              cadenaSalida += input.charAt(i);
            } 
        }
        return cadenaSalida;
    }
    
    
    
    
    public static boolean validaCorreo(String cadena) {  
        // Establecer el patron
        Pattern p = Pattern.compile("[-\\w\\.]+@[\\.\\w]+\\.\\w+");
        Matcher m = p.matcher(cadena);
        if(m.matches()) {
            return true;
        } else {
            return false;
        }

    }
        
    
    
    
    public static String obtenerFecha() {
        
        DateFormat fechaFormato = new SimpleDateFormat("yyyy-mm-dd");
        Date date = new Date();
        String fechaFinal = fechaFormato.format(date);
        
        return fechaFinal;
        
        
    }
    
    
    public static String obtenerEstilo(String estatus, int paso) {
        int estatusInt =  Integer.parseInt(estatus);
        String estiloFinal = "";
        
        
        if(estatusInt==paso) { estiloFinal = "fondoBotones"; }
        if(estatusInt > paso) { estiloFinal = "btn-success"; }
        if(estatusInt < paso) { estiloFinal = ""; }
        
        return estiloFinal;
    }
    
    
}
