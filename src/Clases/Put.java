package Clases;
import Clases.List;
import Clases.LogicGate;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class Put {
	
	
	public Put() {
	}

	List listGates = new List();	
	ConectionGates conectionGates = new ConectionGates();

	public void putImage(String image, Pane panel, DragEvent event ) {
		LogicGate node = FactoryGates.newlogicGate(image);
		ImageView nueva = new ImageView(); 
		Image com = new Image(image);
		Rectangle input1 = new Rectangle(10, 10);
		Rectangle input2 = new Rectangle(10, 10);
		nueva.setImage(com);
		double mouseX = event.getX();
		double mouseY = event.getY();
		double ancho = (nueva.getImage().getWidth()*0.5);
		double largo = (nueva.getImage().getHeight()*0.5);
		nueva.setX(mouseX-ancho);
		nueva.setY(mouseY-largo);
		if (image == "file:and.png"|| image == "file:nand.png" ) {
			nueva.setFitWidth(180);
			nueva.setFitHeight(180);
		}else  {
			nueva.setFitWidth(150);
			nueva.setFitHeight(150);
		}
		Put.putRects(panel, image, mouseX, mouseY, input1, input2);
		listGates.addLast(node, panel, image, mouseX, mouseY, input1, input2);
		node.setInput1R(input1);
		node.setInput2R(input2);
		listGates.recordList(panel);
		panel.getChildren().addAll(nueva);
	}	
	
	
	public static void putRects(Pane panel, String image, Double mouseX, Double mouseY, Rectangle input1, Rectangle input2) {
		if (image == "file:and.png"|| image == "file:nand.png" ) {
			input1.setX(mouseX-20);
			input1.setY(mouseY+13);
			input2.setX(mouseX-20);
			input2.setY(mouseY+34);
			input2.setFill(Color.BLACK);
		}else if (image == "file:not.png") {
			input1.setX(mouseX-40);
			input1.setY(mouseY+11);
			input2.setFill(Color.ALICEBLUE);
		}else  {
			input1.setX(mouseX-32);
			input1.setY(mouseY+1);
			input2.setX(mouseX-32);
			input2.setY(mouseY+22);
			input2.setFill(Color.BLACK);	
		}
		panel.getChildren().addAll(input1, input2);
	}

}