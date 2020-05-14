
function salir(){
    window.location.href = './salir.jsp';    
}

function deleteUsr(num){
    alert("Va a eliminar un paciente.");
    document.formulario.action = "UserController?action="+num;
}