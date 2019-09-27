package Clases;
import java.util.Random;

import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class ConectionGates {
	
	static double firstX;
	static double firstY;
	static double lastX;
	static double lastY;
	static boolean flagLine = false;
	
	public static void paintLines(Rectangle rect, Pane panel) {
		rect.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				if(mouseEvent.getButton() == MouseButton.PRIMARY) {
					firstX = rect.getX();
					firstY = rect.getY();
					flagLine = true;
				}else if(mouseEvent.getButton() == MouseButton.SECONDARY){
					lastX = rect.getX();
					lastY = rect.getY();
					if (flagLine) {
						ConectionGates.putLines(panel);
					}
					flagLine = false;
				}
			}
		});
	}

	public static void putLines(Pane panel) { 
		Line line = new Line(firstX, firstY, lastX, lastY);
		line.setFill(randomColor());
		panel.getChildren().addAll(line);

	}
	
    public static Paint randomColor () {  
        Random random = new Random();  
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(120);
        return Color.rgb ( r , g , b ); 
    }
	
}