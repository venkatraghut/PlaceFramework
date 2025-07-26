package stepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@DeletePlace")
	public void beforeScenario() throws IOException {
		
		
		
		StepDefinationPlaceValidation m = new StepDefinationPlaceValidation();
		if(StepDefinationPlaceValidation.place_id==null) {
			m.add_place_payload("Raghu", "Language", "Australia");
			m.user_calls_with_http_request("AddPlaceAPI", "POST");
			m.verify_place_id_created_maps_to_using("Raghu", "GetPlaceAPI");
		}
		
		
	}

}
