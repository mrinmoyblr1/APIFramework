Feature: Validationg Place APIs 

Scenario Outline: Verify if Place is being Successfully added unsing AddPlaceAPI 
	Given Add Place Payload "<name>" "<language>" "<address>" 
	When User calls "AddPlaceAPI" with "Get" http Request 
	Then The API call got success with Status Code 200 
	And "status" in response body is "OK" 
	And "scope" in response body is "APP" 
	
	
	Examples: 
		|name|language|address|
		|AAHouse|English|World Cross Center|
		|BBHouse|Spanish|Sea Cross Center|
		
		
		
		
		
		
		
		
		
	