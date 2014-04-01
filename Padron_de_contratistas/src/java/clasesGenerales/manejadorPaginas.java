/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clasesGenerales;

import javax.servlet.http.HttpSession;

/**
 *
 * @author Dayuda
 */
public class manejadorPaginas {
    
    
    
    public static String pagina (String pagina, String folio) {

        String pagFinal  = "";
        if(pagina==null && folio.length()==0) {
            pagFinal = "paginas/login.jsp";
        }
        
        
        if(pagina==null && folio.length()>0) {
            pagFinal = "paginas/principal.jsp";
        }
        
        
        return pagFinal;
        
    }
}
