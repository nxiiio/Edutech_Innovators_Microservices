INSERT INTO category (name_category) VALUES
    ('Programación Web'),           -- ID: 1
    ('Base de Datos'),              -- ID: 2
    ('Desarrollo Mobile'),          -- ID: 3
    ('Machine Learning'),           -- ID: 4
    ('Ciberseguridad'),            -- ID: 5
    ('DevOps'),                    -- ID: 6
    ('UX/UI Design'),              -- ID: 7
    ('Cloud Computing'),           -- ID: 8
    ('Análisis de Datos'),         -- ID: 9
    ('Arquitectura de Software');  -- ID: 10


INSERT INTO course (name_course, description_course, id_instructor, id_category) VALUES
    -- Cursos de Programación Web (Categoría 1)
    ('Desarrollo Frontend con React', 'Creación de interfaces de usuario modernas y responsivas', 1, 1),
    ('Fundamentos de HTML y CSS', 'Bases del desarrollo web frontend', 1, 1),

    -- Cursos de Base de Datos (Categoría 2)
    ('Bases de Datos Relacionales', 'Diseño y gestión de bases de datos SQL', 2, 2),
    ('Optimización de Consultas SQL', 'Técnicas avanzadas para mejorar el rendimiento de BD', 2, 2),

    -- Cursos de Desarrollo Mobile (Categoría 3)
    ('Desarrollo de Apps Android', 'Creación de aplicaciones móviles nativas para Android', 3, 3),
    ('Flutter para Multiplataforma', 'Desarrollo de apps móviles con Flutter', 3, 3),

    -- Cursos de Machine Learning (Categoría 4)
    ('Introducción al Machine Learning', 'Fundamentos de aprendizaje automático con Python', 4, 4),
    ('Deep Learning con TensorFlow', 'Redes neuronales profundas para IA', 4, 4),

    -- Cursos de Ciberseguridad (Categoría 5)
    ('Seguridad en Aplicaciones Web', 'Técnicas de protección contra vulnerabilidades', 5, 5),
    ('Ethical Hacking', 'Pruebas de penetración y auditorías de seguridad', 5, 5),

    -- Cursos de DevOps (Categoría 6)
    ('Docker y Containerización', 'Despliegue de aplicaciones con contenedores', 6, 6),
    ('CI/CD con Jenkins', 'Integración y despliegue continuo automatizado', 6, 6),

    -- Cursos de UX/UI Design (Categoría 7)
    ('Diseño de Experiencia de Usuario', 'Principios y metodologías de UX Design', 7, 7),
    ('Prototipado con Figma', 'Herramientas de diseño para interfaces digitales', 7, 7),

    -- Cursos de Cloud Computing (Categoría 8)
    ('AWS Cloud Fundamentals', 'Servicios básicos de Amazon Web Services', 8, 8),
    ('Kubernetes en la Nube', 'Orquestación de contenedores en cloud', 8, 8),

    -- Cursos de Análisis de Datos (Categoría 9)
    ('Análisis de Datos con Python', 'Procesamiento y visualización de datos', 9, 9),
    ('Business Intelligence', 'Herramientas de inteligencia de negocios', 9, 9),

    -- Cursos de Arquitectura de Software (Categoría 10)
    ('Patrones de Diseño de Software', 'Arquitecturas escalables y mantenibles', 10, 10),
    ('Microservicios y APIs', 'Diseño de sistemas distribuidos modernos', 10, 10);