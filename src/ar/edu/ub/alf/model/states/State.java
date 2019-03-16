package ar.edu.ub.alf.model.states;

import java.util.HashMap;
import java.util.Map;

import ar.edu.ub.alf.model.interfaces.IState;
import ar.edu.ub.alf.model.interfaces.ISymbol;

public class State implements IState {
	private String value;
	
	private Map<ISymbol, IState> nextStates;
	
	public State(String value) {
		this.setValue(value);
		this.setNextStates( new HashMap<ISymbol,IState>());
	}
	
	@Override
	public String getValue() {
		return value;
	}
	
	private void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return this.getValue();
	}

	public void setNextState(ISymbol iSymbol, IState state) {
		this.getNextStates().put(iSymbol, state);
	}

	@Override
	public IState getNextState(ISymbol symbol) {
		return this.getNextStates().get(symbol);
	}

	private Map<ISymbol, IState> getNextStates() {
		return nextStates;
	}

	private void setNextStates(Map<ISymbol, IState> nextStates) {
		this.nextStates = nextStates;
	}
}
