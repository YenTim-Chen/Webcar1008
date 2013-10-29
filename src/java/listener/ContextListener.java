/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import DAO.imp.BookDAOimpl;
import DAO.imp.UserDAOimpl;
import Service.BookService;
import Service.UserService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {

      @Override
      public void contextInitialized(ServletContextEvent ctx) {
                  DataSource datasource=null;
            
            try {
                 datasource= InitialContext.doLookup("java:comp/env/jdbc/webcart"); 
                 
            } catch (NamingException ex) {
                  Logger.getLogger(ContextListener.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            ServletContext context=ctx.getServletContext();
            context.setAttribute("BookService",new BookService(new BookDAOimpl(datasource)));
            context.setAttribute("UserService",new UserService(new UserDAOimpl(datasource)));
//            ServletContext context = ctx.getServletContext();
//            
//            context.setAttribute("books",new Bookstore());
      }

      

      @Override
      public void contextDestroyed(ServletContextEvent sce){
       }
}
