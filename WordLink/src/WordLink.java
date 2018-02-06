
/* SELF ASSESSMENT

1. readDictionary
- I have the correct method definition [Mark out of 5:5]
- Comment:The function takes a filename and returns an ArrayList of all of the words in that file.
- My method reads the words from the "words.txt" file. [Mark out of 5:5]
- Comment:Yes it reads the words from the file it is passed.
- It returns the contents from "words.txt" in a String array or an ArrayList. [Mark out of 5:5]
- Comment:Yes it returns the contents in an ArrayList.

2. readWordList
- I have the correct method definition [Mark out of 5:5]
- Comment:Yes the function takes a comma separated String of words and returns a string array of the words. 
- My method reads the words provided (which are separated by commas, saves them to an array or ArrayList of String references and returns it. [Mark out of 5:5]
- Comment:Yes, it returns the separated words in an ArrayList.

3. isUniqueList
- I have the correct method definition [Mark out of 5:5]
- Comment:The function takes an Array and returns a boolean.
- My method compares each word in the array with the rest of the words in the list. [Mark out of 5:5]
- Comment:Yes it compares each word to the rest of the array.
- Exits the loop when a non-unique word is found. [Mark out of 5:5]
- Comment:The loop is exited when a non-unique word is found.
- Returns true is all the words are unique and false otherwise. [Mark out of 5:5]
- Comment:Returns true if words are unique and false otherwise.

4. isEnglishWord
- I have the correct method definition [Mark out of 5:5]
- Comment:Yes it takes a string and ArrayList and returns a boolean.
- My method uses the binarySearch method in Arrays library class. [Mark out of 3:3]
- Comment:No, it was a hint not a requirement. I used the ArrayList.contains method. The function is the same.
- Returns true if the binarySearch method return a value >= 0, otherwise false is returned. [Mark out of 2:2]
- Comment:I used the returned value of the ArrayList.contains method. The function is the same.

5. isDifferentByOne
- I have the correct method definition [Mark out of 5:5]
- Comment:Yes the function takes two Strings and returns a boolean.
- My method loops through the length of a words comparing characters at the same position in both words searching for one difference. [Mark out of 10:10]
- Comment:The function checks if there is a 1 character difference and returns true if there is.

6. isWordChain
- I have the correct method definition [Mark out of 5:]
- Comment:
- My method calls isUniqueList, isEnglishWord and isDifferentByOne methods and prints the appropriate message [Mark out of 10:]
- Comment:

7. main
- Reads all the words from file words.txt into an array or an ArrayList using the any of teh Java.IO classes covered in lectures [Mark out of 10:10]
- Comment:The function reads the words from the file and puts them into an ArrayList using the java.io.bufferedreader class.
- Asks the user for input and calls isWordChain [Mark out of 5:5]
- Comment:The function asks the user for input and calls isWordChain.

 Total Mark out of 100 (Add all the previous marks):100
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class WordLink {
	public static final int NUMBER_OF_WORDS = 658964;

	public static void main(String[] args) {
		ArrayList<String> wordList = readDictionary("src\\wordList.txt");
		boolean finished = false;
		Scanner userInputScanner = new Scanner(System.in);
		while (!finished) {
			System.out.print("Please enter the list of words to be checked or press enter to exit: ");
			if (userInputScanner.hasNextLine()) {
				String userInput = userInputScanner.nextLine();
				if (isWordChain(readWordList(userInput), wordList)) {
					System.out.println("The word string is valid.");
				} else {
					if (userInput.equals(""))
						finished = true;
					else
						System.out.println("The word string is not valid.");
				}
			}
		}
		userInputScanner.close();
		System.out.print("Goodbye...");
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

	public static boolean isEnglishWord(String wordToCheck, ArrayList<String> wordList) {
		return wordList.contains(wordToCheck);
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

	public static boolean isWordChain(String[] inputList, ArrayList<String> wordList) {
		if (inputList.length > 1) {
			for (int index = 0; index < inputList.length - 1; index++) {
				if (!isDifferentByOne(inputList[index], inputList[index + 1])
						|| !isEnglishWord(inputList[index], wordList) || !isUniqueList(inputList))
					return false;
			}
			return true;
		}
		return false;
	}
}
