/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;
import gym.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Eng Mohammed
 */
public class UPDATE {
    
  public static void Display(){
   Stage window = new Stage();
        
        GridPane grid = new GridPane();
        grid.setHgap(25);
        grid.setVgap(25);
        grid.setPadding(new Insets(30,30,30,30));
       
        Label Name = new Label("Name");
        Label Id = new Label("ID");
        Label UserName = new Label("UserName");
        Label Password = new Label("Password");
        Label Age = new Label("Age");
        Label Phone = new Label("Phone");
        Label salary = new Label("salary");
         Label YourId = new Label("Put Your ID ");
        
        TextField NameField = new TextField();
        TextField IdField = new TextField();
        TextField UserNameField = new TextField();
        TextField PasswordField = new TextField();
        TextField AgeField = new TextField();
        TextField PhoneField = new TextField();
        TextField salaryField = new TextField();
        TextField SearchField = new TextField();

        GridPane.setConstraints(Name, 0, 1);
        GridPane.setConstraints(Id, 0, 2);
        GridPane.setConstraints(UserName, 0, 3);
        GridPane.setConstraints(Password, 0, 4);
        GridPane.setConstraints(Age, 0, 5);
        GridPane.setConstraints(Phone, 0, 6);
        GridPane.setConstraints(salary, 0, 7);
      
        
        GridPane.setConstraints(NameField, 1, 1);
        GridPane.setConstraints(IdField, 1, 2);
        GridPane.setConstraints(UserNameField, 1, 3);
        GridPane.setConstraints(PasswordField, 1, 4);
        GridPane.setConstraints(AgeField, 1, 5);
        GridPane.setConstraints(PhoneField, 1, 6);
        GridPane.setConstraints(salaryField, 1, 7);
       
        
        Button Save = new Button("Save");
        
         Save.setOnAction(e->{
           Coach coach = new Coach(NameField.getText(),(int)Integer.parseInt(IdField.getText()),
         UserNameField.getText(),PasswordField.getText(),(int)Integer.parseInt(AgeField.getText()),
         PhoneField.getText(),(double)Double.parseDouble(salaryField.getText()));
           
         Admin admin = new Admin();
         
       admin.updateCoaches((int)Integer.parseInt(SearchField.getText()),coach);
      // admin.addMember(member);
        Label thanks = new Label("Thank You");
            thanks.setFont(Font.font(30));
       GridPane.setConstraints(thanks, 0, 12);
       grid.getChildren().add(thanks);
        });
         
         
         
        Button Delete = new Button("Delete");
      Delete.setOnAction(e->{
          Admin admin=new Admin();
             Coach x=new Coach();
   admin.deletCoaches((int)Integer.parseInt(SearchField.getText()));
    Label Confirmation = new Label("Information Deleted");
            Confirmation.setFont(Font.font(30));
       GridPane.setConstraints(Confirmation, 0, 12);
       grid.getChildren().add(Confirmation);
             });
        
        
        Button Search=new Button("Search");
        Search.setOnAction(e->{
            Coach m = new Coach();
            Coach x = new Coach();
            x= m.search((int)Integer.parseInt(SearchField.getText()));
            
            NameField.setText(""+x.getName());
            IdField.setText(""+x.getId());
            UserNameField.setText(""+x.getUserName());
            PasswordField.setText(""+x.getPassword());
            AgeField.setText(""+x.getAge());
            PhoneField.setText(""+x.getPhone());
            salaryField.setText(""+x.getSalary());
          
            
        });
        Button Home=new Button("HOME");
        Home.setOnAction(e->{
         window.close();
         HOME.Display();
        
        });
               HBox h = new HBox();
           h.getChildren().addAll(Save,Delete,Home);
       h.setPadding(new Insets(10,10,10,10));
       h.setSpacing(35);
       GridPane.setConstraints(h, 1, 11);
       
       
         HBox  searchBox = new HBox();
        searchBox.getChildren().addAll(YourId,SearchField,Search);
        searchBox.setPadding(new Insets(10,10,10,10));
        searchBox.setSpacing(35);
        GridPane.setConstraints(searchBox, 0, 0);
        
        
        grid.getChildren().addAll(Name,Id,UserName,Password,Age,Phone,salary
                ,NameField,IdField,UserNameField,PasswordField,AgeField,PhoneField,salaryField
                ,h,searchBox);
        
       grid.setAlignment(Pos.CENTER);
       
       Label m = new Label("Personal Information");
         m.setFont(Font.font(30));
       BorderPane.setAlignment(m, Pos.CENTER);
       BorderPane border = new BorderPane();
       border.setCenter(grid);
       border.setTop(m);
       
        Scene scene = new Scene(border,700,650);
        window.setScene(scene);
        window.show();
    }
    
}
               