package proceso;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import clasesGenerales.*;
import static clasesGenerales.funciones.limpiarCadena;
import static java.lang.System.out;
import java.sql.ResultSet;
import java.sql.SQLException;
import static java.util.Objects.hash;
import javax.servlet.http.HttpSession;
import mx.gob.sefiplan.daoMDB.MDB;


/**
 *
 * @author Dayuda
 */
@WebServlet(urlPatterns = {"/proceso/valUsuario"})
public class valUsuario extends HttpServlet {

    
    
    
    String email;
    int clave;
    String StringQueryValUsu;
    
// errores
    String erfcvacio = "";
    String eacceso = "";
    String eTotal = "";
    
    ResultSet qValUsu;
    
    HttpSession sesionActual;
    
    String folio;
    String estatus;
    
    int cantidadRegistros;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
     
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            
            /*    usuarios.nombre = "";
                usuarios.aPaterno = "";
                usuarios.aMaterno = "";
            
            */
             
            email = funciones.limpiarCadena(request.getParameter("email"));
            clave = hash(request.getParameter("clave"));
          
          //out.print("2");
              
            try {  
              
                // valida vacios
                if(email.length()==0 || clave==0 ) { 
                    erfcvacio = "<div>Por favor ingresa tu email y tu clave de acceso</div>"; } 
                else {
                    erfcvacio = "";
                }
                
                if(erfcvacio.length()==0) {
                // valida que exista el usuario
                StringQueryValUsu  = "select  folio, estatus from catPersonas where email = '"+email+"' and clave = '"+clave+"'";
                qValUsu = MDB.query(new conexion(), StringQueryValUsu );
                qValUsu.next();
                if(qValUsu.getRow()==0) { 
                    eacceso = clave+"<div class='error'>Acceso denegado</div>"; } 
                else {
                    eacceso = "";
  
                }
                }
                
                
                eTotal = erfcvacio + eacceso;
                
                
                if(eTotal.length()==0) {
                    
                    
                    
                    out.println("1"); 
                    
                folio = qValUsu.getString("folio");
                estatus = qValUsu.getString("estatus");

                    sesionActual = request.getSession(false);
                    sesionActual.setAttribute("usuActual",folio);
                    sesionActual.setAttribute("estatus",estatus);
                  
                    
                    
                    out.println("<div class='info'>Acceso consedido</div>");
                } else {
                    out.println("2"); 
                    out.println("<div class='alert alert-warning' style='margin-top:14px'> "+eTotal+"</div>");
                }
            } catch (SQLException ex) {
                    out.println("2");
                    out.println("<div class='error'>"+ex+"Ocurrio un error desconocido, por favor reportelo con el administrador del sistema</div>");
            }
             
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

        
    }


