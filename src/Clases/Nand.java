package Clases;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class Nand extends LogicGate{


	public Nand(String type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void trueValue() {	
		Boolean result = true;
		result = !(this.isInput1() && this.isInput2());
		this.setOutpot(result);
	}	
}
