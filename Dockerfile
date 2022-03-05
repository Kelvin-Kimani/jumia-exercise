FROM node:16 AS react-app
WORKDIR /app
ENV PATH /jumia-exercise-fe/app/node_modules/.bin:$PATH
COPY /jumia-exercise-fe/package.json ./
COPY /jumia-exercise-fe/package-lock.json ./
RUN npm install
COPY /jumia-exercise-fe/ ./
CMD ["npm", "start"]


FROM openjdk:17 AS spring-boot-app
ADD target/jumia-exercise.jar jumia-exercise.jar
ADD sample.db sample.db
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "jumia-exercise.jar"]