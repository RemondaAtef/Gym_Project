/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gym;

import java.util.ArrayList;

/**
 *
 * @author Mohamed
 */

public class Plan extends FileManager{
 
   private final String PlanFileName = "Plans.txt";
   public  static ArrayList<Plan> Plans = new ArrayList<Plan>();
    FileManager FileManager = new FileManager();

    public Plan(int coachId, String Sunday, String Monday, String Tuesday, String Wednesday, String Thursday,String Saturday) {
        this.coachId = coachId;
        this.Saturday = Saturday;
        this.Sunday = Sunday;
        this.Monday = Monday;
        this.Tuesday = Tuesday;
        this.Wednesday = Wednesday;
        this.Thursday = Thursday;
       
        
    }
     


     
     
    String Saturday;
    String Sunday;
    String Monday;
    String Tuesday;
    String Wednesday;
    String Thursday;
    int coachId;

   public Plan() {
   }

    public int getCoachId() {
        return coachId;
    }

    public void setCoachId(int coachId) {
        this.coachId = coachId;
    }

    public void setSaturday(String Saturday) {
        this.Saturday = Saturday;
    }

    public void setSunday(String Sunday) {
        this.Sunday = Sunday;
    }

    public void setMonday(String Monday) {
        this.Monday = Monday;
    }

    public void setTuesday(String Tuesday) {
        this.Tuesday = Tuesday;
    }

    public void setWednesday(String Wednesday) {
        this.Wednesday = Wednesday;
    }

    public void setThursday(String Thursday) {
        this.Thursday = Thursday;
    }

    public String getSaturday() {
        return Saturday;
    }

    public String getSunday() {
        return Sunday;
    }

    public String getMonday() {
        return Monday;
    }

    public String getTuesday() {
        return Tuesday;
    }

    public String getWednesday() {
        return Wednesday;
    }

    public String getThursday() {
        return Thursday;
    }
    
    
    private String getData(){
        return coachId + "-" + Saturday + "-" + Sunday + "-" + Monday + "-" + Tuesday + "-" + Wednesday + "-" + Thursday ;  
    }
    
    public void addPlan(){
         FileManager.write(getData(),PlanFileName,true);
    }
    private void loadFromFile(){
        Plans = (ArrayList<Plan>) (Object) FileManager.read(PlanFileName);
    }
    private int getIndex(int id){
        for(int i =0;i<Plans.size();i++)
            if(Plans.get(i).getCoachId()==id) return i;
             
        
     return -1;   
    }
    
  
    public void commitToFile(){
        
        int index = Plans.size();
        if(index!=0){
        
        FileManager.write(Plans.get(0).getData(),PlanFileName,false);
        
        for(int i=1;i<Plans.size();i++) FileManager.write(Plans.get(i).getData(),PlanFileName,true);
        
        }
        else if(index==0){
            FileManager.write("",PlanFileName,false);
        }
      }
    
    
    
    public String getPlan(String x,int CoachID){
        
        String Day = null;
       loadFromFile();
       int index = getIndex(CoachID);
            
           
        switch (x)
    {
        case "Saturday":
        Day=Plans.get(index).getSaturday();
        break;
        case "Sunday":
        Day=Plans.get(index).getSunday();
        break;
        case "Monday":
        Day=Plans.get(index).getMonday();
        break;
        case "Tuesday":
        Day=Plans.get(index).getTuesday();
        break;
        case "Wednesday":
        Day=Plans.get(index).getWednesday();
        break;
        case "Thursday":
        Day=Plans.get(index).getThursday();
        break;
        default: System.out.println("Please Choose another day ");
    
        }
    
    return Day;
    }
    
    public String checkDays(String Day1,String Day2,int CoachID){
        
     String x=null; 
     String[] days={"Saturday","Sunday","Monday","Tuesday","Wednesday","Thursday"};   
     String day1=Day1;
     String day2=Day2;
     
     for(int i=0;i<6;i++){
     if(days[i].equals(day1)){x=days[i]+": "+this.getPlan(day1,CoachID)+"\n";}
     if(days[i].equals(day2)){x=x+days[i]+": "+this.getPlan(day2,CoachID);}
     }
        
       
    
    return x;
    }
    
    
}
