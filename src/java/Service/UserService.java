/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.UserDAO;
import java.util.List;
import model.Userbean;

/**
 *
 * @author timchen
 */
public class UserService {
      
      UserDAO UserDAOimpl;
      public UserService(UserDAO UserDAO)
      {
      this.UserDAOimpl=UserDAO;
      }
      public void addUser(Userbean Userbean)
      {
         UserDAOimpl.addUser(Userbean);
      }  
      public List<String> getUser()
      {
        return UserDAOimpl.getUser();
      }
      public List<String> userRepeat(Userbean UserBean)
      {
      return UserDAOimpl.selectById(UserBean);
      }
      
      
}
