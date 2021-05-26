GRANT ALL PRIVILEGES ON module_database.* TO 'root'@'%';
GRANT ALL PRIVILEGES ON module_database.* TO 'root'@'localhost';

CREATE USER 'test'@'%' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON module_database.* TO 'test'@'%';
grant FILE on *.* to 'test'@'%';

flush privileges;

USE module_database
CREATE TABLE IF NOT EXISTS moduleOutput (
	moduleId INT PRIMARY KEY auto_increment,
	name VARCHAR(255),
#	module BLOB NOT NULL,
#	input BLOB,
#	output BLOB,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
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
