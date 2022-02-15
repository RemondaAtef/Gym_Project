/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GYM_FX;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import Frames.MemberData;
import gym.Member;
import gym.Plan;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;


/**
 *
 * @author Mohamed
 */
public class Member_FX {
    
    public static void Display() {
        Stage window = new Stage();
        window.setTitle("Member");
        
        BorderPane  border = new BorderPane();
        
        Menu menu = new Menu("File");
        
        MenuItem Msg = new MenuItem("Msg");
        MenuItem Report = new MenuItem("Report");
        MenuItem Exit = new MenuItem("Exit");
        Msg.setOnAction(e ->{
        MemberData.Msg();
        });
        Report.setOnAction(e->{
        MemberData.Report();
        });
        Exit.setOnAction(e->{
        window.close();
        });
        SeparatorMenuItem m = new SeparatorMenuItem();
        SeparatorMenuItem n = new SeparatorMenuItem();
        menu.getItems().addAll(Msg,m,Report,n,Exit);
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(menu);
        
        Button btn = new Button("Show/Update"); 
        btn.setOnAction(e ->{
        MemberData.Update();
        });
        
        // Member's Plan
        
        GridPane grid = new GridPane();
        grid.setHgap(50);
        grid.setVgap(10);
        grid.setPadding(new Insets(10,10,10,10));
        
        Label Text = new Label("Your Plan :");
        Text.setFont(Font.font(30));
        Text.setPadding(new Insets(30,10,10,30));
        GridPane.setConstraints(Text, 1, 1);
        
        Label Id = new Label("Put Your ID");
        GridPane.setConstraints(Id, 0, 0);
        
        TextField IdField = new TextField();
        GridPane.setConstraints(IdField, 1, 0);
        
        
        Button Search = new Button("Search");
        GridPane.setConstraints(Search, 2, 0);
        
        Label Plan = new Label();
        Plan.setFont(Font.font(15));
        GridPane.setConstraints(Plan, 1, 3);
        
        Label Error = new Label();
        GridPane.setConstraints(Error, 1, 5);
        
        Search.setOnAction(e ->{
            if("".equals(IdField.getText())){
            Error.setText("Please Put Your ID Correctly..");
            
            }
            else{
        Member member = new Member();
        Member x = new Member();
        
        x = member.search((int) Integer.parseInt(IdField.getText()));
        String s=  x.getDays();

        
        Plan.setText(s);
            }
        });

        
        grid.getChildren().addAll(Text,Plan,IdField,Search,Id,Error);
        
        BorderPane.setAlignment(btn, Pos.CENTER);
        BorderPane.setMargin(btn,new Insets(10,10,30,10));
        btn.setPadding(new Insets(20,20,20,20));
        
        border.setBottom(btn);
        border.setCenter(grid);
        border.setTop(menuBar);
        
        Scene scene = new Scene(border,700,650);
        window.setScene(scene);
        window.show();
    }
}
