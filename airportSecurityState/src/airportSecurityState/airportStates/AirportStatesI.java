package airportSecurityState.airportStates;

public interface AirportStatesI {
	
	/**
	 * A method that needs to be implemented by all State classes and calculate the 
	 * next level of Airport Risk State
	 * @param averageTrafficPerDay
	 * @param averageProhibitedItemsPerday
	 * @return {@link AirportStatesI}
	 */
	public AirportStatesI tightenOrLoosenSecurity(int averageTrafficPerDay, int averageProhibitedItemsPerday);
	
	/**
	 * A method that needs to be implemented by all State classes and 
	 * perform Operations according to their Risk level
	 * @return String represents the set of all operations
	 */
	public String operations();

}
