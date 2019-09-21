package Clases;

public class Nand extends LogicGate{

	public Nand(String type) {
		super(type);
	}

	@Override
	public void trueValue() {	
		boolean result = true;
		result = !(this.isInput1() && this.isInput2());
		this.setOutpot(result);
	}

}
