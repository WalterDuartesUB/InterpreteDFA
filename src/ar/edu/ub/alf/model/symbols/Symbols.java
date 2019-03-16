package ar.edu.ub.alf.model.symbols;

import java.util.HashMap;
import java.util.Map;

import ar.edu.ub.alf.model.exceptions.SymbolNotFoundException;
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
	public ISymbol get(String value) throws SymbolNotFoundException{
		ISymbol s = this.getSymbols().get(value);
		
		if( s == null )
			throw new SymbolNotFoundException();
		
		return s;
	}

	private Map<String, ISymbol> getSymbols() {
		return symbols;
	}

	private void setSymbols(Map<String, ISymbol> symbols) {
		this.symbols = symbols;
	}

}
