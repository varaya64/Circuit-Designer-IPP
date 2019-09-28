package Clases;

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
	

	public int getLarge() {
		return large;
	}

	public void setLarge(int large) {
		this.large = large;
	}
	

}
