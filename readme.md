Assignment
==============

Clone this repo and start the mock:

`./gradlew bootRun`

to list all tasks:

`./gradlew tasks`

The mock resources are protected and require authentication through OAuth 2 to gain access. The following credentials can be used to connect to the service:
 
- client-id: travel-api-client
- secret: psw
 
The OAuth2 flow required to retrieve a token is 'client_credentials'.
 
The OAuth2 token endpoint after startup is:
 
`http://localhost:8080/oauth/token`
 
Resource endpoints:
-------------------
Retrieve a list of airports:
`http://localhost:8080/airports`
possible query params:
- size: the size of the result
- page: the page to be selected in the paged response
- lang: the language, supported ones are nl and en

Retrieve a specific airport:
`http://localhost:8080/airports/{code}`
possible query params:
- lang: the language, supported ones are nl and en

Retrieve a fare offer:
`http://localhost:8080/fares/{origin_code}/{destination_code}`
possible query params:
- currency: the requested resulting currency, supported ones are EUR and USD
 
 Tasks:
-------
- Create a web application with a Java backend that connects to the mock a offers the following functionality:
    - The ability to select an origin and a destination from a dropdown.
    - Requesting a fare for the selected origin and displaying the resulting price, including all the details of the origin and 
    destination (name, description, city, country, etc)
- Additional technical requirements:
    - The mock is not very efficient in it's response as it only shows the origin and destination codes and not the full details. 
    Two calls are required to get all the information however the fair result is not very fast, mostly because of the amazing 
    Thread.sleep :) but some services are quite slow unfortunately and this is copied in the mock. Create an aggregate service 
    for your web application that retrieves the origin details, destination details and the fare and combines them in a single result.
    To earn bonus points show us how you can perform this task concurrently.
    - Bonus: It would be very interesting to see how often you application is used, so implement a way to record (and view) metrics for 
    interesting stuff (like highest response time, lowest response time, average response time, total responses, total fault responses, etc)
    - The mock is very paranoid, therefore its token is not kept valid for a very long time, you have to design your application in such 
    a way that it can deal with this without customers experiencing any issues (i.e. exceptions) or delays from refreshing tokens.
