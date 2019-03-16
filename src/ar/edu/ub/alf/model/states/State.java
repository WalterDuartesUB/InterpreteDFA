package ar.edu.ub.alf.model.states;

import java.util.HashMap;
import java.util.Map;

import ar.edu.ub.alf.model.interfaces.IState;
import ar.edu.ub.alf.model.interfaces.ISymbol;
import ar.edu.ub.alf.util.Asserts;

public class State implements IState {
	private String value;
	private boolean acceptanceState;
	private boolean initialState;
	
	private Map<ISymbol, IState> nextStates;
	
	public State(String value, boolean initialState) {
		this.setValue(value);
		this.setInitialState(initialState);
		this.setNextStates( new HashMap<ISymbol,IState>());
	}
	
	public State(String value) {
		this( value, false);
	}

	@Override
	public String getValue() {
		return value;
	}
	
	private void setValue(String value) {
		Asserts.checkNullOrEmpty(value);
		this.value = value;
	}

	@Override
	public String toString() {
		return "State [value=" + value + ", acceptanceState=" + acceptanceState + ", initialState=" + initialState + "]";
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

	@Override
	public boolean isAcceptanceState() {
		return acceptanceState;
	}

	public void setAcceptanceState(boolean acceptanceState) {
		this.acceptanceState = acceptanceState;
	}

	@Override
	public boolean isInitialState() {
		return initialState;
	}

	public void setInitialState(boolean initialState) {
		this.initialState = initialState;
	}


}
