/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucatolica.forealzheimer.controlador;

import com.ucatolica.forealzheimer.BDConnection.StoreCSV;
import com.ucatolica.forealzheimer.model.Usuario;
import com.ucatolica.forealzheimer.model.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Daniela
 */
@MultipartConfig
public class FilesController extends HttpServlet {

    public FilesController() {
        super();
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FilesController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FilesController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Hola Servlet.. FilesController");
        String action = request.getParameter("action");
        System.out.println(action);

        //String ruta;
        switch (action) {
            case "EEG":

                ProcessFile(request, action);
                RedirectETCSV(request, response);
                break;
            case "ETCSV":

                ProcessFile(request, action);
                RedirectModel(request, response);
                break;
            case "ETAVI":

                // ProcessFile(request, response,action);
                //RedirectModel(request, response);
                break;

            default:
                consultar_doc(request, response, action);

                break;
        }
    }

    private void ProcessFile(HttpServletRequest request, String action)
            throws ServletException, IOException {

        HttpSession doc = request.getSession();
        String document = (String) doc.getAttribute("doc");

        List<Part> archivos = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            archivos.add(request.getPart("csv" + i));
        }
        //System.out.println("CSV"+1+archivos);

        StoreCSV csv = new StoreCSV();
        csv.StoreCsv(document, archivos, action);

    }

    private void RedirectETCSV(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/CargarDatosET.jsp");
        dispatcher.forward(request, response);
    }

    private void RedirectModel(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/modelo.jsp");
        dispatcher.forward(request, response);
    }

    private void RedirectConsultarDoc(HttpServletRequest request, HttpServletResponse response, String action) throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        sesion.setAttribute("action", action);
        switch (action) {
            case "UploadFile": {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/ConsultarDoc.jsp");
                dispatcher.forward(request, response);
                break;
            }
        }
    }

    void consultar_doc(HttpServletRequest request, HttpServletResponse response, String argument) throws ServletException, IOException {

        UsuarioDAO dao = new UsuarioDAO();
        int Num_documento = parseInt(request.getParameter("doc"));
        Usuario usr = (Usuario) dao.consultar(Num_documento);

        if (usr.getNum_documento() == Num_documento) {
            almacenar_doc(request, response, request.getParameter("doc"));
        } else {
            HttpSession sesion = request.getSession();
            sesion.setAttribute("argument", argument);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/Paciente_Error.jsp");
            dispatcher.forward(request, response);

        }
    }

    public List<String> Error_message(String argument) {
        List<String> message = new ArrayList<>();
        switch (argument) {
            case "Carga": {
                message.add("<ol class=\"breadcrumb\"><li class=\"breadcrumb-item\">"
                        + "<a href=\"index.jsp\">GISIC</a></li><li class=\"breadcrumb-item\">"
                        + "<a href=\"forealzheimer.jsp\">Fore-Alzheimer</a>"
                        + "</li><li class=\"breadcrumb-item active\"><i class=\"fas fa-fw fa-cloud-upload-alt\">"
                        + "</i>Cargar Datos</li></ol>");
                message.add("<center><h3>Cargar Archivos</h3></center><br>"
                        + "<center><label>El paciente no se encuentra registrado en el Sistema ARCA.</label>"
                        + "<br><br><div class=\"d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 "
                        + "my-2 my-md-0\"><a href=\"ConsultarDoc.jsp\" class=\"btn btn-primary btn-block\" "
                        + "role=\"button\">Regresar</a></div></center> ");

                break;
            }
            case "Recalcula": {

                message.add("<ol class=\"breadcrumb\"><li class=\"breadcrumb-item\">"
                        + "<a href=\"index.jsp\">GISIC</a></li><li class=\"breadcrumb-item\">"
                        + "<a href=\"forealzheimer.jsp\">Fore-Alzheimer</a>"
                        + "</li><li class=\"breadcrumb-item active\"><i class=\"fas fa-fw fa-signal\">"
                        + "</i>Ejecutar Modelos</li></ol>");
                message.add("<center><h3>Recalcular Predicciones</h3></center><br>"
                        + "<center><label>No se han hecho predicciones del paciente señalado.</label>"
                        + "<br><br><div class=\"d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 "
                        + "my-2 my-md-0\"><a href=\"ConsultarDocPred.jsp\" class=\"btn btn-primary btn-block\" "
                        + "role=\"button\">Regresar</a></div></center> ");

                break;
            }
            case "Consulta": {

                message.add("<ol class=\"breadcrumb\"><li class=\"breadcrumb-item\">"
                        + "<a href=\"index.jsp\">GISIC</a></li><li class=\"breadcrumb-item\">"
                        + "<a href=\"forealzheimer.jsp\">Fore-Alzheimer</a>"
                        + "</li><li class=\"breadcrumb-item active\"><i class=\"far fa-fw fa-file-alt\">"
                        + "</i>Resultados</li></ol>");
                message.add("<center><h3>Consultar Resultados</h3></center><br>"
                        + "<center><label>No se han hecho predicciones del paciente señalado.</label>"
                        + "<br><br><div class=\"d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 "
                        + "my-2 my-md-0\"><a href=\"ConsultarDocRes.jsp\" class=\"btn btn-primary btn-block\" "
                        + "role=\"button\">Regresar</a></div></center> ");

                break;
            }

        }
        return message;
    }

    private void almacenar_doc(HttpServletRequest request, HttpServletResponse response, String documento) throws IOException, ServletException {
        HttpSession sesion = request.getSession();
        sesion.setAttribute("doc", documento);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/CargarDatosEEG.jsp");
        dispatcher.forward(request, response);
//        response.sendRedirect("CargarDatos_p1.jsp");

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
