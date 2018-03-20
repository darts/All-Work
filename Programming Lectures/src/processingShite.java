
public class processingShite {
	  @Override
	public String toString() {
		return "processingShite [id=" + id + ", name=" + name + ", neighborhood=" + neighborhood + ", address="
				+ address + ", city=" + city + ", state=" + state + ", postalCode=" + postalCode + ", latitude="
				+ latitude + ", longitude=" + longitude + ", stars=" + stars + ", reviewCount=" + reviewCount
				+ ", isOpen=" + isOpen + ", categories=" + categories + "]";
	}
	String id;
	  String name;
	  String neighborhood;
	  String address;
	  String city;
	  String state;
	  String postalCode;
	  double latitude;
	  double longitude;
	  double stars;
	  int reviewCount;
	  boolean isOpen;
	  String categories;
	public processingShite(String id, String name, String neighborhood, String address, String city, String state,
			String postalCode, double latitude, double longitude, double stars, int reviewCount, boolean isOpen,
			String categories) {
		this.id = id;
		this.name = name;
		this.neighborhood = neighborhood;
		this.address = address;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.latitude = latitude;
		this.longitude = longitude;
		this.stars = stars;
		this.reviewCount = reviewCount;
		this.isOpen = isOpen;
		this.categories = categories;
	}
}
