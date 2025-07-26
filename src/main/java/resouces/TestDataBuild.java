package resouces;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {
	
	public AddPlace getAddPlacePayload(String name, String language, String address) {
        AddPlace place = new AddPlace();
        place.setAccuracy(50);
        place.setName(name);
        place.setAddress(address);
        place.setLanguage(language);
        place.setWebsite("http://google.com");
        place.setPhone_number("734937493439");

        List<String> types = new ArrayList<>();
        types.add("shoe park");
        types.add("park");
        place.setTypes(types);

        Location loc = new Location();
        loc.setLat(-38.383494);
        loc.setLng(33.427362);
        place.setLocation(loc);

        return place;
    }
	
	public String deletePlacePayload(String placeId) {
		return "{\"place_id\":\"" + placeId + "\"}";	}

}
