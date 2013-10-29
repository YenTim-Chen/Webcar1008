/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Service.UserService;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Userbean;

@WebServlet(name = "loginServlet", urlPatterns = {"/loginServlet"})
public class loginServlet extends HttpServlet {

      /**
       * Processes requests for both HTTP
       * <code>GET</code> and
       * <code>POST</code> methods.
       *
       * @param request servlet request
       * @param response servlet response
       * @throws ServletException if a servlet-specific error occurs
       * @throws IOException if an I/O error occurs
       */
      protected void processRequest(HttpServletRequest request, HttpServletResponse response)
              throws ServletException, IOException {

            if (!request.getParameter("loginName").isEmpty() && !request.getParameter("password").isEmpty()) {
                  //re
//                  HttpSession session = request.getSession();
//                  remember(request, response);
//                  session.setAttribute("username", request.getParameter("username"));
                  String loginName = request.getParameter("loginName");
                  loginName.trim();
                  String password = request.getParameter("password");
                  password.trim();
                  
                  ServletContext context = this.getServletContext();
                  UserService userservice = (UserService) context.getAttribute("UserService");
                  Userbean userbean = new Userbean(loginName, password);
                  
                  if (!userservice.userRepeat(userbean).isEmpty()) {
                              HttpSession session=request.getSession();
                              session.setAttribute("username",loginName);
                        response.sendRedirect("ShowBooks");
                        return;
                  } else {
                        response.sendRedirect("Login.jsp");
                        return;
                  }

            } else {
                  request.getRequestDispatcher("Login.jsp").forward(request, response);

            }


//                  PrintWriter out = response.getWriter();
//                  out.println("<form action='loginServlet' method='get'>");
//                  out.println("username:<intpu type=text,name=username,value=Kitty></input>");
//                  out.println("password:<input type=password,name=password,value=123456></input>");
//                  out.println("<input type=submit value=send");
//                  out.println("</form>");
//                  out.println("<input type=checkbox name=rememberme>remember me</input>");
//            

      }

      public void remember(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

            String rememberme = request.getParameter("rememberme");
            if (request.getParameter("rememberme") != null && "yes".equals(rememberme)) {
                  Cookie cookie = new Cookie("rememberme", rememberme);
                  cookie.setMaxAge(300);
                  response.addCookie(cookie);
            }

      }

      // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
      /**
       * Handles the HTTP
       * <code>GET</code> method.
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
       * Handles the HTTP
       * <code>POST</code> method.
       *
       * @param request servlet request
       * @param response servlet response
       * @throws ServletException if a servlet-specific error occurs
       * @throws IOException if an I/O error occurs
       */
      @Override
      protected void doPost(HttpServletRequest request, HttpServletResponse response)
              throws ServletException, IOException {
            processRequest(request, response);
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
