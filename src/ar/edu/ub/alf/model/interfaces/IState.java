package ar.edu.ub.alf.model.interfaces;

public interface IState {
	public String getValue();	
	public boolean isInitialState();
	public boolean isAcceptanceState();
	
	public IState getNextState(ISymbol symbol);
}
