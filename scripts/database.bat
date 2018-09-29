@echo off
docker network create mysql-network

docker run --name dom-mysql  --net=mysql-network  -p 3306:3306  -e MYSQL_ROOT_PASSWORD=password  -v database:/var/lib/mysql   -d mysql:5.7.13