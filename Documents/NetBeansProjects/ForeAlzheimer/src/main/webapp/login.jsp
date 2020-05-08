<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.ucatolica.forealzheimer.controlador.UserController" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Ingresa a GISIC</title>
        <link href="css/styles.css" rel="stylesheet" />
        <script type="text/javascript" src="./js/loginScript.js" ></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js" crossorigin="anonymous"></script>
    </head>
    <body class="bg-primary">
        <div id="layoutAuthentication">
            <div id="layoutAuthentication_content">
                <main>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-5">
                                <div class="card shadow-lg border-0 rounded-lg mt-5">
                                    <div class="card-header">
                                        <h3 class="text-center font-weight-light my-4">GISIC</h3>
                                    </div>
                                    <div class="card-body">
                                        <form name="login_form" method="post"
                                              action="UserController?action=login">
                                            <div class="form-group">
                                                <label class="small mb-1" for="inputEmailAddress">Número de documento</label>
                                                <input class="form-control py-4" name="inputDoc" type="number" 
                                                       placeholder="Número de documento" required />
                                            </div>
                                            <div class="form-group">
                                                <label class="small mb-1" for="inputPassword">Contraseña</label>
                                                <input class="form-control py-4" name="inputPassword" type="password" 
                                                       placeholder="Contraseña" required />
                                            </div>
                                            <!--<div class="form-group">
                                                <div class="custom-control custom-checkbox"><input class="custom-control-input" id="rememberPasswordCheck" type="checkbox" /><label class="custom-control-label" for="rememberPasswordCheck">Remember password</label></div>
                                            </div>-->
                                            <!--<div class="form-group d-flex align-items-center justify-content-between mt-4 mb-0">
                                                <a class="small" href="password.html">Forgot Password?</a>-->
                                            <!--<a class="btn btn-primary" href="index.html">Ingresar</a>-->

                                            <center> 
                                                <div class="small" style='color:red'>
                                                    <p>

                                                        <%
                                                            UserController obj = new UserController();
                                                            HttpSession sesion = request.getSession();
                                                            String argument = (String) sesion.getAttribute("ErrorLogin");
                                                            
                                                            if (argument ==null){
                                                                argument="";
                                                            }
                                                            
                                                            String message =obj.Error_login(argument);
                                                            
                                                        %>
                                                        <%= message  %>
                                                        <%
                                                            sesion.setAttribute("ErrorLogin", "");
                                                        %>
                                                    </p>
                                                </div>
                                                <button type="submit" class="btn btn-primary">
                                                    Ingresar
                                                </button>
                                            </center>
                                        </form>
                                    </div>                                  

                                    <div class="card-footer text-center">
                                        <div class="small">
                                            <a href="register.jsp">Registrarse</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
            <div id="layoutAuthentication_footer">
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; GISIC</div>
                            <div>
                                <img src="./assets/img/logo.png" alt="" style="width:250px; height:63px;">
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.4.1.min.js" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
    </body>
</html>
