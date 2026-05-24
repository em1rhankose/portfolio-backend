# 🚀 Portfolio Backend

A production-ready RESTful API backend for a personal portfolio website, built with Java 21 and Spring Boot 3.5. Every piece of content on the site is dynamically manageable through an admin panel — from hero text and project details to blog posts with YouTube embeds, freelance services, client testimonials, and educational playlists.

---

## ✨ Features

- 🔐 JWT-based stateless authentication with custom filter chain
- 📝 Full CRUD for all site content modules
- 🗝️ Key-value based dynamic site content management
- 🎬 YouTube embed support for blog posts and educational playlists
- 🛡️ Admin-protected endpoints, public read access
- 🌐 CORS configured for React frontend
- 🏗️ Feature-based package architecture
- 💼 Freelance services management
- ⭐ Client testimonials management
- 🔄 Work process steps management
- 🎓 Educational playlist management

---

## 🛠️ Tech Stack

| Layer | Technology |
|-------|------------|
| Language | Java 21 |
| Framework | Spring Boot 3.5.14 |
| Security | Spring Security + JWT (jjwt 0.11.5) |
| Database | PostgreSQL |
| ORM | Spring Data JPA + Hibernate |
| Build Tool | Maven |
| Utilities | Lombok, Bean Validation |

---

## 📁 Project Structure

```
src/main/java/com/emirhan/portfolio/
├── auth/           → JWT login endpoint (AuthController, AuthService, AuthRequest, AuthResponse)
├── blog/           → Blog post CRUD with YouTube embed support
├── config/         → Security, JWT, CORS configuration (JwtUtil, JwtFilter, SecurityConfig, CorsConfig)
├── contact/        → Contact info and social media links CRUD
├── content/        → Key-value based dynamic site content CRUD
├── playlist/       → Educational playlist and video CRUD
├── project/        → Portfolio project CRUD with detail page support
├── service/        → Freelance services CRUD
├── testimonial/    → Client testimonials CRUD
├── user/           → User entity, UserDetailsService
└── workprocess/    → Work process steps CRUD
```

---

## 🗄️ Database Schema

The backend manages **10 tables** in PostgreSQL:

| Table | Description |
|-------|-------------|
| users | Admin user with JWT auth |
| projects | Portfolio projects with detail content |
| blog_posts | Blog posts with YouTube embed support |
| site_content | Key-value store for dynamic site content |
| contact_info | Social media and contact links |
| services | Freelance service offerings |
| testimonials | Client testimonials and reviews |
| work_process | Step-by-step work process description |
| playlist | Educational video playlists |
| playlist_video | Videos belonging to playlists |

---

## 🔌 API Endpoints

### Auth
| Method | Endpoint | Auth | Description |
|--------|----------|------|-------------|
| POST | /api/auth/login | Public | Login, returns JWT token |

### Projects
| Method | Endpoint | Auth | Description |
|--------|----------|------|-------------|
| GET | /api/projects | Public | Get all projects |
| GET | /api/projects/{id} | Public | Get project by ID |
| POST | /api/projects | Admin | Create project |
| PUT | /api/projects/{id} | Admin | Update project |
| DELETE | /api/projects/{id} | Admin | Delete project |

### Blog
| Method | Endpoint | Auth | Description |
|--------|----------|------|-------------|
| GET | /api/blog | Public | Get all visible blog posts |
| GET | /api/blog/{id} | Public | Get blog post by ID |
| POST | /api/blog | Admin | Create blog post |
| PUT | /api/blog/{id} | Admin | Update blog post |
| DELETE | /api/blog/{id} | Admin | Delete blog post |

### Site Content
| Method | Endpoint | Auth | Description |
|--------|----------|------|-------------|
| GET | /api/content | Public | Get all site content |
| GET | /api/content/{key} | Public | Get content by key |
| POST | /api/content | Admin | Create content entry |
| PUT | /api/content/{key} | Admin | Update content by key |
| DELETE | /api/content/{id} | Admin | Delete content entry |

### Contact
| Method | Endpoint | Auth | Description |
|--------|----------|------|-------------|
| GET | /api/contact | Public | Get all visible contact info |
| POST | /api/contact | Admin | Create contact info |
| PUT | /api/contact/{id} | Admin | Update contact info |
| DELETE | /api/contact/{id} | Admin | Delete contact info |

### Services
| Method | Endpoint | Auth | Description |
|--------|----------|------|-------------|
| GET | /api/services | Public | Get all services |
| POST | /api/services | Admin | Create service |
| PUT | /api/services/{id} | Admin | Update service |
| DELETE | /api/services/{id} | Admin | Delete service |

### Testimonials
| Method | Endpoint | Auth | Description |
|--------|----------|------|-------------|
| GET | /api/testimonials | Public | Get all visible testimonials |
| POST | /api/testimonials | Admin | Create testimonial |
| PUT | /api/testimonials/{id} | Admin | Update testimonial |
| DELETE | /api/testimonials/{id} | Admin | Delete testimonial |

### Work Process
| Method | Endpoint | Auth | Description |
|--------|----------|------|-------------|
| GET | /api/work-process | Public | Get all work process steps |
| POST | /api/work-process | Admin | Create step |
| PUT | /api/work-process/{id} | Admin | Update step |
| DELETE | /api/work-process/{id} | Admin | Delete step |

### Playlists
| Method | Endpoint | Auth | Description |
|--------|----------|------|-------------|
| GET | /api/playlists | Public | Get all playlists |
| GET | /api/playlists/{id} | Public | Get playlist by ID |
| POST | /api/playlists | Admin | Create playlist |
| PUT | /api/playlists/{id} | Admin | Update playlist |
| DELETE | /api/playlists/{id} | Admin | Delete playlist |

### Playlist Videos
| Method | Endpoint | Auth | Description |
|--------|----------|------|-------------|
| GET | /api/playlist-videos/{playlistId} | Public | Get videos by playlist ID |
| POST | /api/playlist-videos | Admin | Add video to playlist |
| PUT | /api/playlist-videos/{id} | Admin | Update video |
| DELETE | /api/playlist-videos/{id} | Admin | Delete video |

---

## ⚙️ Setup

### Prerequisites
- Java 21+
- PostgreSQL
- Maven

### Installation

**1. Clone the repository**
```bash
git clone https://github.com/em1rhankose/portfolio-backend.git
cd portfolio-backend
```

**2. Create PostgreSQL database**
```sql
CREATE DATABASE portfolio_db;
```

**3. Configure application properties**
```bash
cp src/main/resources/application.properties.example src/main/resources/application.properties
```
Fill in your database credentials and JWT secret key (minimum 32 characters).

**4. Run the application**
```bash
./mvnw spring-boot:run
```

API will be available at `http://localhost:8080`

---

## 🔒 Authentication

All admin endpoints require a Bearer token in the Authorization header:

```
Authorization: Bearer <your_jwt_token>
```

Obtain a token by sending a POST request to `/api/auth/login`:

```json
{
  "username": "your_username",
  "password": "your_password"
}
```

## 📄 License

This project is licensed under the MIT License.
