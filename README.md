# sport-events
Microservices system for parse and display sports event.

To start all the microservices of this project, just enter the command "docker-compose up -d".
The client part is available at localhost:8080

The project parse sports events from the fonbet. Passes them to the RabbitMQ queue. The listener on the side of the microservice "sport" saves new events to the database(PostgreSQL).
The client can view current events by going through the registration and authentication process.
