package Clases;

import javafx.scene.shape.Rectangle;

public class Not  extends LogicGate{
	

	public Not(String type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void trueValue() {
		boolean result = true;
		result = !(this.isInput1());
		this.setOutpot(result);
		
	}



}
