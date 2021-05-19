# syntax=docker/dockerfile
FROM centos:latest as builder


#Install tools required for project, fortran compiler
RUN yum install -y gcc-gfortran gdb make git
RUN yum update -y

#Set maintainer - Optional
LABEL maintainer="Bana Solutions"
LABEL description="container for geomatics modules"

COPY . /ck001_keith
WORKDIR /ck001_keith

#Build and execute fortran module
RUN make
CMD ./ck001.ksh && ls output/
