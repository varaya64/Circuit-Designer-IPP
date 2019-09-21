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
import javafx.scene.layout.Pane;
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
		
		Image gate1 = new Image("file:and.png");
	   	ImageView gate1V = new ImageView(gate1);
	   	gate1V.setX(40); 
	   	gate1V.setY(40); 
	   	Image gate2 = new Image("file:nand.png");
	   	ImageView gate2V = new ImageView(gate2);
	   	gate2V.setX(40); 
	   	gate2V.setY(50);
	   	Image gate3 = new Image("file:nor.png");
	   	ImageView gate3V = new ImageView(gate3);
	   	gate3V.setX(40); 
	   	gate3V.setY(40);  
	   	Image gate4 = new Image("file:not.png");
	   	ImageView gate4V = new ImageView(gate4);
	   	gate4V.setX(40); 
	   	gate4V.setY(50);
	   	Image gate5 = new Image("file:or.png");
	   	ImageView gate5V = new ImageView(gate5);
	   	gate5V.setX(40); 
	   	gate5V.setY(40);  
	   	Image gate6 = new Image("file:xnor.png");
	   	ImageView gate6V = new ImageView(gate6);
	   	gate6V.setX(40); 
	   	gate6V.setY(50);
	   	Image gate7 = new Image("file:xor.png");
	   	ImageView gate7V = new ImageView(gate7);
	   	gate7V.setX(40); 
	   	gate7V.setY(40);  

		VBox panelLogicGates = new VBox(20);
		panelLogicGates.setAlignment(Pos.CENTER_LEFT);
	   	panelLogicGates.getChildren().addAll(gate1V, gate2V, gate3V, gate4V, gate5V, gate6V, gate7V);

		Pane draw = new Pane();
		draw.setMinSize(1000, 600);
		
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
		
		//Image[] gates = {gate1, gate2, gate3, gate4, gate5, gate6, gate7};
		ImageView[] gatesV = {gate1V, gate2V, gate3V, gate4V, gate5V, gate6V, gate7V};
		String[] gates = {"file:and.png", "file:nand.png", "file:nor.png", "file:not.png",
				"file:or.png", "file:xnor.png", "file:xor.png"};
		
		for (int i=0 ; i < 7; i++ ) {
			ImageView selected = gatesV[i];
			String selected2 = gates[i];
			selected.setOnDragDetected(new EventHandler<MouseEvent>() {
				public void handle(MouseEvent event) {
					Dragboard db = selected.startDragAndDrop(TransferMode.ANY);
					ClipboardContent content = new ClipboardContent();
					content.putString(selected2);
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
					if (event.getGestureSource() != draw && event.getDragboard().hasString()) {
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
					ImageView nueva = new ImageView(); 
					Image com = new Image(db.getString());
					nueva.setImage(com);
					double mouseX = event.getX();
					double mouseY = event.getY();
					double ancho = (nueva.getImage().getWidth()*0.5);
					double largo = (nueva.getImage().getHeight()*0.5);
					nueva.setX(mouseX-ancho);
					nueva.setY(mouseY-largo);
					draw.getChildren().addAll(nueva);
					}
					event.setDropCompleted(success);
					event.consume();
				}
			});
		
			draw.setOnDragExited( new EventHandler<DragEvent>() {
				public void handle(DragEvent event) {
					System.out.println("hola");
					event.consume();
				}
			});
		
		}
	primaryStage.show();
	}


}


