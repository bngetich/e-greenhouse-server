# e-greenhouse
An app that will collect sensor data(temperature, humidity, soil moisture) of a greenhouse. It will notify the farmer of any environmental factors that will destroy their crops.
## Requirements
For building and running the application you need:
- JDK 1.8 or later
- Gradle 5 or later or you can use the gradle wrapper available within the project
## Running the application locally
There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `EgreenhouseApplication.java` class from your IDE.

Alternatively you can use the [Spring Boot Gradle plugin](https://docs.spring.io/spring-boot/docs/current/gradle-plugin/reference/html/) like so:

```shell
gradle bootRun
```
or using gradle wrapper like this:

```shell
./gradlew bootRun
```
## Testing 
To launch your application's tests, run:

```shell
gradle test
```
or:

```shell
./gradlew test
```
## Copyright
Released under the MIT Lincense See the [LICENSE](https://github.com/bngetich/e-greenhouse/blob/master/LICENSE) file.
