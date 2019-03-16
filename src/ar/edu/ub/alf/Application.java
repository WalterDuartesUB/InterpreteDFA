package ar.edu.ub.alf;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import ar.edu.ub.alf.model.LanguageBuilder;
import ar.edu.ub.alf.model.exceptions.CommandLineException;
import ar.edu.ub.alf.model.exceptions.DFAException;
import ar.edu.ub.alf.model.interfaces.ILanguage;

public class Application {
	public static void main(String[] args) {
		new Application().run(args);
	}

	private void run(String[] args) {		
		try {
			CommandLine cmd = this.builtCommandLine(args);
			ILanguage lang = this.createLanguage( cmd.getOptionValue("dfaConfiguration"));						
			System.out.println( lang.evaluate( cmd.getOptionValue("word") ) );
		} catch (DFAException e) {		
			e.printStackTrace();
		} catch(CommandLineException cle) {
			
		}
	}

	private CommandLine builtCommandLine(String[] args) throws CommandLineException{
        Options options = new Options();

        //File with the definition of the DFA
        Option input = new Option("d", "dfaConfiguration", true, "dfa configuration file path");        
        input.setRequired(true);
        options.addOption(input);
        
        //Word to evaluate
        input = new Option("w", "word", true, "word to evaluate");
        input.setRequired(false);        
        options.addOption(input);

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        
        try {
            return parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("utility-name", options);            
            throw new CommandLineException();
        }
	}

	private ILanguage createLanguage(String dfaConfigurationFilePath) throws DFAException {
		return new LanguageBuilder(dfaConfigurationFilePath).build();
	}
}
