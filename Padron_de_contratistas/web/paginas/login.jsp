      <div style="overflow:hidden; padding:50px;">
  <div class="estiloChico" style=" padding:30px; background-color:#F9F9F9; margin:0 auto; width:230px">
                <div id="divlogin">
            <form id="fLogi" name="fLogi" method="post" action="javascript:formSend('fLogi','proceso/valUsuario','bLogi','dLogi','lLogi','recargar()')">
            
            	<div style="padding:5px; " class="estiloTextoAzulGrande"> 
                Iniciar sesión
                </div>
                <div style="padding:5px; "> 
               	  <input name="email" type="text" class="textbox" style="background-image:url(imagenes/arroba.png); background-repeat:no-repeat; width:190px; background-position:-1px -3px; padding-left:23px" id="email"  />
              </div>
            	<div style=" padding:5px; "> 
               	  <input name="clave" type="password" class="textbox" id="clave" style="background-image:url(imagenes/claveContra.jpg); background-repeat:no-repeat; width:190px; padding-left:23px" />
                </div>
              <div id="lLogi" style="display:none; text-align:center"><img src="imagenes/loader.gif" /></div>
                
                <div style=" padding:5px"> 
		          <input name="bLogi" type="submit" class="botonAzul" id="bLogi" value="Entrar" />
                </div>
                <div id="dLogi"></div>
                
                <div style="padding:10px">
               	  <a href="javascript:aparecer('recuperarClave'); ocultar('divlogin')" class="estiloTextoAzulChico">Olvide mi contraseña</a>
              </div> </form>
              </div>
              
                 <div id="recuperarClave" style="display:none">
                   <form id="fReClave" name="fReClave" method="post" action="javascript:formSend('fReClave','proceso/proRecuperarClave.php','bReClave','dReClave','lReClave','ocultarReClave()')">
                   Ingresa tu email:
                     <input name="tuCorreo" type="text" class="textbox" id="tuCorreo" style="width:203px;" />
                     <div id="lReClave" style="display:none"><img src="imagenes/loader.gif" /></div>
                     <div id="dReClave"></div>
                    <div id="bReClave"> <input name="b" type="submit" class="botonAzul" id="b" style="margin-top:3px" value="Recuperar" />
                     <a class="estiloTextoAzulChico" href="javascript:ocultar('recuperarClave'); aparecer('divlogin')">Cancelar</a></div>
                   </form>
                 </div>
                
           
            	
            </div>
</div> 
