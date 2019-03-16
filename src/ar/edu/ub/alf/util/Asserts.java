package ar.edu.ub.alf.util;

public class Asserts {

	public static void checkNullOrEmpty(String value) {
		checkNull(value);
		checkEmpty(value);	
	}
	
	private static void checkNull(Object value) {
		if( value == null )
			throw new RuntimeException();
	}

	private static void checkEmpty(String value) {
		if( value.trim().isEmpty() )
			throw new RuntimeException();		
	}
}
