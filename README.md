# CompanyProject_HEXAG -HEXAGONAL ARQUITECTURE
Contenido:

- [Versiones](#versiones)
- [Correr Proyecto](#correr-proyecto)
- [Endpoints](#endpoints)
- [Setear entorno](#setear-entorno)
- [Tools](#tools)

## Versiones

| Spring Boot | Java | PostgreSQL |
|-------------|------|------------|
|  3.4.3      |  21  |     12     |

## Correr Proyecto

Se debe tener instalado postgreSQL

- Clonar proyecto
- Setear variables de entorno
- Ejecutar "mvn clean install"
- finalmente "run"
- Poblado inicial de datos (si se desea) script en resources/data.sql

## Endpoints

- **POST /company
  
    Endpoint que realiza el alta de subscripción de una empresa.

**REQUEST Ej**
```
|          cuit | companyName |                                                                                                                                              
| -------------:|:-----------:|
|     requerido |   requerido |                                                                 
```
[{
    "cuit":"46666669999",
    "companyName":"Empresa de Prueba 1"
}]
```
    RESPUESTA:
```
[
{
    "idCompany": 1,
    "cuit": "46666669999",
    "companyName": "Empresa de Prueba 1",
    "subscriptionDate": "2025-02-28T17:56:02.6245501"
}
]

```

- **GET /company/subscribed-last-month
  
    Endpoint que lista todas las empresas que se suscribieron el último mes. Este reporte permite conocer por ej, de consumirlo el 28/2/2025,listará todas las empresas que se suscribieron durante todo el mes completo de enero (1 al 31/1/25 por ej)

   RESPUESTA:
```
[
    {
        "idCompany": 1,
        "cuit": "46666669999",
        "companyName": "Empresa de Prueba 1",
        "subscriptionDate": "2025-01-28T17:55:22.317216"
    },
    {
        "idCompany": 2,
        "cuit": "12345678991",
        "companyName": "Empresa de Prueba 1",
        "subscriptionDate": "2025-01-28T17:56:02.62455"
    }
]
```

- **GET /company/transaction-last-month
  
   Endpoint que lista todas las empresas que realizaron transacciones el ultimo mes. Este reporte permite conocer por ej, de consumirlo el 28/2/2025,listará todas las empresas que possen transacciones durante todo el mes completo de enero (1 al 31/1/25 por ej)

  RESPUESTA:
```
{
[
    {
        "idCompany": 1,
        "cuit": "46666669999",
        "companyName": "Empresa de Prueba 1",
        "subscriptionDate": "2025-01-28T17:55:22.317216"
    },
    {
        "idCompany": 2,
        "cuit": "12345678991",
        "companyName": "Empresa de Prueba 1",
        "subscriptionDate": "2025-01-28T17:56:02.62455"
    }
]
}
```
## Setear Entorno

- Setear Variables de entorno:
  
  ```

  DATABASE_URL=;
  DB_USER=;
  DB_PASSWORD=;
  
  ```

## Tools

- Java 21
- Spring boot 3.4.3 
- Maven
- Postgresql DB
- JPA - Hibernate
- Lombok
- IntelliJ Idea
- MapStruct
- Postman
- Arquitectura Hexagonal
