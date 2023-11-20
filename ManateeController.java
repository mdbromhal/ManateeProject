/**
 * Author: Audrey Johnson, Jasmin Singh, Evan Berlin, Megdalia Bromhal, and Riley Simpson
 * Date: 17Nov23
 * Section: CSC 331
 * Description: This is the controller for the Manatee Project. It contains the methods for the
 * buttons and the randomized button positions. The showImagePopup method is used to display the
 * image of the manatee when the button is clicked. The randomizedButtonPosition method is used to
 * randomize the position of the buttons on the screen. The initialize method is used to call the
 * randomizedButtonPosition method and the showImagePopup method.
 */
package com.example.manateefinal;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import java.util.Random;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
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
public class ManateeController {

    // Initialize radio and regular button objects
    @FXML
    private RadioButton loc1button, loc2button, loc3button;

    @FXML
    private Button helpButton;



    /**
     * Purpose: This method is used to randomize the position of the buttons on the screen.
     * Parameters: RadioButton button
     * Return: None
     */
   private void randomizedButtonPosition(RadioButton button){
       // Getting a random number
        Random rand = new Random();

        // Getting a random number for x and y within the range of the map's dimensions
        double x = rand.nextDouble() * 500;
        double y = rand.nextDouble() * 330;

        // Setting the x and y coordinate (connects to fxml) with new random coordinates
        button.setLayoutX(x);
        button.setLayoutY(y);
    }

    /**
     * Purpose: This method is used to display the image of the manatee when the button is clicked.
     * param: imagePath
     * Return: None
     *
     */
    private void showImagePopup(String imagePath) {

        // Get the image from the resources folder
        Image image = new Image(getClass().getResourceAsStream(imagePath));

        // Error handling in case can't find image
        if (image.isError()) {
            System.out.println("Failed to load image: " + imagePath);
            return;
        }

        // Getting image view of image
        ImageView imageView = new ImageView(image);

        // Preserve ratio
        imageView.setPreserveRatio(true);

        // Set height of image
        imageView.setFitHeight(400);

        // Set layout of image with stack pane
        StackPane layout = new StackPane(imageView);

        // Setting new scene object and assigning with layout, and setting stage object
        Scene scene = new Scene(layout);
        Stage popupStage = new Stage();

        // Setting scene to pop up with stage
        popupStage.setScene(scene);

        // Hide the popup stage when it loses focus
        popupStage.focusedProperty().addListener((obs, wasFocused, isNowFocused) -> {
            if (!isNowFocused) {
                popupStage.hide();
            }
        });

        // Show the stage with the image and layout
        popupStage.show();
    }
    /**
        * Purpose: This method is used to call the randomizedButtonPosition method and the
        * showImagePopup method.
        * Parameters: None
     */
    @FXML
    private void initialize() {

        // Find random coordinates for the buttons
        randomizedButtonPosition(loc1button);
        // When event, pop up image according to button
        loc1button.setOnAction(event -> showImagePopup("Manatee_1 info.jpg")); // this is the name of the image

        randomizedButtonPosition(loc2button);
        loc2button.setOnAction(event -> showImagePopup("Manatee_2 info.jpg"));

        randomizedButtonPosition(loc3button);
        loc3button.setOnAction(event -> showImagePopup("Manatee_3 info.jpg"));

        helpButton.setOnAction(event -> showImagePopup("instructions copy.png"));
    }
}

