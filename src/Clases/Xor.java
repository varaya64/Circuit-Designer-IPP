package Clases;

public class Xor  extends LogicGate {



	public Xor(String type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void trueValue() {
		Boolean result = true;
		result = this.isInput1() ^ this.isInput2();
		this.setOutpot(result);
	}

}
