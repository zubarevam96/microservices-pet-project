# microservices-pet-project
This project is the result of following to [this](https://www.youtube.com/playlist?list=PLqq-6Pq4lTTZSKAFG6aCDVDP86Qx4lNas) playlist
Project uses Spring (boot, cloud, web) and Eureka frameworks and built with Maven.
Project simulates backend-side of movie ratings agregators, and contains some info about movies, their ratings and users watched-list. 

Microservices:
- discovery-server - only contains [Eureka server](https://www.tutorialspoint.com/spring_boot/spring_boot_eureka_server.htm);
all other microservice in this project will comunicate with it via Eureka client
- Movie-info-service - contains some basic info about movies like name and description
- Movie-catalog-service - shows movie list that was watched by user
- ratings-info-service - contains information about movie's ratings (by particular person and overall)
