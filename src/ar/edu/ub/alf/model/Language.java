package ar.edu.ub.alf.model;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Language implements ILanguage{

	private ISymbols symbols;
	private IStates states;
	
	public Language(ISymbols symbols, IStates states) {
		this.setStates(states);
		this.setSymbols(symbols);
	}

	@Override
	public IState evaluate(String aString) {
		
		IState s = this.getStates().getInitialState();
		
		Collection<ISymbol> symbols = this.getSymbols( aString );		
		
		for( ISymbol symbol : symbols )
			s = s.getNextState( symbol );
		
		return s;
	}

	private Collection<ISymbol> getSymbols(String aString) {
		List<ISymbol> listOfSymbols = new LinkedList<ISymbol>();
		
		listOfSymbols.add(this.getSymbols().get("a"));		
		listOfSymbols.add(this.getSymbols().get("b"));
		listOfSymbols.add(this.getSymbols().get("a"));
		listOfSymbols.add(this.getSymbols().get("a"));
		
		return listOfSymbols;
	}

	public IStates getStates() {
		return states;
	}

	private void setStates(IStates states) {
		this.states = states;
	}

	public ISymbols getSymbols() {
		return symbols;
	}

	private void setSymbols(ISymbols symbols) {
		this.symbols = symbols;
	}

}
