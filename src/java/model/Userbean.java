/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Objects;

/**
 *
 * @author timchen
 */
public class Userbean {
       private String account;
      private String password;

      public Userbean(String account, String password) {
            this.account = account;
            this.password = password;
      }

      public String getAccount() {
            return account;
      }

      public void setAccount(String account) {
            this.account = account;
      }

      public String getPassword() {
            return password;
      }

      public void setPassword(String password) {
            this.password = password;
      }

      @Override
      public int hashCode() {
            int hash = 7;
            hash = 17 * hash + Objects.hashCode(this.account);
            hash = 17 * hash + Objects.hashCode(this.password);
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
            final Userbean other = (Userbean) obj;
            if (!Objects.equals(this.account, other.account)) {
                  return false;
            }
            if (!Objects.equals(this.password, other.password)) {
                  return false;
            }
            return true;
      }
}
