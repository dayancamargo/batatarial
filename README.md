# Batatarial

## Batata query example
###### http://localhost:8881/batata

###### http://localhost:8881/batata?name=potato

###### http://localhost:8880/batata?page=0&size=3

###### http://localhost:8880/batata?page=0&size=3&name=potato


## Metrics Actuator examples

###### http://localhost:8880/actuator/health

###### http://localhost:8880/actuator/metrics/

###### http://localhost:8880/actuator/metrics/jvm.memory.max


## Translate examples

###### http://localhost:8880/translate/yoda (post) 
> body: {"text" : "some text to be translated" }

## Country Info service (Soap service)

###### http://localhost:8880/country-info/full-info/{ISOCode}
> ISOCode: 2 position country code (eg. BR, AR, US, JP)

###### http://localhost:8880/country-info/list-continent
