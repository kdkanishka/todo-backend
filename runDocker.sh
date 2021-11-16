#!/bin/bash

docker stop todoservice1
docker rm todoservice1
docker run --name todoservice1 \
    -e ENV=PROD \
    -e QUARKUS_PROFILE=prod \
    -e QUARKUS_DATASOURCE_JDBC_URL=jdbc:mariadb://192.168.8.103:33061/tododb \
    -e QUARKUS_DATASOURCE_PASSWORD='mypass123' \
    -itd -p 18080:8080 kdkanishka/todo-service:1.0
