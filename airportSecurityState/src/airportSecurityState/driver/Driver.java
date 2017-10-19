package airportSecurityState.driver;

import airportSecurityState.airportStates.SecurityFactors;
import airportSecurityState.util.FileProcessor;
import airportSecurityState.util.MyLogger;
import airportSecurityState.util.Results;
import airportSecurityState.util.FileProcessor.Permission;

/**
 * This is a driver/entry of the program i.e main class.
 * @author suresh
 *
 */
public class Driver {

	/**
	 * Entry of the program : Performs command line argument check and validation. The process the inputs as per requirement. 
	 * @param args
	 */
	public static void main(String[] args) {

		if(args == null || args.length != 3) {
			System.err.println("Please provide valid number of arguments. 3 Arguments are expected: \n1.Input File \n2.Output File \n3.Log Level");
			System.exit(0);
			return;
		}

		if((args[0].trim().length() == 0 || args[0].contains("${arg0}")) || 
				(args[1].trim().length() == 0 || args[1].contains("${arg1}")) || 
				(args[2].trim().length() == 0 || args[2].contains("${arg2}"))) {

			System.err.println("Please provide valid number of arguments. 3 Arguments are expected: \n1.Input File \n2.Output File \n3.Log Level");
			System.exit(0);
			return;
		}


		String inputFile = args[0];
		String outputFile = args[1];
		String debugLevel = args[2];
		int logLevel = -1;

		try {
			logLevel = Integer.parseInt(debugLevel);
		} catch (NumberFormatException e) {
			System.err.println("Invalid Log level found in the command");
			System.exit(1);
		}
		
		MyLogger.setDebugValue(logLevel);
		
		FileProcessor inputFileProcess = new FileProcessor(inputFile, Permission.READ);
		inputFileProcess.allowEmptyFile(false);
		
		Results results = new Results(outputFile);
		SecurityFactors factors = new SecurityFactors(inputFileProcess, results);
		factors.process();
		
		


	}

}
