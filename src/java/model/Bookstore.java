/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Bookstore {

      List<bookbean> books = new ArrayList<>();

      public Bookstore() {
            creatbook();
      }

      public List<bookbean> getBooks() {
            return Collections.unmodifiableList(books);
      }

      public List<bookbean> creatbook() {
            books.add(new bookbean(1, "aaa", "aa", 123));
            books.add(new bookbean(2, "bbb", "aa", 123));
            books.add(new bookbean(3, "ccc", "aa", 123));
            books.add(new bookbean(4, "dd", "aa", 123));
            books.add(new bookbean(5, "eee", "aa", 123));
            books.add(new bookbean(6, "gg", "aa", 123));
            books.add(new bookbean(7, "ww", "aa", 123));
            return books;
      }

      synchronized public List<bookbean> addbook(String bookname, String publisher, int price) {
            
            books.add(new bookbean(books.size() + 1, bookname, publisher, price));
            return books;

      }
      
      
      
      public bookbean getbook(int id) {
            for (bookbean book : books) {
                  if (book.getId() == id) {
                        return book;
                  }
            }
            return null;
      }
}
