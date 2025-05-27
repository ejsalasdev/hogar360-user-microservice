-- Insertar roles básicos (solo si no existen)
INSERT IGNORE INTO roles (name, description) VALUES 
('ADMIN', 'Administrador del sistema con todos los permisos'),
('SELLER', 'Vendedor de inmuebles'),
('BUYER', 'Comprador de inmuebles');

-- Insertar usuario administrador por defecto (solo si no existe)
-- Password: admin123 (encriptada con BCrypt)
INSERT IGNORE INTO users (documentNnumber, name, lastName, email, phone, birthdate, password, role_id)
SELECT 
    '12345678',
    'Administrador',
    'Sistema', 
    'admin@sistema.com',
    '+1234567890',
    '1990-01-01',
    '$2a$10$N.zmdr9k7uOCQb96VdodL.ZHPvsw5n5YmYW5n4CfPfGpS',
    r.id
FROM roles r 
WHERE r.name = 'ADMIN' 
AND NOT EXISTS (SELECT 1 FROM users WHERE email = 'admin@sistema.com');