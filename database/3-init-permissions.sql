GRANT ALL PRIVILEGES ON DATABASE client_microservice TO client_user;
GRANT ALL PRIVILEGES ON DATABASE course_microservice TO course_user;
GRANT ALL PRIVILEGES ON DATABASE instructor_microservice TO instructor_user;
GRANT ALL PRIVILEGES ON DATABASE inscription_microservice TO inscription_user;
GRANT ALL PRIVILEGES ON DATABASE evaluation_microservice TO evaluation_user;

-- Client microservice
\c client_microservice;
GRANT ALL ON SCHEMA public TO client_user;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO client_user;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public TO client_user;
-- Permisos para futuras tablas
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT ALL ON TABLES TO client_user;
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT ALL ON SEQUENCES TO client_user;

-- Course microservice
\c course_microservice;
GRANT ALL ON SCHEMA public TO course_user;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO course_user;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public TO course_user;
-- Permisos para futuras tablas
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT ALL ON TABLES TO course_user;
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT ALL ON SEQUENCES TO course_user;

-- Instructor microservice
\c instructor_microservice;
GRANT ALL ON SCHEMA public TO instructor_user;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO instructor_user;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public TO instructor_user;
-- Permisos para futuras tablas
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT ALL ON TABLES TO instructor_user;
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT ALL ON SEQUENCES TO instructor_user;

-- Inscription microservice
\c inscription_microservice;
GRANT ALL ON SCHEMA public TO inscription_user;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO inscription_user;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public TO inscription_user;
-- Permisos para futuras tablas
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT ALL ON TABLES TO inscription_user;
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT ALL ON SEQUENCES TO inscription_user;