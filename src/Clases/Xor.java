package Clases;

public class Xor  extends LogicGate {

	public Xor(String type) {
		super(type);
	}

	@Override
	public void trueValue() {
		boolean result = true;
		result = this.isInput1() ^ this.isInput2();
		this.setOutpot(result);
	}

}
