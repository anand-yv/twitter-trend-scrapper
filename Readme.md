# Twitter Trending Scraper

This application scrapes trending topics from Twitter and stores them in a MongoDB database. Follow the instructions below to set up and run the application

## Techstack
- Java
- SpringBoot
- Selenium
- MongoDB

## Prerequisites

- Java Development Kit (JDK) 21 or later installed
- Maven build tool installed
- MongoDB server installed and running
- Chrome browser installed (for Selenium WebDriver)

## Configuration

The application requires the following configuration values, which will be injected into the `TwitterTrendServices` class:

- MongoDB Connector URL (`spring.data.mongodb.uri`)
- MongodDB Database Name (`spring.data.mongodb.database`)
- Server Port(`server.port`) set to 80
- Twitter email address (`twitter.email`)
- Twitter username (`twitter.username`)
- Twitter password (`twitter.password`)
- ProxyMesh username (`proxy.username`)
- ProxyMesh password (`proxy.password`)
- ProxyMesh enableProxy (`proxy.enableProxy`) in boolean(bydefault `false`)

#### For Reference refer [dummy-application.properties](src\main\resources\dummy-application.properties)

These values should be provided as environment variables or through any other configuration mechanism supported by Spring Boot.

## Running the Application

1. Clone this repository to your local machine.
2. Navigate to the project directory in your terminal.
3. Build the application using Maven: ```mvn install```
4. Run the application using the generated JAR file: ```java -jar target/TwitterTrendingScraper-0.0.1-SNAPSHOT.jar```

## Usage

Once the application is running, you can access the trending topics by navigating to the provided URL (e.g., `http://localhost:8080`).

## Additional Notes

- Ensure that MongoDB is running and accessible to the application.
- Make sure to provide the required configuration values before running the application to enable successful scraping of Twitter data.
<br>

#### Application will be started on the port ```localhost:80```