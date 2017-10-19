package airportSecurityState.airportStates;

import airportSecurityState.util.MyLogger;
import airportSecurityState.util.MyLogger.DebugLevel;

/**
 * A state class which handles the High Risk at airport
 * @author suresh
 *
 */

public class HighRisk implements AirportStatesI {
	
	public HighRisk() {
		MyLogger.writeMessage("HighRisk Constructor is called", DebugLevel.CONSTRUCTOR);
	}

	@Override
	public AirportStatesI tightenOrLoosenSecurity(int averageTrafficPerDay, int averageProhibitedItemsPerday) {
		
		if((averageTrafficPerDay >= 8) || (averageProhibitedItemsPerday >= 2)) {
			return new HighRisk();
		} else if((averageTrafficPerDay >= 4 && averageTrafficPerDay < 8) ||
				averageProhibitedItemsPerday >= 1 && averageProhibitedItemsPerday < 2) {
			return new ModerateRisk();
		} else if((averageTrafficPerDay >= 0 && averageTrafficPerDay < 4) ||
				averageProhibitedItemsPerday >= 0 && averageProhibitedItemsPerday < 1) { 
			return new LowRisk();
		}
		
		return new LowRisk();
		
	}


	@Override
	public String operations() {
		return "2 4 6 8 10";
	}
	
	@Override
	public String toString() {
		return "High Risk";
	}

}
