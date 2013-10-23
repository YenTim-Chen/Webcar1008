/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import BookDAO.selectbook;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Car;
import model.bookbean;

/**
 *
 * @author timchen
 */
public class CarService {

      Car cart;
      selectbook getbook = new selectbook();
     
      public bookbean getOnebook(int id) {

            return getbook.getOnebook(id);
      }

      public int getSum(List<bookbean> car) {

            cart = new Car();
            int sum = 0;
            for (bookbean runrun : car) {
                  cart.addcar(runrun);
                  sum = cart.getsum();
            }
            return sum;
      }

      public Map<bookbean, Integer> getCount() {
            
            cart = new Car();
            Map<bookbean, Integer> hm = new HashMap<>();
            hm = cart.onebookcount();
            return hm;
      }
}
