<%@page import="clasesGenerales.usuarios"%>
<%@page import="com.sun.xml.rpc.processor.modeler.j2ee.xml.string"%>
<%@page import="clasesGenerales.funciones"%>



<div >
    
    <%
            

    

    int estatus = 0;
    String spag = "";
    String estilo = "";

    String folio = "";
    String icono = "";
    
 try {   

     
     folio = session.getAttribute("usuActual").toString();
   
     //out.print(folio);
    estatus = Integer.parseInt(usuarios.dUsuarios(folio).get(2).toString());
    
    
    
    
    
    

    if(estatus==1) {
        spag = "envioSolicitud.jsp";
     }
   // out.println("folio:"+folioActual);
 } catch (Exception e) {
   // out.println(e);
 }
        %>
    

<div style="padding: 12px">
    <div class="cajaContenedor" style=" padding-top: 11px; overflow: hidden">
    
            
        
        
        

        
        
        
             <div class="<% 
            if(estatus==2) { out.print("pasoCorrecto"); } else { out.print("pasoDeshabilitado"); }
            
            %>"  ><span style="font-size: 20px"><b>1.- Solicitud</b></span><br>
            <% if(estatus==2) { %><span style="color: #000000">Llena todos los campos con <b>*</b> ya que son obligatorios.</span><% } %>
            <% if(estatus>2) { %><img style="float: right; margin-top: -26px" src="imagenes/ok.png"><% } %>
            <% if(estatus==2) { %>
            <div class="cajaContenedorPno" style="color: #000000" >
                <jsp:include page="formulario.jsp"/> 
            </div>
            <% } %>
        </div>
        
        
        
        
        
        <div class="<% 
            if(estatus==3) { out.print("pasoCorrecto"); } else { out.print("pasoDeshabilitado"); }
            
            %>"  ><span style="font-size: 20px"><b>2.- Subir documentos</b></span><br>
            <% if(estatus==3) { %><span style="color: #000000">Escanea los documentos que se te solicitan y subelo adecuadamente</span><% } %>
            <% if(estatus>3) { %><img style="float: right; margin-top: -26px" src="imagenes/ok.png"><% } %>
            <% if(estatus==3) { %>
            <div class="cajaContenedorPno" style="color: #000000" >
                <jsp:include page="subirDocumentos.jsp"/> 
            </div>
            <% } %>
        </div>
        
        
        
        
        
        
         <div class="<% 
            if(estatus==4) { out.print("pasoCorrecto"); } else { out.print("pasoDeshabilitado"); }
            
            %>"  ><span style="font-size: 20px"><b>3.- Linea de captura y realización del pago</b></span><br>
            <% if(estatus==4) { %><span style="color: #000000">Da click en el botón de abajo para imprimir tu linea de captura para realizar tu pago</span><% } %>
            <% if(estatus>4) { %><img style="float: right; margin-top: -26px" src="imagenes/ok.png"><% } %>
            <% if(estatus==4) { %>
            <div class="cajaContenedorPno" style="color: #000000" >
                <jsp:include page="lineaDeCaptura.jsp"/> 
            </div>
            <% } %>
        </div>
        
        
        
        

        
        
              <div class="<% 
            if(estatus==5) { out.print("pasoCorrecto"); } else { out.print("pasoDeshabilitado"); }
            
            %>"  ><span style="font-size: 20px"><b>4.- Validación de documentos originales</b></span><br>
            <% if(estatus==5) { %>      <span style="color: #000000">Acude a la  <b>SEFIPLAN</b> para cotegar los documentos escaneados con los originales</span><% } %>
            <% if(estatus>5) { %><img style="float: right; margin-top: -26px" src="imagenes/ok.png"><% } %>
            
        </div>
        
        
        
            
            
            
            
             <div class="<% 
            if(estatus==6) { out.print("pasoCorrecto"); } else { out.print("pasoDeshabilitado"); }
            
            %>"  ><span style="font-size: 20px"><b>5.- Impresión de la constancia</b></span><br>
            <% if(estatus==6) { %><span style="color: #000000">Da click en el botón de abajo para imprimir tu constancia</span><% } %>
            <% if(estatus>6) { %><img style="float: right; margin-top: -26px" src="imagenes/ok.png"><% } %>
            <% if(estatus==6) { %>
            <div class="cajaContenedorPno" style="color: #000000" >
                <jsp:include page="imprimirConstancia.jsp"/> 
            </div>
            <% } %>
        </div>
   
            
            
    </div>         
        
</div>
</div>