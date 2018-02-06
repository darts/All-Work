import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class WordLink {
	public static final int NUMBER_OF_WORDS = 658964;

	public static void main(String[] args) {
		// Relative pathing wasn't working.
		ArrayList<String> wordList = readDictionary("src\\wordList.txt");
		String[] wordArray = wordList.toArray(new String[wordList.size()]);
		boolean finished = false;
		Scanner userInputScanner = new Scanner(System.in);
		while(!finished) {
			System.out.print("Please enter the list of words to be checked or type '?quit' to exit: ");
			if(userInputScanner.hasNext()) {
				
			}
			
		}
	}

	public static ArrayList<String> readDictionary(String filename) {
		FileReader reader;
		ArrayList<String> wordList = new ArrayList<String>();
		try {
			reader = new FileReader(filename);
			BufferedReader buffReader = new BufferedReader(reader);
			for (int index = 0; index < NUMBER_OF_WORDS; index++) {
				wordList.add(buffReader.readLine());
			}
			buffReader.close();
			return wordList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return wordList;
	}

	public static String[] readWordList(String stringToParse) {
		return stringToParse.split(", ");
	}

	public static boolean isUniqueList(String[] listToCheck) {
		for (int index = 0; index < listToCheck.length; index++) {
			for (int counter = index; counter < listToCheck.length; counter++) {
				if (listToCheck[index].equals(listToCheck[counter]))
					return false;
			}
		}
		return true;
	}

	public static boolean isEnglishWord(String wordToCheck, String[] wordArray) {
		if (Arrays.binarySearch(wordArray, wordToCheck) < 0)
			return false;
		return true;
	}

	public static boolean isDifferentByOne(String firstWord, String secondWord) {
		if (firstWord.length() == secondWord.length()) {
			int diffCount = 0;
			for (int index = 0; index < firstWord.length(); index++) {
				if (firstWord.charAt(index) != secondWord.charAt(index))
					diffCount++;
				if (diffCount > 1)
					return false;
			}
			if (diffCount == 1)
				return true;
		}
		return false;
	}

	public static boolean isWordChain(String[] inputList, String[] wordArray) {
		for (int index = 0; index < inputList.length - 1; index++) {
			if (!isDifferentByOne(inputList[index], inputList[index + 1])
					|| !isEnglishWord(inputList[index], wordArray))
				return false;
		}
		return true;
	}
}
