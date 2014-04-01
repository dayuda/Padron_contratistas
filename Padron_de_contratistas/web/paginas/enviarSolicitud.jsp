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




<form>
		<div id="queue1" style="padding:15px  " class="estiloChico">
        <div style="padding:1px; text-align:left">
            <div style="float:left; overflow:hidden;">Arrastra el <b>pdf</b> aqui o  </div>
        <div class="pestana" style=" float:left; overflow:hidden; ">
        <input id="file_upload" name="file_upload" type="file" multiple="true" >
        </div> para elegirlo        </div>
        </div>
        
        
		
	
	</form>
    
	<script type="text/javascript">
	
		
		$(function() {
			$('#file_upload').uploadifive({
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
				'queueID'          : 'queue1',
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