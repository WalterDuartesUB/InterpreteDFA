package ar.edu.ub.alf.model.interfaces;

import ar.edu.ub.alf.model.exceptions.DFAException;

public interface ILanguage {

	IState evaluate(String aString) throws DFAException;

	ISymbols getSymbols();

	IStates getStates();

}
