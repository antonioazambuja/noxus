FROM gradle:jdk8-alpine AS BUILD
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build

FROM openjdk:8-alpine
LABEL maintainer="Antonio Azambuja <antonioazambuja_@hotmail.com>"
ENV APP_HOME=/usr/share/noxus
WORKDIR ${APP_HOME}
COPY --from=BUILD /home/gradle/src/build/libs/noxus.jar ${APP_HOME}
EXPOSE 8080
CMD [ "sh", "-c", "java -jar ${APP_HOME}/noxus.jar" ]
