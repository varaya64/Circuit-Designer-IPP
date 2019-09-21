import Clases.FactoryGates;
import Clases.List;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;

public class DragAndDrop {

	
	public void paintGates(Pane panel, ImageView gateV, String gate) {
		
		FactoryGates fg = new FactoryGates();
		List listGates = new List();
		
		gateV.setOnDragDetected(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				Dragboard db = gateV.startDragAndDrop(TransferMode.ANY);
				ClipboardContent content = new ClipboardContent();
				content.putString(gate);
				db.setContent(content);
				event.consume();
			}

		});

		panel.setOnDragOver(new EventHandler<DragEvent>() {
			public void handle(DragEvent event) {
				if (event.getGestureSource() != panel && event.getDragboard().hasString()) {
					event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
				}
				event.consume();
			}
		});
	
		panel.setOnDragDropped(new EventHandler<DragEvent>() {
			public void handle(DragEvent event) {
				Dragboard db = event.getDragboard();
				boolean success = false;
				if (db.hasString()) {
				System.out.println("Solte mouse objetivo");
				success = true;
				ImageView nueva = new ImageView(); 
				Image com = new Image(db.getString());
				nueva.setImage(com);
				double mouseX = event.getX();
				double mouseY = event.getY();
				double ancho = (nueva.getImage().getWidth()*0.5);
				double largo = (nueva.getImage().getHeight()*0.5);
				nueva.setX(mouseX-ancho);
				nueva.setY(mouseY-largo);
				panel.getChildren().addAll(nueva);	
				FactoryGates.newlogicGate(db.getString());
				}
				event.setDropCompleted(success);
				event.consume();
			}
		});
	}
}
