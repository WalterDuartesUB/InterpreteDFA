package ar.edu.ub.alf.model.interfaces;

import ar.edu.ub.alf.model.exceptions.DFAException;

public interface ILanguageBuilder {

	public ILanguage build() throws DFAException;

}
