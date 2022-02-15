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
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Eng Mohammed
 */
public class msg {
     public static void Display(){
   Stage window = new Stage();
        
        GridPane grid = new GridPane();
        grid.setHgap(25);
        grid.setVgap(25);
        grid.setPadding(new Insets(30,30,30,30));
        
        Label Id=new Label("Member Id");
        GridPane.setConstraints(Id, 0, 0);
         Id.setFont(Font.font(15));
         TextField UserId = new TextField();
        UserId.setPromptText("Member Id Please");
        UserId.setMinSize(15, 50);
        GridPane.setConstraints(UserId, 0, 1);
        
        TextField CoachMessage = new TextField();
        CoachMessage.setPromptText("Your Message Please");
        CoachMessage.setMinSize(15, 50);
        GridPane.setConstraints(CoachMessage, 0, 2);
        
        
        Button Send=new Button("Send");
        Send.setPadding(new Insets(15,15,15,15));
      Send.setOnAction(e->{
        
        Member m = new Member();
    Member x = new Member();
    m = x.search((int) Integer.parseInt(Id.getText()));
     
            x.setMsg(CoachMessage.getText() );
             Label thanks = new Label("Thank You");
            thanks.setFont(Font.font(30));
       GridPane.setConstraints(thanks, 0, 12);
       grid.getChildren().add(thanks);
      });

         /* Button Ok=new Button("Ok");
        Ok.setPadding(new Insets(15,15,15,15));
        Ok.setOnAction(e->{
  
        });*/

        
         Button Home=new Button("HOME");
        Home.setOnAction(e->{
         window.close();
         HOME.Display();
        });
        Home.setPadding(new Insets(15,15,15,15));
        GridPane.setConstraints(Home, 4,7);
        
        
         VBox  searchBox = new VBox();
        searchBox.getChildren().addAll(CoachMessage,Send,Id,UserId);
        searchBox.setPadding(new Insets(10,10,10,10));
        searchBox.setSpacing(35);
        GridPane.setConstraints(searchBox, 0, 0);
        
        grid.getChildren().addAll(searchBox,Home);
         Label l = new Label("Coaches’ Massege");
         l.setFont(Font.font(30));
       BorderPane.setAlignment(l, Pos.CENTER);
       BorderPane border = new BorderPane();
       border.setCenter(grid);
       border.setTop(l);
       
        Scene scene = new Scene(border,700,650);
        window.setScene(scene);
        window.show();
             
     }   
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
        TextField SearchField = new TextField();
        
      
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
           Plan plan = new Plan((int)Integer.parseInt(IdField.getText()),SaturdayField.getText(),SundayField.getText(),
         MondayField.getText(),TuesdayField.getText(),WedensdayField.getText(),
         ThursdayField.getText());
           
            Plan K=new Plan();         
            K.addPlan();
      // admin.addMember(member);
        Label thanks = new Label("Thank You");
            thanks.setFont(Font.font(30));
       GridPane.setConstraints(thanks, 0, 12);
       grid.getChildren().add(thanks);
        });
         
         
          Button Home=new Button("HOME");
        Home.setOnAction(e->{
         window.close();
         HOME.Display();
        
        });
        GridPane.setConstraints(Home, 2, 9);
         Home.setPadding(new Insets(15,15,15,15));
         
          Button Search=new Button("Search");
        Search.setOnAction(e->{
            Coach m = new Coach();
            Coach x = new Coach();
            x= m.search((int)Integer.parseInt(SearchField.getText()));
         Label thanks = new Label("Existu");
            thanks.setFont(Font.font(30));
       GridPane.setConstraints(thanks, 0, 12);
       grid.getChildren().add(thanks);
        });
        
        
          HBox  searchBox = new HBox();
        searchBox.getChildren().addAll(MemberId,SearchField,Search);
        searchBox.setPadding(new Insets(10,10,10,10));
        searchBox.setSpacing(35);
        GridPane.setConstraints(searchBox, 0, 0);
        
        
         grid.getChildren().addAll(YourId,Saturday,Sunday,Monday,Tuesday,Wedensday,Thursday,
                IdField,SaturdayField,SundayField,MondayField,TuesdayField,WedensdayField,ThursdayField
                ,searchBox,Save,Home);
        
       grid.setAlignment(Pos.CENTER);
       
       Label m = new Label("Member’s Plan");
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

