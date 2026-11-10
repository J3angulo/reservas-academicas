# Taller Grupal Reservas-academicas

Desarrollo de una API REST para la gestión y administración de espacios académicos:
Salones, Laboratorios y salas de reuniones. Ests proyecto se desarrollada con **Spring Boot** y arquitectura de capas.

## Integrantes Grupo 2

| Integrante | Parte asignada |
|------------|----------------|
| Sofía Rivas (Integrante 1) | `Espacio`: Entity, Repository, Service, Controller y DTO |
| José Angulo (Integrante 2) | `Usuario` y `Horario`: Entity, Repository, Service, Controller y DTO |
| Jessica Sanchez (Integrante 3) | `Reserva` y `DisponibilidadDTO`: Entity, Repository, Service, Controller y DTO |
| Marco Cañarejo (Integrante 4) | Excepciones y manejo centralizado, configuración (WebConfig), interceptor HTTP, aspecto (AOP), `application.properties`, scripts de base de datos, CI, `pom.xml` y `README.md` |

## Tecnologías

- **Java 27** y **Spring Boot 4.1**
- **Spring Web MVC** → controladores REST
- **Spring Data JPA** → acceso a datos
- **Base de datos relacional**
- **Maven** con wrapper (`mvnw`)
- **GitHub** + **GitHub Actions**

## Arquitectura de capas

```
Petición HTTP
     |
     ▼
LoggingInterceptor: Se activa e intercepta los registro de solicitudes
     |
     ▼
Controller  --►  Service  --►  Repository  --►  Entity / Base de datos
 (recibe y        (lógica  -->      (consultas       (mapeo de tablas)
  valida el        de negocio)    Spring Data)
  DTO)
     │
     ├-- si hay algún error --► GlobalExceptionHandler --► respuesta HTTP (404/409/400)
     │
     ▼
LoggingAspect: Permite medir el tiempo de ejecución de cada controller
```

- En las condiciones del proyecto los controllers **no contienen lógica de negocio**: solo reciben el DTO, llaman al service y devuelven la respuesta.
- Todas las respuestas que se genéran de los errores salen de un único punto: `exception/GlobalExceptionHandler`.


## Estructura del proyecto

```
reservas-academicas/
├-- src/main/java/com/grupo2/reservas/
│   ├-- ReservasApplication.java          # Este es el punto de arranque
│   ├-- controller/                       # Los endpoints REST
│   ├-- service/                          # La lógica del negocio
│   ├-- repository/                       # Las consultas Spring Data
│   ├-- entity/                           # Las entidades JPA (tablas)
│   ├-- dto/                              # Los objetos que realizan la transferencia
│   ├-- exception/                        # Las excepciones + handler
│   ├-- config/WebConfig.java             # Los registro del interceptor
│   ├-- interceptor/LoggingInterceptor.java  # El middleware HTTP
│   └-- aspect/LoggingAspect.java         # El AOP que son los tiempos de ejecución
├-- src/main/resources/application.properties
├-- src/test/java/                        # pruebas
├-- database/
│   ├-- schema.sql                        # El esquema Oracle con 4 tablas
│   └-- datos_prueba.sql                  # datos de prueba
└-- .github/workflows/ci.yml              # pipeline de GitHub Actions
