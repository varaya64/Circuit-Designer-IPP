package Clases;

public class And  extends LogicGate {

	public And(String type) {
		super(type);
	}

	@Override
	public void trueValue() {
		boolean result = true;
		result = this.isInput1() && this.isInput2();
		this.setOutpot(result);
	}

}
