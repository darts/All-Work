import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordLink {
	public static void main(String[] args) {
		String[] b = readDictionary("wordList.txt");
		for (int i = 0; i < b.length; i++) {
			//c.add(b[i]);
			System.out.println(b[i]);
		}
	}

	public static String[] readDictionary(String filename) {
		FileReader reader;
		try {
			reader = new FileReader("D:\\Eclipse\\WordLink\\src\\wordList.txt");
			BufferedReader buffReader = new BufferedReader(reader);
			String wordString = "";
			while (!wordString.equals(null)) {
				wordString = buffReader.readLine() + ",";
			}
			return readWordList(wordString);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new String[] { "ERROR" };
	}

	public static String[] readWordList(String stringToParse) {
		return stringToParse.split(",");
	}

}
