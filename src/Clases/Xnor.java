package Clases;

public class Xnor  extends LogicGate{

	public Xnor(String type) {
		super(type);
	}

	@Override
	public void trueValue() {
		boolean result = true;
		result = !(this.isInput1() ^ this.isInput2());
		this.setOutpot(result);
	}

}
