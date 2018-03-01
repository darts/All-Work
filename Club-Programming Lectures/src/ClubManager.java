import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ClubManager {
	public static final int NAME_INDEX = 0;
	public static final int ADDRESS_INDEX = 1;
	public static final int YEAR_OF_REG_INDEX = 2;
	public static final int EMAIL_INDEX = 3;
	public static int groupId = 101;
	
	public static void main(String[] args) {
		ArrayList<ClubMember> clubMemberList = new ArrayList<ClubMember>();
		ArrayList<Group> groupList = new ArrayList<Group>();
		boolean finished = false;
		ClubManager manager = new ClubManager();
		while(!finished) {
			System.out.println("Please select 1 to create a group, 2 to view club members, 3 to view details of a member.........");
			
			//create a group and provide group description
			String groupDesc = "Test";
			groupList.add(manager.CreateGroup(groupId++, groupDesc));
			
			//manager wants to see club members
			manager.printMembers(clubMemberList);
			
			//manager wants to change user address and/email
			String memberName = "Adam Adamson";
			String address = "Another lecture hall";
			String email = null;
			manager.updateMember(manager.getMember(clubMemberList, memberName), address, email);
		}
	}

	public void printMembers(ArrayList<ClubMember> clubMemberList) {
		String clubMemberNameString = "The names of the club members are: ";
		for (ClubMember clubMember : clubMemberList) {
			clubMemberNameString += clubMember.getName() + ", ";
		}
		System.out.println(clubMemberNameString.substring(0, clubMemberNameString.lastIndexOf(',')));
	}

	public void readMembersFromFile(ArrayList<ClubMember> clubMemberList) {
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
					clubMemberList.add(new ClubMember(memberInfo[NAME_INDEX], memberInfo[ADDRESS_INDEX], Integer.parseInt(memberInfo[YEAR_OF_REG_INDEX]),
							memberInfo[EMAIL_INDEX]));
				}
			}
			buffReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ClubMember getMember(ArrayList<ClubMember> clubMemberList, String name) {
		for (ClubMember clubMember : clubMemberList) {
			if (clubMember.getName().equals(name))
				return clubMember;
		}
		return null;
	}

	public void updateMember(ClubMember clubMember, String address, String email) {
		if (clubMember != null) {
			if (email != null)
				clubMember.setName(email);
			if (address != null)
				clubMember.setAddress(address);
		}
	}

	public Group CreateGroup(int groupId, String groupDescription) {
		return new Group(groupId, groupDescription);
	}

	public boolean addMemberToGroup(Group group, ClubMember member) {
		if(group != null && member != null) {
			return group.addGroupMember(member);
		}
		return false;
	}
	
	public void printGroupMembers(Group group) {
		if(group != null) {
			System.out.println("The members of the group" + group.getGroupDescription() + " are:");
			for(ClubMember clubMember : group.getGroupMembers()) {
				System.out.println(clubMember.getName());
			}
		}
	}
	
	public void printGroupNamesAndNumberOfMembers(ArrayList<Group> groupList) {
		for(Group group : groupList) {
			System.out.println("There are " + group.getNumberOfMembers() + "members in the group: " + group.getGroupDescription());
		}
	}
}
