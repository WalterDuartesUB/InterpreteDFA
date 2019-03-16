package ar.edu.ub.alf.model;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import ar.edu.ub.alf.model.exceptions.DFAException;
import ar.edu.ub.alf.model.interfaces.ILanguage;
import ar.edu.ub.alf.model.interfaces.IState;
import ar.edu.ub.alf.model.interfaces.IStates;
import ar.edu.ub.alf.model.interfaces.ISymbol;
import ar.edu.ub.alf.model.interfaces.ISymbols;

public class Language implements ILanguage{

	private ISymbols symbols;
	private IStates states;
	
	public Language(ISymbols symbols, IStates states) {
		this.setStates(states);
		this.setSymbols(symbols);
	}

	@Override
	public IState evaluate(String aString) throws DFAException{
		
		IState s = this.getStates().getInitialState();
		
		Collection<ISymbol> symbols = this.getSymbols( aString );		
		
		for( ISymbol symbol : symbols )
			s = s.getNextState( symbol );
		
		return s;
	}

	private Collection<ISymbol> getSymbols(String aString) throws DFAException {
		List<ISymbol> listOfSymbols = new LinkedList<ISymbol>();
		
		for( int i = 0; i < aString.length(); i ++ )			
			listOfSymbols.add(this.getSymbols().get(String.valueOf(aString.charAt(i))));
		
		return listOfSymbols;
	}

	@Override
	public IStates getStates() {
		return states;
	}

	private void setStates(IStates states) {
		this.states = states;
	}

	@Override
	public ISymbols getSymbols() {
		return symbols;
	}

	private void setSymbols(ISymbols symbols) {
		this.symbols = symbols;
	}

}
