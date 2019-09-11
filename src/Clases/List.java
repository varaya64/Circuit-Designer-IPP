package Clases;

public class List{
	
	private Nodo first;
	private Nodo last;
	
	public List() {
		first = null;
		last = null;
		
	}
	
	public boolean vacia() {
		if (first==null) {
			return true;
		}
		else {
			return false;
		}
	}

	Nodo temp;
	public void addLast(Nodo logicGate) {
		if (vacia()) {
			temp = new Nodo(logicGate, null);
			first = temp;
			last = temp;
		}
	}

}
