package Clases;

public class FactoryGates {
	
	public static LogicGate newlogicGate(String type) {
		if(type.equals("file:and.png")) {
		System.out.println("agrego and");
		return new And();
		}
		else if(type.equals("file:nand.png")) {
		System.out.println("agrego nand");
		return new Nand();
		}
		else if(type.equals("file:nor.png")) {
		System.out.println("agrego nor");
		return new Nor();
		}
		else if(type.equals("file:xor.png")) {
		System.out.println("agrego xor");
		return new Xor();
		}
		else if(type.equals("file:or.png")) {
		System.out.println("agrego or");
		return new Or();
		}
		else if(type.equals("file:not.png")) {
		System.out.println("agrego not");
		return new Not();
		}
		else {
		System.out.println("agrego xnor");
		return new Xnor();
		}
		
	
	}

}
