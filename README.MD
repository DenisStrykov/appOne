
для теста отправки сообщений с Kafka:

[Тестовое сообщение](http://localhost:8082/api/v1/data/send)

{
"sensorId": 3,
"timestamp": "2024-02-10T14:14:14",
"measurement": 16.5,
"measurementType": "TEMPERATURE"
}

[Ряд тестовых сообщений](http://localhost:8082/api/v1/data/test/send)

{
"delayInSeconds": 3,
"measurementTypes": [
"POWER",
"VOLOTAGE",
"TEMPERATURE"
]
}



для теста отправки сообщений с gRPC:

[Тестовое сообщение](http://localhost:8082/api/v1/data/grpc/send)

{
"sensorId": 3,
"timestamp": "2024-02-10T14:14:14",
"measurement": 16.5,
"measurementType": "TEMPERATURE"
}

[Ряд тестовых сообщений](http://localhost:8082/api/v1/data/grpc/test/send)

{
"delayInSeconds": 3,
"measurementTypes": [
"POWER",
"VOLOTAGE",
"TEMPERATURE"
]
}