package ar.edu.ub.alf.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import ar.edu.ub.alf.model.exceptions.DFAException;
import ar.edu.ub.alf.model.exceptions.InvalidDFAFileException;
import ar.edu.ub.alf.model.exceptions.SymbolNotFoundException;
import ar.edu.ub.alf.model.interfaces.ILanguage;
import ar.edu.ub.alf.model.interfaces.ILanguageBuilder;
import ar.edu.ub.alf.model.interfaces.IStates;
import ar.edu.ub.alf.model.interfaces.ISymbols;
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
		States states = this.buildStatesFromString(lines.get(1) );

		// Binding states
		for( int i = 3; i < lines.size(); i++ )
			this.bindNextStateFromLine(states, symbols, lines.get(i));

		return states;
	}

	private void bindNextStateFromLine(States states, ISymbols symbols, String line) throws StateNotFoundException, SymbolNotFoundException {
		String[] fields = line.split(" ");
		
		states.get(fields[0]).setNextState(symbols.get(fields[1]), states.get(fields[2]));
	}

	private States buildStatesFromString(String line) {
		States states = new States();

		String[] s = line.split(" ");
		
		// build the initial state
		states.add(new InitialState(s[0]));
		
		// build of the states
		for( int i = 1; i < s.length; i ++ )
			states.add(new State( s[i] ));
		
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
