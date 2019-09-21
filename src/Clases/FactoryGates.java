package Clases;

public class FactoryGates {
	
	public static LogicGate newlogicGate(String type) {
		if(type.equals("file:and.png")) {
		return new And(type);
		}
		else if(type.equals("file:nand.png")) {
		return new Nand(type);
		}
		else if(type.equals("file:nor.png")) {
		return new Nor(type);
		}
		else if(type.equals("file:xor.png")) {
		return new Xor(type);
		}
		else if(type.equals("file:or.png")) {
		return new Or(type);
		}
		else if(type.equals("file:not.png")) {
		return new Not(type);
		}
		else {
		return new Xnor(type);
		}
		
	
	}

}
