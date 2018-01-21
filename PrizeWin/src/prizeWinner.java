// This program was a problem given in a tutorial, it is designed to compute the winner of race. The first three places and then every prime number thereafter
// 16-11-2017 @ 00:08 - dartse
public class prizeWinner {

	public static void main(String[] args) {
		String stringToPrint = "";
		int numberOfCompetitors = 25;
		for (int currentNumber = 1; currentNumber < numberOfCompetitors; currentNumber++) {

			// Determines if a number is prime.
			boolean isPrime = true;
			for (int primeCounter = 2; currentNumber > primeCounter && isPrime; primeCounter++) {
				if (currentNumber % primeCounter == 0)
					isPrime = false;
			}

			// Get a value for calculations
			int tempCurrentNumber = currentNumber;
			while (tempCurrentNumber > 100)
				tempCurrentNumber -= 100;

			// The meat and potatoes. If it's number 1 add that to the string, otherwise check if it's prime and add if so add that to the string.
			String endingToPrint = "th";
			if (currentNumber == 1) {
				stringToPrint += "1st";
			} else {
				if (isPrime) {
					switch (tempCurrentNumber) {
					case 1:
						endingToPrint = "st";
						break;
					case 2:
						endingToPrint = "nd";
						break;
					case 3:
						endingToPrint = "rd";
						break;
					default:
						if (tempCurrentNumber > 20) {
							int lastDigit = tempCurrentNumber % 10;
							switch (lastDigit) {
							case 1:
								endingToPrint = "st";
								break;
							case 2:
								endingToPrint = "nd";
								break;
							case 3:
								endingToPrint = "rd";
								break;
							}
						}
					}
					stringToPrint += ", " + currentNumber + endingToPrint;
				}
			}
		}
		System.out.println("The places that win prizes should be:");
		System.out.println(stringToPrint);
	}
}
