## Micronaut Reactive DbClient

Simple CRUD services using Micronaut framework with MongoDB in reactive style

------

Sample POST 
```
curl --location --request POST 'http://localhost:8080/api/v1/bicycle' \
--header 'Content-Type: application/json' \
--data-raw '{
   "brand" : "Element",
   "name" : "Police",
   "gear" : 5,
   "type" : "FOLDING",
   "colour": "Red",
   "price" : 2120.00
}'
```
 
 
 Sample GET 
 
 ```
curl --location --request GET 'http://localhost:8080/api/v1/bicycle' \
--header 'Content-Type: application/json' \
--data-raw '{
   "brand" : "Polygon",
   "name" : "Polygon Rogue",
   "gear" : 1 ,
   "type" : "BMX",
   "colour": "Hitam",
   "price" : 1300.00
}'
```


- [Micronaut Micronaut HTTP Client documentation](https://docs.micronaut.io/latest/guide/index.html#httpClient)

