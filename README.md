# rest-assured-study-project

This repo contains the basic structure to implement tests using rest-assured with some examples of use:

- Basic assertions;
- Logging information;
- Extracting data from response body to variables;
- Using optimizations like:
  - Reusable configurations;
  - Reusable assertions;
- Parametrization of tests to use data providers and write one test for multiples data;
- Using json-path and xml-path lib to filter data from response body;
- Serialization and Deserialization of json/xml in java objects and vice-versa;

# Project Technologies

This project was written using Java and Maven in IntelliJ IDE.

# External Libraries and their functions

To write these tests I used the bellow external libraries:

- Junit (junit);
  - Junit (like testNG) is the actor who manages the written and the execution of all test cases. 
- Rest-Assured (io.rest-assured);
  - Rest-assured is the focus library of this repository. Its focus is to simplify the way that the tests was written and provide all functions to send requests.
- Junit Data provider (com.tngtech.junit.dataprovider);
  - This library is used to manage the data objects that were used in tests.
- rest-assured json-path;
  - This is part of rest-assured framework and is used to filter json data from response body.
- rest-assured xml-path;
  - This is part of rest-assured framework and is used to filter xml data from response body.
- Jackson-databind (com.fasterxml.jackson.core);
  - This library is used in Java Objects classes to manage Json Properties, like the order of properties and indicates custom json properties in java objects.

# How to use this repository?

- Install JDK 8;
- Install GIT and Clone the repository;
- Open the project in your favorite IDE;
- Download dependencies using Maven ( mvn install );
- Run the tests using Maven ( mvn test )
