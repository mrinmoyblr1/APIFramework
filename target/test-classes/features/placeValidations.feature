Feature: Validationg Place APIs 

Scenario: Verify if Place is being Successfully added unsing AddPlaceAPI 
	Given Add Place Payload
	When User calls "AddPlaceAPI" with Post Http Request
	Then The API call got success with Status Code 200
	And "status" in response body is "OK"	
	And "scope" in response body is "APP"
	
	
	
	
	
	
	