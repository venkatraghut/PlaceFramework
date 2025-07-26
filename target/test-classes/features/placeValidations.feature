Feature: Validate place API's

	@AddPlace @Regression
	Scenario Outline: Verify if place is added successfully
	    Given Add Place Payload "<name>" "<language>" "<address>"
	    When user calls "AddPlaceAPI" with "POST" http request
	    Then api call should get success with status code of 200
	    And "status" in response body is "OK"
	    And "scope" in response body is "APP"
	    And verify place_Id created maps to "<name>" using "GetPlaceAPI"
	    
	Examples:
			|name|language|address|
			|OrganicHouse|English|White House Main Road|
		
@DeletePlace @Regression
Scenario: Verify if Delete Place functinality is working fine

		Given DeletePlace Payload
    When user calls "DeletePlaceAPI" with "POST" http request
    Then api call should get success with status code of 200
    And "status" in response body is "OK"
    
