/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

/**
 *
 * @author hassan zidan
 */
import javafx.scene.control.Alert;
public class AlterBox {
    public static void ErrorBox(String Title , String Massage)
    {
     
        Alert alter = new Alert(Alert.AlertType.ERROR);
        alter.setTitle(Title);
        alter.setContentText(Massage);
        alter.setHeaderText(null);
        alter.showAndWait();

        
    }
    
      public static void ComfirmationBox(String Title , String Massage)
    {
     
        Alert alter = new Alert(Alert.AlertType.CONFIRMATION);
        alter.setTitle(Title);
        alter.setContentText(Massage);
        alter.setHeaderText(null);
        alter.showAndWait();

        
    }
    
}
