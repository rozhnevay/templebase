@echo off

docker run --name dom-mysql-admin  --net=mysql-network  -e MYSQL_ROOT_PASSWORD=password  -e PMA_HOST="dom-mysql" -e PMA_PORT=3306  -p 8080:80 -d phpmyadmin/phpmyadmin