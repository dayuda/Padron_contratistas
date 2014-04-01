/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proceso;


import clasesGenerales.conexion;
import static clasesGenerales.funciones.limpiarCadena;
import static clasesGenerales.funciones.obtenerFecha;
import static clasesGenerales.funciones.validaCorreo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.util.Objects.hash;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mx.gob.sefiplan.daoMDB.MDB;

/**
 *
 * @author Dayuda
 */
@WebServlet(urlPatterns = {"/proceso/gdarNuevoUsuario"})
public class gdarNuevoUsuario extends HttpServlet {


   // variables
    String enombre = "";
    String eemail = "";  
    String eTotal = "";
    String erfc = "";
    String eclave = "";
    String erclave = "";
    
    String eemailexistencia = "";
    String folio = "";
    
    String fecha = "";
    
    int aleatorioInt = 0;
    
    HttpSession sesion;
   
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
            
           
            
             String email = limpiarCadena(request.getParameter("email"));
             String nombre = limpiarCadena(request.getParameter("nombre"));
             String aPaterno = limpiarCadena(request.getParameter("apaterno"));
             String aMaterno = limpiarCadena(request.getParameter("apaterno"));
             
             int clave = hash(request.getParameter("clave"));
             int rclave = hash(request.getParameter("rclave"));
                  
             if(request.getParameter("nombre").length()==0) {
                 enombre = "<div>Ingresa tu nombre</div>";
             } else {
                 enombre = "";
             } 
             
             // valida correo
             if(validaCorreo(email)==false) {  
                 eemail = "<div>Formato email es incorrecto</div>";  }
             else {
                 eemail = "";
             }
             
            
             
             if(request.getParameter("clave").length()==0 ) { 
                 eclave = "<div>Ingresa una clave</div>"; }
             else {
                 eclave = "";
             }
             
             if(request.getParameter("clave").length()!=0) {
                
                 if(clave == rclave) { 
                     erclave = "";
                 } else {
                     erclave = "<div>La confirmación del clave esta erronea.</div>";
                 }
                 
             }
             
             
             
             
             // validar existencia
             if(eemail.length()==0) {
                 String strQueryEmailEx = "SELECT email FROM catUsuarios WHERE email = '"+email+"'";
                 ResultSet emails = MDB.query(new conexion(), strQueryEmailEx);
                 try {
                     emails.next();
                     if(emails.getRow()>0) {
                         eemailexistencia = "<div>Este email ya esta registrado</div>";
                     } else {
                         eemailexistencia = "";
                     }
                     
                 } catch (SQLException ex) {
                     Logger.getLogger(gdarNuevoUsuario.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 
                 
                 
                 
             }
             
             
             // error total
             
             eTotal = enombre + eemail + eemailexistencia +  eclave + erclave;
             
             
             if(eTotal.length()!=0) {
                out.println("2");
                out.println("<div class='alert alert-warning' style='margin-top:14px'>"+eTotal+"</div>");
             } else {
                 
                 
               // genera aleatorio  
                 aleatorioInt = (int) (Math.random()*100000 + 1000000) ;
                 
                 
              // fecha 
                 fecha = obtenerFecha().replace("-", "");
                 
                 folio = fecha + aleatorioInt;
                 
                String cad = "INSERT INTO "
                        + "catUsuarios (nombre, aPaterno, aMaterno, email,  clave, estatus,folio,tipo) "
                        + "VALUES ('"+nombre+"','"+aPaterno+"','"+aMaterno+"','"+email.toLowerCase()+"','"+clave+"','1','"+folio+"','1')";
                MDB.comando(new conexion(),cad);
                 
                sesion = request.getSession(false);
                sesion.setAttribute("usuActual", folio);
                
                  out.print("1");
                 out.println("<div class='info'>Correcto</div>"+folio);
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
