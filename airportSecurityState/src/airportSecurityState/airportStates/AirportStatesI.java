package airportSecurityState.airportStates;

public interface AirportStatesI {
	
	public AirportStatesI tightenOrLoosenSecurity(int averageTrafficPerDay, int averageProhibitedItemsPerday);
	public void operations();

}
