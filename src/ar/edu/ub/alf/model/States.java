package ar.edu.ub.alf.model;

import java.util.HashMap;
import java.util.Map;

public class States implements IStates {
	
	private Map<String, State> states;
	
	public States() {
		this.setStates( new HashMap<String, State>() );
	}
	
	public void add(State state) {
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
}
