package ar.edu.ub.alf.model;

public class State implements IState {
	private String value;
	
	public State(String value) {
		this.setValue(value);
	}
	
	@Override
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return this.getValue();
	}

	public void setNext(ISymbol iSymbol, IState state) {
		
	}
}
