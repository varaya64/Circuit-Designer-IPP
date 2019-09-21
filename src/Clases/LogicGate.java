package Clases;

public abstract class LogicGate {
	
	private boolean input1;
	private boolean input2;
	private boolean output;
	private LogicGate next;
	private LogicGate prev;
	private LogicGate prevAux1;
	private LogicGate prevAux2;
	
	
 	public boolean isInput1() {
		return input1;
	}
	public void setInput1(boolean input1) {
		this.input1 = input1;
	}
	public boolean isInput2() {
		return input2;
	}
	public void setInput2(boolean input2) {
		this.input2 = input2;
	}
	public boolean isOutpot() {
		return output;
	}
	public void setOutpot(boolean output) {
		this.output = output;
	}
	
	public abstract void trueValue();

}

	