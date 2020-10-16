# Spring graceful shutdown demo
To run:
`./gradlew bootRun`

Graceful shutdown was introduced in [Spring Boot 2.3](https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-2.3-Release-Notes#graceful-shutdown).

`curl localhost:8080/ping -v`

`SIGKILL (9)` - application exists without waiting with non-zero exit value 137

`SIGINT (2) = Ctrl+C` - application waits for requests to finish, but finishes with non-zero exit value 130

calling `curl localhost:8287/actuator/shutdown -X POST -v`- application waits for requests to finish, ends with 0 return code

K8s apps must end with status code 0 otherwise it's taken as failed shutdown.
