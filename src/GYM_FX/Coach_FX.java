/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GYM_FX;

import Frames.CoachData;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Mohamed
 */
public class Coach_FX {
            public static void Display(){
   Stage window = new Stage();
        
        GridPane grid = new GridPane();
        grid.setHgap(50);
        grid.setVgap(10);
        grid.setPadding(new Insets(10,10,10,30));
        
        
         Button Update = new Button("Update");
         Update.setOnAction(e->{
             window.close();
             CoachData.Update();
         });
         Update.setPadding(new Insets(15,15,15,15));
         
         
         Button List = new Button("List");
          List.setOnAction(e->{
        CoachData.List();
         
         });
        List.setPadding(new Insets(15,21,15,21));
         
         
         Button Close = new Button("Close");
         Close.setPadding(new Insets(15,15,15,15));
          Close.setOnAction(e->{
         window.close();
         });
          
          
         VBox v=new VBox();
         v.getChildren().addAll(Update,List,Close);
         v.setPadding(new Insets(10,10,10,10));
         v.setSpacing(35);
        
     
        
       Label a = new Label("Coach’s Data");
       a.setFont(Font.font(38));
       
         Menu menu = new Menu("File");
        
        MenuItem Msg = new MenuItem("Msg");
        MenuItem Plan = new MenuItem("Plan");
        MenuItem Exit = new MenuItem("Exit");
        Msg.setOnAction(e ->{
        CoachData.Msg();
        });
        Plan.setOnAction(e->{
            window.close();
            CoachData.Plan();
        });
        Exit.setOnAction(e->{
        window.close();
        });
        SeparatorMenuItem m = new SeparatorMenuItem();
        SeparatorMenuItem n = new SeparatorMenuItem();
        menu.getItems().addAll(Msg,m,Plan,n,Exit);
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(menu);
        
        
        grid.getChildren().add(v);
          grid.setAlignment(Pos.CENTER); 
       
       
       BorderPane border = new BorderPane();
       border.setCenter(grid);
       border.setTop(a);
       border.setTop(menuBar);
         
         
       BorderPane.setAlignment(a, Pos.CENTER);
       
        Scene scene = new Scene(border,700,650);
        window.setScene(scene);
        window.setTitle("Coach");
        window.show();
         
         
         
     }
        
    }
