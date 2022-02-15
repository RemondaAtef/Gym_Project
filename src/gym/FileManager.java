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
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author Mohamed
 */
class FileManager {

   public boolean write(String Query, String FilePath, boolean appendType) {

        PrintWriter writter = null;
        try {
            
            System.out.print("\nwritting in ! " + FilePath);

            writter = new PrintWriter(new FileWriter(new File(FilePath), appendType));
            if(Query==""){
                            writter.close();

            }else{
            writter.println(Query);
            System.out.println(" ... Done ! ");
            return true;}
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            writter.close();
        }
        return false;
    }
    public ArrayList<Object> read(String FilePath) {
       // Scanner input = new Scanner(System.in);
        
        Scanner Reader = null;
        try {
            System.out.println("Reading ! From " + FilePath);

            Reader = new Scanner(new File(FilePath));

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        if (FilePath.equals("Plans.txt")) {

            ArrayList<Plan> Plans = new ArrayList<>();
            Plan x ;

            while (Reader.hasNext()) {

                x = new Plan();
                
                String Line = Reader.nextLine();
                String[] seprated = Line.split("-");
                
                x.setCoachId((Integer.parseInt(seprated[0])));
                x.setSaturday(seprated[1]);
                x.setSunday(seprated[2]);
                x.setMonday(seprated[3]);
                x.setTuesday(seprated[4]);
                x.setWednesday(seprated[5]);
                x.setThursday(seprated[6]);
                Plans.add(x);
            }
            return(ArrayList<Object>)(Object)Plans;
        }
        else if(FilePath.equals("Coach.txt")){
        ArrayList<Coach> Coaches=new ArrayList<Coach>();
         Coach x;
        while(Reader.hasNext()){
           
        x=new Coach();
            String Line = Reader.nextLine();
            String[] seprated = Line.split("-");
        x.setName(seprated[0]);
        x.setId(Integer.parseInt(seprated[1]));
        x.setUserName(seprated[2]);
        x.setPassword(seprated[3]);
        x.setAge(Integer.parseInt(seprated[4]));
        x.setPhone(seprated[5]);
        x.setSalary(Double.parseDouble(seprated[6]));
        
        Coaches.add(x);
        }
        return(ArrayList<Object>)(Object)Coaches;
        }
        else if(FilePath.equals("Member.txt"))
        {
          ArrayList<Member> Members=new ArrayList<Member>();
        Member x;
        while(Reader.hasNext()){
        x=new Member();
        try{
            String Line = Reader.nextLine();
            String[] seprated = Line.split("-");
        x.setName(seprated[0]);
        x.setId(Integer.parseInt(seprated[1]));
        x.setUserName(seprated[2]);
        x.setPassword(seprated[3]);
        x.setAge(Integer.parseInt(seprated[4]));
        x.setPhone(seprated[5]);
        x.setCost(Double.parseDouble(seprated[6])); 
        x.setHisCoach(Integer.parseInt(seprated[7]));
        x.setDay1(seprated[8]);
        x.setDay2(seprated[9]);
        x.setEndDate(seprated[10]);  
        x.setMsg(seprated[11]);
        x.setReport(seprated[12]);
     
        
        Members.add(x);}
        catch(ArrayIndexOutOfBoundsException w){
        System.out.println(w);
        }
        }
        return(ArrayList<Object>)(Object)Members;
        }
        else{
            return null;
        }
    }
}