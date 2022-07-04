/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package residentialmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author omben
 */
public class payments extends Application {
    
    static Stage  paymentsStage = new Stage();
   
    @Override
    public void start(Stage paymentsStage) {
           Label rent_lbl = new Label("Pay RENT Here:");
           Label electricity_lbl = new Label("Pay Electric Bill Here:");
           Label water_lbl = new Label("Pay Water Bill Here:");
           TextField rent_txt = new TextField();
           TextField electricity_txt = new TextField();
           TextField water_txt = new TextField();
           
           Button submit_btn = new Button("Submit");
           submit_btn.setStyle("-fx-background-color: SILVER; -fx-border-color: brown;  -fx-text-fill: black; -fx-border-radius: 5;");
           submit_btn.setCursor(Cursor.HAND);
           
           GridPane gridPane = new GridPane();
           gridPane.setMinSize(600,400);
           gridPane.setVgap(10);
           gridPane.setHgap(10);
           gridPane.setAlignment(Pos.CENTER);
           
           gridPane.add(rent_lbl, 1,1);
           gridPane.add(rent_txt, 2,1);
           gridPane.add(electricity_lbl, 1, 2);
           gridPane.add(electricity_txt, 2,2);
           gridPane.add(water_lbl, 1, 3);
           gridPane.add(water_txt, 2,3);
           
           gridPane.add(submit_btn, 1,4);
           
        paymentsStage.setTitle("PAYMENTS PAGE");
       
        Scene my_scene=new Scene(gridPane); //This is our scene
        
        gridPane.setStyle("-fx-background-image:url('https://i.pinimg.com/474x/73/21/49/7321495cd2660054405b9989dc2cc779.jpg'); -fx-background-repeat: no-repeat; -fx-background-size: 700 500; -fx-background-position: center center;");
     
        paymentsStage.setScene(my_scene);  
       
        paymentsStage.show();
           
           submit_btn.setOnMouseClicked((new EventHandler<MouseEvent>() {
         @Override
         public void handle(MouseEvent event) {
           
             String username = rent_txt.getText();
             String password = electricity_txt.getText();
             
             
             
             try
             {
                 //Step One - Register the driver
                Class.forName("com.mysql.cj.jdbc.Driver");
               
                //Step Two - Creating the connection
                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/exercise","root","kipese@!!!");
               
                //Step Three - Create the statement object
                 java.sql.Statement stmt = con.createStatement();
               
                //Step Four - Execute your queries
                String query = "SELECT * FROM exercise.user_details Where Username = '"+username+"' AND Password = '"+password+"' ";
                ResultSet rs = stmt.executeQuery(query);
               
                if(rs.next())
                {
                    //You can replace this code with ANY code to be executed after a successfull login
                    Alert al = new Alert(Alert.AlertType.CONFIRMATION);
                    al.setContentText("Successful Login");
                    al.show();
                    rent_txt.setText("");
                    electricity_txt.setText("");
                }
               
                else
                {
                    Alert al = new Alert(Alert.AlertType.WARNING);
                    al.setContentText("Invalid Credentials");
                    al.show();
                 
                }
               
                //Step five - Closing the connection
                con.close();
             
             }
            catch(Exception ee){System.out.println(ee);System.out.println("Connection error");}
            {
               
            }
         }
        }));

                   
           
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
