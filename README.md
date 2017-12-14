# Flight Details - API e Frontend

Sistema de informação de voos.
Backend desenvolvido em Java e Frontend desenvolvido em AngularJS.

## Documentação

As telas (frontend) podem ser visualizadas em:

- [http://localhost:8080/#/flight](http://localhost:8080/#/flight)
- [http://localhost:8080/#/flight/{id}](http://localhost:8080/#/flight/{id})

## Tecnologias e Requisitos

- Java 1.8
- AngularJS
- Bootstrap
- Spring Boot 1.5
- Maven 3.5.0
- JPA
- H2
- JUnit

## Suíte de testes

    $ mvn test

## Instalação

    $ mvn spring-boot:run

## API

### Listar voos

**Exemplo de requisição:**

- **GET** [http://localhost:8080/api/flights](http://localhost:8080/api/flights)
- **Accept:** application/json
- **Content-Type:** application/json

**Exemplo de resposta:**

- **200** OK

```json
    {
       "content":[
          {
             "id":1,
             "departureTime":1515981600000,
             "arrivalTime":1518660000000,
             "departureCity":{
                "id":5,
                "name":"Belo Horizonte"
             },
             "arrivalCity":{
                "id":6,
                "name":"Fortaleza"
             },
             "airplane":{
                "id":1,
                "name":"Airbus A300"
             },
             "pilot":{
                "id":6,
                "name":"Howard Hughes"
             },
             "status":{
                "id":3,
                "name":"Atrasado"
             }
          },
          {
             "id":2,
             "departureTime":1515636000000,
             "arrivalTime":1515636000000,
             "departureCity":{
                "id":9,
                "name":"Porto Alegre"
             },
             "arrivalCity":{
                "id":8,
                "name":"Recife"
             },
             "airplane":{
                "id":3,
                "name":"Boeing 757"
             },
             "pilot":{
                "id":7,
                "name":"Ricardo Kirk"
             },
             "status":{
                "id":1,
                "name":"Confirmado"
             }
          },
          {
             "id":3,
             "departureTime":1515636000000,
             "arrivalTime":1515636000000,
             "departureCity":{
                "id":4,
                "name":"Salvador"
             },
             "arrivalCity":{
                "id":2,
                "name":"São Paulo"
             },
             "airplane":{
                "id":4,
                "name":"Embraer ERJ-190"
             },
             "pilot":{
                "id":5,
                "name":"Gabriel Voisin"
             },
             "status":{
                "id":1,
                "name":"Confirmado"
             }
          },
          {
             "id":4,
             "departureTime":1517277600000,
             "arrivalTime":1517277600000,
             "departureCity":{
                "id":7,
                "name":"Curitiba"
             },
             "arrivalCity":{
                "id":9,
                "name":"Porto Alegre"
             },
             "airplane":{
                "id":6,
                "name":"Airbus A380"
             },
             "pilot":{
                "id":4,
                "name":"José Costa"
             },
             "status":{
                "id":3,
                "name":"Atrasado"
             }
          },
          {
             "id":5,
             "departureTime":1519873200000,
             "arrivalTime":1517450400000,
             "departureCity":{
                "id":8,
                "name":"Recife"
             },
             "arrivalCity":{
                "id":7,
                "name":"Curitiba"
             },
             "airplane":{
                "id":6,
                "name":"Airbus A380"
             },
             "pilot":{
                "id":9,
                "name":"Edu Chaves"
             },
             "status":{
                "id":1,
                "name":"Confirmado"
             }
          },
          {
             "id":6,
             "departureTime":1515895200000,
             "arrivalTime":1515895200000,
             "departureCity":{
                "id":1,
                "name":"Brasília"
             },
             "arrivalCity":{
                "id":5,
                "name":"Belo Horizonte"
             },
             "airplane":{
                "id":5,
                "name":"Boeing 787"
             },
             "pilot":{
                "id":3,
                "name":"Doru Davidovici"
             },
             "status":{
                "id":2,
                "name":"Cancelado"
             }
          },
          {
             "id":7,
             "departureTime":1515290400000,
             "arrivalTime":1515290400000,
             "departureCity":{
                "id":3,
                "name":"Rio de Janeiro"
             },
             "arrivalCity":{
                "id":4,
                "name":"Salvador"
             },
             "airplane":{
                "id":2,
                "name":"Boeing 707"
             },
             "pilot":{
                "id":2,
                "name":"Charles Lindbergh"
             },
             "status":{
                "id":1,
                "name":"Confirmado"
             }
          },
          {
             "id":8,
             "departureTime":1516586400000,
             "arrivalTime":1516586400000,
             "departureCity":{
                "id":2,
                "name":"São Paulo"
             },
             "arrivalCity":{
                "id":3,
                "name":"Rio de Janeiro"
             },
             "airplane":{
                "id":5,
                "name":"Boeing 787"
             },
             "pilot":{
                "id":1,
                "name":"Alvin M. Johnston"
             },
             "status":{
                "id":3,
                "name":"Atrasado"
             }
          }
       ],
       "totalPages":1,
       "totalElements":8,
       "last":true,
       "size":20,
       "number":0,
       "sort":null,
       "first":true,
       "numberOfElements":8
    }
```

### Exibir detalhes do voo

**Exemplo de requisição:**

- **GET** [http://localhost:8080/api/flights/{id}](http://localhost:8080/api/flights/{id})
- **Accept:** application/json
- **Content-Type:** application/json

**Exemplo de resposta:**

- **200** OK

```json
    {
       "id":1,
       "departureTime":1515981600000,
       "arrivalTime":1518660000000,
       "departureCity":{
          "id":5,
          "name":"Belo Horizonte"
       },
       "arrivalCity":{
          "id":6,
          "name":"Fortaleza"
       },
       "airplane":{
          "id":1,
          "name":"Airbus A300"
       },
       "pilot":{
          "id":6,
          "name":"Howard Hughes"
       },
       "status":{
          "id":3,
          "name":"Atrasado"
       }
    }
```