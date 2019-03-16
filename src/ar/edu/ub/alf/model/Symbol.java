package ar.edu.ub.alf.model;

import ar.edu.ub.alf.model.interfaces.ISymbol;

public class Symbol implements ISymbol {
	private String value;
	
	public Symbol(String value) {
		this.setValue(value);
	}

	@Override
	public String toString() { 
		return super.toString();
	}

	@Override
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
