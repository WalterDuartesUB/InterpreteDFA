package ar.edu.ub.alf.model.interfaces;

public interface IState {

	String getValue();

	IState getNextState(ISymbol symbol);

}
