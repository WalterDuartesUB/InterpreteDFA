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
		
		states.add( new State("Q"));
		states.add( new State("P"));
		states.add( new State("R"));
		states.add( new State("ERROR"));		
		
		return states;
	}

	private ISymbols buildSymbols() {
		 Symbols symbols = new Symbols();
		 
		 symbols.add( new Symbol("a") );
		 symbols.add( new Symbol("b") );
		 
		 return symbols;
	}
}
