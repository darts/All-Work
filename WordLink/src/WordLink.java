import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class WordLink {
	public static void main(String[] args) {
		// Relative pathing wasn't working.
		ArrayList<String> wordList = readDictionary("D:\\Eclipse\\WordLink\\src\\wordList.txt");

	}

	public static ArrayList<String> readDictionary(String filename) {
		FileReader reader;
		ArrayList<String> wordList = new ArrayList<String>();
		try {
			reader = new FileReader(filename);
			BufferedReader buffReader = new BufferedReader(reader);
			for (int index = 0; index < 658964; index++) {
				wordList.add(buffReader.readLine());
				System.out.println(index);
			}
			return wordList;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return wordList;
	}

	public static String[] readWordList(String stringToParse) {
		return stringToParse.split(",");
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

	public static boolean isEnglishWord(String wordToCheck, ArrayList<String> comparisonList) {
		return true;
		// return false;
	}

	public static boolean isDifferentByOne(String firstWord, String secondWord) {
		if (firstWord.length() == secondWord.length()) {
			int diffCount = 0;
			for (int index = 0; index < firstWord.length(); index++) {
				if (firstWord.charAt(index) != firstWord.charAt(index))
					diffCount++;
				if (diffCount > 1)
					return false;
			}
			return true;
		}
		return false;
	}

	public static boolean isWordChain(String[] inputList, ArrayList<String> comparisonList) {
		for (int index = 0; index < inputList.length - 1; index++) {
			if(isDifferentByOne(inputList[index], inputList[index + 1])) {
				
			}
		}
		return true;

	}

}
