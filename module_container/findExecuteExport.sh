#!/usr/bin/bash

#change working directory to directory containing ksh
cd "$(find /module -maxdepth 1 -mindepth 1 -type d)"
#Execute .ksh
find . -iname "*.ksh" -exec chmod +x {} \; -exec {} \;
#Show output in terminal
find output/ -name "*.txt" -exec cat {} \;
MODULE_NAME=$(find . -mindepth 1 -type f -iname "*.f")
#Send output to mysql container
username=test
password=password
host=module-database
mysql -h$host  -u$username -p$password -e"source /export.sql"
