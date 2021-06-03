# syntax=docker/dockerfile
FROM centos

#Set maintainer - Optional
LABEL maintainer="Bana Solutions"
LABEL description="container for geomatics modules"

#Install tools required for project, fortran compiler
RUN yum install -y gcc-gfortran gdb make git mysql
RUN yum update -y

#Add module from github
RUN mkdir /module
ARG GIT_URL="https://github.com/keithSchumacher/ck001_keith.git"
RUN git clone $GIT_URL /module
WORKDIR /module

#Add script to build, execute and export results of module
ENV SCRIPT="findExecuteExport.sh"
COPY ${SCRIPT} .
RUN chmod +x ${SCRIPT}
#Mysql script that exports results
COPY export.sql .
#Run script to build, execute and export results of module
ENTRYPOINT ["./findExecuteExport.sh"]
