package Clases;

import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public abstract class LogicGate {
	
	private boolean input1;
	private boolean input2;
	private boolean output;
	private LogicGate next;
	private LogicGate prev;
	private LogicGate prevAux1;
	private LogicGate prevAux2;
	private Rectangle input1R;
	private Rectangle input2R;
	private Rectangle outpot;
	private String Type;
	private int ID;
	
	
	public LogicGate(String type) {
		super();
		Type = type;
	}
	
	public void referencePrevAux(Pane panel, LogicGate temp) {
		if (prevAux1 == null && prevAux2 == null) {
			ConectionGates.paintLines(LogicGate.this.getInput1R(), panel, temp);
			ConectionGates.paintLines(LogicGate.this.getInput2R(), panel, temp);
			ConectionGates.paintLines(LogicGate.this.getOutpot(), panel, temp);
		}else if(prevAux1 != null && prevAux2 != null) {
			System.out.println("No se puede conectar esta compuerta");	
		}else if (prevAux1 == null && prevAux2 != null) {
			ConectionGates.paintLines(LogicGate.this.getInput1R(), panel, temp);
			ConectionGates.paintLines(LogicGate.this.getOutpot(), panel, temp);
		}else if(prevAux1 != null && prevAux2 == null){
			ConectionGates.paintLines(LogicGate.this.getOutpot(), panel, temp);
		}
	}
	
	public boolean isInput1() {
		return input1;
	}
	public void setInput1(boolean input1) {
		this.input1 = input1;
	}
	public boolean isInput2() {
		return input2;
	}
	public void setInput2(boolean input2) {
		this.input2 = input2;
	}
	public boolean isOutpot() {
		return output;
	}
	public void setOutpot(boolean output) {
		this.output = output;
	}	
	public abstract void trueValue();
	public LogicGate getPrevAux1() {
		return prevAux1;
	}
	public void setPrevAux1(LogicGate prevAux1) {
		this.prevAux1 = prevAux1;
	}
	public LogicGate getNext() {
		return next;
	}
	public void setNext(LogicGate next) {
		this.next = next;
	}
	public LogicGate getPrev() {
		return prev;
	}
	public void setPrev(LogicGate prev) {
		this.prev = prev;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public LogicGate getPrevAux2() {
		return prevAux2;
	}
	public void setPrevAux2(LogicGate prevAux2) {
		this.prevAux2 = prevAux2;
	}

	public Rectangle getOutpot() {
		return outpot;
	}
	public void setOutpot(Rectangle outpot) {
		this.outpot = outpot;
	}
	public Rectangle getInput2R() {
		return input2R;
	}
	public void setInput2R(Rectangle input2r) {
		input2R = input2r;
	}
	public Rectangle getInput1R() {
		return input1R;
	}
	public void setInput1R(Rectangle input1r) {
		input1R = input1r;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
}

	