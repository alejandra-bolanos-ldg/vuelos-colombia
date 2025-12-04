# Sistema de Gestión de Vuelos

Aplicación web Full Stack para la búsqueda, gestión y reserva de vuelos, con autenticación basada en roles (usuario / administrador), CRUD completo, generación de reportes y arquitectura cliente–servidor moderna.

- **Frontend:** React 18 + React Router DOM + Hooks + Context API
- **Backend:** Spring Boot 3 + Spring Security + JWT + MySQL + JPA/Hibernate
- **Despliegue:** Railway (Backend) + GitHub Pages (Frontend)

---

## Demo en Vivo

Frontend:
[https://alejandra-bolanos-ldg.github.io/vuelos-colombia/](https://alejandra-bolanos-ldg.github.io/vuelos-colombia/)

Backend (solo API):
Desplegado en Railway

---

## Características Principales

### Autenticación y Roles

* Login y registro con validaciones
* Roles: **Usuario** y **Administrador**
* Persistencia de sesión
* Rutas protegidas por rol
* JWT para autenticación sin estado

### Funcionalidades de Usuario

* Búsqueda de vuelos
* Visualización de resultados
* Reserva de vuelos
* Gestión de reservas personales (historial)

### Funcionalidades de Administrador

* CRUD completo de vuelos
* Gestión de pasajeros
* Consulta de reservas
* Generación de reportes PDF de vuelos y pasajeros

### Arquitectura del Frontend

```
src/
├── components/          # Componentes reutilizables
├── pages/               # Páginas principales (Auth, Admin, Usuario)
├── context/             # Estado global (AuthContext)
├── hooks/               # Custom Hooks (useForm)
├── utils/               # Validación, helpers, formateo
├── data/                # Datos mock iniciales
└── assets/              # Imágenes y recursos
```

### Patrones implementados

* Componentes reutilizables (Button, FormInput, FormSelect)
* Context API para autenticación
* Custom Hooks para manejo de formularios
* Arquitectura modular por páginas y componentes
* Validación en tiempo real en formularios
* Diseño responsive (mobile-first)

---

## Backend – Arquitectura y Endpoints

### Tecnologías

* Java 17
* Spring Boot 3
* Spring Web
* Spring Data JPA (Hibernate)
* Spring Security + JWT
* MySQL
* Apache PDFBox (reportes PDF)
* Lombok

### Modelo de Datos

* `Usuario` (1..*) `Rol`
* `Reserva` (muchos a 1) `Usuario`
* `Reserva` (muchos a 1) `Vuelo`
* `Vuelo`

### Endpoints Principales

#### Autenticación

```
POST /api/auth/register
POST /api/auth/login
```

#### Vuelos

```
GET    /api/vuelos
GET    /api/vuelos/buscar
POST   /api/vuelos            (ADMIN)
PUT    /api/vuelos/{id}       (ADMIN)
DELETE /api/vuelos/{id}       (ADMIN)
GET    /api/vuelos/reporte/pdf
GET    /api/vuelos/{id}/pasajeros/pdf
```

#### Reservas

```
POST /api/reservas/{vueloId}
GET  /api/reservas/me
GET  /api/reservas/vuelo/{vueloId}
DELETE /api/reservas/{id}
```

#### Usuarios

```
GET /api/usuarios           (ADMIN)
GET /api/usuarios/me
PUT /api/usuarios/me/update
```

---

## Instalación y Ejecución Local

### Backend

```bash
cd backend
mvn spring-boot:run
```

### Frontend

```bash
cd frontend
npm install
npm start
```

---

## Despliegue

* **Backend:** Railway
* **Frontend:** GitHub Pages usando HashRouter
* Variables de entorno seguras en Railway (DB, JWT)

---

## Licencia

Proyecto académico – Uso libre para aprendizaje.
