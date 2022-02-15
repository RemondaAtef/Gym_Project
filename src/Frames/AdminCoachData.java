/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import gym.Admin;
import gym.Coach;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Mohamed
 */
public class AdminCoachData {
    
    public static void Add(){
      Stage primaryStage = new Stage();
   Admin a =new Admin();
        TableView<Coach> table = new TableView<>();
        TableColumn<Coach ,String> Name =new TableColumn<>("Name");
        Name.setMinWidth(150);
        Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        
        TableColumn<Coach ,Integer> Id =new TableColumn<>("Id");
        Id.setMinWidth(100);
        Id.setCellValueFactory(new PropertyValueFactory<>("Id"));
        
        TableColumn<Coach ,String> UserName =new TableColumn<>("UserName");
        UserName.setMinWidth(150);
        UserName.setCellValueFactory(new PropertyValueFactory<>("UserName"));
        
        TableColumn<Coach ,String> Password =new TableColumn<>("Password");
        Password.setMinWidth(150);
        Password.setCellValueFactory(new PropertyValueFactory<>("Password"));
        
        TableColumn<Coach ,Integer> Age =new TableColumn<>("Age");
        Age.setMinWidth(150);
        Age.setCellValueFactory(new PropertyValueFactory<>("Age"));
        
          
        
        TableColumn<Coach ,String> phone =new TableColumn<>("Phone");
        phone.setMinWidth(150);
        phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        
        TableColumn<Coach ,Double> Salary =new TableColumn<>("Salary");
        Salary.setMinWidth(150);
        Salary.setCellValueFactory(new PropertyValueFactory<>("Salary"));
       
        
        
        TextField name = new TextField();
        name.setPromptText("Name");
        name.setMinWidth(25);
        
        TextField id = new TextField();
        id.setPromptText("Id");
        id.setMinWidth(25);
        
        TextField userName = new TextField();
        userName.setPromptText("UserName");
        userName.setMinWidth(25);
        
        TextField password = new TextField();
        password.setPromptText("Password");
        password.setMinWidth(25);
        
        TextField age = new TextField();
        age.setPromptText("Age");
        age.setMinWidth(25);
        
        TextField Phone = new TextField();
        Phone.setPromptText("Phone");
        Phone.setMinWidth(25);
        
        TextField salary = new TextField();
        salary.setPromptText("Salary");
        salary.setMinWidth(25);
        
        
        
        Button Add = new Button("Add");
        Add.setMinWidth(50);
        Add.setOnAction(e -> {
            
          if("".equals(name.getText())||"".equals(id.getText())||
                 "".equals(userName.getText())||"".equals(password.getText())||
                 "".equals(age.getText())||
                 "".equals(Phone.getText())||"".equals(salary.getText())){
          AlterBox.ErrorBox("Error", "Put Your Data Correctly");
          }  
          else{
      Coach coach =new Coach();
    
      coach.setName(name.getText());
      coach.setId(Integer.parseInt(id.getText()));
      coach.setUserName(userName.getText());
      coach.setPassword(password.getText());
      coach.setAge(Integer.parseInt(age.getText()));
      coach.setPhone(Phone.getText());
      coach.setSalary(Double.parseDouble(salary.getText()));
      
      table.getItems().add(coach);
      
      a.addCoach(coach);
      name.clear();
      id.clear(); userName.clear(); password.clear();   age.clear();  salary.clear(); Phone.clear();
          }
        });
      
        
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(name,id,userName,password,age,Phone,salary,Add);
        
        ArrayList<Coach> Coaches = new ArrayList<>();
        Coach x = new Coach();
        Coaches = x.list();
        ObservableList<Coach> coaches = FXCollections.observableArrayList(Coaches);
        
        table.setItems(coaches);
        table.getColumns().addAll(Name,Id,UserName,Password,Age,phone,Salary);
        
        VBox vBox = new VBox();
        vBox.getChildren().addAll(table,hBox);
        

       
        
        Scene scene = new Scene(vBox,1002,400);
        
        primaryStage.setTitle("Add New Coach");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

//--------------END------------------------------------------------------------------------------







 //ListFunction
 public static void Display(){
        Stage primaryStage = new Stage();
        Admin a =new Admin();
        TableView<Coach> table = new TableView<>();
        TableColumn<Coach ,String> Name =new TableColumn<>("Name");
        Name.setMinWidth(150);
        Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        
        TableColumn<Coach ,Integer> Id =new TableColumn<>("Id");
        Id.setMinWidth(100);
        Id.setCellValueFactory(new PropertyValueFactory<>("Id"));
        
        TableColumn<Coach ,String> UserName =new TableColumn<>("UserName");
        UserName.setMinWidth(150);
        UserName.setCellValueFactory(new PropertyValueFactory<>("UserName"));
        
        TableColumn<Coach ,String> Password =new TableColumn<>("Password");
        Password.setMinWidth(150);
        Password.setCellValueFactory(new PropertyValueFactory<>("Password"));
        
        TableColumn<Coach ,Integer> Age =new TableColumn<>("Age");
        Age.setMinWidth(150);
        Age.setCellValueFactory(new PropertyValueFactory<>("Age"));
        
          
        
        TableColumn<Coach ,String> phone =new TableColumn<>("Phone");
        phone.setMinWidth(150);
        phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        
        TableColumn<Coach ,Double> Salary =new TableColumn<>("Salary");
        Salary.setMinWidth(150);
        Salary.setCellValueFactory(new PropertyValueFactory<>("Salary"));
       
        
        
        TextField name = new TextField();
        name.setPromptText("Name");
        name.setMinWidth(70);
        
        TextField id = new TextField();
        id.setPromptText("Id");
        id.setMinWidth(25);
        
        TextField userName = new TextField();
        userName.setPromptText("UserName");
        userName.setMinWidth(70);
        
        TextField password = new TextField();
        password.setPromptText("Password");
        password.setMinWidth(70);
        
        TextField age = new TextField();
        age.setPromptText("Age");
        age.setMinWidth(25);
        
        TextField Phone = new TextField();
        Phone.setPromptText("Phone");
        Phone.setMinWidth(70);
        
        TextField salary = new TextField();
        salary.setPromptText("Salary");
        salary.setMinWidth(25);
   
        
        
        table =new TableView<Coach>();
        ArrayList<Coach> Coaches = new ArrayList<>();
        Coach z=new Coach();
        Coaches =z.list();
        ObservableList<Coach> coaches =FXCollections.observableArrayList(Coaches);
        table.setItems(coaches);
        
        table.getColumns().addAll(Name,Id,UserName,Password,Age,phone,Salary);
        
        VBox vBox = new VBox();
        vBox.getChildren().addAll(table);
        

       
        
        Scene scene = new Scene(vBox);
        
        primaryStage.setTitle("Coaches");
        primaryStage.setScene(scene);
        primaryStage.show();
    }










//Update Function
    public static void Update(){
  
   Stage window = new Stage();
   window.setTitle("Update Coach");
   
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
       Label Salary = new Label("Salary");

        Label YourId = new Label("Put Your ID ");
        
       
        
        
        TextField NameField = new TextField();
        TextField IdField = new TextField();
        TextField UserNameField = new TextField();
        PasswordField PasswordField = new PasswordField();
        TextField AgeField = new TextField();
        TextField PhoneField = new TextField();
        TextField SalaryField = new TextField();
        TextField SearchField = new TextField();
  
   
        
        GridPane.setConstraints(Name, 0, 1);
        GridPane.setConstraints(Id, 0, 2);
        GridPane.setConstraints(UserName, 0, 3);
        GridPane.setConstraints(Password, 0, 4);
        GridPane.setConstraints(Age, 0, 5);
        GridPane.setConstraints(Phone, 0, 6);
        GridPane.setConstraints(Salary, 0, 7);
    
        
        GridPane.setConstraints(NameField, 1, 1);
        GridPane.setConstraints(IdField, 1, 2);
        GridPane.setConstraints(UserNameField, 1, 3);
        GridPane.setConstraints(PasswordField, 1, 4);
        GridPane.setConstraints(AgeField, 1, 5);
        GridPane.setConstraints(PhoneField, 1, 6);
        GridPane.setConstraints(SalaryField, 1, 7);
        
     
        
        Button Save = new Button("Save");
        Button Delete = new Button("Delete");
        Button Search = new Button("Search");
        
         Label Text = new Label();
            Text.setFont(Font.font(30));
       GridPane.setConstraints(Text, 0, 8);
        Search.setOnAction(e->{
            
             if("".equals(SearchField.getText())){
                
            AlterBox.ErrorBox("Error", "Wrong Id");
            }
             else {
            Coach x = new Coach();
            Coach c =new Coach();
            x= c.search((int)Integer.parseInt(SearchField.getText()));
            
            NameField.setText(""+x.getName());
            IdField.setText(""+x.getId());
            UserNameField.setText(""+x.getUserName());
            PasswordField.setText(""+x.getPassword());
            AgeField.setText(""+x.getAge());
            PhoneField.setText(""+x.getPhone());
            SalaryField.setText(""+x.getSalary());
            
            
                  
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
                 "".equals(PhoneField.getText())){
            AlterBox.ErrorBox("Error", "pleas Enter you all data");
            }
                
                 
                else{

           
         Coach coach = new Coach(NameField.getText(),(int)Integer.parseInt(IdField.getText()),
         UserNameField.getText(),PasswordField.getText(),(int)Integer.parseInt(AgeField.getText()),
         PhoneField.getText(), (double)Double.parseDouble(SalaryField.getText()));
            
         
        admin.updateCoaches((int)Integer.parseInt(SearchField.getText()),coach);
        NameField.clear();  IdField.clear();  UserNameField.clear();
            PasswordField.clear(); AgeField.clear(); 
            PhoneField.clear(); SalaryField.clear();
        AlterBox.ComfirmationBox("Done", "Updated Successfully");
       grid.getChildren().add(Text);
       }
       }
   });
         Delete.setOnAction(em ->{
             admin.deletCoaches((int)Integer.parseInt(SearchField.getText()));
             AlterBox.ComfirmationBox("Done", "Deleted");
           });
        
       
       HBox h = new HBox();
       h.getChildren().addAll(Save,Delete);
       h.setPadding(new Insets(10,10,10,10));
       h.setSpacing(35);
       GridPane.setConstraints(h, 1, 8);
       
      
       
        grid.getChildren().addAll(Name,Id,UserName,Password,Age,Phone,Salary,NameField,IdField,UserNameField,PasswordField,AgeField,PhoneField,SalaryField,h,searchBox);
        
       grid.setAlignment(Pos.CENTER);
       
       Label m = new Label("Coach's Data");
       m.setFont(Font.font ("Verdana", 60));
       
       BorderPane border = new BorderPane();
       border.setCenter(grid);
       border.setTop(m);
       BorderPane.setAlignment(m, Pos.CENTER);
       
       
        Scene scene = new Scene(border,700,650);
        window.setScene(scene);
        window.show();
    
}
 //---------------------------------END----------------------------------
    
    
}
