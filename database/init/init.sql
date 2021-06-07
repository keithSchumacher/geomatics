GRANT ALL PRIVILEGES ON geomatics_database.* TO 'root'@'%';
GRANT ALL PRIVILEGES ON geomatics_database.* TO 'root'@'localhost';

CREATE USER 'test'@'%' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON geomatics_database.* TO 'test'@'%';
grant FILE on *.* to 'test'@'%';
GRANT SUPER ON *.* TO 'test'@'%';
SET GLOBAL local_infile=1;

flush privileges;

USE geomatics_database
# -----------------------------------
CREATE TABLE IF NOT EXISTS results (
	resultId INT PRIMARY KEY auto_increment,
	moduleName VARCHAR(255),
	commitHash VARCHAR(255),
	fullHash VARCHAR(255),
	author VARCHAR(255),
	commitMessage VARCHAR(255),
	output BLOB,
	executionDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
# -----------------------------------
CREATE TABLE IF NOT EXISTS users (
  userid INT PRIMARY KEY auto_increment,
  username VARCHAR(255),
  password VARCHAR(255),
  firstname VARCHAR(255),
  lastname VARCHAR(255)
);
INSERT INTO users (username, password, firstname, lastname) 
VALUES('k', '1', 'keith', 'schumacher');
INSERT INTO users (username, password, firstname, lastname) 
VALUES('s', '1', 'Sarah', 'Doe');
# -----------------------------------
CREATE TABLE IF NOT EXISTS modules (
	moduleId INT PRIMARY KEY auto_increment,
	moduleName VARCHAR (255),
	gitURL VARCHAR (255),
	hostedPublicly BOOLEAN,
	fullHash VARCHAR(255),
	userid INT,
	CONSTRAINT fk_modules_users foreign key (userid) REFERENCES users (userid)
);
INSERT INTO modules (moduleName, gitURL, hostedPublicly, userid)
VALUES('ck001', 'https://github.com/keithSchumacher/ck001_keith.git', TRUE, 1) 
