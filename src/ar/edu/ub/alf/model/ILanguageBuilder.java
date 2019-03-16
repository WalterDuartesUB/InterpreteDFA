package ar.edu.ub.alf.model;

public class ILanguageBuilder {

	public ILanguage build() {
		ISymbols symbols = this.buildSymbols();
		IStates states = this.buildStates();
		
		return new Language(symbols, states);
	}

	private IStates buildStates() { 
		return new States();
	}

	private ISymbols buildSymbols() {
		return new Symbols();
	}

}
