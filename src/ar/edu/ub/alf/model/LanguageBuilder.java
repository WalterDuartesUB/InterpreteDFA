package ar.edu.ub.alf.model;

import ar.edu.ub.alf.model.interfaces.ILanguage;
import ar.edu.ub.alf.model.interfaces.ILanguageBuilder;
import ar.edu.ub.alf.model.interfaces.IStates;
import ar.edu.ub.alf.model.interfaces.ISymbols;
import ar.edu.ub.alf.model.states.AcceptanceState;
import ar.edu.ub.alf.model.states.InitialState;
import ar.edu.ub.alf.model.states.State;
import ar.edu.ub.alf.model.states.States;
import ar.edu.ub.alf.model.symbols.Symbol;
import ar.edu.ub.alf.model.symbols.Symbols;

public class LanguageBuilder implements ILanguageBuilder{

	@Override
	public ILanguage build(){
		ISymbols symbols = this.buildSymbols();
		IStates states = this.buildStates(symbols);
		
		return new Language(symbols, states);
	}

	private IStates buildStates(ISymbols symbols) { 
		States states = new States();
		
		states.add( new InitialState("Q"));
		states.add( new State("P"));
		states.add( new AcceptanceState("R"));
		states.add( new State("ERROR"));
		
		//Binding states
		states.get("Q").setNextState( symbols.get("a"), states.get("P") );
		states.get("Q").setNextState( symbols.get("b"), states.get("ERROR") );
		states.get("P").setNextState( symbols.get("a"), states.get("R") );
		states.get("P").setNextState( symbols.get("b"), states.get("ERROR") );
		states.get("R").setNextState( symbols.get("a"), states.get("R") );
		states.get("R").setNextState( symbols.get("b"), states.get("R") );
		states.get("ERROR").setNextState( symbols.get("a"), states.get("ERROR") );
		states.get("ERROR").setNextState( symbols.get("b"), states.get("ERROR") );
		
		return states;
	}

	private ISymbols buildSymbols() {
		 Symbols symbols = new Symbols();
		 
		 symbols.add( new Symbol("a") );
		 symbols.add( new Symbol("b") );
		 
		 return symbols;
	}
}
