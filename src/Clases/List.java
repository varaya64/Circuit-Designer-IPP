package Clases;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class List{
	
	private LogicGate first;
	private LogicGate last;
	private int large;

	public List() {
	}
	
	public void addLast(LogicGate node, Pane panel, String type, Double posX, Double posY) {
		if (first == null && last==null) {
			first = node;
			last = node;
		}else {
			last.setNext(node);
			node.setPrev(first);
			last = node;
		}
		List.this.setLarge(List.this.getLarge()+1);
		last.setID(getLarge());

	}
		
	public void recordList(Pane panel) {
		LogicGate temp = first;
		while (temp != null) {
			temp.referencePrevAux(panel, temp);
			temp = temp.getNext();
		}
	}
	
	public void deleteList() {
		first = null;
		last = null;
	}
	
	public void getValues() {
		LogicGate temp = first;
		int i = first.getID();
		while (temp != null) {
			if (temp.getPrevAux1() == null) {
				TextInputDialog dialog = new TextInputDialog("true");
				dialog.setTitle("Para la compuerta " + Integer.toString(i));
				dialog.setHeaderText("Inserte Valor entrada 1 ");
				dialog.setContentText("Valor de verdad: ");
				Optional<String> result = dialog.showAndWait();
				if (result.isPresent()) {
					temp.setInput1(true);
					System.out.println("el valor de entrada es true");
				}else {
					temp.setInput1(false);
				}
				TextInputDialog dialog2 = new TextInputDialog("true");
				dialog2.setTitle("Para la compuerta " + Integer.toString(i));
				dialog2.setHeaderText("Inserte Valor entrada 2 ");
				dialog2.setContentText("Valor de verdad: ");
				Optional<String> result2 = dialog2.showAndWait();
				if (result2.isPresent()) {
					temp.setInput2(true);
					System.out.println("el valor de entrada 2 es true");
				}else {
					temp.setInput2(false);
				}
				temp = temp.getNext();
				i = temp.getID();
			}else {
				temp = temp.getNext();
			}
		}
	}

	public int getLarge() {
		return large;
	}

	public void setLarge(int large) {
		this.large = large;
	}
	

}
