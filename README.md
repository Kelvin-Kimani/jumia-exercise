# Jumia Application

A Single Page Application that uses a sample SQLite database to list and categorize phone numbers by country.

## Bootstrap Application
### Prerequisites
1. Java (JDK 17)
2. Node (Version 16)
3. Docker Engine

### Local Machine

Clone the project to your local repository and navigate to the root directory of the project.

1. Under src folder, navigate to `src/main/java/com/jumiaexercise/JumiaExerciseApplication.java`
2. Run the main method in the application, and ensure the server is up and running.
    >By default, the Tomcat Apache Server starts on port 8080, hence make sure the port isn't in use.
3. Navigate back to the root directory of the project and navigate to `jumia-exercise-fe` folder.
4. Open the terminal from the directory and run the command `npm install`
    >This will install the node modules needed to run the React Application.
5. After installation, run `npm start` to serve the application at [http://localhost:3000](http://localhost:3000)

### Docker Environment


Again, clone the project to your local repository and navigate to the root directory of the project.

1. Perform `maven clean` and `maven install` to get the application jar in the target folder. 
   > Alternatively, could use maven in your IDE to perform the same.
2. Open the terminal and run ensure docker engine is running. Try running `docker version` which will return the version you are using.
3. Now that the daemon is running, run the following command `docker build -t spring-boot-app --target spring-boot-app .` to build the spring boot image.
4. Run `docker build -t react-app --target react-app .` command to build the react image.
5. Ensure both images are present by running `docker images`, and you'll see both of them with their respective tags.

**Running images**

1. Let's start with the backend. Run `docker run -d p8080:8080 spring-boot-app` command to run a container with our image.
   > Try accessing this endpoint [http://localhost:8080/customers](http://localhost:8080/customers) that should return a list of all customers.
2. If up and running, let's run our front end image.
3. Run `docker run -d p3000:3000 react-app` command and access [http://localhost:3000/](http://localhost:3000/) on our browser
4. If up and accessible, then the applications are working as they should.
5. Enjoy!
