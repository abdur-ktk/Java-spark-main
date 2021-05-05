# README #


### What is this repository for? ###

* This spring boot project is a test for apache spark behaviour in a multithreaded environment.


### How do I get set up? ###

1. To start the project simply clean install via maven and then startup the project
   * The project is running on Java version 1.8.0_171
2. Dependency versions used:
    * Spring boot starter parent: 2.1.3.RELEASE
    * Apache spark: 3.1.1
    * Maven 3.6.3 (bundled with Intellj IDEA 2021.1)
3. When the application has started open Postman and enter the URL: http://localhost:9001/api/spark/provokeException?listSize=&amountOfLists= with your desired parameters.
   In my case I can consistently provoke an exception, if set the parameters to 10 and 10, so the URL looks like this: http://localhost:9001/api/spark/provokeException?listSize=10&amountOfLists=10.
    1. From there you can call the rest endpoint via the POST method.
    2. The parameters represent the following:
        * amountOfLists: The amount of lists that get created. This is equal to the amount of threads that get started since every list starts a new thread.
        * listSize: The amount of objects per list.
4. Configuration changes can be made in the application.properties file

### Who do I talk to? ###

* Joel Lagerwall (joel.lagerwall@edatasystems.de)