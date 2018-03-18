# TravelTime
This repository houses examples related to development of a Internet Flight & Hotel search/booking engine using the development sandboxes available from popular GDS's Amadeus and Galileo.

## Building the application
1. Clone the repository in your preferred location.
2. Change the directory to TravelTime/src/main/resources/static
3. run 
   1. $> npm install
   2. $> npm run build
   3. $> npx webpack --config webpack.config.js
4. cd to main project directory i.e. TravelTime
5. create a property file src/main/resources/supplier.properties
   1. Add following properties to it
       amadeus.url=https://api.sandbox.amadeus.com/v1.2
       amadeus.api.key=XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
       sabre.url=https://developer.sabre.com/io-docs/call-api
       sabre.clientId=XXXXXXXXXX
       sabre.clientSecret=XXXXXX
   2. amadeus.api.key can be obtained by registering at Amadeus for a developer account with Amadeus at 
   https://sandbox.amadeus.com
   3. sabre.clientId and sabre.clientSecret could be obtained by registering for a developer account with Sabre at
   https://developer.sabre.com/
6. Have a MySQL Host up and running with a Schema traveltime
    Change the following properties in application.properties to use the schema
    spring.datasource.url=jdbc:mysql://localhost:3306/traveltime
    spring.datasource.username=traveltime
    spring.datasource.password=traveltime
7. Run $> mvn spring-boot:run to run the application.
8. Following is the index page of the application
    <img src="https://user-images.githubusercontent.com/2723994/37564498-4aedd03e-2abd-11e8-854f-2ef20df77b64.png"/>
9. Following is the search results page for hotel search by airport location
    <img src="https://user-images.githubusercontent.com/2723994/37564525-a36d6422-2abd-11e8-9c05-277d086250f8.png"/>
10. Following is the hotel-details page which includes room details
<img src="https://user-images.githubusercontent.com/2723994/37564540-ec432646-2abd-11e8-847b-6ac806714bc6.png"/>
11. Following is the flight result(s) page indicating available flights from 'LHR' to 'CDG' with return options on 31st March 2018 (onward) and 4th April 2018 (return)
<img src="https://user-images.githubusercontent.com/2723994/37564561-6bdcead6-2abe-11e8-8d96-da78a281d514.png"/>
12. Following is the flight detail section
<img src="https://user-images.githubusercontent.com/2723994/37564572-a9d50990-2abe-11e8-83be-f6ece9363c64.png"/>
13. On clicking the 'Outbound Details' one can view the details about various legs of the outbound option.
14. On clicking the 'Inbound Details' one can view the details of about various legs of the inbound option.
15. For one way flights only open-jaw flights (outbound) would be shown.


##REST APIs covered by the application
1) Amadeus - Flights
    1. Low-fare-search
    2. Extensive-search
    3. Inspiration-search
    4. Search Airport by location
    5. Affiliate-Search
    6. Nearest Relevant Airport
    7. Auto suggest Airport
2) Amadeus - Hotels
    1. Search Hotels by Airport Code    
3) Sabre - Flights
    1. Shop Insta Flights

The application is an effort to illustrate how the aggregation of results from various suppliers is done using simple search parameters. The intent of this internet search & booking engine is to let development teams explore various APIs made available by GDS's which could be used to provide quality search/booking experience to users.
    

