FROM oracle/graalvm-ce:20.2.0-java8 as graalvm
RUN gu install native-image

COPY . /home/app/micronaut-dbclient
WORKDIR /home/app/micronaut-dbclient

RUN native-image -cp build/libs/micronaut-dbclient-*-all.jar

FROM frolvlad/alpine-glibc
RUN apk update && apk add libstdc++
EXPOSE 8080
COPY --from=graalvm /home/app/micronaut-dbclient/micronaut-dbclient /app/micronaut-dbclient
ENTRYPOINT ["/app/micronaut-dbclient"]
