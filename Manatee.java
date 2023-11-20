/**
 * Author: Audrey Johnson, Jasmin Singh, Evan Berlin, Megdalia Bromhal, and Riley Simpson
 * Date: 17Nov23
 * Section: CSC 331
 * Description: This is the file that runs the Manatee Project.
 */

package com.example.manateefinal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * Purpose: This class is the controller for the Manatee Project. It contains the methods for the
 * buttons and the randomized button positions. The showImagePopup method is used to display the
 * image of the manatee when the button is clicked. The randomizedButtonPosition method is used to
 * randomize the position of the buttons on the screen. The initialize method is used to call the
 * randomizedButtonPosition method and the showImagePopup method.
 * Parameters: None
 * Return: None
 */
public class Manatee extends Application{
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Manatee.fxml"));

        Scene scene = new Scene(root);
        stage.setTitle("Manatee Tracking Program"); // Displayed in window's title bar
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {launch(args);}
}
