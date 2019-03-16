package ar.edu.ub.alf.model;

public interface IState {

	String getValue();

	IState getNextState(ISymbol symbol);

}
