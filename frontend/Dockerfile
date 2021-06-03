FROM openjdk:16-jdk-buster
# ----
# Install Maven
RUN apt-get update; \
	apt-get install -y --no-install-recommends \
	curl\
	tar 
ARG MAVEN_VERSION=3.8.1
RUN mkdir -p /usr/share/maven && \
curl -fsSL http://apache.osuosl.org/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-$MAVEN_VERSION-bin.tar.gz | tar -xzC /usr/share/maven --strip-components=1 && \
ln -s /usr/share/maven/bin/mvn /usr/bin/mvn
ENV MAVEN_HOME /usr/share/maven
# ----
# Install dependencies
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
COPY pom.xml /usr/src/app
RUN mvn verify --fail-never
# Build src
COPY src /usr/src/app/src
RUN mvn package
RUN mv target/*.jar app.jar
ENTRYPOINT ["java","-jar","./app.jar"]
