package ar.edu.ub.alf.model;

public class Symbol implements ISymbol {
	private String value;
	
	public Symbol(String value) {
		this.setValue(value);
	}

	@Override
	public String toString() { 
		return super.toString();
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
