import javafx.scene.control.*;
import javafx.scene.text.Font;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;

import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.geometry.Pos;



/**
 * Use this template to create Apps with Graphical User Interfaces.
 * 
 * @author BEN CALLAGHAN 12/5/2023 (V1.00)
 */
public class CounterAppGUI extends Application {

    private Counter ballCounter, strikeCounter, nextCounter, outCounter;
    private Counter[] counters =  {ballCounter, strikeCounter, nextCounter, outCounter};
    private Label l1, l2;
    private Button ball, strike, next_Batter, reset;
    private TextField f1;
    private TextField f2;

    
    /** 
     *
     * The pressHandler handleds mouse clickes on the outs label and adds outs by 1
     *
     * @param me tells the class witch part of the screen was clicked
     */
    private void pressHandler(MouseEvent me){
            if(strikeCounter.getCount() != 3){
                outCounter.increment();
                l2.setText("Outs: " + outCounter.toString());
                return;
            }
    }
    
    
    
    /** 
     *
     * BallBtn is where the actionevent code runs for when you prese the next ball button
     *
     * @param e is which buton pressed it. 
     */
    public void ballBtn(ActionEvent e){ 
        if(strikeCounter.getCount() != 3){
            if(ballCounter.getCount() >= 4){
                return;
            } else {
                String str;
    
                ballCounter.increment();
    
                str = String.valueOf(ballCounter);
    
                textToScreen(ballCounter, strikeCounter, nextCounter, outCounter);
    
                f1.setText(str);
            }
        }
    }

    
    
    /** 
     *
     * Text to screen uses counters and prints them onto the termial. it also makings the out score appear and disapper.
     *
     * @param c1  the counter one. 
     * @param c2  the counter two. 
     * @param c3  the counter three. 
     * @param c4  the counter four. 
     */
    public void textToScreen(Counter c1, Counter c2, Counter c3, Counter c4){ 

        String str1, str2, str3, str4;

        str1 = String.valueOf(c1);
        str2 = String.valueOf(c2);
        str3 = String.valueOf(c3);
        str4 = String.valueOf(c4);

        if(c4.getCount() > 0){
            System.out.println(str1 + " " + str2 + " " + str3 + " Outs: " + str4);
        } else {
            System.out.println(str1 + " " + str2 + " " + str3);
        }
    }    

    
    
    /** 
     * @OverLoaded method
     * Text to screen uses counters and prints them onto the termial. it also makings the out score appear and disapper.
     * 
     */
    public void textToScreen(){ 

        String temp = "";
        for (Counter c : counters){
            temp += c.toString() + " ";   
        }
        if(counters[counters.length -1].getCount() > 0){
            System.out.print(temp + " Outs: " + counters[counters.length - 1]);
        } else {
            System.out.println(temp);
        }
    }      

    
    
    /** 
     *
     * StrikeBtn is where the actionevent code runs for when you prese the next strike button
     * can't use stike Btn when 4 balls have been thrown
     * @param e is which buton pressed it. 
     */
    public void strikeBtn(ActionEvent e){ 
        if(ballCounter.getCount() != 4 ){
            if(strikeCounter.getCount() >= 3){
                outCounter.increment();
                l2.setText("Outs: " + outCounter.toString());
                return;
            } else {
                String str;
    
                strikeCounter.increment();
    
                str = String.valueOf(strikeCounter);
    
                textToScreen(ballCounter, strikeCounter, nextCounter, outCounter);
    
                f2.setText(str);    
            }
        }
    } 

    
    
    /** 
     *
     * NextBtn is where the actionevent code runs for when you prese the next batter button
     *
     * @param e is which buton pressed it. 
     */
    public void nextBtn(ActionEvent e){ 

        ballCounter.reset();
        strikeCounter.reset();
        nextCounter.increment();
        
        f1.setText("0");
        f2.setText("0");

        textToScreen(ballCounter, strikeCounter, nextCounter, outCounter);
    }

    
    
    /** 
     *
     * ResetBtn is where the actionevent code runs for when you press the reset button
     *
     * @param e is which buton pressed it. 
     */
    public void resetBtn(ActionEvent e){ 

        ballCounter.reset();
        strikeCounter.reset();
        nextCounter.reset();
        outCounter.reset();

        textToScreen(ballCounter, strikeCounter, nextCounter, outCounter);

        f1.setText(ballCounter.toString());
        f2.setText(strikeCounter.toString());
        l2.setText("Outs: " + outCounter.toString());
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
        Scene scene = new Scene(root, 400, 225); // set the size here
        stage.setTitle("BaseBall App"); // set the window title here
        stage.setScene(scene);
        
        scene.setFill(Color.CHOCOLATE);

        //making the modles
        ballCounter = new Counter();
        strikeCounter = new Counter();
        nextCounter = new Counter();
        outCounter = new Counter();

        //making the gui elments
        l1 = new Label("BaseBall Umpire App");
        l2 = new Label("Outs: " + outCounter.toString());
        ball = new Button("Ball");
        strike = new Button("Strike");
        next_Batter = new Button("Next Batter");
        reset = new Button("Reset");

        f1 = new TextField();
        f2 = new TextField();

        //adding gui elments to root
        root.getChildren().addAll(l1, l2, ball, strike, next_Batter, reset, f1 , f2 );

        //Pitch Counter text
        l1.relocate(10, 10);
        l1.setFont(new Font("System", 40));
        l1.setTextFill(Color.BLUE);

        //Out Counter text
        l2.relocate(200, 80);
        l2.setFont(new Font("System", 30));
        l2.setTextFill(Color.BLUE);

        //textFeild for the ball and strike count
        f1.relocate(25, 80);
        f2.relocate(85, 80);

        //aligment on textFields
        f1.setAlignment(Pos.CENTER);
        f2.setAlignment(Pos.CENTER);

        //setting text to 0 in textFields
        f1.setText("0");
        f2.setText("0");

        //setting Pref Height of the textFields
        f1.setPrefHeight(50);
        f2.setPrefHeight(50);

        //setting Pref Widths of the textFields
        f1.setPrefWidth(40);
        f2.setPrefWidth(40);

        //setting values for the ball button like pos, pref height and font
        ball.relocate(25, 150);
        ball.setPrefHeight(40);
        ball.setFont(new Font("System", 20));

        ////setting values for the strike button like pos, pref height and font
        strike.relocate(90, 150);
        strike.setPrefHeight(40);
        strike.setFont(new Font("System", 20));

        //setting values for the next batter button like pos, pref height and font
        next_Batter.relocate(175, 150);
        next_Batter.setPrefHeight(40);
        next_Batter.setFont(new Font("System", 20));

        //setting values for the reset button like pos, pref height and font
        reset.relocate(310, 150);
        reset.setPrefHeight(40);
        reset.setFont(new Font("System", 20));

        // 5. Add Event Handlers and do final setup

        ball.setOnAction(this::ballBtn);
        strike.setOnAction(this::strikeBtn);
        reset.setOnAction(this::resetBtn);
        next_Batter.setOnAction(this::nextBtn);
        l2.addEventHandler(MouseEvent.MOUSE_PRESSED, this::pressHandler);

        
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
