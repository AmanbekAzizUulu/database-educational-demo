-- Создаем таблицу users, используя созданный тип и внешний ключ на roles
CREATE TABLE flights_management.users (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    login VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(150) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role_id INT NOT NULL,
    gender flights_management.gender_type NOT NULL,
    birth_date DATE NOT NULL,
    CONSTRAINT fk_role FOREIGN KEY (role_id) REFERENCES flights_management.roles(id)
);
