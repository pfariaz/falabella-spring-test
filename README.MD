# Instructions to deploy 

To run locally :
```bash
./gradlew build && java -jar build/libs/falabella-spring-test-1.0.0.jar
```

To run from docker:

1.- First we need to build the docker image 
```bash
docker build -t falabella-spring-test.
```

2.- Then we can launch the image with the spring boot microservice
```bash
docker run -p 8080:8080 -t springboot-test
```

# Instructions to request

The endpoint to request info about pharmacies, its neccessary to request to:

`GET /api/v1/pharmacies`

If you want to filter by commune, yo can add `commune` RequestParam, for example

`GET /api/v1/pharmacies?commune=RECOLETA`

by default the endpoint will response all pharmacies

If you want the response as XML or JSON, you will need to put the following HTTP header in the request:
for JSON response: `Accept: application/json`and for XML response: `Accept: application/xml` 


