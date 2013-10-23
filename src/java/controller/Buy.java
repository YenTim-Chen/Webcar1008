/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Service.BookService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Bookstore;
import model.bookbean;

/**
 *
 * @author timchen
 */
@WebServlet(name = "Buy", urlPatterns = {"/Buy"})
public class Buy extends HttpServlet {

      private Bookstore bookstore;

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

            String sid = request.getParameter("bookid");
            sid.trim();
            int id = Integer.parseInt(sid);

            HttpSession session = request.getSession();

            //ServletContext context = this.getServletContext();
            //BookService bookservice = new BookService();
            ServletContext context=this.getServletContext();
            BookService bookservice=(BookService)context.getAttribute("BookService");
            List<bookbean> buybook = null;
            buybook = (List<bookbean>) session.getAttribute("car");
            if (buybook != null) {
                  buybook.add(bookservice.getOnebook(id));
            } else {
                  buybook=new ArrayList<>();
                  buybook.add(bookservice.getOnebook(id));
                  session.setAttribute("car", buybook);
            }
            //            bookstore = (Bookstore) context.getAttribute("books");
            //
            //
            //            List<bookbean> book;
            //            book = (List<bookbean>) context.getAttribute("car");
            //            if (book != null) {
            //                  book.add(bookstore.getbook(id));
            //            } else {
            //                  book = new ArrayList<>();
            //                  book.add(bookstore.getbook(id));
            //                  context.setAttribute("car", book);
            //            }
            //            

            System.out.println(buybook);



            response.sendRedirect("ShowBooks");
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
