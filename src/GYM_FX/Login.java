/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GYM_FX;


import Frames.AlterBox;
import gym.Admin;
import gym.Coach;
import gym.Member;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.*;


/**
 *
 * @author Mohamed
 */
public  class Login extends Application {
    
    Stage window;
   
    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        window = primaryStage;
       
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(8);
        
        Label labe11 = new Label("User Name");
        GridPane.setConstraints(labe11, 0, 0);
        
        TextField username = new TextField();
        username.setPromptText("Your Username");
        GridPane.setConstraints(username, 1, 0);
        
        Label label2 = new Label("Password");
        GridPane.setConstraints(label2, 0, 1);
        
        PasswordField password = new PasswordField();
        password.setPromptText("Your Password");
        GridPane.setConstraints(password, 1, 1);


        Button loginButton = new Button("Login");
        GridPane.setConstraints(loginButton, 1, 4);
        
        Label Text = new Label();
        GridPane.setConstraints(Text, 1, 5);
        loginButton.setOnAction(e -> {
            
            Member member = new Member();
            Coach coach = new Coach();
            Admin admin = new Admin();
            if(member.login(username.getText(), password.getText())){
                
            Member_FX.Display();
            window.close();
            }
            else if(coach.login(username.getText(), password.getText())){
            Coach_FX.Display();
            window.close();
            } 
            else if(admin.login(username.getText(), password.getText())){
            Admin_FX.Display();
            window.close();
            }
            else {
               AlterBox.ErrorBox("Error", "The user name or password  that you've entered is incorrect. ");
            }
        
        });
        
        grid.getChildren().addAll(labe11,username,label2,password,loginButton);
        Scene scene = new Scene(grid, 300, 170);
        window.setTitle("Login");
        window.setScene(scene);
        window.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}