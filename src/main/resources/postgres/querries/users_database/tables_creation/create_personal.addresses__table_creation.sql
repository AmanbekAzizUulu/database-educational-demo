-- Создание таблицы personal.addresses
CREATE TABLE personal.addresses (
    id SERIAL PRIMARY KEY,
    country VARCHAR(100),
    city VARCHAR(100),
    street VARCHAR(200),
    house_number VARCHAR(20),
    apartment_number VARCHAR(20),
    postal_code VARCHAR(20),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
