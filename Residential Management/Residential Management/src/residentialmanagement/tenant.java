/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package residentialmanagement;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.ImageIcon;
import static residentialmanagement.announcements.announcementsStage;
import static residentialmanagement.complains.complainsStage;
import static residentialmanagement.compliments.complimentsStage;
import static residentialmanagement.ownerlogin.ownerloginStage;
import static residentialmanagement.payments.paymentsStage;
import static residentialmanagement.registerowner.registerownerStage;
import static residentialmanagement.registertenant.registertenantStage;

/**
 *
 * @author prime
 */
public class tenant extends Application {
    static Stage  tenantStage = new Stage();
     @Override
public void start(Stage tenantStage) {
       
         Text heading1 = new Text("ADD A COMPLAINT:");
        heading1.setFill(Color.BLACK);
        heading1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        
        Text heading2 = new Text("ADD A COMPLIMENT:");
        heading2.setFill(Color.BLACK);
        heading2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
       
        Text heading3 = new Text("MAKE PAYMENTS:");
        heading3.setFill(Color.BLACK);
        heading3.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
  
        Button c_btn2 = new Button("COMPLAINS");
        c_btn2.setStyle("-fx-background-color: SILVER; -fx-border-color: brown;  -fx-text-fill: black; -fx-border-radius: 5;");
        c_btn2.setCursor(Cursor.HAND);
        Button c_btn1 = new Button("COMPLIMENTS");
        c_btn1.setStyle("-fx-background-color: SILVER; -fx-border-color: brown;  -fx-text-fill: black; -fx-border-radius: 5;");
        c_btn1.setCursor(Cursor.HAND);
        Button add_btn = new Button("PAYMENTS");
        add_btn.setStyle("-fx-background-color: SILVER; -fx-border-color: brown;  -fx-text-fill: black; -fx-border-radius: 5;");
        add_btn.setCursor(Cursor.HAND);
       
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(600,400);
        gridPane.setVgap(20);
        gridPane.setHgap(20);
        gridPane.setAlignment(Pos.CENTER);
       
        gridPane.add(heading1,1, 1);
        gridPane.add(heading2,1, 4);
        gridPane.add(heading3,1, 7);
        gridPane.add(c_btn2,2, 1);
        gridPane.add(c_btn1,2, 4);
        gridPane.add(add_btn,2,7);
        
            c_btn2.setOnMouseClicked((new EventHandler<MouseEvent>(){
                public void handle(MouseEvent event){
                    complains a = new complains();
                    a.start(complainsStage);
                }
               }));
            
            c_btn1.setOnMouseClicked((new EventHandler<MouseEvent>(){
                public void handle(MouseEvent event){
                    compliments a = new compliments();
                    a.start(complimentsStage);
                }
               }));
            
             add_btn.setOnMouseClicked((new EventHandler<MouseEvent>(){
                public void handle(MouseEvent event){
                    payments a = new payments();
                    a.start(paymentsStage);
                }
               }));
       
        tenantStage.setTitle("TENANT INTERFACE");
       
        Scene my_scene=new Scene(gridPane); //This is our scene
        
         gridPane.setStyle("-fx-background-image:url('https://i.pinimg.com/474x/73/21/49/7321495cd2660054405b9989dc2cc779.jpg'); -fx-background-repeat: no-repeat; -fx-background-size: 700 500; -fx-background-position: center center;");
     
        tenantStage.setScene(my_scene);  
       
        tenantStage.show();

    /**
     * @param args the command line arguments
     */
   
   
   
   
}
 public static void main(String args[]){
      launch(args);
   }
}

