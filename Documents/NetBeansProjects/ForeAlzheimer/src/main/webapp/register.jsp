<%@page import="java.util.List"%>
<%@page import="com.ucatolica.forealzheimer.controlador.UserController"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Registro en GISIC</title>
        <link rel="icon" type="image/jpg" href="./assets/img/ICON.png" />
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
                                    <div class="card-header"><h3 class="text-center font-weight-light my-4">Create an account in GISIC</h3></div>
                                    <div class="card-body">
                                        <form name="register_form" method="post"
                                              action="UserController?action=register">

                                            <div class="form-row">                                                
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="small mb-1" for="inputTipo">Documento type *</label>
                                                        <select name="inputTipo" class="form-control" >
                                                            <option value="CC">Citizenship Card</option> 
                                                            <option value="CE">Foreigner ID</option> 
                                                            <option value="PA">Passport</option> 
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="small mb-1" for="inputNumDoc">ID *</label>
                                                        <input class="form-control" name="inputNumDoc" type="number" placeholder="Enter ID number"/>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label class="small mb-1" for="inputNames">Name *</label>
                                                <input class="form-control" name="inputNames" type="text"  placeholder="Enter name" required/>
                                            </div>

                                            <div class="form-row">
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="small mb-1" for="inputLastNames">Last Name *</label>
                                                        <input class="form-control" name="inputFirstLastName" type="text" placeholder="Enter last name" required/>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="small mb-1" for="inputLastNames">Second Last Name</label>
                                                        <input class="form-control" name="inputSecondLastName" type="text" placeholder="Enter second last name"/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-row">                                                
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="small mb-1" for="inputCel">Mobile Phone Number *</label>                                                        
                                                        <input class="form-control" name="inputCel" type="number" placeholder="Enter mobile phone number *" required/>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="small mb-1" for="inputTel">Phone Number</label>
                                                        <input class="form-control" name="inputTel" type="number" placeholder="Enter phone number"/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-row">    
                                                <div class="col-md-6">
                                                <div class="form-group">
                                                    <label class="small mb-1" for="inputEmailAddress">Email *</label>
                                                    <input class="form-control" name="inputEmail" type="email" aria-describedby="emailHelp" placeholder="Enter email address" required/>
                                                </div>
                                                    </div>
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="small mb-1" for="inputRol">Role *</label>
                                                        <select name="inputRol" class="form-control" >
                                                            <option value="PSICOLOGO">Psychologist</option> 
                                                            <option value="AUXILIAR">Assistant</option> 
                                                        </select>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="form-row">                                                
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="small mb-1" for="inputPassword">Password *</label>
                                                        <input class="form-control" name="inputPassword" type="password" placeholder="Password" required/>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="small mb-1" for="inputPassword">Confirm Password *</label>
                                                        <input class="form-control" name="inputPasswordConfirm" type="password" placeholder="Confirm Password" required/>
                                                    </div>
                                                </div>


                                            </div>

                                            <center> 
                                                <div class="small" style='color:red'>
                                                    <p>

                                                        <%
                                                            UserController obj = new UserController();
                                                            HttpSession sesion = request.getSession();
                                                            String argument = (String) sesion.getAttribute("ErrorLogin");

                                                            if (argument == null) {
                                                                argument = "";
                                                            }

                                                            List<String> message = obj.Error_login(argument);

                                                        %>
                                                        <%= message.get(0)%>
                                                        <%
                                                            sesion.setAttribute("ErrorLogin", "");
                                                        %>
                                                    </p>
                                                </div>




                                                <button type="submit" class="btn btn-primary">
                                                    Create Account
                                                </button>
                                            </center>

                                        </form>
                                    </div>
                                    <div class="card-footer text-center">
                                        <div class="small"><a href="login.jsp">Have an account? Go to login</a></div>
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
