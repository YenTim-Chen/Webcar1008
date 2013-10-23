package model;

import java.util.Objects;


public class bookbean {

private int id;
private String bookname;
private String publisher;
private int price;

public bookbean(){}


public bookbean(int id, String bookname, String publisher, int price) {
        this.id = id;
        this.bookname = bookname;
        this.publisher = publisher;
        this.price = price;
    }
public bookbean(String bookname, String publisher, int price)
{
        this.bookname = bookname;
        this.publisher = publisher;
        this.price = price;
}

      @Override
      public int hashCode() {
            int hash = 7;
            hash = 61 * hash + this.id;
            hash = 61 * hash + Objects.hashCode(this.bookname);
            hash = 61 * hash + Objects.hashCode(this.publisher);
            hash = 61 * hash + this.price;
            return hash;
      }

      @Override
      public boolean equals(Object obj) {
            if (obj == null) {
                  return false;
            }
            if (getClass() != obj.getClass()) {
                  return false;
            }
            final bookbean other = (bookbean) obj;
            if (this.id != other.id) {
                  return false;
            }
            if (!Objects.equals(this.bookname, other.bookname)) {
                  return false;
            }
            if (!Objects.equals(this.publisher, other.publisher)) {
                  return false;
            }
            if (this.price != other.price) {
                  return false;
            }
            return true;
      }



    public int getId() {
        return id;
    }

    public String getBookname() {
        return bookname;
    }
    

    public String getPublisher() {
        return publisher;
    }
    

    public int getPrice() {
        return price;
    }

    
    public void setId(int id) {
        this.id = id;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

   
}
