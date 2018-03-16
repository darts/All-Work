import java.util.ArrayList;

public class Group {
	private int groupId;
	private String groupDescription;
	private ArrayList<ClubMember> groupMembers;

	public Group(int groupId, String groupDescription, ArrayList<ClubMember> groupMembers) {
		this.groupId = groupId;
		this.groupDescription = groupDescription;
		this.groupMembers = groupMembers;
	}

	
	public Group(int groupId, String groupDescription) {
		this(groupId, groupDescription, new ArrayList<ClubMember>());
	}


	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getGroupDescription() {
		return groupDescription;
	}

	public void setGroupDescription(String groupDescription) {
		this.groupDescription = groupDescription;
	}

	public ArrayList<ClubMember> getGroupMembers() {
		return groupMembers;
	}

	public boolean isMember(ClubMember member) {
		for(ClubMember clubMember : groupMembers) {
			if(member == clubMember)
				return true;
		}
		return false;
	}
	
	public boolean addGroupMember(ClubMember member) {
		if(!isMember(member)) {
			groupMembers.add(member);
			return true;
		}
		return false;
	}
	public void setGroupMembers(ArrayList<ClubMember> groupMembers) {
		this.groupMembers = groupMembers;
	}
	
	public int getNumberOfMembers() {
		return groupMembers.size();
	}

	public String toString() {
		return "Group [groupId=" + groupId + ", groupDescription=" + groupDescription + ", groupMembers=" + groupMembers
				+ "]";
	}
}
