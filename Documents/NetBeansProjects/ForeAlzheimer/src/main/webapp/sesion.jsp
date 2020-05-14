<%@page import="com.ucatolica.forealzheimer.model.Usuario"%>
<%

    HttpSession sesion = request.getSession();
    Usuario usr = (Usuario) sesion.getAttribute("usuario");
    if (usr==null){
        RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
        dispatcher.forward(request, response);
    }
%>
