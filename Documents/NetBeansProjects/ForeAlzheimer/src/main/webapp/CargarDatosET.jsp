<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html lang="es">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="GISIC" />

        <title>Fore-Alzheimer</title>
        <link rel="icon" type="image/jpg" href="./assets/img/ICON.png" />


        <link href="css/styles.css" rel="stylesheet" />
        <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet"
              crossorigin="anonymous" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js"
        crossorigin="anonymous"></script>
        <script type="text/javascript" src="./js/cargaArchivos.js" ></script>
    </head>

    <body class="sb-nav-fixed">
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <a class="navbar-brand mr-1" href="#">
                Fore-Alzheimer    
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
                        <a class="dropdown-item" href="#">Configuración</a>
                        <!--<a class="dropdown-item" href="#">Activity Log</a>-->
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="login.jsp">Salir</a>
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
                            <div class="sb-sidenav-menu-heading">Fore-Alzheimer</div>
                            <a class="nav-link" href="ConsultarDoc.jsp">
                                <div class="sb-nav-link-icon">
                                    <i class='fas fa-cloud-upload-alt' style='color:#212529'></i>
                                </div>
                                Cargar Datos
                            </a>
                            <a class="nav-link" href="ConsultarDocPred.jsp">
                                <div class="sb-nav-link-icon">
                                    <i class="fas fa-fw fa-signal" style='color:#212529'></i>
                                </div>
                                Ejecutar Modelo Predictivo
                            </a>
                            <a class="nav-link" href="ConsultarDocRes.jsp">
                                <div class="sb-nav-link-icon">
                                    <i class="far fa-fw fa-file-alt" style='color:#212529'></i>
                                </div>
                                Reportes
                            </a>




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
                        Nombre de Usuario
                        <!--configurar -->
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
                            <li class="breadcrumb-item">
                                <a href="forealzheimer.jsp">Fore-Alzheimer</a>
                            </li>
                            <li class="breadcrumb-item active">
                                <i class="fas fa-fw fa-cloud-upload-alt"></i>
                                Cargar Datos</li>
                        </ol>


                        <!--<div class="jumbotron">-->
                        <h3>Cargar Datos de Seguimiento Ocular</h3>
                        <br>
                        <div class="card mb-4">
                            <div class="card-header"><i class="fas fa-table mr-1"></i>Cargar archivos CSV correspondientes a EEG</div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <form   name="formulario" method="post" enctype="multipart/form-data" action="FilesController?action=ETCSV" >
                                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                            <thead>
                                                <tr>
                                                    <th> # Ejercicio de Entrenamiento Cognitivo </th>
                                                    <th> # Sesión </th>
                                                    <th> Archivo </th>
                                                </tr>
                                            </thead>
                                            <tfoot>
                                                <tr>
                                                    <th> # Ejercicio de Entrenamiento Cognitivo </th>
                                                    <th> # Sesión </th>
                                                    <th> Archivo </th>
                                                </tr>
                                            </tfoot>
                                            <tbody>
                                                <tr>
                                                    <th rowspan="3"> Ejercicio 01 </th>
                                                    <td> 1 </td>
                                                    <td>
                                                        <input class="custom-file" type="file"  name="csv1" required >

                                                        <!-- <button onclick="abortRead();">Cancel read</button> -->

                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td> 2 </td>
                                                    <td> 
                                                        <input class="custom-file" type="file"  name="csv2" required >
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td> 3 </td>
                                                    <td> 
                                                        <input class="custom-file" type="file"  name="csv3" required>

                                                    </td>
                                                </tr>

                                                <!--<tr>
                                                    <th rowspan="3"> Ejercicio 02 </th>
                                                    <td> 1 </td>
                                                    <td>
                                                        <input class="custom-file" type="file"  name="csv4" >
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td> 2 </td>
                                                    <td> 
                                                        <input class="custom-file" type="file"  name="csv5" >
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td> 3 </td>
                                                    <td> 
                                                        <input class="custom-file" type="file"  name="csv6" >

                                                    </td>
                                                </tr>
                                                <tr>
                                                    <th rowspan="3"> Ejercicio 03 </th>
                                                    <td> 1 </td>
                                                    <td>
                                                        <input class="custom-file" type="file"  name="csv7" >
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td> 2 </td>
                                                    <td> 
                                                        <input class="custom-file" type="file"  name="csv8" >
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td> 3 </td>
                                                    <td> 
                                                        <input class="custom-file" type="file"  name="csv9" >

                                                    </td>
                                                </tr>

                                                <tr>
                                                    <th rowspan="3"> Ejercicio 04 </th>
                                                    <td> 1 </td>
                                                    <td>
                                                        <input class="custom-file" type="file"  name="csv10" >
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td> 2 </td>
                                                    <td> 
                                                        <input class="custom-file" type="file"  name="csv11" >
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td> 3 </td>
                                                    <td> 
                                                        <input class="custom-file" type="file"  name="csv12" >

                                                    </td>
                                                </tr>

                                                <tr>
                                                    <th rowspan="3"> Ejercicio 05 </th>
                                                    <td> 1 </td>
                                                    <td>
                                                        <input class="custom-file" type="file"  name="csv13" >
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td> 2 </td>
                                                    <td> 
                                                        <input class="custom-file" type="file"  name="csv14" >
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td> 3 </td>
                                                    <td> 
                                                        <input class="custom-file" type="file"  name="csv15" >

                                                    </td>
                                                </tr>-->
                                                <!--
    
                                                <tr>
                                                    <th rowspan="3"> Ejercicio 06 </th>
                                                    <td> 1 </td>
                                                    <td>
                                                        <input class="custom-file" type="file"  name="csv16" >
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td> 2 </td>
                                                    <td> 
                                                        <input class="custom-file" type="file"  name="csv17" >
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td> 3 </td>
                                                    <td> 
                                                        <input class="custom-file" type="file"  name="csv18" >
    
                                                    </td>
                                                </tr>
    
                                                <tr>
                                                    <th rowspan="3"> Ejercicio 07 </th>
                                                    <td> 1 </td>
                                                    <td>
                                                        <input class="custom-file" type="file"  name="csv19" >
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td> 2 </td>
                                                    <td> 
                                                        <input class="custom-file" type="file"  name="csv20" >
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td> 3 </td>
                                                    <td> 
                                                        <input class="custom-file" type="file"  name="csv21" >
    
                                                    </td>
                                                </tr>
    
                                                <tr>
                                                    <th rowspan="3"> Ejercicio 08 </th>
                                                    <td> 1 </td>
                                                    <td>
                                                        <input class="custom-file" type="file"  name="csv22" >
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td> 2 </td>
                                                    <td> 
                                                        <input class="custom-file" type="file"  name="csv23" >
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td> 3 </td>
                                                    <td> 
                                                        <input class="custom-file" type="file"  name="csv24" >
    
                                                    </td>
                                                </tr>
    
                                                <tr>
                                                    <th rowspan="3"> Ejercicio 09 </th>
                                                    <td> 1 </td>
                                                    <td>
                                                        <input class="custom-file" type="file"  name="csv25" >
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td> 2 </td>
                                                    <td> 
                                                        <input class="custom-file" type="file"  name="csv26" >
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td> 3 </td>
                                                    <td> 
                                                        <input class="custom-file" type="file"  name="csv27" >
    
                                                    </td>
                                                </tr>
    
                                                <tr>
                                                    <th rowspan="3"> Ejercicio 10 </th>
                                                    <td> 1 </td>
                                                    <td>
                                                        <input class="custom-file" type="file"  name="csv28" >
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td> 2 </td>
                                                    <td> 
                                                        <input class="custom-file" type="file"  name="csv29" >
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td> 3 </td>
                                                    <td> 
                                                        <input class="custom-file" type="file"  name="csv30" >
    
                                                    </td>
                                                </tr>
    
                                                <tr>
                                                    <th rowspan="3"> Ejercicio 11 </th>
                                                    <td> 1 </td>
                                                    <td>
                                                        <input class="custom-file" type="file"  name="csv31" >
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td> 2 </td>
                                                    <td> 
                                                        <input class="custom-file" type="file"  name="csv32" >
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td> 3 </td>
                                                    <td> 
                                                        <input class="custom-file" type="file"  name="csv33" >
    
                                                    </td>
                                                </tr>
    
                                                <tr>
                                                    <th rowspan="3"> Ejercicio 12 </th>
                                                    <td> 1 </td>
                                                    <td>
                                                        <input class="custom-file" type="file"  name="csv34" >
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td> 2 </td>
                                                    <td> 
                                                        <input class="custom-file" type="file"  name="csv35" >
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td> 3 </td>
                                                    <td> 
                                                        <input class="custom-file" type="file"  name="csv36" >
    
                                                    </td>
                                                </tr>
    
                                                <tr>
                                                    <th rowspan="3"> Ejercicio 13 </th>
                                                    <td> 1 </td>
                                                    <td>
                                                        <input class="custom-file" type="file"  name="csv37" >
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td> 2 </td>
                                                    <td> 
                                                        <input class="custom-file" type="file"  name="csv38" >
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td> 3 </td>
                                                    <td> 
                                                        <input class="custom-file" type="file"  name="csv39" >
    
                                                    </td>
                                                </tr>
    
                                                <tr>
                                                    <th rowspan="3"> Ejercicio 14 </th>
                                                    <td> 1 </td>
                                                    <td>
                                                        <input class="custom-file" type="file"  name="csv40" >
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td> 2 </td>
                                                    <td> 
                                                        <input class="custom-file" type="file"  name="csv41" >
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td> 3 </td>
                                                    <td> 
                                                        <input class="custom-file" type="file"  name="csv42" >
    
                                                    </td>
                                                </tr>
    
                                                <tr>
                                                    <th rowspan="3"> Ejercicio 15 </th>
                                                    <td> 1 </td>
                                                    <td>
                                                        <input class="custom-file" type="file"  name="csv43" >
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td> 2 </td>
                                                    <td> 
                                                        <input class="custom-file" type="file"  name="csv44" >
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td> 3 </td>
                                                    <td> 
                                                        <input class="custom-file" type="file"  name="csv45" >
    
                                                    </td>
                                                </tr>
    
                                                -->
                                            </tbody>
                                        </table>
                                        <center>
                                            <div class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">

                                                <button type="submit" class="btn btn-primary btn-lg">Cargar</button>

                                            </div>
                                        </center>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <!--</div>-->


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
