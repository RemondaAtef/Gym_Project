/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gym;

public abstract class User implements Alter {
 public   String Name;
 public   int Id;
 public   String UserName ;
 public    String Password ;
 public    int Age ;
 public   String Phone ;
 
 FileManager FileManager = new FileManager();

    public User(String Name, int Id, String UserName, String Password, int Age, String Phone) {
        this.Name = Name;
        this.Id = Id;
        this.UserName = UserName;
        this.Password = Password;
        this.Age = Age;
        this.Phone = Phone;
    }
 
 
 
 public void  setName(String name)
    {
        this.Name=name;
    } 
public void setId(int id)
    {
        this.Id=id;
    }
 public void setUserName(String UserName)
    {
        this.UserName=UserName;
    }
 public void setPassword(String Password)
    {
        this.Password=Password;
    }  
 public void setAge(int age)
    {
        this.Age=age;
    }
 public void setPhone(String Phone)
    {
        this.Phone=Phone;
    }
 public String getName()
 {
     return Name;
 }
 public int getId ()
 {
     return Id ;
 }
 public String getUserName ()
  {
      return UserName ;
  }
 public String getPassword ()
  {
      return Password;
  }
 public int getAge()
 {
     return Age ;
 }
 public String getPhone()
 {
     return Phone ;
 }
public String ToString()
{
    return "\n"+"iam "+ Name +"" + "\n" +"ID:"+Id+"\n"+"Age:"+Age+"\n"+"UserName:"+UserName+"\n"+"Password"+Password+"\n" +"Phone:"+Phone ;
}


}
