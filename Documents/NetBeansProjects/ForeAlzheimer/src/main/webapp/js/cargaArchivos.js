function consultarDoc(argument){
    //var documento=document.formulario.doc.value;
    
    //document.formulario.action = "CargarDatos_p1.jsp";
    document.formulario.action = "FilesController?action="+argument;
}


