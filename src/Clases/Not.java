package Clases;

public class Not  extends LogicGate{
	
	public Not(String type) {
		super(type);
	}

	@Override
	public void trueValue() {
		boolean result = true;
		result = !(this.isInput1());
		this.setOutpot(result);
		
	}

}
