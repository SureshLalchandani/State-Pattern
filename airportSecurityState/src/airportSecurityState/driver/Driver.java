package airportSecurityState.driver;


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
			System.err.println("Please provide valid number of arguments. 5 Arguments are expected: \n1.Input File \n2.Delete File \n3.Output1 File \n4.Output2 File \n5.Output3 File");
			System.exit(0);
			return;
		}

		if((args[0].trim().length() == 0 || args[0].contains("${arg0}")) || 
				(args[1].trim().length() == 0 || args[1].contains("${arg1}")) || 
				(args[2].trim().length() == 0 || args[2].contains("${arg2}"))) {
			
			System.err.println("Please provide valid number of arguments. 5 Arguments are expected: \n1.Input File \n2.Delete File \n3.Output1 File \n4.Output2 File \n5.Output3 File");
			System.exit(0);
			return;
		}

	}

}
