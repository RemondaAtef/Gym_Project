/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gym;

/**
 *
 * @author hassan zidan
 */
public interface Alter{
   public void delete(int id);
   public void commitToFile();
   public void loadFromFile();
   public int getIndex(int id);
   public String getData();
   public boolean login(String userName, String Pass);
    
}
