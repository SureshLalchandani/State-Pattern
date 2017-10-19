package airportSecurityState.airportStates;

import airportSecurityState.util.MyLogger;
import airportSecurityState.util.MyLogger.DebugLevel;

/**
 * A state class which handles the Moderate Risk at airport
 * @author suresh
 *
 */
public class ModerateRisk implements AirportStatesI {
	
	public ModerateRisk() {
		MyLogger.writeMessage("ModerateRisk Constructor is called", DebugLevel.CONSTRUCTOR);
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
		return "2 3 5 8 9";
	}
	
	@Override
	public String toString() {
		return "Moderate Risk";
	}

}
