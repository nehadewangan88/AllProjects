Feature: VAlidating Add Place API

Scenario Outline: Verify if Place being Successfully added using AddPlace API
		Given Add Place Payload with <lat> <lng> "<name>" "<address>" 
		When user calls "AddPlaceAPI" with "post" http request
		Then API call got success with status code 200
		And "status" in response body is "OK"
		
		
Examples:
		|lat     |lng      |name                    |address                         |
		|36.9088 |63.9088  |WaterLine House Andria  |Walfort City, GreenLand  |
		|33.9088 |68.9088  |WaterLine House Familla |Mallina City, Glora      |
		|31.9088 |60.9088  |WaterLine House Cloria  |Walton City, GreenValley|
		