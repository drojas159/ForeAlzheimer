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
import javax.servlet.RequestDispatcher;
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

        //String ruta;
        switch (action) {
            case "login":
                GisicLogin(request,response);

                break;
            case "register":
                GisicRegister(request,response);

                break;
            default:
                

                break;
        }
    }
    private void GisicRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
    }
    private void GisicLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession sesion = request.getSession();
        int doc = parseInt(request.getParameter("inputDoc"));
        String password = request.getParameter("inputPassword");
        UsuarioDAO dao = new UsuarioDAO();
        
        Usuario usr = (Usuario) dao.login(doc);
              
        if (usr.getNum_documento()==0){
            
            sesion.setAttribute("ErrorLogin", "0");
           
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
           
        }else if (usr.getContrasena().equals(password)){
           
            
            almacenar_usr(request, response, usr);
            
        }else{
            
            sesion.setAttribute("ErrorLogin", "1");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
            System.out.println("La contraseña no coincide");  
        } 
        
    }
    public String Error_login(String argument){
        String message;
        switch(argument){
            case "0":
                message="El número de documento no coincide";
                break;
            case "1":
                message="La contraseña no coincide";
                break;
            default:
                message="";
                break;
        }
        return message;
    }
    
    
    private void almacenar_usr(HttpServletRequest request, HttpServletResponse response, Usuario usr) throws ServletException, IOException{
        HttpSession sesion = request.getSession();
        sesion.setAttribute("usuario", usr);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
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

