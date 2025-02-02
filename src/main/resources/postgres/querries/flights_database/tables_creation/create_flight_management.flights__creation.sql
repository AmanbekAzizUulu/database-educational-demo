-- Создание таблицы рейсов
CREATE TABLE flights_management.flights (
	id SERIAL PRIMARY KEY,
	flight_no VARCHAR(20) NOT NULL,
	departure_date TIMESTAMP NOT NULL,
	departure_airport_code VARCHAR(10) REFERENCES flights_management.airports(code) ON DELETE CASCADE,
	arrival_date TIMESTAMP NOT NULL,
	arrival_airport_code VARCHAR(10) REFERENCES flights_management.airports(code) ON DELETE CASCADE,
	aircraft_id INT REFERENCES flights_management.aircrafts(id) ON DELETE
	SET NULL,
		status VARCHAR(20) CHECK (
			status IN (
				'cancelled',
				'arrived',
				'departed',
				'boarding',
				'scheduled'
			)
		)
);
