
/**
 *This is the graphics class. Created by @rob.
 *
 *
 *
 *
 */
import java.util.*;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.SequentialTransition;
import javafx.util.Duration;
import javafx.scene.image.*;
import javafx.scene.shape.*;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.canvas.*;
import javafx.event.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.beans.property.*;
import javafx.scene.layout.*;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.shape.*;
import javafx.scene.paint.*;



public class MGraphics {

  Canvas canvas = new Canvas(400, 300);
  Image bg = new Image("road.jpeg");
  Image player = new Image ("player.png");
  Image whiteBox = new Image("Box.png");
  Image ball = new Image("ball1.png");

  //deck.add(new Image("player.png"));
  //Image[] balls = new Image[2];
  //ystem.out.println(getClass().getResource("ball1.png"));
  //balls[0] = Toolkit.getDefaultToolkit().createImage("ball1.png")



  // ImageView ball1 = new ImageView(ball);
  ImageView whiteBox1 = new ImageView(whiteBox);
  GraphicsContext g = canvas.getGraphicsContext2D();
  StackPane ballPane = new StackPane();
  IntegerProperty score = new SimpleIntegerProperty(0);
  Group root = new Group(canvas);
  Scene road = new Scene(root);
  Label playerScore = new Label();
  StackPane scorePane = new StackPane();
  // Group circle = new Group();
  Timeline timeL = new Timeline();


  // Circle circle1,circle2;


  MGraphics(){

  }

  IntegerProperty getScore(){
    return this.score;
  }

  Scene getScene(){
    return this.road;
  }

  //put 4 new rand circle into circle group
  Group setCircle(int x, int y, int radius) {

    Group circle = new Group();
      for (int i = 0; i < 4; i++) {
          Circle newCircle= new Circle(x + i * 20, y, radius, Color.BLUEVIOLET);
          setRandCircle(newCircle);
          circle.getChildren().add(newCircle);
      }
      return circle;
    }

    void setRandCircle(Circle circle){
        circle.setFill(new ImagePattern(new Image(randImage())));
    }


    Scene setUp(Stage stage) {
       // setCircle(140, -200, 20);
        playerScore.textProperty().bind(score.asString());
        scorePane.getChildren().addAll(whiteBox1, playerScore);
      //  root.getChildren().add(circle);

        root.getChildren().add(scorePane);

       // stage.setScene(road);
        return road;
    }




  void draw(int x) {
    g.drawImage(bg, 0, 0);
    g.drawImage(player, x,250);
  }

  void show(Stage stage) {
  	stage.show();
  }



  String randImage(){
      Random aa = new Random();
      int x = aa.nextInt(2);

      if (x == 0){
         return "ball1.png";
      }else{
        return "player.png";
      }
  }

  KeyFrame makeKeyFrame(int time, int scaleX, int scaleY, int endX, int endY, Node currentCircle){
          KeyFrame keyF = new KeyFrame(Duration.millis(time),
                          new KeyValue(currentCircle.scaleXProperty() , scaleX),
                          new KeyValue(currentCircle.scaleYProperty() , scaleY),
                          new KeyValue(currentCircle.translateXProperty(), endX),
                          new KeyValue(currentCircle.translateYProperty(), endY));
                    return keyF;}

  Timeline makeTimeline(){
        Timeline tl = new Timeline();
        Group group = new Group();
        group = setCircle(140,-50,20);
        root.getChildren().add(group);
        int xChange = 0;
        for (Node node: group.getChildren()) {
            xChange += 50;
            tl.getKeyFrames().add(makeKeyFrame(2000,2,2,xChange,600,node));
        }
        return tl;
  }


  void circleAnimation(){
  //         int xChange = -20;
  //
  //Timeline tl1 = new Timeline();
  //Timeline tl2 = new Timeline();
  //
  //
  //         for (Node node: circle.getChildren()){
  //             xChange += 50;
  //             System.out.println(xChange);
  //             tl1.getKeyFrames().add(makeKeyFrame(2000, 2, 2, xChange, 600, node));
  //
  //         }
  //
  //
  ////8 circles are now set, will have to make new group everytime for each keyframe to work properly
  //setCircle(140,-200,20);
  //xChange=-20;
  //         for (Node node: circle.getChildren()){
  //             xChange += 50;
  //             System.out.println(xChange);
  //             tl2.getKeyFrames().add(makeKeyFrame(2000, 2, 2, xChange, 600, node));
  //
  //         }

  SequentialTransition sequence = new SequentialTransition();
  for (int i = 0; i < 40; i++) {
      sequence.getChildren().add(makeTimeline());
  }
  sequence.play();
  // timeL.play();
}
}
