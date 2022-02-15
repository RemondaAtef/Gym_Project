/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import gym.Member;
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
import static javax.swing.text.StyleConstants.Italic;

/**
 *
 * @author Eng Mohammed
 */
public class SEARCH {
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
    grid.add(table, 0, 0);
   
   
   table.getColumns().addAll(nameColumn,idColumn,usernameColumn,passwordColumn,ageColumn,phoneColumn,EndDateColumn,Day1Column,Day2Column,CostColumn,hisCoachColumn);
   GridPane.setConstraints(table, 0, 0);
        Scene scene = new Scene(grid,700,650);
        window.setScene(scene);
        window.show();
    }
    
}

