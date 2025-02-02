-- Создание таблицы билетов
CREATE TABLE flights_management.tickets (
    id SERIAL PRIMARY KEY,
    passport_no VARCHAR(20) NOT NULL,
    passenger_name VARCHAR(100) NOT NULL,
    flight_id INT REFERENCES flights_management.flights(id) ON DELETE CASCADE,
    seat_id INT REFERENCES flights_management.seats(id) ON DELETE CASCADE,
    cost DECIMAL(10,2) NOT NULL,
    UNIQUE (flight_id, seat_id)
);
