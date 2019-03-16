package ar.edu.ub.alf;

import ar.edu.ub.alf.model.LanguageBuilder;
import ar.edu.ub.alf.model.exceptions.DFAException;
import ar.edu.ub.alf.model.interfaces.ILanguage;

public class Application {
	public static void main(String[] args) {
		new Application().run();
	}

	private void run() {		
		try {
			ILanguage lang = this.createLanguage();
			String aString = "aab";
			
			System.out.println( lang.evaluate( aString ) );
		} catch (DFAException e) {		
			e.printStackTrace();
		}
	}

	private ILanguage createLanguage() throws DFAException {
		return new LanguageBuilder().build();
	}
}
