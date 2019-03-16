package ar.edu.ub.alf.model;

import java.util.HashMap;
import java.util.Map;

import ar.edu.ub.alf.model.interfaces.IStates;

public class States implements IStates {
	
	private Map<String, State> states;
	private State initialState;
	
	public States() {
		this.setStates( new HashMap<String, State>() );
	}
	
	private void addState(State state) {
		this.getStates().put( state.getValue(), state );
	}

	State get(String value){
		return this.getStates().get(value);		
	}

	public Map<String, State> getStates() {
		return states;
	}

	public void setStates(Map<String, State> states) {
		this.states = states;
	}

	public void add(InitialState initialState) {
		this.setInitialState(initialState);
		this.addState(initialState);
	}

	public void add(AcceptanceState acceptanceState) {		
		this.addState(acceptanceState);
	}

	public void add(State state) {
		this.addState(state);		
	}

	@Override
	public State getInitialState() {
		return initialState;
	}

	public void setInitialState(State initialState) {
		this.initialState = initialState;
	}
}
