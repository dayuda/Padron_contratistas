/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clasesGenerales;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import mx.gob.sefiplan.daoMDB.MDB;

/**
 *
 * @author Dayuda
 */
public class usuarios {
    
    
    
    public static ArrayList dUsuarios(String folioSesion) {
        
        
        ArrayList datos = new ArrayList();
   
        ResultSet exeQuery;
        
        String nombre = "";
        String pNombre = "";
        String sNombre = "";
        
        String idPersona = "";
        String  estatus = "";
        
        String strQuery = "select idPersona, primerNombre , segundoNombre , tercerNombre , estatus, folio from catPersonas where folio = '"+folioSesion+"'";
        
        try {
        exeQuery = MDB.query(new conexion(), strQuery);
        exeQuery.next();
        
       if(exeQuery.getString("primerNombre")!=null) { nombre = exeQuery.getString("primerNombre"); }
       if(exeQuery.getString("segundoNombre")!=null) { pNombre = exeQuery.getString("segundoNombre"); }
       if(exeQuery.getString("tercerNombre")!=null) { sNombre = exeQuery.getString("tercerNombre"); }
       
       idPersona = exeQuery.getString("idPersona"); 
       estatus = exeQuery.getString("estatus");
       
        
        datos.add(nombre+" "+pNombre+" "+sNombre);
        datos.add(idPersona);
        datos.add(estatus);
        
        } catch (SQLException er) {
             
        }
        
     
        return datos;
        
        
        
        
    }
    
 
    
    
  
    
   
    
}
