# Dependency adding

    In pom.xml paste the Required  dependency and enter the below code in Cmd     
    --------> mvn clean install


### .env configuration
#### Naming:

    .env file _ and Caps tha use pannanum
    Example: MONGO_URI=link

####    ADD Dependency 

    <dependency>
    <groupId>io.github.cdimascio</groupId>
    <artifactId>dotenv-java</artifactId>
    <version>3.1.0</version>
    </dependency>
#### Call the value By

    namma properties la tha poduvom 

    spring.data.mongodb.uri=${MONGODB_URL}
    
    $ use pannanum and {} ulla variable name in .env

# Query

### Library Sort in service
    return r.findAll(Sort.by(sort).ascending());
### Custom Sort
    service: 
                return r.getBooksOfGenre(genre,Sort.by(sort).ascending());
    Repo:
                @Query("{ 'genre': ?0 }")
	            List<books> getBooksOfGenre(String genre, Sort sort);

    * assign sort and send to repo it is reduse the sort by some property work