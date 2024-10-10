package resources;

import java.util.ArrayList;
import java.util.List;

import PojoClasses.Location;
import PojoClasses.PlaceDetails;

public class TestDataBuild {

	public PlaceDetails addPlacePayload(double lat, double lng, String address, String name) {
		PlaceDetails place = new PlaceDetails();
		Location loc = new Location();
		loc.setLat(lat);
		loc.setLng(lng);
		place.setLocation(loc);
		place.setAccuracy(50);
		place.setAddress(address);
		place.setLanguage("French-IN");
		place.setName(name);
		place.setPhone_number("(+91) 983 893 3937");
		place.setWebsite("http://google.com");
		List<String> newList = new ArrayList<String>();
		newList.add("shoe park");
		newList.add("shop");
		place.setTypes(newList);
		return place;
	}

}
