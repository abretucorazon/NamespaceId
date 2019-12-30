# NamespaceId

git clone https://github.com/abretucorazon/NamespaceId.git

./mvnw spring-boot:run

./mvnw clean package

java -jar target/gs-rest-service-0.1.0.jar


API call: http://localhost:8080/getId?namespace=User

Response: 

    {"id":"User-29-1577686871322-14425-192.168.0.149"}

Format:     
        "User"           -   Namespace
        "29"            -   Counter of number of calls to "/getId"
        "1577686871322" - Current system time: System.currentTimeMillis()
        "14425"	        - Current process Id
        "192.168.0.149" - IP address of localHost
