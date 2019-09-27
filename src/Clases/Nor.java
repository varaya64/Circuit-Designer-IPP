package Clases;

import javafx.scene.shape.Rectangle;

public class Nor  extends LogicGate{


	public Nor(String type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void trueValue() {
		boolean result = true;
		result = !(this.isInput1() || this.isInput2());
		this.setOutpot(result);
		
	}

	

}
