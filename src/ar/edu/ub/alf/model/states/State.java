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
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return this.getValue();
	}

	public void setNext(ISymbol iSymbol, IState state) {
		this.getNextStates().put(iSymbol, state);
	}

	@Override
	public IState getNextState(ISymbol symbol) {
		return this.getNextStates().get(symbol);
	}

	public Map<ISymbol, IState> getNextStates() {
		return nextStates;
	}

	public void setNextStates(Map<ISymbol, IState> nextStates) {
		this.nextStates = nextStates;
	}
}
