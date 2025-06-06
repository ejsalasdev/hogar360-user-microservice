-- Insertar roles básicos (solo si no existen)
INSERT IGNORE INTO roles (name, description)
VALUES ('ADMIN', 'Administrador del sistema con todos los permisos'),
       ('SELLER', 'Vendedor de inmuebles'),
       ('BUYER', 'Comprador de inmuebles');

-- Insertar usuario administrador por defecto (solo si no existe)
-- Password: admin123 (encriptada con BCrypt)
INSERT IGNORE INTO users (document_id, name, last_name, email, phone_number, birth_date, password, rol_id)
SELECT '12345678',
       'Administrador',
       'Sistema',
       'admin@sistema.com',
       '+1234567890',
       '1990-01-01',
       '$2a$10$/eKHQRAMk6FxBP1LiUFiz.eJwSfNYB5t0mrTUNAyG0PnnjQ8.MlZO',
       r.id
FROM roles r
WHERE r.name = 'ADMIN'
  AND NOT EXISTS (SELECT 1 FROM users WHERE email = 'admin@sistema.com');

-- Insertar usuarios sellers para resolver inconsistencia de datos
-- Password para todos: seller123 (encriptada con BCrypt)
-- Seller ID 2
INSERT IGNORE INTO users (id, document_id, name, last_name, email, phone_number, birth_date, password, rol_id)
SELECT 2,
       '87654321',
       'María',
       'González',
       'maria.gonzalez@inmobiliaria.com',
       '+3001234567',
       '1985-03-15',
       '$2a$10$tslF87j6OGQx3NZRZbKDku5J2jsgwNnmmjTgrhytyGhenFIZShbVi',
       r.id
FROM roles r
WHERE r.name = 'SELLER'
  AND NOT EXISTS (SELECT 1 FROM users WHERE id = 2);

-- Seller ID 3  
INSERT IGNORE INTO users (id, document_id, name, last_name, email, phone_number, birth_date, password, rol_id)
SELECT 3,
       '11223344',
       'Carlos',
       'Rodríguez',
       'carlos.rodriguez@inmobiliaria.com',
       '+3009876543',
       '1988-07-22',
       '$2a$10$tslF87j6OGQx3NZRZbKDku5J2jsgwNnmmjTgrhytyGhenFIZShbVi',
       r.id
FROM roles r
WHERE r.name = 'SELLER'
  AND NOT EXISTS (SELECT 1 FROM users WHERE id = 3);

-- Seller ID 4
INSERT IGNORE INTO users (id, document_id, name, last_name, email, phone_number, birth_date, password, rol_id)
SELECT 4,
       '55667788',
       'Ana',
       'Martínez',
       'ana.martinez@inmobiliaria.com',
       '+3005551234',
       '1992-11-08',
       '$2a$10$tslF87j6OGQx3NZRZbKDku5J2jsgwNnmmjTgrhytyGhenFIZShbVi',
       r.id
FROM roles r
WHERE r.name = 'SELLER'
  AND NOT EXISTS (SELECT 1 FROM users WHERE id = 4);

-- Seller ID 5
INSERT IGNORE INTO users (id, document_id, name, last_name, email, phone_number, birth_date, password, rol_id)
SELECT 5,
       '99887766',
       'Luis',
       'Herrera',
       'luis.herrera@inmobiliaria.com',
       '+3007778899',
       '1990-05-30',
       '$2a$10$tslF87j6OGQx3NZRZbKDku5J2jsgwNnmmjTgrhytyGhenFIZShbVi',
       r.id
FROM roles r
WHERE r.name = 'SELLER'
  AND NOT EXISTS (SELECT 1 FROM users WHERE id = 5);