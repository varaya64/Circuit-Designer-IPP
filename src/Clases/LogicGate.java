package Clases;

public class LogicGate {
	
	protected int nInputs;
	protected int outpot;
	protected boolean input1;
	protected boolean input2; 
	protected String type;
	
	public LogicGate(String type, int nInputs) {
		this.nInputs = nInputs;
		this.type = type;
		outpot = (Integer) null;
		input1 = (Boolean) null;
		input2 = (Boolean) null;
	}

	public int getnInputs() {
		return nInputs;
	}

	public int getOutpot() {
		return outpot;
	}

	public boolean getInput1() {
		return input1;
	}
	
	public boolean getInput2() {
		return input2;
	}

	public void setInput1(boolean input1) {
		this.input1 = input1;
	}
	
	public void setInput2(boolean input2) {
		this.input2 = input2;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
