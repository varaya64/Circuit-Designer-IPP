package Clases;

public class Or extends LogicGate{

	@Override
	public void trueValue() {
		boolean result = true;
		result = this.isInput1() || this.isInput2();
		this.setOutpot(result);
	}
	
	

}