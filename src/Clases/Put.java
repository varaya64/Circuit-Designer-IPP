package Clases;
import Clases.List;
import Clases.LogicGate;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class Put {
	
	
	public Put() {
	}

	public void putImage(String image, Pane panel, DragEvent event, List list, ConectionGates conections) {
		LogicGate node = FactoryGates.newlogicGate(image);
		ImageView nueva = new ImageView(); 
		Image com = new Image(image);
		Rectangle input1 = new Rectangle(12, 12);
		Rectangle input2 = new Rectangle(12, 12);
		Rectangle outpot = new Rectangle(15, 15);
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
		Put.putRects(panel, image, mouseX, mouseY, input1, input2, outpot);
		list.addLast(node, panel, image, mouseX, mouseY);
		node.setInput1R(input1);
		node.setInput2R(input2);
		node.setOutpot(outpot);
		list.recordList(panel);
		Put.putLabel(panel, image, mouseX-largo, mouseY-ancho+40, node.getID());
		panel.getChildren().addAll(nueva);
	}	
	
	
	public static void putRects(Pane panel, String image, Double mouseX, Double mouseY, Rectangle input1, Rectangle input2, Rectangle outpot) {
		if (image == "file:and.png"|| image == "file:nand.png" ) {
			input1.setX(mouseX-20);
			input1.setY(mouseY+13);
			input2.setX(mouseX-20);
			input2.setY(mouseY+34);
			outpot.setX(mouseX+75);
			outpot.setY(mouseY+23);
			outpot.setFill(Color.BLUEVIOLET);
		}else if (image == "file:not.png") {
			input1.setX(mouseX-40);
			input1.setY(mouseY+11);
			outpot.setX(mouseX+75);
			outpot.setY(mouseY+12);
			input2.setFill(Color.ALICEBLUE);
			outpot.setFill(Color.BLUEVIOLET);
		}else  {
			input1.setX(mouseX-32);
			input1.setY(mouseY+1);
			input2.setX(mouseX-32);
			input2.setY(mouseY+22);
			outpot.setX(mouseX+60);
			outpot.setY(mouseY+11);
			outpot.setFill(Color.BLUEVIOLET);	
		}
		panel.getChildren().addAll(input1, input2, outpot);
	}

	public static void putLabel(Pane panel, String image, Double mouseX, Double mouseY, int ID) {
		String s = Integer.toString(ID);
		Label l = new Label(s);
		l.setFont(new Font("Arial", 40));
		l.setLayoutX(mouseX);
		l.setLayoutY(mouseY);
		panel.getChildren().addAll(l);
	}
	
	public static void clearPane(Pane panel, List list) {
		panel.getChildren().clear();
		list.deleteList();
	}
}