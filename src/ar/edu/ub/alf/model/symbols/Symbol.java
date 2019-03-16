package ar.edu.ub.alf.model.symbols;

import ar.edu.ub.alf.model.interfaces.ISymbol;
import ar.edu.ub.alf.util.Asserts;

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

	private void setValue(String value) {
		Asserts.checkNullOrEmpty(value);
		this.value = value;
	}
}
