package ar.edu.ub.alf.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import ar.edu.ub.alf.model.exceptions.DFAException;
import ar.edu.ub.alf.model.exceptions.SymbolNotFoundException;
import ar.edu.ub.alf.model.interfaces.ILanguage;
import ar.edu.ub.alf.model.interfaces.ILanguageBuilder;
import ar.edu.ub.alf.model.interfaces.IStates;
import ar.edu.ub.alf.model.interfaces.ISymbols;
import ar.edu.ub.alf.model.states.AcceptanceState;
import ar.edu.ub.alf.model.states.InitialState;
import ar.edu.ub.alf.model.states.State;
import ar.edu.ub.alf.model.states.States;
import ar.edu.ub.alf.model.symbols.StateNotFoundException;
import ar.edu.ub.alf.model.symbols.Symbol;
import ar.edu.ub.alf.model.symbols.Symbols;

public class LanguageBuilder implements ILanguageBuilder {

	private String dfaConfigurationFilePath;

	public LanguageBuilder(String dfaConfigurationFilePath) {
		this.setDfaConfigurationFilePath(dfaConfigurationFilePath);
	}

	@Override
	public ILanguage build() throws DFAException {
		List<String> lines = getFileLines();
		ISymbols symbols = this.buildSymbols(lines.get(0));
		IStates states = this.buildStates(symbols, lines);

		return new Language(symbols, states);
	}

	private List<String> getFileLines() throws InvalidDFAFileException {
		try {
			return Files.readAllLines(Paths.get(this.getDfaConfigurationFilePath()));
		} catch (IOException e) {
			throw new InvalidDFAFileException();
		}
	}

	private IStates buildStates(ISymbols symbols, List<String> lines) throws SymbolNotFoundException, StateNotFoundException {
		States states = new States();

		// build of the states
		states.add(new InitialState("Q"));
		states.add(new State("P"));
		states.add(new AcceptanceState("R"));
		states.add(new State("ERROR"));

		// Binding states
		states.get("Q").setNextState(symbols.get("a"), states.get("P"));
		states.get("Q").setNextState(symbols.get("b"), states.get("ERROR"));
		states.get("P").setNextState(symbols.get("a"), states.get("R"));
		states.get("P").setNextState(symbols.get("b"), states.get("ERROR"));
		states.get("R").setNextState(symbols.get("a"), states.get("R"));
		states.get("R").setNextState(symbols.get("b"), states.get("R"));
		states.get("ERROR").setNextState(symbols.get("a"), states.get("ERROR"));
		states.get("ERROR").setNextState(symbols.get("b"), states.get("ERROR"));

		return states;
	}

	private ISymbols buildSymbols(String symbolsLine) {
		Symbols symbols = new Symbols();

		for (int i = 0; i < symbolsLine.length(); i++)
			symbols.add(new Symbol(String.valueOf(symbolsLine.charAt(i))));

		return symbols;
	}

	private String getDfaConfigurationFilePath() {
		return dfaConfigurationFilePath;
	}

	private void setDfaConfigurationFilePath(String dfaConfigurationFilePath) {
		this.dfaConfigurationFilePath = dfaConfigurationFilePath;
	}
}
