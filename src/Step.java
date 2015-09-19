import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Step {

	private int FRAMES_PER_SECOND = 60;
	private int MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
	private double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;
	private Timeline animation;
	int two = 2;
	
	
	public void updateStep (Stage s, double elapsedTime) {
		
	}
	
	public void startUpdateLoop(Stage s) {
		animation = new Timeline();
		KeyFrame frame = new KeyFrame(Duration.millis(MILLISECOND_DELAY),
				e -> updateStep(s, SECOND_DELAY));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.getKeyFrames().add(frame);
		animation.play();
	}
	
	public void stopUpdateLoop() {
		animation.stop();
	}
	
	public void startUpdateLoop() {
		animation.play();
	}
	
	public void speedFPS() {
		FRAMES_PER_SECOND = FRAMES_PER_SECOND*two;
	}
	
	public void slowFPS() {
		FRAMES_PER_SECOND = FRAMES_PER_SECOND/two;
	}
	
	public void forward() {
//		animation.stop();
	}
}
