Feature: Validationg Place APIs 

@AddPlace @Regression
Scenario Outline: Verify if Place is being Successfully added unsing AddPlaceAPI 
	Given Add Place Payload "<name>" "<language>" "<address>" 
	When User calls "AddPlaceAPI" with "Get" http Request 
	Then The API call got success with Status Code 200 
	And "status" in response body is "OK" 
	And "scope" in response body is "APP" 
	And Verify place_id created maps to "<name>" using "getPlaceAPI" 
	
	
	
	Examples: 
		|name|language|address|
		|AAHouse|English|World Cross Center|
		#	|BBHouse|Spanish|Sea Cross Center|
		
@DeletePlace
Scenario: Verify is the Delete Place functionality API is working 
	Given deletePlaceAPI Payload 
	When User calls "deletePlaceAPI" with "POST" http Request 
	Then The API call got success with Status Code 200 
	And "status" in response body is "OK" 
	
	
	
	
	
	
	
	
	
	
	