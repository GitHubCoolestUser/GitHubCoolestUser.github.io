import javafx.scene.control.*;
import javafx.scene.text.Font;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color; 

/**
 * Use this template to create Apps with Graphical User Interfaces.
 * 
 * @author Ben Callaghan
 */
public class FXGUITemplate extends Application {

    // TODO: Instance Variables for View Components and Model
    GraphicsContext gc;
    TextField tf;
    Button btn;
    
    
    // TODO: Private Event Handlers and Helper Methods
    public void changeColour(ActionEvent e){
        String newColor = tf.getText();
        
        if(!newColor.isEmpty() || !newColor.isBlank()){
            gc.setFill( Color.web(newColor));
            gc.fillRect(0, 0, 200, 200);
        } else {
            gc.setFill( Color.RED);
            gc.fillRect(0, 0, 200, 200);
        }
    }
    
    
    /**
     * This is where you create your components and the model and add event
     * handlers.
     *
     * @param stage The main stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();
        Scene scene = new Scene(root, 200, 300); // set the size here
        stage.setTitle("Colour app"); // set the window title here
        stage.setScene(scene);
        // TODO: Add your GUI-building code here

        // 1. Create the model
        Canvas paper = new Canvas(200, 200);
        gc = paper.getGraphicsContext2D();
        
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0 , 200, 200);
        
        
        // 2. Create the GUI components
        tf = new TextField("grey");
        btn = new Button("change Colour");
        
        // 3. Add components to the root
        root.getChildren().addAll(paper, tf, btn);
        
        // 4. Configure the components (colors, fonts, size, location)
        tf.relocate(0, 201);
        tf.setPrefHeight(50);
        tf.setPrefWidth(200);
        btn.relocate(0,251);
        btn.setPrefHeight(50);
        btn.setPrefWidth(200);
        
        
        // 5. Add Event Handlers and do final setup
        btn.setOnAction(this :: changeColour);
        
        // 6. Show the stage
        stage.show();
    }

    /**
     * Make no changes here.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        launch(args);
    }
}