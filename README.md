# Playing around with Scala Play 2.5
* guice 
* async controllers
* test infrastructure
* json capabilities of play

## run with: 
sbt run

## test call:
curl -H "Content-Type: application/json" -X POST -d '{"content":"Example text"}' http://localhost:9000/test
