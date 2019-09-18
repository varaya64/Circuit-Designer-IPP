import java.awt.Event;
import java.io.FileInputStream;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GUI extends Application {

	public static void main (String [] args ) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		//Buttons
		Button button1 = new Button("Diseñador Circuito");
		Button button2 = new Button("Simulador de Circuitos");
		Button button3 = new Button("Instrucciones");


		VBox panel1 = new VBox(20);
		panel1.setAlignment(Pos.CENTER );
		panel1.getChildren().addAll(button1, button2, button3);	

		StackPane canvas1 = new StackPane();
		canvas1.getChildren().add(panel1);

		//Scenes
		Scene display1 = new Scene(canvas1, 1600, 900);

		primaryStage.setScene(display1);

		//*****************Scene for circuit Designer***************************//
		TextField circuitName = new TextField();
		VBox panelText = new VBox();
		panelText.getChildren().addAll(circuitName);

		Button buttonSave = new Button("Guardar Circuito");
		Button buttonReset = new Button("Nuevo Cicuito");
		Button buttonPlay = new Button("Play");
		Button buttonExitDC = new Button("Salir");
		VBox panelButton = new VBox(20);
		panelButton.getChildren().addAll(buttonSave, buttonReset, buttonPlay, buttonExitDC);

		HBox panelVBox = new HBox(20);
		panelVBox.setAlignment(Pos.BOTTOM_RIGHT);
		panelVBox.setPadding(new Insets(15, 15, 15, 15));
		panelVBox.getChildren().addAll(panelText, panelButton);

		
		VBox panelLogicGates = new VBox(20);
		panelLogicGates.setAlignment(Pos.CENTER_LEFT);
		
	    String[] images = {"file:and.png", "file:and.png", "file:and.png", "file:and.png", "file:and.png",
	    		"file:and.png", "file:and.png"};
		
	    for (String i:images) {
	    	Image image = new Image("file:and.png");
	    	ImageView imageView = new ImageView(image);
	    	imageView.setX(40); 
	    	imageView.setY(40); 
	    	imageView.setFitHeight(150); 
	    	imageView.setFitWidth(150); 
	    	imageView.setPreserveRatio(true); 
	    	panelLogicGates.getChildren().addAll( imageView);
	    }

		ImageView[] gates = {imageView};
		
		Canvas draw = new Canvas(1000, 600);
		GraphicsContext gc = draw.getGraphicsContext2D();
		gc.setFill(Color.ALICEBLUE);
		gc.fillRect(0, 0, draw.getWidth(), draw.getHeight());
		
		HBox HBoxDraw = new HBox(1);
		HBoxDraw.setAlignment(Pos.CENTER_RIGHT);
		HBoxDraw.getChildren().addAll(draw);



		HBox panelMain = new HBox(200);
		panelMain.setAlignment(Pos.CENTER_LEFT);
		panelMain.setPadding(new Insets(15, 15, 15, 15));
		panelMain.getChildren().addAll( panelLogicGates, HBoxDraw);

		StackPane canvas2 = new StackPane();
		canvas2.getChildren().addAll(panelMain);
		


		Scene display2 = new Scene(canvas2, 1600, 900);			

		//******************************* Final Scene Circuit Designer*****************************//
		button1.setOnAction(e -> primaryStage.setScene(display2));
		buttonExitDC.setOnAction(e -> primaryStage.setScene(display1));
		primaryStage.setTitle("Circuit Designer By Carmen Araya");
		primaryStage.setResizable(false);
		
		
		
		for (int i=0 ; i < 1; i++ ) {
			ImageView Puerta = gates[i];
			imageView.setOnDragDetected(new EventHandler<MouseEvent>() {
				public void handle(MouseEvent event) {
					Dragboard db = imageView.startDragAndDrop(TransferMode.ANY);
					ClipboardContent content = new ClipboardContent();
					content.putString("Hello!");
					db.setContent(content);
					event.consume();
				}

			});

			draw.setOnDragOver(new EventHandler<DragEvent>() {
				public void handle(DragEvent event) {
					if (event.getGestureSource() != draw && event.getDragboard().hasString()) {
						event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
					}
					event.consume();
				}
			});
		
			draw.setOnDragEntered(new EventHandler<DragEvent>() {
				public void handle(DragEvent event) {
					if (event.getGestureSource() != gc && event.getDragboard().hasString()) {
						System.out.println("En el objetivo");
					}
					event.consume();
				}
			});
		
			draw.setOnDragDropped(new EventHandler<DragEvent>() {
				public void handle(DragEvent event) {
					Dragboard db = event.getDragboard();
					boolean success = false;
					if (db.hasString()) {
					System.out.println("Solte mouse objetivo");
					success = true;
					gc.setFill(Color.FORESTGREEN);
					gc.fillRect(0, 0, draw.getWidth(), draw.getHeight());
					}
					event.setDropCompleted(success);
					event.consume();
				}
			});
		
			draw.setOnDragExited( new EventHandler<DragEvent>() {
				public void handle(DragEvent event) {
					lg5.setFill(Color.DARKSALMON);
					event.consume();
				}
			});
		
		}
	primaryStage.show();
	}


}


