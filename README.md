# Spring Security Sample Project

## Uses
- Spring Boot 3
- Spring Security 6
- Spring Data JPA
- Thymeleaf
- MySQL

## DB Configuration

mysql 을 로컬에 설치하고 실행하는 방법 (env: local)

mysql 을 로컬에 직접 설치하고 proofy db 및 유저를 추가해야합니다.
```shell
CREATE DATABASE mysql_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE USER 'spring'@'localhost' IDENTIFIED BY 'spring0!';
GRANT ALL PRIVILEGES ON *.* TO 'spring'@'localhost' WITH GRANT OPTION;

CREATE USER 'spring'@'%' IDENTIFIED BY 'spring0!';
GRANT ALL PRIVILEGES ON *.* TO 'spring'@'%' WITH GRANT OPTION;

flush privileges;

SPRING_PROFILES_ACTIVE=local ./gradlew :bootRun  
```