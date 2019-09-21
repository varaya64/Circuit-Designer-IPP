package Clases;

public class Nor  extends LogicGate{

	
	
	public Nor() {
		super();
	}

	@Override
	public void trueValue() {
		boolean result = true;
		result = !(this.isInput1() || this.isInput2());
		this.setOutpot(result);
		
	}

}
