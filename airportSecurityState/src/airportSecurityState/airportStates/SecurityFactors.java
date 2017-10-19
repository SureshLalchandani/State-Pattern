package airportSecurityState.airportStates;

import java.util.Arrays;

import airportSecurityState.util.FileProcessor;
import airportSecurityState.util.MyLogger;
import airportSecurityState.util.Results;
import airportSecurityState.util.MyLogger.DebugLevel;

/**
 * Controller class which communicates with the AirportSecurity context class and pass
 * message with the Security Factors parameters.
 * @author suresh
 *
 */
public class SecurityFactors {

	FileProcessor fileProcessor;
	Results results;
	String[] prohibitedItems = {"Gun", "NailCutter", "Blade", "Knife"};

	AirportSecurity airportSecurity = new AirportSecurity();

	public SecurityFactors(FileProcessor fileProcessorIn, Results resultsIn) {
		MyLogger.writeMessage("SecurityFactor Constructor is called", DebugLevel.CONSTRUCTOR);
		fileProcessor = fileProcessorIn;
		results = resultsIn;
	}

	/**
	 * Iterate through the input file and evaluate security measures for 
	 * every passenger
	 */
	public void process() {

		String line = null;
		int numPassenger = 0;
		int numprohibitedItems = 0;
		
		while((line = fileProcessor.readLine()) != null) {
			String[] components = line.split(";");
			try {

				String[] day = components[0].split(":");
				int dayInt = Integer.parseInt(day[1]);
				String[] item = components[3].split(":");
				numPassenger += 1;

				if(Arrays.asList(prohibitedItems).contains(item[1])) {
					numprohibitedItems += 1;
				}

				eveluate(dayInt, numPassenger, numprohibitedItems);
			} catch (Exception e) {
				MyLogger.writeMessage("SecurityFactors:evaluate - " + e.getMessage(), MyLogger.DebugLevel.ERROR);
				System.exit(0);
			}
		}
		
		results.writeToFile();

	}


	/**
	 * Evaluate the factors and send message to Airport Security to check for Tighten or Loosen security
	 * @param day
	 * @param numPass
	 * @param prohibitedCount
	 */
	private void eveluate(int day, int numPass, int prohibitedCount) {

		int averageTrafficPerDay = numPass / day;
		int averageProhibitedItemsPerDay = prohibitedCount / day;

		airportSecurity.tightenOrLoosenSecurity(averageTrafficPerDay, averageProhibitedItemsPerDay);
		
		results.storeNewResult(airportSecurity.operations());
	}





}
