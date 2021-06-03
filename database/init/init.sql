GRANT ALL PRIVILEGES ON module_database.* TO 'root'@'%';
GRANT ALL PRIVILEGES ON module_database.* TO 'root'@'localhost';

CREATE USER 'test'@'%' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON module_database.* TO 'test'@'%';
grant FILE on *.* to 'test'@'%';
GRANT SUPER ON *.* TO 'test'@'%';
SET GLOBAL local_infile=1;

flush privileges;

USE module_database
CREATE TABLE IF NOT EXISTS moduleOutput (
	moduleId INT PRIMARY KEY auto_increment,
	module_name VARCHAR(255),
	commit_hash VARCHAR(255),
	commit_author VARCHAR(255),
	commit_message VARCHAR(255),
	output BLOB,
	execution_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE IF NOT EXISTS users (
  userid INT PRIMARY KEY auto_increment,
  username VARCHAR(255),
  password VARCHAR(255),
  firstname VARCHAR(255),
  lastname VARCHAR(255)
);

INSERT INTO users (username, password, firstname, lastname) 
VALUES('k', '1', 'keith', 'schumacher');
