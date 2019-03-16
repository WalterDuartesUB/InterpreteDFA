package ar.edu.ub.alf.model.states;

import java.util.HashMap;
import java.util.Map;

import ar.edu.ub.alf.model.interfaces.IStates;
import ar.edu.ub.alf.model.symbols.StateNotFoundException;

public class States implements IStates {
	
	private Map<String, State> states;
	private State initialState;
	
	public States() {
		this.setStates( new HashMap<String, State>() );
	}
	
	private void addState(State state) {
		this.getStates().put( state.getValue(), state );
	}
	
	public State get(String value) throws StateNotFoundException{
		State s = this.getStates().get(value);
		
		if( s == null )
			throw new StateNotFoundException();
		
		return s;
	}

	private Map<String, State> getStates() {
		return states;
	}

	private void setStates(Map<String, State> states) {
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
