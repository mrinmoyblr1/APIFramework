package stepDefinations;

import java.io.IOException;

import cucumber.api.java.Before;

public class Hooks {
	@Before("@DeletePlace")
	public void beforeScenario() throws IOException {

		// Write the code that will return the place_id
		// Execute this code only when the place_id is null
		StepDefination m = new StepDefination();

		if (StepDefination.place_id == null) {
			m.add_Place_Payload("Biswas", "English", "Asia");
			m.user_calls_with_http_Request("AddPlaceAPI", "POST");
			m.verify_place_id_created_maps_to_using("Biswas", "getPlaceAPI");			
			
		}

	}

}
