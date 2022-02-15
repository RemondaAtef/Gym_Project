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

import java.util.ArrayList;

/**
 *
 * -author hassan zidan
 */
public class Coach extends User {

    
    
    
    

    public Coach(String Name,int Id,String UserName,String Password,int Age,String Phone,double salary) {
        super(Name,Id,UserName,Password,Age,Phone);
        this.salary = salary;
       
    }

 public Coach(){
        super("",0,"","",0,"");
 }

    private final String CoachFileName = "Coach.txt";
    public static ArrayList<Coach> Coaches = new ArrayList<Coach>(); 

   private double salary;
   private String msg;


   

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public double getSalary() {
        return salary;
    }

    public String getMsg() {
        return msg;
    }
    
    @Override
    public String getData(){
        return Name + "-" + Id + "-" + UserName + "-" + Password + "-" + Age + "-" + Phone + "-" + salary ;  
    }
    
    public void addCoach(){
        FileManager.write(getData(),CoachFileName,true);
    }
    @Override
    public void loadFromFile(){
            Coaches = (ArrayList<Coach>) (Object) FileManager.read(CoachFileName);
    
    }
    @Override
    public int getIndex(int id){
        for(int i =0;i<Coaches.size();i++)
            if(Coaches.get(i).getId()==id) return i;
             
        
     return -1;   
    }
    
@Override
    public void commitToFile(){
        
        int index = Coaches.size();
        if(index!=0){
        
        FileManager.write(Coaches.get(0).getData(),CoachFileName,false);
        
        for(int i=1;i<Coaches.size();i++) FileManager.write(Coaches.get(i).getData(),CoachFileName,true);
        
        }
        else if(index==0){
            FileManager.write("",CoachFileName,false);
        }
      }
    
   public void updateCoach(int oldId,Coach x){
       loadFromFile();
       int index = getIndex(oldId);
       Coaches.set(index,x);
       commitToFile();
   }
   public Coach search(int id){
       loadFromFile();
       int index = getIndex(id);
       if(index!=-1){
           return Coaches.get(index);}
       else return null;
       
   }
     @Override  
    public void delete(int id){
        loadFromFile();
        int index = getIndex(id);
       Coaches.remove(index);
       commitToFile();
    }
    
 
    public ArrayList<Coach> list(){
        loadFromFile();
       return Coaches;
    }
 
    private void putPlan(Plan x){
        
   System.out.println("Thank You");
    
    }

    @Override
    public String toString() {
        return "{Name="+Name+"ID="+Id+"UserName="+UserName+"Password="+Password+"Age="+Age+"Phone"+Phone + ", salary=" + salary + '}';
    }
 
  @Override
    public boolean login(String userName, String Pass) {
        loadFromFile();
        for (Coach x : Coaches) {
            if (userName.equals(x.UserName) && Pass.equals(x.Password)) {
                return true;
            }
        }
        return false;
    }
    
}
