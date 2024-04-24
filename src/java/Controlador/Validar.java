/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modelo.Empleado;


/**
 *
 * @author nacho
 */
public class Validar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    Empleado em = new Empleado();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
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
        String accion = request.getParameter("accion");
        String registrar = request.getParameter("registrar");
        
        if(accion != null){
            if(accion.equalsIgnoreCase("Ingresar")) {
                String user = request.getParameter("txtuser");
                String pass = request.getParameter("txtpass");
                em=em.Validar(user, pass);
                if((em.getUser() != null) && (em.getEstado().equalsIgnoreCase("0"))) {
                    request.setAttribute("usuario",em);
                    request.getRequestDispatcher("Controlador?menu=Principal").forward(request, response);
                }else if((em.getUser() != null) && (em.getEstado().equalsIgnoreCase("1"))){
                    request.setAttribute("usuario",em);
                    request.getRequestDispatcher("Controlador?menu=PrincipalSimple").forward(request, response);
                }
                else {
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
            }else{
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }
        
        if(registrar != null){
            if (registrar.equalsIgnoreCase("registrar")) {
                String dni = request.getParameter("txtDni");
                        String nom = request.getParameter("txtNombres");
                        String tel = request.getParameter("txtTel");
                        String est = "1";
                        String user = request.getParameter("txtUsuario");
                        em.setDni(dni);
                        em.setNom(nom);
                        em.setTel(tel);
                        em.setEstado(est);
                        em.setUser(user);  
                        em.agregar(em);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                }else{
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
        }
            
        
        doGet(request, response);
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
