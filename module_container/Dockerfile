# syntax=docker/dockerfile
FROM centos

#Set maintainer - Optional
LABEL maintainer="Bana Solutions"
LABEL description="container for geomatics modules"

#Install tools required for project, fortran compiler
RUN yum install -y gcc-gfortran gdb make unzip mysql
RUN yum update -y

#Add module from github
ARG GIT_URL="https://github.com/keithSchumacher/ck001_keith/archive/refs/heads/master.zip"
ADD $GIT_URL /

#Add script to build, execute and export results of module
ENV SCRIPT="findExecuteExport.sh"
COPY ${SCRIPT} /
RUN chmod +x ${SCRIPT}
#Add mysql script to output results
COPY export.sql /
#Unpack zip module
RUN mkdir /module
RUN unzip master.zip -d /module

#Run script to build, execute and export results of module
ENTRYPOINT ["/findExecuteExport.sh"]
