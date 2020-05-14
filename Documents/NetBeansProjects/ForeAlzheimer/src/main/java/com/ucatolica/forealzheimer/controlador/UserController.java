/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucatolica.forealzheimer.controlador;

import com.ucatolica.forealzheimer.model.Usuario;
import com.ucatolica.forealzheimer.model.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Daniela
 */
public class UserController extends HttpServlet {

    public UserController() {
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
            out.println("<title>Servlet UserController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserController at " + request.getContextPath() + "</h1>");
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

        System.out.println("Hola Servlet.. UserController");
        String action = request.getParameter("action");
        System.out.println(action);
        HttpSession sesion = request.getSession();
        //String ruta;
        switch (action) {
            case "login":
                GisicLogin(request, response);

                break;
            case "register":
                GisicRegister(request, response);

                break;

            case "PreEdit":
                ConfirmPassword(request, response);

                break;

            case "EditPassword":
                EditPassword(request, response);

                break;
            case "EditInfo":
                EditInfo(request, response);
                break;
            case "EditPatient":
                ConfirmPatient(request, response, action);

                break;
            case "EditUsr":
                ConfirmPatient(request, response, action);

                break;
            case "EditInfoPat":
                EditInfoPat(request, response);
                break;
            case "EditInfoUsr":
                EditInfoUsr(request, response);
                break;
            case "NewPatient":
                NewPatient(request, response);
                break;
            case "NewUsr": {
                NewUsr(request, response);
                sesion.setAttribute("ErrorLogin", "6");
                response.sendRedirect(request.getContextPath() + "/ConfirmEdit.jsp");

                break;
            }
            case "DeletePatient":
                DeletePatUsr(request, response, action);
                break;
            case "DeleteUsr":
                DeletePatUsr(request, response, action);
                break;
            default:

                break;
        }
    }

    public void DeletePatUsr(HttpServletRequest request, HttpServletResponse response, String action) throws IOException {
        int numDoc = parseInt(request.getParameter("inputId"));
        UsuarioDAO dao = new UsuarioDAO();
        dao.DeleteUser(numDoc);
        if (action.equals("DeletePatient")) {
            response.sendRedirect(request.getContextPath() + "/pacientes.jsp");
        } else {
            response.sendRedirect(request.getContextPath() + "/usuarios.jsp");
        }

    }

    private void ConfirmPatient(HttpServletRequest request, HttpServletResponse response, String action) throws IOException {
        HttpSession sesion = request.getSession();
        int numDoc = parseInt(request.getParameter("inputDoc"));

        UsuarioDAO dao = new UsuarioDAO();

        Usuario usr = (Usuario) dao.consultar(numDoc);

        if (usr.getNum_documento() == numDoc) {
            sesion.setAttribute("docPatientUsr", numDoc);
            if ("EditUsr".equals(action)) {
                response.sendRedirect(request.getContextPath() + "/Edit_Usr.jsp");
            } else {
                response.sendRedirect(request.getContextPath() + "/Edit_Patient.jsp");
            }
        } else {
            sesion.setAttribute("ErrorLogin", "0");
            if ("EditUsr".equals(action)) {
                response.sendRedirect(request.getContextPath() + "/EditUsr.jsp");
            } else {
                response.sendRedirect(request.getContextPath() + "/EditPatient.jsp");
            }

        }
    }

    private void EditInfoUsr(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession sesion = request.getSession();
        int numDoc1 = (int) sesion.getAttribute("docPatientUsr");

        String tipo = request.getParameter("inputTipo");
        int numDoc2 = parseInt(request.getParameter("inputNumDoc"));
        String name = request.getParameter("inputNames").toUpperCase();
        String apellido1 = request.getParameter("inputFirstLastName").toUpperCase();
        String apellido2 = request.getParameter("inputSecondLastName").toUpperCase();
        String numCel = request.getParameter("inputCel");
        String numTel = request.getParameter("inputTel");
        String email = request.getParameter("inputEmail").toUpperCase();
        String rol = request.getParameter("inputRol");
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usr;
        if ("PSICOLOGO".equals(rol)) {
            usr = new Usuario(tipo, numDoc2, name, apellido1, apellido2, "", numTel, numCel, email,
                    null, rol, null);
            dao.updateUsr(usr, numDoc1);

        } else if ("AUXILIAR".equals(rol)) {
            usr = new Usuario(tipo, numDoc2, name, apellido1, apellido2, "", numTel, numCel, email,
                    rol, null, null);
            dao.updateUsr(usr, numDoc1);

        }

        sesion.setAttribute("ErrorLogin", "7");
        response.sendRedirect(request.getContextPath() + "/ConfirmEdit.jsp");
        sesion.setAttribute("docPatientUsr", "");
    }

    private void EditInfoPat(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession sesion = request.getSession();
        int numDoc1 = (int) sesion.getAttribute("docPatientUsr");

        String tipo = request.getParameter("inputTipo");
        int numDoc2 = parseInt(request.getParameter("inputNumDoc"));
        String name = request.getParameter("inputNames").toUpperCase();
        String apellido1 = request.getParameter("inputFirstLastName").toUpperCase();
        String apellido2 = request.getParameter("inputSecondLastName").toUpperCase();
        String numCel = request.getParameter("inputCel");
        String numTel = request.getParameter("inputTel");
        String email = request.getParameter("inputEmail").toUpperCase();
        String rol = "PACIENTE";
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usr;

        usr = new Usuario(tipo, numDoc2, name, apellido1, apellido2, "", numTel, numCel, email,
                null, null, rol);
        dao.updateUsr(usr, numDoc1);
        sesion.setAttribute("ErrorLogin", "5");
        response.sendRedirect(request.getContextPath() + "/ConfirmEdit.jsp");
        sesion.setAttribute("docPatientUsr", "");
    }

    private void EditInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        Usuario usr_sesion = (Usuario) sesion.getAttribute("usuario");

        String tipo = request.getParameter("inputTipo");
        int numDoc = parseInt(request.getParameter("inputNumDoc"));
        String name = request.getParameter("inputNames").toUpperCase();
        String apellido1 = request.getParameter("inputFirstLastName").toUpperCase();
        String apellido2 = request.getParameter("inputSecondLastName").toUpperCase();
        String numCel = request.getParameter("inputCel");
        String numTel = request.getParameter("inputTel");
        String email = request.getParameter("inputEmail").toUpperCase();
        String rol = request.getParameter("inputRol");
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usr;
        if ("PSICOLOGO".equals(rol)) {
            usr = new Usuario(tipo, numDoc, name, apellido1, apellido2, "", numTel, numCel, email,
                    null, rol, null);
            dao.updateUsr(usr, usr_sesion.getNum_documento());

        } else if ("AUXILIAR".equals(rol)) {
            usr = new Usuario(tipo, numDoc, name, apellido1, apellido2, "", numTel, numCel, email,
                    rol, null, null);
            dao.updateUsr(usr, usr_sesion.getNum_documento());

        }
        usr = (Usuario) dao.consultaDatos(numDoc);
        sesion.setAttribute("usuario", usr);
        //sesion.setAttribute("logged", true);
        response.sendRedirect(request.getContextPath() + "/Profile.jsp");
    }

    private void NewUsr(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String tipo = request.getParameter("inputTipo");
        int numDoc = parseInt(request.getParameter("inputNumDoc"));
        String name = request.getParameter("inputNames").toUpperCase();
        String apellido1 = request.getParameter("inputFirstLastName").toUpperCase();
        String apellido2 = request.getParameter("inputSecondLastName").toUpperCase();
        String numCel = request.getParameter("inputCel");
        String numTel = request.getParameter("inputTel");
        String email = request.getParameter("inputEmail").toUpperCase();
        String password = request.getParameter("inputPassword");
        String rol = request.getParameter("inputRol");
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usr;

        if ("PSICOLOGO".equals(rol)) {
            usr = new Usuario(tipo, numDoc, name, apellido1, apellido2, password, numTel, numCel, email,
                    null, rol, null);
            dao.create(usr);

        } else if ("AUXILIAR".equals(rol)) {
            usr = new Usuario(tipo, numDoc, name, apellido1, apellido2, password, numTel, numCel, email,
                    rol, null, null);
            dao.create(usr);

        }
    }

    private void NewPatient(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession sesion = request.getSession();
        String tipo = request.getParameter("inputTipo");
        int numDoc = parseInt(request.getParameter("inputNumDoc"));
        String name = request.getParameter("inputNames").toUpperCase();
        String apellido1 = request.getParameter("inputFirstLastName").toUpperCase();
        String apellido2 = request.getParameter("inputSecondLastName").toUpperCase();
        String numCel = request.getParameter("inputCel");
        String numTel = request.getParameter("inputTel");
        String email = request.getParameter("inputEmail").toUpperCase();
        String password = request.getParameter("inputPassword");
        String rol = "PACIENTE";
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usr;

        usr = new Usuario(tipo, numDoc, name, apellido1, apellido2, password, numTel, numCel, email,
                null, null, rol);
        dao.create(usr);
        sesion.setAttribute("ErrorLogin", "4");
        response.sendRedirect(request.getContextPath() + "/ConfirmEdit.jsp");
    }

    private void GisicRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        boolean registro = false;

        String tipo = request.getParameter("inputTipo");
        int numDoc = parseInt(request.getParameter("inputNumDoc"));
        String name = request.getParameter("inputNames").toUpperCase();
        String apellido1 = request.getParameter("inputFirstLastName").toUpperCase();
        String apellido2 = request.getParameter("inputSecondLastName").toUpperCase();
        String numCel = request.getParameter("inputCel");
        String numTel = request.getParameter("inputTel");
        String email = request.getParameter("inputEmail").toUpperCase();
        String password = request.getParameter("inputPassword");
        String password2 = request.getParameter("inputPasswordConfirm");
        String rol = request.getParameter("inputRol");
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usr;

        if (password.equals(password2)) {
            if ("PSICOLOGO".equals(rol)) {
                usr = new Usuario(tipo, numDoc, name, apellido1, apellido2, password, numTel, numCel, email,
                        null, rol, null);
                registro = dao.register(usr);

            } else if ("AUXILIAR".equals(rol)) {
                usr = new Usuario(tipo, numDoc, name, apellido1, apellido2, password, numTel, numCel, email,
                        rol, null, null);
                registro = dao.register(usr);

            }

            if (registro == false) {
                sesion.setAttribute("ErrorLogin", "9");
                response.sendRedirect(request.getContextPath() + "/register.jsp");
            } else {
                response.sendRedirect(request.getContextPath() + "/login.jsp");
            }
        } else {

            sesion.setAttribute("ErrorLogin", "10");
            response.sendRedirect(request.getContextPath() + "/register.jsp");
        }

    }

    private void EditPassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        UsuarioDAO dao = new UsuarioDAO();

        Usuario usr = (Usuario) sesion.getAttribute("usuario");
        String oldPass = request.getParameter("inputOld");
        String newPass = request.getParameter("inputNew");
        System.out.println(oldPass);
        if (usr.getContrasena().equals(oldPass)) {
            sesion.setAttribute("ErrorLogin", "2");

            dao.ChangePassword(newPass, usr.getNum_documento());
            usr.setContrasena(newPass);
            sesion.setAttribute("usuario", usr);

            response.sendRedirect(request.getContextPath() + "/passwordEdit.jsp");
        } else {
            sesion.setAttribute("ErrorLogin", "3");

            response.sendRedirect(request.getContextPath() + "/passwordEdit.jsp");

        }
    }

    private void ConfirmPassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sesion = request.getSession();

        //System.out.println("Error: "+error);
        Usuario usr = (Usuario) sesion.getAttribute("usuario");
        String password = request.getParameter("inputPassword");

        if (usr.getContrasena().equals(password)) {

            response.sendRedirect(request.getContextPath() + "/EditarPerfil.jsp");
        } else {
            sesion.setAttribute("ErrorLogin", "1");
            response.sendRedirect(request.getContextPath() + "/password.jsp");

        }

    }

    private void GisicLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        String email = request.getParameter("inputEmail").toUpperCase();
        String password = request.getParameter("inputPassword");
        UsuarioDAO dao = new UsuarioDAO();

        Usuario usr = (Usuario) dao.login(email);

        if (usr.getEmail() == null ? email != null : !usr.getEmail().equals(email)) {

            sesion.setAttribute("ErrorLogin", "8");

            response.sendRedirect(request.getContextPath() + "/login.jsp");;

        } else if (usr.getContrasena().equals(password)) {

            almacenar_usr(request, response, usr);

        } else {

            sesion.setAttribute("ErrorLogin", "1");
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }

    }

    public List<String> Error_login(String argument) {
        List<String> message = new ArrayList<>();
        switch (argument) {
            case "0":
                message.add(0, "El número de documento no se encuentra registrado.");
                break;
            case "1":
                message.add(0, "The password is incorrect. Please try again.");
                break;
            case "2":
                message.add(0, "Contraseña cambiada con éxito.");
                break;
            case "3":
                message.add(0, "La contraseña antigua no es correcta.");
                break;
            case "4":
                message.add(0, "¡Paciente creado exitosamente!");
                message.add(1, "<a href=\"./pacientes.jsp\" class=\"btn btn-primary\" role=\"button\">Ver Pacientes</a>");
                break;
            case "5":
                message.add(0, "¡Paciente actualizado exitosamente!");
                message.add(1, "<a href=\"./pacientes.jsp\" class=\"btn btn-primary\" role=\"button\">Ver Pacientes</a>");
                break;
            case "6":
                message.add(0, "¡Usuario creado exitosamente!");
                message.add(1, "<a href=\"./usuarios.jsp\" class=\"btn btn-primary\" role=\"button\">Ver Usuarios</a>");
                break;

            case "7":
                message.add(0, "¡Usuario actualizado exitosamente!");
                message.add(1, "<a href=\"./usuarios.jsp\" class=\"btn btn-primary\" role=\"button\">Ver Usuarios</a>");
                break;
            case "8":
                message.add(0, "Email address not registered.");

                break;
            case "10":
                message.add(0, "Passwords do not match. Try Again.");

                break;
            case "9":
                message.add(0, "ID number is already registered.");

                break;

            default:
                message.add(0, "");
                break;
        }
        return message;
    }

    public Usuario consultarUsuario(int numDoc) {
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usr = dao.consultarUsuario(numDoc);
        return usr;
    }

    public Usuario consultarPaciente(int numDoc) {
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usr = dao.consultarPaciente(numDoc);
        return usr;
    }

    public List<Usuario> consultarPacientes(String Rol[]) {
        UsuarioDAO dao = new UsuarioDAO();
        List<Usuario> pacientes = dao.consultarPacientes(Rol);
        return pacientes;
    }

    private void almacenar_usr(HttpServletRequest request, HttpServletResponse response, Usuario usr) throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        sesion.setAttribute("usuario", usr);
        //sesion.setAttribute("logged", true);
        response.sendRedirect(request.getContextPath() + "/index.jsp");
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
