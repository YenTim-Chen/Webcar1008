

import BookDAO.selectbook;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author timchen
 */
public class NewClass {
       private static final String host="localhost";
           private static final String port="3306";
           private static final String db="test";
           private static final String jdbcurl="jdbc:mysql://"+host+":"+port+"/"+db+"?zeroDateTimeBehavior=convertToNull";
           private static final String user="root";
           private static final String password="base";
      public static void main(String [] args) throws ClassNotFoundException
      {     
           
            getBooks();
           
      
}

      public static void getBooks() {
            
            Connection connection = null;
            PreparedStatement preparedstatement = null;
            ResultSet resultset = null;
            try {
                  connection = DriverManager.getConnection(jdbcurl,user,password);
                  preparedstatement = connection.prepareStatement("SELECT * FROM Bookstore");
                  resultset = preparedstatement.executeQuery();
                  while (resultset.next()) {
                        System.out.println(resultset.getInt(1));
                        System.out.println(resultset.getString("bookname"));
                        System.out.println(resultset.getString("publisher"));
                        System.out.println(resultset.getInt(4));
                  }
            } catch (SQLException e) {
                  System.out.println(e.getMessage());
            } finally {
                  try {
                        if (resultset != null) {
                              resultset.close();
                        }
                  } catch (SQLException ex) {
                        Logger.getLogger(selectbook.class.getName()).log(Level.SEVERE, null, ex);
                  }
                  try {
                        if (preparedstatement != null) {
                              preparedstatement.close();
                        }
                  } catch (SQLException ex) {
                        Logger.getLogger(selectbook.class.getName()).log(Level.SEVERE, null, ex);
                  }
                  try {
                        if (connection != null) {
                              connection.close();
                        }
                  } catch (SQLException ex) {
                        Logger.getLogger(selectbook.class.getName()).log(Level.SEVERE, null, ex);
                  }
            }
      }
}