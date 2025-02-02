-- Создание таблицы самолетов
CREATE TABLE flights_management.aircrafts (
    id SERIAL PRIMARY KEY,
    model VARCHAR(50) NOT NULL
);
