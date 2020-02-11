
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Validator {

	public static String isCountry(Scanner scnr) {

		String response = scnr.nextLine();
		boolean looper = true;
		List<Country> countries = CountriesApp.fileHelper.readAll();

		while (looper) {

			for (Country c : countries) {
				if (c.toString().startsWith(response)) {
					return response;
				}
			}
			System.out.println("That country isn't on the list.  Please name another.");
			response = scnr.nextLine();
		}

		String result = scnr.nextLine();
		return result;
	}

	public static int getInt(Scanner scnr) {
		while (!scnr.hasNextInt()) {
			scnr.nextLine();
			System.out.println("Please enter a whole number, using digits.");
		}
		int result = scnr.nextInt();
		
		return result;
	}

	public static int getInt(Scanner scnr, int min, int max) {
		boolean isValid = false;
		int number;
		do {
			number = getInt(scnr);
			scnr.nextLine();
			if (number < min) {
				isValid = false;
				System.out.println("The number must be at least " + min);
			} else if (number > max) {
				isValid = false;
				System.out.println("The number must not be larger than " + max);
			} else {
				isValid = true;
			}

		} while (!isValid);
		return number;
	}

}
