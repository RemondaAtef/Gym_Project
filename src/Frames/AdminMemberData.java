/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import gym.Admin;
import gym.Member;
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
public class AdminMemberData {
    
    public static void Add(){
      Stage primaryStage = new Stage();
      Admin a =new Admin();

        TableView<Member> table = new TableView<>();
        
        TableColumn<Member ,String> Name =new TableColumn<>("Name");
        Name.setMinWidth(100);
        Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        
        
        TableColumn<Member ,Integer> Id =new TableColumn<>("Id");
        Id.setMinWidth(100);
        Id.setCellValueFactory(new PropertyValueFactory<>("Id"));
        
        
        TableColumn<Member ,String> UserName =new TableColumn<>("UserName");
        UserName.setMinWidth(120);
        UserName.setCellValueFactory(new PropertyValueFactory<>("UserName"));
        
        
        TableColumn<Member ,String> Password =new TableColumn<>("Password");
        Password.setMinWidth(100);
        Password.setCellValueFactory(new PropertyValueFactory<>("Password"));
         
        
        TableColumn<Member ,Integer> Age =new TableColumn<>("Age");
        Age.setMinWidth(100);
        Age.setCellValueFactory(new PropertyValueFactory<>("Age"));
        
          
        TableColumn<Member ,String> phone =new TableColumn<>("Phone");
        phone.setMinWidth(100);
        phone.setCellValueFactory(new PropertyValueFactory<>("Phone"));
        
        TableColumn<Member ,String> EndDate =new TableColumn<>("EndDate");
        EndDate.setMinWidth(100);
        EndDate.setCellValueFactory(new PropertyValueFactory<>("EndDate"));
       
        TableColumn<Member ,String> Day1 =new TableColumn<>("Day1");
        Day1.setMinWidth(100);
        Day1.setCellValueFactory(new PropertyValueFactory<>("Day1"));
        
        TableColumn<Member ,String> Day2 =new TableColumn<>("Day2");
        Day2.setMinWidth(100);
        Day2.setCellValueFactory(new PropertyValueFactory<>("Day2"));
        
        TableColumn<Member ,Double> Cost =new TableColumn<>("Cost");
        Cost.setMinWidth(100);
        Cost.setCellValueFactory(new PropertyValueFactory<>("Cost"));
        
        TableColumn<Member,Integer> hisCoach = new TableColumn<>("HisCoach");
        hisCoach.setMinWidth(100);
        hisCoach.setCellValueFactory(new PropertyValueFactory<>("HisCoach"));
        
        TextField nameField = new TextField();
        nameField.setPromptText("Name");
        nameField.setMinWidth(90);
        
        TextField idField = new TextField();
        idField.setPromptText("Id");
        idField.setMinWidth(90);
        
        TextField userNameField = new TextField();
        userNameField.setPromptText("UserName");
        userNameField.setMinWidth(90);
        
        TextField passwordField = new TextField();
        passwordField.setPromptText("Password");
        passwordField.setMinWidth(90);
        
        TextField ageField = new TextField();
        ageField.setPromptText("Age");
        ageField.setMinWidth(90);
        
        TextField phoneField = new TextField();
        phoneField.setPromptText("Phone");
        phoneField.setMinWidth(90);
        
        TextField endDateField = new TextField();
        endDateField.setPromptText("EndDate");
        endDateField.setMinWidth(90);
        
        TextField day1Field = new TextField();
        day1Field.setPromptText("Day1");
        day1Field.setMinWidth(90);
        
        TextField day2Field = new TextField();
        day2Field.setPromptText("Day2");
        day2Field.setMinWidth(90);
        
        TextField costField = new TextField();
        costField.setPromptText("Cost");
        costField.setMinWidth(90);
        
        TextField yourCoachField = new TextField();
        yourCoachField.setPromptText("YourCoach");
        yourCoachField.setMinWidth(90);
        
        Button Add = new Button("Add");
        Add.setMinWidth(50);
        Add.setOnAction(e -> {
     Member member =new Member();
     
     member.setName(nameField.getText());
     member.setId((int)Integer.parseInt(idField.getText()));
     member.setUserName(userNameField.getText());
     member.setPassword(passwordField.getText());
     member.setAge((int)Integer.parseInt(ageField.getText()));
     member.setPhone(phoneField.getText());
     member.setEndDate(endDateField.getText());
     member.setDay1(day1Field.getText());
     member.setDay2(day2Field.getText());
     member.setCost((double)Double.parseDouble(costField.getText()));
     member.setHisCoach((int)Integer.parseInt(yourCoachField.getText()));

     table.getItems().add(member);//s,i.s
      a.addMember(member);
        
      
      nameField.clear(); idField.clear(); userNameField.clear(); passwordField.clear();
      ageField.clear(); phoneField.clear(); endDateField.clear(); 
      day1Field.clear(); day2Field.clear(); costField.clear(); yourCoachField.clear();
      
        });
      
        
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10,20,10,20));
        hBox.setSpacing(5);
        hBox.getChildren().addAll(nameField,idField,userNameField,passwordField,ageField,phoneField,
                endDateField,day1Field,day2Field,costField,yourCoachField,Add);
        
        ArrayList<Member> Members = new ArrayList<>();
        Member x = new Member();
        Members = x.list();
        ObservableList<Member> members = FXCollections.observableArrayList(Members);
        

        table.setItems(members);
        
        table.getColumns().addAll(Name,Id,UserName,Password,Age,phone,EndDate,Day1,Day2,Cost,hisCoach);
        
        VBox vBox = new VBox();
        vBox.getChildren().addAll(table,hBox);
        

     
        
        Scene scene = new Scene(vBox,1122,400);
        
        primaryStage.setTitle("Add New Member");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    
 //--------------------------------------------------------------------------------------------------------------------------
    
    
    
    
    public static void Display(){
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
    window.setTitle("Members");
    window.show();
     
  
}
     public static void Update(){
   Stage window = new Stage();
   window.setTitle("Update Member");
   
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
        
        Button Save = new Button("Save");
        Button Delete = new Button("Delete");
        Button Search = new Button("Search");
        Search.setOnAction(e->{
              if("".equals(SearchField.getText())){
                
            AlterBox.ErrorBox("Error", "Wrong Id");
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

        
        Label Text = new Label();
            Text.setFont(Font.font(30));
       GridPane.setConstraints(Text, 0, 12);
       grid.getChildren().add(Text);
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
                       AlterBox.ErrorBox("Error","Sorry,Put Your Data..");

         
       }
         else{
               
                   Member member = new Member(NameField.getText(),(int)Integer.parseInt(IdField.getText()),
         UserNameField.getText(),Password.getText(),(int)Integer.parseInt(AgeField.getText()),
         PhoneField.getText(),EndDate.getText(), (double)Double.parseDouble(CostField.getText()),
         Day1Field.getText(),Day2Field.getText(),(int)Integer.parseInt(YourCoachField.getText())
                 );
             admin.updateMember((int)Integer.parseInt(SearchField.getText()),member);
             
        
        
        NameField.clear();  IdField.clear();  UserNameField.clear();
            PasswordField.clear(); AgeField.clear(); 
            PhoneField.clear(); EndDateField.clear(); CostField.clear();
            Day1Field.clear(); Day2Field.clear();  YourCoachField.clear();
            
       AlterBox.ComfirmationBox("Done","Updated Successfully..");
               
         }
       }
       
       
   });
         Delete.setOnAction(em ->{
             admin.deleteMember((int)Integer.parseInt(SearchField.getText()));
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
       
       Label m = new Label("Member's Data");
       m.setFont(Font.font ("Verdana", 60));
       
       BorderPane border = new BorderPane();
       border.setCenter(grid);
       border.setTop(m);
       BorderPane.setAlignment(m, Pos.CENTER);
       
       
        Scene scene = new Scene(border,700,650);
        window.setScene(scene);
        window.show();
    }
         
}