FROM musiccraft/alpine-openjdk-maven:v1

COPY . /code/

RUN cd /code \
	&& mvn clean package -DskipTests
	
CMD ["java", "-jar", "/code/target/sport-0.0.1-SNAPSHOT.jar"]