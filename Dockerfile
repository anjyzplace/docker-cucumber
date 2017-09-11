FROM ubuntu:16.04
MAINTAINER anjola.awofisoye@gmail.com

RUN apt-get update && \
	apt-get install -y openjdk-8-jdk ant && \
	apt-get clean;

RUN apt-get update && \
	apt-get install ca-certificates-java && \
	apt-get clean && \
	update-ca-certificates -f;

ENV JAVA_HOME /usr/lib/jvm/java-8-openjdk-amd64

RUN export JAVA_HOME && \
    apt-get update && \
  	apt-get clean;

# install wget
RUN apt-get install -y wget

# get maven 3.2.2
RUN wget --no-verbose -O /tmp/apache-maven-3.2.2.tar.gz http://archive.apache.org/dist/maven/maven-3/3.2.2/binaries/apache-maven-3.2.2-bin.tar.gz

# verify checksum
RUN echo "87e5cc81bc4ab9b83986b3e77e6b3095 /tmp/apache-maven-3.2.2.tar.gz" | md5sum -c

# install maven
RUN tar xzf /tmp/apache-maven-3.2.2.tar.gz -C /opt/
RUN ln -s /opt/apache-maven-3.2.2 /opt/maven
RUN ln -s /opt/maven/bin/mvn /usr/local/bin
RUN rm -f /tmp/apache-maven-3.2.2.tar.gz
ENV MAVEN_HOME /opt/maven

# Create app directory
RUN mkdir -p /usr/src/test
WORKDIR /usr/src/test

# Install app dependencies
COPY . /usr/src/test/


## Add the wait script to the image
ADD https://raw.githubusercontent.com/ufoscout/docker-compose-wait/1.0.0/wait.sh /wait.sh
RUN chmod +x /wait.sh

#EXPOSE 3000
CMD [ "mvn", "test" ]
