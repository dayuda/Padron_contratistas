<%@page import="java.sql.ResultSet"%>
<%@page import="clasesGenerales.conexion"%>
<%@page import="mx.gob.sefiplan.daoMDB.MDB"%>

<script src="subir/jquery.uploadifive.js" type="text/javascript"></script>
<script src="subir/jquery.uploadifive.min.js" type="text/javascript"></script>
<link rel="stylesheet" href="subir/uploadifive.css" type="text/css" media="all"> 

<style>

.uploadifive-button {
	float: left;
	color:#2988d0;
	margin-right: -25px;
	margin-top:-10px;
	margin-left:-23px;
	cursor:pointer;
	

}
#queue {
	border: 2px dashed #E5E5E5;
	
	overflow: auto;


	
}
</style>

<%
    String consulta = "SELECT idDocumento, nombreDocumento FROM catDocumentos ";
    ResultSet equery = MDB.query(new conexion(), consulta);
    equery.next();
    
    if(equery.getRow()==0) {
       out.print("<div>No hay registros</div>");
    } else {
        equery.beforeFirst();
        while(equery.next()) {
            String id = equery.getString("idDocumento");
           // out.print(id);
            %>
            
            <div style="overflow: hidden; background-color: #f2eeee; padding: 3px; margin-bottom: 2px">
                
                <div style="float: left; padding-top: 15px; padding-left: 10px; width: 300px"><%=equery.getString("nombreDocumento") %></div>
                <div style="float:  right; width: 450px">
            <div style="background-color: #F7F7F7; border: #999 dashed 1px">
<form>
		<div id="queue<%=id %>" style="padding:15px  " class="estiloChico">
        <div style="padding:1px; text-align:left">
            <div style="float:left; overflow:hidden;">Arrastra el <b>pdf</b> aqui o  </div>
        <div class="pestana" style=" float:left; overflow:hidden; ">
        <input id="file_upload<%=id %>" name="file_upload<%=id %>" type="file" multiple="true" >
        </div> para elegirlo        </div>
        </div>
        
        
		
	
	</form>
    
	<script type="text/javascript">
	
		
		$(function() {
			$('#file_upload<%=id %>').uploadifive({
				'fileSizeLimit' : '10240KB',
				'fileTypeExts' : '*.xls ; ',
				'buttonText' : 'click aqui',
				'auto'             : true,
				'checkScript'      : 'check-exists.php?aleatorio=<?=$aleatorio; ?>',
				'formData'         : {
									   'folio' : '123',
									   'aleatorio' : '123',
									   'idExamen': '123',
									   'timestamp' : '<?php echo $timestamp;?>',
									   'token'     : 'aleatorio',
									   'tipo'	   : '1'
				                     },
				'queueID'          : 'queue<%=id %>',
				'multi'		: 'false',
				'queueSizeLimit' : 5,
				'onUploadComplete' : function(file) {
				
				//$('#file_upload').uploadifive('clearQueue')
            cargaDocs("proceso/mostrarTmpPreguntas.php","idExamen=<?=$idExamen; ?>","divPreguntastmp","divPreguntastmpLoader","Actualizando...");
			aparecer('cajad');
        } ,
				
				'uploadScript'     : 'subir/proSubirArchivoExamen.php',
							});
		});
	</script>
        
            </div>
                </div>           </div>
            <%
            
            
        }
    }
    
    %>