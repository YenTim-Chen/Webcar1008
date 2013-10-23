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
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Bookstore;
import model.bookbean;

@WebServlet(name = "addbook", urlPatterns = {"/addbook"})
public class Addbook extends HttpServlet {

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
            ServletContext context=this.getServletContext();
            String bookname = request.getParameter("bookname");
            String publisher = request.getParameter("publisher");
            String sprice = request.getParameter("price");
            sprice.trim();
            int price = Integer.parseInt(sprice);

            //!
            bookbean bookbean = new bookbean();
            bookbean.setBookname(bookname);
            bookbean.setPublisher(publisher);
            bookbean.setPrice(price);
            
            
            BookService bookservice =(BookService)context.getAttribute("BookService");
            bookservice.addBook(bookbean);

            //            ServletContext context = this.getServletContext();
            //
            //            Bookstore bookstore = (Bookstore) context.getAttribute("books");
            //            bookstore.addbook(bookname, publisher, price);
            //            List<bookbean> book = bookstore.getBooks();

            //         bookbean books=new bookbean(bookname,publisher,price);
            //         books.setId(book.size()+1);
            //         book.add(books);

            //book.add(new bookbean(book.size()+1,bookname,publisher,price));
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
