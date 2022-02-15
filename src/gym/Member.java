/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gym;

import static gym.Member.Members;
import java.util.ArrayList;

public class Member extends User {
 private   String endDate ;
 private   double Cost ;
 private   String msg ;
 private   String report ;
 private   int hisCoach ;
 private   String day1 ;
 private   String day2 ;
    public Member() {
        super("",0,"","",0,"");
        
    }

     private final String MemberFileName = "Member.txt";
    public static ArrayList<Member> Members = new ArrayList<Member>(); 
    
      public Member(  String Name, int Id, String UserName, String Password, int Age, String Phone,String endDate, double Cost, String day1,String day2 ,int hisCoach, String msg , String report) {
        super(Name, Id, UserName, Password, Age, Phone);
        this.endDate = endDate;
        this.Cost = Cost;
        this.day1= day1;
        this.day2= day2;
        this.hisCoach = hisCoach;
        this.msg = msg;
        this.report = report;
       
    }
   

        public Member(  String Name, int Id, String UserName, String Password, int Age, String Phone,String endDate, double Cost, String day1,String day2 ,int hisCoach ) {
        super(Name, Id, UserName, Password, Age, Phone);
        this.endDate = endDate;
        this.Cost = Cost;
        this.day1= day1;
        this.day2= day2;
        this.hisCoach = hisCoach;
        
       
    }
      

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setCost(double Cost) {
        this.Cost = Cost;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public void setHisCoach(int hisCoach) {
        this.hisCoach = hisCoach;
    }

    public void setDay1(String day1) {
        this.day1 = day1;
    }

    public void setDay2(String day2) {
        this.day2 = day2;
    }

    public String getEndDate() {
        return endDate;
    }

    public double getCost() {
        return Cost;
    }

    public String getMsg() {
        return msg;
    }

    public String getReport() {
        return report;
    }

    public int getHisCoach() {
        return hisCoach;
    }

    public String getDay1() {
        return day1;
    }

    public String getDay2() {
        return day2;
    }

@Override
    public String getData(){
        return Name + "-" + Id + "-" + UserName + "-" + Password + "-" + Age + "-" + Phone + "-" + Cost + "-" + hisCoach + "-" + day1 + "-" + day2 +"-"+endDate+"-"+msg+"-"+report  ;  
    }
    
    public void addMember(){
        FileManager.write(getData(),MemberFileName,true);
    }
    @Override
    public void loadFromFile(){
            Members = (ArrayList<Member>) (Object) FileManager.read(MemberFileName);
    
    }
       @Override
    public int getIndex(int id){
        for(int i =0;i<Members.size();i++)
            if(Members.get(i).getId()==id) return i;
             
        
     return -1;   
    }
    
    @Override
    public void commitToFile(){
        
        int index = Members.size();
        if(index!=0){
        
        FileManager.write(Members.get(0).getData(),MemberFileName,false);
        
        for(int i=1;i<Members.size();i++) FileManager.write(Members.get(i).getData(),MemberFileName,true);
        
        }
        else if(index==0){
            FileManager.write("",MemberFileName,false);
        }
      }
   
    
   public void updateMember(int oldId,Member x){
       loadFromFile();
       int index = getIndex(oldId);
       Members.set(index,x);
       commitToFile();
   }
   public Member search(int id){
       loadFromFile();
       int index = getIndex(id);
       if(index!=-1)
           return Members.get(index);
       else return null;
       
   }
     @Override  
    public void delete(int id){
        loadFromFile();
        int index = getIndex(id);
       Members.remove(index);
       commitToFile();
    }
    
 
    public ArrayList<Member> list(){
        loadFromFile();
        
       return Members;
       
    }
 
    public String getDays(){
        Plan x = new Plan();
        String s=x.checkDays(day1, day2, hisCoach);
 System.out.println( "Your Training :\n"+x.checkDays(day1, day2, hisCoach)); 
 return s;
    
    }

    @Override
    public String toString() {
        return "{Name="+Name+"ID="+Id+"UserName="+UserName+"Password="+Password+"Age="+Age+"Phone"+Phone + ", Cost=" + Cost + ", YourCoach=" +hisCoach + ", Day1=" + day1 + ", Day2=" + day2 +'}';
    }
 
    @Override
    public boolean login(String userName, String Pass) {
        loadFromFile();
        for (Member x : Members) {
            if (userName.equals(x.UserName) && Pass.equals(x.Password)) {
                return true;
            }
        }
        return false;
    }
    
}