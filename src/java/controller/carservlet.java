/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Service.CarService;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Car;
import model.bookbean;

/**
 *
 * @author timchen
 */
@WebServlet(name = "carservlet", urlPatterns = {"/carservlet", "/goindex", "/clearall", "/deletebook"})
public class carservlet extends HttpServlet {

      private Car cart;

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
            HttpSession session = request.getSession();
            if (request.getServletPath().equals("/clearall")) {
                  clearall(request, response);
                  response.sendRedirect("book.jsp");
                  return;
            }

            if (request.getServletPath().equals("/deletebook")) {

                  String sid = request.getParameter("bookid");
                  sid.trim();
                  int id = Integer.parseInt(sid);

                  //ServletContext context = this.getServletContext();
                  List<bookbean> car = (List<bookbean>) session.getAttribute("car");
                  CarService carservice = new CarService();
                 //part2
                  while (car.contains(carservice.getOnebook(id))) {
                        car.remove(carservice.getOnebook(id));
                  }

//part1
//                  Bookstore bookstore = (Bookstore) context.getAttribute("books");
//
//                  while (car.contains(bookstore.getbook(id))) {
//                        car.remove(bookstore.getbook(id));
//                  }
//                  for (bookbean runrun : car) {
//                        cart.addcar(runrun);
//                        car=cart.deleteone(id);
//                     }
//                 
                 


            }

            ServletContext context = this.getServletContext();
            cart=new Car();
            
            //System.out.println((bookbean)context.getAttribute("car"));
            int sum = 0;
            if ((List<bookbean>) session.getAttribute("car") != null) {
                  List<bookbean> car = (List<bookbean>) session.getAttribute("car");
                  for (bookbean runrun : car) {
                        cart.addcar(runrun);
                        sum = cart.getsum();
                  }
                  
            }

            session.setAttribute("sum", sum);
            Map<bookbean, Integer> hm = new HashMap<>();
            hm = cart.onebookcount();

            session.setAttribute("buybook", hm);
            session.setAttribute("carbuy", hm);




            //session.setAttribute("bookcount", hm.get(hm));


            //request.setAttribute("car",);



            response.sendRedirect("cart.jsp");


      }

      public void clearall(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            //ServletContext context = this.getServletContext();
            HttpSession session = request.getSession();
            List<bookbean> car = (List<bookbean>) session.getAttribute("car");
            car.clear();
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
