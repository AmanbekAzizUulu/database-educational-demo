-- -- Создание таблицы users
CREATE TABLE personal.users (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(100),
    middle_name VARCHAR(100),
    last_name VARCHAR(100),
    address_id INT REFERENCES personal.addresses(id),  -- Связь с таблицей addresses
    contact_info_id INT REFERENCES personal.contact_info(id),  -- Связь с таблицей contact_info
    date_of_birth DATE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    gender VARCHAR(10)  -- Например: 'Male', 'Female', 'Other'
);
