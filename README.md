# NamespaceId
Web service to return a unique id per namespace

(This project is based on https://spring.io/guides/gs/rest-service/)

Clone Repository:
git clone https://github.com/abretucorazon/NamespaceId.git

Build and run this project:
./mvnw spring-boot:run

Build Jar file:
./mvnw clean package

Execute jar file:
java -jar target/gs-rest-service-0.1.0.jar


Issue a request in browser:
http://localhost:8080/getId?namespace=User

Example of response: 
    {"id":"User-29-1577686871322-14425-192.168.0.149"}

Format of response:     
        "User"          -  Namespace
        "29"            -  Counter of number of calls to "/getId"
        "1577686871322" -  Current system time: System.currentTimeMillis()
        "14425"	        -  Current process Id
        "192.168.0.149" -  IP address of localHost



