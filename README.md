# Azure Cognitive Service TTS(Text To Speech) 
 Text to speech  application enables you to convert text into human like synthesized speech. 
The text to speech capability is also known as speech synthesis. 
Use human like prebuilt neural voices out of the box, 
or create a custom neural voice that's unique to your product or brand.


# Prerequisites
* Java Development Kit (JDK) 17
* Apache Maven 3.6.3
* Lombok plugin installed in IDE
* An Azure account with an active subscription. (Create an account for free)
* A Speech resource key and region. (Create a Speech resource in the Azure portal and Get the Speech resource key and region)
* Postman for testing the API (Optional)

# Getting Started

## Set environment variables
>set your SPEECH_KEY in [application.yml](src/main/resources/application.yml)<br>
>set you SPEECH_REGION in [application.yml](src/main/resources/application.yml)

## Install 
* Clone the repository and import with IDE
* Use maven command `mvn clean install` or IDE dialogue to build the code.
## RUN
* run the application using `java -jar 'text2Speech-{version}-SNAPSHOT'` or use IDE prompt to run Spring boot application
* application will be started on port: 8082 with this url will be exposed `http://localhost:8082/text2speech/v1/convert`
* import the [postman-collection](postman/postman_collection.json) in postman and run
* or run this curl command
> curl --location --request POST 'http://localhost:8082/text2speech/v1/convert' \
--header 'Content-Type: application/json' \
--data-raw '{
"inputText" : "YOUR TEXT "
}'

##API Specification
>[Api Specification link](design/ApiSpecification_V1.yml)





