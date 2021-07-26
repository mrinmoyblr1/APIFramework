Feature: Validationg Place APIs 

Scenario: Verify if Place is being Successfully added unsing AddPlaceAPI 
	Given Add Place Payload 
	When User calls AddPlaceAPI with POST Http Request
	Then The API calls is success with Status Code 200
	And status in response body is OK
