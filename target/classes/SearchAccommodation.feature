@tag 
Feature: AlMundo HotelReservation 

@tag1 
Scenario: Search for any accommodation in Buenos Aires 

	Given the user is at AlMundo hotel page 
	And the location "city" is set to "Buenos Aires, Buenos Aires, Argentina" 
	And the entire date for arrival is "Febrero 2020" 
	And the stay starts day "19" 
	And the entire date for leaving is "Marzo 2020" 
	And the stay ends day "20" 
	And the room number is set to "2" 
	And the adult guests are "5" 
	And the children guests are "4" 
	And the child age option is "2" 
	When the search button is clicked 
	Then the hotel results page is displayed 
	
Scenario Outline: 
	Search for any accomodation with the parameters given

	Given the user is at AlMundo hotel page 
	And the location <type> is set to <city> 
	And the entire date for arrival is <checkIn> 
	And the stay starts day <dateFrom> 
	And the entire date for leaving is <checkOut> 
	And the stay ends day <dateTo> 
	And the room number is set to <Rooms> 
	And the adult guests are <adults> 
	And the children guests are <children> 
	And the child age option is <option> 
	When the search button is clicked 
	Then the hotel results page is displayed 
	
	Examples: 
		| type           | city                                                | checkIn        | dateFrom | checkOut       | dateTo | Rooms | adults | children | option |
		| "city"         | "Ciudad de México, Ciudad de México, México"        | "Febrero 2020" | "19"     | "Febrero 2020" | "25"   | "1"   | "3"    | "2"      | "1"    |
		| "neighborhood" | "Porta Romana, Milán, Italia"                       | "Marzo 2020"   | "12"     | "Marzo 2020"   | "22"   | "1"   | "1"    | "2"      | "3"    |
		| "hotel"        | "Apartamentos Europa, Barcelona, España"            | "Marzo 2020"   | "3"      | "Abril 2020"   | "15"   | "1"   | "2"    | "1"      | "5"    |
		| "city"         | "Nueva York, Nueva York, Estados Unidos de América" | "Marzo 2020"   | "14"     | "Abril 2020"   | "25"   | "1"   | "3"    | "1"      | "4"    |
		| "city"         | "San Carlos de Bariloche, Río Negro, Argentina"     | "Julio 2020"   | "20"     | "Julio 2020"   | "26"   | "1"   | "2"    | "1"      | "2"    |
      