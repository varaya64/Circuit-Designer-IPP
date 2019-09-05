import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.Lighting;
import javafx.scene.input.ClipboardContent;
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
		Scene display1 = new Scene(canvas1, 1000, 800);
		
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
		 
		Rectangle lg1 = new Rectangle(40, 40, Color.CADETBLUE);
		Rectangle lg2 = new Rectangle(40, 40);
		Rectangle lg3 = new Rectangle(40, 40);
		Rectangle lg4 = new Rectangle(40, 40);
		Rectangle lg5 = new Rectangle(40, 40);
		Rectangle lg6 = new Rectangle(40, 40);
		Rectangle lg7 = new Rectangle(40, 40);
		 
		VBox panelLogicGates = new VBox(20);
		panelLogicGates.setAlignment(Pos.TOP_LEFT);
		panelLogicGates.getChildren().addAll(lg1,lg2, lg3, lg4 ,lg5 ,lg6 ,lg7);
		 
		Text title = new Text("Arrastre y conecte aqui las compuertas");
		 
		VBox panelMain = new VBox(15);
		panelMain.setAlignment(Pos.TOP_CENTER);
		panelMain.setPadding(new Insets(15, 15, 15, 15));
		panelMain.getChildren().addAll(title, panelLogicGates, panelVBox);
		 
		StackPane canvas2 = new StackPane();
		canvas2.getChildren().add(panelMain);
			
		
		Scene display2 = new Scene(canvas2, 1000, 800);			
		
//******************************* Final Scene Circuit Designer*****************************//
		button1.setOnAction(e -> primaryStage.setScene(display2));
		buttonExitDC.setOnAction(e -> primaryStage.setScene(display1));
		primaryStage.setTitle("Circuit Designer By Carmen Araya");
		primaryStage.setResizable(false);
		primaryStage.show();
		
		lg6.setOnDragDetected(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				Dragboard db = lg6.startDragAndDrop(TransferMode.ANY);
				ClipboardContent content = new ClipboardContent();
				content.putString("Hello!");
		        db.setContent(content);
		        event.consume();
			}
			
		});
		
	}


}


