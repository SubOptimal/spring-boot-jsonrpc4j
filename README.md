This repository provides a small working example showing the use of Spring Boot and JSON-RPC. As JSON-RPC implementation [jsonrpc4j](https://github.com/briandilley/jsonrpc4j) is used.

The code is based on the post [Is Java Remote Procedure Call Dead in the REST Age?](https://dzone.com/articles/is-java-remote-procedure-call-dead-in-the-rest-age) written by [Lieven Doclo](https://dzone.com/users/281312/lievendoclo.html).

## build

```shell
mvn clean package
```

## run the server

```
java -jar target/JsonRPC-0.0.1-SNAPSHOT.jar
```

## send a JSON RPC request

```shell
curl -v -H "Content-Type: application/json" \
    -d '{"id":0, "method":"sayHelloWorld", "params":["John Doe"]}' \
    http://localhost:8080/rpc/myservice
```

## output

```
> POST /rpc/myservice HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.45.0
> Accept: */*
> Content-Type: application/json
> Content-Length: 57
> 
* upload completely sent off: 57 out of 57 bytes
< HTTP/1.1 200 OK
< Server: Apache-Coyote/1.1
< Content-Type: application/json-rpc;charset=UTF-8
< Transfer-Encoding: chunked
< Date: Wed, 16 Dec 2015 00:12:59 GMT
< 
{"jsonrpc":"2.0","id":0,"result":"Hello world, John Doe"}

```