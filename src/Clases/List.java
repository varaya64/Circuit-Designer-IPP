package Clases;

public class List{
	
	private LogicGate first;
	private LogicGate last;

	public List() {
	}
	
	public void addLast(String type) {
		LogicGate node = FactoryGates.newlogicGate(type);
		if (first == null && last==null) {
			first = node;
			last = node;
		}else {
			last.setNext(node);
			node.setPrev(first);
			last = node;
		}
	
	
	}
	
	public void conectionNodes() {
		
	}
	
	
}
