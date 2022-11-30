# swagger-api-example
Java application implementing a sample REST API using **Swagger to describe the API**.

In this case, we are using **Jersey as JAX-RS implementation**, but we could use RESTEasy as well.

## How to compile the application

Execute the following command:

```
mvn clean compile
```

## How to deploy the application

Execute the following command:

```
mvn clean package
```

Deploy the war file generated within the target folder to your preferred server/container, such as Tomcat.

## How to generate the API specification file

If you want to generate the API specification from the source code, just execute the following command:

```
mvn clean compile
```

The API specification will be generated within the **generated/swagger-api-spec** folder.
