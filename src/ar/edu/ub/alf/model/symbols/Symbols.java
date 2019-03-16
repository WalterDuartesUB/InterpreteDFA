package ar.edu.ub.alf.model.symbols;

import java.util.HashMap;
import java.util.Map;

import ar.edu.ub.alf.model.interfaces.ISymbol;
import ar.edu.ub.alf.model.interfaces.ISymbols;

public class Symbols implements ISymbols {

	private Map<String, ISymbol> symbols;
	
	public Symbols() {
		this.setSymbols( new HashMap<String, ISymbol>());
	}

	public void add(ISymbol symbol) {
		this.getSymbols().put(symbol.getValue(), symbol);		
	}

	@Override
	public ISymbol get(String value) {
		return this.getSymbols().get(value);
	}

	private Map<String, ISymbol> getSymbols() {
		return symbols;
	}

	private void setSymbols(Map<String, ISymbol> symbols) {
		this.symbols = symbols;
	}

}
