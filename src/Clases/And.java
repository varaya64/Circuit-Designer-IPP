package Clases;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class And  extends LogicGate {

	
	public And(String type) {
		super(type);
	}

	@Override
	public void trueValue() {
		Boolean result = true;
		result = this.isInput1() && this.isInput2();
		this.setOutpot(result);
	}

}