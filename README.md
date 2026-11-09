# reservas-academicas

Proyecto de gestión de reservas de espacios académicos (salones, laboratorios, salas).

## Stack tecnológico

- Java 27 + Spring Boot 4
- Spring Data JPA
- Oracle Database (producción) / H2 (tests)
- Maven (wrapper incluido)

## Estructura del proyecto

```
reservas-academicas/
├── src/main/java/com/grupo2/reservas/
│   ├── ReservasApplication.java
│   ├── controller/      # EspacioController, UsuarioController, HorarioController, ReservaController
│   ├── service/         # EspacioService, UsuarioService, HorarioService, ReservaService
│   ├── repository/      # EspacioRepository, UsuarioRepository, HorarioRepository, ReservaRepository
│   ├── entity/          # Espacio, Usuario, Horario, Reserva
│   ├── dto/             # EspacioDTO, UsuarioDTO, HorarioDTO, ReservaDTO, DisponibilidadDTO
│   ├── exception/       # RecursoNoEncontradoException, ReservaConflictivaException,
│   │                     # DatosInvalidosException, GlobalExceptionHandler
│   ├── config/WebConfig.java
│   ├── interceptor/LoggingInterceptor.java
│   └── aspect/LoggingAspect.java
├── src/main/resources/application.properties
├── src/test/java/
├── database/            # schema.sql y datos_prueba.sql (Oracle)
└── .github/workflows/ci.yml
```

## Requisitos

- JDK 27
- Maven con wrapper (`./mvnw`), no requiere instalación global

## Ejecutar

```bash
./mvnw spring-boot:run        # Linux/macOS
mvnw.cmd spring-boot:run      # Windows
```

## Tests

```bash
./mvnw test
```

## Integrantes

| Nombre | Parte asignada |
|--------|----------------|
| [pendiente] | [pendiente] |
