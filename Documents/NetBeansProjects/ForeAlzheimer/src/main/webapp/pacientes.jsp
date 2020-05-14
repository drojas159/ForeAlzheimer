<%@page import="java.util.ArrayList"%>
<%@page import="com.ucatolica.forealzheimer.controlador.UserController"%>
<%@page import="java.util.List"%>
<%@page import="com.ucatolica.forealzheimer.model.Usuario"%>
<%@include file="/sesion.jsp" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->

<%    String name = usr.getNombres() + " " + usr.getApellido1() + " " + usr.getApellido2();
    UserController controller = new UserController();
    String Rol[] = {"PACIENTE"};
    List<Usuario> pacientes = controller.consultarPacientes(Rol);
%>
<html lang="es">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="GISIC" />

        <title>GISIC</title>
        <link rel="icon" type="image/jpg" href="./assets/img/ICON.png" />
        <script type="text/javascript" src="./js/salir.js" ></script>
        <link href="css/styles.css" rel="stylesheet" />
        <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet"
              crossorigin="anonymous" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js"
        crossorigin="anonymous"></script>
        <script type="text/javascript" src="./js/cargaArchivos.js" ></script>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    </head>

    <body class="sb-nav-fixed">
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <a class="navbar-brand mr-1" href="#">
                GISIC    
            </a>   


            <button class="btn btn-link btn-sm order-1 order-lg-0" id="sidebarToggle" href="#">
                <i class="fas fa-bars"></i>
            </button>

            <!-- Navbar Search -->
            <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
                <!--<div class="input-group">
                        <input class="form-control" type="text" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2" />
                        <div class="input-group-append">
                            <button class="btn btn-primary" type="button"><i class="fas fa-search"></i></button>
                        </div>
                    </div>-->
            </form>
            <!-- Navbar-->
            <ul class="navbar-nav ml-auto ml-md-0">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="userDropdown" href="#" role="button" data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">
                        <label>Perfil</label>
                        <i class="fas fa-user fa-fw"></i></a>

                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                        <a class="dropdown-item" href="Profile.jsp">Configuración</a>
                        <!--<a class="dropdown-item" href="#">Activity Log</a>-->
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" onclick='salir();'>Salir</a>
                    </div>
                </li>
            </ul>
        </nav>

        <!--SideMenu-->
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-light" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            <div class="sb-sidenav-menu-heading">Mi Perfil</div>

                            <a class="nav-link" href="Profile.jsp">
                                <div class="sb-nav-link-icon">
                                    <i class='fas fa-user-alt' style='color:#212529'></i>

                                </div>
                                Mi Perfil
                            </a>


                            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseLayouts"
                               aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon">
                                    <i class='fas fa-user-edit' style='color:#212529'></i>
                                </div>
                                Editar Perfil
                                <div class="sb-sidenav-collapse-arrow">
                                    <i class="fas fa-angle-down"></i>
                                </div>
                            </a>
                            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne"
                                 data-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">

                                    <a class="nav-link" href="password.jsp">
                                        <div class="sb-nav-link-icon">
                                            <i class="far fa-user-circle" style='color:#212529'></i>
                                        </div>
                                        Editar Datos Personales
                                    </a>
                                    <a class="nav-link" href="passwordEdit.jsp">
                                        <div class="sb-nav-link-icon">
                                            <i class="fas fa-key" style='color:#212529'></i> 
                                        </div>
                                        Editar Contraseña</a>

                                </nav>
                            </div>


                            <div class="sb-sidenav-menu-heading">PERSONAS</div>
                            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePacientes"
                               aria-expanded="false" aria-controls="collapsePacientes">
                                <div class="sb-nav-link-icon">
                                    <i class="fas fa-notes-medical" style='color:#212529'></i>
                                </div>
                                Pacientes
                                <div class="sb-sidenav-collapse-arrow">
                                    <i class="fas fa-angle-down"></i>
                                </div>
                            </a>
                            <div class="collapse" id="collapsePacientes" aria-labelledby="headingOne"
                                 data-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">

                                    <a class="nav-link" href="pacientes.jsp">
                                        <div class="sb-nav-link-icon">
                                            <i class="far fa-user-circle" style='color:#212529'></i>
                                        </div>
                                        Consultar Pacientes
                                    </a>
                                    <a class="nav-link" href="NewPatient.jsp">
                                        <div class="sb-nav-link-icon">
                                            <i class="fas fa-user-plus" style='color:#212529'></i> 
                                        </div>
                                        Nuevo Paciente</a>
                                    <a class="nav-link" href="EditPatient.jsp">
                                        <div class="sb-nav-link-icon">
                                            <i class='fas fa-user-edit' style='color:#212529'></i>
                                        </div>
                                        Editar Pacientes</a>

                                </nav>
                            </div>

                            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUsuarios"
                               aria-expanded="false" aria-controls="collapseUsuarios">
                                <div class="sb-nav-link-icon">
                                    <i class="fas fa-user-md" style='color:#212529'></i>
                                </div>
                                Usuarios
                                <div class="sb-sidenav-collapse-arrow">
                                    <i class="fas fa-angle-down"></i>
                                </div>
                            </a>
                            <div class="collapse" id="collapseUsuarios" aria-labelledby="headingOne"
                                 data-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">

                                    <a class="nav-link" href="usuarios.jsp">
                                        <div class="sb-nav-link-icon">
                                            <i class="far fa-user-circle" style='color:#212529'></i>
                                        </div>
                                        Consultar Usuarios
                                    </a>
                                    <a class="nav-link" href="NewUsr.jsp">
                                        <div class="sb-nav-link-icon">
                                            <i class="fas fa-user-plus" style='color:#212529'></i> 
                                        </div>
                                        Nuevo Usuario</a>
                                    <a class="nav-link" href="EditUsr.jsp">
                                        <div class="sb-nav-link-icon">
                                            <i class='fas fa-user-edit' style='color:#212529'></i>
                                        </div>
                                        Editar Usuario</a>

                                </nav>
                            </div>


                            <div class="sb-sidenav-menu-heading">GISIC</div>
                            <a class="nav-link" href="index.jsp">
                                <div class="sb-nav-link-icon">
                                    <i class="fas fa-arrow-left" style='color:#212529'></i>
                                </div>
                                Volver a GISIC
                            </a>



                        </div>
                    </div>
                    <div class="sb-sidenav-footer">
                        <div class="small"> Conectado como:</div>

                        <%= name%>
                    </div>
                </nav>
            </div>

            <!-- Panel -->

            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid">

                        <br>
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item">
                                <a href="index.jsp">GISIC</a>
                            </li>
                            <li class="breadcrumb-item active">
                                <a href="Profile.jsp">
                                    <i class="fas fa-fw fa-cog"></i>
                                    Configuraciones
                                </a>
                            </li>
                            <li class="breadcrumb-item active">
                                <i class="fas fa-notes-medical"></i>
                                Pacientes</li>


                        </ol>
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-notes-medical"></i>
                                Pacientes</div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <div class="small">    
                                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">

                                            <thead>
                                                <tr>
                                                    <th></th>
                                                    <th>Tipo de Documento</th>
                                                    <th>Número de Documento</th>
                                                    <th>Nombres</th>
                                                    <th>Primer Apellido</th>
                                                    <th>Segundo Apellido</th>
                                                    <th>Teléfono Fijo</th>
                                                    <th>Celular</th>
                                                    <th>Email</th>

                                                </tr>
                                            </thead>
                                            <tfoot>
                                                <tr>
                                                    <th></th>
                                                    <th>Tipo de Documento</th>
                                                    <th>Número de Documento</th>
                                                    <th>Nombres</th>
                                                    <th>Primer Apellido</th>
                                                    <th>Segundo Apellido</th>
                                                    <th>Teléfono Fijo</th>
                                                    <th>Celular</th>
                                                    <th>Email</th>
                                                </tr>
                                            </tfoot>
                                            <tbody>


                                                <%
                                                    for (Usuario pac : pacientes) {

                                                %>
                                                <tr>
                                                    <td>
                                                        <form name="form" method="post"
                                                              action="UserController?action=DeletePatient">
                                                            <input style='display:none;' name='inputId' value='<%= pac.getNum_documento()%>'>
                                                            <button class="btn btn-danger">
                                                                <i class="fas fa-user-minus"></i>
                                                            </button>
                                                        </form></td>
                                                    <td><%= pac.getTipo_documento()%></td>
                                                    <td><%= pac.getNum_documento()%></td>
                                                    <td><%= pac.getNombres()%></td>
                                                    <td><%= pac.getApellido1()%></td>
                                                    <td><%= pac.getApellido2()%></td>
                                                    <td><%= pac.getTel_fijo()%></td>
                                                    <td><%= pac.getCelular()%></td>
                                                    <td><%= pac.getEmail().toLowerCase()%></td>

                                                </tr>
                                                <%
                                                        //controller.DeletePatient(pac);
                                                    }
                                                %>


                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>



                </main>

                <!--Footer -->

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
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
        <script src="js/jquery.dataTables.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="assets/demo/chart-area-demo.js"></script>
        <script src="assets/demo/chart-bar-demo.js"></script>
        <!--<script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js" crossorigin="anonymous"></script>-->
        <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js" crossorigin="anonymous"></script>
        <script src="assets/demo/datatables-demo.js"></script>
    </body>
</html>
