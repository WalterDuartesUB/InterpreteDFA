package ar.edu.ub.alf.model;

public class Language implements ILanguage{

	private ISymbols symbols;
	private IStates states;
	
	public Language(ISymbols symbols, IStates states) {
		this.setStates(states);
		this.setSymbols(symbols);
	}

	@Override
	public ISymbol evaluate(String aString) {
		return new Symbol();
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
