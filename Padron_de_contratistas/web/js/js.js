// INSTANCIA XMLhttpRequest ////////////////////////
function getXMLHttpRequest(){try {req = new XMLHttpRequest();} catch (err1) {try { req = new ActiveXObject("Msxml2.XMLHTTP");} catch (err2) {try {req = new ActiveXObject("Microsoft.XMLHTTP");	} catch (err3){	req = false;}}} return req;	}

var cargando = "<img src='imagenes/loader.gif' />";

var ale = Math.round(Math.random()*1000000);

var formSendR=getXMLHttpRequest();// JavaScript Document
var carvPresidenciaR=getXMLHttpRequest();
var petCargaDoc =getXMLHttpRequest();
var vtoP=getXMLHttpRequest();

function formSend(formid,destino,boton,divDestino,loader,funcion)
{
         var Formulario = document.getElementById(formid);
         var longitudFormulario = Formulario.elements.length;
         var parametroslog = "";
         var sepCampos;
         sepCampos = "";
         for (var i=0; i <= Formulario.elements.length-1;i++) {
			if(Formulario.elements[i].name!=boton) {
			Formulario.elements[i].disabled = true;
			Formulario.elements[i].className = 'textboxDeshabilitado';
			}
			ocultar(divDestino);
			ocultar(boton);
			aparecer(loader);
			
         parametroslog += sepCampos+Formulario.elements[i].name+'='+encodeURI(Formulario.elements[i].value);
         sepCampos="&";
		 }
		 
		 
	
		 
	var ale = Math.round(Math.random()*1000000);
	parametroslog += "&form="+formid+"&divDestino="+divDestino+"&boton="+boton+"&ale="+ale;
	//alert(parametroslog);
	formSendR.open("POST",destino,true);
	//alert(destino);
	formSendR.onreadystatechange = function () {
			if (formSendR.readyState==4)
			{
				if (formSendR.status==200)
				{	
				
				ocultar(loader);
					      for (var f=0; f <= Formulario.elements.length-1;f++) {
			if(Formulario.elements[f].name!=boton) {
			Formulario.elements[f].disabled = false;
			Formulario.elements[f].className = 'textbox';
			} }
		
			
				
					respuesta = formSendR.responseText.substr(0,1);
					contenido = formSendR.responseText.substr(1,100000000000000000000000000);
					//alert(formSendR.responseText);
					document.getElementById(divDestino).innerHTML = contenido;
					
					if(respuesta == "1") { if(funcion!="") {
							setTimeout(funcion,1);	
					} }
					if(respuesta == "2") {
						 aparecer(divDestino); aparecer(boton); 
						 }
					if(respuesta == "3") { 
					aparecer(divDestino);
					if(funcion!="") {
						setTimeout(funcion,1);	
					}
					  }
					
					
					
					
				}
			}	
	}
	formSendR.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded; charset=ISO-8859-1');
	formSendR.send(parametroslog);
}


function aparecer(div) {
	$("#"+div).show(100);
}

function ocultar(div) {
	$("#"+div).hide(100);
}

	


function dire(pag) {
	document.location.href = pag;
}	


function optControl(valor,textbox)
{	
		document.getElementById(textbox).value = valor;	
}	



function cargaDocs(pagina,parametros,divDestino,preloader,textoLoader)
{
		var loaderInd = preloader;
		document.getElementById(loaderInd).innerHTML = textoLoader;
		dir = pagina;
		petCargaDoc.open("POST",dir,true);
		petCargaDoc.onreadystatechange = function() {
			if (petCargaDoc.readyState==4)
					{
						document.getElementById(loaderInd).innerHTML = "";	
						if (petCargaDoc.status==200)
						{
							alert(petCargaDoc.responseText);
								document.getElementById(divDestino).innerHTML=petCargaDoc.responseText;	
								document.getElementById(loaderInd).innerHTML = "";	
						}
					}
		
		}
		petCargaDoc.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded; charset=ISO-8859-1');
		petCargaDoc.send(parametros);		
	
		
}



function mostrarAyuda(ayuda) {
	alert(ayuda)
	
}

function ocultarReClave() {

document.getElementById('tuCorreo').style.display = 'none';	
}


function recargar() {
document.location.reload();
}

function terminarNProyecto () {
	contenido = document.getElementById('dNPro').innerHTML;
	document.getElementById('formNProyecto').innerHTML = contenido;	
}

function terminarConfirmacion() {
	contenido = document.getElementById('dCplantel').innerHTML;
	document.getElementById('cplantel').innerHTML = contenido;
	aparecer("contenedorPaginas");	
}

function optControl(valor,textbox)
{	
		document.getElementById(textbox).value = valor;	
}	


function redirigirExamen(dir) {
	examen = document.getElementById("txtIdExamen").value;
document.location.href = '?plantel='+dir+'&p=vExamen&vExamen='+examen+'&i=1';	
}

function calculaAlto(){
  if (document.layers){
    alto = window.innerHeight;
  } else {
    alto = document.body.clientHeight;
  }
  return alto;
}



function validarRespondidas(total) {
	total = parseInt(total);
	faltantes = 0;
	
	for(var i=1; i<=total; i++) {
		valActual = document.getElementById("resp"+i).value;
		if(valActual=="") {
			faltantes+=1;
		}
	}
	if(faltantes>0) {
			document.getElementById('faltantes').innerHTML ="Te falta responder "+faltantes+" preguntas.";
	}
}

function isNumberKey(evt)
{
var charCode = (evt.which) ? evt.which : event.keyCode
if (charCode > 31 && (charCode < 48 || charCode > 57) || charCode == 1)
return false;
 
return true;
}


function redirecionaPaginar(dir) {
document.location.href = dir;	
}

function checboxControl(chec,textbox)
{
	var casilla = document.getElementById(chec).checked;
	if(casilla == true) 
	{
		document.getElementById(textbox).value = "1";
	}	
	else
	{
			document.getElementById(textbox).value = "";
	}
}	