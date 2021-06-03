# Setup Instructions
## MYSQL Database
- To start container, move to  **database** directory and run: **docker-compose up -d**
- To stop container, move to **database** directory and run: **docker-compose down --remove-orphans**

## Run Frontend
- To build image, move to **frontend** directory and run: **docker build -t frontend .**
- To run container, move to **frontend** directory and run: **docker run -d -p 8080:8080 --network geomatics frontend**
- Access frontend at **http://localhost:8080/home** default user and password are **k** and **1** respectively.

## Run Module
- To build image, move to **module** directory and run: **docker build --build-arg GIT_URL="https://github.com/keithSchumacher/ck001_keith/archive/refs/heads/master.zip" . -t module**
- To run container, move to **module** directory and run: **docker run --network=geomatics module**
