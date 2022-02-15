/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import gym.Member;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import gym.Admin;
import java.io.IOException;

public class MemberData {
    
    public static void Update(){
   Stage window = new Stage();
   window.setTitle("Member's Data");
   
           Admin admin = new Admin();

        
        GridPane grid = new GridPane();
        grid.setHgap(50);
        grid.setVgap(10);
        grid.setPadding(new Insets(10,10,10,10));
       
        Label Name = new Label("Name");
        Label Id = new Label("ID");
        Label UserName = new Label("UserName");
        Label Password = new Label("Password");
        Label Age = new Label("Age");
        Label Phone = new Label("Phone");
        Label EndDate = new Label("EndDate");
        Label Day1 = new Label("Day1");
        Label Day2 = new Label("Day2");
        Label Cost = new Label("Cost");
        Label YourCoach = new Label("YourCoach");
        Label YourId = new Label("Put Your ID ");
        
     
        
        
        TextField NameField = new TextField();
        TextField IdField = new TextField();
        TextField UserNameField = new TextField();
        PasswordField PasswordField = new PasswordField();
        TextField AgeField = new TextField();
        TextField PhoneField = new TextField();
        TextField EndDateField = new TextField();
        TextField Day1Field = new TextField();
        TextField Day2Field = new TextField();
        TextField CostField = new TextField();
        TextField YourCoachField = new TextField();
        TextField SearchField = new TextField();
  
  
        IdField.setEditable(false);
        EndDateField.setEditable(false);
        CostField.setEditable(false);
        YourCoachField.setEditable(false);
      
        
        GridPane.setConstraints(Name, 0, 1);
        GridPane.setConstraints(Id, 0, 2);
        GridPane.setConstraints(UserName, 0, 3);
        GridPane.setConstraints(Password, 0, 4);
        GridPane.setConstraints(Age, 0, 5);
        GridPane.setConstraints(Phone, 0, 6);
        GridPane.setConstraints(EndDate, 0, 7);
        GridPane.setConstraints(Day1, 0, 8);
        GridPane.setConstraints(Day2, 0, 9);
        GridPane.setConstraints(Cost, 0, 10);
        GridPane.setConstraints(YourCoach, 0, 11);
        
        GridPane.setConstraints(NameField, 1, 1);
        GridPane.setConstraints(IdField, 1, 2);
        GridPane.setConstraints(UserNameField, 1, 3);
        GridPane.setConstraints(PasswordField, 1, 4);
        GridPane.setConstraints(AgeField, 1, 5);
        GridPane.setConstraints(PhoneField, 1, 6);
        GridPane.setConstraints(EndDateField, 1, 7);
        GridPane.setConstraints(Day1Field, 1, 8);
        GridPane.setConstraints(Day2Field, 1, 9);
        GridPane.setConstraints(CostField, 1, 10);
        GridPane.setConstraints(YourCoachField, 1, 11);
        
         
        Label Text = new Label();
        Text.setFont(Font.font(30));
        GridPane.setConstraints(Text, 0, 12);
        grid.getChildren().add(Text);
        
        Button Save = new Button("Save");
        Button Delete = new Button("Delete");
        Button Search = new Button("Search");
        
        Search.setOnAction(e->{
            
            if("".equals(SearchField.getText())){
                
            Text.setText("Sorry,Put Your ID..");
            }
            else{
            Member m = new Member();
            Member x = new Member();
            x= m.search((int)Integer.parseInt(SearchField.getText()));
            
            NameField.setText(""+x.getName());
            IdField.setText(""+x.getId());
            UserNameField.setText(""+x.getUserName());
            PasswordField.setText(""+x.getPassword());
            AgeField.setText(""+x.getAge());
            PhoneField.setText(""+x.getPhone());
            EndDateField.setText(""+x.getEndDate());
            Day1Field.setText(""+x.getDay1());
            Day2Field.setText(""+x.getDay2());
            Day2Field.setText(""+x.getDay2());
            CostField.setText(""+x.getCost());
            YourCoachField.setText(""+x.getHisCoach());

            }
                        
                        
            
        });
        
        HBox  searchBox = new HBox();
        searchBox.getChildren().addAll(YourId,SearchField,Search);
        searchBox.setPadding(new Insets(10,10,10,100));
        searchBox.setSpacing(35);
        GridPane.setConstraints(searchBox, 0, 0);

       
       
        Save.setOnAction(new EventHandler<ActionEvent>() {
            
       @Override
       public void handle(ActionEvent e) {
           
     
         if("".equals(NameField.getText())||"".equals(IdField.getText())||
                 "".equals(UserNameField.getText())||"".equals(Password.getText())||
                 "".equals(AgeField.getText())||
                 "".equals(PhoneField.getText())||"".equals(EndDate.getText())||
                 "".equals(CostField.getText())||
                 "".equals(Day1Field.getText())||"".equals(Day2Field.getText())||
                 "".equals(YourCoachField.getText())){
                        Text.setText("Sorry,Put Your Data..");

         
       }
         else{
               
                   Member member = new Member(NameField.getText(),(int)Integer.parseInt(IdField.getText()),
         UserNameField.getText(),PasswordField.getText(),(int)Integer.parseInt(AgeField.getText()),
         PhoneField.getText(),EndDateField.getText(), (double)Double.parseDouble(CostField.getText()),
         Day1Field.getText(),Day2Field.getText(),(int)Integer.parseInt(YourCoachField.getText())
                 );
             admin.updateMember((int)Integer.parseInt(SearchField.getText()),member);
    
                NameField.clear();  IdField.clear();  UserNameField.clear();
            PasswordField.clear(); AgeField.clear(); 
            PhoneField.clear(); EndDateField.clear(); CostField.clear();
            Day1Field.clear(); Day2Field.clear();  YourCoachField.clear();
        
        Text.setText("Updated Successfully..");
               
         }
       }
       
       
   });
         Delete.setOnAction(em ->{
             if("".equals(SearchField.getText())){
                
            Text.setText("Sorry,Put Your ID..");
            }else{
             admin.deleteMember((int)Integer.parseInt(SearchField.getText()));
             }
             });
        
       
       HBox h = new HBox();
       h.getChildren().addAll(Save,Delete);
       h.setPadding(new Insets(10,10,10,10));
       h.setSpacing(35);
       GridPane.setConstraints(h, 1, 12);
       
      
       
        grid.getChildren().addAll(Name,Id,UserName,Password,Age,Phone,EndDate,Day1,Day2,Cost,YourCoach
                ,NameField,IdField,UserNameField,PasswordField,AgeField,PhoneField,EndDateField
                ,Day1Field,Day2Field,CostField,YourCoachField,h,searchBox);
        
       grid.setAlignment(Pos.CENTER);
       
       Label m = new Label("Your Data");
       m.setFont(Font.font ("Verdana", 60));
       
       BorderPane border = new BorderPane();
       border.setCenter(grid);
       border.setTop(m);
       BorderPane.setAlignment(m, Pos.CENTER);
       
       
        Scene scene = new Scene(border,700,650);
        window.setScene(scene);
        window.show();
    }
    
    public static void Msg(){
      Stage window = new Stage();
    GridPane grid = new GridPane();
    
     grid.setHgap(50);
     grid.setVgap(10);
     grid.setPadding(new Insets(10,10,10,10));
     
     Label Id = new Label("Put Your ID");
     GridPane.setConstraints(Id, 0, 0);
        
     TextField IdField = new TextField();
     GridPane.setConstraints(IdField, 1, 0);
     
     Label Text = new Label("This Msg From Your Coach :\n");
    GridPane.setConstraints(Text, 0, 2);
    

    Label Msg = new Label();
    Msg.setPadding(new Insets(10,10,10,10));
    Msg.setFont(Font.font(25));
    GridPane.setConstraints(Msg, 1, 3);
    
     Button Search = new Button("Search");
     GridPane.setConstraints(Search, 2, 0);
     
     Label Error = new Label();
     
     Search.setOnAction(e ->{
         if("".equals(IdField.getText())){
         GridPane.setConstraints(Error, 1, 3);
         Error.setText("Please Put Your ID Correctly");
         }
         else{
    Member m = new Member();
    Member x = new Member();
    m = x.search((int) Integer.parseInt(IdField.getText()));
    Msg.setText(m.getMsg());
         }
     });
     
    grid.getChildren().addAll(Text,Msg,IdField,Search,Id,Error);
    
    Scene scene = new Scene(grid,600,400);
    
      window.setScene(scene);
      window.setTitle("Message");
        window.show();
}
    
    public static void Report(){
    Stage window = new Stage();
    GridPane grid = new GridPane();
    
     grid.setHgap(50);
     grid.setVgap(10);
     grid.setPadding(new Insets(10,10,10,10));
        
     TextField IdField = new TextField();
     GridPane.setConstraints(IdField, 0, 0);
     
     Label Text = new Label("This Report From The Admin :\n");
    GridPane.setConstraints(Text, 0, 1);
    

    Label Report = new Label();
    Report.setPadding(new Insets(10,10,10,10));
    Report.setFont(Font.font(25));
    GridPane.setConstraints(Report, 0, 2);
    
     Button Search = new Button("Search");
     GridPane.setConstraints(Search, 1, 0);
 
     Label Error = new Label();
     
     Search.setOnAction(e ->{
         if("".equals(IdField.getText())){
             GridPane.setConstraints(Error, 0, 2);
             Error.setText("Please Put Your ID Correctly..");
         }
         else{
    Member m = new Member();
    Member x = new Member();
    m = x.search((int) Integer.parseInt(IdField.getText()));
    Report.setText(m.getReport());
         }
     });
     
    grid.getChildren().addAll(Text,Report,IdField,Search,Error);
    
    Scene scene = new Scene(grid,600,400);
    
      window.setScene(scene);
      window.setTitle("Report");
        window.show();
}
    
}
