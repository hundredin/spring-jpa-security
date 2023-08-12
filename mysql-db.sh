#!/bin/bash

docker run --name mysql-db \
  -p 3306:3306 \
  -e MYSQL_ROOT_PASSWORD=mysql0! \
  -v ~/devtools/docker-volumes/mysql-db/mysql:/var/lib/mysql \
  -d arm64v8/mysql:8 \
  --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci
