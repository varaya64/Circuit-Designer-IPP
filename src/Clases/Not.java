package Clases;

public class Not  extends LogicGate{
	
	@Override
	public void trueValue() {
		boolean result = true;
		result = !(this.isInput1());
		this.setOutpot(result);
		
	}

}
