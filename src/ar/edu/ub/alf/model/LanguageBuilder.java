package ar.edu.ub.alf.model;

public class LanguageBuilder implements ILanguageBuilder{

	@Override
	public ILanguage build(){
		ISymbols symbols = this.buildSymbols();
		IStates states = this.buildStates(symbols);
		
		return new Language(symbols, states);
	}

	private IStates buildStates(ISymbols symbols) { 
		return new States();
	}

	private ISymbols buildSymbols() {
		 Symbols symbols = new Symbols();
		 
		 symbols.add( new Symbol("a") );
		 symbols.add( new Symbol("b") );
		 
		 return symbols;
	}
}
