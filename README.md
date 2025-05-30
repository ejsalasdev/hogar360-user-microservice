# 👤 User Microservice

[![Java](https://img.shields.io/badge/Java-17-orange.svg)](https://openjdk.java.net/projects/jdk/17/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.3-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![MySQL](https://img.shields.io/badge/MySQL-8.0-blue.svg)](https://www.mysql.com/)
[![JWT](https://img.shields.io/badge/JWT-Auth0-purple.svg)](https://auth0.com/)
[![CI/CD](https://img.shields.io/badge/CI%2FCD-GitHub%20Actions-blue.svg)](https://github.com/features/actions)
[![Docker](https://img.shields.io/badge/Docker-Hub-blue.svg)](https://hub.docker.com/)

Microservicio para la gestión de usuarios (vendedores y compradores) en la plataforma Hogar360. Implementa arquitectura hexagonal y Domain-Driven Design (DDD), con roles, autenticación y autorización basada en JWT y Spring Security.

---

## 🎯 Características Principales

- **Gestión de Usuarios**: CRUD para usuarios vendedores y compradores.
- **Roles**: Soporte para ADMIN (creado automáticamente al levantar el servicio), SELLER y BUYER.
- **Seguridad JWT**: Autenticación y autorización robusta con JWT.
- **Arquitectura Hexagonal + DDD**: Separación clara de capas y lógica de dominio.
- **Persistencia MySQL**: JPA/Hibernate.
- **Validaciones**: Validación estricta de campos y reglas de negocio.
- **Testing**: Pruebas unitarias y de validadores.
- **Documentación API**: Swagger/OpenAPI.
- **CI/CD**: Integración y despliegue automático con Docker y GitHub Actions.

---

## 🏗️ Arquitectura

- **Domain-Driven Design (DDD)**: Modelos de dominio y casos de uso bien definidos.
- **Arquitectura Hexagonal**: Separación entre dominio, aplicación e infraestructura.
- **Puertos y Adaptadores**: Interfaces para la persistencia y la infraestructura.
- **Validadores**: Cadena de validadores para reglas de negocio.

```
src/main/java/com/powerup/usermicroservice/
├── domain/           # Core de dominio (modelos, puertos, casos de uso)
│   ├── model/
│   ├── ports/
│   ├── usecases/
│   ├── enums/
│   └── utils/
├── application/      # Lógica de aplicación (handlers, DTOs)
├── infrastructure/   # Infraestructura (JPA, seguridad, controladores)
│   ├── adapters/
│   ├── controllers/
│   ├── mappers/
│   ├── entities/
│   ├── repositories/
│   └── security/
└── commons/          # Configuración y constantes
```

---

## 🛠️ Stack Tecnológico

- **Java 17**, **Spring Boot 3.4.3**
- **Spring Security**
- **JWT**
- **MySQL 8.0**
- **MapStruct**, **Lombok**
- **JUnit 5**, **Mockito**
- **Swagger/OpenAPI**
- **GitHub Actions**, **Docker**

---

## 🔐 Seguridad y Roles

- **Roles**: ADMIN (creado al inicio), SELLER, BUYER.
- **Autenticación**: JWT, endpoints protegidos y personalizados según rol.
- **Spring Security**: Configuración avanzada de filtros, CORS y sesión stateless.

Variables de entorno relevantes:
```env
JWT_SECRET=your-secret-key
JWT_USER=AUTH0JWT_BACKEND
JWT_EXPIRATION=86400000
```

---

## 📋 Funcionalidades

### Usuarios
- Registro y gestión de vendedores y compradores.
- El admin es creado por defecto al levantar el servicio.
- Validaciones: email, documento, teléfono, edad mínima, etc.

### Autenticación
- Endpoint de login: `/api/v1/auth/login`
- Generación de token JWT al autenticarse correctamente.

### Roles y permisos
- Solo el ADMIN puede crear nuevos usuarios vendedores mediante `/api/v1/user/create`.
- Los endpoints están protegidos y segmentados por rol.

---

## 📖 Endpoints Principales

```http
# Autenticación
POST /api/v1/auth/login           # Login de usuarios (obtiene JWT)

# Usuarios
POST /api/v1/user/create          # Crear usuario vendedor (ADMIN)
```

La documentación interactiva está disponible en:
- **Swagger UI**: http://localhost:8082/swagger-ui/index.html
- **OpenAPI JSON**: http://localhost:8082/v3/api-docs

---

## 🧪 Testing

- Pruebas unitarias para casos de uso, validadores y lógica de dominio.
- Cobertura sobre lógica de negocio (creación y validación de usuarios).
- Ejecución: `./gradlew test`

---

## 🚀 Instalación y Configuración

### Prerrequisitos
- Java 17+
- MySQL 8.0+
- Gradle 7.0+

### Base de Datos
```sql
CREATE DATABASE hogar360_user_db;
```

### Variables de Entorno
```env
DB_HOST=localhost
DB_PORT=3306
DB_NAME=hogar360_user_db
DB_USERNAME=root
DB_PASSWORD=toor
JWT_SECRET=your-secret-key
SERVER_PORT=8082
```

### Ejecución
```bash
# Desarrollo
./gradlew bootRun

# Tests
./gradlew test

# Construcción
./gradlew build
```

---

## 🐳 Docker

### Construcción de imagen
```bash
docker build -t user-microservice .
```

### Ejecución con Docker
```bash
docker run -p 8082:8082 \
  -e DB_HOST=host.docker.internal \
  -e DB_PORT=3306 \
  -e DB_NAME=hogar360_user_db \
  -e DB_USERNAME=root \
  -e DB_PASSWORD=toor \
  -e JWT_SECRET=your-secret-key \
  user-microservice
```

---

## 🌐 Despliegue y CI/CD

- Pipeline GitHub Actions para construcción, testing y despliegue Docker.
- Imagen Docker multi-stage optimizada.
- Exposición del servicio en el puerto 8082.
- Compatible con Docker Hub para despliegue automático.

---

## 🤝 Contribución

1. Haz fork del repositorio.
2. Crea una nueva rama: `git checkout -b feature/nueva-funcionalidad`
3. Implementa y agrega pruebas unitarias.
4. Verifica la cobertura de código.
5. Haz tu Pull Request.

---

**Desarrollado con ❤️ utilizando Java, Spring Boot, DDD y Arquitectura Hexagonal**
