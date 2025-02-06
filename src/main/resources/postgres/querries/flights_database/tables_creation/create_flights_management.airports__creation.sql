-- Создание таблицы аэропортов в схеме flight_management
CREATE TABLE flights_management.airports (
    code VARCHAR(10) PRIMARY KEY,
    country VARCHAR(50) NOT NULL,
    city VARCHAR(50) NOT NULL
);
