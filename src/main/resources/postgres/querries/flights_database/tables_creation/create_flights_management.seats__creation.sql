-- Создание таблицы мест в самолете
CREATE TABLE flights_management.seats (
    id SERIAL PRIMARY KEY,
    aircraft_id INT REFERENCES flights_management.aircrafts(id) ON DELETE CASCADE,
    seat_no VARCHAR(10) NOT NULL,
    UNIQUE (aircraft_id, seat_no)
);
