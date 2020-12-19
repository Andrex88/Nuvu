@echo off
CALL mvnw.cmd clean package -DskipTests=true
CALL java -jar target/springboot-servi-oauth-0.0.1-SNAPSHOT.jar
