package Clases;

public class Or extends LogicGate{



	public Or(String type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void trueValue() {
		boolean result = true;
		result = this.isInput1() || this.isInput2();
		this.setOutpot(result);
	}
	
	

}
