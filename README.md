# kotlin_rest_mongodb
RESTful API Implementation using Kotlin, Spring Boot, Spring Data and MongoDB

## Usage
- [Toolset](#toolset)
- [Configure](#configure)
- [Start Server](#start-server)
- [Usage](#usage)


### Toolset
- Kotlin v1.1.1
- Spring Boot v1.5.2.RELEASE
- MongoDB v3.2.12 (mLab)

### Configure
- Update "src/main/resources/application.properties" file with required details

### Start Server
- Run the main method from "KotlinRestMongodbApplication.kt" or run the command "./gradlew bootRun"

### Usage
- APIs are available for CRUD operations
- [GET] /book: Get all the book from DB
- [POST] /book: Create a new note and store data in DB
    - JSON Body: ```{
                 	    "title": "Kotlin",
                    	"details": "POST from Kotlin"
                    }```
- [PUT] /book/{id}: Update a note
    - JSON Body: ```{
                    	"title": "Kotlin",
                    	"details": "POST from Kotlin"
                    }```
- [DELETE] /book/{id}: Delete specific note from DB
