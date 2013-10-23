package model;

import java.util.ArrayList;
import java.util.List;

public class bookdb {

    final List<bookbean> book = new ArrayList<>();

    public List<bookbean> creatbook(List<bookbean> book) {
        book.add(new bookbean(1, "aaa", "aa", 123));
        book.add(new bookbean(2, "bbb", "aa", 123));
        book.add(new bookbean(3, "ccc", "aa", 123));
        book.add(new bookbean(4, "dd", "aa", 123));
        book.add(new bookbean(5, "eee", "aa", 123));
        book.add(new bookbean(6, "gg", "aa", 123));
        book.add(new bookbean(7, "ww", "aa", 123));
        return book;
    }

    public bookbean getbyid(int id) {

        for (bookbean bookid : book) {
            if (bookid.getId() == id) {
                return bookid;
            }
        }
        return null;
    }
}
