/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import GYM_FX.Coach_FX;
import gym.Admin;
import gym.Coach;
import gym.Member;
import gym.Plan;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Mohamed
 */
public class CoachData {
    
    
     public static void Plan(){
   Stage window = new Stage();
        
        GridPane grid = new GridPane();
        grid.setHgap(25);
        grid.setVgap(25);
        grid.setPadding(new Insets(30,30,30,30));
        
         Label YourId = new Label("Id");
        Label Saturday = new Label("Saturday");
        Label Sunday = new Label("Sunday");
        Label Monday = new Label("Monday");
        Label Tuesday = new Label("Tuesday");
        Label Wedensday = new Label("Wedensday");
        Label Thursday = new Label("Thursday");
        Label MemberId = new Label("MemberId");

        
        TextField IdField = new TextField();
        TextField SaturdayField = new TextField();
        TextField SundayField = new TextField();
        TextField MondayField = new TextField();
        TextField TuesdayField = new TextField();
        TextField WedensdayField = new TextField();
        TextField ThursdayField = new TextField();
        
      
        GridPane.setConstraints(YourId, 0, 1);
        GridPane.setConstraints(Saturday, 0, 2);
        GridPane.setConstraints(Sunday, 0, 3);
        GridPane.setConstraints(Monday, 0, 4);
        GridPane.setConstraints(Tuesday, 0, 5);
        GridPane.setConstraints(Wedensday, 0, 6);
        GridPane.setConstraints(Thursday, 0, 7);

        
        GridPane.setConstraints(IdField, 1, 1);
        GridPane.setConstraints(SaturdayField, 1, 2);
        GridPane.setConstraints(SundayField, 1, 3);
        GridPane.setConstraints(MondayField, 1, 4);
        GridPane.setConstraints(TuesdayField, 1, 5);
        GridPane.setConstraints(WedensdayField, 1, 6);
        GridPane.setConstraints(ThursdayField, 1, 7);
         
       
        
         Button Save = new Button("Save");
        GridPane.setConstraints(Save, 1, 9);
        Save.setPadding(new Insets(15,15,15,15));
         Save.setOnAction(e->{
             
              if("".equals(IdField.getText())||"".equals(SaturdayField.getText())||
                 "".equals(SundayField.getText())||"".equals(MondayField.getText())||
                 "".equals(TuesdayField.getText())||
                 "".equals(WedensdayField.getText())||"".equals(ThursdayField.getText())){
          AlterBox.ErrorBox("Error", "Put Your Data Correctly");
          }  
             
           Plan plan = new Plan((int)Integer.parseInt(IdField.getText()),SaturdayField.getText(),SundayField.getText(),
         MondayField.getText(),TuesdayField.getText(),WedensdayField.getText(),
         ThursdayField.getText());
           
           plan.addPlan();
     
        });
         
         
          Button Home=new Button("HOME");
        Home.setOnAction(e->{
         window.close();
         Coach_FX.Display();
        
        });
        GridPane.setConstraints(Home, 2, 9);
         Home.setPadding(new Insets(15,15,15,15));
         
          
        
        
        
        
        
         grid.getChildren().addAll(YourId,Saturday,Sunday,Monday,Tuesday,Wedensday,Thursday,
                IdField,SaturdayField,SundayField,MondayField,TuesdayField,WedensdayField,ThursdayField
                ,Save,Home);
        
       grid.setAlignment(Pos.CENTER);
       
       Label m = new Label("Member’s Plan");
         m.setFont(Font.font(30));
       BorderPane.setAlignment(m, Pos.CENTER);
       BorderPane border = new BorderPane();
       border.setCenter(grid);
       border.setTop(m);
       
        Scene scene = new Scene(border,700,650);
        window.setScene(scene);
        window.setTitle("Plan");
        window.show();
    }
    
   public static void List(){
    Stage window = new Stage();
    GridPane grid = new GridPane();
        grid.setHgap(50);
        grid.setVgap(10);
        grid.setPadding(new Insets(10,10,10,10));
        
TableView<Member> table ;

TableColumn<Member,String> nameColumn = new TableColumn<>("Name");
nameColumn.setMinWidth(100);
nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

TableColumn<Member,Integer> idColumn = new TableColumn<>("ID");
idColumn.setMinWidth(100);
idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

TableColumn<Member ,String> usernameColumn =new TableColumn<>("UserName");
usernameColumn.setMinWidth(120);
usernameColumn.setCellValueFactory(new PropertyValueFactory<>("UserName"));

TableColumn<Member,String> passwordColumn = new TableColumn<>("Password");
passwordColumn.setMinWidth(100);
passwordColumn.setCellValueFactory(new PropertyValueFactory<>("Password"));

TableColumn<Member,Integer> ageColumn = new TableColumn<>("Age");
ageColumn.setMinWidth(100);
ageColumn.setCellValueFactory(new PropertyValueFactory<>("Age"));

TableColumn<Member,String> phoneColumn = new TableColumn<>("Phone");
phoneColumn.setMinWidth(100);
phoneColumn.setCellValueFactory(new PropertyValueFactory<>("Phone"));

TableColumn<Member,String> EndDateColumn = new TableColumn<>("EndDate");
EndDateColumn.setMinWidth(100);
EndDateColumn.setCellValueFactory(new PropertyValueFactory<>("EndDate"));

TableColumn<Member,String> Day1Column = new TableColumn<>("Day1");
Day1Column.setMinWidth(100);
Day1Column.setCellValueFactory(new PropertyValueFactory<>("Day1"));

TableColumn<Member,String> Day2Column = new TableColumn<>("Day2");
Day2Column.setMinWidth(100);
Day2Column.setCellValueFactory(new PropertyValueFactory<>("Day2"));


TableColumn<Member,Double> CostColumn = new TableColumn<>("Cost");
CostColumn.setMinWidth(100);
CostColumn.setCellValueFactory(new PropertyValueFactory<>("Cost"));

TableColumn<Member,Integer> hisCoachColumn = new TableColumn<>("hisCoach");
hisCoachColumn.setMinWidth(100);
hisCoachColumn.setCellValueFactory(new PropertyValueFactory<>("hisCoach"));


   table = new TableView<Member>();
   ArrayList<Member> Members = new ArrayList<>();
   Member x = new Member();
   Members = x.list();
   ObservableList<Member> Members1 = FXCollections.observableArrayList(Members);
   table.setItems(Members1);
  
   
   
   table.getColumns().addAll(nameColumn,idColumn,usernameColumn,passwordColumn,ageColumn,phoneColumn,EndDateColumn,Day1Column,Day2Column,CostColumn,hisCoachColumn);
   GridPane.setConstraints(table, 0, 0);
   grid.getChildren().add(table);
   
    Scene scene = new Scene(grid,1120,400);
    window.setScene(scene);
    window.setTitle("Coaches");
    window.show();
     
  
}
    
    public static void Update(){
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
             
              if("".equals(NameField.getText())||"".equals(IdField.getText())||
                 "".equals(UserNameField.getText())||"".equals(Password.getText())||
                 "".equals(AgeField.getText())||
                 "".equals(PhoneField.getText())){
            AlterBox.ErrorBox("Error", "pleas Enter you all data");
            }
              else{
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
              }
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
            if("".equals(SearchField.getText())){
                
            AlterBox.ErrorBox("Error", "Wrong Id");
            }
            else{
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
            }
            
        });
        Button Home=new Button("HOME");
        Home.setOnAction(e->{
         window.close();
         Coach_FX.Display();
        
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
        window.setTitle("Coach's Data");
        window.show();
    }
    
    
    
      public static void Msg()
    {
        GridPane grid = new GridPane();
        Stage window = new Stage();
       
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(8);
        
        Label Id = new Label("Member Id");
        GridPane.setConstraints(Id, 0, 0);
        
        
        TextField IdField = new TextField();
        IdField.setPromptText("Member Id");
        GridPane.setConstraints(IdField, 1, 0);
        IdField.setMinWidth(100);
        
        Label Msg = new Label("Message");
        GridPane.setConstraints(Msg,0,1);
        
        TextField MsgField = new TextField();
        MsgField.setPromptText("Type a massage");
        GridPane.setConstraints(MsgField, 1, 1);
        MsgField.setMinSize(450, 200);
        
        
        
        Button Send = new Button("Send");
        GridPane.setConstraints(Send, 1, 3);
        
        Send.setOnAction(e -> {
            
         Member m = new Member() ;
         Member x = new Member() ;
         
         x= m.search((int)Integer.parseInt(IdField.getText()));
         x.setMsg(MsgField.getText());
         m.updateMember(x.getId(), x);
         
         
         });
        grid.getChildren().addAll(Id,IdField,Msg,MsgField,Send);
        Scene scene = new Scene(grid, 600, 300);
        
        
        
         window.setScene(scene);
         window.setTitle("Message");
         window.show();
         
        
    
        
       
    }
}
