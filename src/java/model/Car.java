package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.bookbean;

public class Car {

      List<bookbean> car = new ArrayList<>();

      //吃參數
      public void addcar(bookbean book) {
            this.car.add(book);//
      }

      //取總價格
      public int getsum() {
            int sum = 0;
            for (bookbean getmoney : car) {
                  sum += getmoney.getPrice();
            }
            return sum;
      }
      Map<Integer, Integer> car2 = new HashMap<>();

//      //取單本數量
//      public Map<Integer, Integer> onebookcount2(int id) {
//            int number = 1;
//            if (car2.containsKey(id)) {
//                  number = car2.get(id);
//                  number++;
//            }
//            car2.put(id, number);
//            return car2;
//      }
      
      Map<bookbean, Integer> car3 = new HashMap<>();
      public Map<bookbean, Integer> onebookcount() {

            int number = 1;
            for (bookbean cc : car) {
                  if (car3.containsKey(cc)) {
                        number = car3.get(cc);
                        number++;
                  }
                  car3.put(cc, number);
            }
            return car3;

      }

      public List<bookbean> deleteone(int id) {
            for (int i = 0; i < car.size(); i++) {
                  if (car.get(i).getId()==id) {
                        car.remove(i);
                  }
            }
            return car;
      }

      public void clear() {
            car.clear();
      }
}
