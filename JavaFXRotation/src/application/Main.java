package application;
	
import java.util.Timer;
import java.util.TimerTask;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Box;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Text text = new Text();
			text.setText("Javaa Fx Rotation");
			text.setX(50);
			text.setY(50);
			Box box = new Box();
			box.setWidth(150);
			box.setHeight(150);
			box.setDepth(150);
			
			Translate translate = new Translate();
			translate.setX(400);
			translate.setY(150);
			translate.setZ(25);
			
			Rotate rxBox = new Rotate(0, 0, 0, 0, Rotate.X_AXIS);
			Rotate ryBox = new Rotate(0, 0, 0, 0, Rotate.Y_AXIS);
			Rotate rzBox = new Rotate(0, 0, 0, 0, Rotate.Z_AXIS);
			rxBox.setAngle(30);
			ryBox.setAngle(50);
			rzBox.setAngle(30);
			box.getTransforms().addAll(rxBox, ryBox, rzBox);
			
	        Pane pane = new Pane(box);
	        Rotate rotation = new Rotate();
	        rotation.pivotXProperty().bind(box.translateXProperty());
	        rotation.pivotYProperty().bind(box.translateYProperty());

	        AnimationTimer aTimer = new AnimationTimer() {
	        	private long lastUpdate = 0 ;
				@Override
				public void handle(long now) {
					// TODO Auto-generated method stub
					 if (now - lastUpdate >= 1000) {
						 	rotation.setAngle(0);
						 	//rotation.angleProperty();
	                        lastUpdate = now ;
	                    }
				}
			};
			
//			Timeline timeline = new Timeline(
//	                new KeyFrame(Duration.ZERO, new KeyValue(rotation.angleProperty(), 0)),
//	                new KeyFrame(Duration.seconds(16), new KeyValue(rotation.angleProperty(), 2880)));
//			
			box.getTransforms().add(rotation);
			
//			 Button button = new Button("Rotate");
//		        button.setOnAction(evt ->  timeline.play());
//		        button.disableProperty().bind(timeline.statusProperty().isEqualTo(Animation.Status.RUNNING));

//		        HBox controls = new HBox(button);
//		        controls.setAlignment(Pos.CENTER);
//		        controls.setPadding(new Insets(12));
			
			BorderPane root = new BorderPane(box/*, null, null, controls, null*/);
			aTimer.start();
//			new Timer().schedule(
//				    new TimerTask() {
//
//				        @Override
//				        public void run() {
//				        	 timeline.play();
//				        }
//				    }, 0, 1000);
			
			//root.setLayoutY(-175);
			root.setTop(text);
			//root.setCenter(box);
			Scene scene = new Scene(root,400,400);
			
			//System.out.println(scene.getWindow());
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			primaryStage.setTitle("My First Java FX Application Yea!!!");
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}
}
