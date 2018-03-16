import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ClubManager {
	
	public static void main(String[] args) {
		ArrayList<ClubMember> clubMemberList = new ArrayList<ClubMember>();
		readMembersFromFile(clubMemberList);
	}

	public void printMembers(ArrayList<ClubMember> clubMembersList) {

	}

	public static void readMembersFromFile(ArrayList<ClubMember> clubMemberList) {
		FileReader reader;
		try {
			reader = new FileReader("Members.txt");
			BufferedReader buffReader = new BufferedReader(reader);
			boolean endFound = false;
			while (!endFound) {
				String memberData = buffReader.readLine();
				if (memberData == null) {
					endFound = true;
				} else {
					String[] memberInfo = memberData.split(",");
					clubMemberList.add(new ClubMember(memberInfo[0], memberInfo[1], Integer.parseInt(memberInfo[2]), memberInfo[3]));
				}
			}
			buffReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
