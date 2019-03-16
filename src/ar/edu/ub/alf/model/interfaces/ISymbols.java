package ar.edu.ub.alf.model.interfaces;

import ar.edu.ub.alf.model.exceptions.SymbolNotFoundException;

public interface ISymbols {

	ISymbol get(String value) throws SymbolNotFoundException;

}
