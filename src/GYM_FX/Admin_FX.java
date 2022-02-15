/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GYM_FX;
import Frames.AdminCoachData;
import Frames.AdminMemberData;
import Frames.AlterBox;
import gym.Member;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;


/**
 *
 * @author Mohamed
 */
public class Admin_FX {
    
    public static void Display() {
        Stage window = new Stage();
        window.setTitle("Admin");
        
        BorderPane  border = new BorderPane();
        
        Menu menu = new Menu("File");
        
        MenuItem Report = new MenuItem("Report");
        MenuItem Exit = new MenuItem("Exit");
       
        Report.setOnAction(e->{
        Report();
        });
        Exit.setOnAction(e->{
        window.close();
        });

        SeparatorMenuItem m = new SeparatorMenuItem();
        SeparatorMenuItem n = new SeparatorMenuItem();
        menu.getItems().addAll(m,Report,n,Exit);
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(menu);
        
        //Coach Menu
        Menu CoachMenu = new Menu("Coach");
        MenuItem Add1 =new MenuItem ("Add");
        MenuItem Update1 =new MenuItem ("Update&Delete");
        MenuItem List1 =new MenuItem ("List");
        //Set Action 
         Add1.setOnAction(e ->{
         AdminCoachData.Add();
        }
        );      
         Update1.setOnAction(e ->{
         AdminCoachData.Update();
        }
        );
        List1.setOnAction(e ->{
         AdminCoachData.Display();
        
        }
        );
        //Put Items
        SeparatorMenuItem a = new SeparatorMenuItem();
        SeparatorMenuItem b = new SeparatorMenuItem();
        CoachMenu.getItems().addAll(Add1,m,Update1,n,List1);



        Menu MemberMenu = new Menu("Member");
        MenuItem Add2 =new MenuItem ("Add");
        MenuItem Update2 =new MenuItem ("Update&Delete");
        MenuItem List2 =new MenuItem ("List");
        
        SeparatorMenuItem c = new SeparatorMenuItem();
        SeparatorMenuItem d = new SeparatorMenuItem();
        MemberMenu.getItems().addAll(Add2,c,Update2,d,List2);
        
        //Set Action 
         Add2.setOnAction(e ->{
         AdminMemberData.Add();
         
        }
        );      
         Update2.setOnAction(e ->{
         AdminMemberData.Update();
         }
        );
        List2.setOnAction(e ->{
        AdminMemberData.Display();
        
        }
        );
        
        
       
        
        MenuBar menuBar1 =new MenuBar();
        menuBar1.getMenus().addAll(menu,CoachMenu,MemberMenu);
        border.setTop(menuBar1);
        
        Scene scene = new Scene(border,700,650);
        window.setScene(scene);
        window.show();
    }
    
        public static void Report()
    {
        GridPane grid = new GridPane();
        Stage window = new Stage();
       
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(8);
        
        Label id = new Label("Member Id");
        GridPane.setConstraints(id, 0, 0);
        
        
        TextField Id = new TextField();
        Id.setPromptText("Member Id");
        GridPane.setConstraints(Id, 1, 0);
        Id.setMinWidth(100);
        
        Label Massage = new Label("Report");
        GridPane.setConstraints(Massage,0,1);
        
        TextField report = new TextField();
        report.setPromptText("Type a massage");
        GridPane.setConstraints(report, 1, 1);
        report.setMinSize(450, 200);
        
        
        
        Button Send = new Button("Send");
        GridPane.setConstraints(Send, 1, 3);
        
        Send.setOnAction(e -> {
            
         Member m = new Member() ;
         Member x = new Member() ; 
         x= m.search((int)Integer.parseInt(Id.getText()));      
         x.setReport(report.getText());
         m.updateMember(x.getId(), x);
        });
        grid.getChildren().addAll(id,Id,Massage,report,Send);
        Scene scene = new Scene(grid, 600, 300);
        
        
        
         window.setScene(scene);
         window.setTitle("Report");
         window.show();
         
        
    
        
       
    }
    
}
