#!/usr/bin/bash

#Execute .ksh
find . -iname "*.ksh" -exec chmod +x {} \; -exec {} \;
#Show output in terminal
#find output/ -name "*.txt" -exec cat {} \;
#MODULE_NAME=$(find . -mindepth 1 -type f -iname "*.f")
########################################################
#Send output to mysql container
username=test
password=password
host=geomatics-database
########################################################
git_hash=$(git log --pretty=format:"%h" -1)
full_hash=$(git log --pretty=format:"%H" -1)
git_author=$(git log --pretty=format:"%an" -1)
git_time=$(git log --pretty=format:"%ar" -1)
git_message=$(git log --pretty=format:"%s" -1)
repo_name=$(basename $(git remote get-url origin))
repo_name=${repo_name%%.*}
output_file=$(find output/ -name "*.txt")
#########################################################
mysql -h$host --local-infile=1 -u$username -p$password <<EOF 

SET GLOBAL local_infile=1;
USE geomatics_database

# Get output file
CREATE TEMPORARY TABLE IF NOT EXISTS temp (
	id INT PRIMARY KEY auto_increment,
	output BLOB
);

LOAD DATA LOCAL INFILE "$output_file" INTO TABLE temp
FIELDS TERMINATED BY "********"
LINES TERMINATED BY "*********"
(output); 

INSERT INTO results(moduleName, commitHash, fullHash, author, commitMessage, output)
VALUES("$repo_name", "$git_hash", "$full_hash", "$git_author", "$git_message", (SELECT output from temp where id =1));

DROP TEMPORARY TABLE temp;
EOF
