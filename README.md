# 🎓 Edutech Microservices v2

API REST de una plataforma educativa con la arquitectura de microservicios, desarrollado con **Spring Boot** y **Docker**.

---

## 📋 Requisitos para el despliegue local

- **Docker** (versión 20.10 o superior, incluido Docker compose)
- **Maven**


# 🚀 Instrucciones para el despliegue
Abre una terminal dentro de la carpeta .\Edutech_innovators\ para los siguientes comandos

### 🔧 Compilar el proyecto
#### ⚠️ Importante: La compilación generará archivos JAR y descargará dependencias, lo que incrementará el tamaño del proyecto.

```bash
mvn clean package -DskipTests
```

### 🔼 Levantar el proyecto
#### Generalmente se puede tardar entre 2-3 minutos en levantar todos los contenedores

```bash
docker-compose up -d
```
### ✅ Verifica si estan los contenedores activos
```bash
docker-compose ps
```
## 🔻 Apagar el proyecto y eliminar

### Apaga todos los contenedores y los elimina
```bash
docker-compose down -v --rmi all
```
## 🌐 Endpoints
- La API está disponible en: `http://localhost:8080/api/v2/{microservicio}`
- La coleccion de Postman esta disponible dentro del repositorio para las pruebas de los endpoints

### 👤 Clients

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/api/v2/clients` | Obtener todos los clientes |
| GET | `/api/v2/clients/{id}` | Obtener cliente por ID |
| POST | `/api/v2/clients` | Crear nuevo cliente |
| PUT | `/api/v2/clients/{id}` | Actualizar cliente |
| DELETE | `/api/v2/clients/{id}` | Eliminar cliente por ID |

### 👨‍🏫 Instructors

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/api/v2/instructors` | Obtener todos los instructores |
| GET | `/api/v2/instructors/{id}` | Obtener instructor por ID |
| POST | `/api/v2/instructors` | Crear nuevo instructor |
| PUT | `/api/v2/instructors/{id}` | Actualizar instructor |
| DELETE | `/api/v2/instructors/{id}` | Eliminar instructor por ID |

### 📚 Courses

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/api/v2/courses` | Obtener todos los cursos |
| GET | `/api/v2/courses/{id}` | Obtener curso por ID |
| GET | `/api/v2/courses/instructor/{instructorId}` | Obtener cursos por instructor |
| POST | `/api/v2/courses` | Crear nuevo curso |
| PUT | `/api/v2/courses/{id}` | Actualizar curso |
| DELETE | `/api/v2/courses/{id}` | Eliminar curso |

### 📂 Categories

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/api/v2/categories` | Obtener todas las categorías |

### 📝 Inscriptions

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/api/v2/inscriptions` | Obtener todas las inscripciones |
| GET | `/api/v2/inscriptions/{id}` | Obtener inscripción por ID |
| GET | `/api/v2/inscriptions/client/{clientId}` | Obtener inscripciones por cliente |
