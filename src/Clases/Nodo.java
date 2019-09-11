package Clases;

public class Nodo {
	
	Nodo next;
	Nodo type;

	@SuppressWarnings("null")
	public Nodo(Nodo logicGate, Nodo next) {
		this.next = next;
		this.type = logicGate;

	}
	
	
	public Nodo getNext() {
		return next;
	}
	
	public void setNext(Nodo next) {
		this.next = next;
	}
	
}


	
