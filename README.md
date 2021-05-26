# Setup Instructions
## MYSQL Database
- To start container, move to  **database_container** directory and run: **docker-compose up -d**
- To stop container, move to **database_container** directory and run: **docker-compose down --remove-orphans**

## Run Module
- To build image, move to **module_container** directory and run: **docker build --build-arg GIT_URL="https://github.com/keithSchumacher/ck001_keith/archive/refs/heads/master.zip" . -t module**
- To run container, move to **module_container** directory and run: **docker run --network=geomatics module**
