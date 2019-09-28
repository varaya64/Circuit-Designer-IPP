package Clases;
import java.awt.Component;
import java.util.Random;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Dialog;
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
	static LogicGate reference;
	
	
	public static void paintLines(Rectangle rect, Pane panel, LogicGate temp) {
		reference = null;
		rect.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				if(mouseEvent.getButton() == MouseButton.PRIMARY) {
					if(rect.equals(temp.getOutpot())) {
						firstX = rect.getX();
						firstY = rect.getY();
						reference = temp;
						flagLine = true;
					}
					else {
					Alert alert = new Alert(AlertType.ERROR); 
					alert.setTitle("Error");
					alert.setHeaderText("Ha seleccionado una entrada!");
					alert.setContentText("Este comando solo permite seleccionar salidas");
					alert.showAndWait();
					}
					
				}else if(mouseEvent.getButton() == MouseButton.SECONDARY){
					if(rect.equals(temp.getInput1R())) {
						lastX = rect.getX();
						lastY = rect.getY();
						if (flagLine) {
							ConectionGates.putLines(panel, reference, temp);	
							temp.setPrevAux1(reference);
							System.out.println(temp.getPrevAux1().getID());
							reference = null;
							flagLine = false;
						}
					}else if (rect.equals(temp.getInput2R())) {
						lastX = rect.getX();
						lastY = rect.getY();
						if (flagLine) {
							ConectionGates.putLines(panel, reference, temp);
							temp.setPrevAux2(reference);
							System.out.println(temp.getPrevAux2().getID());
							reference = null;
							flagLine = false;
						}
					}else {
						Alert alert = new Alert(AlertType.ERROR); 
						alert.setTitle("Error");
						alert.setHeaderText("Ha seleccionado una entrada!");
						alert.setContentText("Este comando solo permite seleccionar entradas");
						alert.showAndWait();
					}
				}
			}
		});
	}
	
	public static void putLines(Pane panel, LogicGate reference, LogicGate temp) { 
		Line line = new Line(firstX, firstY, lastX, lastY);
		line.setStroke(randomColor());
		panel.getChildren().addAll(line);

	}
	
    public static Paint randomColor () {  
        Random random = new Random();  
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(120);
        return Color.rgb( r , g , b ); 
    }
    
}