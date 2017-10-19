package airportSecurityState.airportStates;

import airportSecurityState.util.MyLogger;
import airportSecurityState.util.MyLogger.DebugLevel;

/**
 * This is the Context class for AirportSecurity states and by pass any call
 * or message to Current State that came from outside classes
 * @author suresh
 *
 */
public class AirportSecurity implements AirportStatesI{

	AirportStatesI state = new LowRisk();

	public AirportSecurity() {
		MyLogger.writeMessage("AirportSecurity Constructor is called", DebugLevel.CONSTRUCTOR);
	}

	@Override
	public AirportStatesI tightenOrLoosenSecurity(int averageTrafficPerDay, int averageProhibitedItemsPerday) {
		AirportStatesI stateOld = state;
		state = state.tightenOrLoosenSecurity(averageTrafficPerDay, averageProhibitedItemsPerday);
		
		if(!stateOld.getClass().equals(state.getClass())) {
			MyLogger.writeMessage(
					"State changed from " + stateOld.toString() + " to " + state.toString(), 
					DebugLevel.STATE);
		}
		
		return state;
	}

	@Override
	public String operations() {
		return state.operations();
	}
	

}
