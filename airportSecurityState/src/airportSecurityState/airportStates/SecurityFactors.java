package airportSecurityState.airportStates;

import java.util.Arrays;

import airportSecurityState.util.FileProcessor;
import airportSecurityState.util.MyLogger;

public class SecurityFactors {

	FileProcessor fileProcessor;
	String[] prohibitedItems = {"Gun", "NailCutter", "Blade", "Knife"};

	AirportSecurity airportSecurity = new AirportSecurity();

	public SecurityFactors(FileProcessor fileProcessorIn) {
		fileProcessor = fileProcessorIn;
	}

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
			} catch (NumberFormatException e) {
				MyLogger.writeMessage("SecurityFactors:evaluate - Number Format Exception occured", MyLogger.DebugLevel.ERROR);
				System.exit(0);
			}
		}

	}


	private void eveluate(int day, int numPass, int prohibitedCount) {

		int averageTrafficPerDay = numPass / day;
		int averageProhibitedItemsPerDay = prohibitedCount / day;

		airportSecurity.tightenOrLoosenSecurity(averageTrafficPerDay, averageProhibitedItemsPerDay);

	}





}
