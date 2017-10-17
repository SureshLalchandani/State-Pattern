package airportSecurityState.airportStates;

public class AirportSecurity implements AirportStatesI{
	
	AirportStatesI state = new LowRisk();
	
	public AirportSecurity() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public AirportStatesI tightenOrLoosenSecurity(int averageTrafficPerDay, int averageProhibitedItemsPerday) {
		return state = state.tightenOrLoosenSecurity(averageTrafficPerDay, averageProhibitedItemsPerday);
	}

	@Override
	public void operations() {
		// TODO Auto-generated method stub
		
	}

}
