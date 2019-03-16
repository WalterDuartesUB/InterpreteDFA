package ar.edu.ub.alf;

import ar.edu.ub.alf.model.LanguageBuilder;
import ar.edu.ub.alf.model.interfaces.ILanguage;

public class Application {
	public static void main(String[] args) {
		new Application().run();
	}

	private void run() {
		ILanguage lang = this.createLanguage();
		String aString = "aab";
		
		System.out.println( lang.evaluate( aString ) );
	}

	private ILanguage createLanguage() {
		return new LanguageBuilder().build();
	}
}
