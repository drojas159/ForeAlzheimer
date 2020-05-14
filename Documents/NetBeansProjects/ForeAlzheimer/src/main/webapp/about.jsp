<%-- 
    Document   : about
    Created on : 4/05/2020, 3:37:06 p. m.
    Author     : Daniela
--%>

<%@page import="com.ucatolica.forealzheimer.model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/sesion.jsp" %>
<!DOCTYPE html>
<html lang="en">

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
    </head>

    <body class="sb-nav-fixed">
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <a class="navbar-brand mr-1" href="index.jsp">
                <span>GISIC</span>
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
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            <div class="sb-sidenav-menu-heading">GISIC</div>
                            <!--Info-->
                            <a class="nav-link" href="index.jsp">
                                <div class="sb-nav-link-icon">
                                    <i class="fas fa-home"></i>
                                </div>
                                Inicio
                            </a>
                            <a class="nav-link" href="about.jsp">
                                <div class="sb-nav-link-icon">
                                    <i class="fas fa-info-circle"></i>
                                </div>
                                Acerca de GISIC
                            </a>

                            <div class="sb-sidenav-menu-heading">EXPLORAR</div>
                            <a class="nav-link" href="covid.jsp">
                                <div class="sb-nav-link-icon">
                                    <i class="far fa-fw fa-file-alt"></i>
                                </div>
                                Covid-19
                            </a>

                            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseLayouts"
                               aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon">
                                    <i class="fas fa-desktop"></i>
                                </div>
                                Fore-Alzheimer
                                <div class="sb-sidenav-collapse-arrow">
                                    <i class="fas fa-angle-down"></i>
                                </div>
                            </a>
                            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne"
                                 data-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">

                                    <a class="nav-link" href="forealzheimer.jsp">
                                        <div class="sb-nav-link-icon">
                                            <i class="fas fa-fw fa-cloud-upload-alt"></i></div>
                                        Cargar Datos
                                    </a>
                                    <a class="nav-link" href="#">
                                        <div class="sb-nav-link-icon">
                                            <i class="fas fa-fw fa-signal"></i></div>
                                        Ejecutar Modelo Predictivo</a>
                                    <a class="nav-link" href="#">
                                        <div class="sb-nav-link-icon">
                                            <i class="far fa-fw fa-file-alt"></i></div>
                                        Reportes</a>
                                </nav>
                            </div>

                            <div class="sb-sidenav-menu-heading">PERSONAS</div>
                            <a class="nav-link" href="pacientes.jsp">
                                <div class="sb-nav-link-icon">
                                    <i class="fas fa-notes-medical"></i>
                                </div>
                                Pacientes
                            </a>
                            <a class="nav-link" href="usuarios.jsp">
                                <div class="sb-nav-link-icon">
                                    <i class="fas fa-user-md"></i>
                                </div>
                                Usuarios
                            </a>


                        </div>
                    </div>
                    <div class="sb-sidenav-footer">
                        <div class="small"> Conectado como:</div>
                        <%                        String name = usr.getNombres() + " " + usr.getApellido1() + " " + usr.getApellido2();
                            System.out.println("index.jsp" + name);
                        %>
                        <%= name%>
                        <!--configurar -->
                    </div>
                </nav>
            </div>

            <!-- Panel -->
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid">

                        <br>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active">Acerca de GISIC</li>
                        </ol>

                        <div class="jumbotron">
                            <center>
                                <h1>Acerca de GISIC</h1>
                                <br>

                                <div class="row">
                                    <div class="col-xl-6 text-justify">
                                        <br>
                                        El Grupo de Investigación en Software Inteligente y Convergencia Tecnológica GISIC fue fundado en el año 2010
                                        en la Universidad Católica de Colombia. <br><br>Abarcamos 
                                        áreas del conocimiento relacionadas con Ciencias Naturales,
                                        Computación y Ciencias de Información y Ciencias de la Computación, con el fin 
                                        de consolidar una comunidad académica y científica con los profesores de tiempo
                                        completo de los programas de Ingeniería de Sistemas y Computación, Ingeniería Electrónica 
                                        y Telecomunicaciones, Especialización en Auditoria de sistemas de Información, 
                                        Especialización en Seguridad de la Información y Maestría en Ingeniería y Gestión de la 
                                        Innovación de la Facultad de Ingeniería de la Universidad Católica de Colombia y fomentar 
                                        la búsqueda de formación en doctorado por parte de los profesores de los programas mencionados buscando 
                                        generar una producción investigativa de alto nivel.
                                        <br><br>
                                        <li><strong>Visión: </strong>Para el año 2022 el grupo de Investigación en Software Inteligente y Convergencia Tecnológica será un referente lcoal en la investigación y desarrollo de componentes de software basados en inteligencia artificial, que integren soluciones para la salud, educación y pequeña empresa maximizando la producción y optimización de recursos económicos y ambientales .</li>
                                        <br>
                                        <center>
                                            <a href="https://scienti.minciencias.gov.co/gruplac/jsp/visualiza/visualizagr.jsp?nro=00000000011415" class="btn btn-primary ">
                                                Conocer más sobre GISIC</a>
                                        </center>

                                    </div>
                                    <div class="col-xl-6">
                                        <div class="card mb-4">
                                            <div class="card-header">
                                                <i class="fas fa-university"></i>

                                                </i>Líder</div>
                                            <div class="card-body">
                                                <h4>Dr. Holman Diego Bolívar Barón</h4>
                                                <div class="text-justify">
                                                    <ul>
                                                        <li>

                                                            <strong>Doctorado </strong></br>

                                                            Doctorado en Ingeniería del Software en la Universidad Pontificia de Salamanca<br>
                                                            Febrero de 2010 - Junio de 2014<br>
                                                            <ul><li>Arquitectura Multi-agente Basada en Sistemas Difusos para el Seguimiento 
                                                                    del Aprendizaje a través de Entornos de Inmersión en Línea</ul></li>
                                                        </li>

                                                        <li>

                                                            <strong>Pregrado/Universitario  </strong></br>
                                                            Ingeniería de Sistemas en la Universidad Católica de Colombia<br>

                                                            Enero de 2001 - Marzo de 2007<br>
                                                            <ul><li>Prototipo de Videojuego para la Ensañanza y Practica Matemática</ul></li>
                                                        </li>
                                                        <li>

                                                            <strong>Perfeccionamiento </strong></br>

                                                            DEA Ingeniería del Software en la Universidad Pontificia de Salamanca<br>
                                                            Marzo de 2008 - Septiembre de 2009<br>
                                                            <ul><li>Ontología de la Composición Geométrica 3D para la Web con base en el Estándar X3D</ul></li>
                                                        </li>
                                                    </ul>
                                                    <center>
                                                        <a href="https://scienti.minciencias.gov.co/cvlac/visualizador/generarCurriculoCv.do?cod_rh=0001107933" class="btn btn-secondary ">Conocer más</a>
                                                    </center>
                                                </div>

                                            </div>
                                        </div>
                                    </div>

                                </div>

                            </center>

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
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="assets/demo/chart-area-demo.js"></script>
        <script src="assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js" crossorigin="anonymous"></script>
        <script src="assets/demo/datatables-demo.js"></script>
    </body>

</html>