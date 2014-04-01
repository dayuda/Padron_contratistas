<%@page import="java.util.ArrayList"%>
<%@page import="clasesGenerales.usuarios"%>
<%@page import="clasesGenerales.manejadorPaginas"%>
<%@page import="mx.gob.sefiplan.daoMDB.MDB"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="clasesGenerales.conexion"%>
<%@page import="clasesGenerales.usuarios"%>
<%
    
 String folioActual = "";
   String pagina = "";
    String pag = "";
    
   
 try {   

   
    folioActual = session.getAttribute("usuActual").toString();
   
     //out.print(folioActual+"ddd");
    
    
   // out.println("folio:"+folioActual);
 } catch (Exception e) {
   // out.println(e);
 }
 
 
  
try {
               
               pagina = request.getParameter("pag");
               
               
              pag = manejadorPaginas.pagina(pagina, folioActual);
                //pag =  manejadorPaginas.pagina(pagina,folioActual);
     } catch (Exception a) {
               out.println(a);
     }
           


           %>
   


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Untitled Document</title>
<link href="css/css.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/js.js"></script>
<script type="text/javascript" src="js/jquery-1.6.1.min.js"></script>




</head>

<body >

<div class="cuerpo bordeTotal" style="padding-top:50px">
 
<div id="titulo" style="background-image:url(imagenes/fondoGrisLogo.png); height:95px">
    	<div style="float:left; padding-left:10px; width:100px; margin-top:-30px">
        	<img src="imagenes/logo.png" />
        </div>
 

    </div>
    
    <div style="background-image:url(imagenes/fondoTotalMedio.png); padding-bottom:10px; padding-top: 10px">
    <% if(folioActual.length()!=0) { %>
            
                 <div  style="background-color: #E7E7E7; margin-right: 15px; margin-left: 12px; overflow: hidden; margin-top: -4px  " class="barraUsuario">
            
                     <div style="float: left; padding: 10px">
                         <% 
                       // out.print(folioActual);
                        out.println(usuarios.dUsuarios(folioActual).get(0)); %> 
                     </div>
                    <div style="float: right; padding: 10px"><a href="proceso/salir" class="botonSalir">Salir</a></div>
                
                 </div>
   <% } %>
            
            
<jsp:include page="<%=pag %>"/> 
      
      </div>
    
    
    <div style="background-image:url(imagenes/fondoInferior.png); height:70px; background-repeat:no-repeat"></div>
    </div>
    
    
    
    
    
</div>

    
</body>