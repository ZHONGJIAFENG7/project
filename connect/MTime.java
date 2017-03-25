import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.scene.image.*;
import javafx.scene.shape.*;


import java.util.*;
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
import javafx.animation.SequentialTransition;



public class MTime{
	Timeline timeL = new Timeline();


	MTime(){

	}

	String randImage(){
		Random aa = new Random();
		int x = aa.nextInt(2);

		if (x == 0){
			return "ball1.png";
		}
		else return "player.png";
	}
	Circle[] setRandCircle(Circle[] circles){

		for (int i = 0; i < 4; i++) {
			circles[i].setFill(new ImagePattern(new Image(randImage())));
		}
		return circles;

	}

	Circle[] setCircle(int x, int y, int radius){
		Circle[] circles = new Circle[4];
		for(int i=0;i<4;i++) {
			circles[i] = new Circle(x+i*20, y, radius, Color.BLUEVIOLET);

		}

		return circles;
	}

	/*KeyFrame makeKF(int time){


		KeyValue kValueX = new KeyValue(circle[i].scaleXProperty() , scale);
		KeyValue kValueY = new KeyValue(circle[i].scaleYProperty() , scale);
		//KeyValue kValueY2 = new KeyValue(circle[i].scaleYProperty() , scale);

		KeyValue xC = new KeyValue(circle[i].translateXProperty(), xChange);
		KeyValue yC = new KeyValue(circle[i].translateYProperty(), 300);

		KeyFrame kFrame = new KeyFrame(Duration.millis(time + 1000 ) , kValueX , kValueY, xC, yC);
		return kFrame;

	}*/

	void time20(Circle[] circle){
		for (int i = 0; i < 20; i++){
			time(setRandCircle(circle), 1000);
		}
	}

	void time(Circle[] circle, int time){



int xChange = -90;


		for(int i=0;i<4;i++){
double scale = 2.5;
			KeyValue kValueX = new KeyValue(circle[i].scaleXProperty() , scale);
			KeyValue kValueY = new KeyValue(circle[i].scaleYProperty() , scale);
			//KeyValue kValueY2 = new KeyValue(circle[i].scaleYProperty() , scale);

			KeyValue xC = new KeyValue(circle[i].translateXProperty(), xChange);
			KeyValue yC = new KeyValue(circle[i].translateYProperty(), 300);

			KeyFrame kFrame = new KeyFrame(Duration.millis(1000 ) , kValueX , kValueY, xC, yC);


			timeL.getKeyFrames().add(kFrame);
			setRandCircle(circle);

			KeyValue kValueX1 = new KeyValue(circle[i].scaleXProperty() , scale);
			KeyValue kValueY1 = new KeyValue(circle[i].scaleYProperty() , scale);
			//KeyValue kValueY2 = new KeyValue(circle[i].scaleYProperty() , scale);

			KeyValue xC1 = new KeyValue(circle[i].translateXProperty(), xChange);
			KeyValue yC1 = new KeyValue(circle[i].translateYProperty(), 300);

			KeyFrame kFrame1 = new KeyFrame(Duration.millis(1000 + 5000) , kValueX1 , kValueY1, xC1, yC1);

			timeL.getKeyFrames().add(kFrame1);


			//timeL.setAutoReverse(false);

	//		timeL2.getKeyFrames().add(k2Frame);
			//timeL2.setAutoReverse(false);
//			timeL2.setCycleCount(2);



//			SequentialTransition seq = new SequentialTransition(timeL, timeL2);
//			seq.play();
		//	timeline.setOnFinished(x -> timeline = null);

			//timeL.play();
			/*try {
				Thread.sleep(1000);
			} catch (Exception e){
				System.out.println("Failed sleep");
			}*/


		}
		timeL.play();

		//timeL.stop();
	}
}
