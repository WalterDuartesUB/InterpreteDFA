package ar.edu.ub.alf.model;

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
		states.get("Q").setNext( symbols.get("a"), states.get("P") );
		states.get("Q").setNext( symbols.get("b"), states.get("ERROR") );
		states.get("P").setNext( symbols.get("a"), states.get("R") );
		states.get("P").setNext( symbols.get("b"), states.get("ERROR") );
		states.get("R").setNext( symbols.get("a"), states.get("R") );
		states.get("R").setNext( symbols.get("b"), states.get("R") );
		states.get("ERROR").setNext( symbols.get("a"), states.get("ERROR") );
		states.get("ERROR").setNext( symbols.get("b"), states.get("ERROR") );
		
		return states;
	}

	private ISymbols buildSymbols() {
		 Symbols symbols = new Symbols();
		 
		 symbols.add( new Symbol("a") );
		 symbols.add( new Symbol("b") );
		 
		 return symbols;
	}
}
