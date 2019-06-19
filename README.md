# Spring cloud 


The **House Building Calculator** Estimate The Cost Of Constructing A New Home


## Project Include:
*  Spring Cloud Config Server
*  Service Discovery: Eureka Server
*  Netflix Ribbon
*  Netflix Zuul
*  Declarative REST Client: Feign
*  Netflix Hystrix   



### Installing

Clone a repository from git

```
git clone https://github.com/vKozik/calcBuilder.git
```

enter the project folder
```
cd calcBuilder
```

build the app with maven
```
mvn clean install 

```


### Run

Start Config Server
```
java -jar calcbuilder-config/target/calc-builder-config-1.0-SNAPSHOT.jar
```

Start Eureka Server
```
java -jar calcbuilder-eureka/target/calc-builder-eureka-1.0-SNAPSHOT.jar

```
Start services
```
java -jar calcbuilder-house/target/calc-builder-house-1.0-SNAPSHOT.jar
java -jar calcbuilder-basement/target/calc-builder-basement-1.0-SNAPSHOT.jar
java -jar calcbuilder-roof/target/calc-builder-roof-1.0-SNAPSHOT.jar
java -jar calcbuilder-walls/target/calc-builder-walls-1.0-SNAPSHOT.jar
```


