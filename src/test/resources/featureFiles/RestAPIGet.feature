Feature: Calling the rest end point and validating the response 
    
    Scenario: Calling the rest end point for particular order and validating the response
      Given call a rest end point for a given order 
      Then validate response for following fields
      | Order      | Level    | Code | Parent |This item also includes|Rulings|This item excludes|Reference to ISIC Rev. 4|
      | 398481     |    1     |	A	 |        |                       |       |                  |       A                |                        |     
          




