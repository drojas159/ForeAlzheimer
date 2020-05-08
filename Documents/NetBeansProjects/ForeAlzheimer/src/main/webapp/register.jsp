<%-- 
    Document   : register
    Created on : 6/05/2020, 3:59:24 p. m.
    Author     : Daniela
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Registro en GISIC</title>
        <link href="css/styles.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js" crossorigin="anonymous"></script>
    </head>
    <body class="bg-primary">
        <div id="layoutAuthentication">
            <div id="layoutAuthentication_content">
                <main>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-7">
                                <div class="card shadow-lg border-0 rounded-lg mt-5">
                                    <div class="card-header"><h3 class="text-center font-weight-light my-4">Crear una cuenta en GISIC</h3></div>
                                    <div class="card-body">
                                        <form name="register_form" method="post"
                                              action="UserController?action=register">

                                            <div class="form-row">                                                
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="small mb-1" for="inputRol">Tipo de Documento</label>
                                                        <select name="inputRol" class="form-control" >
                                                            <option value="CC">Cédula de Ciudadanía</option> 
                                                            <option value="CE">Cédula de Extranjería</option> 
                                                            <option value="PA">Pasaporte</option> 
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="small mb-1" for="inputPassword">Número Documento</label>
                                                        <input class="form-control" id="inputNumDoc" type="number" placeholder="Número de Documento"/>
                                                    </div>
                                                </div>
                                            </div>
                                            <label class="small mb-1" for="inputFirstName">Nombres</label>
                                            <div class="form-row">                                                
                                                <div class="col-md-6">
                                                    <div class="form-group">                                                        
                                                        <input class="form-control" id="inputFirstName" type="text" placeholder="Ingrese su primer nombre" required/>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <input class="form-control" id="inputSecondName" type="text" placeholder="Ingrese su segundo nombre"/>
                                                    </div>
                                                </div>
                                            </div>
                                            <label class="small mb-1" for="inputFirstName">Apellidos</label>
                                            <div class="form-row">
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <input class="form-control" id="inputFirstLastName" type="text" placeholder="Ingrese su primer apellido" required/>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <input class="form-control" id="inputSecondLastName" type="text" placeholder="Ingrese su segundo apellido"/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-row">                                                
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="small mb-1" for="inputCel">Celular</label>                                                        
                                                        <input class="form-control" id="inputCel" type="number" placeholder="Número de Celular" required/>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="small mb-1" for="inputTel">Teléfono Fijo</label>
                                                        <input class="form-control" id="inputTel" type="number" placeholder="Número de Teléfono Fijo"/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="small mb-1" for="inputEmailAddress">Correo electrónico</label>
                                                <input class="form-control" id="inputEmail" type="email" aria-describedby="emailHelp" placeholder="Correo electrónico institucional" required/>
                                            </div>

                                            <div class="form-row">                                                
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="small mb-1" for="inputPassword">Contraseña</label>
                                                        <input class="form-control" id="inputPassword" type="password" placeholder="Contraseña" required/>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="small mb-1" for="inputRol">Rol</label>
                                                        <select name="inputRol" class="form-control" >
                                                            <option value="Psicólogo">Psicólogo</option> 
                                                            <option value="Auxiliar">Auxiliar</option> 
                                                        </select>
                                                    </div>
                                                </div>

                                                
                                            </div>



                                            <center>
                                                <button type="submit" class="btn btn-primary">
                                                    Ingresar
                                                </button>
                                            </center>

                                        </form>
                                    </div>
                                    <div class="card-footer text-center">
                                        <div class="small"><a href="login.jsp">¿Ya teine una cuenta? Inicie Sesión</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
                <br><br>

            </div>


            <div id="layoutAuthentication_footer">
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; GISIC</div>
                            <div>
                                <img src="./assets/img/logo.png" alt="" style="width:158px; height:40px;">
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
