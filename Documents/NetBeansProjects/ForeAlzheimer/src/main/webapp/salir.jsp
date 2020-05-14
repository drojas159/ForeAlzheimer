

<%
    HttpSession sesion = request.getSession();
    sesion.invalidate(); 
    System.out.println(request.getContextPath() );
    response.sendRedirect("./login.jsp");
%>

