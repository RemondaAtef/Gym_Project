/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gym;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mohamed
 */


public class Admin extends User{

    public Admin(String Name, int Id, String UserName, String Password, int Age, String Phone) {
        super(Name, Id, UserName, Password, Age, Phone);
    }

    public Admin() {
     
    super("",0,"","",0,"");
    }

 

    public void addMember(Member member )
{
member.addMember();}

public void addCoach(Coach coach)
        
{
    
    coach.addCoach();
    


}





    public void SearchForMember(int id) {
       Member member  = new Member ();
        System.out.println(member.search(id));
    }


   
    public void SearchForCoach(int id) {
    Coach coach = new Coach ();
    System.out.println(coach.search(id));
}



    public void deleteMember(int id) {
    Member member = new Member();
    member.delete(id);
    System.out.println("deleted successfully ..");
    }
    public void deletCoaches(int id) {
        Coach coach = new Coach ();
        coach.delete(id);
        System.out.println("deleted successfully ..");

    }

 

    public void updateMember(int oldId ,Member member) {
      
      member.updateMember(oldId,member);
      System.out.println("Updated successfully ..");
    }

    public void updateCoaches(int oldId ,Coach coach) {
       Coach coash  = new Coach();
        coach.updateCoach(oldId,coach);
        System.out.println("Updated successfully ..");
    }

    public void listMember(){
Member x = new Member();
System.out.println(x.list());
}
public void listCoach(){
        Coach x = new Coach();
        System.out.println(x.list());
        }



    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void commitToFile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void loadFromFile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getIndex(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   @Override
    public String toString() {
        return "{Name="+Name+"ID="+Id+"UserName="+UserName+"Password="+Password+"Age="+Age+"Phone"+Phone  + '}';
    }
    
     @Override
    public boolean login(String userName, String Pass) {

        if (userName.equals("Admin@yahoo.com") && Pass.equals("12345678")) {
            return true;
        }
        return false;

    }
}

