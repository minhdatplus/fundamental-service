# fundamental service

```
git clone https://github.com/minhdatplus/fundamental-service

docker build -t fundamental-service:1.0 .

docker run -it -d -p 8080:8080 fundamental-service:1.0 .
```

Truy cập API Document tại đường dẫn
```
http://localhost:8080/fundamental/swagger-ui.html#/
```
